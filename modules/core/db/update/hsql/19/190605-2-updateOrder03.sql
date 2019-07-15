-- update SPEEDYPIZZAAPP_ORDER set ORDER_ID = <default_value> where ORDER_ID is null ;
alter table SPEEDYPIZZAAPP_ORDER alter column ORDER_ID set not null ;
