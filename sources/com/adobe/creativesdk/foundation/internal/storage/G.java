package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAssetsDataSource.java */
/* loaded from: classes.dex */
public class G implements c.a.a.a.b<ArrayList<AdobePhotoAsset>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f5232a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public G(I i) {
        this.f5232a = i;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoAsset> arrayList) {
        boolean a2;
        ia iaVar;
        ia iaVar2;
        a2 = this.f5232a.a((ArrayList<AdobePhotoAsset>) arrayList);
        if (!a2) {
            this.f5232a.f5238e = true;
        } else {
            this.f5232a.f5236c = true;
        }
        iaVar = this.f5232a.f5235b;
        if (iaVar != null) {
            iaVar2 = this.f5232a.f5235b;
            iaVar2.d();
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobePhotoAssetsDataSourceDidLoadNewPageNotification, null));
    }
}
