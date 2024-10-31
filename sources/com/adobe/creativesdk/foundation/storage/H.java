package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class H implements c.a.a.a.c<AdobeAuthException> {

    /* renamed from: a */
    final /* synthetic */ sd f6997a;

    /* renamed from: b */
    final /* synthetic */ Handler f6998b;

    /* renamed from: c */
    final /* synthetic */ AdobeAssetFile f6999c;

    public H(AdobeAssetFile adobeAssetFile, sd sdVar, Handler handler) {
        this.f6999c = adobeAssetFile;
        this.f6997a = sdVar;
        this.f6998b = handler;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAuthException adobeAuthException) {
        sd sdVar = this.f6997a;
        if (sdVar != null) {
            Handler handler = this.f6998b;
            if (handler != null) {
                handler.post(new G(this, adobeAuthException));
            } else {
                sdVar.a((sd) adobeAuthException);
            }
        }
    }
}
