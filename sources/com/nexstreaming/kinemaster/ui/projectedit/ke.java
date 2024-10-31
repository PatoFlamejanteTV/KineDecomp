package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionStrengthAndVariationFragment.java */
/* loaded from: classes2.dex */
class Ke implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Me f21922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ke(Me me2) {
        this.f21922a = me2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.m mVar;
        NexTimelineItem.m mVar2;
        mVar = this.f21922a.l;
        if (mVar != null) {
            mVar2 = this.f21922a.l;
            mVar2.setStrengthValue(f2 / 100.0f);
            this.f21922a.da().n().execute();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f21922a.G();
    }
}
