package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public class i implements c.a.a.a.b<AdobePhotoCatalog> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f6692a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0522e f6693b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Condition f6694c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ F f6695d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(F f2, Lock lock, C0522e c0522e, Condition condition) {
        this.f6695d = f2;
        this.f6692a = lock;
        this.f6693b = c0522e;
        this.f6694c = condition;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AdobePhotoCatalog adobePhotoCatalog) {
        this.f6692a.lock();
        C0522e c0522e = this.f6693b;
        c0522e.f6675a = true;
        c0522e.f6676b = adobePhotoCatalog;
        this.f6694c.signal();
        this.f6692a.unlock();
    }
}
