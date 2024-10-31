package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeFragment.java */
/* loaded from: classes.dex */
class hs implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ hp f3963a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hs(hp hpVar) {
        this.f3963a = hpVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem.o oVar;
        oVar = this.f3963a.b;
        oVar.setMusicVolume((int) Math.ceil(100.0f + f));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        NexTimelineItem.o oVar;
        NexTimelineItem.o oVar2;
        this.f3963a.d();
        oVar = this.f3963a.b;
        if (oVar != null) {
            KMUsage kMUsage = KMUsage.EditScreen_AdjustBGMVolume;
            oVar2 = this.f3963a.b;
            kMUsage.logEvent("level", KMUsage.bucketParam0to100(oVar2.getMusicVolume()));
        }
    }
}
