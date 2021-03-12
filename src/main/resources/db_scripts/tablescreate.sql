create table "role"(
                       id serial primary key,
                       name varchar(20) not null unique
);

create table "usr"(
                      id serial primary key,
                      name varchar(100) not null,
                      address varchar(255) not null,
                      login varchar(50) not null unique,
                      password varchar(50) not null,
                      roleID integer references "role" (id)
);

create table "item"(
                       id serial primary key,
                       name varchar(255) not null,
                       description varchar(255) not null,
                       userid integer references "usr" (id)
);

create table "status"(
                         id serial primary key,
                         name varchar(20) not null unique
);

create table "auction_lot"(
                              id serial primary key,
                              itemid integer references "item" (id),
                              startprice numeric default 0.0,
                              bid_inc numeric not null,
                              bestoffer numeric,
                              bidderid integer references "usr" (id),
                              stopdate date not null,
                              statusid integer references "status" (id)
);