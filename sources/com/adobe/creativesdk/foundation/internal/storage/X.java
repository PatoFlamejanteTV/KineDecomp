package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.Comparator;

/* compiled from: AdobeStorageDataSource.java */
/* loaded from: classes.dex */
class X implements Comparator<C0533a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Y f5268a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public X(Y y) {
        this.f5268a = y;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C0533a c0533a, C0533a c0533a2) {
        if (this.f5268a.f5270b.f5221e.f6566b == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.SORT_STATE_ASCENDING) {
            return c0533a.getName().toLowerCase().compareTo(c0533a2.getName().toLowerCase());
        }
        return c0533a2.getName().toLowerCase().compareTo(c0533a.getName().toLowerCase());
    }
}
