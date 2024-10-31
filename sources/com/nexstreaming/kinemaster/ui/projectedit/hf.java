package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes.dex */
public class hf extends kp {
    private ImageButton c;
    private Slider d;
    private Slider e;
    private Slider f;
    private Slider g;
    private Slider h;
    private Slider i;
    private View j;
    private View k;
    private View l;
    private TextView m;
    private SwitchCompat n;

    /* renamed from: a, reason: collision with root package name */
    private NexTimelineItem.d f3950a = null;
    private NexTimelineItem.o b = null;
    private boolean o = false;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_volume_balance_fragment, viewGroup, false);
        inflate.setOnClickListener(new hg(this));
        b(inflate);
        f(R.string.volume_panel_title);
        d(true);
        this.m = (TextView) inflate.findViewById(R.id.tvPitchMsg);
        this.n = (SwitchCompat) inflate.findViewById(R.id.buttonOnOff);
        this.n.setOnCheckedChangeListener(new hh(this));
        this.f = (Slider) inflate.findViewById(R.id.stereoLeftSlider);
        this.f.setListener(new hi(this));
        this.g = (Slider) inflate.findViewById(R.id.stereoRightSlider);
        this.g.setListener(new hj(this));
        this.h = (Slider) inflate.findViewById(R.id.monoSlider);
        this.h.setListener(new hk(this));
        this.i = (Slider) inflate.findViewById(R.id.pitchSlider);
        this.i.setListener(new hl(this));
        this.j = inflate.findViewById(R.id.musicVolumeHolder);
        this.c = (ImageButton) inflate.findViewById(R.id.muteBtn);
        this.c.setOnClickListener(new hm(this));
        this.d = (Slider) inflate.findViewById(R.id.clipVolumeBar);
        this.d.setListener(new hn(this));
        this.e = (Slider) inflate.findViewById(R.id.musicVolumeBar);
        this.e.setListener(new ho(this));
        this.k = inflate.findViewById(R.id.monoSliderHolder);
        this.l = inflate.findViewById(R.id.stereoSliderHolder);
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public boolean k_() {
        return true;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        Object m = m();
        if (m != null) {
            if (m instanceof NexTimelineItem.d) {
                this.f3950a = (NexTimelineItem.d) m;
            }
            if (m instanceof NexTimelineItem.o) {
                this.b = (NexTimelineItem.o) m;
            }
            if (m instanceof NexTimelineItem.b) {
                if (((NexTimelineItem.b) m).getAudioEffect() != 0) {
                    this.i.setVisibility(8);
                    this.m.setVisibility(0);
                } else {
                    this.i.setVisibility(0);
                    this.m.setVisibility(8);
                }
            }
            MediaInfo mediaInfo = null;
            if (m instanceof NexVideoClipItem) {
                mediaInfo = MediaInfo.a(((NexVideoClipItem) m).getMediaPath());
            } else if (m instanceof NexAudioClipItem) {
                mediaInfo = MediaInfo.a(((NexAudioClipItem) m).getMediaPath());
            } else if (m instanceof VideoLayer) {
                mediaInfo = MediaInfo.a(((VideoLayer) m).getMediaPath());
            }
            if (mediaInfo != null) {
                if (mediaInfo.I() >= 2) {
                    this.k.setVisibility(8);
                    this.l.setVisibility(0);
                    this.o = false;
                } else {
                    this.k.setVisibility(0);
                    this.l.setVisibility(8);
                    this.o = true;
                }
            }
            if (this.f3950a != null) {
                if (this.c != null) {
                    this.c.setSelected(this.f3950a.getMuteAudio());
                }
                if (this.d != null) {
                    this.d.setValue(this.f3950a.getClipVolume());
                    if (this.f3950a.getMuteAudio()) {
                        this.c.setImageDrawable(getResources().getDrawable(R.drawable.vol_mute_btn));
                    } else {
                        this.c.setImageDrawable(getResources().getDrawable(R.drawable.vol_sound_btn));
                    }
                }
                if (this.n != null) {
                    this.n.setChecked(this.f3950a.isCheckedAudioCompressor());
                }
                if (this.l.getVisibility() == 0) {
                    if (this.f != null) {
                        this.f.setValue(this.f3950a.getAudioLeftVolume());
                    }
                    if (this.g != null) {
                        this.g.setValue(this.f3950a.getAudioRightVolume());
                    }
                } else if (this.h != null) {
                    this.h.setValue(this.f3950a.getAudioLeftVolume());
                }
                if (this.i != null) {
                    this.i.setValue(this.f3950a.getAudioPitch());
                }
            }
            if (this.b != null && this.e != null) {
                this.e.setValue(Math.min(0, this.b.getMusicVolume() - 100));
                this.j.setVisibility(0);
            } else if (this.b == null) {
                this.j.setVisibility(8);
            }
        }
        super.f();
    }
}
