package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import com.nexstreaming.app.general.util.IconButton;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes2.dex */
class Rh implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IconButton f22072a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ IconButton f22073b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Uh f22074c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rh(Uh uh, IconButton iconButton, IconButton iconButton2) {
        this.f22074c = uh;
        this.f22072a = iconButton;
        this.f22073b = iconButton2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem nexTimelineItem;
        Vh vh;
        NexTimelineItem nexTimelineItem2;
        NexTimelineItem nexTimelineItem3;
        Vh vh2;
        Vh vh3;
        Vh vh4;
        Vh vh5;
        Vh vh6;
        Vh vh7;
        Slider slider;
        Vh vh8;
        Vh vh9;
        if (this.f22074c.da() == null) {
            return;
        }
        int v = this.f22074c.da().v();
        nexTimelineItem = this.f22074c.o;
        int absStartTime = nexTimelineItem.getAbsStartTime();
        vh = this.f22074c.l;
        int volumeEnvelopeLength = vh.getVolumeEnvelopeLength();
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        for (int i3 = 1; i3 < volumeEnvelopeLength - 1; i3++) {
            vh9 = this.f22074c.l;
            int abs = Math.abs(v - (vh9.getVolumeEnvelopeTimeAdj(i3) + absStartTime));
            if (abs < i) {
                i2 = i3;
                i = abs;
            }
        }
        Uh uh = this.f22074c;
        nexTimelineItem2 = uh.o;
        float c2 = uh.c(nexTimelineItem2);
        nexTimelineItem3 = this.f22074c.o;
        float representedDuration = (10.0f / c2) * nexTimelineItem3.getRepresentedDuration();
        int i4 = 0;
        if (i < representedDuration && i2 > -1) {
            vh8 = this.f22074c.l;
            vh8.removeVolumeEnvelope(i2);
            this.f22074c.G();
            this.f22072a.setEnabled(true);
            this.f22073b.setEnabled(false);
        }
        vh2 = this.f22074c.l;
        int volumeEnvelopeLength2 = vh2.getVolumeEnvelopeLength();
        while (true) {
            if (i4 >= volumeEnvelopeLength2 - 1) {
                break;
            }
            vh3 = this.f22074c.l;
            int volumeEnvelopeTimeAdj = vh3.getVolumeEnvelopeTimeAdj(i4);
            vh4 = this.f22074c.l;
            int i5 = i4 + 1;
            int volumeEnvelopeTimeAdj2 = vh4.getVolumeEnvelopeTimeAdj(i5);
            int i6 = v - absStartTime;
            if (volumeEnvelopeTimeAdj < i6 && i6 < volumeEnvelopeTimeAdj2) {
                vh5 = this.f22074c.l;
                int volumeEnvelopeLevel = vh5.getVolumeEnvelopeLevel(i5);
                vh6 = this.f22074c.l;
                float volumeEnvelopeLevel2 = ((i6 - volumeEnvelopeTimeAdj) / (volumeEnvelopeTimeAdj2 - volumeEnvelopeTimeAdj)) * (volumeEnvelopeLevel - vh6.getVolumeEnvelopeLevel(i4));
                vh7 = this.f22074c.l;
                int round = Math.round(volumeEnvelopeLevel2 + vh7.getVolumeEnvelopeLevel(i4));
                slider = this.f22074c.n;
                slider.setValue(round);
                break;
            }
            i4 = i5;
        }
        this.f22074c.ha();
    }
}
