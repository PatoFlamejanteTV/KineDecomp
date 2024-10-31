package com.google.android.gms.internal;

/* loaded from: classes.dex */
class bg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bf f1447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.f1447a = bfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1447a.f1446a.destroy();
    }
}
