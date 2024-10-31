package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class k implements ServiceConnection {

    /* renamed from: a */
    private final Set<ServiceConnection> f11159a = new HashSet();

    /* renamed from: b */
    private int f11160b = 2;

    /* renamed from: c */
    private boolean f11161c;

    /* renamed from: d */
    private IBinder f11162d;

    /* renamed from: e */
    private final GmsClientSupervisor.zza f11163e;

    /* renamed from: f */
    private ComponentName f11164f;

    /* renamed from: g */
    private final /* synthetic */ j f11165g;

    public k(j jVar, GmsClientSupervisor.zza zzaVar) {
        this.f11165g = jVar;
        this.f11163e = zzaVar;
    }

    public final void a(String str) {
        ConnectionTracker connectionTracker;
        Context context;
        Context context2;
        ConnectionTracker connectionTracker2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        this.f11160b = 3;
        connectionTracker = this.f11165g.f11156f;
        context = this.f11165g.f11154d;
        GmsClientSupervisor.zza zzaVar = this.f11163e;
        context2 = this.f11165g.f11154d;
        this.f11161c = connectionTracker.a(context, str, zzaVar.a(context2), this, this.f11163e.c());
        if (!this.f11161c) {
            this.f11160b = 2;
            try {
                connectionTracker2 = this.f11165g.f11156f;
                context3 = this.f11165g.f11154d;
                connectionTracker2.a(context3, this);
                return;
            } catch (IllegalArgumentException unused) {
                return;
            }
        }
        handler = this.f11165g.f11155e;
        Message obtainMessage = handler.obtainMessage(1, this.f11163e);
        handler2 = this.f11165g.f11155e;
        j = this.f11165g.f11158h;
        handler2.sendMessageDelayed(obtainMessage, j);
    }

    public final void b(String str) {
        Handler handler;
        ConnectionTracker connectionTracker;
        Context context;
        handler = this.f11165g.f11155e;
        handler.removeMessages(1, this.f11163e);
        connectionTracker = this.f11165g.f11156f;
        context = this.f11165g.f11154d;
        connectionTracker.a(context, this);
        this.f11161c = false;
        this.f11160b = 2;
    }

    public final int c() {
        return this.f11160b;
    }

    public final boolean d() {
        return this.f11161c;
    }

    public final boolean e() {
        return this.f11159a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f11165g.f11153c;
        synchronized (hashMap) {
            handler = this.f11165g.f11155e;
            handler.removeMessages(1, this.f11163e);
            this.f11162d = iBinder;
            this.f11164f = componentName;
            Iterator<ServiceConnection> it = this.f11159a.iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.f11160b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f11165g.f11153c;
        synchronized (hashMap) {
            handler = this.f11165g.f11155e;
            handler.removeMessages(1, this.f11163e);
            this.f11162d = null;
            this.f11164f = componentName;
            Iterator<ServiceConnection> it = this.f11159a.iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.f11160b = 2;
        }
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        ConnectionTracker unused;
        Context unused2;
        unused = this.f11165g.f11156f;
        unused2 = this.f11165g.f11154d;
        this.f11159a.remove(serviceConnection);
    }

    public final ComponentName b() {
        return this.f11164f;
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        Context context;
        ConnectionTracker unused;
        Context unused2;
        unused = this.f11165g.f11156f;
        unused2 = this.f11165g.f11154d;
        GmsClientSupervisor.zza zzaVar = this.f11163e;
        context = this.f11165g.f11154d;
        zzaVar.a(context);
        this.f11159a.add(serviceConnection);
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.f11159a.contains(serviceConnection);
    }

    public final IBinder a() {
        return this.f11162d;
    }
}
