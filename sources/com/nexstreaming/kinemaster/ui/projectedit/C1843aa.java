package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ad.g;
import com.nexstreaming.kinemaster.ui.projectedit.BannerTimelineView;

/* compiled from: BannerTimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.aa */
/* loaded from: classes2.dex */
public class C1843aa implements g.a {

    /* renamed from: a */
    final /* synthetic */ BannerTimelineView f22214a;

    public C1843aa(BannerTimelineView bannerTimelineView) {
        this.f22214a = bannerTimelineView;
    }

    @Override // com.nexstreaming.kinemaster.ad.g.a
    public void a(com.nexstreaming.kinemaster.ad.g gVar) {
        com.nexstreaming.kinemaster.ad.f fVar;
        com.nexstreaming.kinemaster.ad.f fVar2;
        BannerTimelineView.a aVar;
        gVar.removeListener(this);
        fVar = this.f22214a.Tb;
        if (fVar.g()) {
            return;
        }
        fVar2 = this.f22214a.Tb;
        fVar2.a(true);
        aVar = this.f22214a.Ub;
        aVar.a(0.95f, 500L);
        this.f22214a.postInvalidateOnAnimation();
        this.f22214a.o();
    }
}
