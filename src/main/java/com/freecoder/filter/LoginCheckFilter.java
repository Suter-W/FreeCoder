package com.freecoder.filter;

import com.alibaba.fastjson.JSONObject;
import com.freecoder.pojo.Result;
import com.freecoder.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter("/*")
public class LoginCheckFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        //1.获取请求url
        String url = req.getRequestURL().toString();
        log.info("请求的url：{}",url);

        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if(url.contains("login")){
            log.info("登录操作，放行。。。");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //3.获取请求头中的令牌（token）
        String jwt = req.getHeader("Authorization");
        System.out.println(jwt);
        jwt = jwt.substring(7);

        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象-->json -------->阿里巴巴的fastJSON
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return;
        }

        //5.解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { //jwt解析失败
//            throw new RuntimeException(e);
            e.printStackTrace();
            log.info("解析令牌失败，返回未登陆的信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象-->json -------->阿里巴巴的fastJSON
            String notLogin = JSONObject.toJSONString(error);
            res.getWriter().write(notLogin);
            return;
        }

        //6.放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
