-- Create table
create table T_VALUE_SET
(
  id                NVARCHAR2(32) not null,
  application_id    NVARCHAR2(32) not null,
  value_code        NVARCHAR2(255) not null,
  data_type         NVARCHAR2(32) not null,
  remarks           NVARCHAR2(255),
  status            NVARCHAR2(1) default 1 not null,
  date_time         TIMESTAMP(6),
  segment_name      NVARCHAR2(32),
  segment_code      NVARCHAR2(64),
  value_parent_code NVARCHAR2(64),
  value_name        NVARCHAR2(255)
)
tablespace USERS
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
-- Add comments to the table
comment on table T_VALUE_SET
  is '值集表';
-- Add comments to the columns
comment on column T_VALUE_SET.id
  is '主键';
comment on column T_VALUE_SET.application_id
  is '应用id';
comment on column T_VALUE_SET.value_code
  is '值编码';
comment on column T_VALUE_SET.data_type
  is '数据类型:1-String,2-Number,3-Date';
comment on column T_VALUE_SET.remarks
  is '备注';
comment on column T_VALUE_SET.status
  is '0-禁用,1-启用';
comment on column T_VALUE_SET.date_time
  is '时间戳';
comment on column T_VALUE_SET.segment_name
  is '段值名称';
comment on column T_VALUE_SET.segment_code
  is '段值编码';
comment on column T_VALUE_SET.value_parent_code
  is '值编码父code,用于构建树';
comment on column T_VALUE_SET.value_name
  is '值名称';
-- Create/Recreate indexes
create index NK_APPLICATION_ID on T_VALUE_SET (APPLICATION_ID)
  tablespace USERS
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
-- Create/Recreate primary, unique and foreign key constraints
alter table T_VALUE_SET
  add constraint PK_UUID primary key (ID)
  using index
  tablespace USERS
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

