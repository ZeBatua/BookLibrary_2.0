create table Member (
    member_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(100) NOT NULL UNIQUE,
    birthDay varchar(10) NOT NULL
);

CREATE TABLE Book (
    book_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    member_id int REFERENCES Member(member_id) ON DELETE SET NULL,
    name varchar(100) NOT NULL,
    author varchar(100) NOT NULL,
    year int NOT NULL
);

insert into member(name, birthDay) values ('Савельева Дарья Григорьевна', '26.08.1996');
insert into member(name, birthDay) values ('Ильин Александр Арсентьевич', '29.03.1972');
insert into member(name, birthDay) values ('Круглова Василиса Николаевна', '10.07.1970');
insert into member(name, birthDay) values ('Иванова Зоя Михайловна', '29.12.1969');
insert into member(name, birthDay) values ('Коновалова Марта Фёдоровна', '11.02.1987');
insert into member(name, birthDay) values ('Денисова Вероника Александровна', '21.11.1975');
insert into member(name, birthDay) values ('Антонова Мелания Владимировна', '30.09.1968');
insert into member(name, birthDay) values ('Белов Максим Тимофеевич', '26.05.1998');
insert into member(name, birthDay) values ('Крылова Вероника Фёдоровна', '26.05.1995');
insert into member(name, birthDay) values ('Некрасов Лев Константинович', '25.01.1999');

insert into book(member_id, name, author, year) values (1, 'Эффективная Java', 'Джошуа Блох', 2014);
insert into book(member_id, name, author, year) values (2, 'Чистый код: создание, анализ и рефакторинг', 'Мартин Роберт', 2022);
insert into book(member_id, name, author, year) values (3, 'Java. Библиотека профессионала', 'Кей С. Хорстманн', 2020);
insert into book(member_id, name, author, year) values (4, 'Head First. Паттерны проектирования', 'Эрик Фримен, Элизабет Робсон', 2018);
insert into book(member_id, name, author, year) values (5, 'Spring в действии', 'Крейг Уоллс', 2015);
insert into book(member_id, name, author, year) values (6, 'Test Driven: TDD and Acceptance TDD for Java Developers', 'Lasse Koskela', 2007);
insert into book(member_id, name, author, year) values (7, 'Изучаем Java', 'Кэти Сиерра, Берт Бейтс', 2012);
insert into book(member_id, name, author, year) values (8, 'Алгоритмы на Java', 'Роберт Седжвик, Кевин Уэйн', 2016);
insert into book(member_id, name, author, year) values (9, 'Head First Object-Oriented Analysis and Design', 'Brett D. McLaughlin', 2007);
insert into book(member_id, name, author, year) values (10, 'Java. Полное руководство', 'Герберт Шилдт', 2015);

-- (Аналогичное заполнение таблицы Book, только без привязки к пользователям)

-- insert into book(name, author, year) values ('Эффективная Java', 'Джошуа Блох', 2014);
-- insert into book(name, author, year) values ('Чистый код: создание, анализ и рефакторинг', 'Мартин Роберт', 2022);
-- insert into book(name, author, year) values ('Java. Библиотека профессионала', 'Кей С. Хорстманн', 2020);
-- insert into book(name, author, year) values ('Head First. Паттерны проектирования', 'Эрик Фримен, Элизабет Робсон', 2018);
-- insert into book(name, author, year) values ('Spring в действии', 'Крейг Уоллс', 2015);
-- insert into book(name, author, year) values ('Test Driven: TDD and Acceptance TDD for Java Developers', 'Lasse Koskela', 2007);
-- insert into book(name, author, year) values ('Изучаем Java', 'Кэти Сиерра, Берт Бейтс', 2012);
-- insert into book(name, author, year) values ('Алгоритмы на Java', 'Роберт Седжвик, Кевин Уэйн', 2016);
-- insert into book(name, author, year) values ('Head First Object-Oriented Analysis and Design', 'Brett D. McLaughlin', 2007);
-- insert into book(name, author, year) values ( 'Java. Полное руководство', 'Герберт Шилдт', 2015);

