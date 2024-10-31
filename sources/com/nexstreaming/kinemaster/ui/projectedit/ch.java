package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
class ch implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ce f3815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(ce ceVar) {
        this.f3815a = ceVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        View view8;
        view = this.f3815a.e;
        if (view != null) {
            view5 = this.f3815a.c;
            if (view5 != null) {
                view6 = this.f3815a.e;
                float y = view6.getY();
                view7 = this.f3815a.c;
                if (y > view7.getHeight()) {
                    view8 = this.f3815a.e;
                    view8.requestLayout();
                }
            }
        }
        view2 = this.f3815a.d;
        if (view2 != null) {
            view3 = this.f3815a.d;
            if (view3.getHeight() <= 0) {
                view4 = this.f3815a.d;
                view4.requestLayout();
            }
        }
    }
}
