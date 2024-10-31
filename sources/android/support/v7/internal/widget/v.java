package android.support.v7.internal.widget;

import android.support.v7.internal.widget.SpinnerCompat;
import android.view.ViewTreeObserver;

/* compiled from: SpinnerCompat.java */
/* loaded from: classes.dex */
class v implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SpinnerCompat f192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SpinnerCompat spinnerCompat) {
        this.f192a = spinnerCompat;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        SpinnerCompat.d dVar;
        SpinnerCompat.d dVar2;
        dVar = this.f192a.G;
        if (!dVar.b()) {
            dVar2 = this.f192a.G;
            dVar2.c();
        }
        ViewTreeObserver viewTreeObserver = this.f192a.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }
}
