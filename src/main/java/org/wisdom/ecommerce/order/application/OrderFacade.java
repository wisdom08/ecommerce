package org.wisdom.ecommerce.order.application;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.wisdom.ecommerce.product.application.ProductService;
import org.wisdom.ecommerce.user.application.UserService;
import org.wisdom.ecommerce.wallet.application.TransactionService;
import org.wisdom.ecommerce.wallet.application.WalletService;
import org.wisdom.ecommerce.wallet.infra.TransactionType;

@Slf4j
@Component
public class OrderFacade {

  private final UserService userService;
  private final WalletService walletService;
  private final ProductService productService;
  private final OrderService orderService;
  private final OrderItemService orderItemService;
  private final TransactionService transactionService;
  private final ApplicationEventPublisher applicationEventPublisher;

  public OrderFacade(UserService userService, WalletService walletService, ProductService productService,
      OrderService orderService, OrderItemService orderItemService, TransactionService transactionService,
      ApplicationEventPublisher applicationEventPublisher) {
    this.userService = userService;
    this.walletService = walletService;
    this.productService = productService;
    this.orderService = orderService;
    this.orderItemService = orderItemService;
    this.transactionService = transactionService;
    this.applicationEventPublisher = applicationEventPublisher;
  }


  @Transactional
  public void place(Long userId, Long productId, Integer quantity) {
    userService.getUserBy(userId);
    val wallet = walletService.getWalletBy(userId);
    val product = productService.getProductBy(productId);
    val totalPrice = product.price() * quantity;
    walletService.minusBalance(wallet, totalPrice);
    transactionService.saveTransaction(wallet.walletId(), totalPrice, TransactionType.DEDUCT);
    productService.updateStock(product, quantity);
    val orderId = orderService.order(userId);
    orderItemService.save(orderId, product.id(), quantity, product.price());

    try {
      publishOrderEvent(orderId);  // 트랜잭션 외부에서 호출
    } catch (Exception e) {
      log.error("Error publishing event", e);
    }
  }

  private void publishOrderEvent(Long orderId) {
    applicationEventPublisher.publishEvent(new RegisteredEvent(orderId));
  }
}
