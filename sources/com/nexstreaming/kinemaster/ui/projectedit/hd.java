package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;

/* compiled from: OptionTabFragment.java */
/* loaded from: classes.dex */
class hd implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionTabFragment f3948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hd(OptionTabFragment optionTabFragment) {
        this.f3948a = optionTabFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3948a.b(OptionTabFragment.TabId.ItemEditTab);
    }
}
