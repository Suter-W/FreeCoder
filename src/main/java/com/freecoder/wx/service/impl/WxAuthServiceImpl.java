package com.freecoder.wx.service.impl;

import com.freecoder.web.model.Result;
import com.freecoder.wx.mapper.CustomerJpaRepository;
import com.freecoder.wx.model.Customer;
import com.freecoder.wx.service.WxAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    @Autowired
//    private Environment env;
//    private String appid = env.getProperty("appid");
//    private String secret = env.getProperty("secret");
//    private String grantType = env.getProperty("grantType");
//    private WebClient webClient = WebClient.create();

//    @Override
//    public Result login(String jsCode) {
//        //拼接参数为链接
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=" + grantType;
//
//
//        // 发送HTTP GET请求并获取响应
//        Mono<Result> response = webClient.get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(String.class)
//                .flatMap(data -> {
////                    data="{\"session_key\":\"jmPFaP8JVzZ\\/dpjEZYX2aA==\",\"openid\":\"oGKXV5WO4f96WIORcYvyodGCXxtg\"}";
//                    System.out.println(data);
//                    try {
//                        // 使用 Jackson Object Mapper 解析 JSON 数据
//                        ObjectMapper mapper = new ObjectMapper();
//                        JsonNode jsonNode = mapper.readTree(data);
//
//                        if (jsonNode.has("errcode") && jsonNode.has("errmsg")) {
//                            // 第一种情况，包含 errcode 和 errmsg 参数
//                            int errcode = jsonNode.get("errcode").asInt();
//                            String errmsg = jsonNode.get("errmsg").asText();
//                            System.out.println("errcode: " + errcode);
//                            System.out.println("errmsg: " + errmsg);
//
//                            return Mono.just(Result.error("js_code失效"));
//                            // 进一步处理其他逻辑...
//                        } else if (jsonNode.has("session_key") && jsonNode.has("openid")) {
//                            // 第二种情况，包含 param1 和 param2 参数
//                            String sessionKey = jsonNode.get("session_key").asText();
//                            String openId = jsonNode.get("openid").asText();
//                            System.out.println("session_key: " + sessionKey);
//                            System.out.println("openid: " + openId);
//
//                            Map<String, Object> clamis = new HashMap<>();
//                            clamis.put("openid", openId);
//
//                            String jwt = JwtUtils.generateWeChatJwt(clamis);
//                            return Mono.just(Result.success(jwt));
//
//                            // 进一步处理其他逻辑...
//                        } else {
//                            // 其他未知情况或错误处理
//                            System.out.println("Unknown JSON structure");
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    return Mono.just(Result.error("token有误"));
//                });
//        return response.block();
//    }


    @Override
    public Result login(String jsCode) {
        Customer customer = jpaRepository.save(new Customer(jsCode));
        return Result.success("Id: "+customer.getId()+" openId: "+customer.getOpenId());
    }

    @Override
    public Result insert(Customer customer) {
        return null;
    }
}
