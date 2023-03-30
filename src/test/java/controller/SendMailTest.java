package controller;

import static com.jannetta.carpentries.registration.controller.SendMail.send;
import static org.junit.jupiter.api.Assertions.*;

class SendMailTest {

    @org.junit.jupiter.api.Test
    void testSend() {
        assertEquals("Sent message successfully.", send("jannetta@jannetta.com",
                "There was a man from Ealing"));
        System.out.println("Sent ...");
    }
}