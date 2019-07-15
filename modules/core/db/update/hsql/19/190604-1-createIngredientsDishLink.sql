create table SPEEDYPIZZAAPP_INGREDIENTS_DISH_LINK (
    INGREDIENTS_ID varchar(36) not null,
    DISH_ID varchar(36) not null,
    primary key (INGREDIENTS_ID, DISH_ID)
);
