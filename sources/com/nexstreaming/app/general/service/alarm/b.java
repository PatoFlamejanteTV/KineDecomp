package com.nexstreaming.app.general.service.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.util.Log;
import com.google.api.client.util.Base64;
import com.google.gson.Gson;
import com.nexstreaming.app.general.service.NexNotificationService;

/* compiled from: AlarmHelper.java */
/* loaded from: classes.dex */
public class b extends com.nexstreaming.app.general.service.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3185a = b.class.getName() + ".";
    private static b d = null;
    private AlarmManager b;
    private Gson c;

    public static b a(Context context) {
        if (d == null) {
            d = new b(context);
        }
        return d;
    }

    private b(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.b = (AlarmManager) context.getSystemService("alarm");
    }

    public void a(Intent intent) {
        if (intent != null) {
            a((AlarmData) intent.getParcelableExtra("alarm_parcelable"));
        }
    }

    public void a(AlarmData alarmData) {
        if (alarmData != null) {
            Log.i("AlarmHelper", "createAlarm() called with: data = [" + alarmData + "]");
            Intent b = NexNotificationService.b(a(), alarmData.notificationData);
            PendingIntent service = PendingIntent.getService(a(), alarmData.id, b, 536870912);
            if (service == null) {
                service = PendingIntent.getService(a(), alarmData.id, b, 134217728);
            }
            this.b.set(0, alarmData.dTime, service);
            a(f3185a + alarmData.name, alarmData);
        }
    }

    public void b(Intent intent) {
        if (intent != null) {
            b((AlarmData) intent.getParcelableExtra("alarm_parcelable"));
        }
    }

    public void b(AlarmData alarmData) {
        if (alarmData != null) {
            Log.i("AlarmHelper", "cancelAlarm() called with: data = [" + alarmData + "]");
            Intent b = NexNotificationService.b(a(), alarmData.notificationData);
            b.putExtra("noti_parcelable", alarmData.notificationData);
            PendingIntent service = PendingIntent.getService(a(), alarmData.id, b, 536870912);
            if (service == null) {
                service = PendingIntent.getService(a(), alarmData.id, b, 134217728);
            }
            this.b.cancel(service);
        }
    }

    public AlarmData a(String str) {
        String b = b(f3185a + str);
        if (b == null) {
            return null;
        }
        return (AlarmData) d().fromJson(b, AlarmData.class);
    }

    public AlarmData b() {
        return a("a_week");
    }

    public AlarmData c() {
        return a("d-day");
    }

    private void a(String str, AlarmData alarmData) {
        if (str != null && alarmData != null) {
            PreferenceManager.getDefaultSharedPreferences(a()).edit().putString(str, new String(Base64.a(d().toJson(alarmData).getBytes()))).commit();
        }
    }

    private String b(String str) {
        String string = PreferenceManager.getDefaultSharedPreferences(a()).getString(str, null);
        if (string != null) {
            return new String(Base64.a(string));
        }
        return string;
    }

    private Gson d() {
        if (this.c == null) {
            this.c = new Gson();
        }
        return this.c;
    }
}
