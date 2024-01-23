alter table bar_keyword drop foreign key IF EXISTS bar_keyword_keyword;
alter table bar_keyword drop column IF EXISTS keyword_id;
drop table if exists masil.keyword;

alter table masil.bar_keyword
    add column IF NOT EXISTS count INT NOT NULL DEFAULT 0;
