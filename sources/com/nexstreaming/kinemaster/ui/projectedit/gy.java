package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
class gy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ gx f3942a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gy(gx gxVar) {
        this.f3942a = gxVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f3942a.b.b.b.isResumed()) {
            this.f3942a.b.b.b.e = true;
            this.f3942a.b.b.b.i(true);
            this.f3942a.b.b.b.k(true);
            this.f3942a.b.b.b.j(true);
            this.f3942a.b.b.b.k();
            this.f3942a.b.b.b.d = false;
        }
        do {
        } while (this.f3942a.b.b.b.getFragmentManager().popBackStackImmediate());
        this.f3942a.b.b.b.i(true);
        this.f3942a.b.b.b.k(true);
        this.f3942a.b.b.b.j(true);
        this.f3942a.b.b.b.k();
        this.f3942a.b.b.b.d = false;
    }
}
