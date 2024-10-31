package com.google.android.gms.internal;

/* loaded from: classes.dex */
class bc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bb f1443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.f1443a = bbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1443a.f1442a.f1441a.destroy();
    }
}
