package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFolder.java */
/* loaded from: classes.dex */
public class Y implements c.a.a.a.c<AdobeAuthException> {

    /* renamed from: a */
    final /* synthetic */ c.a.a.a.c f7176a;

    public Y(c.a.a.a.c cVar) {
        this.f7176a = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAuthException adobeAuthException) {
        c.a.a.a.c cVar = this.f7176a;
        if (cVar != null) {
            cVar.a(adobeAuthException);
        }
    }
}
