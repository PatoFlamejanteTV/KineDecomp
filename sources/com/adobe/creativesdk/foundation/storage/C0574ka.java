package com.adobe.creativesdk.foundation.storage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ka */
/* loaded from: classes.dex */
public /* synthetic */ class C0574ka {

    /* renamed from: a */
    static final /* synthetic */ int[] f7314a;

    /* renamed from: b */
    static final /* synthetic */ int[] f7315b = new int[AdobeAssetFolderOrderDirection.values().length];

    static {
        try {
            f7315b[AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_ASCENDING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7315b[AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_DESCENDING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f7314a = new int[AdobeAssetFolderOrderBy.values().length];
        try {
            f7314a[AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_NAME.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7314a[AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
