package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* compiled from: AdobeDesignLibraryEditSession.java */
/* loaded from: classes.dex */
class d implements c.a.a.a.b<String> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Lock f6202a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Condition f6203b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f6204c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f6205d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(g gVar, Lock lock, Condition condition, c cVar) {
        this.f6205d = gVar;
        this.f6202a = lock;
        this.f6203b = condition;
        this.f6204c = cVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(String str) {
        this.f6202a.lock();
        this.f6203b.signal();
        try {
            if (this.f6205d.f6211a.j().equals("rendition")) {
                while (this.f6205d.f6213c.h() == null) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            this.f6205d.f6213c.a(this.f6205d.f6211a.m(), str, null, false, this.f6205d.f6211a.j(), null, null, true);
            l.c(this.f6205d.f6217g);
        } catch (AdobeLibraryException e3) {
            e3.printStackTrace();
        }
        this.f6204c.f6200a = true;
        this.f6202a.unlock();
    }
}
