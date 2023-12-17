CREATE TABLE IF NOT EXISTS bar(
      vendor_id VARCHAR(255) PRIMARY KEY ,
      monday_start_time INT,
      monday_end_time INT,
      tuesday_start_time INT,
      tuesday_end_time INT,
      wednesday_start_time INT,
      wednesday_end_time INT,
      thursday_start_time INT,
      thursday_end_time INT,
      friday_start_time INT,
      friday_end_time INT,
      saturday_start_time INT,
      saturday_end_time INT,
      sunday_start_time INT,
      sunday_end_time INT,
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
      id VARCHAR(255) PRIMARY KEY ,
      name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS bar_keyword(
      id VARCHAR(255) PRIMARY KEY ,
      keyword_id VARCHAR(255),
      bar_vendor_id VARCHAR(255),
      name VARCHAR(255)
);


ALTER TABLE bar_menu ADD CONSTRAINT menu_bar FOREIGN KEY IF NOT EXISTS (bar_vendor_id) REFERENCES bar(vendor_id);
ALTER TABLE bar_photo ADD CONSTRAINT photo_bar FOREIGN KEY IF NOT EXISTS (bar_vendor_id) REFERENCES bar(vendor_id);
ALTER TABLE bar_keyword ADD CONSTRAINT bar_keyword_bar FOREIGN KEY IF NOT EXISTS (bar_vendor_id) REFERENCES bar(vendor_id);
ALTER TABLE bar_keyword ADD CONSTRAINT bar_keyword_keyword FOREIGN KEY IF NOT EXISTS (keyword_id) REFERENCES keyword(id);