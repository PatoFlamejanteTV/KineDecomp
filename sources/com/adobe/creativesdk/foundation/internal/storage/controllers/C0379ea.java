package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXAssetOneUpViewerActivity;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXAssetOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ea, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0379ea implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXAssetOneUpViewerActivity.b f6013a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0379ea(AdobeUXAssetOneUpViewerActivity.b bVar) {
        this.f6013a = bVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        int i = C0374da.f6008a[((AdobeNetworkReachability.a) ((com.adobe.creativesdk.foundation.internal.notification.c) obj).b().get("AdobeNetworkReachabilityStatusKey")).f4071a.ordinal()];
        if (i != 1 && i != 2) {
            com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.p pVar = this.f6013a.f5531b;
            if (pVar != null) {
                pVar.g();
                return;
            }
            return;
        }
        com.adobe.creativesdk.foundation.internal.storage.controllers.multipage.p pVar2 = this.f6013a.f5531b;
        if (pVar2 != null) {
            pVar2.h();
        }
    }
}
