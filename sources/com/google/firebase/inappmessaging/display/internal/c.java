package com.google.firebase.inappmessaging.display.internal;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class c implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a */
    final /* synthetic */ BindingWrapper f17602a;

    /* renamed from: b */
    final /* synthetic */ FiamWindowManager f17603b;

    public c(FiamWindowManager fiamWindowManager, BindingWrapper bindingWrapper) {
        this.f17603b = fiamWindowManager;
        this.f17602a = bindingWrapper;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.DismissCallbacks
    public void a(View view, Object obj) {
        if (this.f17602a.d() != null) {
            this.f17602a.d().onClick(view);
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.SwipeDismissTouchListener.DismissCallbacks
    public boolean a(Object obj) {
        return true;
    }
}
