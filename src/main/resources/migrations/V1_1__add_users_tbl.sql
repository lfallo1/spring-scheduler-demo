CREATE TABLE "user"
(
  id bigserial NOT NULL,
  username text NOT NULL,
  email text NOT NULL,
  dob date,
  CONSTRAINT user_pk PRIMARY KEY (id),
  CONSTRAINT user_unique_email UNIQUE (email),
  CONSTRAINT user_unique_username UNIQUE (username)
)
WITH (
  OIDS=FALSE
);

INSERT INTO "user"(username, email, dob)
    VALUES ('lfallo1', 'lance@gmail.com', '1986-10-12'),('kara023', 'kara@gmail.com', '1990-2-18');