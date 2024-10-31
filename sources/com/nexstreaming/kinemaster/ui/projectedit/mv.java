package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes.dex */
public class mv extends kp implements VideoEditor.g {

    /* renamed from: a */
    private nb f4103a;
    private Slider c;
    private NexTimelineItem d;
    private Slider.a b = null;
    private int e = 0;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.volume_envelope_fragment, viewGroup, false);
        g(R.id.editmode_volume_adjust);
        b(inflate);
        f(R.string.volume_env_panel_title);
        d(true);
        this.c = (Slider) inflate.findViewById(R.id.volumeEnvelopeBar);
        IconButton iconButton = (IconButton) inflate.findViewById(R.id.addButton);
        IconButton iconButton2 = (IconButton) inflate.findViewById(R.id.removeButton);
        IconButton iconButton3 = (IconButton) inflate.findViewById(R.id.nextButton);
        IconButton iconButton4 = (IconButton) inflate.findViewById(R.id.prevButton);
        if (this.c != null) {
            this.c.setEnabled(true);
            this.b = new mw(this, iconButton, iconButton2, iconButton3, iconButton4);
            this.c.setListener(this.b);
        }
        if (iconButton != null) {
            iconButton.setOnClickListener(new mx(this, iconButton, iconButton2));
        }
        if (iconButton2 != null) {
            iconButton2.setOnClickListener(new my(this, iconButton, iconButton2));
        }
        if (iconButton3 != null) {
            iconButton3.setOnClickListener(new mz(this));
        }
        if (iconButton4 != null) {
            iconButton4.setOnClickListener(new na(this));
        }
        f();
        j();
        if (o() != null) {
            o().a(this);
        }
        return inflate;
    }

    public int c() {
        if (this.d instanceof NexPrimaryTimelineItem) {
            return ((NexPrimaryTimelineItem) this.d).getStartOverlap();
        }
        return 0;
    }

    public int e() {
        if (this.d instanceof NexPrimaryTimelineItem) {
            return ((NexPrimaryTimelineItem) this.d).getEndOverlap();
        }
        return 0;
    }

    public int h() {
        if (this.d instanceof NexVideoClipItem) {
            return ((NexVideoClipItem) this.d).getTrimTimeStart();
        }
        if (this.d instanceof NexLayerItem) {
            return ((NexLayerItem) this.d).getStartTrim();
        }
        if (this.d instanceof NexAudioClipItem) {
            return ((NexAudioClipItem) this.d).getStartTrim();
        }
        return 0;
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

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        if (this.h) {
            this.h = false;
        } else if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        this.h = true;
        if (m() != null) {
            this.d = m();
            if (this.d instanceof nb) {
                this.f4103a = (nb) this.d;
            }
            if (this.b != null) {
                this.b.a();
            }
            if (this.f4103a.getVolumeEnvelopeLevel(0) == -1) {
                int endEnvelopeTime = this.f4103a.getEndEnvelopeTime();
                this.f4103a.addVolumeEnvelope(0, 0, 100);
                this.f4103a.addVolumeEnvelope(1, endEnvelopeTime, 100);
            }
            if (this.b != null) {
                this.b.a();
            }
        }
        super.f();
        this.h = false;
    }

    public int i() {
        if (this.d instanceof NexVideoClipItem) {
            return ((NexVideoClipItem) this.d).getPlaybackSpeed();
        }
        return 100;
    }

    public void j() {
        if (o() != null) {
            int absStartTime = this.d.getAbsStartTime();
            int absEndTime = this.d.getAbsEndTime();
            o().f().a().getTotalTime();
            for (int i = 0; i < this.f4103a.getVolumeEnvelopeLength(); i++) {
                if (this.f4103a.getVolumeEnvelopeTimeAdj(i) + absStartTime > absEndTime) {
                    this.e = i - 1;
                    return;
                }
                this.e = i;
            }
        }
    }
}
