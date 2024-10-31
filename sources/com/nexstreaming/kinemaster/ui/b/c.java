package com.nexstreaming.kinemaster.ui.b;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: EffectPreviewFragmentBase.java */
/* loaded from: classes.dex */
public class c extends Bg {
    private long n;
    private boolean l = false;
    private int m = 0;
    private boolean o = false;
    private boolean p = false;
    private Runnable q = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void va() {
        View view = getView();
        if (view == null) {
            return;
        }
        this.n = System.nanoTime() / 1000000;
        view.removeCallbacks(this.q);
        view.post(this.q);
        this.l = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sa() {
        if (this.l) {
            return;
        }
        va();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ta() {
        if (this.l) {
            this.l = false;
            View view = getView();
            if (view == null) {
                return;
            }
            view.removeCallbacks(this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ua() {
        int absStartTime;
        if (this.o) {
            this.p = true;
            return;
        }
        this.o = true;
        this.p = false;
        VideoEditor da = da();
        if (da == null) {
            return;
        }
        if (!this.l) {
            da.c(Y());
        }
        ta();
        da.c(Y());
        d(false);
        if (Y() instanceof NexVideoClipItem) {
            absStartTime = Y().getAbsStartTime() + ((NexVideoClipItem) Y()).getStartOverlap() + ((NexVideoClipItem) Y()).getEffectStartTime() + (Y().getTimeline().isProjectVideoFadeInTimeOn() ? Y().getTimeline().getProjectVideoFadeInTimeMillis() : 0) + 11;
        } else {
            absStartTime = Y().getAbsStartTime() + 11;
        }
        da.a(absStartTime, true).onComplete(new a(this));
    }
}
