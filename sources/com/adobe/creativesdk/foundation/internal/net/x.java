package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class x extends m {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f5176b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f5177c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f5178d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f5179e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(A a2, E e2, F f2, Handler handler) {
        this.f5179e = a2;
        this.f5176b = e2;
        this.f5177c = f2;
        this.f5178d = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.m
    public void a(l lVar) {
        this.f5179e.a(lVar, this.f5176b, this.f5126a, this.f5177c, this.f5178d);
    }
}
