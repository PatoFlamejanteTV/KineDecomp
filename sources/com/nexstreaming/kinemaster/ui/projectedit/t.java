package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: EffectLayerEditFragment.java */
/* loaded from: classes.dex */
class t implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ r f4115a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.f4115a = rVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        view = this.f4115a.d;
        if (view != null) {
            view2 = this.f4115a.d;
            if (view2.getHeight() <= 0) {
                view3 = this.f4115a.d;
                view3.requestLayout();
            }
        }
    }
}
