package org.wisdom.ecommerce.user.application;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceDto getUserBy(long userId) {
        return UserServiceDto.from(userRepository.getUserBy(userId));
    }
}
