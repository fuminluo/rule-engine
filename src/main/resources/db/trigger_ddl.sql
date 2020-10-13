create or replace trigger save_hashcode
  before insert or update
  on t_object_data
  FOR EACH ROW
declare
  v_column nvarchar2(2000);
  v_object_data t_object_data%rowtype;
  CURSOR cur_template IS
  SELECT t.* FROM t_application_template t
        WHERE t.application_id = :new.application_id
        ORDER BY t.order_sort;
begin

  v_object_data.id:= :new.id;
  v_object_data.column_char1:= :new.column_char1;
  v_object_data.column_char2:= :new.column_char2;
  v_object_data.column_char3:= :new.column_char3;
  v_object_data.column_char4:= :new.column_char4;
  v_object_data.column_char5:= :new.column_char5;
  v_object_data.column_char6:= :new.column_char6;
  v_object_data.column_char7:= :new.column_char7;
  v_object_data.column_char8:= :new.column_char8;
  v_object_data.column_char9:= :new.column_char9;
  v_object_data.column_char10:= :new.column_char10;
  v_object_data.column_char11:= :new.column_char11;
  v_object_data.column_char12:= :new.column_char12;
  v_object_data.column_char13:= :new.column_char13;
  v_object_data.column_char14:= :new.column_char14;
  v_object_data.column_char15:= :new.column_char15;
  v_object_data.application_id:= :new.application_id;
  v_object_data.column_number1:= :new.column_number1;
  v_object_data.column_number2:= :new.column_number2;
  v_object_data.column_number3:= :new.column_number3;
  v_object_data.column_number4:= :new.column_number4;
  v_object_data.column_number5:= :new.column_number5;
  v_object_data.column_number6:= :new.column_number6;

  v_column :=  v_object_data.application_id;

  for v_template in cur_template loop
    if('IN' = v_template.IN_OUT or 'INOUT' = v_template.IN_OUT) then

       if ('column_char1' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char1;
         end if;

       if ('column_char2' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char2;
         end if;

       if ('column_char3' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char3;
         end if;

       if ('column_char4' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char4;
         end if;

        if ('column_char5' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char5;
         end if;

        if ('column_char6' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char6;
         end if;

        if ('column_char7' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char7;
         end if;

        if ('column_char8' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char8;
         end if;

        if ('column_char9' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char9;
         end if;

        if ('column_char10' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char10;
         end if;

        if ('column_char11' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char11;
         end if;

        if ('column_char12' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char12;
         end if;

        if ('column_char13' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char13;
         end if;

        if ('column_char14' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char14;
         end if;

        if ('column_char15' = v_template.column_name) then
          v_column := v_column || v_object_data.column_char15;
         end if;

        if ('column_number1' = v_template.column_name) then
          v_column := v_column || v_object_data.column_number1;
         end if;

        if ('column_number2' = v_template.column_name) then
          v_column := v_column || v_object_data.column_number2;
         end if;

        if ('column_number3' = v_template.column_name) then
          v_column := v_column || v_object_data.column_number3;
         end if;

        if ('column_number4' = v_template.column_name) then
          v_column := v_column || v_object_data.column_number4;
         end if;

        if ('column_number5' = v_template.column_name) then
          v_column := v_column || v_object_data.column_number5;
         end if;

        if ('column_number6' = v_template.column_name) then
          v_column := v_column || v_object_data.column_number6;
         end if;

      end if;
   end loop;

  select ora_hash(v_column) into :new.hash_code from dual;

end save_hashcode;
