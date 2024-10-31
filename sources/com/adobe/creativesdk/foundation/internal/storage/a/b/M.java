package com.adobe.creativesdk.foundation.internal.storage.a.b;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.C0231f;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.mb;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class M implements ra.b {

    /* renamed from: a */
    final /* synthetic */ mb f5322a;

    /* renamed from: b */
    final /* synthetic */ Handler f5323b;

    /* renamed from: c */
    final /* synthetic */ C0231f f5324c;

    /* renamed from: d */
    final /* synthetic */ ra f5325d;

    public M(ra raVar, mb mbVar, Handler handler, C0231f c0231f) {
        this.f5325d = raVar;
        this.f5322a = mbVar;
        this.f5323b = handler;
        this.f5324c = c0231f;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        if (adobeNetworkException.getData() != null) {
            com.adobe.creativesdk.foundation.internal.net.l lVar = (com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get("Response");
            if (lVar != null) {
                a(lVar);
                return;
            }
            mb mbVar = this.f5322a;
            if (mbVar != null) {
                Handler handler = this.f5323b;
                if (handler != null) {
                    handler.post(new I(this, adobeNetworkException));
                    return;
                } else {
                    mbVar.a(adobeNetworkException);
                    return;
                }
            }
            return;
        }
        mb mbVar2 = this.f5322a;
        if (mbVar2 != null) {
            Handler handler2 = this.f5323b;
            if (handler2 != null) {
                handler2.post(new J(this, adobeNetworkException));
            } else {
                mbVar2.a(adobeNetworkException);
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        AdobeAssetException a2 = (g2 == 200 || g2 == 204 || g2 == 404) ? null : ra.a(lVar);
        if (a2 == null) {
            mb mbVar = this.f5322a;
            if (mbVar != null) {
                Handler handler = this.f5323b;
                if (handler != null) {
                    handler.post(new K(this));
                    return;
                } else {
                    mbVar.a(this.f5324c);
                    return;
                }
            }
            return;
        }
        mb mbVar2 = this.f5322a;
        if (mbVar2 != null) {
            Handler handler2 = this.f5323b;
            if (handler2 != null) {
                handler2.post(new L(this, a2));
            } else {
                mbVar2.a(a2);
            }
        }
    }
}
