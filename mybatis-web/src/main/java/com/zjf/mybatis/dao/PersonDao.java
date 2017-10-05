package com.zjf.mybatis.dao;

import com.zjf.mybatis.model.Person;

import java.util.List;

/**
 * Created by Administrator on 2017/9/30.
 */
public interface PersonDao {
    Person selectPersonByID(Long id);

    List<Person> selectAll();

   List<Person> selectPersonByName(String userName);

   void addPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(int id);
}
