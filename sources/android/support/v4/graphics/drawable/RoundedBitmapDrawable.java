package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

/* loaded from: classes.dex */
public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: a */
    final Bitmap f1153a;

    /* renamed from: b */
    private int f1154b;

    /* renamed from: e */
    private final BitmapShader f1157e;

    /* renamed from: g */
    private float f1159g;
    private boolean k;
    private int l;
    private int m;

    /* renamed from: c */
    private int f1155c = 119;

    /* renamed from: d */
    private final Paint f1156d = new Paint(3);

    /* renamed from: f */
    private final Matrix f1158f = new Matrix();

    /* renamed from: h */
    final Rect f1160h = new Rect();
    private final RectF i = new RectF();
    private boolean j = true;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.f1154b = 160;
        if (resources != null) {
            this.f1154b = resources.getDisplayMetrics().densityDpi;
        }
        this.f1153a = bitmap;
        if (this.f1153a != null) {
            b();
            Bitmap bitmap2 = this.f1153a;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f1157e = new BitmapShader(bitmap2, tileMode, tileMode);
            return;
        }
        this.m = -1;
        this.l = -1;
        this.f1157e = null;
    }

    private static boolean a(float f2) {
        return f2 > 0.05f;
    }

    private void b() {
        this.l = this.f1153a.getScaledWidth(this.f1154b);
        this.m = this.f1153a.getScaledHeight(this.f1154b);
    }

    private void c() {
        this.f1159g = Math.min(this.m, this.l) / 2;
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f1153a;
        if (bitmap == null) {
            return;
        }
        a();
        if (this.f1156d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f1160h, this.f1156d);
            return;
        }
        RectF rectF = this.i;
        float f2 = this.f1159g;
        canvas.drawRoundRect(rectF, f2, f2, this.f1156d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1156d.getAlpha();
    }

    public final Bitmap getBitmap() {
        return this.f1153a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f1156d.getColorFilter();
    }

    public float getCornerRadius() {
        return this.f1159g;
    }

    public int getGravity() {
        return this.f1155c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f1155c != 119 || this.k || (bitmap = this.f1153a) == null || bitmap.hasAlpha() || this.f1156d.getAlpha() < 255 || a(this.f1159g)) ? -3 : -1;
    }

    public final Paint getPaint() {
        return this.f1156d;
    }

    public boolean hasAntiAlias() {
        return this.f1156d.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            c();
        }
        this.j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f1156d.getAlpha()) {
            this.f1156d.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z) {
        this.f1156d.setAntiAlias(z);
        invalidateSelf();
    }

    public void setCircular(boolean z) {
        this.k = z;
        this.j = true;
        if (z) {
            c();
            this.f1156d.setShader(this.f1157e);
            invalidateSelf();
            return;
        }
        setCornerRadius(0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1156d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f2) {
        if (this.f1159g == f2) {
            return;
        }
        this.k = false;
        if (a(f2)) {
            this.f1156d.setShader(this.f1157e);
        } else {
            this.f1156d.setShader(null);
        }
        this.f1159g = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1156d.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1156d.setFilterBitmap(z);
        invalidateSelf();
    }

    public void setGravity(int i) {
        if (this.f1155c != i) {
            this.f1155c = i;
            this.j = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void a() {
        if (this.j) {
            if (this.k) {
                int min = Math.min(this.l, this.m);
                a(this.f1155c, min, min, getBounds(), this.f1160h);
                int min2 = Math.min(this.f1160h.width(), this.f1160h.height());
                this.f1160h.inset(Math.max(0, (this.f1160h.width() - min2) / 2), Math.max(0, (this.f1160h.height() - min2) / 2));
                this.f1159g = min2 * 0.5f;
            } else {
                a(this.f1155c, this.l, this.m, getBounds(), this.f1160h);
            }
            this.i.set(this.f1160h);
            if (this.f1157e != null) {
                Matrix matrix = this.f1158f;
                RectF rectF = this.i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f1158f.preScale(this.i.width() / this.f1153a.getWidth(), this.i.height() / this.f1153a.getHeight());
                this.f1157e.setLocalMatrix(this.f1158f);
                this.f1156d.setShader(this.f1157e);
            }
            this.j = false;
        }
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i) {
        if (this.f1154b != i) {
            if (i == 0) {
                i = 160;
            }
            this.f1154b = i;
            if (this.f1153a != null) {
                b();
            }
            invalidateSelf();
        }
    }
}
