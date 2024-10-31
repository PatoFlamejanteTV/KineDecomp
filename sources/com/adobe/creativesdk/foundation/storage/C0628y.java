package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* compiled from: AdobeAssetFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.y */
/* loaded from: classes.dex */
public class C0628y implements c.a.a.a.c<AdobeAuthException> {

    /* renamed from: a */
    final /* synthetic */ sd f7470a;

    /* renamed from: b */
    final /* synthetic */ Handler f7471b;

    /* renamed from: c */
    final /* synthetic */ AdobeAssetFile f7472c;

    public C0628y(AdobeAssetFile adobeAssetFile, sd sdVar, Handler handler) {
        this.f7472c = adobeAssetFile;
        this.f7470a = sdVar;
        this.f7471b = handler;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAuthException adobeAuthException) {
        sd sdVar = this.f7470a;
        if (sdVar != null) {
            Handler handler = this.f7471b;
            if (handler != null) {
                handler.post(new RunnableC0565i(this, adobeAuthException));
            } else {
                sdVar.a((sd) adobeAuthException);
            }
        }
    }
}
