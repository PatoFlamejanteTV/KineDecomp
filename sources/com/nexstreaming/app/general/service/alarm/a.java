package com.nexstreaming.app.general.service.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.api.client.util.Base64;
import com.google.gson.Gson;

/* compiled from: AlarmHelper.java */
/* loaded from: classes2.dex */
public class a extends com.nexstreaming.app.general.service.a {

    /* renamed from: b */
    private static final String f19675b = a.class.getName() + ".";

    /* renamed from: c */
    private static a f19676c = null;

    /* renamed from: d */
    private AlarmManager f19677d;

    /* renamed from: e */
    private Gson f19678e;

    private a(Context context) {
        super(context);
        this.f19677d = null;
        this.f19678e = null;
        this.f19678e = new Gson();
        this.f19677d = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    public static a a(Context context) {
        if (f19676c == null) {
            f19676c = new a(context);
        }
        return f19676c;
    }

    public AlarmData b() {
        return a("d-day");
    }

    private String b(String str) {
        String string = PreferenceManager.getDefaultSharedPreferences(a()).getString(str, null);
        return string != null ? new String(Base64.a(string)) : string;
    }

    public void a(AlarmData alarmData) {
        if (alarmData != null) {
            Log.i("AlarmHelper", "createAlarm() called with: data = [" + alarmData + "]");
            Intent intent = new Intent("com.nexstreaming.kinemaster.alarm.create");
            intent.putExtra("alarm_data", this.f19678e.toJson(alarmData));
            PendingIntent broadcast = PendingIntent.getBroadcast(a(), alarmData.id, intent, 536870912);
            if (broadcast == null) {
                broadcast = PendingIntent.getBroadcast(a(), alarmData.id, intent, 134217728);
            }
            this.f19677d.set(0, alarmData.dTime, broadcast);
            a(f19675b + alarmData.name, alarmData);
        }
    }

    public AlarmData a(String str) {
        String b2 = b(f19675b + str);
        if (b2 != null) {
            return (AlarmData) this.f19678e.fromJson(b2, AlarmData.class);
        }
        return null;
    }

    private void a(String str, AlarmData alarmData) {
        if (str == null || alarmData == null) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(a()).edit().putString(str, new String(Base64.a(this.f19678e.toJson(alarmData).getBytes()))).commit();
    }
}
