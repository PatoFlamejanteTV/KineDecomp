package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.OptionCroppingFragment;

/* compiled from: OptionCroppingFragment.java */
/* loaded from: classes.dex */
class dl implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f3846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(OptionCroppingFragment optionCroppingFragment) {
        this.f3846a = optionCroppingFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        if (!this.f3846a.a().isCropLink()) {
            z = this.f3846a.E;
            if (!z) {
                this.f3846a.a(OptionCroppingFragment.EditMode.End);
            }
        }
    }
}
