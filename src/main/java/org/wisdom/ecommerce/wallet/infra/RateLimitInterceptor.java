package org.wisdom.ecommerce.wallet.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.wisdom.ecommerce.wallet.presentation.WalletApiRequest;

@Slf4j
@Component
public class RateLimitInterceptor implements HandlerInterceptor {

  public static final int SC_TOO_MANY_REQUESTS = 429;
  private static final int MAX_REQUESTS_PER_MINUTE = 1;
  private Map<Long, Long> userRequestCount = new ConcurrentHashMap<>();

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    val userId = getUserIdFromJson(getRequestJsonBody(request));
    if (userId == null) {
      log.warn("[RateLimitInterceptor] Request with missing userId: body={}, IP={}", getRequestJsonBody(request),
          request.getRemoteAddr());
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write("[RateLimitInterceptor] userId가 null입니다");
      log.warn("[RateLimitInterceptor] userId가 null입니다");
      response.getWriter().flush();
      response.getWriter().close();
      return false;
    }
    val requestCount = userRequestCount.getOrDefault(userId, 0L);
    if (requestCount > MAX_REQUESTS_PER_MINUTE) {
      response.setStatus(SC_TOO_MANY_REQUESTS);
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write("[RateLimitInterceptor] 1분 동안 최대 1번까지 요청할 수 있습니다, 잠시후 다시 시도해주세요");
      log.warn("[RateLimitInterceptor] 1분 동안 최대 1번까지 요청할 수 있습니다, 잠시후 다시 시도해주세요");
      response.getWriter().flush();
      response.getWriter().close();
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

  private String getRequestJsonBody(HttpServletRequest request) throws IOException {
    val stringBuilder = new StringBuilder();
    val reader = request.getReader();
    String line;
    while ((line = reader.readLine()) != null) {
      stringBuilder.append(line);
    }
    return stringBuilder.toString();
  }

  private Long getUserIdFromJson(String requestJsonBody) {
    try {
      val objectMapper = new ObjectMapper();
      val request = objectMapper.readValue(requestJsonBody, WalletApiRequest.class);
      return request.userId();
    } catch (Exception e) {
      log.error("[RateLimitInterceptor]:" + e.getMessage());
    }
    return null;
  }
}
