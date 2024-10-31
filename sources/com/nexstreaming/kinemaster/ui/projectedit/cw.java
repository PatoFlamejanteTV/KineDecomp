package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes.dex */
class cw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ cr f3830a;

    public cw(cr crVar) {
        this.f3830a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        kp.b(this.f3830a.getFragmentManager().beginTransaction()).replace(R.id.optionPanelHolder, new db().a(this.f3830a.m())).addToBackStack("timeline_item").commit();
    }
}
