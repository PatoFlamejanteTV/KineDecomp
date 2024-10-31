package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class GcmListenerService extends Service {
    private int b;

    /* renamed from: a, reason: collision with root package name */
    private final Object f1402a = new Object();
    private int c = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Intent intent) {
        try {
            if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("message_type");
                String str = stringExtra == null ? "gcm" : stringExtra;
                char c = 65535;
                switch (str.hashCode()) {
                    case -2062414158:
                        if (str.equals("deleted_messages")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 102161:
                        if (str.equals("gcm")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 814694033:
                        if (str.equals("send_error")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 814800675:
                        if (str.equals("send_event")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        a(intent.getExtras());
                        break;
                    case 1:
                        a();
                        break;
                    case 2:
                        a(intent.getStringExtra("google.message_id"));
                        break;
                    case 3:
                        a(intent.getStringExtra("google.message_id"), intent.getStringExtra("error"));
                        break;
                    default:
                        Log.w("GcmListenerService", "Received message with unknown type: " + str);
                        break;
                }
                synchronized (this.f1402a) {
                    this.c--;
                    if (this.c == 0) {
                        a(this.b);
                    }
                }
            }
        } finally {
            GcmReceiver.a(intent);
        }
    }

    private void a(Bundle bundle) {
        bundle.remove("message_type");
        bundle.remove("android.support.content.wakelockid");
        if (zza.a(bundle)) {
            zza.a(this).b(bundle);
            return;
        }
        String string = bundle.getString("from");
        bundle.remove("from");
        a(string, bundle);
    }

    public void a() {
    }

    public void a(String str) {
    }

    public void a(String str, Bundle bundle) {
    }

    public void a(String str, String str2) {
    }

    boolean a(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f1402a) {
            this.b = i2;
            this.c++;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new a(this, intent));
            return 3;
        }
        new b(this, intent).execute(new Void[0]);
        return 3;
    }
}
