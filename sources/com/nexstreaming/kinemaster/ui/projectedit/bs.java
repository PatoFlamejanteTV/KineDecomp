package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
class bs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3800a;
    final /* synthetic */ br b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar, String str) {
        this.b = brVar;
        this.f3800a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.f3799a.b.dismiss();
        this.b.f3799a.c.a(this.f3800a);
        this.b.f3799a.c.o().n();
    }
}
