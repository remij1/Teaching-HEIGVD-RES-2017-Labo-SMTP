package ch.heigvd.jacquemardlevy.prankmail.smtp;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * Created by Remi on 04.04.2017.
 */
public class SmtpClient implements ISmtpClient {

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    private final String server;
    private final int port;
    private final String senderAddress;

    private final Charset ENCODING = Charset.forName("UTF-8");
    private final String END_OF_LINE = "\r\n";

    public SmtpClient(String server, int port, String senderAddress) {
        this.server = server;
        this.port = port;
        this.senderAddress = senderAddress;
    }

    private void connect() throws IOException {
        socket = new Socket(server, port);

        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), ENCODING))){
            @Override
            public void println() { //Used to change the end-of-line char
                write(END_OF_LINE);
            }
        };
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), ENCODING));
    }

    private void disconnect() throws IOException {
        writer.close();
        reader.close();
        socket.close();

        writer = null;
        reader = null;
        socket = null;

    }

    private void waitNext() throws IOException {
        writer.flush();
        String response;

        do {
            response = reader.readLine();
            System.out.println(response);
        }
        while (response.charAt(3) != ' ');
    }

    public void sendMail(Mail mail) throws IOException {
        connect();
        waitNext();

        //Connection---
        writer.println("EHLO " + senderAddress);
        waitNext();

        writer.println("MAIL FROM: " + mail.getFrom());
        waitNext();

        for (String address : mail.getTo()) {
            writer.println("RCPT TO: " + address);
            waitNext();
        }

        //Data---
        writer.println("DATA");
        waitNext();

        writer.println("From: " + mail.getFrom());

        writer.print("To: ");
        for (int i = 0; i < mail.getTo().size(); i++) {
            writer.print(mail.getTo().get(i));

            if (i < mail.getTo().size() - 1) {
                writer.print(",");
            }
        }
        writer.println();

        writer.println("Subject: " + mail.getSubject());
        writer.println();

        //Mail
        writer.println(mail.getMessage());

        //Disconnection
        writer.println(".");
        waitNext();
        writer.println("quit");
        waitNext();

        disconnect();
    }
}
