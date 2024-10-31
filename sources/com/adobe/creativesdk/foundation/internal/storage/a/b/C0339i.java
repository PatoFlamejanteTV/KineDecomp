package com.adobe.creativesdk.foundation.internal.storage.a.b;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import org.json.JSONObject;

/* compiled from: AdobeStorageSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.a.b.i */
/* loaded from: classes.dex */
public class C0339i implements ra.b {

    /* renamed from: a */
    final /* synthetic */ xa f5418a;

    /* renamed from: b */
    final /* synthetic */ Handler f5419b;

    /* renamed from: c */
    final /* synthetic */ ra f5420c;

    public C0339i(ra raVar, xa xaVar, Handler handler) {
        this.f5420c = raVar;
        this.f5418a = xaVar;
        this.f5419b = handler;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        if (lVar.g() == 200) {
            JSONObject a2 = com.adobe.creativesdk.foundation.internal.storage.model.util.i.a(lVar.d());
            if (a2 != null) {
                Double valueOf = Double.valueOf(a2.optDouble("storage_used"));
                Double valueOf2 = Double.valueOf(a2.optDouble("storage_available"));
                Double valueOf3 = Double.valueOf(a2.optDouble("storage_quota"));
                xa xaVar = this.f5418a;
                if (xaVar != null) {
                    Handler handler = this.f5419b;
                    if (handler != null) {
                        handler.post(new RunnableC0336f(this, valueOf, valueOf2, valueOf3));
                        return;
                    } else {
                        xaVar.a(valueOf, valueOf2, valueOf3);
                        return;
                    }
                }
                return;
            }
            xa xaVar2 = this.f5418a;
            if (xaVar2 != null) {
                Handler handler2 = this.f5419b;
                if (handler2 != null) {
                    handler2.post(new RunnableC0337g(this));
                } else {
                    xaVar2.a(new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse));
                }
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        AdobeAssetException a2 = ra.a(adobeNetworkException);
        xa xaVar = this.f5418a;
        if (xaVar != null) {
            Handler handler = this.f5419b;
            if (handler != null) {
                handler.post(new RunnableC0338h(this, a2));
            } else {
                xaVar.a(a2);
            }
        }
    }
}
