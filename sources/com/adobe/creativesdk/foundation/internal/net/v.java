package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class v extends m {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f5165b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f5166c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f5167d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f5168e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(A a2, E e2, F f2, Handler handler) {
        this.f5168e = a2;
        this.f5165b = e2;
        this.f5166c = f2;
        this.f5167d = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.m
    public void a(l lVar) {
        this.f5168e.a(lVar, this.f5165b, this.f5126a, this.f5166c, this.f5167d);
    }
}
