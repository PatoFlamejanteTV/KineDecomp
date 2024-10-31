package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionStrengthAndVariationFragment.java */
/* loaded from: classes.dex */
class hc implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ha f3947a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hc(ha haVar) {
        this.f3947a = haVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem.l lVar;
        NexTimelineItem.l lVar2;
        lVar = this.f3947a.b;
        if (lVar != null) {
            lVar2 = this.f3947a.b;
            lVar2.setVariationValue(f / 100.0f);
            this.f3947a.o().z().a();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        this.f3947a.d();
    }
}
