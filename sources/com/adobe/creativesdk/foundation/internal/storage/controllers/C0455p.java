package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.adobe.creativesdk.foundation.internal.storage.C0512k;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStorageOrderByProperty;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStorageOrderRelation;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderBy;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFolderOrderDirection;
import com.adobe.creativesdk.foundation.storage.C0578la;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AdobeAssetViewUtils.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0455p {

    /* renamed from: a, reason: collision with root package name */
    private static String f6364a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f6365b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, String> f6366c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f6367d = false;

    public static boolean a(Context context) {
        boolean z;
        if (f6365b == -1) {
            try {
                z = context.getPackageManager().hasSystemFeature("android.hardware.camera.any");
            } catch (Exception unused) {
                z = true;
            }
            f6365b = z ? 1 : 2;
        }
        return f6365b == 1;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        if (f6364a == null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.adobe.ccsdk.ccAssetsContainer_private_preference", 0);
                if (sharedPreferences != null) {
                    f6364a = sharedPreferences.getString("ccfilescontainer_private_appId", null);
                }
            } catch (Exception unused) {
            }
        }
        String str = f6364a;
        return str != null && str.equalsIgnoreCase("com.adobe.cc.android.loki");
    }

    public static AdobeAssetFolderOrderBy b() {
        if (c.a.a.a.c.a.c.c() == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_ALPHA) {
            return AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_NAME;
        }
        return AdobeAssetFolderOrderBy.ADOBE_ASSET_FOLDER_ORDER_BY_MODIFIED;
    }

    public static int a(int i) {
        return (int) (i * Resources.getSystem().getDisplayMetrics().density);
    }

    public static SpannableString a(String str, Activity activity) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new com.adobe.creativesdk.foundation.internal.utils.d(null, com.adobe.creativesdk.foundation.internal.utils.c.a(activity)), 0, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(activity.getResources().getColor(c.a.a.a.b.b.adobe_csdk_asset_browser_dark_text)), 0, spannableString.length(), 33);
        return spannableString;
    }

    public static AdobeAssetFolderOrderDirection a() {
        if (c.a.a.a.c.a.c.b() == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.SORT_STATE_ASCENDING) {
            return AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_ASCENDING;
        }
        return AdobeAssetFolderOrderDirection.ADOBE_ASSET_FOLDER_ORDER_DESCENDING;
    }

    public static C0578la a(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar) {
        try {
            return new C0512k(eVar, AdobeStorageOrderByProperty.ADOBE_STORAGE_ORDER_BY_NAME, AdobeStorageOrderRelation.ADOBE_STORAGE_ORDER_ASCENDING, new URI(com.adobe.creativesdk.foundation.internal.storage.model.util.g.b(eVar.f6610b.getRawPath())));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static C0578la a(String str, boolean z) {
        C0578la a2;
        AdobeAssetFolderOrderBy b2 = b();
        AdobeAssetFolderOrderDirection a3 = a();
        if (str != null) {
            try {
                a2 = C0578la.a(new URI(str), b2, a3);
            } catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
            return (a2 == null && z) ? C0578la.a(b2, a3) : a2;
        }
        a2 = null;
        if (a2 == null) {
            return a2;
        }
    }

    public static void a(String str, String str2) {
        f6366c.put(str, str2);
    }

    public static boolean a(String str) {
        return f6366c.containsKey(str);
    }
}
