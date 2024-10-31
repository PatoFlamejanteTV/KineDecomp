package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.e.c;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
public final class Dd implements c.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f21815a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f21816b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dd(Bd bd, int i) {
        this.f21815a = bd;
        this.f21816b = i;
    }

    @Override // com.nexstreaming.kinemaster.ui.e.c.b
    public void a(int i) {
        if (i == -1) {
            this.f21815a.q(this.f21816b);
        }
        this.f21815a.r = true;
    }
}
