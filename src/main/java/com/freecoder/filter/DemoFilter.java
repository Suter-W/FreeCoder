package com.freecoder.filter;


import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
public class DemoFilter implements Filter {

    //初始化方法，只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("init 初始化方法实现了");
    }


    //拦截到请求之后调用，调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了请求。。。放行前逻辑");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("拦截到了请求。。。放行后逻辑");
    }


    //销毁方法，只调用一次
    @Override
    public void destroy() {
//        Filter.super.destroy();
        System.out.println("destory 销毁方法执行了");
    }
}