truncate table product;
truncate table wallet;

INSERT INTO ecommerce.product (name, price, quantity, created_at, updated_at)
VALUES ('ipad', 1000, 10, NOW(), NOW());


INSERT INTO ecommerce.product (name, price, quantity, created_at, updated_at)
VALUES ('macbook', 1000, 10, NOW(), NOW());


INSERT INTO ecommerce.wallet (balance, user_id, created_at, updated_at)
VALUES (5000, 1, NOW(), NOW()),
       (1000, 2, NOW(), NOW()),
       (3000, 3, NOW(), NOW()),
       (4000, 4, NOW(), NOW()),
       (2000, 5, NOW(), NOW()),
       (3500, 6, NOW(), NOW()),
       (1500, 7, NOW(), NOW()),
       (2500, 8, NOW(), NOW()),
       (6000, 9, NOW(), NOW()),
       (4500, 10, NOW(), NOW()),
       (5000, 11, NOW(), NOW()),
       (1000, 12, NOW(), NOW()),
       (3000, 13, NOW(), NOW()),
       (4000, 14, NOW(), NOW()),
       (2000, 15, NOW(), NOW()),
       (3500, 16, NOW(), NOW()),
       (1500, 17, NOW(), NOW()),
       (2500, 18, NOW(), NOW()),
       (6000, 19, NOW(), NOW()),
       (4500, 20, NOW(), NOW()),
       (5000, 21, NOW(), NOW()),
       (1000, 22, NOW(), NOW()),
       (3000, 23, NOW(), NOW()),
       (4000, 24, NOW(), NOW()),
       (2000, 25, NOW(), NOW()),
       (3500, 26, NOW(), NOW()),
       (1500, 27, NOW(), NOW()),
       (2500, 28, NOW(), NOW()),
       (6000, 29, NOW(), NOW()),
       (4500, 30, NOW(), NOW()),
       (5000, 31, NOW(), NOW()),
       (1000, 32, NOW(), NOW()),
       (3000, 33, NOW(), NOW()),
       (4000, 34, NOW(), NOW()),
       (2000, 35, NOW(), NOW()),
       (3500, 36, NOW(), NOW()),
       (1500, 37, NOW(), NOW()),
       (2500, 38, NOW(), NOW()),
       (6000, 39, NOW(), NOW()),
       (4500, 40, NOW(), NOW()),
       (5000, 41, NOW(), NOW()),
       (1000, 42, NOW(), NOW()),
       (3000, 43, NOW(), NOW()),
       (4000, 44, NOW(), NOW()),
       (2000, 45, NOW(), NOW()),
       (3500, 46, NOW(), NOW()),
       (1500, 47, NOW(), NOW()),
       (2500, 48, NOW(), NOW()),
       (6000, 49, NOW(), NOW()),
       (4500, 50, NOW(), NOW());