package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.net.C0324c;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class K implements ib {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f4191a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0225c f4192b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f4193c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ M f4194d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(M m, long j, C0225c c0225c, String str) {
        this.f4194d = m;
        this.f4191a = j;
        this.f4192b = c0225c;
        this.f4193c = str;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib
    public void a(C0225c c0225c, AdobeCSDKException adobeCSDKException) {
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobeDCXCompositeXfer", "session.uploadComponent completed inside pushComponentsInManifest");
        Integer num = 200;
        if (adobeCSDKException != null && adobeCSDKException.getData() != null && adobeCSDKException.getData().containsKey(AdobeEntitlementException.AdobeNetworkHTTPStatusKey)) {
            num = (Integer) adobeCSDKException.getData().get(AdobeEntitlementException.AdobeNetworkHTTPStatusKey);
        }
        if (num.intValue() != 404 && num.intValue() != 409 && num.intValue() != 412) {
            M m = this.f4194d;
            if (m.f4202d) {
                m.f4203e.a(c0225c, m.f4200b, m.i, this.f4193c, adobeCSDKException);
            }
            M m2 = this.f4194d;
            m2.f4204f.a(c0225c, this.f4193c, m2.f4200b, adobeCSDKException);
            return;
        }
        long j = this.f4191a + 10;
        if (this.f4194d.f4201c.g() < 0) {
            this.f4194d.f4201c.b(j);
            this.f4194d.f4201c.a(0L);
        } else {
            C0324c c0324c = this.f4194d.f4201c;
            c0324c.b(c0324c.g() + j);
        }
        M m3 = this.f4194d;
        com.adobe.creativesdk.foundation.internal.net.E a2 = m3.f4205g.a(this.f4192b, m3.f4200b, this.f4193c, !m3.f4206h, new I(this), (Handler) null);
        if (a2 != null) {
            a2.a(new J(this, a2, c0225c));
            this.f4194d.f4201c.a(a2, j);
        }
    }
}
