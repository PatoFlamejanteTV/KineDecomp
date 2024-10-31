package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class t extends m {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f5154b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f5155c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f5156d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f5157e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(A a2, E e2, F f2, Handler handler) {
        this.f5157e = a2;
        this.f5154b = e2;
        this.f5155c = f2;
        this.f5156d = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.m
    public void a(l lVar) {
        this.f5157e.a(lVar, this.f5154b, this.f5126a, this.f5155c, this.f5156d);
    }
}
