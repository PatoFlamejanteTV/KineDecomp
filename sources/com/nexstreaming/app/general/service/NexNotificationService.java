package com.nexstreaming.app.general.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.nexstreaming.app.general.service.alarm.AlarmData;
import com.nexstreaming.app.general.service.notification.NotificationData;
import com.nexstreaming.app.general.service.notification.b;

/* loaded from: classes.dex */
public class NexNotificationService extends IntentService {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3183a = NexNotificationService.class.getSimpleName();
    private static final String b = NexNotificationService.class.getName() + ".";
    private static final String c = b + "create.noti";
    private static final String d = b + "cancel.noti";
    private static final String e = b + "cancel.noti.all";
    private static final String f = b + "create.alarm";
    private static final String g = b + "cancel.alarm";
    private b h;

    public NexNotificationService(String str) {
        super(str);
        this.h = null;
    }

    public NexNotificationService() {
        super(f3183a);
        this.h = null;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            Log.i(f3183a, "onHandleIntent() called with: action = [" + action + "]");
            if (action.equals(c)) {
                a().a(intent);
                return;
            }
            if (action.equals(d)) {
                a().b(intent);
                return;
            }
            if (action.equals(e)) {
                a().b();
            } else if (action.equals(f)) {
                com.nexstreaming.app.general.service.alarm.b.a(this).a(intent);
            } else if (action.equals(g)) {
                com.nexstreaming.app.general.service.alarm.b.a(this).b(intent);
            }
        }
    }

    private b a() {
        if (this.h == null) {
            this.h = new b(this);
        }
        return this.h;
    }

    public static final void a(Context context, NotificationData notificationData) {
        if (context != null && notificationData != null) {
            Intent intent = new Intent(context, (Class<?>) NexNotificationService.class);
            intent.setAction(c);
            intent.putExtra("noti_parcelable", notificationData);
            context.startService(intent);
        }
    }

    public static final Intent b(Context context, NotificationData notificationData) {
        if (context == null || notificationData == null) {
            return null;
        }
        Intent intent = new Intent(context, (Class<?>) NexNotificationService.class);
        intent.setAction(c);
        intent.putExtra("noti_parcelable", notificationData);
        return intent;
    }

    public static final void a(Context context, AlarmData alarmData) {
        if (context != null && alarmData != null) {
            Intent intent = new Intent(context, (Class<?>) NexNotificationService.class);
            intent.setAction(f);
            intent.putExtra("alarm_parcelable", alarmData);
            context.startService(intent);
        }
    }
}
