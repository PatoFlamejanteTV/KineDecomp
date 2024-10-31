package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* compiled from: CCFilesWithUploadFragment.java */
/* loaded from: classes.dex */
class Xb implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0415hc f5887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xb(C0415hc c0415hc) {
        this.f5887a = c0415hc;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f5887a.q(((Integer) ((com.adobe.creativesdk.foundation.internal.notification.c) obj).b().get("unreadCount")).intValue());
    }
}
