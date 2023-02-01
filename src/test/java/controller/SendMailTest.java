package controller;

import static controller.SendMail.send;
import static org.junit.jupiter.api.Assertions.*;

class SendMailTest {

    @org.junit.jupiter.api.Test
    void testSend() {
        assertEquals("Sent message successfully.", send("jannetta@jannetta.com",
                "A test message",
                "There was a man from Ealing"));
        System.out.println("Sent ...");
    }
}