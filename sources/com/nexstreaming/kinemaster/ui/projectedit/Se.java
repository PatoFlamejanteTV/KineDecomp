package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes2.dex */
class Se implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ye f22080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Se(Ye ye) {
        this.f22080a = ye;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.e eVar;
        eVar = this.f22080a.l;
        eVar.setAudioRightVolume((int) f2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f22080a.G();
    }
}
