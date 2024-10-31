package com.adobe.creativesdk.foundation.internal.storage.a.b;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkRequestPriority;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;

/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.u */
/* loaded from: classes.dex */
public class C0350u implements ra.a {

    /* renamed from: a */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.net.j f5476a;

    /* renamed from: b */
    final /* synthetic */ Handler f5477b;

    /* renamed from: c */
    final /* synthetic */ ra f5478c;

    /* renamed from: d */
    final /* synthetic */ ra f5479d;

    public C0350u(ra raVar, com.adobe.creativesdk.foundation.internal.net.j jVar, Handler handler, ra raVar2) {
        this.f5479d = raVar;
        this.f5476a = jVar;
        this.f5477b = handler;
        this.f5478c = raVar2;
    }

    public com.adobe.creativesdk.foundation.internal.net.E a(boolean z, com.adobe.creativesdk.foundation.internal.net.E e2, com.adobe.creativesdk.foundation.internal.net.F f2) {
        if (z) {
            this.f5476a.b("If-Match", "*");
        }
        C0347q c0347q = new C0347q(this, f2);
        com.adobe.creativesdk.foundation.internal.net.A c2 = this.f5479d.c("assets");
        if (c2 != null) {
            C0351v c0351v = new C0351v(this.f5479d);
            c0351v.f5480a = c2.a(this.f5476a, AdobeNetworkRequestPriority.NORMAL, new C0349t(this, c0347q), this.f5477b);
            return c0351v.f5480a;
        }
        if (f2 != null) {
            AdobeNetworkException adobeNetworkException = new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorNoCloudSpecified);
            Handler handler = this.f5477b;
            if (handler != null) {
                handler.post(new r(this, f2, adobeNetworkException));
                return null;
            }
            f2.a(adobeNetworkException);
            return null;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, ra.class.getSimpleName(), "Adobe cloud not specified.");
        return null;
    }
}
