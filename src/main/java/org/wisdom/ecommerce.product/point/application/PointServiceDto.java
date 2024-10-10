package org.wisdom.ecommerce.product.point.application;

import lombok.Builder;

import java.math.BigDecimal;

public record PointServiceDto(){

    @Builder
    public record Request(long userId, BigDecimal point) {

    }
}