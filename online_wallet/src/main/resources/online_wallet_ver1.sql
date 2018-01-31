CREATE TABLE "client" (
  "client_id" serial NOT NULL,
  "client_name" character varying NOT NULL UNIQUE,
  "client_password" character varying(40) NOT NULL,
  "client_email" character varying(40) NOT NULL UNIQUE,
  CONSTRAINT client_pk PRIMARY KEY ("client_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "account" (
  "account_id" serial NOT NULL,
  "account_status" BOOLEAN NOT NULL,
  "account_client_id" int4 NOT NULL,
  "account_money" money NOT NULL,
  "account_number" bigint NOT NULL UNIQUE,
  CONSTRAINT account_pk PRIMARY KEY ("account_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "check" (
  "check_id" serial NOT NULL,
  "check_money" money NOT NULL,
  "check_time" timestamp with time zone NOT NULL,
  "check_type_operation_id" int4 NOT NULL,
  CONSTRAINT check_pk PRIMARY KEY ("check_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "request" (
  "request_id" serial NOT NULL,
  "request_from_acc_number" bigint NOT NULL,
  "request_to_acc_number" bigint NOT NULL,
  "request_check_id" int4 NOT NULL,
  CONSTRAINT request_pk PRIMARY KEY ("request_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "type_operation" (
  "type_operation_id" serial NOT NULL,
  "type_operation_value" character varying NOT NULL,
  CONSTRAINT type_operation_pk PRIMARY KEY ("type_operation_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "history" (
  "history_id" serial NOT NULL,
  "history_type_operation_id" int4 NOT NULL,
  "history_account_id" int4 NOT NULL,
  "history_money" money NOT NULL,
  "history_time" timestamp with time zone NOT NULL,
  CONSTRAINT history_pk PRIMARY KEY ("history_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "validate" (
  "validate_id" serial NOT NULL,
  "validate_token" character varying NOT NULL,
  "validate_key" character varying NOT NULL,
  "validate_check_id" int4 NOT NULL,
  CONSTRAINT validate_pk PRIMARY KEY ("validate_id")
) WITH (
OIDS=FALSE
);




ALTER TABLE "account" ADD CONSTRAINT "account_fk0" FOREIGN KEY ("account_client_id") REFERENCES "client"("client_id");

ALTER TABLE "check" ADD CONSTRAINT "check_fk0" FOREIGN KEY ("check_type_operation_id") REFERENCES "type_operation"("type_operation_id");

ALTER TABLE "request" ADD CONSTRAINT "request_fk0" FOREIGN KEY ("request_check_id") REFERENCES "check"("check_id");


ALTER TABLE "history" ADD CONSTRAINT "history_fk0" FOREIGN KEY ("history_type_operation_id") REFERENCES "type_operation"("type_operation_id");
ALTER TABLE "history" ADD CONSTRAINT "history_fk1" FOREIGN KEY ("history_account_id") REFERENCES "account"("account_id");

ALTER TABLE "validate" ADD CONSTRAINT "validate_fk0" FOREIGN KEY ("validate_check_id") REFERENCES "check"("check_id");
