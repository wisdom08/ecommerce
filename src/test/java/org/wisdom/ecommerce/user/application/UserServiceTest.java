package org.wisdom.ecommerce.user.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @InjectMocks
  private UserService service;

  @Mock
  private UserRepository repository;

  @Test
  void userId로_유저를_찾는다() {
    // given
    when(repository.getUserBy(0L)).thenReturn(0L);
    // when
    val result = service.getUserBy(0L);
    // then
    assertThat(result).isEqualTo(0L);
  }

}