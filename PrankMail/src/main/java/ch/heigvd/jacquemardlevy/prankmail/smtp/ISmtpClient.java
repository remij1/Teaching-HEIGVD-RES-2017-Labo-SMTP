package ch.heigvd.jacquemardlevy.prankmail.smtp;

import java.io.IOException;

/**
 * Created by Remi on 04.04.2017.
 */
public interface ISmtpClient {

    public void sendMail(Mail mail) throws IOException;
}
