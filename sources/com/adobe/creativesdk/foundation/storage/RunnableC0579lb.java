package com.adobe.creativesdk.foundation.storage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryComposite.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.lb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class RunnableC0579lb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7336a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f7337b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0614ub f7338c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC0579lb(C0614ub c0614ub, c.a.a.a.b bVar, String str) {
        this.f7338c = c0614ub;
        this.f7336a = bVar;
        this.f7337b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7336a.b(this.f7337b);
    }
}
