package org.wisdom.ecommerce.order.application;

import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.wisdom.ecommerce.order.infra.DataPlatform;
import org.wisdom.ecommerce.product.application.ProductService;
import org.wisdom.ecommerce.user.application.UserService;
import org.wisdom.ecommerce.wallet.application.TransactionService;
import org.wisdom.ecommerce.wallet.application.WalletService;

@Component
public class OrderFacade {

  private final UserService userService;
  private final WalletService walletService;
  private final ProductService productService;
  private final OrderService orderService;
  private final OrderItemService orderItemService;
  private final DataPlatform dataPlatform;
  private final TransactionService transactionService;

  public OrderFacade(UserService userService, WalletService walletService,
      ProductService productService,
      OrderService orderService, OrderItemService orderItemService, DataPlatform dataPlatform,
      TransactionService transactionService) {
    this.userService = userService;
    this.walletService = walletService;
    this.productService = productService;
    this.orderService = orderService;
    this.orderItemService = orderItemService;
    this.dataPlatform = dataPlatform;
    this.transactionService = transactionService;
  }

  @Transactional
  public void place(Long userId, Long productId, Integer quantity) {
    userService.getUserBy(userId);
    val wallet = walletService.getWalletBy(userId);
    val product = productService.getProductBy(productId);
    val totalPrice = product.price() * quantity;
    walletService.updateBalance(wallet, totalPrice);
    transactionService.saveTransaction(wallet.walletId(), totalPrice);
    productService.updateStock(product, quantity);
    val orderId = orderService.order(userId);
    orderItemService.save(orderId, product.id(), quantity, product.price());
    dataPlatform.send();
  }
}
