package com.freecoder.wx.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freecoder.response.result.Result;
import com.freecoder.response.result.ResultStatus;
import com.freecoder.utils.JwtUtils;
import com.freecoder.wx.mapper.CustomerJpaRepository;
import com.freecoder.wx.mapper.EmployeeJpaRepository;
import com.freecoder.wx.model.Customer;
import com.freecoder.wx.model.Employee;
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
    CustomerJpaRepository customerRepository;

    @Autowired
    EmployeeJpaRepository employeeRepository;

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
                            return Mono.just(Result.failure(ResultStatus.BAD_REQUEST, errmsg));
                        } else if (jsonNode.has("session_key") && jsonNode.has("openid")) {
                            // 获取到了openid 和 session_key
                            String sessionKey = jsonNode.get("session_key").asText();
                            String openId = jsonNode.get("openid").asText();
                            System.out.println("session_key: " + sessionKey);
                            System.out.println("openid: " + openId);

                            if (!customerRepository.existsByOpenId(openId)) {
                                register(
                                        new Customer(openId, sessionKey,
                                                "微信用户",
                                                "https://img0.baidu.com/it/u=3070762535,1739046062&fm=253&fmt=auto&app=138&f=JPEG?w=222&h=220",
                                                false));
                            }

                            Customer customer = customerRepository.findByOpenId(openId).get();

                            Map<String, Object> clamis = new HashMap<>();
                            clamis.put("id", customer.getId());
                            String jwt = JwtUtils.generateWeChatJwt(clamis);
                            System.out.println("token:" + jwt);
                            HashMap<String, Object> map = new HashMap();
                            map.put("token", jwt);
                            map.put("customer", customer);
                            return Mono.just(Result.success(map));

                            // 进一步处理其他逻辑...
                        } else {
                            // 其他未知情况或错误处理
                            return Mono.just(Result.failure(ResultStatus.BAD_REQUEST, "Unknown JSON structure"));
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
        return Result.success(customerRepository.save(customer));
    }

    @Override
    public Result employeeLogin(String jsCode) {
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
                            return Mono.just(Result.failure(ResultStatus.BAD_REQUEST, errmsg));
                        } else if (jsonNode.has("session_key") && jsonNode.has("openid")) {
                            // 获取到了openid 和 session_key
                            String sessionKey = jsonNode.get("session_key").asText();
                            String openId = jsonNode.get("openid").asText();
                            System.out.println("session_key: " + sessionKey);
                            System.out.println("openid: " + openId);

                            if (!employeeRepository.existsByOpenId(openId)) {
                                register(new Employee(openId, sessionKey, "餐厅员工",
                                        "https://img0.baidu.com/it/u=3070762535,1739046062&fm=253&fmt=auto&app=138&f=JPEG?w=222&h=220",
                                        null, null, null));
                            }

                            Employee employee = employeeRepository.findByOpenId(openId);

                            Map<String, Object> clamis = new HashMap<>();
                            clamis.put("id", employee.getId());
                            String jwt = JwtUtils.generateWeChatJwt(clamis);
                            System.out.println("token:" + jwt);
                            HashMap<String, Object> map = new HashMap();
                            map.put("token", jwt);
                            map.put("employee", employee);
                            return Mono.just(Result.success(map));

                            // 进一步处理其他逻辑...
                        } else {
                            // 其他未知情况或错误处理
                            return Mono.just(Result.failure(ResultStatus.BAD_REQUEST, "Unknown JSON structure"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return Mono.just(Result.failure(ResultStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
                    }
                });
        return response.block();
    }

    @Override
    public Result register(Employee employee) {
        return Result.success(employeeRepository.save(employee));
    }

    @Override
    public Result refreshToken(String code) {
        return null;
    }
}
