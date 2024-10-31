package android.support.v7.internal.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable.java */
/* loaded from: classes.dex */
class c extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    final ActionBarContainer f167a;

    public c(ActionBarContainer actionBarContainer) {
        this.f167a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f167a.d) {
            if (this.f167a.c != null) {
                this.f167a.c.draw(canvas);
            }
        } else {
            if (this.f167a.f145a != null) {
                this.f167a.f145a.draw(canvas);
            }
            if (this.f167a.b != null && this.f167a.e) {
                this.f167a.b.draw(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }
}
