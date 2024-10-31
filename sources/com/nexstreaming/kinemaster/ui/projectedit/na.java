package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes.dex */
class na implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mv f4109a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public na(mv mvVar) {
        this.f4109a = mvVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bb, code lost:            if ((r0.getVolumeEnvelopeTimeAdj(r2) + (r5 / 2.0f)) >= 0.0f) goto L24;     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r9) {
        /*
            r8 = this;
            r1 = 0
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nexstreaming.kinemaster.editorwrapper.VideoEditor r0 = r0.o()
            if (r0 != 0) goto La
        L9:
            return
        La:
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nexstreaming.kinemaster.editorwrapper.VideoEditor r0 = r0.o()
            int r3 = r0.u()
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nextreaming.nexeditorui.NexTimelineItem r0 = com.nexstreaming.kinemaster.ui.projectedit.mv.a(r0)
            int r4 = r0.getAbsStartTime()
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nexstreaming.kinemaster.ui.projectedit.nb r0 = com.nexstreaming.kinemaster.ui.projectedit.mv.b(r0)
            int r2 = r0.getVolumeEnvelopeLength()
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nexstreaming.kinemaster.ui.projectedit.mv r5 = r8.f4109a
            com.nextreaming.nexeditorui.NexTimelineItem r5 = com.nexstreaming.kinemaster.ui.projectedit.mv.a(r5)
            float r5 = r0.e(r5)
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nextreaming.nexeditorui.NexTimelineItem r0 = com.nexstreaming.kinemaster.ui.projectedit.mv.a(r0)
            int r6 = r0.getRepresentedDuration()
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nextreaming.nexeditorui.NexTimelineItem r0 = com.nexstreaming.kinemaster.ui.projectedit.mv.a(r0)
            boolean r0 = r0 instanceof com.nextreaming.nexeditorui.NexPrimaryTimelineItem
            if (r0 == 0) goto Ld7
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nextreaming.nexeditorui.NexTimelineItem r0 = com.nexstreaming.kinemaster.ui.projectedit.mv.a(r0)
            com.nextreaming.nexeditorui.NexPrimaryTimelineItem r0 = (com.nextreaming.nexeditorui.NexPrimaryTimelineItem) r0
            int r0 = r0.getStartOverlap()
        L54:
            r7 = 1096810496(0x41600000, float:14.0)
            float r5 = r7 / r5
            float r6 = (float) r6
            float r5 = r5 * r6
            int r2 = r2 + (-1)
        L5c:
            if (r2 < 0) goto L78
            com.nexstreaming.kinemaster.ui.projectedit.mv r6 = r8.f4109a
            com.nexstreaming.kinemaster.ui.projectedit.nb r6 = com.nexstreaming.kinemaster.ui.projectedit.mv.b(r6)
            int r6 = r6.getVolumeEnvelopeTimeAdj(r2)
            int r6 = r6 + r4
            if (r3 <= r6) goto L9b
            com.nexstreaming.kinemaster.ui.projectedit.mv r7 = r8.f4109a
            com.nexstreaming.kinemaster.ui.projectedit.nb r7 = com.nexstreaming.kinemaster.ui.projectedit.mv.b(r7)
            int r7 = r7.getVolumeEnvelopeTimeAdj(r2)
            int r7 = r7 - r0
            if (r7 >= 0) goto L88
        L78:
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            android.app.Activity r0 = r0.getActivity()
            com.nexstreaming.app.general.tracelog.AppUsage r0 = com.nexstreaming.kinemaster.tracelog.KMAppUsage.a(r0)
            com.nexstreaming.kinemaster.tracelog.KMAppUsage$KMMetric r1 = com.nexstreaming.kinemaster.tracelog.KMAppUsage.KMMetric.VidVolumeEnvelopePrevPoint
            r0.a(r1)
            goto L9
        L88:
            int r7 = r3 - r6
            float r7 = (float) r7
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 >= 0) goto L9e
            com.nexstreaming.kinemaster.ui.projectedit.mv r7 = r8.f4109a
            com.nexstreaming.kinemaster.ui.projectedit.Slider r7 = com.nexstreaming.kinemaster.ui.projectedit.mv.e(r7)
            boolean r7 = r7.isEnabled()
            if (r7 == 0) goto L9e
        L9b:
            int r2 = r2 + (-1)
            goto L5c
        L9e:
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nextreaming.nexeditorui.NexTimelineItem r0 = com.nexstreaming.kinemaster.ui.projectedit.mv.a(r0)
            boolean r0 = r0 instanceof com.nextreaming.nexeditorui.NexSecondaryTimelineItem
            if (r0 == 0) goto Lbd
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nexstreaming.kinemaster.ui.projectedit.nb r0 = com.nexstreaming.kinemaster.ui.projectedit.mv.b(r0)
            int r0 = r0.getVolumeEnvelopeTimeAdj(r2)
            float r0 = (float) r0
            r3 = 1073741824(0x40000000, float:2.0)
            float r3 = r5 / r3
            float r0 = r0 + r3
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 < 0) goto L78
        Lbd:
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            r0.e(r6, r1)
            com.nexstreaming.kinemaster.ui.projectedit.mv r0 = r8.f4109a
            com.nexstreaming.kinemaster.ui.projectedit.Slider r0 = com.nexstreaming.kinemaster.ui.projectedit.mv.e(r0)
            com.nexstreaming.kinemaster.ui.projectedit.mv r1 = r8.f4109a
            com.nexstreaming.kinemaster.ui.projectedit.nb r1 = com.nexstreaming.kinemaster.ui.projectedit.mv.b(r1)
            int r1 = r1.getVolumeEnvelopeLevel(r2)
            float r1 = (float) r1
            r0.setValue(r1)
            goto L78
        Ld7:
            r0 = r1
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.na.onClick(android.view.View):void");
    }
}
