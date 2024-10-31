package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class m implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f6708a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0522e f6709b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f6710c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6711d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(F f2, Lock lock, C0522e c0522e, Condition condition) {
        this.f6711d = f2;
        this.f6708a = lock;
        this.f6709b = c0522e;
        this.f6710c = condition;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f6708a.lock();
        C0522e c0522e = this.f6709b;
        c0522e.f6675a = true;
        c0522e.f6677c = adobeCSDKException;
        this.f6710c.signal();
        this.f6708a.unlock();
    }
}
