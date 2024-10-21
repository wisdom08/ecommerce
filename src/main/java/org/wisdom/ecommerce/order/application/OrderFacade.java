package org.wisdom.ecommerce.order.application;

import org.springframework.stereotype.Component;
import org.wisdom.ecommerce.order.infra.DataPlatform;
import org.wisdom.ecommerce.product.application.ProductApplicationDto;
import org.wisdom.ecommerce.product.application.ProductService;
import org.wisdom.ecommerce.user.application.UserService;
import org.wisdom.ecommerce.wallet.application.WalletService;
import org.wisdom.ecommerce.wallet.domain.Wallet;

@Component
public class OrderFacade {

    private final UserService userService;
    private final WalletService walletService;
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final DataPlatform dataPlatform;

    public OrderFacade(UserService userService, WalletService walletService, ProductService productService,
        OrderService orderService, OrderItemService orderItemService, DataPlatform dataPlatform) {
        this.userService = userService;
        this.walletService = walletService;
        this.productService = productService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.dataPlatform = dataPlatform;
    }

    public void place(long userId, long productId, int quantity) {
        userService.getUserBy(userId);
        ProductApplicationDto product = productService.getProductBy(productId);
        Wallet wallet = walletService.getWalletBy(userId);

        wallet.validatePayAmount(product.price());

        long orderId = orderService.order(userId);
        orderItemService.save(orderId, product.id(), quantity, product.price());
        dataPlatform.send();
    }
}
