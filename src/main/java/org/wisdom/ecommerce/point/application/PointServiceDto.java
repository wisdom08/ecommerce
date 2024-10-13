package org.wisdom.ecommerce.point.application;

import lombok.Builder;

import java.math.BigDecimal;

public record PointServiceDto(){

    @Builder
    public record Request(long userId, BigDecimal point) {

    }
}