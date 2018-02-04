CREATE TABLE "client" (
  "client_id" serial NOT NULL,
  "client_name" character varying NOT NULL UNIQUE,
  "client_password" character varying NOT NULL,
  "client_email" character varying(40) NOT NULL UNIQUE,
  "client_is_admin" BOOLEAN NOT NULL,
  CONSTRAINT client_pk PRIMARY KEY ("client_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "account" (
  "account_id" serial NOT NULL,
  "account_status" BOOLEAN NOT NULL,
  "account_client_id" int4 NOT NULL,
  "account_money" money ,
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
  "check_request_id" int4 NOT NULL ,
  CONSTRAINT check_pk PRIMARY KEY ("check_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "request" (
  "request_id" serial NOT NULL,
  "request_from_acc_number" bigint NOT NULL,
  "request_to_acc_number" bigint NOT NULL,
  "request_unique_number" int4 NOT NULL,


  CONSTRAINT request_pk PRIMARY KEY ("request_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "type_operation" (
  "type_operation_id" serial NOT NULL,
  "type_operation_value" character varying NOT NULL UNIQUE ,
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



CREATE TABLE "token" (
  "token_id" serial NOT NULL,
  "token_token" character varying NOT NULL UNIQUE ,
  "token_status" BOOLEAN NOT NULL,
  "token_check_id" int4 NOT NULL,

  CONSTRAINT token_pk PRIMARY KEY ("token_id")
) WITH (
OIDS=FALSE
);




ALTER TABLE "account" ADD CONSTRAINT "account_fk0" FOREIGN KEY ("account_client_id") REFERENCES "client"("client_id");

ALTER TABLE "check" ADD CONSTRAINT "check_fk0" FOREIGN KEY ("check_type_operation_id") REFERENCES "type_operation"("type_operation_id");

ALTER TABLE "check" ADD CONSTRAINT "check_fk1" FOREIGN KEY ("check_request_id") REFERENCES "request"("request_id");


ALTER TABLE "history" ADD CONSTRAINT "history_fk0" FOREIGN KEY ("history_type_operation_id") REFERENCES "type_operation"("type_operation_id");
ALTER TABLE "history" ADD CONSTRAINT "history_fk1" FOREIGN KEY ("history_account_id") REFERENCES "account"("account_id");

ALTER TABLE "token" ADD CONSTRAINT "token_fk0" FOREIGN KEY ("token_check_id") REFERENCES "check"("check_id");

INSERT INTO public.type_operation( type_operation_value)VALUES ('take off');
INSERT INTO public.type_operation( type_operation_value)VALUES ('received');