--应用
insert into T_APPLICATION (id, application_name, application_code, remarks, date_time, status, parent_id, root_id, order_sort)
values ('6525D9B9ADBF4C5EA8942607BBEFB985', '出差补助标准', 'Travel Allowance', null, to_timestamp('09-10-2020 10:11:23.300000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', '4461CD66904741DBB9DB0111384163CC', '4461CD66904741DBB9DB0111384163CC', 2);
insert into T_APPLICATION (id, application_name, application_code, remarks, date_time, status, parent_id, root_id, order_sort)
values ('E3EB8F408D7243F09044AE3C64E6D507', '加班补助标准', 'Overtime Premium', null, to_timestamp('09-10-2020 10:12:47.392000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', '4461CD66904741DBB9DB0111384163CC', '4461CD66904741DBB9DB0111384163CC', 3);
insert into T_APPLICATION (id, application_name, application_code, remarks, date_time, status, parent_id, root_id, order_sort)
values ('4461CD66904741DBB9DB0111384163CC', '我的公司', 'MyCompany', null, to_timestamp('09-10-2020 09:05:52.824000', 'dd-mm-yyyy hh24:mi:ss.ff'), '1', '0', '0', 1);
commit;
--模板
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

--值集合数据
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('F4BA217776DB4D0081D1011E9D81B130', '6525D9B9ADBF4C5EA8942607BBEFB985', 'D002', 'String', null, '1', to_timestamp('19-10-2020 16:11:00.633000', 'dd-mm-yyyy hh24:mi:ss.ff'), '职级', 'classOfPositions', null, '高级', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('F4BA217776DB4D0081D1011E9D81B131', '6525D9B9ADBF4C5EA8942607BBEFB985', 'Y', 'String', null, '1', to_timestamp('19-10-2020 16:15:13.568000', 'dd-mm-yyyy hh24:mi:ss.ff'), '是否累加', 'accumulation', null, '是', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('F4BA217776DB4D0081D1011E9D81B132', '6525D9B9ADBF4C5EA8942607BBEFB985', 'N', 'String', null, '1', to_timestamp('19-10-2020 16:15:13.572000', 'dd-mm-yyyy hh24:mi:ss.ff'), '是否累加', 'accumulation', null, '否', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('211091D831A94EC39CE5435B749640D8', '6525D9B9ADBF4C5EA8942607BBEFB985', 'C003', 'String', null, '1', to_timestamp('20-10-2020 10:49:24.760000', 'dd-mm-yyyy hh24:mi:ss.ff'), '岗位', 'post', null, 'HR岗', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('1B7219D9FDB54AD4839B6DB38CCE8A5A', '6525D9B9ADBF4C5EA8942607BBEFB985', 'C004', 'String', null, '1', to_timestamp('20-10-2020 10:49:24.760000', 'dd-mm-yyyy hh24:mi:ss.ff'), '岗位', 'post', null, '会计主管', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('C35327C82CD7478EB4377F38E47A2D15', '6525D9B9ADBF4C5EA8942607BBEFB985', 'C005', 'String', null, '1', to_timestamp('20-10-2020 10:49:24.760000', 'dd-mm-yyyy hh24:mi:ss.ff'), '岗位', 'post', null, '业务员', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('340A1C0466FB4EDC9D133F2589620E5E', '6525D9B9ADBF4C5EA8942607BBEFB985', 'C006', 'String', null, '1', to_timestamp('20-10-2020 10:49:24.760000', 'dd-mm-yyyy hh24:mi:ss.ff'), '岗位', 'post', null, '总经理', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('67C6477E76EC4BB28CE9DFA16B858BCD', '6525D9B9ADBF4C5EA8942607BBEFB985', 'D003', 'String', null, '1', to_timestamp('20-10-2020 10:49:24.775000', 'dd-mm-yyyy hh24:mi:ss.ff'), '职及', 'classOfPositions', null, '高级', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('8EF9A75E5F354910956BC1773E6F26F4', '6525D9B9ADBF4C5EA8942607BBEFB985', 'D004', 'String', null, '1', to_timestamp('20-10-2020 10:49:24.775000', 'dd-mm-yyyy hh24:mi:ss.ff'), '职及', 'classOfPositions', null, '特级', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('ADC03FFEA3F34CEFBA500809050340EA', '6525D9B9ADBF4C5EA8942607BBEFB985', 'USD', 'String', null, '1', to_timestamp('20-10-2020 10:49:24.791000', 'dd-mm-yyyy hh24:mi:ss.ff'), '币种', 'currency', null, '美元', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('3312776D325F4C66BDC0563E2CFD1598', '6525D9B9ADBF4C5EA8942607BBEFB985', 'GBF', 'String', null, '1', to_timestamp('20-10-2020 10:49:24.791000', 'dd-mm-yyyy hh24:mi:ss.ff'), '币种', 'currency', null, '英镑', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('4A89B4EA414842D1A35E00CEF1656C5F', '6525D9B9ADBF4C5EA8942607BBEFB985', 'A001', 'String', null, '1', to_timestamp('16-10-2020 19:38:52.745000', 'dd-mm-yyyy hh24:mi:ss.ff'), '公司', 'company', null, '平安科技', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('54FB4CC7755142FE98C7A6E3E90641E1', '6525D9B9ADBF4C5EA8942607BBEFB985', 'A002', 'String', null, '1', to_timestamp('16-10-2020 19:38:52.745000', 'dd-mm-yyyy hh24:mi:ss.ff'), '公司', 'company', null, '平安寿险', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('F4BA217776DB4D0081D1011E9D81B117', '6525D9B9ADBF4C5EA8942607BBEFB985', 'C001', 'String', null, '1', to_timestamp('19-10-2020 16:08:47.098000', 'dd-mm-yyyy hh24:mi:ss.ff'), '岗位', 'post', null, '财务岗', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('F4BA217776DB4D0081D1011E9D81B128', '6525D9B9ADBF4C5EA8942607BBEFB985', 'C002', 'String', null, '1', to_timestamp('19-10-2020 16:09:43.726000', 'dd-mm-yyyy hh24:mi:ss.ff'), '岗位', 'post', null, '出纳岗', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('086BB2173BAA46489403A0C6297A7F1F', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B001', 'String', null, '1', to_timestamp('16-10-2020 20:55:51.160000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部1', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('F4BA217776DB4D0081D1011E9D81B129', '6525D9B9ADBF4C5EA8942607BBEFB985', 'D001', 'String', null, '1', to_timestamp('19-10-2020 16:11:00.633000', 'dd-mm-yyyy hh24:mi:ss.ff'), '职级', 'classOfPositions', null, '初级', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('F4BA217776DB4D0081D1011E9D81F667', '6525D9B9ADBF4C5EA8942607BBEFB985', 'CNY', 'String', null, '1', to_timestamp('16-10-2020 20:52:38.306000', 'dd-mm-yyyy hh24:mi:ss.ff'), '币种', 'currency', null, '人民币', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('F4BA217776DB4D0081D1011E9D81F66D', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B002', 'String', null, '1', to_timestamp('16-10-2020 20:52:38.306000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '市场部2', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('23672C1E593E4C9DA0CA7ED55D6EF17E', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B003', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部3', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('1BC0055C09E94F619D604B3E94D572BA', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B004', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部4', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('5F3206817EB941A0B4CD9C6E30900FF4', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B005', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部5', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('9ED551194DE94BA999D9638A917918EE', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B006', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部6', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('4245161291E14B3FB248CC03F3774093', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B007', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部7', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('AFC7C4C3E5F3468CAC3A739CA5E826AC', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B008', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部8', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('C2351A3266A54F72906E67DF7ABD6ED1', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B009', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部9', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('69D7B91C3EF441718DA18B4D5CC67F69', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B0010', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部10', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('162FC0EA4DD24E60A96804FE21C62F24', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B0011', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部11', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('E5B3B04D36844358AC0475E237901FF5', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B0012', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部12', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('8E6586A6ACEE4E93BD8F009DC3608159', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B0013', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部13', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('1E7B3B4B709044A698342F1FDDD9A0D2', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B0014', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部14', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('0C7F8020502446F5B18485E083D9AAFE', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B0015', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部15', '4461CD66904741DBB9DB0111384163CC');
insert into T_VALUE_SET (id, application_id, value_code, data_type, remarks, status, date_time, segment_name, segment_code, value_parent_code, value_name, root_id)
values ('0FCAD39A281048EA8FE9F653552A8D23', '6525D9B9ADBF4C5EA8942607BBEFB985', 'B0016', 'String', null, '1', to_timestamp('20-10-2020 10:34:42.923000', 'dd-mm-yyyy hh24:mi:ss.ff'), '部门', 'dept', null, '开发部16', '4461CD66904741DBB9DB0111384163CC');
commit;

