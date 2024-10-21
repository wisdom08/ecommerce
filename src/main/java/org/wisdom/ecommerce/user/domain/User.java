package org.wisdom.ecommerce.user.domain;

import lombok.Builder;

@Builder
public record User(long userId, String email) {

}
