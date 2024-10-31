package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRendition;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import com.adobe.creativesdk.foundation.storage.AdobePhotoPage;
import com.adobe.creativesdk.foundation.storage.sd;
import com.adobe.creativesdk.foundation.storage.td;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
public class T implements td {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCollection f5254a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ sd f5255b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(AdobePhotoCollection adobePhotoCollection, sd sdVar) {
        this.f5254a = adobePhotoCollection;
        this.f5255b = sdVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.td
    public void a(ArrayList<AdobePhotoAsset> arrayList, AdobePhotoPage adobePhotoPage, AdobePhotoPage adobePhotoPage2) {
        if (arrayList != null && arrayList.size() >= 1) {
            AdobePhotoAsset adobePhotoAsset = arrayList.get(0);
            this.f5254a.setCoverAsset(adobePhotoAsset);
            Map<String, AdobePhotoAssetRendition> renditions = adobePhotoAsset.getRenditions();
            if (renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x) != null) {
                adobePhotoAsset.downloadRendition(renditions.get(AdobePhotoAsset.AdobePhotoAssetRenditionImageThumbnail2x), this.f5255b);
            } else {
                this.f5255b.b(null);
            }
        }
        if (arrayList == null || arrayList.size() != 0) {
            return;
        }
        this.f5255b.b(null);
    }
}
