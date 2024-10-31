package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataSourceDelegate.java */
/* loaded from: classes.dex */
public class fa implements ha {

    /* renamed from: a */
    private AdobeAssetDataSourceType f6581a;

    public fa(AdobeAssetDataSourceType adobeAssetDataSourceType) {
        this.f6581a = adobeAssetDataSourceType;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ha
    public void a() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ha
    public void a(int i) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ha
    public void a(AdobeAssetException adobeAssetException) {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ha
    public void b() {
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ha
    public void c() {
        if (na.c() != null) {
            na.c().c(this.f6581a);
        }
    }
}
