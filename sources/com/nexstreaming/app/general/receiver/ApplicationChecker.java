package com.nexstreaming.app.general.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.nexstreaming.app.general.service.NexNotificationService;
import com.nexstreaming.app.general.service.alarm.AlarmData;
import com.nexstreaming.app.general.service.alarm.b;
import com.tencent.mm.sdk.constants.ConstantsAPI;

/* loaded from: classes.dex */
public class ApplicationChecker extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (context != null && intent != null && (action = intent.getAction()) != null) {
            Log.i("ApplicationChecker", "onReceive = " + action);
            if (action.equals("android.intent.action.BOOT_COMPLETED")) {
                AlarmData b = b.a(context).b();
                AlarmData c = b.a(context).c();
                if (b != null && b.dTime >= System.currentTimeMillis()) {
                    NexNotificationService.a(context, b);
                }
                if (c != null && c.dTime >= System.currentTimeMillis()) {
                    NexNotificationService.a(context, c);
                    return;
                }
                return;
            }
            if (action.equals(ConstantsAPI.ACTION_REFRESH_WXAPP)) {
                if (com.nexstreaming.app.kinemasterfree.wxapi.b.a() == null) {
                    com.nexstreaming.app.kinemasterfree.wxapi.b.a(context);
                }
                com.nexstreaming.app.kinemasterfree.wxapi.b.a().f();
            } else {
                if (action.equals(ConstantsAPI.ACTION_HANDLE_APP_REGISTER) || !action.equals(ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER)) {
                }
            }
        }
    }
}
