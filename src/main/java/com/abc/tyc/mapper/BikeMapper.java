package com.abc.tyc.mapper;

import com.abc.tyc.entity.Person;

public interface BikeMapper {
    int insertPerson(Person person);

    Person selectPersonByUsername(String username);
}