-- Create table
create table T_TEMPLATE_COFIG
(
  id           NVARCHAR2(32) not null,
  segment_code NVARCHAR2(32) not null,
  segment_name NVARCHAR2(64) not null,
  column_name  NVARCHAR2(32) not null,
  column_type  NVARCHAR2(32) not null,
  is_request   NVARCHAR2(1) not null,
  remarks      NVARCHAR2(255),
  template_id  NVARCHAR2(32),
  custom_sql   NVARCHAR2(1000),
  segment_type NVARCHAR2(32) not null,
  order_sort   NUMBER not null,
  date_time    TIMESTAMP(6),
  status       NVARCHAR2(1),
  in_out       NVARCHAR2(8) not null,
  is_join      NVARCHAR2(1) not null,
  join_code    NVARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table
comment on table T_TEMPLATE_COFIG
  is '模板配置表';
-- Add comments to the columns
comment on column T_TEMPLATE_COFIG.id
  is '配置id';
comment on column T_TEMPLATE_COFIG.segment_code
  is '段值编码';
comment on column T_TEMPLATE_COFIG.segment_name
  is '段值名称';
comment on column T_TEMPLATE_COFIG.column_name
  is '数据库列名称';
comment on column T_TEMPLATE_COFIG.column_type
  is '数据库列类型:字符、数字、时间';
comment on column T_TEMPLATE_COFIG.is_request
  is '是否必填:Y-是,N-否';
comment on column T_TEMPLATE_COFIG.remarks
  is '备注';
comment on column T_TEMPLATE_COFIG.template_id
  is '配置id';
comment on column T_TEMPLATE_COFIG.custom_sql
  is '自定义取值sql';
comment on column T_TEMPLATE_COFIG.segment_type
  is '断值数据类型:字符、数字、时间';
comment on column T_TEMPLATE_COFIG.order_sort
  is '排序字段';
comment on column T_TEMPLATE_COFIG.date_time
  is '时间戳';
comment on column T_TEMPLATE_COFIG.status
  is '0-禁用,1-启用';
comment on column T_TEMPLATE_COFIG.in_out
  is '输入:IN、输出:OUT、输入和输出:INOUT';
comment on column T_TEMPLATE_COFIG.is_join
  is '是否关联:Y-是,N-否';
comment on column T_TEMPLATE_COFIG.join_code
  is '关联父节点编码';
-- Create/Recreate indexes
create index NK_ORDER_SORT on T_TEMPLATE_COFIG (ORDER_SORT)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
create index NK_TEMPLATE_ID on T_TEMPLATE_COFIG (TEMPLATE_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints
alter table T_TEMPLATE_COFIG
  add constraint PK_TEMPLATE_COFIG_ID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

-- Create table
create table T_TEMPLATE
(
  id             NVARCHAR2(32) not null,
  template_name  NVARCHAR2(64),
  application_id NVARCHAR2(32),
  date_time      TIMESTAMP(6),
  status         NVARCHAR2(1),
  remarks        NVARCHAR2(255)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table
comment on table T_TEMPLATE
  is '模板表';
-- Add comments to the columns
comment on column T_TEMPLATE.template_name
  is '模板名称';
comment on column T_TEMPLATE.application_id
  is '应用id';
comment on column T_TEMPLATE.date_time
  is '时间戳';
comment on column T_TEMPLATE.status
  is '0-禁用,1-启用';
comment on column T_TEMPLATE.remarks
  is '备注';
-- Create/Recreate indexes
create index NK_APPLICATION_ID1 on T_TEMPLATE (APPLICATION_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints
alter table T_TEMPLATE
  add constraint PK_TEMPLATE_ID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

-- Create table
create table T_OBJECT_DATA
(
  id             NVARCHAR2(32) not null,
  column_char1   NVARCHAR2(255),
  column_char2   NVARCHAR2(255),
  column_char3   NVARCHAR2(255),
  column_char4   NVARCHAR2(255),
  column_char5   NVARCHAR2(255),
  column_char6   NVARCHAR2(255),
  column_char7   NVARCHAR2(255),
  column_char8   NVARCHAR2(255),
  column_char9   NVARCHAR2(255),
  column_char10  NVARCHAR2(255),
  column_char11  NVARCHAR2(255),
  column_char12  NVARCHAR2(255),
  column_char13  NVARCHAR2(255),
  column_char14  NVARCHAR2(255),
  column_char15  NVARCHAR2(255),
  column_number1 NUMBER,
  column_number2 NUMBER,
  column_number3 NUMBER,
  column_number4 NUMBER,
  column_number5 NUMBER,
  column_number6 NUMBER,
  column_date1   TIMESTAMP(6),
  column_date2   TIMESTAMP(6),
  column_date3   TIMESTAMP(6),
  column_date4   TIMESTAMP(6),
  hash_code      NVARCHAR2(32),
  application_id NVARCHAR2(32),
  template_id    NVARCHAR2(32)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Create/Recreate indexes
create index NK_HASH_CODE on T_OBJECT_DATA (HASH_CODE)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create/Recreate primary, unique and foreign key constraints
alter table T_OBJECT_DATA
  add constraint PK_OBJECT_DATA_ID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

-- Create table
create table T_APPLICATION
(
  id               NVARCHAR2(32) not null,
  application_name NVARCHAR2(64) not null,
  application_code NVARCHAR2(32) not null,
  remarks          NVARCHAR2(255),
  date_time        TIMESTAMP(6),
  status           NVARCHAR2(1) default 1 not null,
  parent_id        NVARCHAR2(32) not null,
  root_id          NVARCHAR2(32) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table
comment on table T_APPLICATION
  is '应用表';
-- Add comments to the columns
comment on column T_APPLICATION.id
  is '应用id';
comment on column T_APPLICATION.application_name
  is '应用名称';
comment on column T_APPLICATION.application_code
  is '应用编码';
comment on column T_APPLICATION.remarks
  is '备注';
comment on column T_APPLICATION.date_time
  is '时间戳';
comment on column T_APPLICATION.status
  is '0-禁用,1-启用';
comment on column T_APPLICATION.parent_id
  is '父id';
comment on column T_APPLICATION.root_id
  is '根id';
