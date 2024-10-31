package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.af, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1848af implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1857bf f22219a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1848af(C1857bf c1857bf) {
        this.f22219a = c1857bf;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.q qVar;
        qVar = this.f22219a.m;
        qVar.setMusicVolume((int) Math.ceil(f2 + 100.0f));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        this.f22219a.G();
    }
}
