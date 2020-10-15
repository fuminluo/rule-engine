-- Create table
create table T_APPLICATION
(
    id               NVARCHAR2(32) not null,
    application_name NVARCHAR2(64) not null,
    application_code NVARCHAR2(32) not null,
    remarks          NVARCHAR2(255),
    date_time        TIMESTAMP(6) default systimestamp,
    status           NVARCHAR2(1) default 1 not null,
    parent_id        NVARCHAR2(32) not null,
    root_id          NVARCHAR2(32) not null,
    order_sort       NUMBER
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
comment on column T_APPLICATION.order_sort
    is '排序';
-- Create/Recreate indexes
create index NK_APP_ORDER_SORT on T_APPLICATION (ORDER_SORT)
    tablespace ROOT_SPACE
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
create unique index UK_APP_APPLICATION_CODE on T_APPLICATION (APPLICATION_CODE)
    tablespace ROOT_SPACE
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
alter table T_APPLICATION
    add constraint PK_APPLICATION_ID primary key (ID)
        using index
            tablespace ROOT_SPACE
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
create table T_APPLICATION_TEMPLATE
(
    id             NVARCHAR2(32) not null,
    segment_code   NVARCHAR2(32) not null,
    segment_name   NVARCHAR2(64) not null,
    column_name    NVARCHAR2(32) not null,
    column_type    NVARCHAR2(32) not null,
    is_request     NVARCHAR2(1) not null,
    remarks        NVARCHAR2(255),
    custom_sql     NVARCHAR2(1000),
    segment_type   NVARCHAR2(32) not null,
    order_sort     NUMBER,
    date_time      TIMESTAMP(6) default systimestamp,
    status         NVARCHAR2(1) default 1,
    in_out         NVARCHAR2(8) default 'IN' not null,
    is_join        NVARCHAR2(1) default 'N' not null,
    join_code      NVARCHAR2(32),
    application_id NVARCHAR2(32),
    field_name     NVARCHAR2(32),
    field_type     NVARCHAR2(32),
    arithmetic     NVARCHAR2(32),
    enable_sql     NVARCHAR2(1)
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
comment on table T_APPLICATION_TEMPLATE
    is '模板配置表';
-- Add comments to the columns
comment on column T_APPLICATION_TEMPLATE.id
    is '配置id';
comment on column T_APPLICATION_TEMPLATE.segment_code
    is '段值编码';
comment on column T_APPLICATION_TEMPLATE.segment_name
    is '段值名称';
comment on column T_APPLICATION_TEMPLATE.column_name
    is '数据库列名称';
comment on column T_APPLICATION_TEMPLATE.column_type
    is '数据库列类型:字符、数字、时间';
comment on column T_APPLICATION_TEMPLATE.is_request
    is '是否必填:Y-是,N-否';
comment on column T_APPLICATION_TEMPLATE.remarks
    is '备注';
comment on column T_APPLICATION_TEMPLATE.custom_sql
    is '自定义取值sql';
comment on column T_APPLICATION_TEMPLATE.segment_type
    is '断值数据类型:字符、数字、时间';
comment on column T_APPLICATION_TEMPLATE.order_sort
    is '排序字段';
comment on column T_APPLICATION_TEMPLATE.date_time
    is '时间戳';
comment on column T_APPLICATION_TEMPLATE.status
    is '0-禁用,1-启用';
comment on column T_APPLICATION_TEMPLATE.in_out
    is '输入:IN、输出:OUT、输入和输出:INOUT、非输入和输出NOT';
comment on column T_APPLICATION_TEMPLATE.is_join
    is '是否关联:Y-是,N-否';
comment on column T_APPLICATION_TEMPLATE.join_code
    is '关联父节点编码';
comment on column T_APPLICATION_TEMPLATE.application_id
    is '应用id';
comment on column T_APPLICATION_TEMPLATE.field_name
    is 'java属性名称';
comment on column T_APPLICATION_TEMPLATE.field_type
    is 'java属性类型';
comment on column T_APPLICATION_TEMPLATE.arithmetic
    is '运算符';
comment on column T_APPLICATION_TEMPLATE.enable_sql
    is '启用sql';
-- Create/Recreate indexes
create index NK_AT_APPLICATION_ID on T_APPLICATION_TEMPLATE (APPLICATION_ID)
    tablespace ROOT_SPACE
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
create index NK_ORDER_SORT on T_APPLICATION_TEMPLATE (ORDER_SORT)
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
alter table T_APPLICATION_TEMPLATE
    add constraint PK_APPLICATION_TEMPLATE_ID primary key (ID)
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
    hash_code      NUMBER not null,
    application_id NVARCHAR2(32) not null,
    status         NVARCHAR2(1) default '2' not null,
    date_time      TIMESTAMP(6) default systimestamp not null,
    batch_group_id NUMBER(12) not null
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
-- Add comments to the columns
comment on column T_OBJECT_DATA.hash_code
    is 'hash索引';
comment on column T_OBJECT_DATA.application_id
    is '应用id';
comment on column T_OBJECT_DATA.status
    is '0-禁用,1-启用,2-草稿';
comment on column T_OBJECT_DATA.date_time
    is '时间戳';
comment on column T_OBJECT_DATA.batch_group_id
    is '批次id';
-- Create/Recreate indexes
create index NK_HASH_CODE on T_OBJECT_DATA (HASH_CODE)
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
alter table T_OBJECT_DATA
    add constraint PK_OBJECT_DATA_ID primary key (ID)
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
create table T_VALUE_SET
(
    id                NVARCHAR2(32) not null,
    application_id    NVARCHAR2(32) not null,
    value_code        NVARCHAR2(255) not null,
    data_type         NVARCHAR2(32) not null,
    remarks           NVARCHAR2(255),
    status            NVARCHAR2(1) default 1 not null,
    date_time         TIMESTAMP(6) default systimestamp,
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
create index NK_VALUE_CODE on T_VALUE_SET (VALUE_CODE)
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



