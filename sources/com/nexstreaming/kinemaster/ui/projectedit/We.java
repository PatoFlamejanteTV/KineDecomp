package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes2.dex */
class We implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ye f22166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public We(Ye ye) {
        this.f22166a = ye;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        boolean z;
        NexTimelineItem.e eVar;
        Slider slider;
        z = this.f22166a.A;
        if (z && f2 < 15.0f) {
            slider = this.f22166a.o;
            slider.setValue(15.0f);
            f2 = 15.0f;
        }
        eVar = this.f22166a.l;
        eVar.setClipVolume((int) f2);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f22166a.G();
    }
}
