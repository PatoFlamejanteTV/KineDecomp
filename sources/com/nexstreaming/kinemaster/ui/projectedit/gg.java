package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: ReverseController.kt */
/* loaded from: classes2.dex */
final class Gg implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Hg f21880a;

    public Gg(Hg hg) {
        this.f21880a = hg;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.nexstreaming.kinemaster.ui.a.p pVar;
        pVar = this.f21880a.f21894a.f22058c;
        if (pVar != null) {
            pVar.dismissAllowingStateLoss();
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
