package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ColorAdjustmentFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.fa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1888fa extends Bg {
    private NexTimelineItem.f l;
    private NexTimelineItem.g m;
    private Slider n;
    private Slider o;
    private Slider p;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va() {
        return (this.l == null || this.m == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wa() {
        return Y() != null && (Y() instanceof NexLayerItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        Fa.a Y = Y();
        if (Y != null) {
            if (Y instanceof NexTimelineItem.f) {
                this.l = (NexTimelineItem.f) Y;
            }
            if (Y instanceof NexTimelineItem.g) {
                this.m = (NexTimelineItem.g) Y;
            }
            this.p.setValue(this.l.getSaturation());
            this.o.setValue(this.l.getContrast());
            this.n.setValue(this.l.getBrightness());
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.color_adjustment_fragment, viewGroup, false);
        a(inflate);
        n(R.string.coloradj_panel_title);
        f(true);
        this.n = (Slider) inflate.findViewById(R.id.brightnessBar);
        this.n.setListener(new C1861ca(this));
        this.o = (Slider) inflate.findViewById(R.id.contrastBar);
        this.o.setListener(new C1870da(this));
        this.p = (Slider) inflate.findViewById(R.id.saturationBar);
        this.p.setListener(new C1879ea(this));
        na();
        return inflate;
    }
}
