package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpService.java */
/* loaded from: classes.dex */
public class z extends m {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f5187b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f5188c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Handler f5189d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f5190e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(A a2, E e2, F f2, Handler handler) {
        this.f5190e = a2;
        this.f5187b = e2;
        this.f5188c = f2;
        this.f5189d = handler;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.m
    public void a(l lVar) {
        this.f5190e.a(lVar, this.f5187b, this.f5126a, this.f5188c, this.f5189d);
    }
}
