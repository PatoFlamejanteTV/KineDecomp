package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ad.f;

/* compiled from: BannerTimelineView.java */
/* loaded from: classes2.dex */
public class Z implements f.a {

    /* renamed from: a */
    final /* synthetic */ BannerTimelineView f22191a;

    public Z(BannerTimelineView bannerTimelineView) {
        this.f22191a = bannerTimelineView;
    }

    @Override // com.nexstreaming.kinemaster.ad.f.a
    public void a(com.nexstreaming.kinemaster.ad.f fVar) {
        this.f22191a.postOnAnimationDelayed(new Y(this), 500L);
    }
}
