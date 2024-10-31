package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.Sc;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DesignLibraryItemsListView.java */
/* loaded from: classes.dex */
public class Rc implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z f5810a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Sc.a f5811b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rc(Sc.a aVar, com.adobe.creativesdk.foundation.internal.storage.controllers.upload.z zVar) {
        this.f5811b = aVar;
        this.f5810a = zVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f5811b.b((AdobeUploadAssetData) obj, this.f5810a);
    }
}
