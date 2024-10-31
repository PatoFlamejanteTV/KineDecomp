package com.nexstreaming.kinemaster.ui.layereditrender;

import android.os.Handler;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MarchingAnts.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MarchingAnts f3714a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MarchingAnts marchingAnts) {
        this.f3714a = marchingAnts;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Runnable runnable;
        boolean z;
        VideoEditor videoEditor;
        boolean z2;
        VideoEditor videoEditor2;
        boolean z3;
        VideoEditor videoEditor3;
        boolean z4;
        Handler handler2;
        Runnable runnable2;
        Handler handler3;
        Runnable runnable3;
        handler = this.f3714a.d;
        runnable = this.f3714a.J;
        handler.removeCallbacks(runnable);
        z = this.f3714a.l;
        if (z) {
            z4 = this.f3714a.F;
            if (z4) {
                handler3 = this.f3714a.d;
                runnable3 = this.f3714a.J;
                handler3.postDelayed(runnable3, 33L);
            } else {
                handler2 = this.f3714a.d;
                runnable2 = this.f3714a.J;
                handler2.postDelayed(runnable2, 166L);
            }
        }
        videoEditor = this.f3714a.x;
        if (videoEditor != null) {
            z2 = this.f3714a.E;
            if (z2) {
                videoEditor2 = this.f3714a.x;
                if (!videoEditor2.a(NexEditor.FastPreviewOption.normal, 0, true)) {
                    z3 = this.f3714a.I;
                    if (!z3) {
                        this.f3714a.I = true;
                        videoEditor3 = this.f3714a.x;
                        videoEditor3.n().onComplete(new d(this)).onFailure(new c(this));
                    }
                }
            }
        }
    }
}
