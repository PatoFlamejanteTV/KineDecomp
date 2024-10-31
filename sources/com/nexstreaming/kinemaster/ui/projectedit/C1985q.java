package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: AlphaAdjustmentFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.q, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1985q implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f22483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1985q(r rVar) {
        this.f22483a = rVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.a aVar;
        NexTimelineItem.a aVar2;
        aVar = this.f22483a.l;
        if (aVar != null) {
            aVar2 = this.f22483a.l;
            aVar2.setAlpha((int) ((f2 * 255.0f) / 100.0f));
            VideoEditor da = this.f22483a.da();
            if (da != null) {
                da.n().execute();
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        this.f22483a.L();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        NexTimelineItem.a aVar;
        aVar = this.f22483a.l;
        if (aVar != null) {
            this.f22483a.G();
        }
    }
}
