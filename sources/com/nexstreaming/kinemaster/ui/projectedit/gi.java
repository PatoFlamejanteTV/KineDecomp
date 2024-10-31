package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: OptionPanelShortTransition.java */
/* loaded from: classes.dex */
public class gi extends kp {

    /* renamed from: a, reason: collision with root package name */
    private View f3926a;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3926a = layoutInflater.inflate(R.layout.option_panel_short_transition, viewGroup, false);
        b(this.f3926a);
        f(R.string.transition_effect_panel_title);
        f();
        return this.f3926a;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f3926a = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        a(R.id.action_undo, 0, R.id.action_redo, 0);
        super.onActivityCreated(bundle);
    }
}
