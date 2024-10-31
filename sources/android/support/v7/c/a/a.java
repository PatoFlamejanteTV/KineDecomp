package android.support.v7.c.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapper.java */
/* loaded from: classes.dex */
public class a extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f117a;

    public a(Drawable drawable) {
        a(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f117a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f117a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f117a.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f117a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f117a.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f117a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f117a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f117a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f117a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.f117a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f117a.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        android.support.v4.b.a.a.a(this.f117a);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f117a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f117a.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f117a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f117a.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f117a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f117a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f117a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f117a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f117a.getPadding(rect);
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
        return this.f117a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        android.support.v4.b.a.a.a(this.f117a, z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return android.support.v4.b.a.a.b(this.f117a);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        android.support.v4.b.a.a.a(this.f117a, i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        android.support.v4.b.a.a.a(this.f117a, colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        android.support.v4.b.a.a.a(this.f117a, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        android.support.v4.b.a.a.a(this.f117a, f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        android.support.v4.b.a.a.a(this.f117a, i, i2, i3, i4);
    }

    public void a(Drawable drawable) {
        if (this.f117a != null) {
            this.f117a.setCallback(null);
        }
        this.f117a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }
}
