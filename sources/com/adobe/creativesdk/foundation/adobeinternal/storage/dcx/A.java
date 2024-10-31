package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class A implements Y.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ReentrantLock f4100a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fa f4101b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ db f4102c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0225c f4103d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C f4104e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ C0231f f4105f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f4106g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f4107h;
    final /* synthetic */ Fa i;
    final /* synthetic */ C0324c j;
    final /* synthetic */ zb k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(ReentrantLock reentrantLock, Fa fa, db dbVar, C0225c c0225c, C c2, C0231f c0231f, boolean z, String str, Fa fa2, C0324c c0324c, zb zbVar) {
        this.f4100a = reentrantLock;
        this.f4101b = fa;
        this.f4102c = dbVar;
        this.f4103d = c0225c;
        this.f4104e = c2;
        this.f4105f = c0231f;
        this.f4106g = z;
        this.f4107h = str;
        this.i = fa2;
        this.j = c0324c;
        this.k = zbVar;
    }

    public void a(String str, C0225c c0225c, String str2) {
        String str3;
        String str4;
        String str5;
        C0225c c0225c2;
        this.f4100a.lock();
        try {
            boolean z = this.f4101b.d(c0225c) != null;
            if (z && this.f4102c == null) {
                this.f4104e.a(new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXInvalidComponentManager, "No component manager found for unmanaged component : " + this.f4103d.b() + " with UCID : " + this.f4101b.d(this.f4103d)));
            } else {
                C0264w c0264w = new C0264w(this, z, str2);
                if (!z) {
                    try {
                        str = this.f4105f.u().a(this.f4103d, this.f4101b, this.f4105f, true);
                    } catch (AdobeDCXException e2) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "CoordinatedDownload:getPathOfComponent", "Error fetching local path of component: " + this.f4103d.b() + " ERROR:" + e2.getMessage(), e2);
                    }
                    if (str == null) {
                        this.f4104e.a(new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorInvalidRemoteManifest));
                    } else if (this.f4105f.L() && new File(str).exists()) {
                        this.f4104e.a(null);
                    }
                }
                String m = c0225c.m();
                if (this.f4105f.L()) {
                    if (m != null && (m.equals("committedDelete") || m.equals("pendingDelete"))) {
                        c0264w.a(null);
                        this.f4104e.a(null);
                        this.f4105f.a(c0225c, this.f4101b);
                    }
                } else if (m != null && m.equals("committedDelete")) {
                    c0264w.a(null);
                    this.f4104e.a(null);
                }
                String c2 = this.f4103d.d() == null ? this.f4101b.c(this.f4103d) : null;
                if ((m == null || !m.equals("unmodified")) && c2 == null) {
                    if (m != null && !this.f4106g) {
                        c0264w.a(null);
                        this.f4104e.a(null);
                    } else {
                        Ka i = c0225c.i();
                        i.g("unmodified");
                        try {
                            c0225c = this.f4101b.f(i);
                        } catch (AdobeDCXException e3) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeDCXCompositeXfer.internalDownloadComponents:updateComponentInBranchOrElement", "IGNORING:" + e3.getMessage(), e3);
                        }
                        if (this.f4106g) {
                            try {
                                this.f4101b.a(this.f4107h, false);
                            } catch (AdobeDCXException e4) {
                                c0264w.a(e4);
                                this.f4104e.a(e4);
                            }
                        }
                    }
                }
                C0225c c0225c3 = c0225c;
                File file = new File(org.apache.commons.io.c.d(str));
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (this.i == null || (c0225c2 = this.i.b().get(c0225c3.b())) == null) {
                    str3 = null;
                    str4 = null;
                    str5 = null;
                } else {
                    try {
                        str4 = this.f4105f.u().a(c0225c2, this.i, this.f4105f, false);
                    } catch (AdobeDCXException e5) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeDCXCompositeXfer.internalDownloadComponents:getPathOfComponent", e5.getMessage(), e5);
                        str4 = null;
                    }
                    if (str4 == null) {
                        str4 = "";
                    }
                    if (new File(str4).exists()) {
                        str5 = c0225c2.d();
                        str3 = c0225c2.m();
                    } else {
                        str3 = null;
                        str5 = null;
                    }
                }
                File file2 = new File(str);
                if (c2 == null && c0225c3.d().equals(str5) && (str3 == null || (!str3.equals("modified") && !str3.equals("pendingDelete")))) {
                    if (file2.exists() && !file2.delete()) {
                        this.f4104e.a(null);
                    } else {
                        try {
                            org.apache.commons.io.b.b(new File(str4), file2);
                            this.f4104e.a(null);
                        } catch (IOException e6) {
                            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeDCXCompositeXfer.internalDownloadComponents", "Error copying file for component : " + this.f4103d.b() + "of composite :" + this.f4105f.n() + " ERROR:" + e6.getMessage(), e6);
                            this.f4104e.a(com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(AdobeDCXErrorCode.AdobeDCXErrorComponentCopyFailure, null, null, str4));
                        }
                    }
                }
                if (file2.exists() && file2.length() == c0225c3.f()) {
                    String h2 = c0225c3.h();
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer", "AdobeStorageUtils.MD5HashOfFile-1 inside internalDownloadComponents");
                    com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(str, false, (com.adobe.creativesdk.foundation.internal.storage.model.util.j) new C0262v(this, h2, c0264w, c2, c0225c3, str));
                } else {
                    new C0270z(this, c0264w, c2).a(c0225c3, str);
                }
            }
        } finally {
            this.f4100a.unlock();
        }
    }
}
