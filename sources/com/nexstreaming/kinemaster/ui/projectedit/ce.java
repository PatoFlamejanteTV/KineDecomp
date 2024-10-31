package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes2.dex */
class Ce implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ De f21801a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ce(De de2) {
        this.f21801a = de2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f21801a.f21818b.f21847b.f21877b.isResumed()) {
            this.f21801a.f21818b.f21847b.f21877b.G = true;
            this.f21801a.f21818b.f21847b.f21877b.l(true);
            this.f21801a.f21818b.f21847b.f21877b.j(true);
            this.f21801a.f21818b.f21847b.f21877b.k(true);
            this.f21801a.f21818b.f21847b.f21877b.J();
            this.f21801a.f21818b.f21847b.f21877b.F = false;
        }
        do {
        } while (this.f21801a.f21818b.f21847b.f21877b.getFragmentManager().popBackStackImmediate());
        this.f21801a.f21818b.f21847b.f21877b.l(true);
        this.f21801a.f21818b.f21847b.f21877b.j(true);
        this.f21801a.f21818b.f21847b.f21877b.k(true);
        this.f21801a.f21818b.f21847b.f21877b.J();
        this.f21801a.f21818b.f21847b.f21877b.F = false;
    }
}
