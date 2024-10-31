package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;
import com.nexstreaming.kinemaster.ui.settings.tb;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SubscriptionFragment.java */
/* loaded from: classes2.dex */
public class rb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f23189a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ tb f23190b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public rb(tb tbVar, IABManager iABManager) {
        this.f23190b = tbVar;
        this.f23189a = iABManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        tb.b bVar;
        tb.b bVar2;
        IABManager iABManager = this.f23189a;
        if (iABManager != null) {
            if (!(iABManager.n() instanceof com.nexstreaming.app.general.iab.Presenter.B)) {
                bVar = this.f23190b.k;
                bVar.i();
                this.f23189a.E();
            } else {
                com.nexstreaming.app.general.iab.Presenter.B b2 = (com.nexstreaming.app.general.iab.Presenter.B) this.f23189a.n();
                if (b2.D()) {
                    this.f23189a.a(IABBasePresent.State.REQUEST_LOGIN);
                    bVar2 = this.f23190b.k;
                    bVar2.i();
                    this.f23189a.E();
                } else {
                    b2.a(this.f23190b.getActivity());
                }
            }
        }
        this.f23190b.B();
    }
}
