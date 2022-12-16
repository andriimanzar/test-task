CREATE TABLE IF NOT EXISTS users
(
    id         IDENTITY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    birth_date DATE         NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);
