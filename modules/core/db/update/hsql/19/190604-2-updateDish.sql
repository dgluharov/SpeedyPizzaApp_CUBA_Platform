-- alter table SPEEDYPIZZAAPP_DISH add column DISH_TYPE_ID varchar(36) ^
-- update SPEEDYPIZZAAPP_DISH set DISH_TYPE_ID = <default_value> ;
-- alter table SPEEDYPIZZAAPP_DISH alter column DISH_TYPE_ID set not null ;
alter table SPEEDYPIZZAAPP_DISH add column DISH_TYPE_ID varchar(36) not null ;
