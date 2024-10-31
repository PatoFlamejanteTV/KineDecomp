package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: OptionRotateFragment.java */
/* loaded from: classes.dex */
public class gj extends kp {

    /* renamed from: a */
    NexTimelineItem.q f3927a;
    private boolean b = false;
    private boolean c = false;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pedit_option_rotate_fragment, viewGroup, false);
        b(inflate);
        f(R.string.ro_panel_title);
        d(true);
        IconButton iconButton = (IconButton) inflate.findViewById(R.id.mirrorHBtn);
        IconButton iconButton2 = (IconButton) inflate.findViewById(R.id.mirrorVBtn);
        IconButton iconButton3 = (IconButton) inflate.findViewById(R.id.rotateCCWBtn);
        IconButton iconButton4 = (IconButton) inflate.findViewById(R.id.rotateCWBtn);
        iconButton.setOnClickListener(new gk(this));
        iconButton2.setOnClickListener(new gl(this));
        iconButton3.setOnClickListener(new gm(this));
        iconButton4.setOnClickListener(new gn(this));
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
        } else if (m != null && (m instanceof NexVideoClipItem) && ((NexVideoClipItem) m).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        Object m = m();
        if (m != null && (m instanceof NexTimelineItem.q)) {
            this.f3927a = (NexTimelineItem.q) m;
            if (m instanceof NexLayerItem) {
                this.b = true;
            }
            if (((m instanceof VideoLayer) && ((VideoLayer) m).isSplitScreenEnabled()) || ((m instanceof ImageLayer) && ((ImageLayer) m).isSplitScreenEnabled())) {
                this.c = true;
            }
        }
        super.f();
    }
}
