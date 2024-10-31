package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes2.dex */
class Sh implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Uh f22085a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sh(Uh uh) {
        this.f22085a = uh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem nexTimelineItem;
        NexTimelineItem nexTimelineItem2;
        Vh vh;
        NexTimelineItem nexTimelineItem3;
        NexTimelineItem nexTimelineItem4;
        int ya;
        Vh vh2;
        Slider slider;
        Vh vh3;
        Slider slider2;
        if (this.f22085a.da() == null) {
            return;
        }
        int v = this.f22085a.da().v();
        nexTimelineItem = this.f22085a.o;
        int absStartTime = nexTimelineItem.getAbsStartTime();
        nexTimelineItem2 = this.f22085a.o;
        int absEndTime = nexTimelineItem2.getAbsEndTime();
        vh = this.f22085a.l;
        int volumeEnvelopeLength = vh.getVolumeEnvelopeLength();
        Uh uh = this.f22085a;
        nexTimelineItem3 = uh.o;
        float c2 = uh.c(nexTimelineItem3);
        nexTimelineItem4 = this.f22085a.o;
        int representedDuration = nexTimelineItem4.getRepresentedDuration();
        float f2 = 10.0f / c2;
        float f3 = representedDuration;
        float f4 = f2 * f3;
        ya = this.f22085a.ya();
        for (int i = 0; i < volumeEnvelopeLength; i++) {
            vh2 = this.f22085a.l;
            int volumeEnvelopeTimeAdj = vh2.getVolumeEnvelopeTimeAdj(i) + absStartTime;
            if (v < volumeEnvelopeTimeAdj) {
                int i2 = volumeEnvelopeTimeAdj - absStartTime;
                if (i2 - f4 <= f3 && i2 <= representedDuration + ya) {
                    if (volumeEnvelopeTimeAdj - v < f4) {
                        slider2 = this.f22085a.n;
                        if (slider2.isEnabled()) {
                        }
                    }
                    this.f22085a.b(Math.min(volumeEnvelopeTimeAdj, absEndTime - 1), false);
                    slider = this.f22085a.n;
                    vh3 = this.f22085a.l;
                    slider.setValue(vh3.getVolumeEnvelopeLevel(i));
                    return;
                }
                return;
            }
        }
    }
}
