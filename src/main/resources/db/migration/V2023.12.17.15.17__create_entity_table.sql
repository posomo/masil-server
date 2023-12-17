CREATE TABLE IF NOT EXISTS bar(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
  vendor_id VARCHAR(255) UNIQUE ,
  road_address VARCHAR(255),
  local_address VARCHAR(255),
  common_address VARCHAR(255),
  phone_number VARCHAR(255),
  latitude DOUBLE,
  longitude DOUBLE,
  category VARCHAR(255),
  star_rating DOUBLE,
  description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS bar_menu(
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(255),
   price INT,
   bar_vendor_id VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS bar_photo(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    url VARCHAR(255),
    bar_vendor_id VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS keyword(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS bar_keyword(
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  keyword_id VARCHAR(255),
  bar_vendor_id VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS bar_opening_hour
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    monday    BOOLEAN,
    tuesday   BOOLEAN,
    wednesday BOOLEAN,
    thursday  BOOLEAN,
    friday    BOOLEAN,
    saturday  BOOLEAN,
    sunday    BOOLEAN,
    type      VARCHAR(15) COMMENT '영업시간, 휴업, 브레이크타임',
    bar_vendor_id VARCHAR(255),
    start_time VARCHAR(20),
    end_time VARCHAR(20)

);

ALTER TABLE bar_keyword ADD COLUMN IF NOT EXISTS name VARCHAR(255);

ALTER DATABASE masil CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

ALTER TABLE bar_opening_hour CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE bar_menu CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE bar_photo CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE bar_keyword CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE keyword CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE bar CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
