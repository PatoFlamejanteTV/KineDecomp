package com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core;

import com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.ACLibraryManager;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ACLibraryManager.java */
/* loaded from: classes.dex */
public class c implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.a.b.a.a.d f4086a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ACLibraryManager f4087b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ACLibraryManager aCLibraryManager, c.a.a.a.a.b.a.a.d dVar) {
        this.f4087b = aCLibraryManager;
        this.f4086a = dVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f4086a.a();
        com.adobe.creativesdk.foundation.internal.notification.b.a().b(ACLibraryManager.ACLibraryNotificationID.ACLibrarySyncFinishedNotification, this);
    }
}
