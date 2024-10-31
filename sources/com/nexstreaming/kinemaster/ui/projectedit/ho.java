package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeAndBalanceFragment.java */
/* loaded from: classes.dex */
class ho implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ hf f3959a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ho(hf hfVar) {
        this.f3959a = hfVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem.o oVar;
        oVar = this.f3959a.b;
        oVar.setMusicVolume((int) Math.ceil(100.0f + f));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        NexTimelineItem.o oVar;
        NexTimelineItem.o oVar2;
        this.f3959a.d();
        oVar = this.f3959a.b;
        if (oVar != null) {
            KMUsage kMUsage = KMUsage.EditScreen_AdjustBGMVolume;
            oVar2 = this.f3959a.b;
            kMUsage.logEvent("level", KMUsage.bucketParam0to100(oVar2.getMusicVolume()));
        }
    }
}
