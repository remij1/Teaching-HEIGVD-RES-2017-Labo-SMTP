package ch.heigvd.jacquemardlevy.prankmail.model;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Remi on 04.04.2017.
 */
public class Group {

    LinkedList<Person> persons = new LinkedList<Person>();

    public void addPerson(Person person){
        this.persons.add(person);
    }

}
