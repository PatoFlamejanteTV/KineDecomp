package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;

/* compiled from: AdobeAssetMobileCreationSelectionState.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0515n {

    /* renamed from: a, reason: collision with root package name */
    private static AdobeAssetFile f6628a;

    /* renamed from: b, reason: collision with root package name */
    private static AdobeAssetPackagePages f6629b;

    public static void a(AdobeAssetPackagePages adobeAssetPackagePages, AdobeAssetFile adobeAssetFile) {
        f6628a = adobeAssetFile;
        f6629b = adobeAssetPackagePages;
    }

    public static boolean b() {
        return (f6628a == null || f6629b == null) ? false : true;
    }

    public static void c() {
        f6628a = null;
    }

    public static AdobeAssetFile a() {
        return f6628a;
    }
}
