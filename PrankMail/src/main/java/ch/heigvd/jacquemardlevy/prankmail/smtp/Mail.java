package ch.heigvd.jacquemardlevy.prankmail.smtp;

import java.util.LinkedList;

/**
 * Created by Remi on 04.04.2017.
 */
public class Mail {

    private String from;
    private LinkedList<String> to;
    private String message;
    private String subject;


    public Mail(String from, LinkedList<String> to, String message, String subject) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LinkedList<String> getTo() {
        return to;
    }

    public void setTo(LinkedList<String> to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
