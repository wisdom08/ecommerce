package org.wisdom.ecommerce.user.application;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

  Long getUserBy(Long userId);
}
