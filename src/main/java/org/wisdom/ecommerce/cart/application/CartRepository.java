package org.wisdom.ecommerce.cart.application;

import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository {
    long getCartBy(long userId);
}
