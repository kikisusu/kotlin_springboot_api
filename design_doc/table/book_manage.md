```mermaid
erDiagram

  books ||--o{ authors : ""

  books {
    CHAR(13) isbn_code(NOT_NULL) PK "ISBNコード"
    VARCHAR(256) title(NOT_NULL) "タイトル"
    DATETIME registration_datetime(NOT_NULL) "登録日時"
    DATETIME update_datetime "更新日時"
  }

  authors {
    BIGINT(AUTO_INCREMENT) id(NOT_NULL) PK "ID"
    CHAR(13) isbn_code(NOT_NULL) FK "ISBNコード"
    VARCHAR(64) name(NOT_NULL) "著者名"
    DATETIME registration_datetime(NOT_NULL) "登録日時"
    DATETIME update_datetime "更新日時"
  }

```