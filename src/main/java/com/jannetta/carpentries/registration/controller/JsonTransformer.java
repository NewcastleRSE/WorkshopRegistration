package com.jannetta.carpentries.registration.controller;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    Logger logger = LoggerFactory.getLogger(getClass());
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public String render(Object model) {
        return gson.toJson(model);
    }

}