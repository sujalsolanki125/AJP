package com.mycompany.carbonwebservlet;

import java.io.IOException;
import javax.servlet.*;

public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("Request received at: " + new java.util.Date());

        chain.doFilter(request, response);
    }
}