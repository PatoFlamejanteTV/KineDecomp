package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* compiled from: AdobeAssetViewerController.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.q */
/* loaded from: classes.dex */
public class C0460q implements Observer {

    /* renamed from: a */
    final /* synthetic */ C0469s f6379a;

    public C0460q(C0469s c0469s) {
        this.f6379a = c0469s;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        InterfaceC0406fd interfaceC0406fd;
        InterfaceC0406fd interfaceC0406fd2;
        interfaceC0406fd = C0469s.f6391c;
        if (interfaceC0406fd == null) {
            return;
        }
        interfaceC0406fd2 = C0469s.f6391c;
        interfaceC0406fd2.h();
    }
}
