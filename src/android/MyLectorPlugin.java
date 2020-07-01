package com.mylectorplugin;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.*;
import android.os.*;
import com.ftsafe.readerScheme.FTReader;

/**
 * This class echoes a string called from JavaScript.
 */
public class MyLectorPlugin extends CordovaPlugin {

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    String message ="";
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        

            Context context = cordova.getActivity().getApplicationContext();
            if (action.equals("coolMethod")) {
                message = "Hola mundo de Costa Rica a Nicaragua 3 :)";
                this.openNewActivity(context);
                return true;
            }
            return false;

    }

    private void openNewActivity(Context context) {
        Intent intent = new Intent(context, NewActivity.class);
        this.cordova.getActivity().startActivity(intent);
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
