package com.nexstreaming.kinemaster.ui.projectedit;

import android.util.Log;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ec, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1881ec implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1899gc f22324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1881ec(C1899gc c1899gc) {
        this.f22324a = c1899gc;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.d dVar;
        Slider slider;
        dVar = this.f22324a.w;
        double d2 = f2;
        dVar.setChromaKeyFGClip((float) (Math.ceil(d2) / 100.0d));
        slider = this.f22324a.s;
        slider.setValue((float) Math.ceil(d2));
        this.f22324a.da().n().execute();
        this.f22324a.wa();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        View view;
        view = this.f22324a.y;
        view.setVisibility(8);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a() {
        View view;
        Slider slider;
        Slider slider2;
        Slider slider3;
        Slider slider4;
        Slider slider5;
        view = this.f22324a.y;
        view.setVisibility(0);
        StringBuilder sb = new StringBuilder();
        sb.append("TESTTEST :: Limit :: BG :: ");
        slider = this.f22324a.s;
        float maxValue = slider.getMaxValue();
        slider2 = this.f22324a.s;
        sb.append(maxValue - slider2.getValue());
        Log.d("ChromaKey", sb.toString());
        slider3 = this.f22324a.r;
        slider4 = this.f22324a.s;
        float maxValue2 = slider4.getMaxValue();
        slider5 = this.f22324a.s;
        slider3.setDraggingLimitValue(maxValue2 - slider5.getValue());
        this.f22324a.G();
    }
}
