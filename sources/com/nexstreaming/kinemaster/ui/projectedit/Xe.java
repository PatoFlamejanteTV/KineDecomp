package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes2.dex */
class Xe implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ye f22170a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xe(Ye ye) {
        this.f22170a = ye;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.q qVar;
        qVar = this.f22170a.m;
        qVar.setMusicVolume((int) Math.ceil(f2 + 100.0f));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f22170a.G();
    }
}
