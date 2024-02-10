USE book_manage;

CREATE TABLE IF NOT EXISTS books (
    isbn_code CHAR(13) NOT NULL PRIMARY KEY,
    title VARCHAR(256) NOT NULL,
    registration_datetime DATETIME NOT NULL,
    update_datetime DATETIME
);

CREATE TABLE IF NOT EXISTS authors (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    isbn_code CHAR(13) NOT NULL,
    name VARCHAR(64) NOT NULL,
    registration_datetime DATETIME NOT NULL,
    update_datetime DATETIME,
    FOREIGN KEY (isbn_code) REFERENCES books(isbn_code)
);
