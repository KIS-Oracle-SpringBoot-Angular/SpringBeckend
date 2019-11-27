create or replace NONEDITIONABLE PROCEDURE insert_user_t (new_name VARCHAR2) AS 
BEGIN 
INSERT INTO user_test  VALUES (user_test_seq.NEXTVAL, CONCAT(LOWER(new_name),'@domain.com'), new_name);
END insert_user_t;