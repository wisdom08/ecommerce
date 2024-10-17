package org.wisdom.ecommerce.cart.application;

import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public long getCartsBy(long userId) {
        return cartRepository.getCartBy(userId);
    }

//    public List<CartApiDto.Response> removeProductInCarts(CartServiceDto.Request cartServiceDtoRequest) {
//        List<CartApiDto.Response> carts = List.of(
//            CartApiDto.Response.builder()
//                .userId(cartServiceDtoRequest.userId())
//                .cartId(1)
//                .quantity(1)
//                .productId(1)
//                .productName("MOCK_PRODUCT_NAME_1")
//                .build(),
//
//            CartApiDto.Response.builder()
//                .userId(cartServiceDtoRequest.userId())
//                .cartId(2)
//                .quantity(2)
//                .productId(2)
//                .productName("MOCK_PRODUCT_NAME_2")
//                .build()
//        );
//
//        return carts.stream().filter(i -> i.cartId() != cartServiceDtoRequest.cartId()).toList();
//    }
//
//    public List<CartApiDto.Response> addCarts(long productId) {
//
//        List<CartApiDto.Response> carts = List.of(
//            CartApiDto.Response.builder()
//                .userId(1)
//                .cartId(1)
//                .quantity(1)
//                .productId(1)
//                .productName("MOCK_PRODUCT_NAME_1")
//                .build(),
//
//            CartApiDto.Response.builder()
//                .userId(2)
//                .cartId(2)
//                .quantity(2)
//                .productId(2)
//                .productName("MOCK_PRODUCT_NAME_2")
//                .build()
//        );
//
//        CartApiDto.Response addedCart = CartApiDto.Response.builder()
//            .userId(3)
//            .cartId(3)
//            .quantity(3)
//            .productId(productId)
//            .productName("MOCK_PRODUCT_NAME_3")
//            .build();
//
//        return Stream.concat(carts.stream(), Stream.of(addedCart)).toList();
//    }

}
