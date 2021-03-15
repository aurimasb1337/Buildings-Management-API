package com.buildings.demo.controllers;


import com.buildings.demo.models.Person;
import com.buildings.demo.models.Property;
import com.buildings.demo.services.PersonService;
import com.buildings.demo.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    PropertyService propertyService;
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List getAllPersons(){
        return personService.getAllPersons();
    }

    @PostMapping("/persons")
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping("persons/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    @DeleteMapping("persons/{id}")
    public void deletePersonById(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @GetMapping("/persons/{id}/properties")
        public List<Property> getPropertiesOfOwner(@PathVariable Long id){
        return propertyService.getPropertiesByOwnerId(id);
    }

    @PostMapping("/persons/{id}/properties")
    public void addProperty(@PathVariable Long id, @RequestBody Property property){
        propertyService.addProperty(id, property);
    }


    @GetMapping("/persons/{id}/properties/{id}")
    public Property getPropetyById(@PathVariable Long id){
        return propertyService.getPropertyById(id);
    }

    @DeleteMapping("/persons/{id}/properties/{id}")
    public void  deletePropertyById(@PathVariable Long id){
         propertyService.deletePropertyById(id);
    }

    @PutMapping("/persons/{id}/properties/{id}")
    public void  editProperty(@PathVariable Long id, @RequestBody Property property){
        propertyService.editProperty(id, property);
    }
}
