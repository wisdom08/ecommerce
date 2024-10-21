package org.wisdom.ecommerce.cart.infra;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.wisdom.ecommerce.cart.domain.CartItem;

@Builder
@Getter
@Table(name = "cart_item")
@Entity
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long cartId;
    private long productId;
    private int quantity;

    public CartItemEntity() {

    }

    public CartItemEntity(long id, long cartId, long productId, int quantity) {
        this.id = id;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartItem toDomain() {
        return CartItem.builder()
                .id(id)
                .cartId(cartId)
                .productId(productId)
                .quantity(quantity)
                .build();
    }

    public static CartItemEntity of(long userId, long productId, int quantity) {
        return CartItemEntity.builder()
                .cartId(userId)
                .productId(productId)
                .quantity(quantity)
                .build();
    }
}
