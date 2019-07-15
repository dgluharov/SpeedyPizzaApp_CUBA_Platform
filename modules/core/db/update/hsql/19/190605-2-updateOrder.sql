-- update SPEEDYPIZZAAPP_ORDER set STAFF_ID = <default_value> where STAFF_ID is null ;
alter table SPEEDYPIZZAAPP_ORDER alter column STAFF_ID set not null ;
