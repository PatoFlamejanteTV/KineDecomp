package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibrarySyncManager.java */
/* loaded from: classes.dex */
public class W implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ha f4560a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public W(ha haVar) {
        this.f4560a = haVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        D d2;
        d2 = this.f4560a.C;
        d2.c(true);
    }
}
