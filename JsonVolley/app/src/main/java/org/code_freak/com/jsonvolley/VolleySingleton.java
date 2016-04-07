package org.code_freak.com.jsonvolley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Kuldiep on 3/9/2016.
 */
public class VolleySingleton {

    private static VolleySingleton volleySingleton =null;
    private RequestQueue requestQueue;
    private VolleySingleton() {
       

    }
    public static VolleySingleton getInstance(){
        if(volleySingleton != null){
            volleySingleton =  VolleySingleton();
        }
        return volleySingleton;
    }
    public RequestQueue requestQueue(){
        return requestQueue;
    }
}
