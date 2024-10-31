package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStoragePagingMode;
import com.adobe.creativesdk.foundation.internal.storage.model.util.ParsingDataException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
class la implements ra.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ta f5438a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.e f5439b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeStoragePagingMode f5440c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5441d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public la(ra raVar, ta taVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStoragePagingMode adobeStoragePagingMode) {
        this.f5441d = raVar;
        this.f5438a = taVar;
        this.f5439b = eVar;
        this.f5440c = adobeStoragePagingMode;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f5438a.a((ta) ra.a(adobeNetworkException));
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.ra.b
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        int g2 = lVar.g();
        AdobeAssetException adobeAssetException = null;
        if (g2 != 200 && g2 != 304) {
            adobeAssetException = ra.a(lVar);
        } else if (g2 != 304) {
            try {
                this.f5439b.a(lVar.d(), this.f5440c == AdobeStoragePagingMode.AdobeStorageNextPageAppend);
            } catch (ParsingDataException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "", "", e2);
            }
            if (lVar.e() != null && lVar.e().containsKey("x-children-next-start")) {
                this.f5439b.b(lVar.e().get("x-children-next-start").get(0));
            } else {
                this.f5439b.b(null);
            }
        }
        if (adobeAssetException == null) {
            this.f5438a.a(this.f5439b);
        } else {
            this.f5438a.a((ta) adobeAssetException);
        }
    }
}
