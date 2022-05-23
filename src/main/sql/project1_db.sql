CREATE TABLE Person(
   id int AUTO_INCREMENT,
   full_name varchar(100) NOT NULL UNIQUE,
   year_of_birth int NOT NULL,
   PRIMARY KEY(id)
);

CREATE TABLE Book(
    id int AUTO_INCREMENT,
    title varchar(100) NOT NULL,
    author varchar(100) NOT NULL,
    year int NOT NULL ,
    person_id int REFERENCES Person(id) ON DELETE SET NULL,
    PRIMARY KEY(id)
);

select * from Book;