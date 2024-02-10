USE book_manage;

INSERT IGNORE INTO
    books (isbn_code, title, registration_datetime)
VALUES
    ('9781234567890', 'Book Title 1', NOW()),
    ('9781234567891', 'Book Title 2', NOW()),
    ('9781234567892', 'Book Title 3', NOW()),
    ('9781234567893', 'Book Title 4', NOW()),
    ('9781234567894', 'Book Title 5', NOW()),
    ('9781234567895', 'Book Title 6', NOW()),
    ('9781234567896', 'Book Title 7', NOW()),
    ('9781234567897', 'Book Title 8', NOW()),
    ('9781234567898', 'Book Title 9', NOW()),
    ('9781234567899', 'Book Title 10', NOW());

INSERT IGNORE INTO
    authors (isbn_code, name, registration_datetime)
VALUES
    ('9781234567890', 'Author Name 1', NOW()),
    ('9781234567891', 'Author Name 2', NOW()),
    ('9781234567892', 'Author Name 3', NOW()),
    ('9781234567893', 'Author Name 4', NOW()),
    ('9781234567894', 'Author Name 5', NOW()),
    ('9781234567895', 'Author Name 6', NOW()),
    ('9781234567896', 'Author Name 7', NOW()),
    ('9781234567897', 'Author Name 8', NOW()),
    ('9781234567898', 'Author Name 9', NOW()),
    ('9781234567899', 'Author Name 10', NOW());