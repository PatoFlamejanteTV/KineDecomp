package com.google.android.gms.internal;

/* loaded from: classes.dex */
class cm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzgf f1479a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(zzgf zzgfVar) {
        this.f1479a = zzgfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1479a.onStop();
    }
}
