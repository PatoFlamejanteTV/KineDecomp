package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionRotateFragmentForHW.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.xe, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2074xe extends Bg {
    NexTimelineItem.s l;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        Fa.a Y = Y();
        if (Y != null && (Y instanceof NexTimelineItem.s) && (Y instanceof HandwritingLayer)) {
            this.l = (NexTimelineItem.s) Y;
        }
        super.na();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pedit_option_rotate_frag_for_hw, viewGroup, false);
        a(inflate);
        n(R.string.ro_panel_rotate);
        f(true);
        IconButton iconButton = (IconButton) inflate.findViewById(R.id.rotateCCWBtn);
        IconButton iconButton2 = (IconButton) inflate.findViewById(R.id.rotateCWBtn);
        iconButton.setOnClickListener(new ViewOnClickListenerC2057ve(this));
        iconButton2.setOnClickListener(new ViewOnClickListenerC2066we(this));
        na();
        return inflate;
    }
}
