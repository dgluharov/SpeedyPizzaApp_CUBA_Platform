-- alter table SPEEDYPIZZAAPP_ORDER add column STAFF_ID varchar(36) ^
-- update SPEEDYPIZZAAPP_ORDER set STAFF_ID = <default_value> ;
-- alter table SPEEDYPIZZAAPP_ORDER alter column STAFF_ID set not null ;
alter table SPEEDYPIZZAAPP_ORDER add column STAFF_ID varchar(36) not null ;
