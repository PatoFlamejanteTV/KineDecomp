package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import com.nexstreaming.app.general.util.IconButton;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VolumeEnvelopeFragment.java */
/* loaded from: classes2.dex */
class Qh implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IconButton f22042a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ IconButton f22043b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Uh f22044c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qh(Uh uh, IconButton iconButton, IconButton iconButton2) {
        this.f22044c = uh;
        this.f22042a = iconButton;
        this.f22043b = iconButton2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem nexTimelineItem;
        Vh vh;
        Vh vh2;
        Vh vh3;
        Vh vh4;
        Vh vh5;
        Vh vh6;
        Vh vh7;
        int za;
        int xa;
        Vh vh8;
        Slider slider;
        boolean z;
        if (this.f22044c.da() == null) {
            return;
        }
        int v = this.f22044c.da().v();
        nexTimelineItem = this.f22044c.o;
        int absStartTime = v - nexTimelineItem.getAbsStartTime();
        vh = this.f22044c.l;
        int volumeEnvelopeLength = vh.getVolumeEnvelopeLength();
        int i = 0;
        while (true) {
            if (i >= volumeEnvelopeLength - 1) {
                break;
            }
            vh2 = this.f22044c.l;
            if (i < vh2.getVolumeEnvelopeLength() - 1) {
                vh3 = this.f22044c.l;
                int volumeEnvelopeTimeAdj = vh3.getVolumeEnvelopeTimeAdj(i);
                vh4 = this.f22044c.l;
                int i2 = i + 1;
                int volumeEnvelopeTimeAdj2 = vh4.getVolumeEnvelopeTimeAdj(i2);
                if (v == volumeEnvelopeTimeAdj || v == volumeEnvelopeTimeAdj2) {
                    break;
                }
                if (volumeEnvelopeTimeAdj >= absStartTime || absStartTime >= volumeEnvelopeTimeAdj2) {
                    i = i2;
                } else {
                    float f2 = (absStartTime - volumeEnvelopeTimeAdj) / (volumeEnvelopeTimeAdj2 - volumeEnvelopeTimeAdj);
                    vh5 = this.f22044c.l;
                    int volumeEnvelopeLevel = vh5.getVolumeEnvelopeLevel(i2);
                    vh6 = this.f22044c.l;
                    float volumeEnvelopeLevel2 = f2 * (volumeEnvelopeLevel - vh6.getVolumeEnvelopeLevel(i));
                    vh7 = this.f22044c.l;
                    int volumeEnvelopeLevel3 = (int) (volumeEnvelopeLevel2 + vh7.getVolumeEnvelopeLevel(i));
                    if (i2 > 0 && i2 < volumeEnvelopeLength) {
                        za = this.f22044c.za();
                        xa = this.f22044c.xa();
                        vh8 = this.f22044c.l;
                        vh8.addVolumeEnvelope(i2, ((absStartTime * xa) / 100) + za, volumeEnvelopeLevel3);
                        slider = this.f22044c.n;
                        slider.setValue(volumeEnvelopeLevel3);
                        z = this.f22044c.r;
                        if (!z) {
                            this.f22044c.G();
                        }
                        this.f22042a.setEnabled(false);
                        this.f22043b.setEnabled(true);
                    }
                }
            } else {
                break;
            }
        }
        this.f22044c.r = false;
        this.f22044c.ha();
    }
}
