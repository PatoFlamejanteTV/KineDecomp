package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

/* compiled from: SkuDetailsParams.java */
/* loaded from: classes.dex */
public class S {

    /* renamed from: a */
    private String f7898a;

    /* renamed from: b */
    private List<String> f7899b;

    /* compiled from: SkuDetailsParams.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private String f7900a;

        /* renamed from: b */
        private List<String> f7901b;

        /* synthetic */ a(Q q) {
            this();
        }

        public a a(List<String> list) {
            this.f7901b = new ArrayList(list);
            return this;
        }

        private a() {
        }

        public a a(String str) {
            this.f7900a = str;
            return this;
        }

        public S a() {
            S s = new S();
            s.f7898a = this.f7900a;
            s.f7899b = this.f7901b;
            return s;
        }
    }

    public static a c() {
        return new a();
    }

    public List<String> b() {
        return this.f7899b;
    }

    public String a() {
        return this.f7898a;
    }
}
