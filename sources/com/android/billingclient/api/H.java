package com.android.billingclient.api;

/* compiled from: BillingResult.java */
/* loaded from: classes.dex */
public final class H {

    /* renamed from: a */
    private int f7871a;

    /* renamed from: b */
    private String f7872b;

    /* compiled from: BillingResult.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private int f7873a;

        /* renamed from: b */
        private String f7874b;

        /* synthetic */ a(G g2) {
            this();
        }

        public a a(int i) {
            this.f7873a = i;
            return this;
        }

        private a() {
        }

        public a a(String str) {
            this.f7874b = str;
            return this;
        }

        public H a() {
            H h2 = new H();
            h2.f7871a = this.f7873a;
            h2.f7872b = this.f7874b;
            return h2;
        }
    }

    public static a b() {
        return new a();
    }

    public int a() {
        return this.f7871a;
    }
}
