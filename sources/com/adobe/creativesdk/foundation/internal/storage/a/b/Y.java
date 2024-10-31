package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public class Y implements vb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f5361a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ka f5362b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f5363c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ra f5364d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(ra raVar, Lock lock, ka kaVar, Condition condition) {
        this.f5364d = raVar;
        this.f5361a = lock;
        this.f5362b = kaVar;
        this.f5363c = condition;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.vb
    public void a(com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, AdobeCSDKException adobeCSDKException) {
        this.f5361a.lock();
        try {
            this.f5362b.f5432c = adobeCSDKException;
            this.f5362b.f5431b = fVar;
            this.f5362b.f5430a = true;
            this.f5363c.signal();
        } finally {
            this.f5361a.unlock();
        }
    }
}
