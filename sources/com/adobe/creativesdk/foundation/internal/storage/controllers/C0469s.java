package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.storage.AdobeStorageDataSource;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observer;

/* compiled from: AdobeAssetViewerController.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.s */
/* loaded from: classes.dex */
public class C0469s {

    /* renamed from: a */
    private static Observer f6389a;

    /* renamed from: b */
    private static Observer f6390b;

    /* renamed from: c */
    private static InterfaceC0406fd f6391c;

    /* renamed from: d */
    protected ArrayList<C0533a> f6392d;

    /* renamed from: e */
    private WeakReference<AdobeStorageDataSource> f6393e = null;

    /* renamed from: f */
    private int f6394f;

    private C0469s() {
    }

    void b(AdobeStorageDataSource adobeStorageDataSource, C0533a c0533a) {
        this.f6393e = new WeakReference<>(adobeStorageDataSource);
        if (adobeStorageDataSource != null) {
            this.f6392d = adobeStorageDataSource.j();
            this.f6394f = a(this.f6392d, c0533a);
        } else {
            b(c0533a);
        }
        if (this.f6394f == -1) {
            b(c0533a);
        }
    }

    public void c(AdobeAssetFile adobeAssetFile) {
        com.adobe.creativesdk.foundation.internal.storage.W.c(adobeAssetFile);
    }

    public int d() {
        return com.adobe.creativesdk.foundation.internal.storage.W.d();
    }

    public int e() {
        return this.f6394f;
    }

    public boolean f() {
        ArrayList<C0533a> arrayList = this.f6392d;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean g() {
        return com.adobe.creativesdk.foundation.internal.storage.W.b();
    }

    public boolean h() {
        AdobeStorageDataSource adobeStorageDataSource;
        WeakReference<AdobeStorageDataSource> weakReference = this.f6393e;
        if (weakReference == null || (adobeStorageDataSource = weakReference.get()) == null) {
            return false;
        }
        return adobeStorageDataSource.i();
    }

    public synchronized void i() {
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, f6389a);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, f6389a);
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(AdobeInternalNotificationID.AdobeStorageDataSourceDidLoadNewPageNotification, f6390b);
        f6391c = null;
        this.f6394f = -1;
        f6389a = null;
        f6390b = null;
    }

    public synchronized InterfaceC0406fd c() {
        return f6391c;
    }

    public static C0469s a(C0533a c0533a) {
        C0469s c0469s = new C0469s();
        c0469s.b(c0533a);
        return c0469s;
    }

    public static C0469s a(AdobeStorageDataSource adobeStorageDataSource, C0533a c0533a) {
        C0469s c0469s = new C0469s();
        c0469s.b(adobeStorageDataSource, c0533a);
        return c0469s;
    }

    public void b(C0533a c0533a) {
        this.f6392d = new ArrayList<>();
        this.f6392d.add(c0533a);
        this.f6394f = 0;
    }

    private static int a(ArrayList<C0533a> arrayList, C0533a c0533a) {
        if (c0533a == null) {
            return -1;
        }
        int i = 0;
        Iterator<C0533a> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().equals(c0533a)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public C0533a a(int i) {
        return this.f6392d.get(i);
    }

    public void b(int i) {
        this.f6394f = i;
    }

    public void a(AdobeAssetFile adobeAssetFile) {
        com.adobe.creativesdk.foundation.internal.storage.W.a(adobeAssetFile);
    }

    public int b() {
        ArrayList<C0533a> arrayList = this.f6392d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public synchronized void a(InterfaceC0406fd interfaceC0406fd) {
        f6391c = interfaceC0406fd;
        f6389a = new C0460q(this);
        f6390b = new r(this);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetAssetCountChangeNotification, f6389a);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageSelectedAssetMultiselectModeDidChangeNotification, f6389a);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(AdobeInternalNotificationID.AdobeStorageDataSourceDidLoadNewPageNotification, f6390b);
    }

    public boolean b(AdobeAssetFile adobeAssetFile) {
        return com.adobe.creativesdk.foundation.internal.storage.W.b(adobeAssetFile);
    }
}
