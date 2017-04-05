package ch.heigvd.jacquemardlevy.prankmail.config;

import java.io.*;
import java.util.Properties;

/**
 * Created by Remi on 04.04.2017.
 */
public class ConfigurationManager {

    private final File file;
    private final Properties properties = new Properties();

    public ConfigurationManager() throws IOException {
        file = new File("config/config.properties");

        properties.load(new BufferedInputStream(new FileInputStream(file)));
    }

    public String getServerAddress(){
        return properties.getProperty("serverAddress");
    }

    public int getServerPort(){
        return Integer.parseInt(properties.getProperty("serverPort"));
    }

    public int getNumberOfGroups(){
        return Integer.parseInt(properties.getProperty("numberOfGroups"));
    }

    public String getMessagesPath(){
        return properties.getProperty("messagesPath");
    }

    public String getAddressesPath(){
        return properties.getProperty("addressesPath");
    }
}
