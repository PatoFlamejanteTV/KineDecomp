package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.R;

/* loaded from: classes.dex */
class RoundRectDrawableWithShadow extends Drawable {

    /* renamed from: a */
    private static final double f2982a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b */
    static RoundRectHelper f2983b;

    /* renamed from: c */
    private final int f2984c;

    /* renamed from: e */
    private Paint f2986e;

    /* renamed from: f */
    private Paint f2987f;

    /* renamed from: g */
    private final RectF f2988g;

    /* renamed from: h */
    private float f2989h;
    private Path i;
    private float j;
    private float k;
    private float l;
    private ColorStateList m;
    private final int o;
    private final int p;
    private boolean n = true;
    private boolean q = true;
    private boolean r = false;

    /* renamed from: d */
    private Paint f2985d = new Paint(5);

    /* loaded from: classes.dex */
    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.o = resources.getColor(R.color.cardview_shadow_start_color);
        this.p = resources.getColor(R.color.cardview_shadow_end_color);
        this.f2984c = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        b(colorStateList);
        this.f2986e = new Paint(5);
        this.f2986e.setStyle(Paint.Style.FILL);
        this.f2989h = (int) (f2 + 0.5f);
        this.f2988g = new RectF();
        this.f2987f = new Paint(this.f2986e);
        this.f2987f.setAntiAlias(false);
        a(f3, f4);
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.m = colorStateList;
        this.f2985d.setColor(this.m.getColorForState(getState(), this.m.getDefaultColor()));
    }

    private int d(float f2) {
        int i = (int) (f2 + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    private void g() {
        float f2 = this.f2989h;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.k;
        rectF2.inset(-f3, -f3);
        Path path = this.i;
        if (path == null) {
            this.i = new Path();
        } else {
            path.reset();
        }
        this.i.setFillType(Path.FillType.EVEN_ODD);
        this.i.moveTo(-this.f2989h, 0.0f);
        this.i.rLineTo(-this.k, 0.0f);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        float f4 = this.f2989h;
        float f5 = this.k;
        float f6 = f4 / (f4 + f5);
        Paint paint = this.f2986e;
        float f7 = f4 + f5;
        int i = this.o;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f7, new int[]{i, i, this.p}, new float[]{0.0f, f6, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f2987f;
        float f8 = this.f2989h;
        float f9 = this.k;
        int i2 = this.o;
        paint2.setShader(new LinearGradient(0.0f, (-f8) + f9, 0.0f, (-f8) - f9, new int[]{i2, i2, this.p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f2987f.setAntiAlias(false);
    }

    public void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    public void c(float f2) {
        a(f2, this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            b(getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.l / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.l) / 2.0f);
        f2983b.drawRoundRect(canvas, this.f2988g, this.f2989h, this.f2985d);
    }

    public float e() {
        float f2 = this.j;
        return (Math.max(f2, this.f2989h + this.f2984c + (f2 / 2.0f)) * 2.0f) + ((this.j + this.f2984c) * 2.0f);
    }

    public float f() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(b(this.j, this.f2989h, this.q));
        int ceil2 = (int) Math.ceil(a(this.j, this.f2989h, this.q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f2985d.getColor() == colorForState) {
            return false;
        }
        this.f2985d.setColor(colorForState);
        this.n = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2985d.setAlpha(i);
        this.f2986e.setAlpha(i);
        this.f2987f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2985d.setColorFilter(colorFilter);
    }

    public float c() {
        return this.j;
    }

    public float d() {
        float f2 = this.j;
        return (Math.max(f2, this.f2989h + this.f2984c + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.j * 1.5f) + this.f2984c) * 2.0f);
    }

    private void a(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        }
        if (f3 >= 0.0f) {
            float d2 = d(f2);
            float d3 = d(f3);
            if (d2 > d3) {
                if (!this.r) {
                    this.r = true;
                }
                d2 = d3;
            }
            if (this.l == d2 && this.j == d3) {
                return;
            }
            this.l = d2;
            this.j = d3;
            this.k = (int) ((d2 * 1.5f) + this.f2984c + 0.5f);
            this.n = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
    }

    public static float b(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        double d2 = f2 * 1.5f;
        double d3 = 1.0d - f2982a;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    private void b(Rect rect) {
        float f2 = this.j;
        float f3 = 1.5f * f2;
        this.f2988g.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        g();
    }

    public float b() {
        return this.f2989h;
    }

    public void b(float f2) {
        a(this.l, f2);
    }

    public static float a(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        double d2 = f2;
        double d3 = 1.0d - f2982a;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    public void a(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
        }
        float f3 = (int) (f2 + 0.5f);
        if (this.f2989h == f3) {
            return;
        }
        this.f2989h = f3;
        this.n = true;
        invalidateSelf();
    }

    private void a(Canvas canvas) {
        float f2 = this.f2989h;
        float f3 = (-f2) - this.k;
        float f4 = f2 + this.f2984c + (this.l / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.f2988g.width() - f5 > 0.0f;
        boolean z2 = this.f2988g.height() - f5 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.f2988g;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.i, this.f2986e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f2988g.width() - f5, -this.f2989h, this.f2987f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.f2988g;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.f2986e);
        if (z) {
            canvas.drawRect(0.0f, f3, this.f2988g.width() - f5, (-this.f2989h) + this.k, this.f2987f);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.f2988g;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.f2986e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f2988g.height() - f5, -this.f2989h, this.f2987f);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.f2988g;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.f2986e);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.f2988g.height() - f5, -this.f2989h, this.f2987f);
        }
        canvas.restoreToCount(save4);
    }

    public void a(Rect rect) {
        getPadding(rect);
    }

    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    public ColorStateList a() {
        return this.m;
    }
}
