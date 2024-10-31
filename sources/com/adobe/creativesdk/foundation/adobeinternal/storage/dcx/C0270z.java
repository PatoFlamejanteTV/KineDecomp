package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Y;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import java.io.File;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0270z implements Y.b {

    /* renamed from: a, reason: collision with root package name */
    private String f4490a;

    /* renamed from: b, reason: collision with root package name */
    private String f4491b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0264w f4492c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4493d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f4494e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0270z(A a2, C0264w c0264w, String str) {
        this.f4494e = a2;
        this.f4492c = c0264w;
        this.f4493d = str;
    }

    String b() {
        return this.f4491b;
    }

    void a(String str) {
        Object obj;
        Integer num;
        Integer num2;
        this.f4490a = str;
        obj = Y.f4278c;
        synchronized (obj) {
            StringBuilder sb = new StringBuilder();
            sb.append(org.apache.commons.io.b.a());
            sb.append("/");
            sb.append(new Date().getTime());
            num = Y.f4277b;
            num2 = Y.f4277b;
            Integer unused = Y.f4277b = Integer.valueOf(num2.intValue() + 1);
            sb.append(Integer.toString(num.intValue()));
            this.f4491b = sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() throws Exception {
        org.apache.commons.io.b.d(new File(this.f4491b), new File(this.f4490a));
    }

    public void a(C0225c c0225c, String str) {
        com.adobe.creativesdk.foundation.internal.net.E a2;
        a(str);
        if (this.f4494e.j.c()) {
            AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorCancelled);
            this.f4492c.a(null);
            this.f4494e.f4104e.a(adobeNetworkException);
            return;
        }
        long f2 = this.f4493d == null ? 10 + c0225c.f() : 10L;
        if (f2 > 0) {
            if (this.f4494e.j.g() < 0) {
                this.f4494e.j.b(f2);
                this.f4494e.j.a(0L);
            } else {
                C0324c c0324c = this.f4494e.j;
                c0324c.b(c0324c.g() + f2);
            }
        }
        String str2 = this.f4493d;
        if (str2 == null) {
            A a3 = this.f4494e;
            a2 = a3.k.a(c0225c, a3.f4105f, b(), new C0266x(this, str), null);
        } else {
            A a4 = this.f4494e;
            a2 = a4.k.a(str2, c0225c, a4.f4105f, b(), new C0268y(this, str), null);
        }
        if (f2 <= 0 || a2 == null) {
            return;
        }
        this.f4494e.j.a(a2, f2);
    }
}
