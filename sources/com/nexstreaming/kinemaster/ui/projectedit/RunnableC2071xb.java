package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: MediaEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2071xb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f22763a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2079yb f22764b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2071xb(C2079yb c2079yb, String str) {
        this.f22764b = c2079yb;
        this.f22763a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22764b.f22788a.f22801b.dismiss();
        this.f22764b.f22788a.f22802c.h(this.f22763a);
        this.f22764b.f22788a.f22802c.da().H();
    }
}
