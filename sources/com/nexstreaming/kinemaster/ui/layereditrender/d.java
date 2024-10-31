package com.nexstreaming.kinemaster.ui.layereditrender;

import android.os.Handler;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MarchingAnts.java */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MarchingAnts f21634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MarchingAnts marchingAnts) {
        this.f21634a = marchingAnts;
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
        handler = this.f21634a.f21626d;
        runnable = this.f21634a.P;
        handler.removeCallbacks(runnable);
        z = this.f21634a.l;
        if (z && !EditorGlobal.f24025d) {
            z4 = this.f21634a.K;
            if (z4) {
                handler3 = this.f21634a.f21626d;
                runnable3 = this.f21634a.P;
                handler3.postDelayed(runnable3, 33L);
            } else {
                handler2 = this.f21634a.f21626d;
                runnable2 = this.f21634a.P;
                handler2.postDelayed(runnable2, 166L);
            }
        }
        videoEditor = this.f21634a.A;
        if (videoEditor != null) {
            z2 = this.f21634a.J;
            if (z2) {
                videoEditor2 = this.f21634a.A;
                if (videoEditor2.a(NexEditor.FastPreviewOption.normal, 0, true)) {
                    return;
                }
                z3 = this.f21634a.N;
                if (z3) {
                    return;
                }
                this.f21634a.N = true;
                videoEditor3 = this.f21634a.A;
                videoEditor3.H().onComplete(new c(this)).onFailure(new b(this));
            }
        }
    }
}
