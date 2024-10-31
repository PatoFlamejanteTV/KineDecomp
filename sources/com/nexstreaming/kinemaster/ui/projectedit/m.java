package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: ColorAdjustmentFragment.java */
/* loaded from: classes.dex */
public class m extends kp {

    /* renamed from: a */
    private NexTimelineItem.e f4081a;
    private NexTimelineItem.f b;
    private Slider c;
    private Slider d;
    private Slider e;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.color_adjustment_fragment, viewGroup, false);
        b(inflate);
        f(R.string.coloradj_panel_title);
        d(true);
        this.c = (Slider) inflate.findViewById(R.id.brightnessBar);
        this.c.setListener(new n(this));
        this.d = (Slider) inflate.findViewById(R.id.contrastBar);
        this.d.setListener(new o(this));
        this.e = (Slider) inflate.findViewById(R.id.saturationBar);
        this.e.setListener(new p(this));
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        NexTimelineItem m = m();
        if (m != null && (m instanceof NexLayerItem)) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if ((m instanceof NexVideoClipItem) && ((NexVideoClipItem) m).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    public boolean c() {
        return (this.f4081a == null || this.b == null) ? false : true;
    }

    public boolean e() {
        return m() != null && (m() instanceof NexLayerItem);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        Object m = m();
        if (m != null) {
            if (m instanceof NexTimelineItem.e) {
                this.f4081a = (NexTimelineItem.e) m;
            }
            if (m instanceof NexTimelineItem.f) {
                this.b = (NexTimelineItem.f) m;
            }
            this.e.setValue(this.f4081a.getSaturation());
            this.d.setValue(this.f4081a.getContrast());
            this.c.setValue(this.f4081a.getBrightness());
        }
    }
}
