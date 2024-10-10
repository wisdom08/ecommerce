package org.wisdom.ecommerce.cart.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.wisdom.ecommerce.cart.application.CartService;
import org.wisdom.ecommerce.common.model.CommonApiResponse;

import java.util.List;

@Tag(name = "장바구니")
@RequestMapping("/api/v1/carts")
@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @Operation(summary = "추가")
    @PatchMapping("/{productId}")
    public CommonApiResponse<List<CartApiDto.Response>> addCarts(@PathVariable(name = "productId") long productId) {
        return CommonApiResponse.success(cartService.addCarts(productId));
    }


    @Operation(summary = "조회")
    @GetMapping("/{userId}")
    public CommonApiResponse<List<CartApiDto.Response>> getCartsBy(@PathVariable(name = "userId") long userId) {
        return CommonApiResponse.success(cartService.getCartsBy(userId));
    }


    @Operation(summary = "삭제")
    @DeleteMapping
    public CommonApiResponse<List<CartApiDto.Response>> removeProductInCarts(@RequestBody CartApiDto.Request cartRequest) {
        return CommonApiResponse.success(cartService.removeProductInCarts(cartRequest.toCartServiceDto()));
    }

}