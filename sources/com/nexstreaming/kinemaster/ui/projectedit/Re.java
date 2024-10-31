package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes2.dex */
class Re implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ye f22055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Re(Ye ye) {
        this.f22055a = ye;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.e eVar;
        eVar = this.f22055a.l;
        eVar.setAudioLeftVolume((int) f2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f22055a.G();
    }
}
