package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionStrengthAndVariationFragment.java */
/* loaded from: classes2.dex */
public class Me extends Bg {
    private NexTimelineItem.m l;
    private NexTimelineItem.n m;
    private Slider n;
    private Slider o;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        Fa.a Y = Y();
        if (Y != null) {
            if (Y instanceof NexTimelineItem.m) {
                this.l = (NexTimelineItem.m) Y;
            }
            if (Y instanceof NexTimelineItem.n) {
                this.m = (NexTimelineItem.n) Y;
            }
            this.n.setValue(this.l.getStrengthValue() * 100.0f);
            this.o.setValue(this.m.getVariationhValue() * 100.0f);
        }
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_strength_variation_fragment, viewGroup, false);
        a(inflate);
        n(R.string.opt_strength_and_variation);
        f(true);
        this.n = (Slider) inflate.findViewById(R.id.strengthSlider);
        this.n.setListener(new Ke(this));
        this.o = (Slider) inflate.findViewById(R.id.variationSlider);
        this.o.setListener(new Le(this));
        na();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
    }
}
