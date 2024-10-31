package com.adobe.creativesdk.foundation.storage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.pb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0595pb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7380a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeLibraryException f7381b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0614ub f7382c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0595pb(C0614ub c0614ub, c.a.a.a.c cVar, AdobeLibraryException adobeLibraryException) {
        this.f7382c = c0614ub;
        this.f7380a = cVar;
        this.f7381b = adobeLibraryException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7380a.a(this.f7381b);
    }
}
