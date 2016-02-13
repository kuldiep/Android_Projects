package org.code_freak.com.bunch_of_app;

/**
 * Created by Kuldiep on 2/13/2016.
 */
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Kuldiep on 2/11/2016.
 */
public class Utils {

    public static void toastIt(Context context, String msg){
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}