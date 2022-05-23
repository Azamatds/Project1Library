package com.example.project1library.dao;

import com.example.project1library.models.Book;
import com.example.project1library.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDAO {
    List<Person> index();

    Person show(int id);

    void save(Person person);

    void update(int id, Person updatedPerson);

    void delete(int id);

    Optional<Person> getPersonByFullName(String fullName);

    List<Book> getBooksByPersonId(int id);
}
