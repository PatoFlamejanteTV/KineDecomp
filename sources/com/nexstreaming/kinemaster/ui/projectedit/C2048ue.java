package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionRotateFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ue, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2048ue extends Bg {
    NexTimelineItem.s l;
    private boolean m = false;
    private boolean n = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        Fa.a Y = Y();
        if (Y != null && (Y instanceof NexTimelineItem.s)) {
            this.l = (NexTimelineItem.s) Y;
            if (Y instanceof NexLayerItem) {
                this.m = true;
            }
            if (((Y instanceof VideoLayer) && ((VideoLayer) Y).isSplitScreenEnabled()) || ((Y instanceof ImageLayer) && ((ImageLayer) Y).isSplitScreenEnabled())) {
                this.n = true;
            }
        }
        super.na();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pedit_option_rotate_fragment, viewGroup, false);
        a(inflate);
        n(R.string.ro_panel_title);
        f(true);
        IconButton iconButton = (IconButton) inflate.findViewById(R.id.mirrorHBtn);
        IconButton iconButton2 = (IconButton) inflate.findViewById(R.id.mirrorVBtn);
        IconButton iconButton3 = (IconButton) inflate.findViewById(R.id.rotateCCWBtn);
        IconButton iconButton4 = (IconButton) inflate.findViewById(R.id.rotateCWBtn);
        iconButton.setOnClickListener(new ViewOnClickListenerC1990qe(this));
        iconButton2.setOnClickListener(new ViewOnClickListenerC1998re(this));
        iconButton3.setOnClickListener(new ViewOnClickListenerC2007se(this));
        iconButton4.setOnClickListener(new ViewOnClickListenerC2016te(this));
        na();
        return inflate;
    }
}
