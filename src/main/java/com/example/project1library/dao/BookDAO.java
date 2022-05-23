package com.example.project1library.dao;

import com.example.project1library.models.Book;
import com.example.project1library.models.Person;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    List<Book> index();

    Book show(int id);

    void save(Book book);

    void update(int id, Book updatedBook);

    void delete(int id);

    Optional<Person> getBookOwner(int id);

    void release(int id);

    void assign(int id, Person selectedPerson);


}
