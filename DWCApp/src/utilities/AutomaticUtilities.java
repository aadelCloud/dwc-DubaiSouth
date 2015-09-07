package utilities;

import java.util.Date;

/**
 * Created by M_Ghareeb on 8/30/2015.
 */
public class AutomaticUtilities {
    public static int daysBetween(Date d1, long d2){
        return (int)( ( d1.getTime()-d2 ) / (1000 * 60 * 60 * 24));
    }
}
