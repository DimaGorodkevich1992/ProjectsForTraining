CREATE TABLE "users" (
  "users_id" BIGSERIAL NOT NULL,
  "users_name" character varying NOT NULL UNIQUE,
  "users_password" character varying NOT NULL,
  "users_email" character varying(40) NOT NULL UNIQUE,
  "users_is_admin" BOOLEAN NOT NULL,
  CONSTRAINT users_pk PRIMARY KEY ("users_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "account" (
  "account_id" BIGSERIAL NOT NULL,
  "account_status" BOOLEAN NOT NULL,
  "account_users_id" bigint NOT NULL,
  "account_money" INT NOT NULL,
  "account_number" bigint NOT NULL UNIQUE,
  CONSTRAINT account_pk PRIMARY KEY ("account_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "type_operation" (
  "type_operation_id" BIGSERIAL NOT NULL,
  "type_operation_value" character varying NOT NULL,
  CONSTRAINT type_operation_pk PRIMARY KEY ("type_operation_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "history" (
  "history_id" BIGSERIAL NOT NULL,
  "history_type_operation_id" bigint NOT NULL,
  "history_account_id" bigint NOT NULL,
  "history_money" INT NOT NULL,
  "history_time" timestamp with time zone NOT NULL,
  CONSTRAINT history_pk PRIMARY KEY ("history_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "validate" (
  "validate_id" BIGSERIAL NOT NULL,
  "validate_token" character varying NOT NULL UNIQUE,
  "validate_key" BIGINT NOT NULL,
  "validate_status" BOOLEAN NOT NULL,
  CONSTRAINT validate_pk PRIMARY KEY ("validate_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "cheque" (
  "cheque_id" BIGSERIAL NOT NULL,
  "cheque_money" INT NOT NULL,
  "cheque_time" timestamp with time zone NOT NULL,
  "cheque_validate_id" bigint NOT NULL,
  "cheque_type_operation_id" bigint NOT NULL,
  CONSTRAINT cheque_pk PRIMARY KEY ("cheque_id")
) WITH (
OIDS=FALSE
);



CREATE TABLE "request" (
  "request_id" BIGSERIAL NOT NULL,
  "request_from_acc_number" bigint NOT NULL,
  "request_to_acc_number" bigint NOT NULL,
  "request_validate_id" bigint NOT NULL,
  CONSTRAINT request_pk PRIMARY KEY ("request_id")
) WITH (
OIDS=FALSE
);




ALTER TABLE "account" ADD CONSTRAINT "account_fk0" FOREIGN KEY ("account_users_id") REFERENCES "users"("users_id");


ALTER TABLE "history" ADD CONSTRAINT "history_fk0" FOREIGN KEY ("history_type_operation_id") REFERENCES "type_operation"("type_operation_id");
ALTER TABLE "history" ADD CONSTRAINT "history_fk1" FOREIGN KEY ("history_account_id") REFERENCES "account"("account_id");


ALTER TABLE "cheque" ADD CONSTRAINT "cheque_fk0" FOREIGN KEY ("cheque_validate_id") REFERENCES "validate"("validate_id");
ALTER TABLE "cheque" ADD CONSTRAINT "cheque_fk1" FOREIGN KEY ("cheque_type_operation_id") REFERENCES "type_operation"("type_operation_id");

ALTER TABLE "request" ADD CONSTRAINT "request_fk0" FOREIGN KEY ("request_validate_id") REFERENCES "validate"("validate_id");


INSERT INTO public.type_operation (type_operation_value) VALUES ('take off');
INSERT INTO public.type_operation (type_operation_value) VALUES ('received');
