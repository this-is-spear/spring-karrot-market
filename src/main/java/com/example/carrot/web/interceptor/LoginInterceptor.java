package com.example.carrot.web.interceptor;

import com.example.carrot.web.filter.CheckThreadLog;
import com.example.carrot.web.session.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.debug("[{}][{}] 인증 체크 인터셉터 실행", MDC.get(CheckThreadLog.LOG_ID), requestURI);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(SessionConst.LOGIN_SESSION) == null) {
            log.debug("[{}][{}] 미인증 사용자 요청", MDC.get(CheckThreadLog.LOG_ID), requestURI);
            response.sendRedirect("/login?redirectURL=" + requestURI);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("[{}][{}] postHandle", MDC.get(CheckThreadLog.LOG_ID), modelAndView);
    }

}
