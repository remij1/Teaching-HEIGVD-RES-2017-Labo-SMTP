package ch.heigvd.jacquemardlevy.prankmail.model;

import ch.heigvd.jacquemardlevy.prankmail.config.ConfigurationManager;
import ch.heigvd.jacquemardlevy.prankmail.smtp.ISmtpClient;
import ch.heigvd.jacquemardlevy.prankmail.smtp.SmtpClient;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Remi on 04.04.2017.
 */
public class PrankGenerator {

    private ConfigurationManager configurationManager;
    private ISmtpClient smtpClient;


    public PrankGenerator() throws Exception {

        LinkedList<String> to = new LinkedList<>();

        configurationManager = new ConfigurationManager();
        ISmtpClient client = new SmtpClient(configurationManager.getServerAddress(), configurationManager.getServerPort(), "whatacompanyname.ch");


        //Getting the persons we wants
        LinkedList<Person> persons = Person.getPersonsFromFile(configurationManager.getAddressesPath());

        //Checking if there is enough persons
        if((double)persons.size() / (double)configurationManager.getNumberOfGroups() < 1){
            throw new Exception("There is not enough persons !");
        }

        //Getting the messages
        LinkedList<Message> messages = Message.getMessagesFromFile(configurationManager.getMessagesPath());

        //Creating Pranks-----
        





        /*
        Mail m = new Mail("aurelie.levy@heig-vd.ch", to, "Coucou Aurélie ! Figure toi que j'ai fait un client SMTP ;P",
                "Concernant le prochain push");

        try {
            client.sendMail(m);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }

    public void send() {
    }
}
