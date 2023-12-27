CREATE TABLE IF NOT EXISTS editor_pick
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    bar_vendor_id   varchar(255) NOT NULL,
    one_line_review varchar(255) NOT NULL,
    main_text       text NULL,
    common_address  varchar(255) NOT NULL,
    editor_name     varchar(255) NOT NULL,
    published_at    datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

create table if not exists editor_pick_image
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    editor_pick_id BIGINT       NOT NULL,
    image_url      varchar(255) NOT NULL,
    FOREIGN KEY (editor_pick_id) REFERENCES editor_pick (id)
);

create table if not exists editor_pick_tag
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    editor_pick_id BIGINT       NOT NULL,
    tag            varchar(255) NOT NULL,
    FOREIGN KEY (editor_pick_id) REFERENCES editor_pick (id)
);


