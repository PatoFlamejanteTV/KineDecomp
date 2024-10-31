package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.widget.SpeedControlSpinner;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: SpeedControlFragment.java */
/* loaded from: classes2.dex */
class Mg implements SpeedControlSpinner.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ng f21965a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mg(Ng ng) {
        this.f21965a = ng;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.SpeedControlSpinner.a
    public void a(float f2) {
        NexVideoClipItem nexVideoClipItem;
        NexVideoClipItem nexVideoClipItem2;
        NexVideoClipItem nexVideoClipItem3;
        NexVideoClipItem nexVideoClipItem4;
        nexVideoClipItem = this.f21965a.q;
        if (nexVideoClipItem != null) {
            nexVideoClipItem2 = this.f21965a.q;
            nexVideoClipItem2.setPlaybackSpeed((int) (100.0f * f2));
            nexVideoClipItem3 = this.f21965a.q;
            nexVideoClipItem3.getTimeline().requestCalcTimes();
            nexVideoClipItem4 = this.f21965a.q;
            nexVideoClipItem4.setUseIFrameOnly(f2 >= 2.0f);
            this.f21965a.ha();
            this.f21965a.d(false);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.SpeedControlSpinner.a
    public void b() {
        NexVideoClipItem nexVideoClipItem;
        Ng ng = this.f21965a;
        nexVideoClipItem = ng.q;
        ng.p = nexVideoClipItem.getPlaybackSpeed();
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.SpeedControlSpinner.a
    public void a() {
        this.f21965a.xa();
    }
}
