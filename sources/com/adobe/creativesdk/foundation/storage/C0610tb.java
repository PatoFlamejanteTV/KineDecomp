package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.tb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0610tb implements c.a.a.a.c<AdobeNetworkException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f7427a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7428b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7429c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f7430d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0614ub f7431e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0610tb(C0614ub c0614ub, JSONObject jSONObject, String str, c.a.a.a.c cVar, Handler handler) {
        this.f7431e = c0614ub;
        this.f7427a = jSONObject;
        this.f7428b = str;
        this.f7429c = cVar;
        this.f7430d = handler;
    }

    @Override // c.a.a.a.c
    public void a(AdobeNetworkException adobeNetworkException) {
        if (com.adobe.creativesdk.foundation.internal.storage.a.a.b.a((com.adobe.creativesdk.foundation.internal.net.l) adobeNetworkException.getData().get(AdobeNetworkException.getKeyForResponse()))) {
            try {
                this.f7427a.put(this.f7428b, "ERROR");
                this.f7431e.w();
            } catch (JSONException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0614ub.class.getSimpleName(), null, e2);
            }
        }
        c.a.a.a.c cVar = this.f7429c;
        if (cVar != null) {
            this.f7431e.a((c.a.a.a.c<AdobeLibraryException>) cVar, this.f7430d, new AdobeLibraryException(AdobeLibraryErrorCode.AdobeLibraryErrorDownloadingRepresentationAsset));
        }
    }
}
