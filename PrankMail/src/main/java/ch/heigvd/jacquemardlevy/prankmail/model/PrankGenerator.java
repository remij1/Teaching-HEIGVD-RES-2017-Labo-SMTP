package ch.heigvd.jacquemardlevy.prankmail.model;

import ch.heigvd.jacquemardlevy.prankmail.config.ConfigurationManager;
import ch.heigvd.jacquemardlevy.prankmail.smtp.ISmtpClient;
import ch.heigvd.jacquemardlevy.prankmail.smtp.Mail;
import ch.heigvd.jacquemardlevy.prankmail.smtp.SmtpClient;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Remi on 04.04.2017.
 */
public class PrankGenerator {

    private ConfigurationManager configurationManager;
    private ISmtpClient smtpClient;

    private static Random random = new Random();
    private LinkedList<Prank> pranks = new LinkedList<>();

    public PrankGenerator() throws Exception {

        LinkedList<String> to = new LinkedList<>();

        configurationManager = new ConfigurationManager();
        smtpClient = new SmtpClient(configurationManager.getServerAddress(), configurationManager.getServerPort(), "whatacompanyname.ch");


        //Getting the persons we wants
        LinkedList<Person> persons = Person.getPersonsFromFile(configurationManager.getAddressesPath());

        //Checking if there is enough persons
        if((double)persons.size() / (double)configurationManager.getNumberOfGroups() < 3.0){
            throw new Exception("There is not enough persons !");
        }

        int peoplePerGroup = persons.size()/configurationManager.getNumberOfGroups();

        //Getting the messages
        LinkedList<Message> messages = Message.getMessagesFromFile(configurationManager.getMessagesPath());

        //Creating Pranks-----
        for(int i = 0; i < configurationManager.getNumberOfGroups(); i++){
            LinkedList<Person> group = new LinkedList<>();

            //Adding members
            for(int j = 0; j < peoplePerGroup; j++){
                group.add(persons.remove(random.nextInt(persons.size())));
            }

            //Looking for the message
            Message message = messages.get(random.nextInt(messages.size()));

            //Creating the pranks
            pranks.add(new Prank(group, message.getMessage(), message.getSubject()));
        }

    }

    public void send() throws IOException {
        for(Prank prank : pranks){
            smtpClient.sendMail(prank.createMail());
        }
    }
}
