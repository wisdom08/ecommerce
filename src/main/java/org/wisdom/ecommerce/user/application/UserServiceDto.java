package org.wisdom.ecommerce.user.application;


import lombok.Builder;
import org.wisdom.ecommerce.user.domain.User;

@Builder
public record UserServiceDto(long userId, String email) {

  public static UserServiceDto from(User user) {
    return UserServiceDto.builder().userId(user.userId()).build();
  }
}
