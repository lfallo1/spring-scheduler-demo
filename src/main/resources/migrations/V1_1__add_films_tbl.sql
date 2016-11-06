CREATE TABLE "film"
(
  id bigserial NOT NULL,
  title text NOT NULL,
  genre text NOT NULL,
  release date,
  CONSTRAINT user_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

INSERT INTO "film"(title, genre, release)
    VALUES ('Star Wars', 'Sci-fi', '1975-10-12'),('Super Troopers', 'Comedy', '2002-12-19');