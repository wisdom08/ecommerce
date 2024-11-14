package org.wisdom.ecommerce.cart.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.val;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wisdom.ecommerce.cart.application.CartFacade;
import org.wisdom.ecommerce.common.model.CommonApiResponse;

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
  public CommonApiResponse<Void> addProductToCart(@RequestBody CartApiAddRequest request) {
    cartFacade.addProductToCart(request.userId(), request.productId(), request.quantity());
    return CommonApiResponse.success(null);
  }


  @Operation(summary = "조회")
  @GetMapping("/{userId}")
  public CommonApiResponse<Page<CartApiResponse>> getCartBy(@PathVariable(name = "userId") Long userId,
      @RequestParam int page, @RequestParam int size) {
    val carts = cartFacade.getCartBy(userId, page, size);
    return CommonApiResponse.success(carts.map(CartApiResponse::of));
  }


  @Operation(summary = "삭제")
  @DeleteMapping
  public CommonApiResponse<Void> removeProductFromCart(@RequestBody CartApiDeleteRequest request) {
    cartFacade.removeProductFromCart(request.userId(), request.cartId());
    return CommonApiResponse.success(null);
  }
}
