package io.fabric.sdk.android.services.common;

/* compiled from: Crash.java */
/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a */
    private final String f26896a;

    /* renamed from: b */
    private final String f26897b;

    /* compiled from: Crash.java */
    /* loaded from: classes3.dex */
    public static class a extends l {
        public a(String str, String str2) {
            super(str, str2);
        }
    }

    /* compiled from: Crash.java */
    /* loaded from: classes3.dex */
    public static class b extends l {
        public b(String str, String str2) {
            super(str, str2);
        }
    }

    public l(String str, String str2) {
        this.f26896a = str;
        this.f26897b = str2;
    }

    public String a() {
        return this.f26897b;
    }

    public String b() {
        return this.f26896a;
    }
}
