package com.adobe.creativesdk.foundation.internal.storage.a.b;

import android.os.Handler;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.e */
/* loaded from: classes.dex */
public class C0335e implements c.a.a.a.c<AdobeAuthException> {

    /* renamed from: a */
    final /* synthetic */ Handler f5392a;

    /* renamed from: b */
    final /* synthetic */ xa f5393b;

    /* renamed from: c */
    final /* synthetic */ ra f5394c;

    public C0335e(ra raVar, Handler handler, xa xaVar) {
        this.f5394c = raVar;
        this.f5392a = handler;
        this.f5393b = xaVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeAuthException adobeAuthException) {
        Handler handler = this.f5392a;
        if (handler != null) {
            handler.post(new RunnableC0334d(this, adobeAuthException));
            return;
        }
        xa xaVar = this.f5393b;
        if (xaVar != null) {
            xaVar.a(adobeAuthException);
        }
    }
}
