package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Uj implements zzfg {

    /* renamed from: a, reason: collision with root package name */
    private final zzfz[] f11880a;

    /* renamed from: b, reason: collision with root package name */
    private final zzop f11881b;

    /* renamed from: c, reason: collision with root package name */
    private final zzoo f11882c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f11883d;

    /* renamed from: e, reason: collision with root package name */
    private final Wj f11884e;

    /* renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArraySet<zzfh> f11885f;

    /* renamed from: g, reason: collision with root package name */
    private final zzgf f11886g;

    /* renamed from: h, reason: collision with root package name */
    private final zzge f11887h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private zzgc p;
    private Object q;
    private zzma r;
    private zzoo s;
    private zzfy t;
    private zzfp u;
    private int v;
    private int w;
    private long x;

    @SuppressLint({"HandlerLeak"})
    public Uj(zzfz[] zzfzVarArr, zzop zzopVar, zzfw zzfwVar) {
        String str = zzqe.zzbic;
        StringBuilder sb = new StringBuilder("Init ExoPlayerLib/2.4.2 [".length() + 1 + String.valueOf(str).length());
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzpo.checkState(zzfzVarArr.length > 0);
        zzpo.checkNotNull(zzfzVarArr);
        this.f11880a = zzfzVarArr;
        zzpo.checkNotNull(zzopVar);
        this.f11881b = zzopVar;
        this.j = false;
        this.k = 0;
        this.l = 1;
        this.f11885f = new CopyOnWriteArraySet<>();
        this.f11882c = new zzoo(new zzom[zzfzVarArr.length]);
        this.p = zzgc.zzaal;
        this.f11886g = new zzgf();
        this.f11887h = new zzge();
        this.r = zzma.zzazi;
        this.s = this.f11882c;
        this.t = zzfy.zzaaf;
        this.f11883d = new Vj(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.u = new zzfp(0, 0L);
        this.f11884e = new Wj(zzfzVarArr, zzopVar, zzfwVar, this.j, 0, this.f11883d, this.u, this);
    }

    private final int a() {
        if (!this.p.isEmpty() && this.m <= 0) {
            this.p.zza(this.u.zzyr, this.f11887h, false);
            return 0;
        }
        return this.v;
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final long getBufferedPosition() {
        if (!this.p.isEmpty() && this.m <= 0) {
            this.p.zza(this.u.zzyr, this.f11887h, false);
            return this.f11887h.zzcm() + zzfe.zzf(this.u.zzza);
        }
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final long getDuration() {
        if (this.p.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzfe.zzf(this.p.zza(a(), this.f11886g, false, 0L).zzaan);
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final int getPlaybackState() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final void release() {
        this.f11884e.a();
        this.f11883d.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final void seekTo(long j) {
        long zzg;
        int a2 = a();
        if (a2 >= 0 && (this.p.isEmpty() || a2 < this.p.zzck())) {
            this.m++;
            this.v = a2;
            if (this.p.isEmpty()) {
                this.w = 0;
            } else {
                this.p.zza(a2, this.f11886g, false, 0L);
                if (j == -9223372036854775807L) {
                    zzg = this.f11886g.zzaaw;
                } else {
                    zzg = zzfe.zzg(j);
                }
                long j2 = this.f11886g.zzaax + zzg;
                long j3 = this.p.zza(0, this.f11887h, false).zzaan;
                int i = 0;
                while (j3 != -9223372036854775807L && j2 >= j3 && i < this.f11886g.zzaav) {
                    j2 -= j3;
                    i++;
                    j3 = this.p.zza(i, this.f11887h, false).zzaan;
                }
                this.w = i;
            }
            if (j == -9223372036854775807L) {
                this.x = 0L;
                this.f11884e.a(this.p, a2, -9223372036854775807L);
                return;
            }
            this.x = j;
            this.f11884e.a(this.p, a2, zzfe.zzg(j));
            Iterator<zzfh> it = this.f11885f.iterator();
            while (it.hasNext()) {
                it.next().zzbs();
            }
            return;
        }
        throw new zzfv(this.p, a2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final void stop() {
        this.f11884e.b();
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final void zza(zzfh zzfhVar) {
        this.f11885f.add(zzfhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final void zzb(zzfh zzfhVar) {
        this.f11885f.remove(zzfhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final boolean zzbp() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final int zzbq() {
        return this.f11880a.length;
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final long zzbr() {
        if (!this.p.isEmpty() && this.m <= 0) {
            this.p.zza(this.u.zzyr, this.f11887h, false);
            return this.f11887h.zzcm() + zzfe.zzf(this.u.zzyz);
        }
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final void zzc(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.f11884e.a(z);
            Iterator<zzfh> it = this.f11885f.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.l);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final void zza(zzlo zzloVar) {
        if (!this.p.isEmpty() || this.q != null) {
            this.p = zzgc.zzaal;
            this.q = null;
            Iterator<zzfh> it = this.f11885f.iterator();
            while (it.hasNext()) {
                it.next().zza(this.p, this.q);
            }
        }
        if (this.i) {
            this.i = false;
            this.r = zzma.zzazi;
            this.s = this.f11882c;
            this.f11881b.zzd(null);
            Iterator<zzfh> it2 = this.f11885f.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.r, this.s);
            }
        }
        this.n++;
        this.f11884e.a(zzloVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final void zzb(zzfj... zzfjVarArr) {
        this.f11884e.b(zzfjVarArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Message message) {
        switch (message.what) {
            case 0:
                this.n--;
                return;
            case 1:
                this.l = message.arg1;
                Iterator<zzfh> it = this.f11885f.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.j, this.l);
                }
                return;
            case 2:
                this.o = message.arg1 != 0;
                Iterator<zzfh> it2 = this.f11885f.iterator();
                while (it2.hasNext()) {
                    it2.next().zzd(this.o);
                }
                return;
            case 3:
                if (this.n == 0) {
                    zzor zzorVar = (zzor) message.obj;
                    this.i = true;
                    this.r = zzorVar.zzbfk;
                    this.s = zzorVar.zzbfl;
                    this.f11881b.zzd(zzorVar.zzbfm);
                    Iterator<zzfh> it3 = this.f11885f.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.r, this.s);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.m - 1;
                this.m = i;
                if (i == 0) {
                    this.u = (zzfp) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzfh> it4 = this.f11885f.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzbs();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.m == 0) {
                    this.u = (zzfp) message.obj;
                    Iterator<zzfh> it5 = this.f11885f.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzbs();
                    }
                    return;
                }
                return;
            case 6:
                zzfr zzfrVar = (zzfr) message.obj;
                this.m -= zzfrVar.zzzd;
                if (this.n == 0) {
                    this.p = zzfrVar.zzxi;
                    this.q = zzfrVar.zzxj;
                    this.u = zzfrVar.zzxn;
                    Iterator<zzfh> it6 = this.f11885f.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.p, this.q);
                    }
                    return;
                }
                return;
            case 7:
                zzfy zzfyVar = (zzfy) message.obj;
                if (this.t.equals(zzfyVar)) {
                    return;
                }
                this.t = zzfyVar;
                Iterator<zzfh> it7 = this.f11885f.iterator();
                while (it7.hasNext()) {
                    it7.next().zza(zzfyVar);
                }
                return;
            case 8:
                zzff zzffVar = (zzff) message.obj;
                Iterator<zzfh> it8 = this.f11885f.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzffVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfg
    public final void zza(zzfj... zzfjVarArr) {
        this.f11884e.a(zzfjVarArr);
    }
}
