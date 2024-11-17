package org.wisdom.ecommerce.order.application;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Component
public class DataPlatformListener {

  @Async
  @EventListener
  public void handleOrderPlacedEvent(OrderPlacedEvent event) {
    // 데이터 플랫폼에 주문 전송
    val order = event.order();
    log.info("Sending order to data platform: {}", order);
    log.info("TransactionSynchronizationManager.getCurrentTransactionName(), {}",TransactionSynchronizationManager.getCurrentTransactionName());
    log.info("TransactionSynchronizationManager.isActualTransactionActive(): {}", TransactionSynchronizationManager.isActualTransactionActive());
    log.info("Current Thread Name: {}", Thread.currentThread().getName());
    // 실제 전송 로직
  }
}