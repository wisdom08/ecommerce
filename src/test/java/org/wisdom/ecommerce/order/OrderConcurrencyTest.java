package org.wisdom.ecommerce.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.jdbc.Sql;
import org.wisdom.ecommerce.order.application.OrderFacade;

@Sql(scripts = "classpath:truncate.sql")
@SpringBootTest
public class OrderConcurrencyTest {

  @Autowired
  private OrderFacade facade;

  @Test
  void 주문_동시성_테스트_50명_1개씩_동시요청_했는데_재고가_10개여서_40명_실패() throws InterruptedException, ExecutionException {

    List<CompletableFuture<Boolean>> tasks = new ArrayList<>();
    List<Long> exceptionCount = new ArrayList<>();

    for (long i = 1; i <= 50; i++) {
      val userId = i;
      tasks.add(CompletableFuture.supplyAsync(() -> {
        facade.place(userId, 1L, 1);
        return true;
      }).exceptionally(ex -> {
        exceptionCount.add(userId);
        return false;
      }));
    }

    CompletableFuture<Void> allTasks = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
    allTasks.join();

    long successCount = 0;
    long failureCount = 0;

    for (CompletableFuture<Boolean> task : tasks) {
      if (task.get()) {
        successCount++;
      } else {
        failureCount++;
      }
    }

    assertThat(successCount).isEqualTo(10);
    assertThat(failureCount).isEqualTo(40);
    assertThat(exceptionCount).hasSize(40);
  }

  @Test
  void 동일한_유저가_주문을_10번_신청시_첫번째는_성공_나머지는_잔고_부족으로_예외_발생() {
    val userId = 2L;

    assertThatNoException().isThrownBy(() -> facade.place(userId, 2L, 1));

    for (int i = 0; i < 9; i++) {
      assertThatThrownBy(() -> facade.place(userId, 2L, 1))
          .isInstanceOf(InvalidDataAccessApiUsageException.class)
          .hasMessageContaining("잔고가 부족합니다.");
    }
  }
}