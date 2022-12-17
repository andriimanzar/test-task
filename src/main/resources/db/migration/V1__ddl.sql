CREATE TABLE IF NOT EXISTS users
(
    id         IDENTITY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    birth_date DATE         NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

INSERT INTO users(first_name, last_name, birth_date)
VALUES ('First_Name', 'Last_Name',
        '1999-10-10');
INSERT INTO users(first_name, last_name, birth_date)
VALUES ('First_Name#2', 'Last_Name#2',
        '1990-05-07');
INSERT INTO users(first_name, last_name, birth_date)
VALUES ('First_Name#3', 'Last_Name#3', '2003-02-01');
