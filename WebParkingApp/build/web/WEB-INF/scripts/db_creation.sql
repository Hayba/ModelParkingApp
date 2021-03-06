DROP TABLE USERS;
CREATE TABLE USERS(
    ID BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    ROLE VARCHAR(200) NOT NULL,
    NAME VARCHAR(200) NOT NULL,
    LOGIN VARCHAR(20) NOT NULL,
    PASSWORDHASH BIGINT NOT NULL
);
INSERT INTO USERS VALUES(default,'ADMIN','Administrador','admin', 1509442);
INSERT INTO USERS VALUES(default,'OPERATOR','Fulano da Silva','fulano', 1509442);

DROP TABLE prices;
CREATE TABLE prices(
    id BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    timestamp TIMESTAMP NOT NULL,
    new_price DOUBLE PRECISION NOT NULL
);
DROP TABLE parking_periods;
CREATE TABLE parking_periods(
    ID BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    model varchar(50) not null,
    plante varchar(7) not null,
    begin_period TIMESTAMP not null,
    end_period TIMESTAMP,
    price DOUBLE PRECISION
);