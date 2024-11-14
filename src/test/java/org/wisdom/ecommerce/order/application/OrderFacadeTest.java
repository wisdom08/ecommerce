package org.wisdom.ecommerce.order.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;
import org.wisdom.ecommerce.order.infra.DataPlatform;
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

  private final Long userId = 1L;
  private final Long productId = 1L;
  private final Integer quantity = 2;

  @BeforeEach
  void setup() {
    Long walletId = 1L;
    Wallet wallet = new Wallet(walletId, userId, INITIAL_BALANCE);
    Product product = new Product(productId, "MOCK_PRODUCT", 1000, INITIAL_QUANTITY);

    when(userService.getUserBy(userId)).thenReturn(userId);
    when(walletService.getWalletBy(userId)).thenReturn(wallet);
    when(productService.getProductBy(productId)).thenReturn(product);
  }

  @Transactional
  @Test
  void 주문_정보_전송이_실패해서_롤백되어_포인트_차감이_되지않고_기존잔액을_유지하게_된다() {
    // given
    doThrow(new RuntimeException()).when(dataPlatform).send();
    // when
    assertThrows(RuntimeException.class, () -> orderFacade.place(userId, productId, quantity));
    // then
    assertThat(INITIAL_BALANCE).isEqualTo(walletService.getWalletBy(userId).balance());
  }

  @Transactional
  @Test
  void 주문_정보_전송이_실패해서_롤백되어_상품_재고가_차감되지않고_기존_재고를_유지하게_된다() {
    // given
    doThrow(new RuntimeException()).when(dataPlatform).send();
    // when
    assertThrows(RuntimeException.class, () -> orderFacade.place(userId, productId, quantity));
    // then
    assertThat(INITIAL_QUANTITY).isEqualTo(productService.getProductBy(productId).quantity());
  }
}