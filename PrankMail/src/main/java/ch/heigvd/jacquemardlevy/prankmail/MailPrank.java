package ch.heigvd.jacquemardlevy.prankmail;

import ch.heigvd.jacquemardlevy.prankmail.config.ConfigurationManager;
import ch.heigvd.jacquemardlevy.prankmail.model.PrankGenerator;
import ch.heigvd.jacquemardlevy.prankmail.smtp.ISmtpClient;
import ch.heigvd.jacquemardlevy.prankmail.smtp.Mail;
import ch.heigvd.jacquemardlevy.prankmail.smtp.SmtpClient;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Remi on 04.04.2017.
 */
public class MailPrank {

    public static void main(String ... args) throws IOException {

        try {
            new PrankGenerator().send();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
