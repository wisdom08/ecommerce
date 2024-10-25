INSERT INTO ecommerce.product (name, price, quantity, created_at, updated_at)
VALUES ('Laptop', 1000, 50, NOW(), NOW()),
       ('Headphones', 150, 200, NOW(), NOW()),
       ('Smartphone', 800, 100, NOW(), NOW()),
       ('Tablet', 500, 75, NOW(), NOW()),
       ('Smartwatch', 300, 60, NOW(), NOW());

INSERT INTO ecommerce.user (email, created_at, updated_at)
VALUES ('user1@example.com', NOW(), NOW()),
       ('user2@example.com', NOW(), NOW()),
       ('user3@example.com', NOW(), NOW()),
       ('user4@example.com', NOW(), NOW()),
       ('user5@example.com', NOW(), NOW()),
       ('user6@example.com', NOW(), NOW()),
       ('user7@example.com', NOW(), NOW()),
       ('user8@example.com', NOW(), NOW()),
       ('user9@example.com', NOW(), NOW()),
       ('user10@example.com', NOW(), NOW()),
       ('user11@example.com', NOW(), NOW()),
       ('user12@example.com', NOW(), NOW()),
       ('user13@example.com', NOW(), NOW()),
       ('user14@example.com', NOW(), NOW()),
       ('user15@example.com', NOW(), NOW()),
       ('user16@example.com', NOW(), NOW()),
       ('user17@example.com', NOW(), NOW()),
       ('user18@example.com', NOW(), NOW()),
       ('user19@example.com', NOW(), NOW()),
       ('user20@example.com', NOW(), NOW()),
       ('user21@example.com', NOW(), NOW()),
       ('user22@example.com', NOW(), NOW()),
       ('user23@example.com', NOW(), NOW()),
       ('user24@example.com', NOW(), NOW()),
       ('user25@example.com', NOW(), NOW()),
       ('user26@example.com', NOW(), NOW()),
       ('user27@example.com', NOW(), NOW()),
       ('user28@example.com', NOW(), NOW()),
       ('user29@example.com', NOW(), NOW()),
       ('user30@example.com', NOW(), NOW()),
       ('user31@example.com', NOW(), NOW()),
       ('user32@example.com', NOW(), NOW()),
       ('user33@example.com', NOW(), NOW()),
       ('user34@example.com', NOW(), NOW()),
       ('user35@example.com', NOW(), NOW()),
       ('user36@example.com', NOW(), NOW()),
       ('user37@example.com', NOW(), NOW()),
       ('user38@example.com', NOW(), NOW()),
       ('user39@example.com', NOW(), NOW()),
       ('user40@example.com', NOW(), NOW()),
       ('user41@example.com', NOW(), NOW()),
       ('user42@example.com', NOW(), NOW()),
       ('user43@example.com', NOW(), NOW()),
       ('user44@example.com', NOW(), NOW()),
       ('user45@example.com', NOW(), NOW()),
       ('user46@example.com', NOW(), NOW()),
       ('user47@example.com', NOW(), NOW()),
       ('user48@example.com', NOW(), NOW()),
       ('user49@example.com', NOW(), NOW()),
       ('user50@example.com', NOW(), NOW());


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
VALUES (5000, 1, NOW(), NOW());