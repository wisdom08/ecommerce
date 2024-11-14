package org.wisdom.ecommerce.order.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;
import org.wisdom.ecommerce.order.infra.DataPlatform;
import org.wisdom.ecommerce.order.infra.EventListener;
import org.wisdom.ecommerce.product.application.ProductService;
import org.wisdom.ecommerce.product.domain.Product;
import org.wisdom.ecommerce.product.infra.ProductRedisManager;
import org.wisdom.ecommerce.user.application.UserService;
import org.wisdom.ecommerce.wallet.application.TransactionService;
import org.wisdom.ecommerce.wallet.application.WalletService;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@SpringBootTest
class OrderFacadeTest {

  public static final int INITIAL_BALANCE = 10000;
  public static final int INITIAL_QUANTITY = 10;
  public static final int QUANTITY_OF_ORDER = 2;
  public static final int PRODUCT_OF_PRICE = 1000;


  @Autowired
  private OrderFacade orderFacade;

  @MockBean
  private UserService userService;
  @MockBean
  private WalletService walletService;
  @MockBean
  private ProductService productService;
  @MockBean
  private OrderService orderService;
  @MockBean
  private OrderItemService orderItemService;
  @MockBean
  private DataPlatform dataPlatform;
  @MockBean
  private TransactionService transactionService;
  @MockBean
  private ProductRedisManager productRedisManager;
  @MockBean
  private EventListener eventListener;

  private final Long userId = 1L;
  private final Long productId = 1L;
  private final Integer quantity = 2;

  @BeforeEach
  void setup() {
    Long walletId = 1L;
    Wallet wallet = new Wallet(walletId, userId, INITIAL_BALANCE);
    Product product = new Product(productId, "MOCK_PRODUCT", PRODUCT_OF_PRICE, INITIAL_QUANTITY);

    when(userService.getUserBy(userId)).thenReturn(userId);
    when(walletService.getWalletBy(userId)).thenReturn(wallet);
    when(productService.getProductBy(productId)).thenReturn(product);
  }

  @Disabled
  @Transactional
  @Test
  void 주문_정보_전송이_실패해서_롤백되어_포인트_차감이_되지않고_기존잔액을_유지하게_된다() {
    // given
    doThrow(new RuntimeException()).when(dataPlatform).send(1L);
    // when
    assertThrows(RuntimeException.class, () -> orderFacade.place(userId, productId, quantity));
    // then
    assertThat(walletService.getWalletBy(userId).balance()).isEqualTo(INITIAL_BALANCE);
  }

  @Disabled
  @Transactional
  @Test
  void 주문_정보_전송이_실패해서_롤백되어_상품_재고가_차감되지않고_기존_재고를_유지하게_된다() {
    // given
    doThrow(new RuntimeException()).when(dataPlatform).send(1L);
    // when
    assertThrows(RuntimeException.class, () -> orderFacade.place(userId, productId, quantity));
    // then
    assertThat(productService.getProductBy(productId).quantity()).isEqualTo(INITIAL_QUANTITY);
  }

  @Transactional
  @Test
  void 주문_정보_전송이_실패하더라도_주문로직은_처리되어_재고와_포인트가_차감된다() {
    // given
    doThrow(new RuntimeException()).when(dataPlatform).send(anyLong());
    // when
    orderFacade.place(userId, productId, QUANTITY_OF_ORDER);
    // then
    verify(eventListener).sendOrderInfo(anyLong());
    assertThat(walletService.getWalletBy(userId).balance()).isEqualTo(INITIAL_BALANCE - QUANTITY_OF_ORDER);
    assertThat(productService.getProductBy(productId).quantity()).isEqualTo(INITIAL_QUANTITY-PRODUCT_OF_PRICE);
  }
}