package android.databinding;

import android.view.Choreographer;

/* compiled from: ViewDataBinding.java */
/* loaded from: classes.dex */
public class p implements Choreographer.FrameCallback {

    /* renamed from: a */
    final /* synthetic */ ViewDataBinding f161a;

    public p(ViewDataBinding viewDataBinding) {
        this.f161a = viewDataBinding;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        Runnable runnable;
        runnable = this.f161a.l;
        runnable.run();
    }
}
