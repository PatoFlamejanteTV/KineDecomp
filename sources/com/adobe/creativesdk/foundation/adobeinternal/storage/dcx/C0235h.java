package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.File;
import java.util.Arrays;

/* compiled from: AdobeDCXCompositeMutableBranch.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0235h extends C0233g {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public C0235h(C0231f c0231f, Fa fa) {
        super(c0231f, fa);
    }

    public void a(Object obj, String str) {
        a().a(obj, str);
    }

    public Na b(Na na, Na na2, long j) throws AdobeDCXException {
        return a().b(na, na2, j);
    }

    @Deprecated
    public Ha c(Ha ha) {
        return a().c(ha);
    }

    public void d(String str) {
        if (Za.a(str, "pendingDelete")) {
            Za.a("csdk_android_dcx", "AdobeDCXCompositeMutableBranch.setCompositeState", "Marking composite for deletion " + Arrays.toString(Thread.currentThread().getStackTrace()), g() != null ? g().h() : null);
        }
        a().f(str);
    }

    public void e(String str) {
        a().g(str);
    }

    public boolean f(String str) throws AdobeDCXException {
        File file = new File(new File(str).getParent());
        boolean mkdirs = !file.exists() ? file.mkdirs() : true;
        g().a(str, true);
        if (mkdirs) {
            l().O();
        }
        return mkdirs;
    }

    public Ma n() {
        if (h() == null) {
            return null;
        }
        if (!(h() instanceof Ma)) {
            a(h().c());
        }
        return (Ma) h();
    }

    public boolean o() {
        return g() != null && g().m;
    }

    public void p() {
        d("pendingDelete");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static C0235h b(C0231f c0231f, Fa fa) {
        return new C0235h(c0231f, fa);
    }

    public C0225c a(C0225c c0225c, Na na, String str, boolean z, String str2) throws AdobeDCXException {
        return a().a(c0225c, na, str, z, str2);
    }

    public Na c(Na na) {
        a().c(na);
        return na;
    }

    public C0225c a(C0225c c0225c, String str, boolean z) throws AdobeDCXException {
        return a().a(c0225c, str, z);
    }

    @Deprecated
    public C0225c a(C0225c c0225c, C0233g c0233g, Ha ha) throws AdobeDCXException {
        return a().a(c0225c, c0233g, ha);
    }

    @Deprecated
    public C0225c a(C0225c c0225c, C0233g c0233g) throws AdobeDCXException {
        return a().a(c0225c, c0233g);
    }

    public C0225c a(C0225c c0225c, InterfaceC0223b interfaceC0223b) throws AdobeDCXException {
        return a().a(c0225c, interfaceC0223b);
    }

    public C0225c d(C0225c c0225c) {
        return a().d(c0225c);
    }

    public Na a(String str, String str2, String str3, String str4, Na na) throws AdobeDCXException {
        return a().a(str, str2, str3, str4, na);
    }

    public Na d(Na na) throws AdobeDCXException {
        return a().a(na, (String) null, (String) null);
    }

    public Na a(String str, String str2, String str3, String str4, Na na, long j) throws AdobeDCXException {
        return a().a(str, str2, str3, str4, na, j);
    }

    public Na a(Na na, Na na2, long j) throws AdobeDCXException {
        return a().a(na, na2, j);
    }

    public Na a(Na na, Na na2, long j, String str, String str2) throws AdobeDCXException {
        return a().a(na, na2, j, str, str2);
    }

    public boolean a(C0233g c0233g, C0233g c0233g2) throws AdobeDCXException {
        C0225c a2;
        String str;
        C0231f l = l();
        if (l == null || Ia.a(c0233g2) == null || (a2 = Ia.a(l.A())) == null) {
            return false;
        }
        C0225c a3 = Ia.a(c0233g);
        C0225c i = Ia.a((C0233g) this).i();
        Ia f2 = c0233g.f();
        if (f2 != null) {
            if (f2.a(this) == null) {
                return false;
            }
            Ka i2 = Ia.a((InterfaceC0223b) this).i();
            if (i2.b().equals(a2.b())) {
                i2.c(a2.d());
            }
            if (a((C0225c) i2, (String) null, false) == null) {
                return false;
            }
        } else {
            if (i != null && a3 != null && !i.b().equals(a3.b()) && !i.b().equals(a2.b())) {
                d(i);
                i = null;
            }
            if (i != null && !c0233g.d().equals(c0233g2.d())) {
                try {
                    str = c0233g.c(a3);
                } catch (AdobeDCXException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0235h.class.getSimpleName(), null, e2);
                    str = null;
                }
                if (str == null || a(i, str, true) == null) {
                    return false;
                }
            } else if (i != null) {
                if (a(a3, (InterfaceC0223b) c0233g) == null) {
                    return false;
                }
            } else if (a(a3, c0233g, (Ha) null) == null) {
                return false;
            }
        }
        a((Ia) null);
        return true;
    }
}
