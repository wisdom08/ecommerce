package org.wisdom.ecommerce.order.infra;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {

  @Query(value = "SELECT oi.product_id " +
      "FROM order_item oi " +
      "WHERE oi.created_at >= NOW() - INTERVAL 3 DAY " +
      "GROUP BY oi.product_id " +
      "ORDER BY COUNT(oi.product_id) DESC " +
      "LIMIT 5", nativeQuery = true)
  List<Long> bestItemsForThreeDays();
}
