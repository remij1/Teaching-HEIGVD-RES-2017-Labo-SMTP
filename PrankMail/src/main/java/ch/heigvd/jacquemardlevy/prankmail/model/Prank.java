package ch.heigvd.jacquemardlevy.prankmail.model;

import ch.heigvd.jacquemardlevy.prankmail.smtp.Mail;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Remi on 04.04.2017.
 */
public class Prank {

    private LinkedList<Person> to;
    private Person from;
    private String message;

    private static Random random = new Random();
    private String subject;

    public Prank(LinkedList<Person> persons, String message, String subject){
        if(persons.size() < 3) {
            throw new IllegalArgumentException("There should be at least 3 persons.");
        }

        this.message = message;
        this.subject = subject;

        //We work on a copy of the persons
        to = new LinkedList<>(persons);

        //Get the sender randomly
        int fromIndex = random.nextInt(to.size());
        from = to.remove(fromIndex);
    }

    public Mail createMail(){
        LinkedList<String> toAddress = new LinkedList<>();
        for(Person p : to){
            toAddress.add(p.getAddress());
        }

        return new Mail(from.getAddress(), toAddress, message, subject);
    }

}
