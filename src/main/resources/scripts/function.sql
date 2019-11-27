create or replace NONEDITIONABLE FUNCTION count_name_length_more (lenhgt number)
RETURN INTEGER
IS temp_count number;
BEGIN 
SELECT COUNT(*) INTO temp_count FROM USER_TEST ut
       WHERE LENGTH(ut.name) > lenhgt; 
RETURN(temp_count);
END count_name_length_more;