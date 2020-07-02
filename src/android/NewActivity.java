package com.mylectorplugin;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;

public class NewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("activity_new", "layout", package_name));

        findViewById(getResources().getIdentifier("button_conectar", "id", getPackageName())).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mHandler.sendMessage(mHandler.obtainMessage(-1, ""));
            }
        });
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            TextView textView = (TextView) findViewById(getResources().getIdentifier("textView", "id", getPackageName()));

            String log=null;

            switch (msg.what) {
                case -1:
                    textView.setText("AAAAAAAAAAAAAAAAAAAAAAAAAA-08");
                    return;
                }
            }
        };
        
        private void showLog(String log){
            mHandler.sendMessage(mHandler.obtainMessage(0, log));
        }
}


