package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;

/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes2.dex */
class Dc implements DurationSpinner.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jc f21814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dc(Jc jc) {
        this.f21814a = jc;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.DurationSpinner.a
    public void a(float f2) {
        if (this.f21814a.Y() == null || this.f21814a.sa() == null) {
            return;
        }
        ((NexLayerItem) this.f21814a.Y()).setLayerExpressionDuration(this.f21814a.sa(), (int) (f2 * 1000.0f));
        this.f21814a.q = System.nanoTime();
        this.f21814a.da().J();
    }
}
