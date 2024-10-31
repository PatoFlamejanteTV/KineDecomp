package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes.dex */
class hi implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ hf f3953a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hi(hf hfVar) {
        this.f3953a = hfVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem.d dVar;
        dVar = this.f3953a.f3950a;
        dVar.setAudioLeftVolume((int) f);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        this.f3953a.d();
    }
}
