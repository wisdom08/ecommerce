package org.wisdom.ecommerce.common.filter;

import lombok.val;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebConfig {

  @Bean
  public FilterRegistrationBean logFilter() {
    val filterFilterRegistrationBean = new FilterRegistrationBean<>();
    filterFilterRegistrationBean.setFilter(new LogFilter());
    filterFilterRegistrationBean.setOrder(1);
    filterFilterRegistrationBean.addUrlPatterns("/api/v1/*");
    return filterFilterRegistrationBean;
  }
}
