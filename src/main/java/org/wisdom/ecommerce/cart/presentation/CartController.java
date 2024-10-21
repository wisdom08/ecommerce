package org.wisdom.ecommerce.cart.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.wisdom.ecommerce.cart.application.CartFacade;
import org.wisdom.ecommerce.cart.application.CartServiceDto;
import org.wisdom.ecommerce.common.model.CommonApiResponse;

import java.util.List;

@Tag(name = "[장바구니]")
@RequestMapping("/api/v1/carts")
@RestController
public class CartController {

    private final CartFacade cartFacade;

    public CartController(CartFacade cartFacade) {
        this.cartFacade = cartFacade;
    }


    @Operation(summary = "추가")
    @PatchMapping()
    public CommonApiResponse<Void> addProductToCart(@RequestBody CartApiDto cartRequest) {
        cartFacade.addProductToCart(cartRequest.userId(), cartRequest.productId(), cartRequest.quantity());
        return CommonApiResponse.success(null);
    }


    @Operation(summary = "조회")
    @GetMapping("/{userId}")
    public CommonApiResponse<List<CartApiDto.Response>> getCartBy(@PathVariable(name = "userId") long userId) {
        List<CartServiceDto> carts = cartFacade.getCartBy(userId);
        return CommonApiResponse.success(CartApiDto.Response.of(carts));
    }


    @Operation(summary = "삭제")
    @DeleteMapping
    public CommonApiResponse<Void> removeProductFromCart(@RequestBody CartApiDto cartRequest) {
        cartFacade.removeProductFromCart(cartRequest.userId(), cartRequest.productId());
        return CommonApiResponse.success(null);
    }
}
