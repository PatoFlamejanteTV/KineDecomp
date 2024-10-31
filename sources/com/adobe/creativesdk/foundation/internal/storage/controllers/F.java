package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAsset;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;

/* compiled from: AdobePhotoAssetViewerController.java */
/* loaded from: classes.dex */
public class F {

    /* renamed from: a */
    private static Observer f5633a;

    /* renamed from: b */
    private static Observer f5634b;

    /* renamed from: c */
    private static InterfaceC0406fd f5635c;

    /* renamed from: d */
    private static ArrayList<AdobePhotoAsset> f5636d;

    /* renamed from: e */
    private static WeakReference<com.adobe.creativesdk.foundation.internal.storage.I> f5637e;

    /* renamed from: f */
    private static int f5638f;

    private F() {
    }

    public static void c(int i) {
        f5638f = i;
    }

    public synchronized InterfaceC0406fd d() {
        return f5635c;
    }

    public int e() {
        return com.adobe.creativesdk.foundation.internal.storage.ca.d();
    }

    public int f() {
        return f5638f;
    }

    public int g() {
        com.adobe.creativesdk.foundation.internal.storage.I i;
        WeakReference<com.adobe.creativesdk.foundation.internal.storage.I> weakReference = f5637e;
        if (weakReference == null || (i = weakReference.get()) == null) {
            return -1;
        }
        return i.e();
    }

    public boolean h() {
        ArrayList<AdobePhotoAsset> arrayList = f5636d;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean i() {
        return com.adobe.creativesdk.foundation.internal.storage.ca.b();
    }

    public void j() {
        com.adobe.creativesdk.foundation.internal.storage.I i;
        WeakReference<com.adobe.creativesdk.foundation.internal.storage.I> weakReference = f5637e;
        if (weakReference == null || (i = weakReference.get()) == null) {
            return;
        }
        i.c();
    }

    public synchronized void k() {
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, f5633a);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, f5633a);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobePhotoAssetsDataSourceDidLoadNewPageNotification, f5634b);
        f5635c = null;
        f5638f = -1;
        f5633a = null;
        f5634b = null;
    }

    static void b(com.adobe.creativesdk.foundation.internal.storage.I i, AdobePhotoAsset adobePhotoAsset) {
        f5637e = new WeakReference<>(i);
        f5636d = i.d();
        f5638f = a(f5636d, adobePhotoAsset);
    }

    public int c() {
        ArrayList<AdobePhotoAsset> arrayList = f5636d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void c(AdobePhotoAsset adobePhotoAsset) {
        com.adobe.creativesdk.foundation.internal.storage.ca.c(adobePhotoAsset);
    }

    private static int a(ArrayList<AdobePhotoAsset> arrayList, AdobePhotoAsset adobePhotoAsset) {
        if (adobePhotoAsset == null) {
            return -1;
        }
        int i = 0;
        Iterator<AdobePhotoAsset> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().isEqualToAsset(adobePhotoAsset)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public AdobePhotoAsset b(int i) {
        return f5636d.get(i);
    }

    public static F a(com.adobe.creativesdk.foundation.internal.storage.I i, AdobePhotoAsset adobePhotoAsset) {
        F f2 = new F();
        b(i, adobePhotoAsset);
        return f2;
    }

    public boolean b(AdobePhotoAsset adobePhotoAsset) {
        return com.adobe.creativesdk.foundation.internal.storage.ca.b(adobePhotoAsset);
    }

    public void a(AdobePhotoAsset adobePhotoAsset) {
        com.adobe.creativesdk.foundation.internal.storage.ca.a(adobePhotoAsset);
    }

    public void a(AdobePhotoAsset adobePhotoAsset, com.adobe.creativesdk.foundation.storage.sd<byte[], AdobePhotoException> sdVar) {
        com.adobe.creativesdk.foundation.internal.storage.I.a(adobePhotoAsset, sdVar);
    }

    public static synchronized void a(InterfaceC0406fd interfaceC0406fd) {
        synchronized (F.class) {
            f5635c = interfaceC0406fd;
            f5633a = new D();
            f5634b = new E();
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, f5633a);
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, f5633a);
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobePhotoAssetsDataSourceDidLoadNewPageNotification, f5634b);
        }
    }
}
