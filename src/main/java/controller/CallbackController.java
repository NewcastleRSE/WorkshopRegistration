package controller;

import com.auth0.AuthenticationController;

public class CallbackController {
    private static AuthenticationController authenticationController;
    public static String callBack () {
//        try {
//            authenticationController = AuthenticationControllerProvider.getInstance(AuthenticationControllerProvider.getDomain());
//            Tokens tokens = authenticationController.handle(req, res);
//        } catch (UnsupportedEncodingException e) {
//            throw new Exception("Couldn't create the AuthenticationController instance. Check the configuration.", e);
//        }
        return "Called back";
    };


}
