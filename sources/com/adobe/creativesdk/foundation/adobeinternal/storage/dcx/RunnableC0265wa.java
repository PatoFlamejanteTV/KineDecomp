package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import android.os.Handler;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.wa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0265wa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ nb f4471a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0242ka f4472b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Aa f4473c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f4474d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ReentrantLock f4475e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Condition f4476f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Aa f4477g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0265wa(Aa aa, nb nbVar, C0242ka c0242ka, Aa aa2, String str, ReentrantLock reentrantLock, Condition condition) {
        this.f4477g = aa;
        this.f4471a = nbVar;
        this.f4472b = c0242ka;
        this.f4473c = aa2;
        this.f4474d = str;
        this.f4475e = reentrantLock;
        this.f4476f = condition;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        handler = this.f4477g.f4109b;
        handler.post(new RunnableC0263va(this));
    }
}
