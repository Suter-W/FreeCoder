package com.freecoder.filter;

import com.alibaba.fastjson.JSONObject;
import com.freecoder.response.MyResult;
import com.freecoder.response.result.Result;
import com.freecoder.response.result.ResultStatus;
import com.freecoder.utils.JwtUtils;

import jakarta.annotation.security.PermitAll;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;


@Slf4j
@WebFilter("/*")
@CrossOrigin
@PermitAll
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        // 1. 获取请求url
        String url = req.getRequestURL().toString();
        log.info("请求的url：{}", url);

        // 2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if (url.contains("/login")) {
            log.info("登录操作，放行。。。");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 3. 获取请求方法
        String method = req.getMethod();

        // 4. 判断是否为OPTIONS方法，如果是直接放行
        if ("OPTIONS".equals(method)) {
            log.info("预检请求，放行。。。");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 5. 获取请求头中的令牌（token）
        String token = req.getHeader("Authorization");
        System.out.println(token);

        // 6. 判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if (!StringUtils.hasLength(token) || !token.startsWith("Bearer ")) {
            log.info("请求头token为空，返回未登录的信息");
            MyResult error;
            if (!url.contains("/wxapp/")) {
//                error = MyResult.error("NOT_LOGIN", "redirect:http://localhost:8080/web/login");
//                res.getWriter().write("HTTP/1.1 302 Found\nLocation: http://localhost:8080/web/login");
                res.sendRedirect("http://localhost:8080/web/login");
                return;
            } else {
                error = com.freecoder.response.MyResult.error("NOT_LOGIN");
                String notLogin = JSONObject.toJSONString(error);
                res.setContentType("application/json;charset=UTF-8");
                res.getWriter().write(notLogin);
                return;
            }

        }

        // 7. 提取令牌
        token = token.substring(7);

        // 8. 判断url是否以web开头，如果不是，返回错误结果
        if (!(url.contains("/web/") || url.contains("/wxapp/"))) {
//            MyResult error = MyResult.error("Not Found");
            Result result = Result.failure(ResultStatus.NOT_FOUND);
            String notLogin = JSONObject.toJSONString(result);
            res.setContentType("application/json;charset=UTF-8");
            res.getWriter().write(notLogin);
            return;
        }
        // 9. 对应路径解析token，如果解析失败，返回错误结果（未登录）
        try {
            if (url.contains("/web/")) {
                JwtUtils.parseWebJWT(token);
            }else if (url.contains("/wxapp/")){
                JwtUtils.parseWeChatJWT(token);
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录的信息");
            Result result = Result.failure(ResultStatus.INVALID_TOKEN);
            String notLogin = JSONObject.toJSONString(result);
            res.setContentType("application/json;charset=UTF-8");
            res.getWriter().write(notLogin);
            return;
        }

        // 10. 放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}