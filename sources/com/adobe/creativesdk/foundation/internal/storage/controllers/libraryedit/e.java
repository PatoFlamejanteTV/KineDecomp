package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* compiled from: AdobeDesignLibraryEditSession.java */
/* loaded from: classes.dex */
class e implements c.a.a.a.c<AdobeLibraryException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f6206a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Condition f6207b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f6208c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f6209d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, Lock lock, Condition condition, c cVar) {
        this.f6209d = gVar;
        this.f6206a = lock;
        this.f6207b = condition;
        this.f6208c = cVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeLibraryException adobeLibraryException) {
        this.f6206a.lock();
        l.c(this.f6209d.f6217g);
        this.f6207b.signal();
        this.f6208c.f6200a = true;
        this.f6206a.unlock();
    }
}
