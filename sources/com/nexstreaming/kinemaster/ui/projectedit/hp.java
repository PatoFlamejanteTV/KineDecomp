package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: OptionVolumeFragment.java */
/* loaded from: classes.dex */
public class hp extends kp {

    /* renamed from: a */
    private NexTimelineItem.d f3960a = null;
    private NexTimelineItem.o b = null;
    private ImageButton c;
    private Slider d;
    private Slider e;
    private View f;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_volume_fragment, viewGroup, false);
        b(inflate);
        f(R.string.volume_panel_title);
        d(true);
        this.f = inflate.findViewById(R.id.musicVolumeHolder);
        this.c = (ImageButton) inflate.findViewById(R.id.muteBtn);
        this.c.setOnClickListener(new hq(this));
        this.d = (Slider) inflate.findViewById(R.id.clipVolumeBar);
        this.d.setListener(new hr(this));
        this.e = (Slider) inflate.findViewById(R.id.musicVolumeBar);
        this.e.setListener(new hs(this));
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if ((m() instanceof NexVideoClipItem) && ((NexVideoClipItem) m()).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if (m() instanceof NexPrimaryTimelineItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if (m() instanceof NexLayerItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        Object m = m();
        if (m != null) {
            if (m instanceof NexTimelineItem.d) {
                this.f3960a = (NexTimelineItem.d) m;
            }
            if (m instanceof NexTimelineItem.o) {
                this.b = (NexTimelineItem.o) m;
            }
            if (this.f3960a != null) {
                if (this.c != null) {
                    this.c.setSelected(this.f3960a.getMuteAudio());
                }
                if (this.d != null) {
                    this.d.setValue(this.f3960a.getClipVolume());
                    if (this.f3960a.getMuteAudio()) {
                        this.c.setImageDrawable(getResources().getDrawable(R.drawable.vol_mute_btn));
                    } else {
                        this.c.setImageDrawable(getResources().getDrawable(R.drawable.vol_sound_btn));
                    }
                }
            }
            if (this.b != null && this.e != null) {
                this.e.setValue(Math.min(0, this.b.getMusicVolume() - 100));
                this.f.setVisibility(0);
            } else if (this.b == null) {
                this.f.setVisibility(8);
            }
        }
        super.f();
    }
}
