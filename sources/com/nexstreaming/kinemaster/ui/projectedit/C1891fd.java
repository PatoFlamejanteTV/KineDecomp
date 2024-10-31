package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionMaskFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.fd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1891fd extends Bg {
    private static final int[] l = {R.id.mask_by_a, R.id.mask_by_b, R.id.mask_by_c, R.id.mask_by_d};
    private static final int[] m = {R.id.mask_contrib_a, R.id.mask_contrib_b, R.id.mask_contrib_c, R.id.mask_contrib_d};
    private static final int[] n = {R.id.mask_by_a, R.id.mask_by_b, R.id.mask_by_c, R.id.mask_by_d, R.id.mask_contrib_a, R.id.mask_contrib_b, R.id.mask_contrib_c, R.id.mask_contrib_d};
    private SwitchCompat o;
    private View p;
    private NexTimelineItem q;
    private NexTimelineItem.o r;
    private View.OnClickListener s = new ViewOnClickListenerC1873dd(this);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        NexTimelineItem Y = Y();
        if (Y != 0) {
            this.q = Y;
            this.r = (NexTimelineItem.o) Y;
        }
        if (this.r == null || this.q == null || this.p == null) {
            return;
        }
        for (int i : n) {
            View findViewById = this.p.findViewById(i);
            if (findViewById != null) {
                findViewById.setActivated(false);
            }
        }
        View view = null;
        int i2 = C1882ed.f22325a[this.r.getLayerMaskMode().ordinal()];
        if (i2 == 1) {
            view = this.p.findViewById(m[this.r.getLayerMaskIndex()]);
        } else if (i2 == 2) {
            view = this.p.findViewById(l[this.r.getLayerMaskIndex()]);
        }
        if (view != null) {
            view.setActivated(true);
        }
        if (this.r.isLayerMaskEnabled()) {
            this.o.setChecked(true);
            for (int i3 : n) {
                View findViewById2 = this.p.findViewById(i3);
                if (findViewById2 != null) {
                    findViewById2.setEnabled(true);
                    findViewById2.setAlpha(1.0f);
                }
            }
        } else {
            this.o.setChecked(false);
            for (int i4 : n) {
                View findViewById3 = this.p.findViewById(i4);
                if (findViewById3 != null) {
                    findViewById3.setEnabled(false);
                    findViewById3.setAlpha(0.3f);
                }
            }
        }
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.p = layoutInflater.inflate(R.layout.option_layer_mask_fragment, viewGroup, false);
        a(this.p);
        n(R.string.opt_layer_mask);
        f(true);
        this.o = (SwitchCompat) this.p.findViewById(R.id.buttonOnOff);
        this.o.setOnCheckedChangeListener(new C1864cd(this));
        for (int i : n) {
            this.p.findViewById(i).setOnClickListener(this.s);
        }
        na();
        return this.p;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.p = null;
        this.o = null;
        super.onDestroyView();
    }
}
