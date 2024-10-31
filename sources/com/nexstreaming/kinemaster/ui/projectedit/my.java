package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes.dex */
class my implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IconButton f4106a;
    final /* synthetic */ IconButton b;
    final /* synthetic */ mv c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public my(mv mvVar, IconButton iconButton, IconButton iconButton2) {
        this.c = mvVar;
        this.f4106a = iconButton;
        this.b = iconButton2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem nexTimelineItem;
        nb nbVar;
        NexTimelineItem nexTimelineItem2;
        NexTimelineItem nexTimelineItem3;
        nb nbVar2;
        nb nbVar3;
        nb nbVar4;
        nb nbVar5;
        nb nbVar6;
        nb nbVar7;
        Slider slider;
        nb nbVar8;
        nb nbVar9;
        int i;
        if (this.c.o() != null) {
            int u = this.c.o().u();
            nexTimelineItem = this.c.d;
            int absStartTime = nexTimelineItem.getAbsStartTime();
            nbVar = this.c.f4103a;
            int volumeEnvelopeLength = nbVar.getVolumeEnvelopeLength();
            int i2 = Integer.MAX_VALUE;
            int i3 = 1;
            int i4 = -1;
            while (i3 < volumeEnvelopeLength - 1) {
                nbVar9 = this.c.f4103a;
                int abs = Math.abs(u - (nbVar9.getVolumeEnvelopeTimeAdj(i3) + absStartTime));
                if (abs < i2) {
                    i = i3;
                } else {
                    abs = i2;
                    i = i4;
                }
                i3++;
                i4 = i;
                i2 = abs;
            }
            mv mvVar = this.c;
            nexTimelineItem2 = this.c.d;
            float e = mvVar.e(nexTimelineItem2);
            nexTimelineItem3 = this.c.d;
            if (i2 < (14.0f / e) * nexTimelineItem3.getRepresentedDuration() && i4 > -1) {
                nbVar8 = this.c.f4103a;
                nbVar8.removeVolumeEnvelope(i4);
                this.c.d();
                this.f4106a.setEnabled(true);
                this.b.setEnabled(false);
            }
            nbVar2 = this.c.f4103a;
            int volumeEnvelopeLength2 = nbVar2.getVolumeEnvelopeLength();
            int i5 = 0;
            while (true) {
                if (i5 >= volumeEnvelopeLength2 - 1) {
                    break;
                }
                nbVar3 = this.c.f4103a;
                int volumeEnvelopeTimeAdj = nbVar3.getVolumeEnvelopeTimeAdj(i5);
                nbVar4 = this.c.f4103a;
                int volumeEnvelopeTimeAdj2 = nbVar4.getVolumeEnvelopeTimeAdj(i5 + 1);
                int i6 = u - absStartTime;
                if (volumeEnvelopeTimeAdj >= i6 || i6 >= volumeEnvelopeTimeAdj2) {
                    i5++;
                } else {
                    float f = (i6 - volumeEnvelopeTimeAdj) / (volumeEnvelopeTimeAdj2 - volumeEnvelopeTimeAdj);
                    nbVar5 = this.c.f4103a;
                    int volumeEnvelopeLevel = nbVar5.getVolumeEnvelopeLevel(i5 + 1);
                    nbVar6 = this.c.f4103a;
                    float volumeEnvelopeLevel2 = f * (volumeEnvelopeLevel - nbVar6.getVolumeEnvelopeLevel(i5));
                    nbVar7 = this.c.f4103a;
                    int round = Math.round(nbVar7.getVolumeEnvelopeLevel(i5) + volumeEnvelopeLevel2);
                    slider = this.c.c;
                    slider.setValue(round);
                    break;
                }
            }
            this.c.s();
            KMAppUsage.a(this.c.getActivity()).a(KMAppUsage.KMMetric.VidVolumeEnvelopeDeletePoint);
        }
    }
}
