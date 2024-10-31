package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.qd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageDataSource.java */
/* loaded from: classes.dex */
public class Y implements qd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f5269a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeStorageDataSource f5270b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(AdobeStorageDataSource adobeStorageDataSource, int i) {
        this.f5270b = adobeStorageDataSource;
        this.f5269a = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0151, code lost:            if (r13.c() == false) goto L52;     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011a  */
    @Override // com.adobe.creativesdk.foundation.storage.qd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.ArrayList<com.adobe.creativesdk.foundation.storage.C0533a> r12, int r13) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.creativesdk.foundation.internal.storage.Y.a(java.util.ArrayList, int):void");
    }

    @Override // c.a.a.a.c
    public void a(AdobeAssetException adobeAssetException) {
        ka n;
        n = this.f5270b.n();
        if (n != null) {
            n.a(adobeAssetException);
        }
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.CCContainerViewControllerEndRefreshNotification, null));
        this.f5270b.i = false;
    }
}
