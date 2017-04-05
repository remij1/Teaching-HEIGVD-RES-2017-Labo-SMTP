package ch.heigvd.jacquemardlevy.prankmail.model;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;

/**
 * Created by Remi on 04.04.2017.
 */
public class Person {

    private String address;

    public Person(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }


    public static LinkedList<Person> getPersonsFromFile(String path) throws IOException {
        return getPersonsFromFile(new File(path));
    }



    public static LinkedList<Person> getPersonsFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
        LinkedList<Person> persons = new LinkedList<>();

        //Creates a person from mail addresses
        String line;
        while( (line = reader.readLine()) != null){
            persons.add(new Person(line));
        }

        reader.close();

        return persons;
    }


}
