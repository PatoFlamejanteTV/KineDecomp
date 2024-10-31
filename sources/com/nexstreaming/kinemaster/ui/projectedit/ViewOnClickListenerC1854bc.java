package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: OptionChromaKeyFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.bc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class ViewOnClickListenerC1854bc implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1899gc f22274a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1854bc(C1899gc c1899gc) {
        this.f22274a = c1899gc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentTransaction a2 = Bg.f21786a.a(this.f22274a.getFragmentManager().beginTransaction());
        C1908hc c1908hc = new C1908hc();
        c1908hc.a((C1908hc) this.f22274a.Y());
        a2.replace(R.id.optionPanelHolder, c1908hc).addToBackStack("timeline_item").commit();
    }
}
