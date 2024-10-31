package com.adobe.creativesdk.foundation.auth;

/* compiled from: AdobeUXAuthManager.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    private static k f4726a;

    /* renamed from: b */
    private c.a.a.a.a.a.a f4727b;

    private k() {
        this.f4727b = null;
        this.f4727b = c.a.a.a.a.a.a.b();
    }

    public static k a() {
        if (f4726a == null) {
            f4726a = new k();
        }
        return f4726a;
    }

    public AdobeAuthUserProfile b() {
        return this.f4727b.c();
    }

    public boolean c() {
        return this.f4727b.f();
    }

    public void b(j jVar) {
        this.f4727b.b(jVar);
    }

    public void a(j jVar) {
        this.f4727b.a(jVar);
    }
}
