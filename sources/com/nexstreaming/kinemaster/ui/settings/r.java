package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import com.nexstreaming.app.general.iab.Presenter.IABBasePresent;

/* compiled from: AccountInfoV4Fragment.java */
/* loaded from: classes2.dex */
class r implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewOnClickListenerC2191s f23185a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ViewOnClickListenerC2191s viewOnClickListenerC2191s) {
        this.f23185a = viewOnClickListenerC2191s;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f23185a.f23191a.F.a(IABBasePresent.State.REQUEST_LOGIN);
        this.f23185a.f23191a.j();
        dialogInterface.dismiss();
    }
}
