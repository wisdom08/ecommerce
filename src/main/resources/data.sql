INSERT INTO ecommerce.product (name, price, quantity, created_at, updated_at)
VALUES ('Laptop', 1000, 50, NOW(), NOW()),
       ('Headphones', 150, 200, NOW(), NOW()),
       ('Smartphone', 800, 100, NOW(), NOW()),
       ('Tablet', 500, 75, NOW(), NOW()),
       ('Smartwatch', 300, 60, NOW(), NOW());

INSERT INTO ecommerce.user (email, created_at, updated_at)
VALUES ('john.doe@example.com', NOW(), NOW()),
       ('jane.smith@example.com', NOW(), NOW()),
       ('alex.johnson@example.com', NOW(), NOW());


INSERT INTO ecommerce.cart (user_id, created_at, updated_at)
VALUES (1, NOW(), NOW()),
       (2, NOW(), NOW());

INSERT INTO ecommerce.cart_item (cart_id, product_id, quantity, created_at, updated_at)
VALUES (1, 1, 2, NOW(), NOW()),
       (1, 3, 1, NOW(), NOW()),
       (2, 2, 3, NOW(), NOW());

INSERT INTO ecommerce.orders (user_id, status, created_at, updated_at)
VALUES (1, 'paid', NOW(), NOW()),
       (2, 'preparing', NOW(), NOW());

INSERT INTO ecommerce.order_item (order_id, product_id, quantity, unit_price, created_at, updated_at)
VALUES (1, 1, 2, 1000, NOW(), NOW()),
       (1, 3, 1, 800, NOW(), NOW()),
       (2, 2, 3, 150, NOW(), NOW());


INSERT INTO ecommerce.wallet (balance, user_id, created_at, updated_at)
VALUES (5000, 1, NOW(), NOW()),
       (1000, 2, NOW(), NOW());
