package com.adobe.creativesdk.foundation.storage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.mb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0583mb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7350a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7351b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0614ub f7352c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0583mb(C0614ub c0614ub, c.a.a.a.b bVar, String str) {
        this.f7352c = c0614ub;
        this.f7350a = bVar;
        this.f7351b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7350a.b(this.f7351b);
    }
}
