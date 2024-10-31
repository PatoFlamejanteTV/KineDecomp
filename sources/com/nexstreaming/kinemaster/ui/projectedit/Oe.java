package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;

/* compiled from: OptionTabFragment.java */
/* loaded from: classes2.dex */
class Oe implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ OptionTabFragment f21985a;

    public Oe(OptionTabFragment optionTabFragment) {
        this.f21985a = optionTabFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f21985a.d(OptionTabFragment.TabId.ItemOptionTab);
    }
}
