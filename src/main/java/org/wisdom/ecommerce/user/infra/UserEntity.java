package org.wisdom.ecommerce.user.infra;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.wisdom.ecommerce.config.BaseTimeEntity;
import org.wisdom.ecommerce.user.domain.User;

@Getter
@Table(name = "user")
@Entity
public class UserEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String email;

  public User toDomain() {
    return User.builder()
        .userId(id)
        .email(email)
        .build();
  }
}
