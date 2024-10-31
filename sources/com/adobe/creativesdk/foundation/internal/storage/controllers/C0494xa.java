package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXMobilePackageItemOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.xa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0494xa implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXMobilePackageItemOneUpViewerActivity f6526a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0494xa(AdobeUXMobilePackageItemOneUpViewerActivity adobeUXMobilePackageItemOneUpViewerActivity) {
        this.f6526a = adobeUXMobilePackageItemOneUpViewerActivity;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f6526a.E();
        this.f6526a.C();
    }
}
