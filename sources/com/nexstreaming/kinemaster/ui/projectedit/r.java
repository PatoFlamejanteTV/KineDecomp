package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: AlphaAdjustmentFragment.java */
/* loaded from: classes2.dex */
public class r extends Bg {
    private NexTimelineItem.a l;
    private Slider m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        com.nexstreaming.kinemaster.editorwrapper.Fa ca = ca();
        if (ca instanceof NexTimelineItem.a) {
            this.l = (NexTimelineItem.a) ca;
            this.m.setValue((this.l.getAlpha() * 100) / 255);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.alpha_adjustment_fragment, viewGroup, false);
        a(inflate);
        n(R.string.alphaadj_panel_title);
        f(true);
        this.m = (Slider) inflate.findViewById(R.id.alphaBar);
        this.m.setListener(new C1985q(this));
        na();
        return inflate;
    }
}
