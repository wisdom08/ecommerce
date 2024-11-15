package org.wisdom.ecommerce.order.application;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class OrderInfoHandler {

  @Async
  @EventListener
  public void sendOrderInfo(RegisteredEvent event) throws InterruptedException {
    Thread.sleep(2000);
    log.info("event: {}", event, "send orderInfo");
  }
}
