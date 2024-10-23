package org.wisdom.ecommerce.common.filter;

import lombok.val;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.wisdom.ecommerce.wallet.infra.RateLimitInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final RateLimitInterceptor rateLimitInterceptor;

  public WebConfig(RateLimitInterceptor rateLimitInterceptor) {
    this.rateLimitInterceptor = rateLimitInterceptor;
  }

  @Bean
  public FilterRegistrationBean logFilter() {
    val filterFilterRegistrationBean = new FilterRegistrationBean<>();
    filterFilterRegistrationBean.setFilter(new LogFilter());
    filterFilterRegistrationBean.setOrder(1);
    filterFilterRegistrationBean.addUrlPatterns("/api/v1/*");
    return filterFilterRegistrationBean;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(rateLimitInterceptor).addPathPatterns("/api/v1/wallet/**");
  }
}
