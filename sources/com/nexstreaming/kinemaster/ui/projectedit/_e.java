package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeFragment.java */
/* loaded from: classes2.dex */
class _e implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1857bf f22203a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _e(C1857bf c1857bf) {
        this.f22203a = c1857bf;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.e eVar;
        eVar = this.f22203a.l;
        eVar.setClipVolume((int) f2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f22203a.G();
    }
}
