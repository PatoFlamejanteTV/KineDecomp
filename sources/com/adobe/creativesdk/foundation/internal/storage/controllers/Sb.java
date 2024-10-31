package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Rb;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesListView.java */
/* loaded from: classes.dex */
public class Sb implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUploadAssetData f5822a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z f5823b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Rb.b.C0029b f5824c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sb(Rb.b.C0029b c0029b, AdobeUploadAssetData adobeUploadAssetData, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
        this.f5824c = c0029b;
        this.f5822a = adobeUploadAssetData;
        this.f5823b = zVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        AdobeUploadAssetData adobeUploadAssetData;
        Bitmap bitmap;
        AdobeUploadAssetData adobeUploadAssetData2 = (AdobeUploadAssetData) obj;
        if (adobeUploadAssetData2.d() == AdobeUploadAssetData.UploadStatus.Completed && adobeUploadAssetData2.q != null && (bitmap = (adobeUploadAssetData = this.f5822a).k) != null) {
            Rb.this.a(bitmap, adobeUploadAssetData.q, adobeUploadAssetData.p, adobeUploadAssetData.r);
        }
        this.f5824c.c(adobeUploadAssetData2, this.f5823b);
    }
}
