-- begin SPEEDYPIZZAAPP_CUSTOMER
create table SPEEDYPIZZAAPP_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PHONE_NUMBER varchar(255) not null,
    ADDRESS varchar(255),
    ORDER_COUNTER integer not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZAAPP_CUSTOMER
-- begin SPEEDYPIZZAAPP_ORDER
create table SPEEDYPIZZAAPP_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID varchar(255),
    ORDER_TIME timestamp not null,
    CUSTOMER_ID varchar(36) not null,
    DELIVERY_INCTRUCTIONS varchar(255),
    DELIVERY_TIME time not null,
    TOTAL_AMOUNT decimal(19, 2) not null,
    STAFF_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZAAPP_ORDER
-- begin SPEEDYPIZZAAPP_ORDER_LINE
create table SPEEDYPIZZAAPP_ORDER_LINE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_ID varchar(36) not null,
    DISH_ID varchar(36) not null,
    QUANTITY decimal(19, 2),
    --
    primary key (ID)
)^
-- end SPEEDYPIZZAAPP_ORDER_LINE
-- begin SPEEDYPIZZAAPP_DISH
create table SPEEDYPIZZAAPP_DISH (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PRICE decimal(19, 2) not null,
    COOKING_TIME time not null,
    DISH_TYPE_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZAAPP_DISH
-- begin SPEEDYPIZZAAPP_DISH_TYPE
create table SPEEDYPIZZAAPP_DISH_TYPE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZAAPP_DISH_TYPE
-- begin SPEEDYPIZZAAPP_INGREDIENTS
create table SPEEDYPIZZAAPP_INGREDIENTS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZAAPP_INGREDIENTS
-- begin SPEEDYPIZZAAPP_STAFF
create table SPEEDYPIZZAAPP_STAFF (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end SPEEDYPIZZAAPP_STAFF
-- begin SPEEDYPIZZAAPP_INGREDIENTS_DISH_LINK
create table SPEEDYPIZZAAPP_INGREDIENTS_DISH_LINK (
    INGREDIENTS_ID varchar(36) not null,
    DISH_ID varchar(36) not null,
    primary key (INGREDIENTS_ID, DISH_ID)
)^
-- end SPEEDYPIZZAAPP_INGREDIENTS_DISH_LINK
