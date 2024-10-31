package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* compiled from: ViewOverlayApi18.java */
/* loaded from: classes.dex */
class ga implements ha {

    /* renamed from: a */
    private final ViewOverlay f590a;

    public ga(View view) {
        this.f590a = view.getOverlay();
    }

    @Override // android.support.transition.ha
    public void a(Drawable drawable) {
        this.f590a.add(drawable);
    }

    @Override // android.support.transition.ha
    public void b(Drawable drawable) {
        this.f590a.remove(drawable);
    }
}
