package com.freecoder.wx.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freecoder.response.result.Result;
import com.freecoder.response.result.ResultStatus;
import com.freecoder.utils.JwtUtils;
import com.freecoder.wx.mapper.CustomerJpaRepository;
import com.freecoder.wx.model.Customer;
import com.freecoder.wx.service.WxAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信登录服务实现
 *
 * @author : LY
 * @version : [v1.0]
 * @createTime : [2023/7/9 10:14]
 */
@Service
public class WxAuthServiceImpl implements WxAuthService {
    @Autowired
    CustomerJpaRepository jpaRepository;

    @Value("${appid}")
    private String appid;
    @Value("${secret}")
    private String secret;
    @Value("${grantType}")
    private String grantType;
    private WebClient webClient = WebClient.create();

    @Override
    public Result login(String jsCode) {
        //拼接参数为链接, 用于从微信获取openid
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=" + grantType;

        // 发送HTTP GET请求并获取响应
        Mono<Result> response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(data -> {
                    try {
                        // 使用 Jackson Object Mapper 解析 JSON 数据
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode jsonNode = mapper.readTree(data);

                        if (jsonNode.has("errcode") && jsonNode.has("errmsg")) {
                            // 第一种情况，包含 errcode 和 errmsg 参数
                            // 即请求失败，返回报错信息
                            int errcode = jsonNode.get("errcode").asInt();
                            String errmsg = jsonNode.get("errmsg").asText();
                            System.out.println("errcode: " + errcode);
                            System.out.println("errmsg: " + errmsg);
                            return Mono.just(Result.failure(ResultStatus.BAD_REQUEST,errmsg));
                        } else if (jsonNode.has("session_key") && jsonNode.has("openid")) {
                            // 获取到了openid 和 session_key
                            String sessionKey = jsonNode.get("session_key").asText();
                            String openId = jsonNode.get("openid").asText();
                            System.out.println("session_key: " + sessionKey);
                            System.out.println("openid: " + openId);

                            if (!jpaRepository.existsByOpenId(openId)){
                                register(new Customer(openId));
                            }

                            Map<String, Object> clamis = new HashMap<>();
                            clamis.put("openid", openId);

                            String jwt = JwtUtils.generateWeChatJwt(clamis);
                            return Mono.just(Result.success(jwt));

                            // 进一步处理其他逻辑...
                        } else {
                            // 其他未知情况或错误处理
                            return Mono.just(Result.failure(ResultStatus.BAD_REQUEST,"Unknown JSON structure"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return Mono.just(Result.failure(ResultStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
                    }
                });
        return response.block();
    }



    @Override
    public Result register(Customer customer) {
        return Result.success( jpaRepository.save(customer));
    }

    @Override
    public Result refreshToken(String code) {
        return null;
    }
}
