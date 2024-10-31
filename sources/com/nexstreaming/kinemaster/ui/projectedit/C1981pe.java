package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.HashMap;

/* compiled from: OptionPanelShortTransition.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.pe, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1981pe extends Bg {
    private HashMap l;

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.option_panel_short_transition, viewGroup, false);
        kotlin.jvm.internal.h.a((Object) inflate, "view");
        a(inflate);
        n(R.string.transition_effect_panel_title);
        na();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        z();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void z() {
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
