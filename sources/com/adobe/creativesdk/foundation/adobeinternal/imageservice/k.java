package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.sd;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class k implements sd<com.adobe.creativesdk.foundation.internal.storage.model.resources.f, AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f4027a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f[] f4028b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean[] f4029c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Condition f4030d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException[] f4031e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f4032f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ t f4033g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(t tVar, Lock lock, com.adobe.creativesdk.foundation.internal.storage.model.resources.f[] fVarArr, boolean[] zArr, Condition condition, AdobeCSDKException[] adobeCSDKExceptionArr, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f4033g = tVar;
        this.f4027a = lock;
        this.f4028b = fVarArr;
        this.f4029c = zArr;
        this.f4030d = condition;
        this.f4031e = adobeCSDKExceptionArr;
        this.f4032f = fVar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar) {
        this.f4027a.lock();
        this.f4028b[0] = fVar;
        this.f4029c[0] = true;
        this.f4030d.signal();
        this.f4027a.unlock();
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f4027a.lock();
        this.f4031e[0] = adobeCSDKException;
        this.f4028b[0] = this.f4032f;
        this.f4029c[0] = true;
        this.f4030d.signal();
        this.f4027a.unlock();
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        this.f4027a.lock();
        this.f4029c[0] = true;
        this.f4030d.signal();
        this.f4027a.unlock();
    }
}
