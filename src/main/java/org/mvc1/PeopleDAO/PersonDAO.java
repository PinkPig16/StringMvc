package org.mvc1.PeopleDAO;

import org.mvc1.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PersonCount;

    {
        people = new ArrayList<>();
        people.add(new Person(++PersonCount,"Igor"));
        people.add(new Person(++PersonCount,"Oleg"));
        people.add(new Person(++PersonCount,"Vlad"));
        people.add(new Person(++PersonCount,"Sanya"));
    }

    public Person showIndex(int id){
        for(Person person:people){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public List<Person> show(){
        return people;
    }

    public void save(Person person) {
        person.setId(++PersonCount);

        people.add(person);
    }

}
