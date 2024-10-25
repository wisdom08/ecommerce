truncate table product;

INSERT INTO ecommerce.product (name, price, quantity, created_at, updated_at)
VALUES ('ipad', 1000, 10, NOW(), NOW());
