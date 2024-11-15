package org.wisdom.ecommerce.order.infra;

import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class EventListener {

  private final DataPlatform dataPlatform;

  public EventListener(DataPlatform dataPlatform) {
    this.dataPlatform = dataPlatform;
  }

  @Async
  @TransactionalEventListener(phase = AFTER_COMMIT)
  public void sendOrderInfo(Long orderId) {
    try {
      log.info("Attempting to send order info for orderId: {}", orderId);
      dataPlatform.send(orderId);
      log.info("Successfully sent order info for orderId: {}", orderId);
    } catch (Exception e) {
      log.error("Error sending order info for orderId: {}", orderId, e);
      throw new RuntimeException("Failed to send order info", e);
    }
  }
}
