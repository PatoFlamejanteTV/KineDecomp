package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zza {

    /* renamed from: a */
    private static Object f14222a = new Object();

    /* renamed from: b */
    private static zza f14223b;

    /* renamed from: c */
    private volatile long f14224c;

    /* renamed from: d */
    private volatile long f14225d;

    /* renamed from: e */
    private volatile boolean f14226e;

    /* renamed from: f */
    private volatile AdvertisingIdClient.Info f14227f;

    /* renamed from: g */
    private volatile long f14228g;

    /* renamed from: h */
    private volatile long f14229h;
    private final Context i;
    private final Clock j;
    private final Thread k;
    private final Object l;
    private zzd m;

    private zza(Context context) {
        this(context, null, DefaultClock.d());
    }

    public static zza a(Context context) {
        if (f14223b == null) {
            synchronized (f14222a) {
                if (f14223b == null) {
                    zza zzaVar = new zza(context);
                    f14223b = zzaVar;
                    zzaVar.k.start();
                }
            }
        }
        return f14223b;
    }

    public final void b() {
        Process.setThreadPriority(10);
        while (!this.f14226e) {
            AdvertisingIdClient.Info a2 = this.m.a();
            if (a2 != null) {
                this.f14227f = a2;
                this.f14229h = this.j.a();
                zzdi.d("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.l) {
                    this.l.wait(this.f14224c);
                }
            } catch (InterruptedException unused) {
                zzdi.d("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    @VisibleForTesting
    private zza(Context context, zzd zzdVar, Clock clock) {
        this.f14224c = 900000L;
        this.f14225d = com.umeng.commonsdk.proguard.c.f26227d;
        this.f14226e = false;
        this.l = new Object();
        this.m = new i(this);
        this.j = clock;
        if (context != null) {
            this.i = context.getApplicationContext();
        } else {
            this.i = context;
        }
        this.f14228g = this.j.a();
        this.k = new Thread(new m(this));
    }

    @VisibleForTesting
    public final void a() {
        this.f14226e = true;
        this.k.interrupt();
    }
}
