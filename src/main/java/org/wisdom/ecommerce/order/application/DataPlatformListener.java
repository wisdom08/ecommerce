package org.wisdom.ecommerce.order.application;

import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import org.wisdom.ecommerce.order.infra.DataPlatform;

@Slf4j
@Component
public class DataPlatformListener {

  private final DataPlatform dataPlatform;

  public DataPlatformListener(DataPlatform dataPlatform) {
    this.dataPlatform = dataPlatform;
  }

  @Async
  @TransactionalEventListener(phase = AFTER_COMMIT)
  public void handleOrderPlacedEvent(OrderPlacedEvent event) {
    val order = event.order();
    log.info("Sending order to data platform: {}", order);
    // 데이터 플랫폼에 주문 전송
    dataPlatform.send(order);
  }
}