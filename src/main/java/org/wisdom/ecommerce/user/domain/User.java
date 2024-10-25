package org.wisdom.ecommerce.user.domain;

import lombok.Builder;

@Builder
public record User(Long userId, String email) {

}
