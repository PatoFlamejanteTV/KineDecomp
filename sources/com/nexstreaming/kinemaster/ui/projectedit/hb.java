package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionStrengthAndVariationFragment.java */
/* loaded from: classes.dex */
class hb implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ha f3946a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hb(ha haVar) {
        this.f3946a = haVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem.k kVar;
        NexTimelineItem.k kVar2;
        kVar = this.f3946a.f3945a;
        if (kVar != null) {
            kVar2 = this.f3946a.f3945a;
            kVar2.setStrengthValue(f / 100.0f);
            this.f3946a.o().z().a();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        this.f3946a.d();
    }
}
