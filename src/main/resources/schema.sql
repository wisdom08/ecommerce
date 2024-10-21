drop table if exists ecommerce.order_item;
drop table if exists ecommerce.cart_item;
drop table if exists ecommerce.orders;
drop table if exists ecommerce.cart;
drop table if exists ecommerce.product;
drop table if exists ecommerce.transaction;
drop table if exists ecommerce.wallet;
drop table if exists ecommerce.user;

create table ecommerce.product
(
    id         bigint auto_increment primary key,
    name       varchar(255),
    price      int,
    quantity   int,
    created_at timestamp,
    updated_at timestamp
);


create table ecommerce.transaction
(
    id         bigint auto_increment primary key,
    wallet_id  bigint,
    amount     int,
    type       varchar(20),
    created_at timestamp,
    updated_at timestamp
);

create table ecommerce.user
(
    id         bigint auto_increment primary key,
    email      varchar(255),
    created_at timestamp,
    updated_at timestamp
);

create table ecommerce.cart
(
    id         bigint auto_increment primary key,
    user_id    bigint,
    created_at timestamp,
    updated_at timestamp
);

create table ecommerce.cart_item
(
    id         bigint auto_increment primary key,
    cart_id    bigint,
    product_id bigint,
    quantity   int,
    created_at timestamp,
    updated_at timestamp
);

create table ecommerce.orders
(
    id         bigint auto_increment primary key,
    user_id    bigint,
    status     varchar(20),
    created_at timestamp,
    updated_at timestamp
);

create table ecommerce.order_item
(
    id         bigint auto_increment primary key,
    order_id   bigint,
    product_id bigint,
    quantity   int,
    unit_price int,
    created_at timestamp,
    updated_at timestamp
);

create table ecommerce.wallet
(
    id         bigint auto_increment     primary key,
    balance    int,
    user_id    bigint,
    created_at timestamp,
    updated_at timestamp
);


