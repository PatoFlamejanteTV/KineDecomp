package com.nexstreaming.kinemaster.ui.b;

import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: EffectPreviewFragmentBase.java */
/* loaded from: classes.dex */
public class c extends kp {
    private long c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f3687a = false;
    private int b = 0;
    private boolean d = false;
    private boolean e = false;
    private Runnable f = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public void f_() {
        int absStartTime;
        if (this.d) {
            this.e = true;
            return;
        }
        this.d = true;
        this.e = false;
        VideoEditor o = o();
        if (o != null) {
            if (!this.f3687a) {
                o.a(m());
            }
            c();
            o.a(m());
            e(false);
            if (m() instanceof NexVideoClipItem) {
                absStartTime = ((NexVideoClipItem) m()).getEffectStartTime() + m().getAbsStartTime() + ((NexVideoClipItem) m()).getStartOverlap() + 11;
            } else {
                absStartTime = m().getAbsStartTime() + 11;
            }
            o.a(absStartTime, true).onComplete(new d(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g_() {
        if (!this.f3687a) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        View view = getView();
        if (view != null) {
            this.c = System.nanoTime() / 1000000;
            view.removeCallbacks(this.f);
            view.post(this.f);
            this.f3687a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (this.f3687a) {
            this.f3687a = false;
            View view = getView();
            if (view != null) {
                view.removeCallbacks(this.f);
            }
        }
    }
}
