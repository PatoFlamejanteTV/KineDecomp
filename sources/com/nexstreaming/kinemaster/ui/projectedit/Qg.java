package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: StickerEditFragment.java */
/* loaded from: classes2.dex */
class Qg implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f22040a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Xg f22041b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qg(Xg xg, View view) {
        this.f22041b = xg;
        this.f22040a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        view = this.f22041b.K;
        if (view != null) {
            view2 = this.f22041b.K;
            if (view2.getHeight() <= 0) {
                view3 = this.f22041b.K;
                view3.requestLayout();
            }
        }
        View view4 = this.f22040a;
        if (view4 != null) {
            view4.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
