package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zzl {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f545a = new Object();
    private static zzl b;
    private final com.google.android.gms.ads.internal.util.client.zza c = new com.google.android.gms.ads.internal.util.client.zza();
    private final zze d = new zze();
    private final zzm e = new zzm();
    private final zzad f = new zzad();
    private final zzda g = new zzda();
    private final com.google.android.gms.ads.internal.reward.client.zzf h = new com.google.android.gms.ads.internal.reward.client.zzf();

    static {
        a(new zzl());
    }

    protected zzl() {
    }

    public static com.google.android.gms.ads.internal.util.client.zza a() {
        return d().c;
    }

    protected static void a(zzl zzlVar) {
        synchronized (f545a) {
            b = zzlVar;
        }
    }

    public static zze b() {
        return d().d;
    }

    public static zzm c() {
        return d().e;
    }

    private static zzl d() {
        zzl zzlVar;
        synchronized (f545a) {
            zzlVar = b;
        }
        return zzlVar;
    }
}
