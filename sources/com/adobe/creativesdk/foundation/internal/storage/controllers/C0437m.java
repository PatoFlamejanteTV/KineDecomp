package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.content.Intent;
import com.adobe.creativesdk.foundation.internal.storage.C0515n;
import com.adobe.creativesdk.foundation.internal.storage.model.util.AdobeStorageAssetFileInfo;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AdobeAssetViewBrowserSelectFilesHelper.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0437m {
    public static Intent a() {
        ArrayList<C0533a> e2 = com.adobe.creativesdk.foundation.internal.storage.W.e();
        ArrayList arrayList = new ArrayList();
        if (e2 != null && e2.size() > 0) {
            Iterator<C0533a> it = e2.iterator();
            while (it.hasNext()) {
                arrayList.add(new AdobeStorageAssetFileInfo((AdobeAssetFile) it.next()));
            }
        }
        com.adobe.creativesdk.foundation.internal.storage.W.c();
        com.adobe.creativesdk.foundation.internal.storage.ca.c();
        Intent intent = new Intent();
        intent.putExtra("ADOBE_ASSETBROWSER_ASSETFILE_SELECTION_LIST", arrayList);
        if (com.adobe.creativesdk.foundation.internal.storage.ba.b()) {
            intent.putExtra("ADOBE_ASSETBROWSER_LIBRARY_SELECTION_LIST", com.adobe.creativesdk.foundation.internal.storage.ba.a().c());
        }
        if (C0515n.b()) {
            intent.putExtra("ASSETBROWSER_MOBILE_PACKAGE_SELECTION_ITEM", C0515n.a().getGUID());
        }
        return intent;
    }

    public static Intent b() {
        com.adobe.creativesdk.foundation.internal.storage.W.c();
        Intent intent = new Intent();
        ArrayList<AdobePhotoAsset> e2 = com.adobe.creativesdk.foundation.internal.storage.ca.e();
        ArrayList arrayList = new ArrayList();
        if (e2 != null && e2.size() > 0) {
            Iterator<AdobePhotoAsset> it = e2.iterator();
            while (it.hasNext()) {
                arrayList.add(new AdobeStorageAssetFileInfo(it.next()));
            }
        }
        com.adobe.creativesdk.foundation.internal.storage.ca.c();
        com.adobe.creativesdk.foundation.internal.storage.W.c();
        intent.putExtra("ADOBE_ASSETBROWSER_PHOTOASSET_SELECTION_LIST", arrayList);
        return intent;
    }
}
