package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.GraphResponse;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFile.java */
/* loaded from: classes.dex */
public class F implements com.adobe.creativesdk.foundation.internal.storage.a.b.va {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.d f6965a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f6966b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ sd f6967c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f6968d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AdobeAssetFile f6969e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public F(AdobeAssetFile adobeAssetFile, com.adobe.creativesdk.foundation.internal.analytics.d dVar, String str, sd sdVar, AdobeAssetFile adobeAssetFile2) {
        this.f6969e = adobeAssetFile;
        this.f6965a = dVar;
        this.f6966b = str;
        this.f6967c = sdVar;
        this.f6968d = adobeAssetFile2;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.va
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        AdobeAssetFile adobeAssetFile = this.f6969e;
        adobeAssetFile.uploadRequest = null;
        if (fVar != null) {
            adobeAssetFile.asrItem = fVar;
            adobeAssetFile.etag = fVar.f6613e;
            adobeAssetFile.name = fVar.f6611c;
            adobeAssetFile.GUID = fVar.f6609a;
            adobeAssetFile.href = fVar.f6610b;
            adobeAssetFile.md5Hash = fVar.f();
            this.f6969e.links = fVar.j;
            if (fVar.e() != null) {
                this.f6969e.fileSize = fVar.e().intValue();
            } else {
                this.f6969e.fileSize = 0L;
            }
            if (fVar.k() != null) {
                this.f6969e.currentVersion = Integer.parseInt(fVar.k());
            } else {
                this.f6969e.currentVersion = 0;
            }
            String str = fVar.f6615g;
            if (str != null) {
                this.f6969e.modificationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(str);
            } else {
                AdobeAssetFile adobeAssetFile2 = this.f6969e;
                adobeAssetFile2.modificationDate = adobeAssetFile2.creationDate;
            }
            this.f6969e.optionalMetadata = fVar.h();
            com.adobe.creativesdk.foundation.internal.analytics.q.b("Product Saves", "Creative Cloud");
            this.f6965a.a(fVar.f6613e, fVar.f6611c, "", this.f6966b, "" + this.f6969e.fileSize);
            this.f6965a.a(GraphResponse.SUCCESS_KEY);
            this.f6967c.b(this.f6968d);
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:Update", String.format("Failed to Create/Update File: %s", adobeAssetFile.name));
        this.f6965a.a("failure");
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f6967c.a(d2);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        if (adobeAssetException != null && adobeAssetException.getErrorCode().equals(AdobeAssetErrorCode.AdobeAssetErrorCancelled)) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.INFO, "AdobeAssetFile:Update", String.format("Update request for %s has been cancelled.", this.f6969e.href));
            this.f6965a.a(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
            this.f6967c.a();
        } else if (adobeAssetException != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetFile:Update", String.format("Update request for %s ended in error: %s.", this.f6969e.href, adobeAssetException.toString()));
            this.f6965a.a("failure");
            this.f6967c.a((sd) adobeAssetException);
        }
    }
}
