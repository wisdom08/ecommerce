package org.wisdom.ecommerce.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class LogFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) {
    log.info("[LogFilter] init");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    val httpRequest = (HttpServletRequest) servletRequest;
    val requestURI = httpRequest.getRequestURI();
    log.info("[LogFilter] Request URI: {}", requestURI);
    filterChain.doFilter(httpRequest, servletResponse);
  }

  @Override
  public void destroy() {
    log.info("[LogFilter] destroy");
  }
}
