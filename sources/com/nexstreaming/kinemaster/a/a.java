package com.nexstreaming.kinemaster.a;

import android.util.SparseIntArray;
import com.nexstreaming.app.general.util.SeedableRandom;

/* compiled from: BasicParticleSystem.java */
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private int f3255a;
    private b[] b;
    private int c;
    private int d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i;
    private SeedableRandom j;
    private long k;
    private double l;
    private double m;
    private double n;
    private double o;
    private int p;
    private int q;
    private boolean r;
    private double s;
    private double[] t;
    private double[] u;
    private int[] v;
    private SparseIntArray w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BasicParticleSystem.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public double f3257a;
        public double b;
        public double c;
        public double d;
        public float e;
        public float f;
        public int g;
        public int h;
        public int i;

        public b() {
        }

        public b(b bVar) {
            this.f3257a = bVar.f3257a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
        }

        public void a(b bVar) {
            this.f3257a = bVar.f3257a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
        }

        public String toString() {
            return "[P " + this.f3257a + "," + this.b + "; " + this.c + "," + this.d + " age=" + this.g + " lifetime=" + this.h + "]";
        }
    }

    public void a(double d, double d2) {
        this.e = d;
        this.f = d2;
    }

    public void a(double... dArr) {
        this.t = dArr;
    }

    public void b(double... dArr) {
        this.u = dArr;
    }

    public void b(double d, double d2) {
        this.l = d;
        this.m = d2;
    }

    public void a(int i, int i2) {
        this.p = i;
        this.q = i2;
    }

    public void a(double d) {
        this.g = d;
    }

    public a() {
        this.c = 0;
        this.d = -1;
        this.j = new SeedableRandom();
        this.k = -6335755299382366719L;
        this.l = 0.001d;
        this.m = 0.01d;
        this.n = 0.1d;
        this.o = 0.2d;
        this.p = 100;
        this.q = 120;
        this.r = false;
        this.s = 0.8d;
        this.w = new SparseIntArray();
        this.f3255a = 200;
        b();
    }

    public a(int i) {
        this.c = 0;
        this.d = -1;
        this.j = new SeedableRandom();
        this.k = -6335755299382366719L;
        this.l = 0.001d;
        this.m = 0.01d;
        this.n = 0.1d;
        this.o = 0.2d;
        this.p = 100;
        this.q = 120;
        this.r = false;
        this.s = 0.8d;
        this.w = new SparseIntArray();
        this.f3255a = i;
        b();
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public int a() {
        return this.c;
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public boolean a(int i, com.nexstreaming.kinemaster.a.b bVar) {
        if (i >= this.c) {
            return false;
        }
        bVar.f3258a = (float) this.b[i].f3257a;
        bVar.b = (float) this.b[i].b;
        bVar.e = (float) this.b[i].c;
        bVar.f = (float) this.b[i].d;
        bVar.d = this.b[i].e;
        bVar.c = this.b[i].f;
        bVar.g = this.b[i].i;
        return true;
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public void b() {
        if (this.b == null || this.b.length < this.f3255a) {
            this.b = new b[this.f3255a];
            for (int i = 0; i < this.f3255a; i++) {
                this.b[i] = new b();
            }
        }
        this.c = 0;
        this.d = -1;
        this.h = 0.0d;
        this.i = 0.0d;
        this.j.setSeed(this.k);
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public void c() {
        this.d++;
        this.i += this.g + this.w.get(this.d);
        while (this.h + 0.5d < this.i) {
            e();
        }
        int i = 0;
        while (i < this.c) {
            b bVar = this.b[i];
            bVar.g++;
            if (this.b[i].g > this.b[i].h) {
                System.arraycopy(this.b, i + 1, this.b, i, (this.b.length - i) - 1);
                this.b[this.b.length - 1] = bVar;
                this.c--;
                i--;
            } else {
                bVar.c += this.e;
                bVar.d += this.f;
                bVar.f3257a += bVar.c;
                bVar.b += bVar.d;
                if (this.r) {
                    if (bVar.d > 0.0d && bVar.b > 1.0d) {
                        bVar.b = 1.0d - (bVar.b - 1.0d);
                        bVar.d = (-bVar.d) * this.s;
                    } else if (bVar.d < 0.0d && bVar.b < -1.0d) {
                        bVar.b = (-1.0d) + ((-1.0d) - bVar.b);
                        bVar.d = (-bVar.d) * this.s;
                    }
                    if (bVar.c > 0.0d && bVar.f3257a > 1.0d) {
                        bVar.f3257a = 1.0d - (bVar.f3257a - 1.0d);
                        bVar.c = (-bVar.c) * this.s;
                    } else if (bVar.c < 0.0d && bVar.f3257a < -1.0d) {
                        bVar.f3257a = (-1.0d) + ((-1.0d) - bVar.f3257a);
                        bVar.c = (-bVar.c) * this.s;
                    }
                }
                if (this.t != null) {
                    if (this.t.length <= 0) {
                        bVar.e = 1.0f;
                    } else if (this.t.length == 1) {
                        bVar.e = (float) this.t[0];
                    } else {
                        double d = bVar.g / bVar.h;
                        double length = 1.0d / (this.t.length - 1);
                        int min = Math.min((int) (d / length), this.t.length - 2);
                        double d2 = (d - (min * length)) / length;
                        bVar.e = (float) (((1.0d - d2) * this.t[min]) + (this.t[min + 1] * d2));
                    }
                } else {
                    bVar.e = 1.0f;
                }
                if (this.u != null) {
                    if (this.u.length <= 0) {
                        bVar.f = 1.0f;
                    } else if (this.u.length == 1) {
                        bVar.f = (float) this.u[0];
                    } else {
                        double d3 = bVar.g / bVar.h;
                        double length2 = 1.0d / (this.u.length - 1);
                        int min2 = Math.min((int) (d3 / length2), this.u.length - 2);
                        double d4 = (d3 - (min2 * length2)) / length2;
                        bVar.f = (float) (((1.0d - d4) * this.u[min2]) + (this.u[min2 + 1] * d4));
                    }
                } else {
                    bVar.f = 1.0f;
                }
                if (this.v != null) {
                    if (this.v.length <= 0) {
                        bVar.i = -16777216;
                    } else if (this.v.length == 1) {
                        bVar.i = this.v[0];
                    } else {
                        double d5 = bVar.g / bVar.h;
                        double length3 = 1.0d / (this.v.length - 1);
                        int min3 = Math.min((int) (d5 / length3), this.v.length - 2);
                        bVar.i = a((float) ((d5 - (min3 * length3)) / length3), this.v[min3], this.v[min3 + 1]);
                    }
                } else {
                    bVar.i = 1;
                }
            }
            i++;
        }
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public d d() {
        return new C0066a(this);
    }

    @Override // com.nexstreaming.kinemaster.a.c
    public void a(d dVar) {
        ((C0066a) dVar).a(this);
    }

    /* compiled from: BasicParticleSystem.java */
    /* renamed from: com.nexstreaming.kinemaster.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0066a implements d {

        /* renamed from: a, reason: collision with root package name */
        private final b[] f3256a;
        private final int b;
        private final double c;
        private final double d;
        private final long e;

        public C0066a(a aVar) {
            this.f3256a = new b[aVar.c];
            this.b = aVar.d;
            this.c = aVar.h;
            this.d = aVar.i;
            this.e = aVar.j.saveSeed();
            for (int i = 0; i < this.f3256a.length; i++) {
                this.f3256a[i] = new b(aVar.b[i]);
            }
        }

        public void a(a aVar) {
            aVar.c = this.f3256a.length;
            aVar.d = this.b;
            aVar.h = this.c;
            aVar.i = this.d;
            aVar.j.restoreSeed(this.e);
            for (int i = 0; i < this.f3256a.length; i++) {
                aVar.b[i].a(this.f3256a[i]);
            }
        }
    }

    private int a(float f, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f))) << 16) | ((((int) ((((i2 >> 8) & 255) - r2) * f)) + ((i >> 8) & 255)) << 8) | (((int) (((i2 & 255) - r3) * f)) + (i & 255));
    }

    private void e() {
        this.h += 1.0d;
        if (this.c < this.f3255a) {
            b[] bVarArr = this.b;
            int i = this.c;
            this.c = i + 1;
            b bVar = bVarArr[i];
            double c = c(-3.141592653589793d, 3.141592653589793d);
            double c2 = c(-0.19634954084936207d, 0.19634954084936207d) + c;
            double c3 = c(this.l, this.m);
            double c4 = c(this.n, this.o);
            bVar.g = 0;
            bVar.f3257a = Math.cos(c) * c4;
            bVar.b = Math.sin(c) * c4;
            bVar.c = Math.cos(c2) * c3;
            bVar.d = Math.sin(c2) * c3;
            bVar.h = this.p + this.j.nextInt(this.q - this.p);
        }
    }

    private double c(double d, double d2) {
        return (this.j.nextDouble() * (d2 - d)) + d;
    }
}
