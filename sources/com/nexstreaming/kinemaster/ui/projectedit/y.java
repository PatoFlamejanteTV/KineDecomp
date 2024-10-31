package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: BannerTimelineView.java */
/* loaded from: classes2.dex */
class Y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Z f22177a;

    public Y(Z z) {
        this.f22177a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22177a.f22191a.B();
        this.f22177a.f22191a.postInvalidateOnAnimation();
    }
}
