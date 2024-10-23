package org.wisdom.ecommerce.wallet.infra;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

  public static final int SC_TOO_MANY_REQUESTS = 429;
  private static final int MAX_REQUESTS_PER_MINUTE = 1;
  private Map<Long, Long> userRequestCount = new ConcurrentHashMap<>();

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    val userIdHeader = request.getParameter("userId");
    if (userIdHeader == null) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getWriter().write("userId header is missing");
      return false;
    }
    val userId = Long.parseLong(userIdHeader);
    val requestCount = userRequestCount.getOrDefault(userId, 0L);
    if (requestCount > MAX_REQUESTS_PER_MINUTE) {
      response.setStatus(SC_TOO_MANY_REQUESTS);
      response.getWriter().write("Too many requests. Try again later.");
      return false;
    }
    userRequestCount.put(userId, requestCount + 1);
    scheduleReset(userId);
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }

  private void scheduleReset(Long userId) {
    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        userRequestCount.put(userId, 0L);
      }
    }, 60000);
  }
}
