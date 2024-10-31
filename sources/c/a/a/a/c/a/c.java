package c.a.a.a.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout;

/* compiled from: AdobeCommonLearnedSettings.java */
/* loaded from: classes.dex */
public class c {
    private static void a(String str, String str2) {
        SharedPreferences.Editor edit = e().edit();
        edit.putString(str, str2);
        edit.commit();
    }

    private static String b(String str, String str2) {
        return e().getString(str, str2);
    }

    public static AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType c() {
        return AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.valueOf(b("lastSortType", AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_TIME.toString()));
    }

    public static AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout d() {
        return AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.valueOf(b("VisualLayout", AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.ADOBE_STORAGE_VISUAL_LAYOUT_WATERFALL.toString()));
    }

    private static SharedPreferences e() {
        return f().getSharedPreferences("CommonLearnedSettings", 0);
    }

    private static Context f() {
        return a.b().a();
    }

    public static AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState b() {
        String b2;
        if (c() == AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.SORT_TYPE_TIME) {
            b2 = b("lastSortState", AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.SORT_STATE_DESCENDING.toString());
        } else {
            b2 = b("lastSortState", AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.SORT_STATE_ASCENDING.toString());
        }
        return AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.valueOf(b2);
    }

    public static void a(AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout) {
        a("VisualLayout", adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserVisualLayout.toString());
    }

    public static void a(AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType) {
        a("lastSortType", adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortType.toString());
    }

    public static void a(AdobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState) {
        a("lastSortState", adobeUXAssetBrowserCommonTypes$AdobeUXAssetBrowserSortState.toString());
    }

    public static AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType a() {
        return AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType.valueOf(b("lastCollectionSortType", AdobeUXAssetBrowserCommonTypes$AdobePhotoSortType.ADOBE_PHOTO_SORT_TYPE_TIME.toString()));
    }
}
