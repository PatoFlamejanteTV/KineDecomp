package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* compiled from: MobileCreationPackageCollectionFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.gd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0411gd implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0416hd f6100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0411gd(C0416hd c0416hd) {
        this.f6100a = c0416hd;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f6100a.C();
    }
}
