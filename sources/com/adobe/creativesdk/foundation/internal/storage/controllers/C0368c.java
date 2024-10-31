package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.AdobeAssetMimeTypes;
import java.util.EnumSet;

/* compiled from: AdobeAssetMainBrowserConfiguration.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0368c {

    /* renamed from: a, reason: collision with root package name */
    private EnumSet<AdobeAssetDataSourceType> f5961a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5962b;

    /* renamed from: c, reason: collision with root package name */
    private EnumSet<AdobeAssetMimeTypes> f5963c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5964d;

    /* renamed from: e, reason: collision with root package name */
    private AdobeCloud f5965e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0368c(EnumSet<AdobeAssetDataSourceType> enumSet, boolean z, EnumSet<AdobeAssetMimeTypes> enumSet2, boolean z2, AdobeCloud adobeCloud) {
        this.f5961a = enumSet;
        this.f5962b = z;
        this.f5963c = enumSet2;
        this.f5964d = z2;
        if (adobeCloud != null) {
            this.f5965e = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().b(adobeCloud);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdobeCloud a() {
        return this.f5965e;
    }

    public EnumSet<AdobeAssetDataSourceType> b() {
        return this.f5961a;
    }
}
