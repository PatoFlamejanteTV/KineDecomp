package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import com.nexstreaming.app.general.iab.IABManager;

/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2184o implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FragmentC2201x f23172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2184o(FragmentC2201x fragmentC2201x) {
        this.f23172a = fragmentC2201x;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IABManager iABManager = this.f23172a.F;
        if (iABManager != null) {
            iABManager.B();
        }
    }
}
