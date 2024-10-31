package android.databinding;

import android.annotation.TargetApi;
import android.view.View;

/* compiled from: ViewDataBinding.java */
/* loaded from: classes.dex */
class n implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    @TargetApi(19)
    public void onViewAttachedToWindow(View view) {
        Runnable runnable;
        runnable = ViewDataBinding.a(view).l;
        runnable.run();
        view.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }
}
