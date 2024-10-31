package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes2.dex */
class Th implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Uh f22105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Th(Uh uh) {
        this.f22105a = uh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem nexTimelineItem;
        Vh vh;
        NexTimelineItem nexTimelineItem2;
        NexTimelineItem nexTimelineItem3;
        NexTimelineItem nexTimelineItem4;
        int i;
        Vh vh2;
        Vh vh3;
        NexTimelineItem nexTimelineItem5;
        Slider slider;
        Vh vh4;
        Vh vh5;
        Slider slider2;
        NexTimelineItem nexTimelineItem6;
        if (this.f22105a.da() == null) {
            return;
        }
        int v = this.f22105a.da().v();
        nexTimelineItem = this.f22105a.o;
        int absStartTime = nexTimelineItem.getAbsStartTime();
        vh = this.f22105a.l;
        int volumeEnvelopeLength = vh.getVolumeEnvelopeLength();
        Uh uh = this.f22105a;
        nexTimelineItem2 = uh.o;
        float c2 = uh.c(nexTimelineItem2);
        nexTimelineItem3 = this.f22105a.o;
        int representedDuration = nexTimelineItem3.getRepresentedDuration();
        nexTimelineItem4 = this.f22105a.o;
        if (nexTimelineItem4 instanceof NexPrimaryTimelineItem) {
            nexTimelineItem6 = this.f22105a.o;
            i = ((NexPrimaryTimelineItem) nexTimelineItem6).getStartOverlap();
        } else {
            i = 0;
        }
        float f2 = (10.0f / c2) * representedDuration;
        for (int i2 = volumeEnvelopeLength - 1; i2 >= 0; i2--) {
            vh2 = this.f22105a.l;
            int volumeEnvelopeTimeAdj = vh2.getVolumeEnvelopeTimeAdj(i2) + absStartTime;
            if (v > volumeEnvelopeTimeAdj) {
                vh3 = this.f22105a.l;
                if (vh3.getVolumeEnvelopeTimeAdj(i2) - i < 0) {
                    return;
                }
                if (v - volumeEnvelopeTimeAdj < f2) {
                    slider2 = this.f22105a.n;
                    if (slider2.isEnabled()) {
                    }
                }
                nexTimelineItem5 = this.f22105a.o;
                if (nexTimelineItem5 instanceof NexSecondaryTimelineItem) {
                    vh5 = this.f22105a.l;
                    if (vh5.getVolumeEnvelopeTimeAdj(i2) + (f2 / 2.0f) < 0.0f) {
                        return;
                    }
                }
                this.f22105a.b(volumeEnvelopeTimeAdj, false);
                slider = this.f22105a.n;
                vh4 = this.f22105a.l;
                slider.setValue(vh4.getVolumeEnvelopeLevel(i2));
                return;
            }
        }
    }
}
