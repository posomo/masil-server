CREATE TABLE IF NOT EXISTS bar_propose
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    common_address varchar(255) null,
    description text null,
    keywords varchar(255) null,
    proposed_at DATETIME
);

