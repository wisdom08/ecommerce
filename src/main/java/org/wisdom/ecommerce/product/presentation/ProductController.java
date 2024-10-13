package org.wisdom.ecommerce.product.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.wisdom.ecommerce.common.model.CommonApiResponse;
import org.wisdom.ecommerce.product.application.ProductService;

import java.util.List;

@Tag(name = "상품")
@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "조회")
    @GetMapping("/{productId}")
    public CommonApiResponse<ProductApiDto.Response> getProductBy(@PathVariable(name = "productId") long productId) {
        return CommonApiResponse.success(productService.getProductBy(productId));
    }

    @Operation(summary = "인기 상품 조회")
    @GetMapping("/best")
    public CommonApiResponse<List<ProductApiDto.Response>> getBestOfProducts() {
        return CommonApiResponse.success(productService.getBestOfProducts());
    }
}
