package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperDonut.java */
/* loaded from: classes.dex */
class h extends Drawable implements Drawable.Callback, g {

    /* renamed from: a, reason: collision with root package name */
    static final PorterDuff.Mode f71a = PorterDuff.Mode.SRC_IN;
    Drawable b;
    private ColorStateList c;
    private PorterDuff.Mode d = f71a;
    private int e;
    private PorterDuff.Mode f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Drawable drawable) {
        a(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.b.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.b.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.b.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.b.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.c != null && this.c.isStateful()) || this.b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.b.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.b.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.b.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.b.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.b.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.b.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.b.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.b;
        Drawable mutate = drawable.mutate();
        if (mutate != drawable) {
            a(mutate);
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.g
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.g
    public void setTintList(ColorStateList colorStateList) {
        this.c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.b.a.g
    public void setTintMode(PorterDuff.Mode mode) {
        this.d = mode;
        a(getState());
    }

    private boolean a(int[] iArr) {
        if (this.c != null && this.d != null) {
            int colorForState = this.c.getColorForState(iArr, this.c.getDefaultColor());
            PorterDuff.Mode mode = this.d;
            if (!this.g || colorForState != this.e || mode != this.f) {
                setColorFilter(colorForState, mode);
                this.e = colorForState;
                this.f = mode;
                this.g = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v4.b.a.g
    public Drawable a() {
        return this.b;
    }

    public void a(Drawable drawable) {
        if (this.b != null) {
            this.b.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        invalidateSelf();
    }
}
