package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes2.dex */
class Ue implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ye f22146a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ue(Ye ye) {
        this.f22146a = ye;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.e eVar;
        eVar = this.f22146a.l;
        eVar.setAudioPitch((int) f2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        Slider slider;
        NexTimelineItem.e eVar;
        slider = this.f22146a.t;
        eVar = this.f22146a.l;
        slider.setValue(eVar.getAudioPitch());
        this.f22146a.G();
    }
}
