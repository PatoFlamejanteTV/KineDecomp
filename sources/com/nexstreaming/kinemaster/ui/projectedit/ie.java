package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.Toast;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;

/* compiled from: OptionSplitScreenFragment.java */
/* loaded from: classes2.dex */
class Ie implements PopoutListMenu.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SplitScreenType f21902a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Je f21903b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ie(Je je, SplitScreenType splitScreenType) {
        this.f21903b = je;
        this.f21902a = splitScreenType;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.PopoutListMenu.b
    public void a(PopoutListMenu popoutListMenu, int i) {
        if (i == -1) {
            c.d.b.l.a.f3846a.a(this.f21902a);
            Toast.makeText(this.f21903b.getActivity(), R.string.layer_menu_setdefault_applied, 0).show();
        }
    }
}
