package com.adobe.creativesdk.foundation.storage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.qb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0599qb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7390a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeLibraryException f7391b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0614ub f7392c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0599qb(C0614ub c0614ub, c.a.a.a.c cVar, AdobeLibraryException adobeLibraryException) {
        this.f7392c = c0614ub;
        this.f7390a = cVar;
        this.f7391b = adobeLibraryException;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7390a.a(this.f7391b);
    }
}
