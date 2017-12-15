
/*
ALTER TABLE "users_history"
  DROP CONSTRAINT IF EXISTS "users_history_fk0";

ALTER TABLE "users_history"
  DROP CONSTRAINT IF EXISTS "users_history_fk1";

ALTER TABLE "users_card"
  DROP CONSTRAINT IF EXISTS "users_card_fk0";

ALTER TABLE "users_card"
  DROP CONSTRAINT IF EXISTS "users_card_fk1";

ALTER TABLE "card"
  DROP CONSTRAINT IF EXISTS "card_fk0";




DROP TABLE IF EXISTS "user_history";

DROP TABLE IF EXISTS "history";

DROP TABLE IF EXISTS "user_card";
DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS "card";

DROP TABLE IF EXISTS "account";
*/


CREATE TABLE "users_history" (
  "up_history_id" BIGINT NOT NULL,
  "up_users_id"   BIGINT NOT NULL
) WITH (
OIDS = FALSE
);


CREATE TABLE "history" (
  "history_id"               SERIAL                 NOT NULL,
  "history_type_operation"   CHARACTER VARYING(100) NOT NULL,
  "history_data_operation"   DATE                   NOT NULL,
  "history_time_operation"   TIME                   NOT NULL,
  "history_amount_operation" MONEY                  NOT NULL,
  CONSTRAINT history_pk PRIMARY KEY ("history_id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "users_card" (
  "uc_users_id" BIGINT NOT NULL,
  "uc_card_id"  BIGINT NOT NULL
) WITH (
OIDS = FALSE
);


CREATE TABLE "users" (
  "users_id"       SERIAL                 NOT NULL,
  "users_name"     CHARACTER VARYING(150) NOT NULL UNIQUE,
  "users_password" CHARACTER VARYING(50)  NOT NULL,
  "users_status"   BOOLEAN                NOT NULL DEFAULT TRUE ,
  "users_admin"    BOOLEAN                NOT NULL DEFAULT FALSE ,
  CONSTRAINT users_pk PRIMARY KEY ("users_id")
) WITH (
OIDS = FALSE
);


CREATE TABLE "card" (
  "card_id"         SERIAL NOT NULL,
  "card_number"     BIGINT NOT NULL UNIQUE,
  "card_account_id" BIGINT NOT NULL UNIQUE,
  CONSTRAINT card_pk PRIMARY KEY ("card_id")
) WITH (
OIDS = FALSE
);


ALTER TABLE "card"
  DROP CONSTRAINT IF EXISTS "card_fk0";
DROP TABLE IF EXISTS "account";
ALTER TABLE "card"
  ADD CONSTRAINT "card_fk0" FOREIGN KEY ("card_account_id") REFERENCES "account" ("account_id");

CREATE TABLE "account" (
  "account_id"     SERIAL  NOT NULL,
  "account_number" BIGINT  NOT NULL UNIQUE,
  "account_money"  NUMERIC   NOT NULL,
  "account_status" BOOLEAN NOT NULL DEFAULT TRUE ,
  CONSTRAINT account_pk PRIMARY KEY ("account_id")
) WITH (
OIDS = FALSE
);



ALTER TABLE "users_history"
  ADD CONSTRAINT "users_history_fk0" FOREIGN KEY ("up_history_id") REFERENCES "history" ("history_id");
ALTER TABLE "users_history"
  ADD CONSTRAINT "users_history_fk1" FOREIGN KEY ("up_users_id") REFERENCES "users" ("users_id");


ALTER TABLE "users_card"
  ADD CONSTRAINT "users_card_fk0" FOREIGN KEY ("uc_users_id") REFERENCES "users" ("users_id");
ALTER TABLE "users_card"
  ADD CONSTRAINT "users_card_fk1" FOREIGN KEY ("uc_card_id") REFERENCES "card" ("card_id");


ALTER TABLE "card"
  ADD CONSTRAINT "card_fk0" FOREIGN KEY ("card_account_id") REFERENCES "account" ("account_id");





