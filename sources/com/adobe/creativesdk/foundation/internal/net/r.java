package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class r extends m {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f5144b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f5145c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f5146d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f5147e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(A a2, E e2, F f2, Handler handler) {
        this.f5147e = a2;
        this.f5144b = e2;
        this.f5145c = f2;
        this.f5146d = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.m
    public void a(l lVar) {
        this.f5147e.a(lVar, this.f5144b, this.f5126a, this.f5145c, this.f5146d);
    }
}
