package com.jannetta.carpentries.registration.util;

public class Path {

    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        public static final String INDEX = "/index/";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout/";
    }
    public static class Template {

        public static final String RECEIPT = "/velocity/receipt.vm";
        public final static String INDEX = "/velocity/index.vm";
        public final static String REGISTRATION = "/velocity/registration.vm";
        public final static String LOGIN = "/velocity/login/login.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
    }

}
