package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;

/* compiled from: OptionTabFragment.java */
/* loaded from: classes2.dex */
class Ne implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ OptionTabFragment f21974a;

    public Ne(OptionTabFragment optionTabFragment) {
        this.f21974a = optionTabFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f21974a.d(OptionTabFragment.TabId.ItemEditTab);
    }
}
