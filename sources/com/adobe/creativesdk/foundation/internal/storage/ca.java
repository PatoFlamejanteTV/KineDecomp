package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: AdobeStoragePhotoAssetSelectionState.java */
/* loaded from: classes.dex */
public class ca {

    /* renamed from: a, reason: collision with root package name */
    static boolean f5503a = false;

    /* renamed from: b, reason: collision with root package name */
    static HashMap<String, AdobePhotoAsset> f5504b = null;

    /* renamed from: c, reason: collision with root package name */
    static int f5505c = -1;

    public static int a() {
        return f5505c;
    }

    public static boolean b(AdobePhotoAsset adobePhotoAsset) {
        return f().containsKey(adobePhotoAsset.getGUID());
    }

    public static void c(AdobePhotoAsset adobePhotoAsset) {
        if (adobePhotoAsset == null) {
            return;
        }
        g();
        f().remove(adobePhotoAsset.getGUID());
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, null));
    }

    public static int d() {
        return f().size();
    }

    public static ArrayList<AdobePhotoAsset> e() {
        return new ArrayList<>(f().values());
    }

    public static HashMap<String, AdobePhotoAsset> f() {
        if (f5504b == null) {
            f5504b = new HashMap<>();
        }
        return f5504b;
    }

    private static void g() {
        f5505c++;
    }

    public static void a(AdobePhotoAsset adobePhotoAsset) {
        if (adobePhotoAsset == null) {
            return;
        }
        g();
        f().put(adobePhotoAsset.getGUID(), adobePhotoAsset);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, null));
    }

    public static boolean b() {
        return f5503a;
    }

    public static void c() {
        f5504b = new HashMap<>();
        g();
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, null));
    }
}
