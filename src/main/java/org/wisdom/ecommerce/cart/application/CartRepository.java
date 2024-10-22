package org.wisdom.ecommerce.cart.application;

import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository {

  Long getCartBy(Long userId);
}
