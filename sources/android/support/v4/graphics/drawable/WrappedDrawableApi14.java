package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {

    /* renamed from: a */
    static final PorterDuff.Mode f1161a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private int f1162b;

    /* renamed from: c */
    private PorterDuff.Mode f1163c;

    /* renamed from: d */
    private boolean f1164d;

    /* renamed from: e */
    DrawableWrapperState f1165e;

    /* renamed from: f */
    private boolean f1166f;

    /* renamed from: g */
    Drawable f1167g;

    /* loaded from: classes.dex */
    public static abstract class DrawableWrapperState extends Drawable.ConstantState {

        /* renamed from: a */
        int f1168a;

        /* renamed from: b */
        Drawable.ConstantState f1169b;

        /* renamed from: c */
        ColorStateList f1170c;

        /* renamed from: d */
        PorterDuff.Mode f1171d;

        public DrawableWrapperState(DrawableWrapperState drawableWrapperState, Resources resources) {
            this.f1170c = null;
            this.f1171d = WrappedDrawableApi14.f1161a;
            if (drawableWrapperState != null) {
                this.f1168a = drawableWrapperState.f1168a;
                this.f1169b = drawableWrapperState.f1169b;
                this.f1170c = drawableWrapperState.f1170c;
                this.f1171d = drawableWrapperState.f1171d;
            }
        }

        boolean a() {
            return this.f1169b != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int i = this.f1168a;
            Drawable.ConstantState constantState = this.f1169b;
            return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);
    }

    /* loaded from: classes.dex */
    public static class DrawableWrapperStateBase extends DrawableWrapperState {
        DrawableWrapperStateBase(DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new WrappedDrawableApi14(this, resources);
        }
    }

    public WrappedDrawableApi14(DrawableWrapperState drawableWrapperState, Resources resources) {
        this.f1165e = drawableWrapperState;
        a(resources);
    }

    private void a(Resources resources) {
        Drawable.ConstantState constantState;
        DrawableWrapperState drawableWrapperState = this.f1165e;
        if (drawableWrapperState == null || (constantState = drawableWrapperState.f1169b) == null) {
            return;
        }
        setWrappedDrawable(constantState.newDrawable(resources));
    }

    protected boolean a() {
        return true;
    }

    DrawableWrapperState b() {
        return new DrawableWrapperStateBase(this.f1165e, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1167g.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        DrawableWrapperState drawableWrapperState = this.f1165e;
        return changingConfigurations | (drawableWrapperState != null ? drawableWrapperState.getChangingConfigurations() : 0) | this.f1167g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        DrawableWrapperState drawableWrapperState = this.f1165e;
        if (drawableWrapperState == null || !drawableWrapperState.a()) {
            return null;
        }
        this.f1165e.f1168a = getChangingConfigurations();
        return this.f1165e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1167g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1167g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1167g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1167g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1167g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1167g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f1167g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f1167g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1167g.getTransparentRegion();
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawable
    public final Drawable getWrappedDrawable() {
        return this.f1167g;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        DrawableWrapperState drawableWrapperState;
        ColorStateList colorStateList = (!a() || (drawableWrapperState = this.f1165e) == null) ? null : drawableWrapperState.f1170c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1167g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1167g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1166f && super.mutate() == this) {
            this.f1165e = b();
            Drawable drawable = this.f1167g;
            if (drawable != null) {
                drawable.mutate();
            }
            DrawableWrapperState drawableWrapperState = this.f1165e;
            if (drawableWrapperState != null) {
                Drawable drawable2 = this.f1167g;
                drawableWrapperState.f1169b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1166f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1167g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f1167g.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1167g.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f1167g.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1167g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1167g.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1167g.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return a(iArr) || this.f1167g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.f1165e.f1170c = colorStateList;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f1165e.f1171d = mode;
        a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1167g.setVisible(z, z2);
    }

    @Override // android.support.v4.graphics.drawable.WrappedDrawable
    public final void setWrappedDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1167g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1167g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            DrawableWrapperState drawableWrapperState = this.f1165e;
            if (drawableWrapperState != null) {
                drawableWrapperState.f1169b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    private boolean a(int[] iArr) {
        if (!a()) {
            return false;
        }
        DrawableWrapperState drawableWrapperState = this.f1165e;
        ColorStateList colorStateList = drawableWrapperState.f1170c;
        PorterDuff.Mode mode = drawableWrapperState.f1171d;
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f1164d || colorForState != this.f1162b || mode != this.f1163c) {
                setColorFilter(colorForState, mode);
                this.f1162b = colorForState;
                this.f1163c = mode;
                this.f1164d = true;
                return true;
            }
        } else {
            this.f1164d = false;
            clearColorFilter();
        }
        return false;
    }

    public WrappedDrawableApi14(Drawable drawable) {
        this.f1165e = b();
        setWrappedDrawable(drawable);
    }
}
