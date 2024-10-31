package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: OptionPanelMissingMedia.java */
/* loaded from: classes.dex */
public class gh extends kp {

    /* renamed from: a, reason: collision with root package name */
    private View f3925a;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3925a = layoutInflater.inflate(R.layout.option_panel_missing_media, viewGroup, false);
        b(this.f3925a);
        b(m().getDescriptiveTitle(getActivity()));
        f();
        return this.f3925a;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f3925a = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete);
        super.onActivityCreated(bundle);
    }
}
