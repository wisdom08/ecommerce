package org.wisdom.ecommerce.product.point.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.wisdom.ecommerce.common.model.CommonApiResponse;
import org.wisdom.ecommerce.product.point.application.PointService;

@Tag(name = "포인트")
@RequestMapping("/api/v1/points")
@RestController
public class PointController {

    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @Operation(summary = "충전")
    @PatchMapping
    public CommonApiResponse<PointApiDto.Response> charge(@RequestBody PointApiDto.Request chargeRequest) {
        return CommonApiResponse.success(pointService.chargePoints(chargeRequest.toPointServiceDto()));
    }


    @Operation(summary = "조회")
    @GetMapping("/{userId}")
    public CommonApiResponse<PointApiDto.Response> getPointsBy(@PathVariable(name = "userId") long userId) {
        return CommonApiResponse.success(pointService.getPointsBy(userId));
    }
}
