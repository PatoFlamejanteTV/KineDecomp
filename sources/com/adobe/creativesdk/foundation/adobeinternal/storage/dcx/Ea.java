package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXLocalStorageDirectories.java */
/* loaded from: classes.dex */
public class Ea implements ob {
    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String a(C0225c c0225c, Fa fa, C0231f c0231f) throws AdobeDCXException {
        return a(c0225c, fa, c0231f, false);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public void a(Fa fa, List<Fa> list) {
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public void a(C0225c c0225c, Fa fa) {
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean a() {
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean a(C0225c c0225c, Fa fa, Fa fa2) {
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public long b(C0231f c0231f) {
        return -1L;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String c(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "current/manifest");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String d(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "push/manifest.base");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String e(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "clientdata");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String f(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "pull/manifest.base");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String g(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "pull/manifest");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String h(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "push/journal");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean i(C0231f c0231f) throws AdobeDCXException {
        return a(c0231f) && m(c0231f) && a("base", c0231f);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean j(C0231f c0231f) throws AdobeDCXException {
        try {
            org.apache.commons.io.b.b(new File(c0231f.z()));
            return true;
        } catch (Exception unused) {
            throw new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalStoragePath);
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String k(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "push/manifest");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String l(C0231f c0231f) {
        return org.apache.commons.io.c.a(c0231f.z(), "base/manifest");
    }

    public boolean m(C0231f c0231f) throws AdobeDCXException {
        return a("push", c0231f);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean a(Ka ka, Fa fa, C0231f c0231f, String str) throws AdobeDCXException {
        String a2 = org.apache.commons.io.c.a(c0231f.z(), "current");
        String j = org.apache.commons.io.c.j(str);
        if (j.startsWith(a2)) {
            String substring = j.substring(a2.length() + 1);
            if (!substring.equals(ka.k())) {
                ka.e(substring);
            }
            ka.a(new File(j).length());
            return true;
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalStoragePath, "Component path " + j + " reaches out of composite directory");
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public String a(C0225c c0225c, Fa fa, C0231f c0231f, boolean z) throws AdobeDCXException {
        String a2 = org.apache.commons.io.c.a(c0231f.z(), z ? "pull" : "current");
        String a3 = org.apache.commons.io.c.a(a2, c0225c.k());
        if (a3.startsWith(a2)) {
            return a3;
        }
        throw com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalStoragePath, "Component path " + c0225c.k() + " reaches out of composite directory");
    }

    private boolean a(String str, C0231f c0231f) throws AdobeDCXException {
        File file = new File(org.apache.commons.io.c.a(c0231f.z(), str));
        if (!file.exists()) {
            return true;
        }
        try {
            org.apache.commons.io.b.b(file);
            return true;
        } catch (Exception unused) {
            throw new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalStoragePath);
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    @SuppressLint({"Assert"})
    public boolean a(Fa fa, C0231f c0231f) throws AdobeDCXException {
        String a2 = org.apache.commons.io.c.a(c0231f.z(), "current");
        String a3 = org.apache.commons.io.c.a(c0231f.z(), "pull");
        if (fa != null) {
            fa.a(g(c0231f), true);
        }
        File file = new File(a2);
        File file2 = new File(a3);
        if (file.exists()) {
            try {
                org.apache.commons.io.b.b(file);
                org.apache.commons.io.b.c(file2, file);
            } catch (Exception unused) {
                throw new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalStoragePath);
            }
        } else {
            try {
                org.apache.commons.io.b.c(file2, file);
            } catch (Exception unused2) {
                throw new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorInvalidLocalStoragePath);
            }
        }
        boolean b2 = com.adobe.creativesdk.foundation.internal.storage.model.util.f.b(org.apache.commons.io.c.a(org.apache.commons.io.c.a(c0231f.z(), "current"), "manifest.base"), l(c0231f));
        c0231f.S();
        return b2;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ob
    public boolean a(C0231f c0231f) throws AdobeDCXException {
        return a("pull", c0231f);
    }
}
