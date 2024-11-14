package org.wisdom.ecommerce.order.infra;

import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EventListener {

  private final DataPlatform dataPlatform;

  public EventListener(DataPlatform dataPlatform) {
    this.dataPlatform = dataPlatform;
  }

  @Async
  @TransactionalEventListener(phase = AFTER_COMMIT)
  public void sendOrderInfo(Long orderId) {
    dataPlatform.send(orderId);
  }
}
