package org.wisdom.ecommerce.order.infra;

import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.order.domain.Order;

@Component
public class DataPlatform {

  public boolean send(Order order) {
    return true;
  }
}
