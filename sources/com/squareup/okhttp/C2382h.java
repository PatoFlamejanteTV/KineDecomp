package com.squareup.okhttp;

import android.support.v7.widget.ActivityChooserView;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheControl.java */
/* renamed from: com.squareup.okhttp.h */
/* loaded from: classes3.dex */
public final class C2382h {

    /* renamed from: a */
    public static final C2382h f25250a;

    /* renamed from: b */
    public static final C2382h f25251b;

    /* renamed from: c */
    private final boolean f25252c;

    /* renamed from: d */
    private final boolean f25253d;

    /* renamed from: e */
    private final int f25254e;

    /* renamed from: f */
    private final int f25255f;

    /* renamed from: g */
    private final boolean f25256g;

    /* renamed from: h */
    private final boolean f25257h;
    private final boolean i;
    private final int j;
    private final int k;
    private final boolean l;
    private final boolean m;
    String n;

    static {
        a aVar = new a();
        aVar.b();
        f25250a = aVar.a();
        a aVar2 = new a();
        aVar2.d();
        aVar2.a(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.SECONDS);
        f25251b = aVar2.a();
    }

    /* synthetic */ C2382h(a aVar, C2381g c2381g) {
        this(aVar);
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.f25252c) {
            sb.append("no-cache, ");
        }
        if (this.f25253d) {
            sb.append("no-store, ");
        }
        if (this.f25254e != -1) {
            sb.append("max-age=");
            sb.append(this.f25254e);
            sb.append(", ");
        }
        if (this.f25255f != -1) {
            sb.append("s-maxage=");
            sb.append(this.f25255f);
            sb.append(", ");
        }
        if (this.f25256g) {
            sb.append("private, ");
        }
        if (this.f25257h) {
            sb.append("public, ");
        }
        if (this.i) {
            sb.append("must-revalidate, ");
        }
        if (this.j != -1) {
            sb.append("max-stale=");
            sb.append(this.j);
            sb.append(", ");
        }
        if (this.k != -1) {
            sb.append("min-fresh=");
            sb.append(this.k);
            sb.append(", ");
        }
        if (this.l) {
            sb.append("only-if-cached, ");
        }
        if (this.m) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f25256g;
    }

    public boolean b() {
        return this.f25257h;
    }

    public int c() {
        return this.f25254e;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.k;
    }

    public boolean f() {
        return this.i;
    }

    public boolean g() {
        return this.f25252c;
    }

    public boolean h() {
        return this.f25253d;
    }

    public boolean i() {
        return this.l;
    }

    public String toString() {
        String str = this.n;
        if (str != null) {
            return str;
        }
        String j = j();
        this.n = j;
        return j;
    }

    private C2382h(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f25252c = z;
        this.f25253d = z2;
        this.f25254e = i;
        this.f25255f = i2;
        this.f25256g = z3;
        this.f25257h = z4;
        this.i = z5;
        this.j = i3;
        this.k = i4;
        this.l = z6;
        this.m = z7;
        this.n = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.squareup.okhttp.C2382h a(com.squareup.okhttp.x r21) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.C2382h.a(com.squareup.okhttp.x):com.squareup.okhttp.h");
    }

    /* compiled from: CacheControl.java */
    /* renamed from: com.squareup.okhttp.h$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        boolean f25258a;

        /* renamed from: b */
        boolean f25259b;

        /* renamed from: c */
        int f25260c = -1;

        /* renamed from: d */
        int f25261d = -1;

        /* renamed from: e */
        int f25262e = -1;

        /* renamed from: f */
        boolean f25263f;

        /* renamed from: g */
        boolean f25264g;

        public a a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f25261d = seconds > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public a b() {
            this.f25258a = true;
            return this;
        }

        public a c() {
            this.f25259b = true;
            return this;
        }

        public a d() {
            this.f25263f = true;
            return this;
        }

        public C2382h a() {
            return new C2382h(this);
        }
    }

    private C2382h(a aVar) {
        this.f25252c = aVar.f25258a;
        this.f25253d = aVar.f25259b;
        this.f25254e = aVar.f25260c;
        this.f25255f = -1;
        this.f25256g = false;
        this.f25257h = false;
        this.i = false;
        this.j = aVar.f25261d;
        this.k = aVar.f25262e;
        this.l = aVar.f25263f;
        this.m = aVar.f25264g;
    }
}
