# SMTP-PrankMail

## Description
This repository contains a code in java for a client application (TCP), which use the Socket API to communicate with a SMTP server.
It include also a partial implementation of the SMTP protocol.
Whith this code, you can send forged e-mails to a group of victims of your choice. You can also choose the message sent.

## How to use it
* Install or update your Java RE: [https://www.java.com/fr/download/](https://www.java.com/fr/download/)
* Download or clone this repository
* Configure the files named **messages.txt** and **persons.txt** that you find in *PrankMail/config*:
  * **messages.txt**: the 1st line should be the subject of your e-mail. The next ones are the text that you want.
  * **persons.txt**: each line is the e-mail's address of the persons that you wish to use in your prank
* Now, if you don't want already send yours fakes e-mails, you can download MockMock server to set up a test environment. You can do it here: [https://github.com/tweakers-dev/MockMock]https://github.com/tweakers-dev/MockMock
* You run MockMock.jar with the next command: `java -jar MockMock.jar` with the  terminal.



