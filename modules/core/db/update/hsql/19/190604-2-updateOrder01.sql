alter table SPEEDYPIZZAAPP_ORDER add constraint FK_SPEEDYPIZZAAPP_ORDER_ON_STAFF foreign key (STAFF_ID) references SPEEDYPIZZAAPP_STAFF(ID);
create index IDX_SPEEDYPIZZAAPP_ORDER_ON_STAFF on SPEEDYPIZZAAPP_ORDER (STAFF_ID);
