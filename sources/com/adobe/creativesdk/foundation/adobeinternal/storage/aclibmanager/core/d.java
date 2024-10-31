package com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core;

import com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.ACLibraryManager;
import com.adobe.creativesdk.foundation.storage.Gb;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ACLibraryManager.java */
/* loaded from: classes.dex */
public class d implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f4088a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.a.b.a.a.d f4089b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ACLibraryManager f4090c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ACLibraryManager aCLibraryManager, boolean[] zArr, c.a.a.a.a.b.a.a.d dVar) {
        this.f4090c = aCLibraryManager;
        this.f4088a = zArr;
        this.f4089b = dVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Gb gb;
        Gb gb2;
        if (this.f4088a[0]) {
            gb = this.f4090c.f4077g;
            if (gb == null) {
                return;
            }
            gb2 = this.f4090c.f4077g;
            gb2.r();
            this.f4088a[0] = false;
            return;
        }
        this.f4089b.a();
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(ACLibraryManager.ACLibraryNotificationID.ACLibrarySyncFinishedNotification, this);
    }
}
