package org.wisdom.ecommerce.common.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Getter
public class CommonApiResponse<T> extends ResponseEntity<T> {

    private final T data;

    public CommonApiResponse(HttpStatusCode status, T data) {
        super(data, status);
        this.data = data;
    }

    public static <T> CommonApiResponse<T> success(T data) {
        return new CommonApiResponse<>(HttpStatus.OK, data);
    }

    public static CommonApiResponse<ErrorResponse> error(HttpStatusCode status, String errorMessage) {
        return new CommonApiResponse<>(status, new ErrorResponse(errorMessage));
    }
}
