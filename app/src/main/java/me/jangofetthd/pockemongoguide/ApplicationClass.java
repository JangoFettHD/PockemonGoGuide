package me.jangofetthd.pockemongoguide;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.localytics.android.Localytics;

/**
 * Created by JangoFettHD on 21.07.2016.
 */
public class ApplicationClass extends Application {

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    @Override
    public void onCreate()
    {
        super.onCreate();

        Localytics.autoIntegrate(this);
    }
}
