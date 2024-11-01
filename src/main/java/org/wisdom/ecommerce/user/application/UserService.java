package org.wisdom.ecommerce.user.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional(readOnly = true)
  public Long getUserBy(Long userId) {
    return userRepository.getUserBy(userId);
  }
}
