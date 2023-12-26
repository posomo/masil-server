drop table if exists masil.keyword;

alter table masil.bar_keyword
    add column IF NOT EXISTS count INT NOT NULL DEFAULT 0;
