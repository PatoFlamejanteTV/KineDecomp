package com.nexstreaming.kinemaster.ui.b;

import android.view.View;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectPreviewFragmentBase.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f21516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f21516a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int absStartTime;
        int absEndTime;
        VideoEditor da = this.f21516a.da();
        View view = this.f21516a.getView();
        if (view == null || da == null || this.f21516a.Y() == null) {
            return;
        }
        long nanoTime = System.nanoTime() / 1000000;
        j = this.f21516a.n;
        long j2 = nanoTime - j;
        view.removeCallbacks(this);
        view.postOnAnimationDelayed(this, 33L);
        if (this.f21516a.Y() instanceof NexVideoClipItem) {
            absStartTime = this.f21516a.Y().getAbsStartTime() + ((NexVideoClipItem) this.f21516a.Y()).getStartOverlap() + ((NexVideoClipItem) this.f21516a.Y()).getEffectStartTime() + 10;
            absEndTime = ((NexVideoClipItem) this.f21516a.Y()).getEffectDuration() + absStartTime;
        } else {
            absStartTime = this.f21516a.Y().getAbsStartTime();
            absEndTime = this.f21516a.Y().getAbsEndTime();
        }
        int i = absEndTime - absStartTime;
        int max = Math.max(i, 300);
        int min = Math.min(Math.max(400, i / 3), SemanticAnnotations.SemanticType.ST_AVOCADO_ID_VALUE) + i;
        boolean z = false;
        if (i >= 1) {
            long j3 = min;
            long j4 = i;
            int min2 = (int) Math.min(((j2 % j3) * j4) / max, j4);
            if ((this.f21516a.Y() instanceof NexTransitionItem) && (j2 / j3) % 2 == 1) {
                z = true;
            }
            absStartTime += min2;
        }
        this.f21516a.l = true;
        if (EditorGlobal.i().j()) {
            NexEditor.c n = da.n();
            n.a(absStartTime);
            n.a(z);
            n.a();
            return;
        }
        NexEditor.c n2 = da.n();
        n2.a(absStartTime);
        n2.a(z);
        n2.execute();
    }
}
