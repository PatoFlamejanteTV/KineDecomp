package com.android.billingclient.api;

/* compiled from: BillingFlowParams.java */
/* loaded from: classes.dex */
public class F {

    /* renamed from: a */
    private P f7859a;

    /* renamed from: b */
    private String f7860b;

    /* renamed from: c */
    private String f7861c;

    /* renamed from: d */
    private boolean f7862d;

    /* renamed from: e */
    private int f7863e = 0;

    /* renamed from: f */
    private String f7864f;

    /* compiled from: BillingFlowParams.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private P f7865a;

        /* renamed from: b */
        private String f7866b;

        /* renamed from: c */
        private String f7867c;

        /* renamed from: d */
        private boolean f7868d;

        /* renamed from: e */
        private int f7869e;

        /* renamed from: f */
        private String f7870f;

        /* synthetic */ a(E e2) {
            this();
        }

        public a a(P p) {
            this.f7865a = p;
            return this;
        }

        private a() {
            this.f7869e = 0;
        }

        public F a() {
            F f2 = new F();
            f2.f7859a = this.f7865a;
            f2.f7860b = this.f7866b;
            f2.f7861c = this.f7867c;
            f2.f7862d = this.f7868d;
            f2.f7863e = this.f7869e;
            f2.f7864f = this.f7870f;
            return f2;
        }
    }

    public static a j() {
        return new a();
    }

    public int d() {
        return this.f7863e;
    }

    public String e() {
        P p = this.f7859a;
        if (p == null) {
            return null;
        }
        return p.k();
    }

    public P f() {
        return this.f7859a;
    }

    public String g() {
        P p = this.f7859a;
        if (p == null) {
            return null;
        }
        return p.o();
    }

    public boolean h() {
        return this.f7862d;
    }

    public boolean i() {
        return (!this.f7862d && this.f7861c == null && this.f7864f == null && this.f7863e == 0) ? false : true;
    }

    public String b() {
        return this.f7864f;
    }

    public String c() {
        return this.f7860b;
    }

    public String a() {
        return this.f7861c;
    }
}
