package com.google.firebase.database.android;

import com.google.firebase.internal.InternalTokenResult;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InternalTokenResult f16668a;

    /* renamed from: b */
    final /* synthetic */ d f16669b;

    public c(d dVar, InternalTokenResult internalTokenResult) {
        this.f16669b = dVar;
        this.f16668a = internalTokenResult;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f16669b.f16670a.a(this.f16668a.a());
    }
}
