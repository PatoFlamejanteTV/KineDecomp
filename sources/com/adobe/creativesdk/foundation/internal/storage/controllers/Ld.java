package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* compiled from: PhotosCollectionFragment.java */
/* loaded from: classes.dex */
class Ld implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Od f5715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ld(Od od) {
        this.f5715a = od;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.f5715a.getActivity() == null || !this.f5715a.isAdded()) {
            return;
        }
        this.f5715a.ra();
        com.adobe.creativesdk.foundation.internal.storage.controllers.upload.f.f6445a = false;
    }
}
