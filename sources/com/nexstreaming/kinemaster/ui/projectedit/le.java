package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionStrengthAndVariationFragment.java */
/* loaded from: classes2.dex */
class Le implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Me f21949a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Le(Me me2) {
        this.f21949a = me2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.n nVar;
        NexTimelineItem.n nVar2;
        nVar = this.f21949a.m;
        if (nVar != null) {
            nVar2 = this.f21949a.m;
            nVar2.setVariationValue(f2 / 100.0f);
            this.f21949a.da().n().execute();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f21949a.G();
    }
}
