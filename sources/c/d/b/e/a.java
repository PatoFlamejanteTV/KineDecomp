package c.d.b.e;

import android.util.SparseIntArray;
import com.nexstreaming.app.general.util.SeedableRandom;

/* compiled from: BasicParticleSystem.java */
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a */
    private int f3763a;

    /* renamed from: b */
    private b[] f3764b;

    /* renamed from: e */
    private double f3767e;

    /* renamed from: f */
    private double f3768f;

    /* renamed from: g */
    private double f3769g;

    /* renamed from: h */
    private double f3770h;
    private double i;
    private double[] t;
    private double[] u;
    private int[] v;

    /* renamed from: c */
    private int f3765c = 0;

    /* renamed from: d */
    private int f3766d = -1;
    private SeedableRandom j = new SeedableRandom();
    private long k = -6335755299382366719L;
    private double l = 0.001d;
    private double m = 0.01d;
    private double n = 0.1d;
    private double o = 0.2d;
    private int p = 100;
    private int q = 120;
    private boolean r = false;
    private double s = 0.8d;
    private SparseIntArray w = new SparseIntArray();

    /* compiled from: BasicParticleSystem.java */
    /* renamed from: c.d.b.e.a$a */
    /* loaded from: classes.dex */
    private static class C0016a implements d {

        /* renamed from: a */
        private final b[] f3771a;

        /* renamed from: b */
        private final int f3772b;

        /* renamed from: c */
        private final double f3773c;

        /* renamed from: d */
        private final double f3774d;

        /* renamed from: e */
        private final long f3775e;

        public C0016a(a aVar) {
            this.f3771a = new b[aVar.f3765c];
            this.f3772b = aVar.f3766d;
            this.f3773c = aVar.f3770h;
            this.f3774d = aVar.i;
            this.f3775e = aVar.j.saveSeed();
            int i = 0;
            while (true) {
                b[] bVarArr = this.f3771a;
                if (i >= bVarArr.length) {
                    return;
                }
                bVarArr[i] = new b(aVar.f3764b[i]);
                i++;
            }
        }

        public void a(a aVar) {
            aVar.f3765c = this.f3771a.length;
            aVar.f3766d = this.f3772b;
            aVar.f3770h = this.f3773c;
            aVar.i = this.f3774d;
            aVar.j.restoreSeed(this.f3775e);
            for (int i = 0; i < this.f3771a.length; i++) {
                aVar.f3764b[i].a(this.f3771a[i]);
            }
        }
    }

    /* compiled from: BasicParticleSystem.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public double f3776a;

        /* renamed from: b */
        public double f3777b;

        /* renamed from: c */
        public double f3778c;

        /* renamed from: d */
        public double f3779d;

        /* renamed from: e */
        public float f3780e;

        /* renamed from: f */
        public float f3781f;

        /* renamed from: g */
        public int f3782g;

        /* renamed from: h */
        public int f3783h;
        public int i;

        public b() {
        }

        public void a(b bVar) {
            this.f3776a = bVar.f3776a;
            this.f3777b = bVar.f3777b;
            this.f3778c = bVar.f3778c;
            this.f3779d = bVar.f3779d;
            this.f3780e = bVar.f3780e;
            this.f3781f = bVar.f3781f;
            this.f3782g = bVar.f3782g;
            this.f3783h = bVar.f3783h;
            this.i = bVar.i;
        }

        public String toString() {
            return "[P " + this.f3776a + "," + this.f3777b + "; " + this.f3778c + "," + this.f3779d + " age=" + this.f3782g + " lifetime=" + this.f3783h + "]";
        }

        public b(b bVar) {
            this.f3776a = bVar.f3776a;
            this.f3777b = bVar.f3777b;
            this.f3778c = bVar.f3778c;
            this.f3779d = bVar.f3779d;
            this.f3780e = bVar.f3780e;
            this.f3781f = bVar.f3781f;
            this.f3782g = bVar.f3782g;
            this.f3783h = bVar.f3783h;
            this.i = bVar.i;
        }
    }

    public a(int i) {
        this.f3763a = i;
        rewind();
    }

    private int a(float f2, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f2))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f2))) << 16) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r2) * f2))) << 8) | ((i & 255) + ((int) (f2 * ((i2 & 255) - r8))));
    }

    @Override // c.d.b.e.c
    public void rewind() {
        b[] bVarArr = this.f3764b;
        if (bVarArr == null || bVarArr.length < this.f3763a) {
            this.f3764b = new b[this.f3763a];
            for (int i = 0; i < this.f3763a; i++) {
                this.f3764b[i] = new b();
            }
        }
        this.f3765c = 0;
        this.f3766d = -1;
        this.f3770h = 0.0d;
        this.i = 0.0d;
        this.j.setSeed(this.k);
    }

    private void d() {
        this.f3770h += 1.0d;
        int i = this.f3765c;
        if (i >= this.f3763a) {
            return;
        }
        b[] bVarArr = this.f3764b;
        this.f3765c = i + 1;
        b bVar = bVarArr[i];
        double d2 = d(-3.141592653589793d, 3.141592653589793d);
        double d3 = d(-0.19634954084936207d, 0.19634954084936207d) + d2;
        double d4 = d(this.l, this.m);
        double d5 = d(this.n, this.o);
        bVar.f3782g = 0;
        bVar.f3776a = Math.cos(d2) * d5;
        bVar.f3777b = Math.sin(d2) * d5;
        bVar.f3778c = Math.cos(d3) * d4;
        bVar.f3779d = Math.sin(d3) * d4;
        int i2 = this.p;
        bVar.f3783h = i2 + this.j.nextInt(this.q - i2);
    }

    public void c(double d2, double d3) {
        this.l = d2;
        this.m = d3;
    }

    public void a(long j) {
        this.k = j;
    }

    public void b(double... dArr) {
        this.u = dArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d1  */
    @Override // c.d.b.e.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.b.e.a.c():void");
    }

    public void a(double d2, double d3) {
        this.f3767e = d2;
        this.f3768f = d3;
    }

    public void b(double d2, double d3) {
        this.n = d2;
        this.o = d3;
    }

    public void a(double... dArr) {
        this.t = dArr;
    }

    @Override // c.d.b.e.c
    public d b() {
        return new C0016a(this);
    }

    public void a(int i, int i2) {
        this.p = i;
        this.q = i2;
    }

    public void a(double d2) {
        this.f3769g = d2;
    }

    @Override // c.d.b.e.c
    public int a() {
        return this.f3765c;
    }

    @Override // c.d.b.e.c
    public boolean a(int i, c.d.b.e.b bVar) {
        if (i >= this.f3765c) {
            return false;
        }
        b[] bVarArr = this.f3764b;
        bVar.f3784a = (float) bVarArr[i].f3776a;
        bVar.f3785b = (float) bVarArr[i].f3777b;
        bVar.f3788e = (float) bVarArr[i].f3778c;
        bVar.f3789f = (float) bVarArr[i].f3779d;
        bVar.f3787d = bVarArr[i].f3780e;
        bVar.f3786c = bVarArr[i].f3781f;
        bVar.f3790g = bVarArr[i].i;
        return true;
    }

    private double d(double d2, double d3) {
        return d2 + (this.j.nextDouble() * (d3 - d2));
    }

    @Override // c.d.b.e.c
    public void a(d dVar) {
        ((C0016a) dVar).a(this);
    }
}
