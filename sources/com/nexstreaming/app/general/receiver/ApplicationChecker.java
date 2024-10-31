package com.nexstreaming.app.general.receiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import c.d.a.a.d.a.d;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.kinemasterfree.wxapi.e;
import com.nexstreaming.kinemaster.ui.SplashActivity;
import com.tencent.mm.sdk.constants.ConstantsAPI;

/* loaded from: classes2.dex */
public class ApplicationChecker extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (context == null || intent == null || (action = intent.getAction()) == null) {
            return;
        }
        Log.i("ApplicationChecker", "onReceive = " + action);
        if (action.equals(ConstantsAPI.ACTION_REFRESH_WXAPP)) {
            if (e.c() == null) {
                e.c(context);
            }
            e.c().b();
            return;
        }
        if (action.equals(ConstantsAPI.ACTION_HANDLE_APP_REGISTER) || action.equals(ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER) || !action.equals("com.nextreaming.kinemaster.asset.install.clear")) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("open", false);
        d.a(context).b();
        ComponentName componentName = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity;
        if (componentName == null || componentName.getPackageName().equals(context.getPackageName()) || !booleanExtra) {
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) SplashActivity.class);
        intent2.setAction(NotificationData.ACTION_NOTIFICATION);
        intent2.setFlags(268468224);
        context.startActivity(intent2);
    }
}
