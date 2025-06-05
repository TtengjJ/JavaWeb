package com.example.interceptor;


import com.example.utils.JwtUtils;
import com.example.utils.ThreatLocal;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    //拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URI
        String uri = request.getRequestURI();

        // 获取token
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.info("token为空，请求URI：{}", uri);
            // 如果是HTML页面请求，重定向到登录页
            if (uri.endsWith(".html")) {

                response.sendRedirect("/login.html");
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            return false;
        }

        // 验证token
        try {
            //解析令牌
            JwtUtils.parseToken(token);
            //解析当前id，放入ThreatLocal
            Integer useId= JwtUtils.getUserId(token);
            ThreatLocal.setCurrentId(String.valueOf(useId));
        } catch (Exception e) {
            log.info("token验证失败，请求URI：{}", uri);
            if (uri.endsWith(".html")) {
                response.sendRedirect("/login.html");
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
            return false;
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 在请求处理完成后，清除当前线程的id
        ThreatLocal.remove();
    }
}

