package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

/* loaded from: classes.dex */
public class InstanceIDListenerService extends Service {

    /* renamed from: a, reason: collision with root package name */
    static String f1423a = NativeProtocol.WEB_DIALOG_ACTION;
    private static String f = "google.com/iid";
    private static String g = "CMD";
    private static String h = "gcm.googleapis.com/refresh";
    MessengerCompat b = new MessengerCompat(new a(this, Looper.getMainLooper()));
    BroadcastReceiver c = new b(this);
    int d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(g, "SYNC");
        context.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, zzd zzdVar) {
        zzdVar.b();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(g, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        zzc.a((Context) this);
        getPackageManager();
        if (i == zzc.c || i == zzc.b) {
            a((Intent) message.obj);
        } else {
            Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + zzc.b + " appid=" + zzc.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this) {
            this.d--;
            if (this.d == 0) {
                stopSelf(this.e);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.d + " " + this.e);
            }
        }
    }

    void a(int i) {
        synchronized (this) {
            this.d++;
            if (i > this.e) {
                this.e = i;
            }
        }
    }

    public void a(Intent intent) {
        InstanceID a2;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            a2 = InstanceID.b(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            a2 = InstanceID.a(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(g);
        if (intent.getStringExtra("error") != null || intent.getStringExtra("registration_id") != null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Register result in service " + stringExtra);
            }
            a2.e().d(intent);
            return;
        }
        if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
        }
        if (intent.getStringExtra("unregistered") != null) {
            zzd d = a2.d();
            if (stringExtra == null) {
                stringExtra = "";
            }
            d.e(stringExtra);
            a2.e().d(intent);
            return;
        }
        if (h.equals(intent.getStringExtra("from"))) {
            a2.d().e(stringExtra);
            a(false);
            return;
        }
        if ("RST".equals(stringExtra2)) {
            a2.c();
            a(true);
            return;
        }
        if ("RST_FULL".equals(stringExtra2)) {
            if (a2.d().a()) {
                return;
            }
            a2.d().b();
            a(true);
            return;
        }
        if ("SYNC".equals(stringExtra2)) {
            a2.d().e(stringExtra);
            a(false);
        } else if ("PING".equals(stringExtra2)) {
            try {
                GoogleCloudMessaging.a(this).a(f, zzc.b(), 0L, intent.getExtras());
            } catch (IOException e) {
                Log.w("InstanceID", "Failed to send ping response");
            }
        }
    }

    public void a(boolean z) {
        b();
    }

    public void b() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            return null;
        }
        return this.b.a();
    }

    @Override // android.app.Service
    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.c, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        unregisterReceiver(this.c);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Intent intent2;
        a(i2);
        if (intent == null) {
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (Build.VERSION.SDK_INT <= 18 && (intent2 = (Intent) intent.getParcelableExtra("GSF")) != null) {
                    startService(intent2);
                    return 1;
                }
                a(intent);
            }
            a();
            if (intent.getStringExtra("from") != null) {
                GcmReceiver.a(intent);
            }
            return 2;
        } finally {
            a();
        }
    }
}
