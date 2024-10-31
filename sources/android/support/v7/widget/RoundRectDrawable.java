package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class RoundRectDrawable extends Drawable {

    /* renamed from: a */
    private float f2974a;

    /* renamed from: c */
    private final RectF f2976c;

    /* renamed from: d */
    private final Rect f2977d;

    /* renamed from: e */
    private float f2978e;

    /* renamed from: h */
    private ColorStateList f2981h;
    private PorterDuffColorFilter i;
    private ColorStateList j;

    /* renamed from: f */
    private boolean f2979f = false;

    /* renamed from: g */
    private boolean f2980g = true;
    private PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private final Paint f2975b = new Paint(5);

    public RoundRectDrawable(ColorStateList colorStateList, float f2) {
        this.f2974a = f2;
        a(colorStateList);
        this.f2976c = new RectF();
        this.f2977d = new Rect();
    }

    private void a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2981h = colorStateList;
        this.f2975b.setColor(this.f2981h.getColorForState(getState(), this.f2981h.getDefaultColor()));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f2975b;
        if (this.i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.i);
            z = true;
        }
        RectF rectF = this.f2976c;
        float f2 = this.f2974a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public ColorStateList getColor() {
        return this.f2981h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2977d, this.f2974a);
    }

    public float getRadius() {
        return this.f2974a;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f2981h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f2981h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f2975b.getColor();
        if (z) {
            this.f2975b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 == null || (mode = this.k) == null) {
            return z;
        }
        this.i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2975b.setAlpha(i);
    }

    public void setColor(ColorStateList colorStateList) {
        a(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2975b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.i = a(this.j, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.i = a(this.j, this.k);
        invalidateSelf();
    }

    public void a(float f2, boolean z, boolean z2) {
        if (f2 == this.f2978e && this.f2979f == z && this.f2980g == z2) {
            return;
        }
        this.f2978e = f2;
        this.f2979f = z;
        this.f2980g = z2;
        a((Rect) null);
        invalidateSelf();
    }

    public float a() {
        return this.f2978e;
    }

    private void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2976c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f2977d.set(rect);
        if (this.f2979f) {
            this.f2977d.inset((int) Math.ceil(RoundRectDrawableWithShadow.a(this.f2978e, this.f2974a, this.f2980g)), (int) Math.ceil(RoundRectDrawableWithShadow.b(this.f2978e, this.f2974a, this.f2980g)));
            this.f2976c.set(this.f2977d);
        }
    }

    public void a(float f2) {
        if (f2 == this.f2974a) {
            return;
        }
        this.f2974a = f2;
        a((Rect) null);
        invalidateSelf();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
