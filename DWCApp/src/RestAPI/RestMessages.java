package RestAPI;

/**
 * Created by Abanoub on 6/16/2015.
 */
public class RestMessages {

    final String error_message = "Failed to load data ,please check your internet connection";
    final String success_message = "Loaded Successfully";

    private static RestMessages ourInstance = new RestMessages();

    public static RestMessages getInstance() {
        if (ourInstance == null) {
            ourInstance = new RestMessages();
            return ourInstance;
        }
        return ourInstance;
    }

    private RestMessages() {
    }

    public static String getErrorMessage() {
        return getInstance().error_message;
    }

    public static String getSuccessMessage() {
        return getInstance().success_message;
    }
}
