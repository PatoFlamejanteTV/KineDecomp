package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Request.java */
/* loaded from: classes3.dex */
public final class C {

    /* renamed from: a */
    private static final long f25543a = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: b */
    int f25544b;

    /* renamed from: c */
    long f25545c;

    /* renamed from: d */
    int f25546d;

    /* renamed from: e */
    public final Uri f25547e;

    /* renamed from: f */
    public final int f25548f;

    /* renamed from: g */
    public final String f25549g;

    /* renamed from: h */
    public final List<J> f25550h;
    public final int i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final float n;
    public final float o;
    public final float p;
    public final boolean q;
    public final Bitmap.Config r;
    public final Picasso.Priority s;

    /* synthetic */ C(Uri uri, int i, String str, List list, int i2, int i3, boolean z, boolean z2, boolean z3, float f2, float f3, float f4, boolean z4, Bitmap.Config config, Picasso.Priority priority, B b2) {
        this(uri, i, str, list, i2, i3, z, z2, z3, f2, f3, f4, z4, config, priority);
    }

    public String a() {
        Uri uri = this.f25547e;
        if (uri != null) {
            return String.valueOf(uri.getPath());
        }
        return Integer.toHexString(this.f25548f);
    }

    public boolean b() {
        return this.f25550h != null;
    }

    public boolean c() {
        return (this.i == 0 && this.j == 0) ? false : true;
    }

    public String d() {
        long nanoTime = System.nanoTime() - this.f25545c;
        if (nanoTime > f25543a) {
            return g() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return g() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    public boolean e() {
        return c() || this.n != 0.0f;
    }

    public boolean f() {
        return e() || b();
    }

    public String g() {
        return "[R" + this.f25544b + ']';
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i = this.f25548f;
        if (i > 0) {
            sb.append(i);
        } else {
            sb.append(this.f25547e);
        }
        List<J> list = this.f25550h;
        if (list != null && !list.isEmpty()) {
            for (J j : this.f25550h) {
                sb.append(' ');
                sb.append(j.key());
            }
        }
        if (this.f25549g != null) {
            sb.append(" stableKey(");
            sb.append(this.f25549g);
            sb.append(')');
        }
        if (this.i > 0) {
            sb.append(" resize(");
            sb.append(this.i);
            sb.append(',');
            sb.append(this.j);
            sb.append(')');
        }
        if (this.k) {
            sb.append(" centerCrop");
        }
        if (this.l) {
            sb.append(" centerInside");
        }
        if (this.n != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.n);
            if (this.q) {
                sb.append(" @ ");
                sb.append(this.o);
                sb.append(',');
                sb.append(this.p);
            }
            sb.append(')');
        }
        if (this.r != null) {
            sb.append(' ');
            sb.append(this.r);
        }
        sb.append('}');
        return sb.toString();
    }

    private C(Uri uri, int i, String str, List<J> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f2, float f3, float f4, boolean z4, Bitmap.Config config, Picasso.Priority priority) {
        this.f25547e = uri;
        this.f25548f = i;
        this.f25549g = str;
        if (list == null) {
            this.f25550h = null;
        } else {
            this.f25550h = Collections.unmodifiableList(list);
        }
        this.i = i2;
        this.j = i3;
        this.k = z;
        this.l = z2;
        this.m = z3;
        this.n = f2;
        this.o = f3;
        this.p = f4;
        this.q = z4;
        this.r = config;
        this.s = priority;
    }

    /* compiled from: Request.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        private Uri f25551a;

        /* renamed from: b */
        private int f25552b;

        /* renamed from: c */
        private String f25553c;

        /* renamed from: d */
        private int f25554d;

        /* renamed from: e */
        private int f25555e;

        /* renamed from: f */
        private boolean f25556f;

        /* renamed from: g */
        private boolean f25557g;

        /* renamed from: h */
        private boolean f25558h;
        private float i;
        private float j;
        private float k;
        private boolean l;
        private List<J> m;
        private Bitmap.Config n;
        private Picasso.Priority o;

        public a(Uri uri, int i, Bitmap.Config config) {
            this.f25551a = uri;
            this.f25552b = i;
            this.n = config;
        }

        public a a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
            if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            }
            this.f25554d = i;
            this.f25555e = i2;
            return this;
        }

        public boolean b() {
            return (this.f25551a == null && this.f25552b == 0) ? false : true;
        }

        public boolean c() {
            return (this.f25554d == 0 && this.f25555e == 0) ? false : true;
        }

        public C a() {
            if (this.f25557g && this.f25556f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f25556f && this.f25554d == 0 && this.f25555e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (this.f25557g && this.f25554d == 0 && this.f25555e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            }
            if (this.o == null) {
                this.o = Picasso.Priority.NORMAL;
            }
            return new C(this.f25551a, this.f25552b, this.f25553c, this.m, this.f25554d, this.f25555e, this.f25556f, this.f25557g, this.f25558h, this.i, this.j, this.k, this.l, this.n, this.o);
        }
    }
}
