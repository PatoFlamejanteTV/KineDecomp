package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import java.util.ArrayList;

/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
class Q implements c.a.a.a.b<ArrayList<AdobePhotoCollection>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f5252a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(U u) {
        this.f5252a = u;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoCollection> arrayList) {
        ja jaVar;
        ja jaVar2;
        ArrayList arrayList2;
        if (arrayList != null) {
            arrayList2 = this.f5252a.i;
            arrayList2.addAll(arrayList);
            this.f5252a.f5259d = true;
        } else {
            this.f5252a.f5260e = true;
        }
        jaVar = this.f5252a.f5256a;
        if (jaVar != null) {
            jaVar2 = this.f5252a.f5256a;
            jaVar2.e();
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobePhotoCollectionsDataSourceDidLoadNewPageNotification, null));
    }
}
