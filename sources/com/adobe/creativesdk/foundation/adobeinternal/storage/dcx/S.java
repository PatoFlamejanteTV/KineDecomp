package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* loaded from: classes.dex */
public class S implements rb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ rb f4231a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0231f f4232b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4233c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(rb rbVar, C0231f c0231f, Aa aa) {
        this.f4231a = rbVar;
        this.f4232b = c0231f;
        this.f4233c = aa;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.rb
    public void a(AdobeCSDKException adobeCSDKException) {
        rb rbVar = this.f4231a;
        if (rbVar != null) {
            rbVar.a(adobeCSDKException);
        }
        Level level = Level.DEBUG;
        StringBuilder sb = new StringBuilder();
        sb.append("Inside pushComposite failed for compositeId = ");
        C0231f c0231f = this.f4232b;
        sb.append(c0231f != null ? c0231f.n() : null);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, "CSDK::Release::DCX", sb.toString());
        this.f4233c.c(this.f4232b, adobeCSDKException);
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.rb
    public void onSuccess() {
        rb rbVar = this.f4231a;
        if (rbVar != null) {
            rbVar.onSuccess();
        }
        Level level = Level.DEBUG;
        StringBuilder sb = new StringBuilder();
        sb.append("Inside pushComposite succeeded for compositeId = ");
        C0231f c0231f = this.f4232b;
        sb.append(c0231f != null ? c0231f.n() : null);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, "CSDK::Release::DCX", sb.toString());
        this.f4233c.c(this.f4232b, (AdobeCSDKException) null);
    }
}
