create schema netology;

create table netology.PERSONS(

    name varchar(100) not null,
    surname varchar(200) not null,
    age int not null,
    phone_number int,
    city_of_living varchar(168),
    PRIMARY KEY (name, surname, age)
);

insert into PERSONS (name, surname, age, phone_number, city_of_living)
values ('Alexey', 'Bush', 25, '222-44-55', 'Moscow'),
('Jack', 'Arnold', 25, '+7843-205-54-87','Kazan'),
('Alex', 'Jeff', 25, '+7813-363-15-95', 'Novosibirsk' ),
('Oliver', 'Carey', 25, '+84007237', 'Omsk');