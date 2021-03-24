insert into "status" (name)
values ('ACTIVE'), ('CLOSED');

insert into "role" (name)
values ('ADMIN'), ('USER');

insert into "usr" (name, address, login, password, roleid)
values ('Ivan ivanov', 'Syktyvkar, Pushkin street, 4', 'Beetle', 'Beetle', 1),
       ('Vasya Pupkin', 'Saratov, Moskovskaya street, 1', 'AppleBoy', 'AppleBoy', 2),
       ('Mariya Morozova', 'Barnaul, Pervomaiskaya street, 823', 'Sunny', 'Sunny', 2),
       ('Pavel Morozov', 'Barnaul, Pervomaiskaya street, 823', 'Cloudy', 'Cloudy', 2);

insert into "item" (name, description, userid)
values ('Pen', 'Good pen', 2),
       ('Stone axe', 'Best thing', 2),
       ('Pyramid', 'Egypt pyramid', 3),
       ('Mirror', 'Some description', 3),
       ('Umbrella', 'Some description some description some description', 3),
       ('boyarsky mustache', 'Become successful', 4),
       ('Michalkov mustache', 'Become successful', 4);

insert into "auction_lot" (itemid, startprice, bid_inc, bestoffer, bidderid, stopdate, statusid)
values (1, 0.0, 1.0, 2.0, 4, '06-02-2021', 1),
       (2, 15.0, 10.0, 35.0, 4, '08-02-2021', 1),
       (3, 0.0, 0.2, 2.2, 2, '05-02-2021', 1),
       (6, 45000.0, 1000.0, 50000.0, 1, '03-31-2021', 1),
       (7, 80000.0, 1500.0, 100000.0, 1, '03-31-2021', 1);

insert into "auction_lot" (itemid, startprice, bid_inc, stopdate, statusid)
values (4, 20.5, 6.5, '02-15-2021', 1),
       (5, 35.0, 20.0, '02-17-2021', 1);
