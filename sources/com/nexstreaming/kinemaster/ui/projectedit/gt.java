package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
class gt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ gs f3937a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gt(gs gsVar) {
        this.f3937a = gsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3937a.b.b.i(true);
        this.f3937a.b.b.k(true);
        this.f3937a.b.b.j(true);
        this.f3937a.b.b.k();
        this.f3937a.b.b.d = false;
    }
}
