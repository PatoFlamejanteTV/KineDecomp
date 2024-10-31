package com.nexstreaming.kinemaster.ui.projectedit;

import android.util.Log;
import android.view.View;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.dc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1872dc implements Slider.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1899gc f22309a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1872dc(C1899gc c1899gc) {
        this.f22309a = c1899gc;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void a(float f2) {
        NexTimelineItem.d dVar;
        Slider slider;
        dVar = this.f22309a.w;
        double d2 = f2;
        dVar.setChromaKeyBGClip((float) (Math.ceil(d2) / 100.0d));
        slider = this.f22309a.r;
        slider.setValue((float) Math.ceil(d2));
        this.f22309a.da().n().execute();
        this.f22309a.wa();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Slider.a
    public void b() {
        View view;
        view = this.f22309a.x;
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
        view = this.f22309a.x;
        view.setVisibility(0);
        StringBuilder sb = new StringBuilder();
        sb.append("TESTTEST :: Limit :: FG :: ");
        slider = this.f22309a.r;
        float maxValue = slider.getMaxValue();
        slider2 = this.f22309a.r;
        sb.append(maxValue - slider2.getValue());
        Log.d("ChromaKey", sb.toString());
        slider3 = this.f22309a.s;
        slider4 = this.f22309a.r;
        float maxValue2 = slider4.getMaxValue();
        slider5 = this.f22309a.r;
        slider3.setDraggingLimitValue(maxValue2 - slider5.getValue());
        this.f22309a.G();
    }
}
