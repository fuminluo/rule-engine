--授权root创建表
grant create table to root;
--批量创建表
create or replace procedure create_table_batch(
i_count in number, --创建n张表
i_table_prefix varchar2, --表名前缀
i_colunm_prefix varchar2) is --字段名前缀

  v_sql varchar2(500);
  v_exist number(1);
  v_tablename varchar2(100);
  v_errorCode number; --异常代号
  v_errorMsg varchar2(1000); --异常信息
begin
    for i in 1 .. i_count loop
     --删除表
     v_tablename := i_table_prefix||i;
     select count(*) into v_exist from user_tables where table_name =upper(v_tablename);
     if v_exist > 0 then
        v_sql:= 'drop table '||v_tablename;
        EXECUTE IMMEDIATE v_sql;
        end if;
     --创建表
     v_sql:= 'create table '|| v_tablename || '('||i_colunm_prefix ||i||' NVARCHAR2(255))';
     EXECUTE IMMEDIATE v_sql;
    end loop;
   exception
     when others then
       dbms_output.put_line(v_errorCode || ',' || v_errorMsg);
end create_table_batch;

--批量清除表
create or replace procedure clean_column_table is
begin
    DELETE FROM T_COLUMN_CHAR1;
    DELETE FROM T_COLUMN_CHAR2;
    DELETE FROM T_COLUMN_CHAR3;
    DELETE FROM T_COLUMN_CHAR4;
    DELETE FROM T_COLUMN_CHAR5;
    DELETE FROM T_COLUMN_CHAR6;
    DELETE FROM T_COLUMN_CHAR7;
    DELETE FROM T_COLUMN_CHAR8;
    DELETE FROM T_COLUMN_CHAR9;
    DELETE FROM T_COLUMN_CHAR10;
    DELETE FROM T_COLUMN_CHAR11;
    DELETE FROM T_COLUMN_CHAR12;
    DELETE FROM T_COLUMN_CHAR13;
    DELETE FROM T_COLUMN_CHAR14;
    DELETE FROM T_COLUMN_CHAR15;
    DELETE FROM T_COLUMN_CHAR15;
    DELETE FROM T_COLUMN_NUMBER1;
    DELETE FROM T_COLUMN_NUMBER2;
    DELETE FROM T_COLUMN_NUMBER3;
    DELETE FROM T_COLUMN_NUMBER4;
    DELETE FROM T_COLUMN_NUMBER5;
    DELETE FROM T_COLUMN_NUMBER6;
    DELETE FROM T_COLUMN_DATE1;
    DELETE FROM T_COLUMN_DATE2;
    DELETE FROM T_COLUMN_DATE3;
    DELETE FROM T_COLUMN_DATE4;
end clean_column_table;