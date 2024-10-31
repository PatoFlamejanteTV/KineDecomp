package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.util.Log;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AdobeDCXCompositeBranch.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.g */
/* loaded from: classes.dex */
public class C0233g implements InterfaceC0223b {

    /* renamed from: a */
    private C0220a f4377a;

    /* renamed from: b */
    private HashSet<Object> f4378b = new HashSet<>();

    public C0233g(C0231f c0231f, Fa fa) {
        this.f4377a = new C0220a(c0231f, fa, null, this);
    }

    public void a(Fa fa) {
        synchronized (this) {
            this.f4377a.a(fa);
            this.f4377a.a((Ia) null);
        }
    }

    @Deprecated
    public List<C0225c> b(Ha ha) {
        return this.f4377a.b(ha);
    }

    public String c() {
        return this.f4377a.b();
    }

    public String d() {
        return this.f4377a.c();
    }

    public final JSONObject e() {
        return this.f4377a.d();
    }

    public Ia f() {
        return this.f4377a.f();
    }

    public Fa g() {
        return this.f4377a.e();
    }

    public Ia h() {
        C0225c a2;
        if (this.f4377a.f() == null && (a2 = Ia.a((InterfaceC0223b) this)) != null) {
            try {
                this.f4377a.a(new Ma(this, a2));
            } catch (Exception e2) {
                String a3 = a2.a();
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeBranch.getMetadata", "componentPath =" + a3);
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeDCXCompositeBranch.getMetadata", e2.getMessage(), e2);
                Za.a("csdk_android_dcx", "compositeBranch-getMetadata", "metadata object creation fail " + Log.getStackTraceString(e2), a3);
            }
        }
        return this.f4377a.f();
    }

    public C0235h i() {
        Fa fa;
        try {
            fa = new Fa(this.f4377a.e().n());
        } catch (AdobeDCXException e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0233g.class.getSimpleName(), null, e2);
            fa = null;
        }
        if (fa == null) {
            return null;
        }
        C0235h c0235h = new C0235h(l(), fa);
        if (this.f4377a.f() != null) {
            Ma c2 = this.f4377a.f().c();
            c2.a(fa);
            c0235h.a(c2);
        }
        return c0235h;
    }

    public String j() {
        return this.f4377a.g();
    }

    public Ha k() {
        return this.f4377a.h().c();
    }

    public C0231f l() {
        return this.f4377a.i();
    }

    public boolean m() {
        if (this.f4377a.f() == null || !this.f4377a.f().g()) {
            return Ia.a((InterfaceC0223b) this).m().equals("modified");
        }
        return true;
    }

    public List<C0225c> b(Na na) {
        return this.f4377a.b(na);
    }

    public Na c(String str) {
        return this.f4377a.e(str);
    }

    public C0225c b(String str) {
        return this.f4377a.d(str);
    }

    public String c(C0225c c0225c) throws AdobeDCXException {
        return this.f4377a.c(c0225c);
    }

    @Deprecated
    public Ha b(C0225c c0225c) {
        return this.f4377a.b(c0225c);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.InterfaceC0223b
    public C0220a a() {
        return this.f4377a;
    }

    public List<C0225c> b() {
        return this.f4377a.a();
    }

    public static C0233g a(C0231f c0231f, Fa fa) {
        return new C0233g(c0231f, fa);
    }

    public void a(Ia ia) {
        this.f4377a.a(ia);
        if (ia != null) {
            ia.i();
        }
    }

    public final Object a(String str) {
        return this.f4377a.a(str);
    }

    public Na a(C0225c c0225c) {
        return this.f4377a.a(c0225c);
    }

    @Deprecated
    public List<Ha> a(Ha ha) {
        return this.f4377a.a(ha);
    }

    public List<Na> a(Na na) {
        return this.f4377a.a(na);
    }

    public Na a(Na na, Ba ba) {
        return this.f4377a.a(na, ba);
    }
}
