package org.wisdom.ecommerce.user.application;

import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.user.domain.User;

@Repository
public interface UserRepository {

    User getUserBy(long userId);
}
