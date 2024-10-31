package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.AdobeStorageDataSource;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetViewerController.java */
/* loaded from: classes.dex */
public class r implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0469s f6384a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(C0469s c0469s) {
        this.f6384a = c0469s;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        InterfaceC0406fd interfaceC0406fd;
        InterfaceC0406fd interfaceC0406fd2;
        WeakReference weakReference;
        InterfaceC0406fd interfaceC0406fd3;
        WeakReference weakReference2;
        interfaceC0406fd = C0469s.f6391c;
        if (interfaceC0406fd == null) {
            return;
        }
        C0469s c0469s = this.f6384a;
        interfaceC0406fd2 = C0469s.f6391c;
        c0469s.f6394f = interfaceC0406fd2.d();
        AdobeStorageDataSource adobeStorageDataSource = null;
        weakReference = this.f6384a.f6393e;
        if (weakReference != null) {
            weakReference2 = this.f6384a.f6393e;
            adobeStorageDataSource = (AdobeStorageDataSource) weakReference2.get();
        }
        if (adobeStorageDataSource != null) {
            ArrayList<C0533a> a2 = adobeStorageDataSource.f5221e.a();
            this.f6384a.f6392d = new ArrayList<>();
            Iterator<C0533a> it = a2.iterator();
            while (it.hasNext()) {
                C0533a next = it.next();
                if (next instanceof AdobeAssetFile) {
                    this.f6384a.f6392d.add(next);
                }
            }
            interfaceC0406fd3 = C0469s.f6391c;
            interfaceC0406fd3.f();
        }
    }
}
