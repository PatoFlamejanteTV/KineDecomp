package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;

/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2191s implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentC2201x f23191a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2191s(FragmentC2201x fragmentC2201x) {
        this.f23191a = fragmentC2201x;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.a aVar = new e.a(this.f23191a.getActivity());
        aVar.c(R.string.Restore_subscription_msg);
        aVar.b(100);
        aVar.c(R.string.button_ok, new r(this));
        aVar.a().show();
    }
}
