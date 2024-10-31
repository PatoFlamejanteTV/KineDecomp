package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.OptionCroppingFragment;

/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.uc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2046uc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f22726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2046uc(OptionCroppingFragment optionCroppingFragment) {
        this.f22726a = optionCroppingFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (this.f22726a.sa().isCropLink()) {
            return;
        }
        z = this.f22726a.P;
        if (z) {
            return;
        }
        this.f22726a.a(OptionCroppingFragment.EditMode.End);
    }
}
