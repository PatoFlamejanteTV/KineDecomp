package android.support.v7.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.appcompat.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;

    /* renamed from: a */
    private static final float f2254a = (float) Math.toRadians(45.0d);

    /* renamed from: c */
    private float f2256c;

    /* renamed from: d */
    private float f2257d;

    /* renamed from: e */
    private float f2258e;

    /* renamed from: f */
    private float f2259f;

    /* renamed from: g */
    private boolean f2260g;
    private final int i;
    private float k;
    private float l;

    /* renamed from: b */
    private final Paint f2255b = new Paint();

    /* renamed from: h */
    private final Path f2261h = new Path();
    private boolean j = false;
    private int m = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        this.f2255b.setStyle(Paint.Style.STROKE);
        this.f2255b.setStrokeJoin(Paint.Join.MITER);
        this.f2255b.setStrokeCap(Paint.Cap.BUTT);
        this.f2255b.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f2257d = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f2256c = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f2258e = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float a(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.m;
        boolean z = false;
        if (i != 0 && (i == 1 || (i == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z = true;
        }
        float f2 = this.f2256c;
        float a2 = a(this.f2257d, (float) Math.sqrt(f2 * f2 * 2.0f), this.k);
        float a3 = a(this.f2257d, this.f2258e, this.k);
        float round = Math.round(a(0.0f, this.l, this.k));
        float a4 = a(0.0f, f2254a, this.k);
        float a5 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.k);
        double d2 = a2;
        double d3 = a4;
        double cos = Math.cos(d3);
        Double.isNaN(d2);
        boolean z2 = z;
        float round2 = (float) Math.round(cos * d2);
        double sin = Math.sin(d3);
        Double.isNaN(d2);
        float round3 = (float) Math.round(d2 * sin);
        this.f2261h.rewind();
        float a6 = a(this.f2259f + this.f2255b.getStrokeWidth(), -this.l, this.k);
        float f3 = (-a3) / 2.0f;
        this.f2261h.moveTo(f3 + round, 0.0f);
        this.f2261h.rLineTo(a3 - (round * 2.0f), 0.0f);
        this.f2261h.moveTo(f3, a6);
        this.f2261h.rLineTo(round2, round3);
        this.f2261h.moveTo(f3, -a6);
        this.f2261h.rLineTo(round2, -round3);
        this.f2261h.close();
        canvas.save();
        float strokeWidth = this.f2255b.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.f2259f);
        if (this.f2260g) {
            canvas.rotate(a5 * (this.j ^ z2 ? -1 : 1));
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f2261h, this.f2255b);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.f2256c;
    }

    public float getArrowShaftLength() {
        return this.f2258e;
    }

    public float getBarLength() {
        return this.f2257d;
    }

    public float getBarThickness() {
        return this.f2255b.getStrokeWidth();
    }

    public int getColor() {
        return this.f2255b.getColor();
    }

    public int getDirection() {
        return this.m;
    }

    public float getGapSize() {
        return this.f2259f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.f2255b;
    }

    public float getProgress() {
        return this.k;
    }

    public boolean isSpinEnabled() {
        return this.f2260g;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f2255b.getAlpha()) {
            this.f2255b.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f2) {
        if (this.f2256c != f2) {
            this.f2256c = f2;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f2) {
        if (this.f2258e != f2) {
            this.f2258e = f2;
            invalidateSelf();
        }
    }

    public void setBarLength(float f2) {
        if (this.f2257d != f2) {
            this.f2257d = f2;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f2) {
        if (this.f2255b.getStrokeWidth() != f2) {
            this.f2255b.setStrokeWidth(f2);
            double d2 = f2 / 2.0f;
            double cos = Math.cos(f2254a);
            Double.isNaN(d2);
            this.l = (float) (d2 * cos);
            invalidateSelf();
        }
    }

    public void setColor(int i) {
        if (i != this.f2255b.getColor()) {
            this.f2255b.setColor(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2255b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i) {
        if (i != this.m) {
            this.m = i;
            invalidateSelf();
        }
    }

    public void setGapSize(float f2) {
        if (f2 != this.f2259f) {
            this.f2259f = f2;
            invalidateSelf();
        }
    }

    public void setProgress(float f2) {
        if (this.k != f2) {
            this.k = f2;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z) {
        if (this.f2260g != z) {
            this.f2260g = z;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z) {
        if (this.j != z) {
            this.j = z;
            invalidateSelf();
        }
    }
}
