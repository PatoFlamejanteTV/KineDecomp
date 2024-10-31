package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public abstract class zzb extends Service {

    /* renamed from: a */
    final ExecutorService f17418a;

    /* renamed from: b */
    private Binder f17419b;

    /* renamed from: c */
    private final Object f17420c;

    /* renamed from: d */
    private int f17421d;

    /* renamed from: e */
    private int f17422e;

    public zzb() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        this.f17418a = Executors.newSingleThreadExecutor(new NamedThreadFactory(valueOf.length() != 0 ? "Firebase-".concat(valueOf) : new String("Firebase-")));
        this.f17420c = new Object();
        this.f17422e = 0;
    }

    public final void d(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.f17420c) {
            this.f17422e--;
            if (this.f17422e == 0) {
                stopSelfResult(this.f17421d);
            }
        }
    }

    protected Intent a(Intent intent) {
        return intent;
    }

    public boolean b(Intent intent) {
        return false;
    }

    public abstract void c(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f17419b == null) {
            this.f17419b = new zzf(this);
        }
        return this.f17419b;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f17420c) {
            this.f17421d = i2;
            this.f17422e++;
        }
        Intent a2 = a(intent);
        if (a2 == null) {
            d(intent);
            return 2;
        }
        if (b(a2)) {
            d(intent);
            return 2;
        }
        this.f17418a.execute(new w(this, a2, intent));
        return 3;
    }
}
