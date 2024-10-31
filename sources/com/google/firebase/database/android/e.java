package com.google.firebase.database.android;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f16672a;

    /* renamed from: b */
    final /* synthetic */ Throwable f16673b;

    /* renamed from: c */
    final /* synthetic */ f f16674c;

    public e(f fVar, String str, Throwable th) {
        this.f16674c = fVar;
        this.f16672a = str;
        this.f16673b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new RuntimeException(this.f16672a, this.f16673b);
    }
}
