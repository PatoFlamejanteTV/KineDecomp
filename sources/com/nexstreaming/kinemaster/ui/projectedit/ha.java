package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionStrengthAndVariationFragment.java */
/* loaded from: classes.dex */
public class ha extends kp {

    /* renamed from: a */
    private NexTimelineItem.k f3945a;
    private NexTimelineItem.l b;
    private Slider c;
    private Slider d;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_strength_variation_fragment, viewGroup, false);
        b(inflate);
        f(R.string.opt_strength_and_variation);
        d(true);
        this.c = (Slider) inflate.findViewById(R.id.strengthSlider);
        this.c.setListener(new hb(this));
        this.d = (Slider) inflate.findViewById(R.id.variationSlider);
        this.d.setListener(new hc(this));
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        Object m = m();
        if (m != null) {
            if (m instanceof NexTimelineItem.k) {
                this.f3945a = (NexTimelineItem.k) m;
            }
            if (m instanceof NexTimelineItem.l) {
                this.b = (NexTimelineItem.l) m;
            }
            this.c.setValue(this.f3945a.getStrengthValue() * 100.0f);
            this.d.setValue(this.b.getVariationhValue() * 100.0f);
        }
        super.f();
    }
}
