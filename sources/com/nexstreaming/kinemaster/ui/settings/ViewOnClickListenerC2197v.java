package com.nexstreaming.kinemaster.ui.settings;

import android.content.DialogInterface;
import android.view.View;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.iab.SKUDetails;

/* compiled from: AccountInfoV4Fragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.settings.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC2197v implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SKUDetails f23212a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ FragmentC2201x f23213b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC2197v(FragmentC2201x fragmentC2201x, SKUDetails sKUDetails) {
        this.f23213b = fragmentC2201x;
        this.f23212a = sKUDetails;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f23213b.getActivity() != null) {
            if (c.d.b.m.i.f(this.f23213b.getActivity())) {
                SKUDetails sKUDetails = this.f23212a;
                if (sKUDetails != null) {
                    this.f23213b.a(sKUDetails);
                    return;
                }
                IABManager iABManager = this.f23213b.F;
                if (iABManager != null) {
                    iABManager.a((DialogInterface.OnClickListener) null);
                    return;
                }
                return;
            }
            IABManager iABManager2 = this.f23213b.F;
            if (iABManager2 != null) {
                iABManager2.a((DialogInterface.OnClickListener) null);
            }
        }
    }
}
