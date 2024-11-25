package org.wisdom.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EcommerceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EcommerceApplication.class, args);
  }
}
