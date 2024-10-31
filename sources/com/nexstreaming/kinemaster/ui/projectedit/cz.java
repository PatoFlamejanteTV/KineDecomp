package com.nexstreaming.kinemaster.ui.projectedit;

import android.util.Log;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes.dex */
class cz implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cr f3833a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cr crVar) {
        this.f3833a = crVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f) {
        NexTimelineItem.c cVar;
        Slider slider;
        cVar = this.f3833a.l;
        cVar.setChromaKeyFGClip((float) (Math.ceil(f) / 100.0d));
        slider = this.f3833a.h;
        slider.setValue((float) Math.ceil(f));
        this.f3833a.o().z().a();
        this.f3833a.h();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        View view;
        view = this.f3833a.n;
        view.setVisibility(8);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        View view;
        Slider slider;
        Slider slider2;
        Slider slider3;
        Slider slider4;
        Slider slider5;
        view = this.f3833a.n;
        view.setVisibility(0);
        StringBuilder append = new StringBuilder().append("TESTTEST :: Limit :: BG :: ");
        slider = this.f3833a.h;
        float maxValue = slider.getMaxValue();
        slider2 = this.f3833a.h;
        Log.d("ChromaKey", append.append(maxValue - slider2.getValue()).toString());
        slider3 = this.f3833a.g;
        slider4 = this.f3833a.h;
        float maxValue2 = slider4.getMaxValue();
        slider5 = this.f3833a.h;
        slider3.setDraggingLimitValue(maxValue2 - slider5.getValue());
        this.f3833a.d();
    }
}
