alter table SPEEDYPIZZAAPP_STAFF alter column NAME rename to NAME__U31144 ^
alter table SPEEDYPIZZAAPP_STAFF alter column NAME__U31144 set null ;
-- alter table SPEEDYPIZZAAPP_STAFF add column USER_ID varchar(36) ^
-- update SPEEDYPIZZAAPP_STAFF set USER_ID = <default_value> ;
-- alter table SPEEDYPIZZAAPP_STAFF alter column USER_ID set not null ;
alter table SPEEDYPIZZAAPP_STAFF add column USER_ID varchar(36) not null ;
