package com.adobe.creativesdk.foundation.internal.storage.controllers;

import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.cb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0370cb implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb f5973a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0370cb(AbstractC0414hb abstractC0414hb) {
        this.f5973a = abstractC0414hb;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        this.f5973a.f6107f.g();
    }
}
