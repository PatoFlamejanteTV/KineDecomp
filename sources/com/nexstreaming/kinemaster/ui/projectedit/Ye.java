package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes2.dex */
public class Ye extends Bg {
    private ImageButton n;
    private Slider o;
    private Slider p;
    private Slider q;
    private Slider r;
    private Slider s;
    private Slider t;
    private View u;
    private View v;
    private View w;
    private TextView x;
    private SwitchCompat y;
    private NexTimelineItem.e l = null;
    private NexTimelineItem.q m = null;
    private boolean z = false;
    private boolean A = false;

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public boolean ja() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        String musicAssetId;
        com.nexstreaming.app.general.nexasset.assetpackage.r a2;
        com.nexstreaming.app.general.nexasset.assetpackage.p assetSubCategory;
        Slider slider;
        com.nexstreaming.kinemaster.editorwrapper.Fa ca = ca();
        if (ca != null) {
            if (ca instanceof NexTimelineItem.e) {
                this.l = (NexTimelineItem.e) ca;
            }
            if (ca instanceof NexTimelineItem.q) {
                this.m = (NexTimelineItem.q) ca;
            }
            boolean z = false;
            if (ca instanceof NexTimelineItem.b) {
                this.t.setVisibility(0);
                this.x.setVisibility(8);
            }
            MediaInfo mediaInfo = null;
            if (ca instanceof NexVideoClipItem) {
                mediaInfo = MediaInfo.a(((NexVideoClipItem) ca).getMediaPath());
            } else if (ca instanceof NexAudioClipItem) {
                mediaInfo = MediaInfo.a(((NexAudioClipItem) ca).getMediaPath());
            } else if (ca instanceof VideoLayer) {
                mediaInfo = MediaInfo.a(((VideoLayer) ca).getMediaPath());
            }
            if (mediaInfo != null) {
                if (mediaInfo.m() >= 2) {
                    this.v.setVisibility(8);
                    this.w.setVisibility(0);
                    this.z = false;
                } else {
                    this.v.setVisibility(0);
                    this.w.setVisibility(8);
                    this.z = true;
                }
            }
            NexTimelineItem.e eVar = this.l;
            if (eVar != null) {
                ImageButton imageButton = this.n;
                if (imageButton != null) {
                    imageButton.setSelected(eVar.getMuteAudio());
                }
                Slider slider2 = this.o;
                if (slider2 != null) {
                    slider2.setValue(this.l.getClipVolume());
                    if (this.l.getMuteAudio()) {
                        this.n.setImageDrawable(getResources().getDrawable(R.drawable.vol_mute_btn));
                    } else {
                        this.n.setImageDrawable(getResources().getDrawable(R.drawable.vol_sound_btn));
                    }
                }
                SwitchCompat switchCompat = this.y;
                if (switchCompat != null) {
                    switchCompat.setChecked(this.l.isCheckedAudioCompressor());
                }
                if (this.w.getVisibility() == 0) {
                    Slider slider3 = this.q;
                    if (slider3 != null) {
                        slider3.setValue(this.l.getAudioLeftVolume());
                    }
                    Slider slider4 = this.r;
                    if (slider4 != null) {
                        slider4.setValue(this.l.getAudioRightVolume());
                    }
                } else {
                    Slider slider5 = this.s;
                    if (slider5 != null) {
                        slider5.setValue(this.l.getAudioLeftVolume());
                    }
                }
                Slider slider6 = this.t;
                if (slider6 != null) {
                    slider6.setValue(this.l.getAudioPitch());
                }
            }
            if (this.m != null && (slider = this.p) != null) {
                slider.setValue(Math.min(0, r1.getMusicVolume() - 100));
                this.u.setVisibility(0);
            } else if (this.m == null) {
                this.u.setVisibility(8);
            }
            if ((ca instanceof NexAudioClipItem) && (Y() instanceof NexAudioClipItem) && (musicAssetId = ((NexAudioClipItem) Y()).getMusicAssetId()) != null && (a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(musicAssetId.substring(musicAssetId.indexOf(47) + 1))) != null && a2.getAssetPackage() != null && (assetSubCategory = a2.getAssetPackage().getAssetSubCategory()) != null && assetSubCategory.getSubCategoryAlias().equals("Muserk")) {
                this.A = true;
            }
            if (this.A) {
                this.n.setEnabled(false);
                this.n.setImageDrawable(getResources().getDrawable(R.drawable.vol_sound_on_press));
                if (this.l.getMuteAudio()) {
                    this.l.setMuteAudio(false);
                    z = true;
                }
                if (this.l.getClipVolume() <= 15) {
                    this.o.setValue(15.0f);
                    this.l.setClipVolume(15);
                    z = true;
                }
                if (z) {
                    da().c(Y());
                }
            }
        }
        super.na();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_volume_balance_fragment, viewGroup, false);
        inflate.setOnClickListener(new Pe(this));
        a(inflate);
        n(R.string.volume_panel_title);
        f(true);
        this.x = (TextView) inflate.findViewById(R.id.tvPitchMsg);
        this.y = (SwitchCompat) inflate.findViewById(R.id.buttonOnOff);
        this.y.setOnCheckedChangeListener(new Qe(this));
        this.q = (Slider) inflate.findViewById(R.id.stereoLeftSlider);
        this.q.setListener(new Re(this));
        this.r = (Slider) inflate.findViewById(R.id.stereoRightSlider);
        this.r.setListener(new Se(this));
        this.s = (Slider) inflate.findViewById(R.id.monoSlider);
        this.s.setListener(new Te(this));
        this.t = (Slider) inflate.findViewById(R.id.pitchSlider);
        this.t.setListener(new Ue(this));
        this.u = inflate.findViewById(R.id.musicVolumeHolder);
        this.n = (ImageButton) inflate.findViewById(R.id.muteBtn);
        this.n.setOnClickListener(new Ve(this));
        this.o = (Slider) inflate.findViewById(R.id.clipVolumeBar);
        this.o.setListener(new We(this));
        this.p = (Slider) inflate.findViewById(R.id.musicVolumeBar);
        this.p.setListener(new Xe(this));
        this.v = inflate.findViewById(R.id.monoSliderHolder);
        this.w = inflate.findViewById(R.id.stereoSliderHolder);
        na();
        return inflate;
    }
}
