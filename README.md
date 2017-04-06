# SMTP-PrankMail

## Description
This repository contains a code in java for a client application (TCP), which use the Socket API to communicate with a SMTP server.
It include also a partial implementation of the SMTP protocol.
Whith this code, you can send forged e-mails to a group of victims of your choice. You can also choose the message sent.

_____

## How to use it
* Install or update your Java RE: [https://www.java.com/fr/download/](https://www.java.com/fr/download/)
* Download or clone this repository
* Configure the files named **messages.txt** and **persons.txt** that you find in *PrankMail/config*:
  * **messages.txt**: the 1st line should be the subject of your e-mail. The next ones are the text that you want.
  * **persons.txt**: each line is the e-mail's address of the persons that you wish to use in your prank
* Now, if you don't want already send yours fakes e-mails, you can download MockMock server to set up a test environment. You can do it here: [https://github.com/tweakers-dev/MockMock]https://github.com/tweakers-dev/MockMock
* You run MockMock.jar with the next command: `java -jar MockMock.jar -h xxxx -p xxxxx` with the  terminal. The x for -h are for the local port you want to use (default: 25) and the x for -p are for the web interface (default 8282).
* Then, open your browser and go to `localhost:<the x choose for the -p>`. It will open a window where you can see your fake e-mails. (They won't be really sent with MockMock)
* Now you can run the code: HEEEEEEEEEEERRRRE ADDD

_____

##Implementation
The code has 4 packages:
* **ch.heigvd.jacquemardlevy.prankmail**: 
  * MailPrank.java => main of the application
* **ch.heigvd.jacquemardlevy.prankmail.config**:
  * ConfigurationManager.java => allow to config your manager using the Properties class of java.util
* **ch.heigvd.jacquemardlevy.prankmail.model**:
  * Message.java => methods to get all the attributes of a message like the subject or the contents
  * Person.java => methods to get the informations like addresses
  * Prank.java => get all the informations needed and create the e-mails
  * PrankGenerator.java => generate and send all the e-mails
* **ch.heigvd.jacquemardlevy.prankmail.smtp**:
  * ISmtpClient.java => interface to define the method senMail
  * Mail.java => define all the methods use to create the e-mails
  * SmtpClient.java => implements the interface named ISmtpClient. Contains the methods for the smtp client to define for example the port, the IP, etc.

