package com.mylectorplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.*;
import com.ftsafe.PcscServer;
import com.ftsafe.readerScheme.FTReader;

/**
 * This class echoes a string called from JavaScript.
 */
public class MyLectorPlugin extends CordovaPlugin {
    String message ="";
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {


            message = "Hola mundo de Costa Rica a Nicaragua 3 :)";

            final Handler mHandler = new Handler(){
                @Override
                public void handleMessage(Message msg){
                    super.handleMessage(msg);
                    message += "---- entro al handler ---";
                    switch (msg.what) {
                        case 0:
                        String log = msg.obj.toString();
                        message +="LOG---------->"+log;
                        break;
                    }
                }
            };

            mHandler.sendMessage(mHandler.obtainMessage(0, "Prueba"));

            int PORT = 0x096e; 
            PcscServer pcscServer = new PcscServer(PORT,Activity.getApplicationContext(), mHandler);
           /*
            FTReader  ftReader = pcscServer.getFtReaderObject();
            new Tpcsc().testA(PORT); 
            */

            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
