package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes.dex */
class cx implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cr f3831a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cr crVar) {
        this.f3831a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean c;
        cr crVar = this.f3831a;
        c = this.f3831a.c();
        crVar.a(!c);
        this.f3831a.e();
    }
}
