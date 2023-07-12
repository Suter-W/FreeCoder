package com.freecoder.web.controller;

import com.freecoder.response.MyResult;
import com.freecoder.utils.JwtUtils;
//import com.freecoder.utils.JwtWeChatUtils;
import jakarta.annotation.security.PermitAll;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WeChatAuthController
 * @Description 微信登录
 * @DATE 2023/7/7 9:52
 */

@RestController
@CrossOrigin
@PermitAll
@RequestMapping("/wxapp")
public class WeChatAuthController {


    Environment env = new StandardEnvironment();
//
//    private String appid = env.getProperty("weChat_appid");
//
//    private String secret = env.getProperty("weChat_secret");
//
//    private String grantType = env.getProperty("grantType");

    private WebClient webClient = WebClient.create();

    @GetMapping("/wechatLogin")
    public MyResult getJsCode(@RequestParam String jsCode){
        String appid = "wx2c83501229e9d8ed";
        String secret = "bc57fe0a79c8782a34c2cf9c368d9be7";
        String grantType = "authorization_code";

        //拼接参数为链接
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+jsCode+"&grant_type="+grantType;


        // 发送HTTP GET请求并获取响应
        Mono<MyResult> response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(data -> {
//                    data="{\"session_key\":\"jmPFaP8JVzZ\\/dpjEZYX2aA==\",\"openid\":\"oGKXV5WO4f96WIORcYvyodGCXxtg\"}";
                    System.out.println(data);
                    try {
                        // 使用 Jackson Object Mapper 解析 JSON 数据
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode jsonNode = mapper.readTree(data);

                        if (jsonNode.has("errcode") && jsonNode.has("errmsg")) {
                            // 第一种情况，包含 errcode 和 errmsg 参数
                            int errcode = jsonNode.get("errcode").asInt();
                            String errmsg = jsonNode.get("errmsg").asText();
                            System.out.println("errcode: " + errcode);
                            System.out.println("errmsg: " + errmsg);

                            return Mono.just(com.freecoder.response.MyResult.error("error","js_code失效"));
                            // 进一步处理其他逻辑...
                        } else if (jsonNode.has("session_key") && jsonNode.has("openid")) {
                            // 第二种情况，包含 param1 和 param2 参数
                            String sessionKey = jsonNode.get("session_key").asText();
                            String openId = jsonNode.get("openid").asText();
                            System.out.println("session_key: " + sessionKey);
                            System.out.println("openid: " + openId);

                            Map<String, Object> clamis = new HashMap<>();
                            clamis.put("openid",openId);

                            String jwt = JwtUtils.generateWeChatJwt(clamis);
                            return Mono.just(com.freecoder.response.MyResult.success(jwt));

                            // 进一步处理其他逻辑...
                        } else {
                            // 其他未知情况或错误处理
                            System.out.println("Unknown JSON structure");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return Mono.just(MyResult.error("error","token有误"));
                });
        return response.block();
    }

}
