package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;

/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes.dex */
class dv implements DurationSpinner.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ dt f3857a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(dt dtVar) {
        this.f3857a = dtVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.DurationSpinner.a
    public void a(float f) {
        if (this.f3857a.m() != null && this.f3857a.a() != null) {
            ((NexLayerItem) this.f3857a.m()).setLayerExpressionDuration(this.f3857a.a(), (int) (1000.0f * f));
            this.f3857a.g = System.nanoTime();
            this.f3857a.o().l();
        }
    }
}
