package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoAssetViewerController.java */
/* loaded from: classes.dex */
public class E implements Observer {
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        InterfaceC0406fd interfaceC0406fd;
        WeakReference weakReference;
        WeakReference weakReference2;
        WeakReference weakReference3;
        InterfaceC0406fd interfaceC0406fd2;
        interfaceC0406fd = F.f5635c;
        int unused = F.f5638f = interfaceC0406fd.d();
        weakReference = F.f5637e;
        if (weakReference != null) {
            weakReference2 = F.f5637e;
            if (weakReference2.get() != null) {
                weakReference3 = F.f5637e;
                ArrayList unused2 = F.f5636d = ((com.adobe.creativesdk.foundation.internal.storage.I) weakReference3.get()).d();
                interfaceC0406fd2 = F.f5635c;
                interfaceC0406fd2.f();
            }
        }
    }
}
