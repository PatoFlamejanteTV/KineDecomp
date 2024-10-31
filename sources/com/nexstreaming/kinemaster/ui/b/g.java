package com.nexstreaming.kinemaster.ui.b;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTransitionItem;

/* compiled from: EffectSettingsFragment.java */
/* loaded from: classes.dex */
class g implements DurationSpinner.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f3694a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f3694a = fVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.DurationSpinner.a
    public void a(float f) {
        boolean i;
        NexTransitionItem j;
        VideoEditor o;
        NexTransitionItem j2;
        i = this.f3694a.i();
        if (i) {
            j = this.f3694a.j();
            if (j != null) {
                o = this.f3694a.o();
                NexTimeline.c beginTimeChange = o.f().a().beginTimeChange();
                j2 = this.f3694a.j();
                j2.setDuration((int) (1000.0f * f));
                this.f3694a.s();
                beginTimeChange.a();
                this.f3694a.d();
                this.f3694a.e(false);
            }
        }
    }
}
