package com.jannetta.carpentries.registration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Workshops {

    @JsonProperty("Workshops")
    private List<Workshop> workshops;

    public Workshops() {}

    public List<Workshop> getWorkshops() {
        return workshops;
    }

    @Override
    public String toString() {
        String ret ="\nworkshops: " + workshops + "\n";
        return ret;
    }
}
