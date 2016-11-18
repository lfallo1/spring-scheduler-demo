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
    VALUES ('lfallo1', 'lance@gmail.com', '1986-10-12'),('kara023', 'kara@gmail.com', '1990-2-18'),('bob998', 'bob@gmail.com', '1980-5-18'),('george109', 'george109@gmail.com', '1968-8-13'),('harry2923', 'harry3234@gmail.com', '1995-5-28');