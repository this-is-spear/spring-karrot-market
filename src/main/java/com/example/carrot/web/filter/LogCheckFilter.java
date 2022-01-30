package com.example.carrot.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.LogRecord;

@Slf4j
public class LogCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("log filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        MDC.put(CheckThreadLog.LOG_ID, UUID.randomUUID().toString());
        try {
            log.debug("[{}][{}] REQUEST", MDC.get(CheckThreadLog.LOG_ID), requestURI);
            chain.doFilter(request, response);
        } catch (Exception e) {
            throw e;
        } finally {
          log.debug("[{}][{}] RESPONSE ",  MDC.get(CheckThreadLog.LOG_ID), requestURI);
        }
    }

    @Override
    public void destroy() {
        log.debug("log filter destroy");
    }
}
