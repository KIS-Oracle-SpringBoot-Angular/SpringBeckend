create or replace NONEDITIONABLE PROCEDURE validate_email (email VARCHAR2) AS
exc EXCEPTION;
Big_disc EXCEPTION;
countt number;
BEGIN

SELECT COUNT(email) INTO countt FROM dual WHERE REGEXP_LIKE(email, '(\D+?)\1');

IF (countt > 0) THEN RAISE exc;
END IF;

EXCEPTION
WHEN exc THEN
	Raise_application_error (-20002, 'REPEATABLE SYMBOLS');
END;