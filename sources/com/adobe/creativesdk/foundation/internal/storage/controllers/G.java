package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.os.Bundle;

/* compiled from: AdobePhotosViewContainerConfiguration.java */
/* loaded from: classes.dex */
public class G extends C0474t {

    /* renamed from: h */
    private String f5648h;
    private String i;
    private String j;
    private String k;

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0474t
    public void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        super.a(bundle);
        this.f5648h = (String) bundle.get("ASSET_CONTAINER_TARGET_COLLECTION_GUID");
        this.i = (String) bundle.get("ASSET_CONTAINER_TARGET_COLLECTION_NAME");
        this.j = (String) bundle.get("ASSET_CONTAINER_TARGET_COLLECTION_CATALOG_GUID");
        this.k = (String) bundle.get("ASSET_CONTAINER_TARGET_COLLECTION_CATALOG_NAME");
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.k;
    }

    public String j() {
        return this.f5648h;
    }

    public String k() {
        return this.i;
    }
}
