package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* compiled from: PhotosAssetsFragment.java */
/* loaded from: classes.dex */
class Cd implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fd f5608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cd(Fd fd) {
        this.f5608a = fd;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f5608a.C();
    }
}
