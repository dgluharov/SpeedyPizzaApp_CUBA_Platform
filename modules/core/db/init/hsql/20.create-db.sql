-- begin SPEEDYPIZZAAPP_ORDER
alter table SPEEDYPIZZAAPP_ORDER add constraint FK_SPEEDYPIZZAAPP_ORDER_ON_CUSTOMER foreign key (CUSTOMER_ID) references SPEEDYPIZZAAPP_CUSTOMER(ID)^
alter table SPEEDYPIZZAAPP_ORDER add constraint FK_SPEEDYPIZZAAPP_ORDER_ON_STAFF foreign key (STAFF_ID) references SPEEDYPIZZAAPP_STAFF(ID)^
create index IDX_SPEEDYPIZZAAPP_ORDER_ON_CUSTOMER on SPEEDYPIZZAAPP_ORDER (CUSTOMER_ID)^
create index IDX_SPEEDYPIZZAAPP_ORDER_ON_STAFF on SPEEDYPIZZAAPP_ORDER (STAFF_ID)^
-- end SPEEDYPIZZAAPP_ORDER
-- begin SPEEDYPIZZAAPP_ORDER_LINE
alter table SPEEDYPIZZAAPP_ORDER_LINE add constraint FK_SPEEDYPIZZAAPP_ORDER_LINE_ON_ORDER foreign key (ORDER_ID) references SPEEDYPIZZAAPP_ORDER(ID)^
alter table SPEEDYPIZZAAPP_ORDER_LINE add constraint FK_SPEEDYPIZZAAPP_ORDER_LINE_ON_DISH foreign key (DISH_ID) references SPEEDYPIZZAAPP_DISH(ID)^
create index IDX_SPEEDYPIZZAAPP_ORDER_LINE_ON_ORDER on SPEEDYPIZZAAPP_ORDER_LINE (ORDER_ID)^
create index IDX_SPEEDYPIZZAAPP_ORDER_LINE_ON_DISH on SPEEDYPIZZAAPP_ORDER_LINE (DISH_ID)^
-- end SPEEDYPIZZAAPP_ORDER_LINE
-- begin SPEEDYPIZZAAPP_INGREDIENTS
create unique index IDX_SPEEDYPIZZAAPP_INGREDIENTS_UNIQ_NAME on SPEEDYPIZZAAPP_INGREDIENTS (NAME) ^
-- end SPEEDYPIZZAAPP_INGREDIENTS
-- begin SPEEDYPIZZAAPP_INGREDIENTS_DISH_LINK
alter table SPEEDYPIZZAAPP_INGREDIENTS_DISH_LINK add constraint FK_INGDIS_ON_INGREDIENTS foreign key (INGREDIENTS_ID) references SPEEDYPIZZAAPP_INGREDIENTS(ID)^
alter table SPEEDYPIZZAAPP_INGREDIENTS_DISH_LINK add constraint FK_INGDIS_ON_DISH foreign key (DISH_ID) references SPEEDYPIZZAAPP_DISH(ID)^
-- end SPEEDYPIZZAAPP_INGREDIENTS_DISH_LINK
-- begin SPEEDYPIZZAAPP_DISH
alter table SPEEDYPIZZAAPP_DISH add constraint FK_SPEEDYPIZZAAPP_DISH_ON_DISH_TYPE foreign key (DISH_TYPE_ID) references SPEEDYPIZZAAPP_DISH_TYPE(ID)^
create index IDX_SPEEDYPIZZAAPP_DISH_ON_DISH_TYPE on SPEEDYPIZZAAPP_DISH (DISH_TYPE_ID)^
-- end SPEEDYPIZZAAPP_DISH
-- begin SPEEDYPIZZAAPP_STAFF
alter table SPEEDYPIZZAAPP_STAFF add constraint FK_SPEEDYPIZZAAPP_STAFF_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_SPEEDYPIZZAAPP_STAFF_ON_USER on SPEEDYPIZZAAPP_STAFF (USER_ID)^
-- end SPEEDYPIZZAAPP_STAFF