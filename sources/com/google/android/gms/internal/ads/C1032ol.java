package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.ol */
/* loaded from: classes2.dex */
public final class C1032ol implements zzib, zzlm, zzlu, zzpg<C1101tl> {
    private boolean[] A;
    private boolean B;
    private long D;
    private int F;
    private boolean G;
    private boolean H;

    /* renamed from: a */
    private final Uri f12398a;

    /* renamed from: b */
    private final zzov f12399b;

    /* renamed from: c */
    private final int f12400c;

    /* renamed from: d */
    private final Handler f12401d;

    /* renamed from: e */
    private final zzll f12402e;

    /* renamed from: f */
    private final zzlp f12403f;

    /* renamed from: g */
    private final zzot f12404g;

    /* renamed from: h */
    private final String f12405h;
    private final long i;
    private final C1115ul k;
    private zzln q;
    private zzig r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private zzma x;
    private long y;
    private boolean[] z;
    private final zzpf j = new zzpf("Loader:ExtractorMediaPeriod");
    private final zzpq l = new zzpq();
    private final Runnable m = new RunnableC1046pl(this);
    private final Runnable n = new RunnableC1060ql(this);
    private final Handler o = new Handler();
    private long E = -9223372036854775807L;
    private final SparseArray<zzls> p = new SparseArray<>();
    private long C = -1;

    public C1032ol(Uri uri, zzov zzovVar, zzhz[] zzhzVarArr, int i, Handler handler, zzll zzllVar, zzlp zzlpVar, zzot zzotVar, String str, int i2) {
        this.f12398a = uri;
        this.f12399b = zzovVar;
        this.f12400c = i;
        this.f12401d = handler;
        this.f12402e = zzllVar;
        this.f12403f = zzlpVar;
        this.f12404g = zzotVar;
        this.f12405h = str;
        this.i = i2;
        this.k = new C1115ul(zzhzVarArr, this);
    }

    private final void c() {
        zzig zzigVar;
        C1101tl c1101tl = new C1101tl(this, this.f12398a, this.f12399b, this.k, this.l);
        if (this.t) {
            zzpo.checkState(g());
            long j = this.y;
            if (j != -9223372036854775807L && this.E >= j) {
                this.G = true;
                this.E = -9223372036854775807L;
                return;
            } else {
                c1101tl.a(this.r.zzr(this.E), this.E);
                this.E = -9223372036854775807L;
            }
        }
        this.F = e();
        int i = this.f12400c;
        if (i == -1) {
            i = (this.t && this.C == -1 && ((zzigVar = this.r) == null || zzigVar.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.j.zza(c1101tl, this, i);
    }

    public final void d() {
        if (this.H || this.t || this.r == null || !this.s) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            if (this.p.valueAt(i).zzfn() == null) {
                return;
            }
        }
        this.l.zzha();
        zzlz[] zzlzVarArr = new zzlz[size];
        this.A = new boolean[size];
        this.z = new boolean[size];
        this.y = this.r.getDurationUs();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < size) {
                zzfs zzfn = this.p.valueAt(i2).zzfn();
                zzlzVarArr[i2] = new zzlz(zzfn);
                String str = zzfn.zzzj;
                if (!zzpt.zzac(str) && !zzpt.zzab(str)) {
                    z = false;
                }
                this.A[i2] = z;
                this.B = z | this.B;
                i2++;
            } else {
                this.x = new zzma(zzlzVarArr);
                this.t = true;
                this.f12403f.zzb(new zzly(this.y, this.r.zzdw()), null);
                this.q.zza((zzlm) this);
                return;
            }
        }
    }

