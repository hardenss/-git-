package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(filterName = "FilterDemo01", urlPatterns = { "/*" })
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 进行逻辑处理

        System.out.println("in doFilter");
        // 一定要记得这个,逻辑处理完之后,调用过滤器链,去进入到下一个过滤器
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
