package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.os.Bundle;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetMimeTypes;
import java.util.EnumSet;

/* compiled from: AdobeAssetsViewContainerConfiguration.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.t */
/* loaded from: classes.dex */
public class C0474t {

    /* renamed from: a */
    private AdobeAssetDataSourceType f6404a;

    /* renamed from: b */
    private com.adobe.creativesdk.foundation.internal.storage.model.resources.e f6405b;

    /* renamed from: c */
    private EnumSet<AdobeAssetMimeTypes> f6406c;

    /* renamed from: d */
    private boolean f6407d;

    /* renamed from: e */
    private boolean f6408e;

    /* renamed from: f */
    private EnumSet<AdobeAssetDataSourceType> f6409f;

    /* renamed from: g */
    private AdobeCloud f6410g;

    public void a(Bundle bundle) {
        this.f6404a = (AdobeAssetDataSourceType) bundle.getSerializable("ASSET_CONTAINER_DATA_SOURCE_TYPE");
        this.f6405b = (com.adobe.creativesdk.foundation.internal.storage.model.resources.e) bundle.getParcelable("ASSET_CONTAINER_TARGET_COLLECTION");
        this.f6406c = (EnumSet) bundle.getSerializable("ASSET_CONTAINER_MIME_FILTERS");
        this.f6407d = bundle.getBoolean("ASSET_CONTAINER_MIME_TYPES_FILTER");
        this.f6408e = bundle.getBoolean("ASSET_CONTAINER_IS_READ_ONLY");
        AdobeCloud adobeCloud = (AdobeCloud) bundle.getSerializable("ADOBE_CLOUD");
        if (adobeCloud != null) {
            this.f6410g = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().b(adobeCloud);
        }
        this.f6409f = (EnumSet) bundle.getSerializable("MOBILE_CREATION_FILTERED_TYPES");
    }

    public AdobeAssetDataSourceType b() {
        return this.f6404a;
    }

    public boolean c() {
        return this.f6407d;
    }

    public EnumSet<AdobeAssetMimeTypes> d() {
        return this.f6406c;
    }

    public EnumSet<AdobeAssetDataSourceType> e() {
        return this.f6409f;
    }

    public com.adobe.creativesdk.foundation.internal.storage.model.resources.e f() {
        return this.f6405b;
    }

    public boolean g() {
        return this.f6408e;
    }

    public AdobeCloud a() {
        return this.f6410g;
    }
}
