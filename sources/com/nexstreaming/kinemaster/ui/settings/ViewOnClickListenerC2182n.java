package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;

/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2182n implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentC2201x f23168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2182n(FragmentC2201x fragmentC2201x) {
        this.f23168a = fragmentC2201x;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IABManager iABManager = this.f23168a.F;
        if (iABManager != null) {
            if (iABManager.n() instanceof com.nexstreaming.app.general.iab.Presenter.B) {
                com.nexstreaming.app.general.iab.Presenter.B b2 = (com.nexstreaming.app.general.iab.Presenter.B) this.f23168a.F.n();
                if (b2.D()) {
                    this.f23168a.F.a(IABBasePresent.State.REQUEST_LOGIN);
                    this.f23168a.F.F();
                    return;
                } else {
                    b2.a(this.f23168a.getActivity());
                    return;
                }
            }
            this.f23168a.F.F();
        }
    }
}
