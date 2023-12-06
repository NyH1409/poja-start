create table if not exists prime
(
    id varchar
        constraint prime_table_pk primary key,
    value text not null,
    creation_datetime timestamp not null
);

insert into dummy_uuid (id)
values ('dummy-uuid-id-1')
on conflict on constraint dummy_uuid_pk do nothing;