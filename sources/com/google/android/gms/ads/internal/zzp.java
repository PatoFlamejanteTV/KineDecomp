package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzii;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;

@zzgr
/* loaded from: classes.dex */
public class zzp {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f667a = new Object();
    private static zzp b;
    private final com.google.android.gms.ads.internal.request.zza c = new com.google.android.gms.ads.internal.request.zza();
    private final com.google.android.gms.ads.internal.overlay.zza d = new com.google.android.gms.ads.internal.overlay.zza();
    private final com.google.android.gms.ads.internal.overlay.zze e = new com.google.android.gms.ads.internal.overlay.zze();
    private final zzgg f = new zzgg();
    private final zzid g = new zzid();
    private final zzjb h = new zzjb();
    private final zzie i = zzie.zzM(Build.VERSION.SDK_INT);
    private final zzhu j = new zzhu(this.g);
    private final zzmn k = new zzmp();
    private final zzcb l = new zzcb();
    private final zzgz m = new zzgz();
    private final zzbw n = new zzbw();
    private final zzbv o = new zzbv();
    private final zzbx p = new zzbx();
    private final com.google.android.gms.ads.internal.purchase.zzi q = new com.google.android.gms.ads.internal.purchase.zzi();
    private final zzii r = new zzii();
    private final zzej s = new zzej();
    private final zzdu t = new zzdu();

    static {
        a(new zzp());
    }

    protected zzp() {
    }

    public static com.google.android.gms.ads.internal.request.zza a() {
        return s().c;
    }

    protected static void a(zzp zzpVar) {
        synchronized (f667a) {
            b = zzpVar;
        }
    }

    public static com.google.android.gms.ads.internal.overlay.zza b() {
        return s().d;
    }

    public static com.google.android.gms.ads.internal.overlay.zze c() {
        return s().e;
    }

    public static zzgg d() {
        return s().f;
    }

    public static zzid e() {
        return s().g;
    }

    public static zzjb f() {
        return s().h;
    }

    public static zzie g() {
        return s().i;
    }

    public static zzhu h() {
        return s().j;
    }

    public static zzmn i() {
        return s().k;
    }

    public static zzcb j() {
        return s().l;
    }

    public static zzgz k() {
        return s().m;
    }

    public static zzbw l() {
        return s().n;
    }

    public static zzbv m() {
        return s().o;
    }

    public static zzbx n() {
        return s().p;
    }

    public static com.google.android.gms.ads.internal.purchase.zzi o() {
        return s().q;
    }

    public static zzii p() {
        return s().r;
    }

    public static zzej q() {
        return s().s;
    }

    public static zzdu r() {
        return s().t;
    }

    private static zzp s() {
        zzp zzpVar;
        synchronized (f667a) {
            zzpVar = b;
        }
        return zzpVar;
    }
}
