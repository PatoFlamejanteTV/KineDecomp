package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Xj {

    /* renamed from: a, reason: collision with root package name */
    public final zzlm f11959a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11960b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11961c;

    /* renamed from: d, reason: collision with root package name */
    public final zzlv[] f11962d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean[] f11963e;

    /* renamed from: f, reason: collision with root package name */
    public final long f11964f;

    /* renamed from: g, reason: collision with root package name */
    public int f11965g;

    /* renamed from: h, reason: collision with root package name */
    public long f11966h;
    public boolean i;
    public boolean j;
    public boolean k;
    public Xj l;
    public zzor m;
    private final zzfz[] n;
    private final zzga[] o;
    private final zzop p;
    private final zzfw q;
    private final zzlo r;
    private zzor s;

    public Xj(zzfz[] zzfzVarArr, zzga[] zzgaVarArr, long j, zzop zzopVar, zzfw zzfwVar, zzlo zzloVar, Object obj, int i, int i2, boolean z, long j2) {
        this.n = zzfzVarArr;
        this.o = zzgaVarArr;
        this.f11964f = j;
        this.p = zzopVar;
        this.q = zzfwVar;
        this.r = zzloVar;
        zzpo.checkNotNull(obj);
        this.f11960b = obj;
        this.f11961c = i;
        this.f11965g = i2;
        this.i = z;
        this.f11966h = j2;
        this.f11962d = new zzlv[zzfzVarArr.length];
        this.f11963e = new boolean[zzfzVarArr.length];
        this.f11959a = zzloVar.zza(i2, zzfwVar.zzci());
    }

    public final void a(int i, boolean z) {
        this.f11965g = i;
        this.i = z;
    }

    public final long b() {
        return this.f11964f - this.f11966h;
    }

    public final boolean c() {
        if (this.j) {
            return !this.k || this.f11959a.zzez() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d() throws com.google.android.gms.internal.ads.zzff {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzop r0 = r6.p
            com.google.android.gms.internal.ads.zzga[] r1 = r6.o
            com.google.android.gms.internal.ads.zzlm r2 = r6.f11959a
            com.google.android.gms.internal.ads.zzma r2 = r2.zzex()
            com.google.android.gms.internal.ads.zzor r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzor r1 = r6.s
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L16
        L14:
            r1 = 0
            goto L28
        L16:
            r4 = 0
        L17:
            com.google.android.gms.internal.ads.zzoo r5 = r0.zzbfl
            int r5 = r5.length
            if (r4 >= r5) goto L27
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L24
            goto L14
        L24:
            int r4 = r4 + 1
            goto L17
        L27:
            r1 = 1
        L28:
            if (r1 == 0) goto L2b
            return r3
        L2b:
            r6.m = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Xj.d():boolean");
    }

    public final long a(long j, boolean z) {
        return a(j, false, new boolean[this.n.length]);
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        zzoo zzooVar = this.m.zzbfl;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzooVar.length) {
                break;
            }
            boolean[] zArr2 = this.f11963e;
            if (z || !this.m.zza(this.s, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.f11959a.zza(zzooVar.zzgp(), this.f11963e, this.f11962d, zArr, j);
        this.s = this.m;
        this.k = false;
        int i2 = 0;
        while (true) {
            zzlv[] zzlvVarArr = this.f11962d;
            if (i2 < zzlvVarArr.length) {
                if (zzlvVarArr[i2] != null) {
                    zzpo.checkState(zzooVar.zzbe(i2) != null);
                    this.k = true;
                } else {
                    zzpo.checkState(zzooVar.zzbe(i2) == null);
                }
                i2++;
            } else {
                this.q.zza(this.n, this.m.zzbfk, zzooVar);
                return zza;
            }
        }
    }

    public final void a() {
        try {
            this.r.zzb(this.f11959a);
        } catch (RuntimeException e2) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e2);
        }
    }
}
