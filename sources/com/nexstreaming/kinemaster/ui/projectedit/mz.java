package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes.dex */
class mz implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mv f4107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mz(mv mvVar) {
        this.f4107a = mvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem nexTimelineItem;
        NexTimelineItem nexTimelineItem2;
        nb nbVar;
        NexTimelineItem nexTimelineItem3;
        NexTimelineItem nexTimelineItem4;
        int c;
        nb nbVar2;
        Slider slider;
        nb nbVar3;
        Slider slider2;
        if (this.f4107a.o() != null) {
            int u = this.f4107a.o().u();
            nexTimelineItem = this.f4107a.d;
            int absStartTime = nexTimelineItem.getAbsStartTime();
            nexTimelineItem2 = this.f4107a.d;
            int absEndTime = nexTimelineItem2.getAbsEndTime();
            nbVar = this.f4107a.f4103a;
            int volumeEnvelopeLength = nbVar.getVolumeEnvelopeLength();
            mv mvVar = this.f4107a;
            nexTimelineItem3 = this.f4107a.d;
            float e = mvVar.e(nexTimelineItem3);
            nexTimelineItem4 = this.f4107a.d;
            int representedDuration = nexTimelineItem4.getRepresentedDuration();
            float f = representedDuration * (14.0f / e);
            c = this.f4107a.c();
            for (int i = 0; i < volumeEnvelopeLength; i++) {
                nbVar2 = this.f4107a.f4103a;
                int volumeEnvelopeTimeAdj = nbVar2.getVolumeEnvelopeTimeAdj(i) + absStartTime;
                if (u < volumeEnvelopeTimeAdj) {
                    if ((volumeEnvelopeTimeAdj - absStartTime) - f > representedDuration || volumeEnvelopeTimeAdj - absStartTime > representedDuration + c) {
                        break;
                    }
                    if (volumeEnvelopeTimeAdj - u < f) {
                        slider2 = this.f4107a.c;
                        if (slider2.isEnabled()) {
                        }
                    }
                    this.f4107a.e(Math.min(volumeEnvelopeTimeAdj, absEndTime - 1), false);
                    slider = this.f4107a.c;
                    nbVar3 = this.f4107a.f4103a;
                    slider.setValue(nbVar3.getVolumeEnvelopeLevel(i));
                    break;
                }
            }
            KMAppUsage.a(this.f4107a.getActivity()).a(KMAppUsage.KMMetric.VidVolumeEnvelopeNextPoint);
        }
    }
}
