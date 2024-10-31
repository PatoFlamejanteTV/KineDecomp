package com.nexstreaming.kinemaster.ui.projectedit;

import android.support.v7.widget.ActivityChooserView;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes2.dex */
class Ph implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IconButton f22020a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ IconButton f22021b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ IconButton f22022c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ IconButton f22023d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Uh f22024e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ph(Uh uh, IconButton iconButton, IconButton iconButton2, IconButton iconButton3, IconButton iconButton4) {
        this.f22024e = uh;
        this.f22020a = iconButton;
        this.f22021b = iconButton2;
        this.f22022c = iconButton3;
        this.f22023d = iconButton4;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem nexTimelineItem;
        Vh vh;
        NexTimelineItem nexTimelineItem2;
        NexTimelineItem nexTimelineItem3;
        boolean z;
        boolean z2;
        Vh vh2;
        Slider slider;
        Vh vh3;
        int v = this.f22024e.da().v();
        nexTimelineItem = this.f22024e.o;
        int absStartTime = nexTimelineItem.getAbsStartTime();
        vh = this.f22024e.l;
        int volumeEnvelopeLength = vh.getVolumeEnvelopeLength();
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        for (int i3 = 0; i3 < volumeEnvelopeLength; i3++) {
            vh3 = this.f22024e.l;
            int abs = Math.abs(v - (vh3.getVolumeEnvelopeTimeAdj(i3) + absStartTime));
            if (abs < i) {
                i2 = i3;
                i = abs;
            }
        }
        Uh uh = this.f22024e;
        nexTimelineItem2 = uh.o;
        float c2 = uh.c(nexTimelineItem2);
        nexTimelineItem3 = this.f22024e.o;
        float representedDuration = (10.0f / c2) * nexTimelineItem3.getRepresentedDuration();
        z = this.f22024e.q;
        if (z) {
            this.f22024e.r = true;
            this.f22020a.performClick();
            this.f22024e.q = false;
            return;
        }
        if (i < representedDuration && i2 > -1) {
            z2 = this.f22024e.s;
            if (z2 && f2 < 15.0f) {
                slider = this.f22024e.n;
                slider.setValue(15.0f);
                f2 = 15.0f;
            }
            vh2 = this.f22024e.l;
            vh2.changeVolumeLevel(i2, (int) f2);
            if (i2 >= 1 && i2 < volumeEnvelopeLength - 1) {
                this.f22020a.setEnabled(false);
                this.f22021b.setEnabled(true);
            } else {
                this.f22020a.setEnabled(false);
                this.f22021b.setEnabled(false);
            }
        } else {
            this.f22020a.setEnabled(true);
            this.f22021b.setEnabled(false);
        }
        this.f22024e.ha();
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x01f8, code lost:            if (r1 <= r2.getVolumeEnvelopeTimeAdj(r11)) goto L54;     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0236, code lost:            if (r1 <= r2.getVolumeEnvelopeTimeAdj(r11)) goto L62;     */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            Method dump skipped, instructions count: 599
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.Ph.b():void");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        boolean z;
        z = this.f22024e.q;
        if (z) {
            this.f22020a.performClick();
            this.f22024e.q = false;
        }
        this.f22024e.G();
    }
}
