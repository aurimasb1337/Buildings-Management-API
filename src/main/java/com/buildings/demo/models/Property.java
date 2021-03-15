package com.buildings.demo.models;

import com.buildings.demo.common.Common;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Property {
    private String address;

    public Property() {
    }


    public long getId() {
        return id;
    }

    private @Id
    @GeneratedValue(strategy= GenerationType.AUTO) long id;
    private String propertyType;

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ManyToOne
    @JsonIgnore
    protected Person person;

    public String getAddress() {
        return address;
    }
    public double getYearlyRate(){
        double result = 0;
        if(propertyType.equals("House"))
        result = marketValue*Common.HOUSE_RATE;

        else if(propertyType.equals("Apartment"))
            result = marketValue*Common.HOUSE_RATE;

        else result = marketValue*Common.INDUSTRIAL_RATE;

        return result;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(int marketValue) {
        this.marketValue = marketValue;
    }

    private int size;

    public Property(String address, String propertyType, int size, int marketValue) {
        this.address = address;

        this.propertyType = propertyType;
        this.size = size;
        this.marketValue = marketValue;
    }

    private int marketValue;
}
