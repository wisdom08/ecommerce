package org.wisdom.ecommerce.product.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wisdom.ecommerce.common.model.CommonApiResponse;
import org.wisdom.ecommerce.product.application.ProductFacade;

@Tag(name = "상품")
@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

  private final ProductFacade productFacade;

  public ProductController(ProductFacade productFacade) {
    this.productFacade = productFacade;
  }


  @Operation(summary = "조회")
  @GetMapping("/{productId}")
  public CommonApiResponse<ProductApiDto> getProductBy(
      @PathVariable(name = "productId") long productId) {
    return CommonApiResponse.success(ProductApiDto.from(productFacade.getProductBy(productId)));
  }

  @Operation(summary = "인기 상품 조회")
  @GetMapping("/best")
  public CommonApiResponse<List<Long>> getBestOfProducts() {
    return CommonApiResponse.success(productFacade.getBestOfProducts());
  }
}
