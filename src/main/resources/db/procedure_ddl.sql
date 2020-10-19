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
