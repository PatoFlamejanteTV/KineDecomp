package com.nexstreaming.kinemaster.ui.b;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectPreviewFragmentBase.java */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f3689a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.f3689a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoEditor o;
        long j;
        int absStartTime;
        int absEndTime;
        boolean z = false;
        o = this.f3689a.o();
        View view = this.f3689a.getView();
        if (view != null && o != null && this.f3689a.m() != null) {
            long nanoTime = System.nanoTime() / 1000000;
            j = this.f3689a.c;
            long j2 = nanoTime - j;
            view.removeCallbacks(this);
            view.postDelayed(this, 33L);
            if (this.f3689a.m() instanceof NexVideoClipItem) {
                absStartTime = ((NexVideoClipItem) this.f3689a.m()).getEffectStartTime() + this.f3689a.m().getAbsStartTime() + ((NexVideoClipItem) this.f3689a.m()).getStartOverlap() + 10;
                absEndTime = ((NexVideoClipItem) this.f3689a.m()).getEffectDuration() + absStartTime;
            } else {
                absStartTime = this.f3689a.m().getAbsStartTime();
                absEndTime = this.f3689a.m().getAbsEndTime();
            }
            int i = absEndTime - absStartTime;
            int max = Math.max(i, 300);
            int min = Math.min(Math.max(400, i / 3), 2500) + i;
            if (i >= 1) {
                absStartTime += (int) Math.min(((j2 % min) * i) / max, i);
                z = (j2 / ((long) min)) % 2 == 1;
            }
            this.f3689a.f3687a = true;
            if (true == EditorGlobal.a().l()) {
                o.z().a(absStartTime).a(z).b();
            } else {
                o.z().a(absStartTime).a(z).a();
            }
        }
    }
}
