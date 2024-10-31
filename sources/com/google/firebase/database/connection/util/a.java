package com.google.firebase.database.connection.util;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Runnable f16822a;

    /* renamed from: b */
    final /* synthetic */ RetryHelper f16823b;

    public a(RetryHelper retryHelper, Runnable runnable) {
        this.f16823b = retryHelper;
        this.f16822a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16823b.f16808h = null;
        this.f16822a.run();
    }
}
