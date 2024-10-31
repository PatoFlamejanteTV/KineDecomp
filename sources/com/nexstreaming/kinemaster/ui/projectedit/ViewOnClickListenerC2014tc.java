package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.OptionCroppingFragment;

/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.tc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2014tc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f22537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2014tc(OptionCroppingFragment optionCroppingFragment) {
        this.f22537a = optionCroppingFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (this.f22537a.sa().isCropLink()) {
            return;
        }
        z = this.f22537a.P;
        if (z) {
            return;
        }
        this.f22537a.a(OptionCroppingFragment.EditMode.Start);
    }
}
