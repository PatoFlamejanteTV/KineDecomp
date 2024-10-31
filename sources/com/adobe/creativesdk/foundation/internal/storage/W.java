package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: AdobeStorageAssetSelectionState.java */
/* loaded from: classes.dex */
public class W {

    /* renamed from: a, reason: collision with root package name */
    static boolean f5265a = false;

    /* renamed from: b, reason: collision with root package name */
    static HashMap<String, C0533a> f5266b = null;

    /* renamed from: c, reason: collision with root package name */
    static int f5267c = 1;

    public static int a() {
        return f5267c;
    }

    public static boolean b(AdobeAssetFile adobeAssetFile) {
        return f().containsKey(adobeAssetFile.getGUID());
    }

    public static void c(AdobeAssetFile adobeAssetFile) {
        if (adobeAssetFile == null) {
            return;
        }
        g();
        f().remove(adobeAssetFile.getGUID());
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, null));
    }

    public static int d() {
        return f().size();
    }

    public static ArrayList<C0533a> e() {
        return new ArrayList<>(f().values());
    }

    public static HashMap<String, C0533a> f() {
        if (f5266b == null) {
            f5266b = new HashMap<>();
        }
        return f5266b;
    }

    private static void g() {
        f5267c++;
    }

    public static void a(AdobeAssetFile adobeAssetFile) {
        if (adobeAssetFile == null) {
            return;
        }
        g();
        f().put(adobeAssetFile.getGUID(), adobeAssetFile);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, null));
    }

    public static boolean b() {
        return f5265a;
    }

    public static void c() {
        f5266b = new HashMap<>();
        g();
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, null));
    }
}
