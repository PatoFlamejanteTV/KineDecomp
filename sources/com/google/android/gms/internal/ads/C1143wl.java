package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.wl, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1143wl {

    /* renamed from: a, reason: collision with root package name */
    private int f12637a = 1000;

    /* renamed from: b, reason: collision with root package name */
    private int[] f12638b;

    /* renamed from: c, reason: collision with root package name */
    private long[] f12639c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f12640d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f12641e;

    /* renamed from: f, reason: collision with root package name */
    private long[] f12642f;

    /* renamed from: g, reason: collision with root package name */
    private zzij[] f12643g;

    /* renamed from: h, reason: collision with root package name */
    private zzfs[] f12644h;
    private int i;
    private int j;
    private int k;
    private int l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    private zzfs q;

    public C1143wl() {
        int i = this.f12637a;
        this.f12638b = new int[i];
        this.f12639c = new long[i];
        this.f12642f = new long[i];
        this.f12641e = new int[i];
        this.f12640d = new int[i];
        this.f12643g = new zzij[i];
        this.f12644h = new zzfs[i];
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        this.p = true;
        this.o = true;
    }

    public final long a(int i) {
        int d2 = d() - i;
        zzpo.checkArgument(d2 >= 0 && d2 <= this.i);
        if (d2 == 0) {
            if (this.j == 0 && this.i == 0) {
                return 0L;
            }
            int i2 = this.l;
            if (i2 == 0) {
                i2 = this.f12637a;
            }
            return this.f12639c[i2 - 1] + this.f12640d[r0];
        }
        this.i -= d2;
        int i3 = this.l;
        int i4 = this.f12637a;
        this.l = ((i3 + i4) - d2) % i4;
        this.n = Long.MIN_VALUE;
        for (int i5 = this.i - 1; i5 >= 0; i5--) {
            int i6 = (this.k + i5) % this.f12637a;
            this.n = Math.max(this.n, this.f12642f[i6]);
            if ((this.f12641e[i6] & 1) != 0) {
                break;
            }
        }
        return this.f12639c[this.l];
    }

    public final void b() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.i = 0;
        this.o = true;
    }

    public final void c() {
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
    }

    public final int d() {
        return this.j + this.i;
    }

    public final int e() {
        return this.j;
    }

    public final synchronized boolean f() {
        return this.i != 0;
    }

    public final synchronized zzfs g() {
        if (this.p) {
            return null;
        }
        return this.q;
    }

    public final synchronized long h() {
        if (!f()) {
            return -1L;
        }
        int i = ((this.k + this.i) - 1) % this.f12637a;
        this.k = (this.k + this.i) % this.f12637a;
        this.j += this.i;
        this.i = 0;
        return this.f12639c[i] + this.f12640d[i];
    }

    public final synchronized long a() {
        return Math.max(this.m, this.n);
    }

    public final synchronized int a(zzfu zzfuVar, zzho zzhoVar, boolean z, boolean z2, zzfs zzfsVar, zzlr zzlrVar) {
        if (!f()) {
            if (z2) {
                zzhoVar.setFlags(4);
                return -4;
            }
            if (this.q == null || (!z && this.q == zzfsVar)) {
                return -3;
            }
            zzfuVar.zzaad = this.q;
            return -5;
        }
        if (!z && this.f12644h[this.k] == zzfsVar) {
            if (zzhoVar.zzdd == null) {
                return -3;
            }
            zzhoVar.zzago = this.f12642f[this.k];
            zzhoVar.setFlags(this.f12641e[this.k]);
            zzlrVar.size = this.f12640d[this.k];
            zzlrVar.zzapb = this.f12639c[this.k];
            zzlrVar.zzajw = this.f12643g[this.k];
            this.m = Math.max(this.m, zzhoVar.zzago);
            this.i--;
            this.k++;
            this.j++;
            if (this.k == this.f12637a) {
                this.k = 0;
            }
            zzlrVar.zzayl = this.i > 0 ? this.f12639c[this.k] : zzlrVar.zzapb + zzlrVar.size;
            return -4;
        }
        zzfuVar.zzaad = this.f12644h[this.k];
        return -5;
    }

    public final synchronized long a(long j, boolean z) {
        if (f() && j >= this.f12642f[this.k]) {
            if (j > this.n && !z) {
                return -1L;
            }
            int i = this.k;
            int i2 = -1;
            int i3 = 0;
            while (i != this.l && this.f12642f[i] <= j) {
                if ((this.f12641e[i] & 1) != 0) {
                    i2 = i3;
                }
                i = (i + 1) % this.f12637a;
                i3++;
            }
            if (i2 == -1) {
                return -1L;
            }
            this.k = (this.k + i2) % this.f12637a;
            this.j += i2;
            this.i -= i2;
            return this.f12639c[this.k];
        }
        return -1L;
    }

    public final synchronized boolean a(zzfs zzfsVar) {
        if (zzfsVar == null) {
            this.p = true;
            return false;
        }
        this.p = false;
        if (zzqe.zza(zzfsVar, this.q)) {
            return false;
        }
        this.q = zzfsVar;
        return true;
    }

    public final synchronized void a(long j, int i, long j2, int i2, zzij zzijVar) {
        if (this.o) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.o = false;
            }
        }
        zzpo.checkState(!this.p);
        a(j);
        this.f12642f[this.l] = j;
        this.f12639c[this.l] = j2;
        this.f12640d[this.l] = i2;
        this.f12641e[this.l] = i;
        this.f12643g[this.l] = zzijVar;
        this.f12644h[this.l] = this.q;
        this.f12638b[this.l] = 0;
        this.i++;
        if (this.i == this.f12637a) {
            int i3 = this.f12637a + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            zzij[] zzijVarArr = new zzij[i3];
            zzfs[] zzfsVarArr = new zzfs[i3];
            int i4 = this.f12637a - this.k;
            System.arraycopy(this.f12639c, this.k, jArr, 0, i4);
            System.arraycopy(this.f12642f, this.k, jArr2, 0, i4);
            System.arraycopy(this.f12641e, this.k, iArr2, 0, i4);
            System.arraycopy(this.f12640d, this.k, iArr3, 0, i4);
            System.arraycopy(this.f12643g, this.k, zzijVarArr, 0, i4);
            System.arraycopy(this.f12644h, this.k, zzfsVarArr, 0, i4);
            System.arraycopy(this.f12638b, this.k, iArr, 0, i4);
            int i5 = this.k;
            System.arraycopy(this.f12639c, 0, jArr, i4, i5);
            System.arraycopy(this.f12642f, 0, jArr2, i4, i5);
            System.arraycopy(this.f12641e, 0, iArr2, i4, i5);
            System.arraycopy(this.f12640d, 0, iArr3, i4, i5);
            System.arraycopy(this.f12643g, 0, zzijVarArr, i4, i5);
            System.arraycopy(this.f12644h, 0, zzfsVarArr, i4, i5);
            System.arraycopy(this.f12638b, 0, iArr, i4, i5);
            this.f12639c = jArr;
            this.f12642f = jArr2;
            this.f12641e = iArr2;
            this.f12640d = iArr3;
            this.f12643g = zzijVarArr;
            this.f12644h = zzfsVarArr;
            this.f12638b = iArr;
            this.k = 0;
            this.l = this.f12637a;
            this.i = this.f12637a;
            this.f12637a = i3;
            return;
        }
        this.l++;
        if (this.l == this.f12637a) {
            this.l = 0;
        }
    }

    public final synchronized void a(long j) {
        this.n = Math.max(this.n, j);
    }
}
