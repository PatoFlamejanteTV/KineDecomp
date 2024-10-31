package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes2.dex */
public class Uh extends Bg implements VideoEditor.g {
    private Vh l;
    private Slider n;
    private NexTimelineItem o;
    private Slider.a m = null;
    private int p = 0;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void va() {
        if (da() == null) {
            return;
        }
        int absStartTime = this.o.getAbsStartTime();
        int absEndTime = this.o.getAbsEndTime();
        da().s().a().getTotalTime();
        for (int i = 0; i < this.l.getVolumeEnvelopeLength(); i++) {
            if (this.l.getVolumeEnvelopeTimeAdj(i) + absStartTime > absEndTime) {
                this.p = i - 1;
                return;
            }
            this.p = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wa() {
        NexTimelineItem nexTimelineItem = this.o;
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            return ((NexPrimaryTimelineItem) nexTimelineItem).getEndOverlap();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xa() {
        NexTimelineItem nexTimelineItem = this.o;
        if (nexTimelineItem instanceof NexVideoClipItem) {
            return ((NexVideoClipItem) nexTimelineItem).getPlaybackSpeed();
        }
        return 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ya() {
        NexTimelineItem nexTimelineItem = this.o;
        if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
            return ((NexPrimaryTimelineItem) nexTimelineItem).getStartOverlap();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int za() {
        NexTimelineItem nexTimelineItem = this.o;
        if (nexTimelineItem instanceof NexVideoClipItem) {
            return ((NexVideoClipItem) nexTimelineItem).getTrimTimeStart();
        }
        if (nexTimelineItem instanceof NexLayerItem) {
            return ((NexLayerItem) nexTimelineItem).getStartTrim();
        }
        if (nexTimelineItem instanceof NexAudioClipItem) {
            return ((NexAudioClipItem) nexTimelineItem).getStartTrim();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        String musicAssetId;
        com.nexstreaming.app.general.nexasset.assetpackage.r a2;
        com.nexstreaming.app.general.nexasset.assetpackage.p assetSubCategory;
        this.t = true;
        if (Y() != null) {
            this.o = Y();
            Fa.a aVar = this.o;
            if (aVar instanceof Vh) {
                this.l = (Vh) aVar;
            }
            Slider.a aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.b();
            }
            if (this.l.getVolumeEnvelopeLevel(0) == -1) {
                int endEnvelopeTime = this.l.getEndEnvelopeTime();
                this.l.addVolumeEnvelope(0, 0, 100);
                this.l.addVolumeEnvelope(1, endEnvelopeTime, 100);
            }
            Slider.a aVar3 = this.m;
            if (aVar3 != null) {
                aVar3.b();
            }
            if ((this.o instanceof NexAudioClipItem) && (Y() instanceof NexAudioClipItem) && (musicAssetId = ((NexAudioClipItem) Y()).getMusicAssetId()) != null && (a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(musicAssetId.substring(musicAssetId.indexOf(47) + 1))) != null && a2.getAssetPackage() != null && (assetSubCategory = a2.getAssetPackage().getAssetSubCategory()) != null && assetSubCategory.getSubCategoryAlias().equals("Muserk")) {
                this.s = true;
            }
            if (this.s) {
                int volumeEnvelopeLength = this.l.getVolumeEnvelopeLength();
                boolean z = false;
                for (int i = 0; i < volumeEnvelopeLength; i++) {
                    if (this.l.getVolumeEnvelopeLevel(i) < 15) {
                        this.l.changeVolumeLevel(i, 15);
                        z = true;
                    }
                }
                if (z) {
                    da().c(Y());
                    Slider.a aVar4 = this.m;
                    if (aVar4 != null) {
                        aVar4.b();
                    }
                }
            }
        }
        super.na();
        this.t = false;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.volume_envelope_fragment, viewGroup, false);
        o(R.id.editmode_volume_adjust);
        a(inflate);
        n(R.string.volume_env_panel_title);
        f(true);
        this.n = (Slider) inflate.findViewById(R.id.volumeEnvelopeBar);
        IconButton iconButton = (IconButton) inflate.findViewById(R.id.addButton);
        IconButton iconButton2 = (IconButton) inflate.findViewById(R.id.removeButton);
        IconButton iconButton3 = (IconButton) inflate.findViewById(R.id.nextButton);
        IconButton iconButton4 = (IconButton) inflate.findViewById(R.id.prevButton);
        Slider slider = this.n;
        if (slider != null) {
            slider.setEnabled(true);
            this.m = new Ph(this, iconButton, iconButton2, iconButton3, iconButton4);
            this.n.setListener(this.m);
        }
        if (iconButton != null) {
            iconButton.setOnClickListener(new Qh(this, iconButton, iconButton2));
        }
        if (iconButton2 != null) {
            iconButton2.setOnClickListener(new Rh(this, iconButton, iconButton2));
        }
        if (iconButton3 != null) {
            iconButton3.setOnClickListener(new Sh(this));
        }
        if (iconButton4 != null) {
            iconButton4.setOnClickListener(new Th(this));
        }
        na();
        va();
        if (da() != null) {
            da().a(this);
        }
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        if (this.t) {
            this.t = false;
            return;
        }
        Slider.a aVar = this.m;
        if (aVar != null) {
            aVar.b();
        }
    }
}
