package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.GraphResponse;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class M implements com.adobe.creativesdk.foundation.internal.storage.a.b.va {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.d f7053a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7054b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f7055c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f7056d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ sd f7057e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7058f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f7059g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(AdobeAssetFile adobeAssetFile, com.adobe.creativesdk.foundation.internal.analytics.d dVar, String str, int i, Handler handler, sd sdVar, AdobeAssetFile adobeAssetFile2) {
        this.f7059g = adobeAssetFile;
        this.f7053a = dVar;
        this.f7054b = str;
        this.f7055c = i;
        this.f7056d = handler;
        this.f7057e = sdVar;
        this.f7058f = adobeAssetFile2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.va
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        AdobeAssetFile adobeAssetFile = this.f7059g;
        adobeAssetFile.uploadRequest = null;
        if (fVar != null) {
            adobeAssetFile.asrItem = fVar;
            adobeAssetFile.etag = fVar.f6613e;
            adobeAssetFile.name = fVar.f6611c;
            adobeAssetFile.GUID = fVar.f6609a;
            adobeAssetFile.href = fVar.f6610b;
            adobeAssetFile.md5Hash = fVar.f();
            this.f7059g.links = fVar.j;
            if (fVar.k() != null) {
                this.f7059g.currentVersion = Integer.parseInt(fVar.k());
            } else {
                this.f7059g.currentVersion = 0;
            }
            String str = fVar.f6615g;
            if (str != null) {
                this.f7059g.modificationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(str);
            } else {
                AdobeAssetFile adobeAssetFile2 = this.f7059g;
                adobeAssetFile2.modificationDate = adobeAssetFile2.creationDate;
            }
            this.f7059g.optionalMetadata = fVar.h();
            com.adobe.creativesdk.foundation.internal.analytics.q.b("Product Saves", "Creative Cloud");
            this.f7053a.a(fVar.f6613e, fVar.f6611c, "", this.f7054b, "" + this.f7055c);
            this.f7053a.a(GraphResponse.SUCCESS_KEY);
            Handler handler = this.f7056d;
            if (handler != null) {
                handler.post(new I(this));
                return;
            } else {
                this.f7057e.b(this.f7058f);
                return;
            }
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:Update", String.format("Failed to Create/Update File: %s", adobeAssetFile.name));
        this.f7053a.a("failure");
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        Handler handler = this.f7056d;
        if (handler != null) {
            handler.post(new J(this, d2));
        } else {
            this.f7057e.a(d2);
        }
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException != null && adobeAssetException.getErrorCode().equals(AdobeAssetErrorCode.AdobeAssetErrorCancelled)) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAssetFile:Update", String.format("Update request for %s has been cancelled.", this.f7059g.href));
            this.f7053a.a(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
            Handler handler = this.f7056d;
            if (handler != null) {
                handler.post(new K(this));
                return;
            } else {
                this.f7057e.a();
                return;
            }
        }
        if (adobeAssetException != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:Update", String.format("Update request for %s ended in error: %s.", this.f7059g.href, adobeAssetException.toString()));
            this.f7053a.a("failure");
            Handler handler2 = this.f7056d;
            if (handler2 != null) {
                handler2.post(new L(this, adobeAssetException));
            } else {
                this.f7057e.a((sd) adobeAssetException);
            }
        }
    }
}
