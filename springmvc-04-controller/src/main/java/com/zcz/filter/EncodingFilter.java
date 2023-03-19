package com.zcz.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description: 编码过滤器
 * @ClassName: EncodingFilter
 * @Author: ZCZ
 * @Date 2023年03月19日 16:30
 **/
public class EncodingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
