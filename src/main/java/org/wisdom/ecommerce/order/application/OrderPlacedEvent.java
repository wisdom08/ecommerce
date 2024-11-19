package org.wisdom.ecommerce.order.application;

import org.wisdom.ecommerce.order.domain.Order;

public record OrderPlacedEvent(Order order) {

}
