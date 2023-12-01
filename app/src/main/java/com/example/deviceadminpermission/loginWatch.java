package com.example.deviceadminpermission;

/**
 * @author Sanat
 * loginWatch class, handle enabling and disabling of security Policies
 * by the user
 */
import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class loginWatch extends DeviceAdminReceiver {

    /**
     * This method is called once device admin is enabled
     */
    @Override
    public void onEnabled(@NonNull Context context, @NonNull Intent intent) {
        Toast.makeText(context,"Device Admin Enabled",Toast.LENGTH_SHORT).show();
        Log.i("loginWatch","Device Admin Enabled");
    }

    /**
     * This method is called once device admin is disabled
     */
    @Override
    public void onDisabled(@NonNull Context context, @NonNull Intent intent) {
        Toast.makeText(context,"Device Admin Disabled",Toast.LENGTH_SHORT).show();
        Log.i("loginWatch","Device Admin Disabled");
    }

    /***
     * This method will be called eveytime an incorrect PIN is entered
     */
    @Override
    public void onPasswordFailed(@NonNull Context context, @NonNull Intent intent) {
        super.onPasswordFailed(context, intent);
        SecurityService.failedPasswordCount++;
        Toast.makeText(context,"Hello Hacker",Toast.LENGTH_SHORT).show();


    }
}
