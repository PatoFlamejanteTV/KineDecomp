package android.databinding;

import android.os.Build;
import android.view.View;

/* compiled from: ViewDataBinding.java */
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ViewDataBinding f160a;

    public o(ViewDataBinding viewDataBinding) {
        this.f160a = viewDataBinding;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        View view3;
        View.OnAttachStateChangeListener onAttachStateChangeListener2;
        synchronized (this) {
            this.f160a.m = false;
        }
        ViewDataBinding.i();
        if (Build.VERSION.SDK_INT >= 19) {
            view = this.f160a.p;
            if (!view.isAttachedToWindow()) {
                view2 = this.f160a.p;
                onAttachStateChangeListener = ViewDataBinding.k;
                view2.removeOnAttachStateChangeListener(onAttachStateChangeListener);
                view3 = this.f160a.p;
                onAttachStateChangeListener2 = ViewDataBinding.k;
                view3.addOnAttachStateChangeListener(onAttachStateChangeListener2);
                return;
            }
        }
        this.f160a.d();
    }
}
