insert into T_APPLICATION (id, application_name, application_code, remarks, date_time, status, parent_id, root_id, order_sort)
values ('6525D9B9ADBF4C5EA8942607BBEFB985', '出差补助标准', 'Travel Allowance', null, to_timestamp('09-10-2020 10:11:23.300000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', '4461CD66904741DBB9DB0111384163CC', '4461CD66904741DBB9DB0111384163CC', 2);
insert into T_APPLICATION (id, application_name, application_code, remarks, date_time, status, parent_id, root_id, order_sort)
values ('E3EB8F408D7243F09044AE3C64E6D507', '加班补助标准', 'Overtime Premium', null, to_timestamp('09-10-2020 10:12:47.392000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', '4461CD66904741DBB9DB0111384163CC', '4461CD66904741DBB9DB0111384163CC', 3);
insert into T_APPLICATION (id, application_name, application_code, remarks, date_time, status, parent_id, root_id, order_sort)
values ('4461CD66904741DBB9DB0111384163CC', '我的公司', 'MyCompany', null, to_timestamp('09-10-2020 09:05:52.824000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', '0', '0', 1);
commit;
insert into T_APPLICATION_TEMPLATE (id, segment_code, segment_name, column_name, column_type, is_request, remarks, custom_sql, segment_type, order_sort, date_time, status, in_out, is_join, join_code, application_id, field_name, field_type, arithmetic)
values ('D19176F8B1C049CAB5580619976DDAB1', 'company', '公司', 'column_char1', 'NVARCHAR2', 'Y', null, null, '字符', 1, to_timestamp('09-10-2020 11:34:35.241000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'IN', 'N', null, '6525D9B9ADBF4C5EA8942607BBEFB985', 'columnChar1', null, '=');
insert into T_APPLICATION_TEMPLATE (id, segment_code, segment_name, column_name, column_type, is_request, remarks, custom_sql, segment_type, order_sort, date_time, status, in_out, is_join, join_code, application_id, field_name, field_type, arithmetic)
values ('D1F1687B2FB74D4AA82D8EE27D7E667D', 'dept', '部门', 'column_char2', 'NVARCHAR2', 'Y', null, null, '字符', 2, to_timestamp('09-10-2020 14:15:18.758000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'IN', 'N', null, '6525D9B9ADBF4C5EA8942607BBEFB985', 'columnChar2', null, '=');
insert into T_APPLICATION_TEMPLATE (id, segment_code, segment_name, column_name, column_type, is_request, remarks, custom_sql, segment_type, order_sort, date_time, status, in_out, is_join, join_code, application_id, field_name, field_type, arithmetic)
values ('7A6D1F5E71154F1D8ED127B77554EF7F', 'post', '岗位', 'column_char3', 'NVARCHAR2', 'Y', null, null, '字符', 3, to_timestamp('09-10-2020 14:16:40.146000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'IN', 'N', null, '6525D9B9ADBF4C5EA8942607BBEFB985', 'columnChar3', null, '=');
insert into T_APPLICATION_TEMPLATE (id, segment_code, segment_name, column_name, column_type, is_request, remarks, custom_sql, segment_type, order_sort, date_time, status, in_out, is_join, join_code, application_id, field_name, field_type, arithmetic)
values ('99E293FE57FA44958FF13D3451149E21', 'classOfPositions', '职及', 'column_char4', 'NVARCHAR2', 'Y', null, null, '字符', 4, to_timestamp('09-10-2020 14:17:56.843000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'IN', 'N', null, '6525D9B9ADBF4C5EA8942607BBEFB985', 'columnChar4', null, '=');
insert into T_APPLICATION_TEMPLATE (id, segment_code, segment_name, column_name, column_type, is_request, remarks, custom_sql, segment_type, order_sort, date_time, status, in_out, is_join, join_code, application_id, field_name, field_type, arithmetic)
values ('ED6DA4765CEA414F82AC6DD651660A7A', 'amount ', '报销金额', 'column_number1', 'NUMBER', 'Y', null, null, '数字', 5, to_timestamp('09-10-2020 14:35:59.068000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'OUT', 'N', null, '6525D9B9ADBF4C5EA8942607BBEFB985', 'columnNumber1', null, null);
insert into T_APPLICATION_TEMPLATE (id, segment_code, segment_name, column_name, column_type, is_request, remarks, custom_sql, segment_type, order_sort, date_time, status, in_out, is_join, join_code, application_id, field_name, field_type, arithmetic)
values ('64D6955C5373468B8EF6246BCB6FEBDD', 'currency', '币种', 'column_char5', 'NVARCHAR2', 'Y', null, null, '字符', 6, to_timestamp('09-10-2020 14:38:05.614000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'OUT', 'N', null, '6525D9B9ADBF4C5EA8942607BBEFB985', 'columnChar5', null, null);
insert into T_APPLICATION_TEMPLATE (id, segment_code, segment_name, column_name, column_type, is_request, remarks, custom_sql, segment_type, order_sort, date_time, status, in_out, is_join, join_code, application_id, field_name, field_type, arithmetic)
values ('7C83B634792146F1B71E8BBDF8ADB328', 'accumulation', '是否累加', 'column_char6', 'NVARCHAR2', 'N', null, null, '字符', 7, to_timestamp('09-10-2020 14:43:00.069000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'OUT', 'N', null, '6525D9B9ADBF4C5EA8942607BBEFB985', 'columnChar6', null, null);
insert into T_APPLICATION_TEMPLATE (id, segment_code, segment_name, column_name, column_type, is_request, remarks, custom_sql, segment_type, order_sort, date_time, status, in_out, is_join, join_code, application_id, field_name, field_type, arithmetic)
values ('6FE1C043AE3743F8856B91E10BBD30A0', 'startTime', '开始时间', 'column_date1', 'TIMESTAMP', 'N', null, null, '时间', 8, to_timestamp('09-10-2020 14:46:15.588000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'OUT', 'N', null, '6525D9B9ADBF4C5EA8942607BBEFB985', 'columnDate1', null, '< sysdate');
insert into T_APPLICATION_TEMPLATE (id, segment_code, segment_name, column_name, column_type, is_request, remarks, custom_sql, segment_type, order_sort, date_time, status, in_out, is_join, join_code, application_id, field_name, field_type, arithmetic)
values ('67B0A6C5B07044D5A3330A05243FC980', 'endTime', '结束时间', 'column_date2', 'TIMESTAMP', 'N', null, null, '时间', 9, to_timestamp('09-10-2020 14:46:41.451000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', 'OUT', 'N', null, '6525D9B9ADBF4C5EA8942607BBEFB985', 'columnDate2', null, '> sysdate');
commit;
insert into T_OBJECT_DATA (id, column_char1, column_char2, column_char3, column_char4, column_char5, column_char6, column_char7, column_char8, column_char9, column_char10, column_char11, column_char12, column_char13, column_char14, column_char15, column_number1, column_number2, column_number3, column_number4, column_number5, column_number6, column_date1, column_date2, column_date3, column_date4, hash_code, application_id)
values ('475acfef00d44f8b90e5901ba689ed54', '001', '002', '003', '004', 'CNY', 'Y', null, null, null, null, null, null, null, null, null, 200, null, null, null, null, null, to_timestamp('12-10-2020 14:40:39.643000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('31-12-2021 23:59:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null, null, 3847194711, '6525D9B9ADBF4C5EA8942607BBEFB985');
insert into T_OBJECT_DATA (id, column_char1, column_char2, column_char3, column_char4, column_char5, column_char6, column_char7, column_char8, column_char9, column_char10, column_char11, column_char12, column_char13, column_char14, column_char15, column_number1, column_number2, column_number3, column_number4, column_number5, column_number6, column_date1, column_date2, column_date3, column_date4, hash_code, application_id)
values ('8dfae1aae9dd4fcdb7deed0fd5e1945d', '001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, to_timestamp('12-10-2020 14:40:39.643000', 'dd-mm-yyyy hh24:mi:ss.ff'), to_timestamp('31-12-2021 23:59:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), null, null, 3810636176, '6525D9B9ADBF4C5EA8942607BBEFB985');
commit;