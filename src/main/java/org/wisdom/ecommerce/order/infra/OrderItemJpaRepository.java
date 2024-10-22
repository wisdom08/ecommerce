package org.wisdom.ecommerce.order.infra;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {

  @Query(value = "select oi.product_id" +
      "from order_item oi " +
      "where oi.created_at >= now() - interval 3 day " +
      "group by oi.product_id " +
      "order by totalquantity desc " +
      "limit 5", nativeQuery = true)
  List<Long> bestItemsForThreeDays();
}
