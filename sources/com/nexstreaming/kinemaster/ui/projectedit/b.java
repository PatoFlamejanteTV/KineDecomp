package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: AlphaAdjustmentFragment.java */
/* loaded from: classes.dex */
public class b extends kp {

    /* renamed from: a */
    private NexTimelineItem.a f3780a;
    private Slider b;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.alpha_adjustment_fragment, viewGroup, false);
        b(inflate);
        f(R.string.alphaadj_panel_title);
        d(true);
        this.b = (Slider) inflate.findViewById(R.id.alphaBar);
        this.b.setListener(new c(this));
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        NexTimelineItem m = m();
        if (m != null && (m instanceof TextLayer)) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
        } else if (m != null && (m instanceof NexLayerItem)) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        Object m = m();
        if (m != null) {
            if (m instanceof NexTimelineItem.a) {
                this.f3780a = (NexTimelineItem.a) m;
            }
            this.b.setValue((this.f3780a.getAlpha() * 100) / 255);
        }
    }
}
