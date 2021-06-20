CREATE TABLE CITY(
	CITY_ID NUMBER(9, 0),
	CITY_NAME VARCHAR2(100),

	CONSTRAINT "PK_CITY_ID" PRIMARY KEY ("CITY_ID")
);

CREATE SEQUENCE "CITY_ID_SEQ" MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1;

CREATE TABLE PERSONS(
    PERSON_ID NUMBER(9,0),
    CITY_ID NUMBER(9, 0),
    FIRST_NAME VARCHAR2(10),
    LAST_NAME VARCHAR2(64),
    EMAIL VARCHAR2(64),
    CONSTRAINT "PK_PERSON_ID" PRIMARY KEY("PERSON_ID"),
    CONSTRAINT "FK_CITY_ID" FOREIGN KEY("CITY_ID") REFERENCES "CITY" ("CITY_ID") ENABLE
);

CREATE SEQUENCE "CUSTOMER_ID_SEQ" MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1;