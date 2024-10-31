package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
class gw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ gv f3940a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gw(gv gvVar) {
        this.f3940a = gvVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3940a.f3939a.b.b.i(true);
        this.f3940a.f3939a.b.b.k(true);
        this.f3940a.f3939a.b.b.j(true);
        this.f3940a.f3939a.b.b.k();
        this.f3940a.f3939a.b.b.d = false;
    }
}
