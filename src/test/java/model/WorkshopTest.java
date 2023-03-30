package model;

import com.jannetta.carpentries.registration.model.Workshop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkshopTest {



    @Test
    void testToString() {
        Workshop workshop = new Workshop("2023-01-01-NCL","links1", "2023-03-03", "titletitle", "typetype", "linktoform");
        assertEquals(workshop.toString(), "\nid: 2023-01-01-NCL\nlink: links1\ndate: 2023-03-03\ntitle: titletitle\ntype: typetype\nform: linktoform");
    }
}