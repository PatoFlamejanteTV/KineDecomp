package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class D implements c.a.a.a.c<AdobeAuthException> {

    /* renamed from: a */
    final /* synthetic */ sd f6945a;

    /* renamed from: b */
    final /* synthetic */ Handler f6946b;

    /* renamed from: c */
    final /* synthetic */ AdobeAssetFile f6947c;

    public D(AdobeAssetFile adobeAssetFile, sd sdVar, Handler handler) {
        this.f6947c = adobeAssetFile;
        this.f6945a = sdVar;
        this.f6946b = handler;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAuthException adobeAuthException) {
        sd sdVar = this.f6945a;
        if (sdVar != null) {
            Handler handler = this.f6946b;
            if (handler != null) {
                handler.post(new C(this, adobeAuthException));
            } else {
                sdVar.a((sd) adobeAuthException);
            }
        }
    }
}
