package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetViewFragment.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ab, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0360ab implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0414hb f5941a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0360ab(AbstractC0414hb abstractC0414hb) {
        this.f5941a = abstractC0414hb;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        int i = Xa.f5886a[((AdobeNetworkReachability.a) ((com.adobe.creativesdk.foundation.internal.notification.c) obj).b().get("AdobeNetworkReachabilityStatusKey")).f4071a.ordinal()];
        if (i != 1 && i != 2) {
            this.f5941a.g(false);
        } else {
            this.f5941a.h(true);
        }
    }
}
