package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes.dex */
class mw implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IconButton f4104a;
    final /* synthetic */ IconButton b;
    final /* synthetic */ IconButton c;
    final /* synthetic */ IconButton d;
    final /* synthetic */ mv e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mw(mv mvVar, IconButton iconButton, IconButton iconButton2, IconButton iconButton3, IconButton iconButton4) {
        this.e = mvVar;
        this.f4104a = iconButton;
        this.b = iconButton2;
        this.c = iconButton3;
        this.d = iconButton4;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem nexTimelineItem;
        nb nbVar;
        NexTimelineItem nexTimelineItem2;
        NexTimelineItem nexTimelineItem3;
        boolean z;
        nb nbVar2;
        nb nbVar3;
        int i;
        int u = this.e.o().u();
        nexTimelineItem = this.e.d;
        int absStartTime = nexTimelineItem.getAbsStartTime();
        nbVar = this.e.f4103a;
        int volumeEnvelopeLength = nbVar.getVolumeEnvelopeLength();
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = -1;
        while (i3 < volumeEnvelopeLength) {
            nbVar3 = this.e.f4103a;
            int abs = Math.abs(u - (nbVar3.getVolumeEnvelopeTimeAdj(i3) + absStartTime));
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
        mv mvVar = this.e;
        nexTimelineItem2 = this.e.d;
        float e = mvVar.e(nexTimelineItem2);
        nexTimelineItem3 = this.e.d;
        float representedDuration = (14.0f / e) * nexTimelineItem3.getRepresentedDuration();
        z = this.e.f;
        if (z) {
            this.e.g = true;
            this.f4104a.performClick();
            this.e.f = false;
            return;
        }
        if (i2 < representedDuration && i4 > -1) {
            nbVar2 = this.e.f4103a;
            nbVar2.changeVolumeLevel(i4, (int) f);
            if (i4 < 1 || i4 >= volumeEnvelopeLength - 1) {
                this.f4104a.setEnabled(false);
                this.b.setEnabled(false);
            } else {
                this.f4104a.setEnabled(false);
                this.b.setEnabled(true);
            }
        } else {
            this.f4104a.setEnabled(true);
            this.b.setEnabled(false);
        }
        this.e.s();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        boolean z;
        z = this.e.f;
        if (z) {
            this.f4104a.performClick();
            this.e.f = false;
        }
        this.e.d();
        KMAppUsage.a(this.e.getActivity()).a(KMAppUsage.KMMetric.VidVolumeEnvelopeAdjustVolume);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0216, code lost:            if (r2 <= r1.getVolumeEnvelopeTimeAdj(r0)) goto L53;     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x025a, code lost:            if (r2 <= r1.getVolumeEnvelopeTimeAdj(r0)) goto L61;     */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 643
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.mw.a():void");
    }
}
