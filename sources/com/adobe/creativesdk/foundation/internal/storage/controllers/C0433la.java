package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXAssetVideoActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.la, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0433la implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXAssetVideoActivity f6176a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0433la(AdobeUXAssetVideoActivity adobeUXAssetVideoActivity) {
        this.f6176a = adobeUXAssetVideoActivity;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        int i = C0438ma.f6253a[((AdobeNetworkReachability.a) ((com.adobe.creativesdk.foundation.internal.notification.c) obj).b().get("AdobeNetworkReachabilityStatusKey")).f4071a.ordinal()];
        if (i == 1 || i == 2) {
            this.f6176a.e();
        } else {
            this.f6176a.d();
        }
    }
}
