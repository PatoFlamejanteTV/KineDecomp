package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ib, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0567ib implements c.a.a.a.c<AdobeLibraryException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7289a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Handler f7290b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0614ub f7291c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0567ib(C0614ub c0614ub, c.a.a.a.c cVar, Handler handler) {
        this.f7291c = c0614ub;
        this.f7289a = cVar;
        this.f7290b = handler;
    }

    @Override // c.a.a.a.c
    public void a(AdobeLibraryException adobeLibraryException) {
        c.a.a.a.c cVar = this.f7289a;
        if (cVar != null) {
            this.f7291c.a((c.a.a.a.c<AdobeLibraryException>) cVar, this.f7290b, adobeLibraryException);
        }
    }
}
