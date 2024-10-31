package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes2.dex */
public final class zzh implements ServiceConnection {

    /* renamed from: a */
    private final Context f17424a;

    /* renamed from: b */
    private final Intent f17425b;

    /* renamed from: c */
    private final ScheduledExecutorService f17426c;

    /* renamed from: d */
    private final Queue<x> f17427d;

    /* renamed from: e */
    private zzf f17428e;

    /* renamed from: f */
    private boolean f17429f;

    public zzh(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private final void b() {
        while (!this.f17427d.isEmpty()) {
            this.f17427d.poll().a();
        }
    }

    public final synchronized void a(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.f17427d.add(new x(intent, pendingResult, this.f17426c));
        a();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.f17429f = false;
            this.f17428e = (zzf) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("onServiceConnected: ");
                sb.append(valueOf);
                Log.d("EnhancedIntentService", sb.toString());
            }
            if (iBinder == null) {
                Log.e("EnhancedIntentService", "Null service connection");
                b();
            } else {
                a();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("EnhancedIntentService", sb.toString());
        }
        a();
    }

    private zzh(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f17427d = new ArrayDeque();
        this.f17429f = false;
        this.f17424a = context.getApplicationContext();
        this.f17425b = new Intent(str).setPackage(this.f17424a.getPackageName());
        this.f17426c = scheduledExecutorService;
    }

    private final synchronized void a() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "flush queue called");
        }
        while (!this.f17427d.isEmpty()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "found intent to be delivered");
            }
            if (this.f17428e != null && this.f17428e.isBinderAlive()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
                }
                this.f17428e.a(this.f17427d.poll());
            } else {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    boolean z = !this.f17429f;
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("binder is dead. start connection? ");
                    sb.append(z);
                    Log.d("EnhancedIntentService", sb.toString());
                }
                if (!this.f17429f) {
                    this.f17429f = true;
                    try {
                    } catch (SecurityException e2) {
                        Log.e("EnhancedIntentService", "Exception while binding the service", e2);
                    }
                    if (ConnectionTracker.a().a(this.f17424a, this.f17425b, this, 65)) {
                        return;
                    }
                    Log.e("EnhancedIntentService", "binding to the service failed");
                    this.f17429f = false;
                    b();
                }
                return;
            }
        }
    }
}
