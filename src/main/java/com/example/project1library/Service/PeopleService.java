package com.example.project1library.Service;

import com.example.project1library.Repository.PersonRepository;
import com.example.project1library.models.Book;
import com.example.project1library.models.Person;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PersonRepository personRepository;

    @Autowired
    public PeopleService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> index(){
        return personRepository.findAll();
    }

    public Person show(int id){
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    @Transactional
    public void save(Person person){
        personRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }

    public Optional<Person> getPersonByFullName(String fullName){
        return personRepository.findByFullName(fullName);
    }

    public List<Book> getBooksByPersonId(int id){
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            Hibernate.initialize(person.get().getBooks());

            person.get().getBooks().forEach(book ->{
                long diffInMillies = Math.abs(book.getTakenAt().getTime() - new Date().getTime());
                // 864000000 милисекунд = 10 суток
                if(diffInMillies > 864000000){
                    book.setExpired(true);
                }
            });
            return person.get().getBooks();
        }else {
            return Collections.emptyList();
        }
    }

}
