package com.buildings.demo.services;

import com.buildings.demo.models.Person;
import com.buildings.demo.repositories.PersonRepository;
import com.buildings.demo.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PropertyRepository propertyRepository;



    public List getAllPersons(){
        List results = new ArrayList<>();
        personRepository.findAll().forEach(person -> {results.add(person);});
        return results;
    }

    public void addPerson(Person p){
        personRepository.save(p);
    }
    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
    public Optional<Person> getPersonById(Long id){
       return personRepository.findById(id);
    }

}
