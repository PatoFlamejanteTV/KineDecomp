package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes.dex */
class mx implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IconButton f4105a;
    final /* synthetic */ IconButton b;
    final /* synthetic */ mv c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mx(mv mvVar, IconButton iconButton, IconButton iconButton2) {
        this.c = mvVar;
        this.f4105a = iconButton;
        this.b = iconButton2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem nexTimelineItem;
        nb nbVar;
        nb nbVar2;
        nb nbVar3;
        nb nbVar4;
        nb nbVar5;
        nb nbVar6;
        nb nbVar7;
        int h;
        int i;
        nb nbVar8;
        Slider slider;
        boolean z;
        if (this.c.o() != null) {
            int u = this.c.o().u();
            nexTimelineItem = this.c.d;
            int absStartTime = u - nexTimelineItem.getAbsStartTime();
            nbVar = this.c.f4103a;
            int volumeEnvelopeLength = nbVar.getVolumeEnvelopeLength();
            int i2 = 0;
            while (true) {
                if (i2 >= volumeEnvelopeLength - 1) {
                    break;
                }
                nbVar2 = this.c.f4103a;
                if (i2 < nbVar2.getVolumeEnvelopeLength() - 1) {
                    nbVar3 = this.c.f4103a;
                    int volumeEnvelopeTimeAdj = nbVar3.getVolumeEnvelopeTimeAdj(i2);
                    nbVar4 = this.c.f4103a;
                    int volumeEnvelopeTimeAdj2 = nbVar4.getVolumeEnvelopeTimeAdj(i2 + 1);
                    if (u == volumeEnvelopeTimeAdj || u == volumeEnvelopeTimeAdj2) {
                        break;
                    }
                    if (volumeEnvelopeTimeAdj >= absStartTime || absStartTime >= volumeEnvelopeTimeAdj2) {
                        i2++;
                    } else {
                        float f = (absStartTime - volumeEnvelopeTimeAdj) / (volumeEnvelopeTimeAdj2 - volumeEnvelopeTimeAdj);
                        nbVar5 = this.c.f4103a;
                        int volumeEnvelopeLevel = nbVar5.getVolumeEnvelopeLevel(i2 + 1);
                        nbVar6 = this.c.f4103a;
                        float volumeEnvelopeLevel2 = f * (volumeEnvelopeLevel - nbVar6.getVolumeEnvelopeLevel(i2));
                        nbVar7 = this.c.f4103a;
                        int volumeEnvelopeLevel3 = (int) (volumeEnvelopeLevel2 + nbVar7.getVolumeEnvelopeLevel(i2));
                        int i3 = i2 + 1;
                        if (i3 > 0 && i3 < volumeEnvelopeLength) {
                            h = this.c.h();
                            i = this.c.i();
                            nbVar8 = this.c.f4103a;
                            nbVar8.addVolumeEnvelope(i3, ((absStartTime * i) / 100) + h, volumeEnvelopeLevel3);
                            slider = this.c.c;
                            slider.setValue(volumeEnvelopeLevel3);
                            z = this.c.g;
                            if (!z) {
                                this.c.d();
                            }
                            this.f4105a.setEnabled(false);
                            this.b.setEnabled(true);
                        }
                    }
                } else {
                    break;
                }
            }
            this.c.g = false;
            this.c.s();
            KMAppUsage.a(this.c.getActivity()).a(KMAppUsage.KMMetric.VidVolumeEnvelopeAddPoint);
        }
    }
}
