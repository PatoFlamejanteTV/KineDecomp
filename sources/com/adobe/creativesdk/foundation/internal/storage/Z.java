package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.adobe.creativesdk.foundation.storage.qd;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageDataSource.java */
/* loaded from: classes.dex */
public class Z implements qd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeStorageDataSource f5271a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Z(AdobeStorageDataSource adobeStorageDataSource) {
        this.f5271a = adobeStorageDataSource;
    }

    @Override // com.adobe.creativesdk.foundation.storage.qd
    public void a(ArrayList<C0533a> arrayList, int i) {
        ka n;
        AdobeStorageDataSource adobeStorageDataSource = this.f5271a;
        if (adobeStorageDataSource.f5224h) {
            n = adobeStorageDataSource.n();
            if (n != null) {
                n.b();
            }
            AdobeStorageDataSource adobeStorageDataSource2 = this.f5271a;
            adobeStorageDataSource2.f5224h = false;
            adobeStorageDataSource2.j = false;
            return;
        }
        adobeStorageDataSource.f5218b.addAll(arrayList);
        AdobeStorageDataSource adobeStorageDataSource3 = this.f5271a;
        adobeStorageDataSource3.f5219c = adobeStorageDataSource3.f5218b;
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeStorageDataSourceDidLoadNewPageNotification, null));
        AdobeStorageDataSource adobeStorageDataSource4 = this.f5271a;
        adobeStorageDataSource4.j = false;
        adobeStorageDataSource4.a(adobeStorageDataSource4.f5220d);
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        ka n;
        AdobeStorageDataSource adobeStorageDataSource = this.f5271a;
        adobeStorageDataSource.j = false;
        n = adobeStorageDataSource.n();
        if (n != null) {
            n.b();
        }
    }
}
