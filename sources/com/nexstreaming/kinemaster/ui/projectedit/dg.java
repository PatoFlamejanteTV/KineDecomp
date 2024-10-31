package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.OptionCroppingFragment;

/* compiled from: OptionCroppingFragment.java */
/* loaded from: classes.dex */
class dg implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f3841a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(OptionCroppingFragment optionCroppingFragment) {
        this.f3841a = optionCroppingFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (!this.f3841a.a().isCropLink()) {
            z = this.f3841a.E;
            if (!z) {
                this.f3841a.a(OptionCroppingFragment.EditMode.Start);
            }
        }
    }
}
