package ch.heigvd.jacquemardlevy.prankmail.model;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;

/**
 * Created by Remi on 05.04.2017.
 */
public class Message {

    private String subject;
    private String message;

    public Message(String subject, String message){
        this.subject = subject;
        this.message = message;
    }


    public static LinkedList<Message> getMessagesFromFile(String path) throws IOException {
        return getMessagesFromFile(new File(path));
    }


    public static LinkedList<Message> getMessagesFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
        LinkedList<Message> messages = new LinkedList<>();


        String line;
        while ((line = reader.readLine()) != null) {
            //The first line is the subject
            String subject = line;

            String message = "";
            //The characters to separate messages is '=='
            while ((line = reader.readLine()) != null && !line.startsWith("==")) {
                message += line + '\n';
            }

            //Here, the message has been fully read
            messages.add(new Message(subject, message));

        }

        reader.close();

        return messages;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
