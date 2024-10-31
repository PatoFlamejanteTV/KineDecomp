package android.support.design.widget;

import android.view.ViewTreeObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl.java */
/* renamed from: android.support.design.widget.t */
/* loaded from: classes.dex */
public class ViewTreeObserverOnPreDrawListenerC0193t implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    final /* synthetic */ C0194u f495a;

    public ViewTreeObserverOnPreDrawListenerC0193t(C0194u c0194u) {
        this.f495a = c0194u;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f495a.i();
        return true;
    }
}
