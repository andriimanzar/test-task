CREATE TABLE IF NOT EXISTS users
(
    id         identity,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    age        int          NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);
