package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionMaskFragment.java */
/* loaded from: classes.dex */
public class em extends kp {
    private static final int[] e = {R.id.mask_by_a, R.id.mask_by_b, R.id.mask_by_c, R.id.mask_by_d};
    private static final int[] f = {R.id.mask_contrib_a, R.id.mask_contrib_b, R.id.mask_contrib_c, R.id.mask_contrib_d};
    private static final int[] g = {R.id.mask_by_a, R.id.mask_by_b, R.id.mask_by_c, R.id.mask_by_d, R.id.mask_contrib_a, R.id.mask_contrib_b, R.id.mask_contrib_c, R.id.mask_contrib_d};

    /* renamed from: a */
    private SwitchCompat f3873a;
    private View b;
    private NexTimelineItem c;
    private NexTimelineItem.m d;
    private View.OnClickListener h = new eo(this);

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.option_layer_mask_fragment, viewGroup, false);
        b(this.b);
        f(R.string.opt_layer_mask);
        d(true);
        this.f3873a = (SwitchCompat) this.b.findViewById(R.id.buttonOnOff);
        this.f3873a.setOnCheckedChangeListener(new en(this));
        for (int i : g) {
            this.b.findViewById(i).setOnClickListener(this.h);
        }
        f();
        return this.b;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (m() instanceof NexPrimaryTimelineItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        NexTimelineItem m = m();
        if (m != 0) {
            this.c = m;
            this.d = (NexTimelineItem.m) m;
        }
        if (this.d != null && this.c != null && this.b != null) {
            for (int i : g) {
                View findViewById = this.b.findViewById(i);
                if (findViewById != null) {
                    findViewById.setActivated(false);
                }
            }
            View view = null;
            switch (this.d.getLayerMaskMode()) {
                case Contributes:
                    view = this.b.findViewById(f[this.d.getLayerMaskIndex()]);
                    break;
                case MaskedBy:
                    view = this.b.findViewById(e[this.d.getLayerMaskIndex()]);
                    break;
            }
            if (view != null) {
                view.setActivated(true);
            }
            if (this.d.isLayerMaskEnabled()) {
                this.f3873a.setChecked(true);
                for (int i2 : g) {
                    View findViewById2 = this.b.findViewById(i2);
                    if (findViewById2 != null) {
                        findViewById2.setEnabled(true);
                        findViewById2.setAlpha(1.0f);
                    }
                }
            } else {
                this.f3873a.setChecked(false);
                for (int i3 : g) {
                    View findViewById3 = this.b.findViewById(i3);
                    if (findViewById3 != null) {
                        findViewById3.setEnabled(false);
                        findViewById3.setAlpha(0.3f);
                    }
                }
            }
            super.f();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.b = null;
        this.f3873a = null;
        super.onDestroyView();
    }
}
