package b.b.e.a;

import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class c implements Drawable.Callback {

    /* renamed from: a */
    final /* synthetic */ d f3301a;

    public c(d dVar) {
        this.f3301a = dVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        this.f3301a.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f3301a.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f3301a.unscheduleSelf(runnable);
    }
}
