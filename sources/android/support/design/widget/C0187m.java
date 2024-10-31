package android.support.design.widget;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.math.MathUtils;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;

/* compiled from: CollapsingTextHelper.java */
/* renamed from: android.support.design.widget.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0187m {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f475a;

    /* renamed from: b, reason: collision with root package name */
    private static final Paint f476b;
    private boolean A;
    private Bitmap B;
    private Paint C;
    private float D;
    private float E;
    private float F;
    private float G;
    private int[] H;
    private boolean I;
    private Interpolator K;
    private Interpolator L;
    private float M;
    private float N;
    private float O;
    private int P;
    private float Q;
    private float R;
    private float S;
    private int T;

    /* renamed from: c, reason: collision with root package name */
    private final View f477c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f478d;

    /* renamed from: e, reason: collision with root package name */
    private float f479e;
    private ColorStateList m;
    private ColorStateList n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private Typeface u;
    private Typeface v;
    private Typeface w;
    private CharSequence x;
    private CharSequence y;
    private boolean z;
    private int i = 16;
    private int j = 16;
    private float k = 15.0f;
    private float l = 15.0f;
    private final TextPaint J = new TextPaint(129);

    /* renamed from: g, reason: collision with root package name */
    private final Rect f481g = new Rect();

    /* renamed from: f, reason: collision with root package name */
    private final Rect f480f = new Rect();

    /* renamed from: h, reason: collision with root package name */
    private final RectF f482h = new RectF();

    static {
        f475a = Build.VERSION.SDK_INT < 18;
        f476b = null;
        Paint paint = f476b;
        if (paint != null) {
            paint.setAntiAlias(true);
            f476b.setColor(-65281);
        }
    }

    public C0187m(View view) {
        this.f477c = view;
    }

    private Typeface d(int i) {
        TypedArray obtainStyledAttributes = this.f477c.getContext().obtainStyledAttributes(i, new int[]{R.attr.fontFamily});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void e(float f2) {
        this.f482h.left = a(this.f480f.left, this.f481g.left, f2, this.K);
        this.f482h.top = a(this.o, this.p, f2, this.K);
        this.f482h.right = a(this.f480f.right, this.f481g.right, f2, this.K);
        this.f482h.bottom = a(this.f480f.bottom, this.f481g.bottom, f2, this.K);
    }

    private void i() {
        float f2 = this.G;
        d(this.l);
        CharSequence charSequence = this.y;
        float measureText = charSequence != null ? this.J.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.j, this.z ? 1 : 0);
        int i = absoluteGravity & 112;
        if (i == 48) {
            this.p = this.f481g.top - this.J.ascent();
        } else if (i != 80) {
            this.p = this.f481g.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.p = this.f481g.bottom;
        }
        int i2 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i2 == 1) {
            this.r = this.f481g.centerX() - (measureText / 2.0f);
        } else if (i2 != 5) {
            this.r = this.f481g.left;
        } else {
            this.r = this.f481g.right - measureText;
        }
        d(this.k);
        CharSequence charSequence2 = this.y;
        float measureText2 = charSequence2 != null ? this.J.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.i, this.z ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        if (i3 == 48) {
            this.o = this.f480f.top - this.J.ascent();
        } else if (i3 != 80) {
            this.o = this.f480f.centerY() + (((this.J.descent() - this.J.ascent()) / 2.0f) - this.J.descent());
        } else {
            this.o = this.f480f.bottom;
        }
        int i4 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i4 == 1) {
            this.q = this.f480f.centerX() - (measureText2 / 2.0f);
        } else if (i4 != 5) {
            this.q = this.f480f.left;
        } else {
            this.q = this.f480f.right - measureText2;
        }
        k();
        f(f2);
    }

    private void j() {
        c(this.f479e);
    }

    private void k() {
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            bitmap.recycle();
            this.B = null;
        }
    }

    private void l() {
        if (this.B != null || this.f480f.isEmpty() || TextUtils.isEmpty(this.y)) {
            return;
        }
        c(0.0f);
        this.D = this.J.ascent();
        this.E = this.J.descent();
        TextPaint textPaint = this.J;
        CharSequence charSequence = this.y;
        int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
        int round2 = Math.round(this.E - this.D);
        if (round <= 0 || round2 <= 0) {
            return;
        }
        this.B = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.B);
        CharSequence charSequence2 = this.y;
        canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, round2 - this.J.descent(), this.J);
        if (this.C == null) {
            this.C = new Paint(3);
        }
    }

    private int m() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.n.getColorForState(iArr, 0);
        }
        return this.n.getDefaultColor();
    }

    private int n() {
        int[] iArr = this.H;
        if (iArr != null) {
            return this.m.getColorForState(iArr, 0);
        }
        return this.m.getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Interpolator interpolator) {
        this.K = interpolator;
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Interpolator interpolator) {
        this.L = interpolator;
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i) {
        if (this.i != i) {
            this.i = i;
            h();
        }
    }

    final boolean f() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.n;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.m) != null && colorStateList.isStateful());
    }

    void g() {
        this.f478d = this.f481g.width() > 0 && this.f481g.height() > 0 && this.f480f.width() > 0 && this.f480f.height() > 0;
    }

    public void h() {
        if (this.f477c.getHeight() <= 0 || this.f477c.getWidth() <= 0) {
            return;
        }
        i();
        j();
    }

    private void f(float f2) {
        d(f2);
        this.A = f475a && this.F != 1.0f;
        if (this.A) {
            l();
        }
        ViewCompat.postInvalidateOnAnimation(this.f477c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f2) {
        if (this.k != f2) {
            this.k = f2;
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface c() {
        Typeface typeface = this.u;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    private void c(float f2) {
        e(f2);
        this.s = a(this.q, this.r, f2, this.K);
        this.t = a(this.o, this.p, f2, this.K);
        f(a(this.k, this.l, f2, this.L));
        if (this.n != this.m) {
            this.J.setColor(a(n(), m(), f2));
        } else {
            this.J.setColor(m());
        }
        this.J.setShadowLayer(a(this.Q, this.M, f2, (Interpolator) null), a(this.R, this.N, f2, (Interpolator) null), a(this.S, this.O, f2, (Interpolator) null), a(this.T, this.P, f2));
        ViewCompat.postInvalidateOnAnimation(this.f477c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f479e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence e() {
        return this.x;
    }

    private void d(float f2) {
        float f3;
        boolean z;
        boolean z2;
        if (this.x == null) {
            return;
        }
        float width = this.f481g.width();
        float width2 = this.f480f.width();
        if (a(f2, this.l)) {
            float f4 = this.l;
            this.F = 1.0f;
            if (a(this.w, this.u)) {
                this.w = this.u;
                z2 = true;
            } else {
                z2 = false;
            }
            f3 = f4;
            z = z2;
        } else {
            f3 = this.k;
            if (a(this.w, this.v)) {
                this.w = this.v;
                z = true;
            } else {
                z = false;
            }
            if (a(f2, this.k)) {
                this.F = 1.0f;
            } else {
                this.F = f2 / this.k;
            }
            float f5 = this.l / this.k;
            width = width2 * f5 > width ? Math.min(width / f5, width2) : width2;
        }
        if (width > 0.0f) {
            z = this.G != f3 || this.I || z;
            this.G = f3;
            this.I = false;
        }
        if (this.y == null || z) {
            this.J.setTextSize(this.G);
            this.J.setTypeface(this.w);
            this.J.setLinearText(this.F != 1.0f);
            CharSequence ellipsize = TextUtils.ellipsize(this.x, this.J, width, TextUtils.TruncateAt.END);
            if (TextUtils.equals(ellipsize, this.y)) {
                return;
            }
            this.y = ellipsize;
            this.z = b(this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.n != colorStateList) {
            this.n = colorStateList;
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, int i2, int i3, int i4) {
        if (a(this.f480f, i, i2, i3, i4)) {
            return;
        }
        this.f480f.set(i, i2, i3, i4);
        this.I = true;
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, int i4) {
        if (a(this.f481g, i, i2, i3, i4)) {
            return;
        }
        this.f481g.set(i, i2, i3, i4);
        this.I = true;
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        if (this.j != i) {
            this.j = i;
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f477c.getContext(), i, android.support.v7.appcompat.R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor)) {
            this.n = obtainStyledAttributes.getColorStateList(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
        }
        if (obtainStyledAttributes.hasValue(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize)) {
            this.l = obtainStyledAttributes.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, (int) this.l);
        }
        this.P = obtainStyledAttributes.getInt(android.support.v7.appcompat.R.styleable.TextAppearance_android_shadowColor, 0);
        this.N = obtainStyledAttributes.getFloat(android.support.v7.appcompat.R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.O = obtainStyledAttributes.getFloat(android.support.v7.appcompat.R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.M = obtainStyledAttributes.getFloat(android.support.v7.appcompat.R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.u = d(i);
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f2) {
        float clamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        if (clamp != this.f479e) {
            this.f479e = clamp;
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.l;
    }

    private boolean b(CharSequence charSequence) {
        return (ViewCompat.getLayoutDirection(this.f477c) == 1 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Typeface typeface) {
        this.v = typeface;
        this.u = typeface;
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(int[] iArr) {
        this.H = iArr;
        if (!f()) {
            return false;
        }
        h();
        return true;
    }

    public void a(Canvas canvas) {
        float ascent;
        int save = canvas.save();
        if (this.y != null && this.f478d) {
            float f2 = this.s;
            float f3 = this.t;
            boolean z = this.A && this.B != null;
            if (z) {
                ascent = this.D * this.F;
                float f4 = this.E;
            } else {
                ascent = this.J.ascent() * this.F;
                this.J.descent();
                float f5 = this.F;
            }
            if (z) {
                f3 += ascent;
            }
            float f6 = f3;
            float f7 = this.F;
            if (f7 != 1.0f) {
                canvas.scale(f7, f7, f2, f6);
            }
            if (z) {
                canvas.drawBitmap(this.B, f2, f6, this.C);
            } else {
                CharSequence charSequence = this.y;
                canvas.drawText(charSequence, 0, charSequence.length(), f2, f6, this.J);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean a(Typeface typeface, Typeface typeface2) {
        return !(typeface == null || typeface.equals(typeface2)) || (typeface == null && typeface2 != null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.x)) {
            this.x = charSequence;
            this.y = null;
            k();
            h();
        }
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a() {
        return this.n;
    }

    private static int a(int i, int i2, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i) * f3) + (Color.alpha(i2) * f2)), (int) ((Color.red(i) * f3) + (Color.red(i2) * f2)), (int) ((Color.green(i) * f3) + (Color.green(i2) * f2)), (int) ((Color.blue(i) * f3) + (Color.blue(i2) * f2)));
    }

    private static float a(float f2, float f3, float f4, Interpolator interpolator) {
        if (interpolator != null) {
            f4 = interpolator.getInterpolation(f4);
        }
        return C0175a.a(f2, f3, f4);
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
