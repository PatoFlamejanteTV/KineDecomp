package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes.dex */
class hl implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ hf f3956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hl(hf hfVar) {
        this.f3956a = hfVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem.d dVar;
        dVar = this.f3956a.f3950a;
        dVar.setAudioPitch((int) f);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        Slider slider;
        NexTimelineItem.d dVar;
        slider = this.f3956a.i;
        dVar = this.f3956a.f3950a;
        slider.setValue(dVar.getAudioPitch());
        this.f3956a.d();
    }
}
