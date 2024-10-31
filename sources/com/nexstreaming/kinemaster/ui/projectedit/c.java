package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: AlphaAdjustmentFragment.java */
/* loaded from: classes.dex */
class c implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f3808a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f3808a = bVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem.a aVar;
        NexTimelineItem.a aVar2;
        aVar = this.f3808a.f3780a;
        if (aVar != null) {
            aVar2 = this.f3808a.f3780a;
            aVar2.setAlpha((int) ((255.0f * f) / 100.0f));
            VideoEditor o = this.f3808a.o();
            if (o != null) {
                o.z().a();
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f3808a.q();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        NexTimelineItem.a aVar;
        NexTimelineItem.a aVar2;
        aVar = this.f3808a.f3780a;
        if (aVar != null) {
            this.f3808a.d();
            KMUsage kMUsage = KMUsage.EditScreen_Adjust_Alpha;
            aVar2 = this.f3808a.f3780a;
            kMUsage.logEvent("value", KMUsage.bucketParamPlusMinus100(aVar2.getAlpha()));
        }
    }
}
