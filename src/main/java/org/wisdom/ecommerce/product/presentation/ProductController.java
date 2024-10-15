package org.wisdom.ecommerce.product.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.wisdom.ecommerce.common.model.CommonApiResponse;
import org.wisdom.ecommerce.product.application.ProductService;
import org.wisdom.ecommerce.product.presentation.ProductApiDto.Response;

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
    public CommonApiResponse<Response> getProductBy(@PathVariable(name = "productId") long productId) {
        return CommonApiResponse.success(Response.from(productService.getProductBy(productId)));
    }

    @Operation(summary = "인기 상품 조회")
    @GetMapping("/best")
    public CommonApiResponse<List<Response>> getBestOfProducts() {
        return CommonApiResponse.success(productService.getBestOfProducts());
    }
}
