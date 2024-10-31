package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionBlendModeFragment.java */
/* loaded from: classes2.dex */
class Ub implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Xb f22140a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ub(Xb xb) {
        this.f22140a = xb;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.a aVar;
        NexTimelineItem.a aVar2;
        aVar = this.f22140a.m;
        if (aVar != null) {
            aVar2 = this.f22140a.m;
            aVar2.setAlpha((int) ((f2 * 255.0f) / 100.0f));
            VideoEditor da = this.f22140a.da();
            if (da != null) {
                da.n().execute();
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        this.f22140a.L();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        NexTimelineItem.a unused;
        unused = this.f22140a.m;
    }
}
