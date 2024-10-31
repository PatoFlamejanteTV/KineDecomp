package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.iid.InstanceID;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class GoogleCloudMessaging {
    static GoogleCloudMessaging d;
    private Context f;
    private PendingIntent g;

    /* renamed from: a, reason: collision with root package name */
    public static int f1406a = 5000000;
    public static int b = 6500000;
    public static int c = 7000000;
    private static final AtomicInteger i = new AtomicInteger(1);
    private final BlockingQueue<Intent> j = new LinkedBlockingQueue();
    private Map<String, Handler> h = Collections.synchronizedMap(new HashMap());
    final Messenger e = new Messenger(new c(this, Looper.getMainLooper()));

    public static synchronized GoogleCloudMessaging a(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            if (d == null) {
                d = new GoogleCloudMessaging();
                d.f = context.getApplicationContext();
            }
            googleCloudMessaging = d;
        }
        return googleCloudMessaging;
    }

    static String a(Intent intent, String str) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("error");
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private void a(String str, String str2, long j, int i2, Bundle bundle) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        a(intent);
        intent.setPackage(b(this.f));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        intent.putExtra("google.delay", Integer.toString(i2));
        if (!b(this.f).contains(".gsf")) {
            this.f.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        Bundle bundle2 = new Bundle();
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj instanceof String) {
                bundle2.putString("gcm." + str3, (String) obj);
            }
        }
        bundle2.putString("google.to", str);
        bundle2.putString("google.message_id", str2);
        InstanceID.b(this.f).b("GCM", "upstream", bundle2);
    }

    public static String b(Context context) {
        return com.google.android.gms.iid.zzc.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Intent intent) {
        Handler remove;
        String stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra == null || (remove = this.h.remove(stringExtra)) == null) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.obj = intent;
        return remove.sendMessage(obtain);
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(b(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    private String c() {
        return "google.rpc" + String.valueOf(i.getAndIncrement());
    }

    @Deprecated
    Intent a(Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        if (c(this.f) < 0) {
            throw new IOException("Google Play Services missing");
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(b(this.f));
        a(intent);
        intent.putExtra("google.message_id", c());
        intent.putExtras(bundle);
        intent.putExtra("google.messenger", this.e);
        this.f.startService(intent);
        try {
            return this.j.poll(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Deprecated
    public synchronized String a(String... strArr) throws IOException {
        String a2;
        String b2 = b(strArr);
        Bundle bundle = new Bundle();
        if (b(this.f).contains(".gsf")) {
            bundle.putString("legacy.sender", b2);
            a2 = InstanceID.b(this.f).a(b2, "GCM", bundle);
        } else {
            bundle.putString("sender", b2);
            a2 = a(a(bundle), "registration_id");
        }
        return a2;
    }

    public void a() {
        d = null;
        zza.f1415a = null;
        b();
    }

    synchronized void a(Intent intent) {
        if (this.g == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.g = PendingIntent.getBroadcast(this.f, 0, intent2, 0);
        }
        intent.putExtra("app", this.g);
    }

    public void a(String str, String str2, long j, Bundle bundle) throws IOException {
        a(str, str2, j, -1, bundle);
    }

    String b(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i2 = 1; i2 < strArr.length; i2++) {
            sb.append(',').append(strArr[i2]);
        }
        return sb.toString();
    }

    synchronized void b() {
        if (this.g != null) {
            this.g.cancel();
            this.g = null;
        }
    }
}
