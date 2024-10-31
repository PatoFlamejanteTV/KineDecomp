package com.google.firebase.inappmessaging.display.internal;

import android.view.View;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class d extends SwipeDismissTouchListener {
    final /* synthetic */ WindowManager.LayoutParams o;
    final /* synthetic */ WindowManager p;
    final /* synthetic */ BindingWrapper q;
    final /* synthetic */ FiamWindowManager r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(FiamWindowManager fiamWindowManager, View view, Object obj, SwipeDismissTouchListener.DismissCallbacks dismissCallbacks, WindowManager.LayoutParams layoutParams, WindowManager windowManager, BindingWrapper bindingWrapper) {
        super(view, obj, dismissCallbacks);
        this.r = fiamWindowManager;
        this.o = layoutParams;
        this.p = windowManager;
        this.q = bindingWrapper;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener
    protected float a() {
        return this.o.x;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener
    public void b(float f2) {
        this.o.x = (int) f2;
        this.p.updateViewLayout(this.q.f(), this.o);
    }
}
