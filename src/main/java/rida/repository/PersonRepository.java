package rida.repository;

import rida.data.Person;

public interface PersonRepository {

    Person selectById(String id);
    void insert(Person person);
}
