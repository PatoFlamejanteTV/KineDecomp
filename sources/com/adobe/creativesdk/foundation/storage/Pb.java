package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePSDCompositeXfer.java */
/* loaded from: classes.dex */
public class Pb implements com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.kb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.a.b.ra f7087a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f7088b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.adobeinternal.imageservice.t f7089c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Lb f7090d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pb(com.adobe.creativesdk.foundation.internal.storage.a.b.ra raVar, C0231f c0231f, com.adobe.creativesdk.foundation.adobeinternal.imageservice.t tVar, Lb lb) {
        this.f7087a = raVar;
        this.f7088b = c0231f;
        this.f7089c = tVar;
        this.f7090d = lb;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.kb
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa) throws AdobeCSDKException {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f b2 = this.f7087a.b(fa, this.f7088b);
        String str = new String("/assets/psd");
        com.adobe.creativesdk.foundation.internal.storage.model.resources.f a2 = this.f7089c.a(b2, this.f7090d.d(), str);
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa fa2 = null;
        if (a2 != null) {
            try {
                fa2 = new com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa(new String(a2.d(), "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
            if (fa2 != null && (this.f7088b.n() == null || this.f7088b.r() == null)) {
                String h2 = fa2.h();
                this.f7088b.d(h2);
                try {
                    this.f7088b.a(new URI(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.c(str, h2)));
                } catch (URISyntaxException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePSDCompositeXfer.internalPullMinimalPSDComposite", e2.getMessage());
                }
            }
            fa2.g(a2.f6613e);
            fa2.a(this.f7090d.c().r());
        }
        return fa2;
    }
}
