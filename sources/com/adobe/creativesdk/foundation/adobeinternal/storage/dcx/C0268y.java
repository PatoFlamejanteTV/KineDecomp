package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXCompositeXfer.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0268y implements ib {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4484a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0270z f4485b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0268y(C0270z c0270z, String str) {
        this.f4485b = c0270z;
        this.f4484a = str;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ib
    public void a(C0225c c0225c, AdobeCSDKException adobeCSDKException) {
        String str;
        AdobeDCXException a2;
        if (adobeCSDKException != null) {
            if (adobeCSDKException.getData() != null && adobeCSDKException.getData().containsKey(AdobeEntitlementException.AdobeNetworkHTTPStatusKey) && ((Integer) adobeCSDKException.getData().get(AdobeEntitlementException.AdobeNetworkHTTPStatusKey)).intValue() == 404) {
                a2 = new AdobeDCXException(AdobeDCXErrorCode.AdobeDCXErrorMissingComponentAsset);
                adobeCSDKException = null;
            }
            a2 = null;
        } else {
            if (this.f4485b.f4494e.f4105f.L()) {
                try {
                    this.f4485b.a();
                    a2 = null;
                } catch (Exception e2) {
                    AdobeDCXErrorCode adobeDCXErrorCode = AdobeDCXErrorCode.AdobeDCXErrorComponentWriteFailure;
                    StringBuilder sb = new StringBuilder();
                    sb.append("invalid write permissions for filePath : ");
                    str = this.f4485b.f4490a;
                    sb.append(str);
                    a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.e.a(adobeDCXErrorCode, sb.toString(), e2);
                }
                if (a2 != null && this.f4485b.f4494e.f4105f.v()) {
                    com.adobe.creativesdk.foundation.internal.storage.model.util.f.c(this.f4484a);
                }
            }
            a2 = null;
        }
        A a3 = this.f4485b.f4494e;
        if (a3.f4106g) {
            try {
                C0225c f2 = a3.f4101b.f(c0225c);
                if (f2 != null) {
                    this.f4485b.f4494e.f4105f.u().a(f2.i(), this.f4485b.f4494e.f4101b, this.f4485b.f4494e.f4105f, this.f4484a);
                }
            } catch (AdobeDCXException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Y.class.getSimpleName(), null, e3);
            }
        } else {
            try {
                a3.f4105f.p().a(c0225c, (C0233g) this.f4485b.f4494e.f4105f.p());
            } catch (AdobeDCXException e4) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, Y.class.getSimpleName(), null, e4);
            }
        }
        if (a2 != null) {
            adobeCSDKException = a2;
        }
        this.f4485b.f4492c.a(adobeCSDKException);
        this.f4485b.f4494e.f4104e.a(adobeCSDKException);
    }
}
