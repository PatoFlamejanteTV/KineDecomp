package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.bf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1857bf extends Bg {
    private NexTimelineItem.e l = null;
    private NexTimelineItem.q m = null;
    private ImageButton n;
    private Slider o;
    private Slider p;
    private View q;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        Slider slider;
        Fa.a Y = Y();
        if (Y != null) {
            if (Y instanceof NexTimelineItem.e) {
                this.l = (NexTimelineItem.e) Y;
            }
            if (Y instanceof NexTimelineItem.q) {
                this.m = (NexTimelineItem.q) Y;
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
            }
            if (this.m != null && (slider = this.p) != null) {
                slider.setValue(Math.min(0, r0.getMusicVolume() - 100));
                this.q.setVisibility(0);
            } else if (this.m == null) {
                this.q.setVisibility(8);
            }
        }
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_volume_fragment, viewGroup, false);
        a(inflate);
        n(R.string.volume_panel_title);
        f(true);
        this.q = inflate.findViewById(R.id.musicVolumeHolder);
        this.n = (ImageButton) inflate.findViewById(R.id.muteBtn);
        this.n.setOnClickListener(new Ze(this));
        this.o = (Slider) inflate.findViewById(R.id.clipVolumeBar);
        this.o.setListener(new _e(this));
        this.p = (Slider) inflate.findViewById(R.id.musicVolumeBar);
        this.p.setListener(new C1848af(this));
        na();
        return inflate;
    }
}
