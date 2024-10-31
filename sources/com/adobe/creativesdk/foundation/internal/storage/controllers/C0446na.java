package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXLibraryItemCollectionOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.na, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0446na implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXLibraryItemCollectionOneUpViewerActivity f6343a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0446na(AdobeUXLibraryItemCollectionOneUpViewerActivity adobeUXLibraryItemCollectionOneUpViewerActivity) {
        this.f6343a = adobeUXLibraryItemCollectionOneUpViewerActivity;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f6343a.F();
        this.f6343a.G();
    }
}
