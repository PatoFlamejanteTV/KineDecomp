package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import com.nexstreaming.kinemaster.ui.settings.tb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionFragment.java */
/* loaded from: classes2.dex */
public class qb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f23183a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ tb f23184b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qb(tb tbVar, IABManager iABManager) {
        this.f23184b = tbVar;
        this.f23183a = iABManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        tb.b bVar;
        tb.b bVar2;
        IABManager iABManager = this.f23183a;
        if (iABManager != null) {
            if (!(iABManager.n() instanceof com.nexstreaming.app.general.iab.Presenter.B)) {
                bVar = this.f23184b.k;
                bVar.i();
                this.f23183a.F();
            } else {
                com.nexstreaming.app.general.iab.Presenter.B b2 = (com.nexstreaming.app.general.iab.Presenter.B) this.f23183a.n();
                if (b2.D()) {
                    this.f23183a.a(IABBasePresent.State.REQUEST_LOGIN);
                    bVar2 = this.f23184b.k;
                    bVar2.i();
                    this.f23183a.F();
                } else {
                    b2.a(this.f23184b.getActivity());
                }
            }
        }
        this.f23184b.B();
    }
}
