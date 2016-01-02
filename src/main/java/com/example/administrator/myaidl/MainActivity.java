package com.example.administrator.myaidl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {


    private static final String Tag = "client";
    private ICalcAIDL mCalcAidl;
    private ServiceConnection mConn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e(Tag,"onServiceConnection");
            mCalcAidl = ICalcAIDL.Stub.asInterface(iBinder);

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
                Log.e(Tag,"OnServiceDisconnected()");
                mCalcAidl=null;

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void bindService(View view ) {

        Intent intent =new Intent();
        intent.setAction("com.dfy.myaidl");

       super.bindService(intent, mConn, Context.BIND_AUTO_CREATE);

    }


    public void unbindService(View view) {
        super.unbindService(mConn);

    }
    public void addInvoked(View view) throws RemoteException {
        if(mCalcAidl!=null){
           int res= mCalcAidl.add(12,12);
            Log.e("Tag","addInvoke()的结果："+res);
            Toast.makeText(this,res+"",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"服务器被异常杀死，重新连接！",Toast.LENGTH_SHORT).show();

        }

    }

    public void minInvoked(View view) throws RemoteException {
        if(mCalcAidl!=null){
            int res=mCalcAidl.min(50,12);
            Log.e(Tag, "minInvoke()的结果："+res);
            Toast.makeText(this,res+"",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "服务器异常，重新连接！",Toast.LENGTH_LONG).show();
        }
    }
}
