package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import com.adobe.creativesdk.foundation.internal.storage.controllers.xd;
import java.util.Observable;
import java.util.Observer;

/* compiled from: PhotosAssetListView.java */
/* loaded from: classes.dex */
class zd implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUploadAssetData f6560a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z f6561b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ xd.b f6562c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zd(xd.b bVar, AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
        this.f6562c = bVar;
        this.f6560a = adobeUploadAssetData;
        this.f6561b = zVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        AdobeUploadAssetData adobeUploadAssetData;
        Bitmap bitmap;
        AdobeUploadAssetData adobeUploadAssetData2 = (AdobeUploadAssetData) obj;
        if (adobeUploadAssetData2.d() == AdobeUploadAssetData.UploadStatus.Completed && adobeUploadAssetData2.q != null && (bitmap = (adobeUploadAssetData = this.f6560a).k) != null) {
            xd.this.a(bitmap, adobeUploadAssetData.q, adobeUploadAssetData.p, adobeUploadAssetData.r);
        }
        this.f6562c.b(adobeUploadAssetData2, this.f6561b);
    }
}
