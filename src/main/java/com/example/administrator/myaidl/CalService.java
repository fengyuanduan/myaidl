package com.example.administrator.myaidl;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by Administrator on 2015/12/25.
 */
public class CalService extends Service {

    private static String Tag="Service";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(Tag,"OnCreate()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onDestroy() {

        Log.e(Tag,"OnDestroy()");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.e(Tag,"onUnBinder()");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(Tag,"OnRebind()");
        super.onRebind(intent);
    }


    private final ICalcAIDL.Stub mBinder=new ICalcAIDL.Stub(){

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int add(int a, int b) throws RemoteException {
            return a+b;
        }

        @Override
        public int min(int a, int b) throws RemoteException {
            return a-b;
        }
    };
}
