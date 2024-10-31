package com.nexstreaming.kinemaster.ui.b;

import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: EffectSettingsFragment.java */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ f f3695a;

    public h(f fVar) {
        this.f3695a = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f.a(this.f3695a.getFragmentManager().beginTransaction()).replace(R.id.optionPanelHolder, new o().a(this.f3695a.m())).addToBackStack("").commit();
    }
}
