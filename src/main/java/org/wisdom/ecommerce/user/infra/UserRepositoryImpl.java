package org.wisdom.ecommerce.user.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.wisdom.ecommerce.user.application.UserRepository;
import org.wisdom.ecommerce.user.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository repository;

    public UserRepositoryImpl(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public User getUserBy(long userId) {
        return repository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException(userId + "의 유저가 없습니다"))
            .toDomain()
            ;
    }
}
