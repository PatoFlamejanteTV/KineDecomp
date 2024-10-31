package com.google.android.gms.tagmanager;

/* loaded from: classes.dex */
class ag implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f2214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.f2214a = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar;
        lVar = this.f2214a.b;
        lVar.a();
    }
}
