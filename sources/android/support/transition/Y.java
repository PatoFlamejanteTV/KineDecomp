package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
class Y implements Z {

    /* renamed from: a */
    private final ViewGroupOverlay f567a;

    public Y(ViewGroup viewGroup) {
        this.f567a = viewGroup.getOverlay();
    }

    @Override // android.support.transition.ha
    public void a(Drawable drawable) {
        this.f567a.add(drawable);
    }

    @Override // android.support.transition.ha
    public void b(Drawable drawable) {
        this.f567a.remove(drawable);
    }

    @Override // android.support.transition.Z
    public void a(View view) {
        this.f567a.add(view);
    }

    @Override // android.support.transition.Z
    public void b(View view) {
        this.f567a.remove(view);
    }
}
