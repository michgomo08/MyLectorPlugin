package com.mylectorplugin;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;


import com.ftsafe.readerScheme.FTException;
import com.ftsafe.readerScheme.FTReader;

public class NewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("activity_new", "layout", package_name));
		
		showLog("LibVersion:"+FTReader.readerGetLibVersion());

        
        
        
        findViewById(getResources().getIdentifier("button_limpiar", "id", getPackageName())).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mHandler.sendMessage(mHandler.obtainMessage(-1, ""));
            }
        });

        findViewById(getResources().getIdentifier("button_salir", "id", getPackageName())).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                android.os.Process.killProcess(android.os.Process.myPid());
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
                case 0:
                    log = msg.obj.toString();
                    textView.append("LOG---------->"+log+"\n");
                    break;	
            }
        }
    };
        
        private void showLog(String log){
            mHandler.sendMessage(mHandler.obtainMessage(0, log));
        }
}


