----------------------------------------------------
-- Export file for user TEST                      --
-- Created by Administrator on 2016/4/14, 8:35:53 --
----------------------------------------------------

set define off
spool sql.log

prompt
prompt Creating table GOODS
prompt ====================
prompt
create table TEST.GOODS
(
  id          NUMBER(10) not null,
  goods_name  VARCHAR2(255 CHAR),
  goods_num   NUMBER(10),
  goods_price FLOAT
)
tablespace TEST
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TEST.GOODS
  add primary key (ID)
  using index 
  tablespace TEST
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ITEM
prompt ===================
prompt
create table TEST.ITEM
(
  id   NUMBER not null,
  name VARCHAR2(20),
  num  NUMBER
)
tablespace TEST
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ORDERS
prompt =====================
prompt
create table TEST.ORDERS
(
  id           NUMBER(10) not null,
  total_prices FLOAT
)
tablespace TEST
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TEST.ORDERS
  add primary key (ID)
  using index 
  tablespace TEST
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ITEM_DETAILS
prompt ===========================
prompt
create table TEST.ITEM_DETAILS
(
  id       NUMBER(10) not null,
  num      NUMBER(10),
  good_id  NUMBER(10),
  order_id NUMBER(10)
)
tablespace TEST
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TEST.ITEM_DETAILS
  add primary key (ID)
  using index 
  tablespace TEST
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table TEST.ITEM_DETAILS
  add constraint FK_1M4I65XHSYSCOI17YSAB5ORJ3 foreign key (ORDER_ID)
  references TEST.ORDERS (ID);
alter table TEST.ITEM_DETAILS
  add constraint FK_H3CJS6C6HRCFAXPFEC1OGRQ5P foreign key (GOOD_ID)
  references TEST.GOODS (ID);

prompt
prompt Creating table TEST
prompt ===================
prompt
create table TEST.TEST
(
  id    NUMBER,
  name  VARCHAR2(20),
  pid   NUMBER,
  ppath VARCHAR2(20)
)
tablespace TEST
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table USERS
prompt ====================
prompt
create table TEST.USERS
(
  id       NUMBER,
  username VARCHAR2(20),
  password VARCHAR2(20),
  passowrd VARCHAR2(255 CHAR)
)
tablespace TEST
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence SEQ_TEST
prompt ==========================
prompt
create sequence TEST.SEQ_TEST
minvalue 1
maxvalue 9999999999999999999999999999
start with 2
increment by 1
nocache;

prompt
prompt Creating trigger TG_ITEM
prompt ========================
prompt
CREATE OR REPLACE TRIGGER TEST.tg_item
BEFORE INSERT ON item FOR EACH ROW WHEN (new.id is null)
begin
select seq_test.nextval into:new.id from dual;
end;
/


spool off
