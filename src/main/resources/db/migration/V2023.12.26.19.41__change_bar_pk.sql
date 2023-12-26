alter table masil.bar
    modify if exists id bigint;
ALTER TABLE masil.bar DROP PRIMARY KEY, ADD PRIMARY KEY (vendor_id);
alter table masil.bar
    drop if exists id;
