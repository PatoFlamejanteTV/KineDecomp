package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.GroupLayer;

/* compiled from: MultiSelectOptionFragment.java */
/* loaded from: classes2.dex */
class Nb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GroupLayer f21969a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Qb f21970b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nb(Qb qb, GroupLayer groupLayer) {
        this.f21970b = qb;
        this.f21969a = groupLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21970b.f(this.f21969a);
    }
}
