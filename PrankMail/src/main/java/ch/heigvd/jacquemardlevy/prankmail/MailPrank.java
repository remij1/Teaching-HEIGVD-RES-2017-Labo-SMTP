package ch.heigvd.jacquemardlevy.prankmail;

import ch.heigvd.jacquemardlevy.prankmail.smtp.ISmtpClient;
import ch.heigvd.jacquemardlevy.prankmail.smtp.Mail;
import ch.heigvd.jacquemardlevy.prankmail.smtp.SmtpClient;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Remi on 04.04.2017.
 */
public class MailPrank {

    public static void main(String ... args){
        LinkedList<String> to = new LinkedList<>();
        to.add("aurelie.levy@heig-vd.ch");

        ISmtpClient client = new SmtpClient("mailcl0.heig-vd.ch", 25);

        Mail m = new Mail("aurelie.levy@heig-vd.ch", to, "Coucou Aurélie ! Figure toi que j'ai fait un client SMTP ;P",
                "Concernant le prochain push");

        try {
            client.sendMail(m);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
