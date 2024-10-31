package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* compiled from: PhotosCollectionFragment.java */
/* loaded from: classes.dex */
class Kd implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Od f5705a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Kd(Od od) {
        this.f5705a = od;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f5705a.C();
    }
}
