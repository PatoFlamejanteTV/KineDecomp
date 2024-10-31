package com.android.billingclient.api;

/* compiled from: ConsumeParams.java */
/* loaded from: classes.dex */
public final class K {

    /* renamed from: a */
    private String f7883a;

    /* renamed from: b */
    private String f7884b;

    /* compiled from: ConsumeParams.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        private String f7885a;

        /* renamed from: b */
        private String f7886b;

        /* synthetic */ a(J j) {
            this();
        }

        public a a(String str) {
            this.f7885a = str;
            return this;
        }

        public a b(String str) {
            this.f7886b = str;
            return this;
        }

        private a() {
        }

        public K a() {
            K k = new K();
            k.f7883a = this.f7886b;
            k.f7884b = this.f7885a;
            return k;
        }
    }

    /* synthetic */ K(J j) {
        this();
    }

    public static a c() {
        return new a();
    }

    private K() {
    }

    public String a() {
        return this.f7884b;
    }

    public String b() {
        return this.f7883a;
    }
}
