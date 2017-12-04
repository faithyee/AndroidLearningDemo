package utils;

import android.util.Log;

/**
 * Author：yewmf on 2017/12/4 10:51
 * E-mail：faith_yee@163.com
 */
public class LogUtils {

    private final static boolean DEBUG = true;
    private final static String TAG = "faith_log: ";


    public static void i(String tag, String str){
        if(DEBUG)
            Log.i(TAG + tag, str);
    }

}