    private final int e() {
        int size = this.p.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.p.valueAt(i2).zzfk();
        }
        return i;
    }

    private final long f() {
        int size = this.p.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.p.valueAt(i).zzfc());
        }
        return j;
    }

    private final boolean g() {
        return this.E != -9223372036854775807L;
    }

    public final void a() {
        this.j.zza(new RunnableC1073rl(this, this.k));
        this.o.removeCallbacksAndMessages(null);
        this.H = true;
    }

    public final void b() throws IOException {
        this.j.zzbi(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zza(zzln zzlnVar, long j) {
        this.q = zzlnVar;
        this.l.zzgz();
        c();
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zzaa(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzab(long j) {
        if (!this.r.zzdw()) {
            j = 0;
        }
        this.D = j;
        int size = this.p.size();
        boolean z = !g();
        for (int i = 0; z && i < size; i++) {
            if (this.z[i]) {
                z = this.p.valueAt(i).zze(j, false);
            }
        }
        if (!z) {
            this.E = j;
            this.G = false;
            if (this.j.isLoading()) {
                this.j.zzgy();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.p.valueAt(i2).zzh(this.z[i2]);
                }
            }
        }
        this.v = false;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final zzii zzb(int i, int i2) {
        zzls zzlsVar = this.p.get(i);
        if (zzlsVar != null) {
            return zzlsVar;
        }
        zzls zzlsVar2 = new zzls(this.f12404g);
        zzlsVar2.zza(this);
        this.p.put(i, zzlsVar2);
        return zzlsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final void zzdy() {
        this.s = true;
        this.o.post(this.m);
    }

    @Override // com.google.android.gms.internal.ads.zzlm, com.google.android.gms.internal.ads.zzlw
    public final long zzeu() {
        if (this.w == 0) {
            return Long.MIN_VALUE;
        }
        return zzez();
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zzew() throws IOException {
        this.j.zzbi(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final zzma zzex() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzey() {
        if (!this.v) {
            return -9223372036854775807L;
        }
        this.v = false;
        return this.D;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzez() {
        long f2;
        if (this.G) {
            return Long.MIN_VALUE;
        }
        if (g()) {
            return this.E;
        }
        if (this.B) {
            f2 = Long.MAX_VALUE;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                if (this.A[i]) {
                    f2 = Math.min(f2, this.p.valueAt(i).zzfc());
                }
            }
        } else {
            f2 = f();
        }
        return f2 == Long.MIN_VALUE ? this.D : f2;
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzg(zzfs zzfsVar) {
        this.o.post(this.m);
    }

    @Override // com.google.android.gms.internal.ads.zzlm, com.google.android.gms.internal.ads.zzlw
    public final boolean zzy(long j) {
        if (this.G) {
            return false;
        }
        if (this.t && this.w == 0) {
            return false;
        }
        boolean zzgz = this.l.zzgz();
        if (this.j.isLoading()) {
            return zzgz;
        }
        c();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zza(zzom[] zzomVarArr, boolean[] zArr, zzlv[] zzlvVarArr, boolean[] zArr2, long j) {
        int i;
        zzpo.checkState(this.t);
        for (int i2 = 0; i2 < zzomVarArr.length; i2++) {
            if (zzlvVarArr[i2] != null && (zzomVarArr[i2] == null || !zArr[i2])) {
                i = ((C1129vl) zzlvVarArr[i2]).f12614a;
                zzpo.checkState(this.z[i]);
                this.w--;
                this.z[i] = false;
                this.p.valueAt(i).disable();
                zzlvVarArr[i2] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < zzomVarArr.length; i3++) {
            if (zzlvVarArr[i3] == null && zzomVarArr[i3] != null) {
                zzom zzomVar = zzomVarArr[i3];
                zzpo.checkState(zzomVar.length() == 1);
                zzpo.checkState(zzomVar.zzbd(0) == 0);
                int zza = this.x.zza(zzomVar.zzgk());
                zzpo.checkState(!this.z[zza]);
                this.w++;
                this.z[zza] = true;
                zzlvVarArr[i3] = new C1129vl(this, zza);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.u) {
            int size = this.p.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.z[i4]) {
                    this.p.valueAt(i4).disable();
                }
            }
        }
        if (this.w == 0) {
            this.v = false;
            if (this.j.isLoading()) {
                this.j.zzgy();
            }
        } else if (!this.u ? j != 0 : z) {
            j = zzab(j);
            for (int i5 = 0; i5 < zzlvVarArr.length; i5++) {
                if (zzlvVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.u = true;
        return j;
    }

    public final boolean a(int i) {
        if (this.G) {
            return true;
        }
        return !g() && this.p.valueAt(i).zzfm();
    }

    public final int a(int i, zzfu zzfuVar, zzho zzhoVar, boolean z) {
        if (this.v || g()) {
            return -3;
        }
        return this.p.valueAt(i).zza(zzfuVar, zzhoVar, z, this.G, this.D);
    }

    public final void a(int i, long j) {
        zzls valueAt = this.p.valueAt(i);
        if (this.G && j > valueAt.zzfc()) {
            valueAt.zzfp();
        } else {
            valueAt.zze(j, true);
        }
    }

    private final void a(C1101tl c1101tl) {
        long j;
        if (this.C == -1) {
            j = c1101tl.i;
            this.C = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public final void zza(zzig zzigVar) {
        this.r = zzigVar;
        this.o.post(this.m);
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ int zza(C1101tl c1101tl, long j, long j2, IOException iOException) {
        zzig zzigVar;
        C1101tl c1101tl2 = c1101tl;
        a(c1101tl2);
        Handler handler = this.f12401d;
        if (handler != null && this.f12402e != null) {
            handler.post(new RunnableC1087sl(this, iOException));
        }
        if (iOException instanceof zzmb) {
            return 3;
        }
        boolean z = e() > this.F;
        if (this.C == -1 && ((zzigVar = this.r) == null || zzigVar.getDurationUs() == -9223372036854775807L)) {
            this.D = 0L;
            this.v = this.t;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                this.p.valueAt(i).zzh(!this.t || this.z[i]);
            }
            c1101tl2.a(0L, 0L);
        }
        this.F = e();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ void zza(C1101tl c1101tl, long j, long j2, boolean z) {
        a(c1101tl);
        if (z || this.w <= 0) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            this.p.valueAt(i).zzh(this.z[i]);
        }
        this.q.zza((zzln) this);
    }

    @Override // com.google.android.gms.internal.ads.zzpg
    public final /* synthetic */ void zza(C1101tl c1101tl, long j, long j2) {
        a(c1101tl);
        this.G = true;
        if (this.y == -9223372036854775807L) {
            long f2 = f();
            this.y = f2 == Long.MIN_VALUE ? 0L : f2 + 10000;
            this.f12403f.zzb(new zzly(this.y, this.r.zzdw()), null);
        }
        this.q.zza((zzln) this);
    }
}
