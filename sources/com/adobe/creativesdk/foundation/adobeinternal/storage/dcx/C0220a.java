package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AdobeDCXBranchCore.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0220a {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<C0231f> f4302a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<InterfaceC0223b> f4303b;

    /* renamed from: c, reason: collision with root package name */
    private Fa f4304c;

    /* renamed from: d, reason: collision with root package name */
    private Ia f4305d;

    public C0220a(C0231f c0231f, Fa fa, Ia ia, InterfaceC0223b interfaceC0223b) {
        this.f4302a = new WeakReference<>(c0231f);
        this.f4304c = fa;
        this.f4305d = ia;
        this.f4303b = new WeakReference<>(interfaceC0223b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Ia ia) {
        this.f4305d = ia;
    }

    public String b() {
        return this.f4304c.i();
    }

    public String c() {
        return this.f4304c.l();
    }

    public JSONObject d() {
        return this.f4304c.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fa e() {
        return this.f4304c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia f() {
        return this.f4305d;
    }

    public void g(String str) {
        this.f4304c.h(str);
    }

    public Na h() {
        Na d2 = this.f4304c.d(this.f4304c.t().g());
        d2.a(this.f4303b.get());
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0231f i() {
        return this.f4302a.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fa fa) {
        this.f4304c = fa;
    }

    @Deprecated
    public List<C0225c> b(Ha ha) {
        if (ha == null) {
            return this.f4304c.f();
        }
        return this.f4304c.d(ha);
    }

    public C0225c c(String str) {
        return this.f4304c.c(str);
    }

    public C0225c d(String str) {
        return this.f4304c.b().get(str);
    }

    public Na e(String str) {
        Na d2 = this.f4304c.d(str);
        if (d2 != null) {
            d2.a(this.f4303b.get());
        }
        return d2;
    }

    public void f(String str) {
        this.f4304c.f(str);
    }

    public String g() {
        return this.f4304c.p();
    }

    public void a(Object obj, String str) {
        this.f4304c.a(obj, str);
    }

    public String c(C0225c c0225c) throws AdobeDCXException {
        C0231f c0231f = this.f4302a.get();
        boolean equals = this.f4303b.get().equals(c0231f.A());
        String a2 = c0231f.u().a(c0225c, this.f4304c, c0231f, equals);
        if (equals) {
            return a2;
        }
        if (a2 == null || !new File(a2).exists()) {
            return null;
        }
        return a2;
    }

    public C0225c d(C0225c c0225c) {
        return this.f4302a.get().a(c0225c, this.f4304c);
    }

    public Object a(String str) {
        return this.f4304c.b(str);
    }

    public List<C0225c> b(Na na) {
        return b(na != null ? na.c() : null);
    }

    public Na a(C0225c c0225c) {
        Ha b2 = b(c0225c);
        if (b2 == null) {
            return null;
        }
        Na d2 = this.f4304c.d(b2.g());
        d2.a(this.f4303b.get());
        return d2;
    }

    @Deprecated
    public Ha b(C0225c c0225c) {
        return this.f4304c.b(c0225c);
    }

    @Deprecated
    public La d(Ha ha) throws AdobeDCXException {
        return this.f4304c.e(ha);
    }

    @Deprecated
    public Ha b(String str) {
        return this.f4304c.a().get(str);
    }

    public Na b(Na na, Na na2, long j) throws AdobeDCXException {
        La la;
        if (na2 == null) {
            la = (La) this.f4304c.b(na.c(), j);
        } else {
            la = (La) this.f4304c.b(na.c(), na2.c(), j);
        }
        if (la == null) {
            return null;
        }
        na.a(la);
        na.a(this.f4303b.get());
        la.a(na);
        return na;
    }

    private Na c(Na na, Na na2, long j) throws AdobeDCXException {
        La la;
        if (na2 == null) {
            la = (La) this.f4304c.a(na.c(), j);
        } else {
            la = (La) this.f4304c.a(na.c(), na2.c(), j);
        }
        if (la == null) {
            return null;
        }
        na.a(la);
        na.a(this.f4303b.get());
        la.a(na);
        return na;
    }

    public List<C0225c> a() {
        return new ArrayList(this.f4304c.b().values());
    }

    @Deprecated
    public List<Ha> a(Ha ha) {
        if (ha == null) {
            return this.f4304c.c();
        }
        return this.f4304c.c(ha);
    }

    public List<Na> a(Na na) {
        List<Ha> a2 = a(na == null ? null : na.c());
        ArrayList arrayList = new ArrayList(a2.size());
        Iterator<Ha> it = a2.iterator();
        while (it.hasNext()) {
            Na d2 = this.f4304c.d(it.next().g());
            d2.a(this.f4303b.get());
            arrayList.add(d2);
        }
        return arrayList;
    }

    @Deprecated
    public Ha c(Ha ha) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(ha != null, "Parameter node shouldn't be null.");
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(ha.g() != null, "NodeId must not be null");
        C0231f c0231f = this.f4302a.get();
        ArrayList<C0225c> arrayList = new ArrayList<>();
        Ha a2 = this.f4304c.a(ha, arrayList);
        Iterator<C0225c> it = arrayList.iterator();
        while (it.hasNext()) {
            C0225c next = it.next();
            if (c0231f != null && c0231f.u() != null) {
                c0231f.u().a(next, this.f4304c);
            }
            this.f4304c.a((String) null, next);
            this.f4304c.b((String) null, next);
        }
        return a2;
    }

    @Deprecated
    public Ha a(Ha ha, Ba ba) {
        return this.f4304c.a(ha, ba);
    }

    public Na a(Na na, Ba ba) {
        Na d2 = this.f4304c.d(a(na.c(), ba).g());
        d2.a(this.f4303b.get());
        return d2;
    }

    @Deprecated
    public C0225c a(String str, String str2, String str3, String str4, String str5, Ha ha, String str6, boolean z, String str7) throws AdobeDCXException {
        Ka ka = new Ka(str2 == null ? com.adobe.creativesdk.foundation.internal.storage.model.util.i.a() : str2, str5, str, str3, null, "modified");
        ka.f(str4);
        return a(ka, ha, str6, z, str7);
    }

    public Na c(Na na) {
        c(na.c());
        na.g();
        return na;
    }

    public C0225c a(String str, String str2, String str3, String str4, String str5, Na na, String str6, boolean z, String str7) throws AdobeDCXException {
        return a(str, str2, str3, str4, str5, na == null ? null : na.c(), str6, z, str7);
    }

    @Deprecated
    public C0225c a(C0225c c0225c, Ha ha, String str, boolean z, String str2) throws AdobeDCXException {
        Ka i = c0225c.i();
        i.g("modified");
        if (i.b() == null) {
            i.b(com.adobe.creativesdk.foundation.internal.storage.model.util.i.a());
        }
        return a(i, ha, str, z, str2, (String) null);
    }

    public C0225c a(C0225c c0225c, Na na, String str, boolean z, String str2) throws AdobeDCXException {
        return a(c0225c, na.c(), str, z, str2);
    }

    private C0225c a(Ka ka, Ha ha, String str, boolean z, String str2, String str3) throws AdobeDCXException {
        String str4;
        AdobeDCXException adobeDCXException;
        C0225c c0225c;
        String str5;
        C0231f c0231f = this.f4302a.get();
        if (str != null) {
            str4 = c0231f.u().a(ka, this.f4304c, c0231f);
            if (str4 == null) {
                return null;
            }
            File file = new File(new File(str4).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
            String k = org.apache.commons.io.c.k(str);
            String k2 = org.apache.commons.io.c.k(str4);
            File file2 = new File(k);
            File file3 = new File(k2);
            if (!k.equals(k2)) {
                c0231f.a(k2);
                try {
                    if (z) {
                        org.apache.commons.io.b.b(file2, file3);
                    } else {
                        org.apache.commons.io.b.d(file2, file3);
                    }
                } catch (IOException e2) {
                    Za.a("csdk_android_dcx", "internalAddComponent", "copy/move failed-reason:" + e2.getMessage(), "srcFile:" + k + "destFile" + k2);
                    c0231f.b(k2);
                    throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorFileIO, "Copy/Move failed: internalAddComponent", e2);
                }
            }
            if (!c0231f.u().a(ka, this.f4304c, c0231f, str4)) {
                c0231f.b(k2);
                return null;
            }
            c0231f.b(k2);
        } else {
            str4 = null;
        }
        try {
            if (ha == null) {
                c0225c = this.f4304c.a(ka, (Fa) null, (String) null);
            } else {
                c0225c = this.f4304c.a(ka, (Fa) null, ha, (String) null);
            }
            adobeDCXException = null;
        } catch (AdobeDCXException e3) {
            adobeDCXException = e3;
            c0225c = null;
        }
        if (c0225c != null) {
            this.f4304c.a(str2, ka);
            this.f4304c.b(str3, ka);
            return c0225c;
        }
        if (str4 != null) {
            if (c0231f.L()) {
                if (z) {
                    new File(str4).delete();
                } else {
                    try {
                        org.apache.commons.io.b.d(new File(str4), new File(str));
                    } catch (IOException e4) {
                        if (str == null || str4 == null) {
                            str5 = "";
                        } else {
                            str5 = "srcFile:" + str + "destFile:" + str4;
                        }
                        Za.a("csdk_android_dcx", "internalAddComponent", "moveFile failed-reason:" + e4.getMessage(), str5);
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0220a.class.getSimpleName(), null, e4);
                    }
                }
                c0231f.u().a(ka, this.f4304c);
                throw adobeDCXException;
            }
            throw adobeDCXException;
        }
        throw adobeDCXException;
    }

    public C0225c a(C0225c c0225c, String str, boolean z) throws AdobeDCXException {
        return a(c0225c, str, z, (String) null);
    }

    public C0225c a(C0225c c0225c, InterfaceC0223b interfaceC0223b) throws AdobeDCXException {
        return this.f4302a.get().a(c0225c, interfaceC0223b.a().f4304c, interfaceC0223b.a().f4302a.get(), null, this.f4304c, true, null);
    }

    private C0225c a(C0225c c0225c, String str, boolean z, String str2) throws AdobeDCXException {
        String str3;
        String str4;
        boolean z2;
        String str5;
        String str6;
        C0231f c0231f = this.f4302a.get();
        boolean z3 = false;
        boolean z4 = this.f4304c.d(c0225c) == null;
        Ka i = c0225c.getClass().equals(Ka.class) ? (Ka) c0225c : c0225c.i();
        String str7 = null;
        String a2 = (c0231f.L() && z4) ? c0231f.u().a(c0225c, this.f4304c, c0231f, false) : null;
        String c2 = this.f4304c.c(c0225c);
        if (str == null && str2 == null) {
            str3 = "";
        } else {
            if (str != null) {
                String a3 = c0231f.u().a(c0225c, this.f4304c, c0231f);
                if (a3 == null) {
                    return null;
                }
                File file = new File(Za.e(a3));
                if (!file.exists()) {
                    file.mkdirs();
                }
                String k = org.apache.commons.io.c.k(str);
                String k2 = org.apache.commons.io.c.k(a3);
                str3 = "";
                File file2 = new File(k);
                File file3 = new File(k2);
                if (k.equals(k2)) {
                    z2 = false;
                } else {
                    c0231f.a(k2);
                    try {
                        if (z) {
                            org.apache.commons.io.b.b(file2, file3);
                        } else {
                            org.apache.commons.io.b.c(file3);
                            org.apache.commons.io.b.d(file2, file3);
                        }
                        if (i.m() != null && i.m().equals("unmodified")) {
                            i.g("modified");
                        }
                        z2 = true;
                    } catch (IOException e2) {
                        if (str == null || a3 == null) {
                            str5 = str3;
                        } else {
                            str5 = "srcFile:" + k + "destFile:" + k2;
                        }
                        Za.a("csdk_android_dcx", "updateComponent", "copy/move/delete failed-reason:" + e2.getMessage(), str5);
                        c0231f.b(k2);
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeMutaleBranch.updateComponentInBranchOrElement", e2.getMessage(), e2);
                        return null;
                    }
                }
                str4 = k2;
                z3 = z2;
                str7 = a3;
            } else {
                str3 = "";
                i.a(0L);
                if (i.m() != null && i.m().equals("unmodified")) {
                    i.g("modified");
                }
                str4 = null;
                z3 = true;
                str7 = null;
            }
            if (!c0231f.u().a(i, this.f4304c, c0231f, str7)) {
                if (str4 == null) {
                    return null;
                }
                c0231f.b(str4);
                return null;
            }
            if (str4 != null) {
                c0231f.b(str4);
            }
            this.f4304c.b(str2, i);
            this.f4304c.a((String) null, i);
        }
        try {
            return this.f4304c.f(i);
        } catch (AdobeDCXException e3) {
            if (str7 != null) {
                if (c0231f.L()) {
                    if (a2 != null) {
                        c0231f.u().a(c0225c.i(), this.f4304c, c0231f, a2);
                    }
                    if (z3) {
                        if (z) {
                            new File(str7).delete();
                        } else {
                            try {
                                org.apache.commons.io.b.d(new File(str7), new File(str));
                            } catch (IOException e4) {
                                if (str == null || str7 == null) {
                                    str6 = str3;
                                } else {
                                    str6 = "srcFile" + str + "destFile" + str7;
                                }
                                Za.a("csdk_android_dcx", "updateComponent", "moveFile failed:" + e3.getMessage(), str6);
                                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0220a.class.getSimpleName(), null, e4);
                            }
                        }
                    }
                }
                if (c2 != null) {
                    this.f4304c.a(c2, c0225c);
                    throw e3;
                }
                throw e3;
            }
            throw e3;
        }
    }

    @Deprecated
    public C0225c a(C0225c c0225c, InterfaceC0223b interfaceC0223b, Ha ha) throws AdobeDCXException {
        return a(c0225c, interfaceC0223b, ha, (String) null);
    }

    @Deprecated
    public C0225c a(C0225c c0225c, InterfaceC0223b interfaceC0223b, Ha ha, String str) throws AdobeDCXException {
        return this.f4302a.get().a(c0225c, interfaceC0223b.a().f4304c, interfaceC0223b.a().f4302a.get(), ha, this.f4304c, false, str);
    }

    public Na a(String str, String str2, String str3, String str4, Na na) throws AdobeDCXException {
        return a(new Na(str3, str4, str, str2), na);
    }

    private Na a(Na na, Na na2) throws AdobeDCXException {
        La la;
        if (na2 == null) {
            la = (La) this.f4304c.a(na.c());
        } else {
            la = (La) this.f4304c.a(na.c(), na2.c());
        }
        if (la == null) {
            return null;
        }
        na.a(la);
        na.a(this.f4303b.get());
        la.a(na);
        return na;
    }

    public Na a(String str, String str2, String str3, String str4, Na na, long j) throws AdobeDCXException {
        return c(new Na(str3, str4, str, str2), na, j);
    }

    public Na a(Na na, Na na2, long j) throws AdobeDCXException {
        return a(na, na2, j, (String) null, (String) null);
    }

    public Na a(Na na, Na na2, long j, String str, String str2) throws AdobeDCXException {
        InterfaceC0223b b2 = na.b();
        C0231f c0231f = this.f4302a.get();
        C0231f c0231f2 = b2.a().f4302a.get();
        La la = (La) c0231f.a(na.c(), b2.a().f4304c, c0231f2, na2 == null ? null : na2.c(), j, this.f4304c, false, str, str2);
        if (la == null) {
            return null;
        }
        Na d2 = this.f4304c.d(la.g());
        d2.a(this.f4303b.get());
        return d2;
    }

    public Na a(Na na, String str, String str2) throws AdobeDCXException {
        InterfaceC0223b b2 = na.b();
        C0231f c0231f = this.f4302a.get();
        C0231f c0231f2 = b2.a().f4302a.get();
        Fa fa = b2.a().f4304c;
        b(na.e());
        La la = (La) c0231f.a(na.c(), fa, c0231f2, null, 0L, this.f4304c, true, str, str2);
        if (la == null) {
            return null;
        }
        Na d2 = this.f4304c.d(la.g());
        d2.a(this.f4303b.get());
        return d2;
    }
}
