package com.buildings.demo.services;

import com.buildings.demo.models.Person;
import com.buildings.demo.models.Property;
import com.buildings.demo.repositories.PersonRepository;
import com.buildings.demo.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PropertyRepository propertyRepository;

    public List getAllProperties(){
        List results = new ArrayList<>();
        propertyRepository.findAll().forEach(property -> results.add(property));
        return results;
    }
    public List getPropertiesByOwnerId  (Long id){
        List results = new ArrayList<>();
        propertyRepository.findAll().forEach(property ->
        {
            if(property.getPerson().getId().equals(id))
                results.add(property);
        });
        return results;
    }
    public void addProperty(Long id, Property p){
            Person person = personRepository.findById(id).get();
            p.setPerson(person);
            propertyRepository.save(p);
    }

    public Property getPropertyById (Long id){
      Property p = propertyRepository.findById(id).get();
      return p;
    }
    public void deletePropertyById(Long id){
        propertyRepository.deleteById(id);
    }

    public Property editProperty(Long id, Property property){
        propertyRepository.findAll().forEach(p ->
        {
            if(p.getId()==id) {
                p.setAddress(property.getAddress());
                p.setPropertyType(property.getPropertyType());
                p.setSize(property.getSize());
            }   propertyRepository.save(p);
        });
                return property;
    }

}
