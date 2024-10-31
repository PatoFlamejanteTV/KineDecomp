package com.nexstreaming.kinemaster.layer.handwriting;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import com.nexstreaming.app.general.util.C1708l;
import com.nexstreaming.kinemaster.wire.KMProto;

/* loaded from: classes.dex */
public class Stroke extends b {

    /* renamed from: a */
    private static PathMeasure f20635a = new PathMeasure();

    /* renamed from: b */
    private static float[] f20636b = new float[2];

    /* renamed from: c */
    private static Path f20637c = new Path();

    /* renamed from: d */
    private static RectF f20638d = new RectF();

    /* renamed from: e */
    private static Bitmap f20639e;
    private CapDecorationStyle A;
    private CapDecorationStyle B;
    private int C;
    private float D;
    private float[] E;
    private Paint F;
    private RectF G;

    /* renamed from: f */
    private transient boolean f20640f;

    /* renamed from: g */
    private transient float f20641g;

    /* renamed from: h */
    private transient boolean f20642h;
    private transient boolean i;
    private transient Path j;
    private transient Path k;
    private transient Paint l;
    private transient int m;
    private int n;
    private float[] o;
    private float[] p;
    private transient float q;
    private transient float r;
    private transient float s;
    private transient float t;
    private PathStyle u;
    private int v;
    private float w;
    private boolean x;
    private float y;
    private boolean z;

    /* loaded from: classes.dex */
    public enum CapDecorationStyle {
        None,
        Round,
        SolidArrow,
        HollowArrow;

        public static CapDecorationStyle fromProtoBuf(KMProto.KMProject.CapDecorationStyle capDecorationStyle) {
            int i = d.f20647d[capDecorationStyle.ordinal()];
            if (i == 1) {
                return None;
            }
            if (i == 2) {
                return Round;
            }
            if (i == 3) {
                return SolidArrow;
            }
            if (i != 4) {
                return null;
            }
            return HollowArrow;
        }

        public KMProto.KMProject.CapDecorationStyle asProtoBuf() {
            int i = d.f20646c[ordinal()];
            if (i == 1) {
                return KMProto.KMProject.CapDecorationStyle.NONE;
            }
            if (i == 2) {
                return KMProto.KMProject.CapDecorationStyle.ROUND;
            }
            if (i == 3) {
                return KMProto.KMProject.CapDecorationStyle.SOLID_ARROW;
            }
            if (i != 4) {
                return null;
            }
            return KMProto.KMProject.CapDecorationStyle.HOLLOW_ARROW;
        }
    }

    public Stroke() {
        CapDecorationStyle capDecorationStyle = CapDecorationStyle.None;
        this.A = capDecorationStyle;
        this.B = capDecorationStyle;
        this.C = 0;
        this.D = 20.0f;
        this.G = new RectF();
        this.n = 0;
        this.m = 500;
        this.u = PathStyle.Smooth;
        this.w = 1.0f;
        this.y = 1.0f;
        this.v = ViewCompat.MEASURED_STATE_MASK;
        this.x = false;
        int i = this.m;
        this.o = new float[i * 2];
        this.p = new float[i];
    }

    private void d(float f2) {
        if (this.j == null) {
            this.j = new Path();
            this.f20640f = true;
        }
        if (Math.abs(this.f20641g - f2) > 1.0E-4d) {
            this.f20640f = true;
        }
        if (this.f20640f) {
            this.f20641g = f2;
            this.j.rewind();
            switch (d.f20644a[this.u.ordinal()]) {
                case 1:
                    g(f2);
                    break;
                case 2:
                    f(f2);
                    break;
                case 3:
                    c(f2);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    e(f2);
                    break;
            }
            this.i = true;
            this.f20640f = false;
        }
    }

    private void e(float f2) {
        this.j.rewind();
        int i = this.n;
        if (i < 1) {
            return;
        }
        float[] fArr = this.o;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[((i - 1) * 2) + 0];
        float f6 = fArr[((i - 1) * 2) + 1];
        RectF rectF = f20638d;
        switch (d.f20644a[this.u.ordinal()]) {
            case 4:
            case 8:
                this.j.addRect(f3 < f5 ? f3 : f5, f4 < f6 ? f4 : f6, f3 < f5 ? f5 : f3, f4 < f6 ? f6 : f4, Path.Direction.CCW);
                return;
            case 5:
                this.j.moveTo(f3, f4);
                this.j.lineTo(f5, f6);
                this.j.moveTo(f5, f4);
                this.j.lineTo(f3, f6);
                return;
            case 6:
            case 9:
                rectF.set(f3, f4, f5, f6);
                this.j.addOval(rectF, Path.Direction.CCW);
                return;
            case 7:
            case 10:
                this.j.addRect(f3 < f5 ? f3 : f5, f4 < f6 ? f4 : f6, f3 < f5 ? f5 : f3, f4 < f6 ? f6 : f4, Path.Direction.CCW);
                return;
            default:
                return;
        }
    }

    private void g(float f2) {
        int i;
        this.j.rewind();
        int i2 = this.n;
        int min = Math.min(i2, (int) (i2 * f2));
        if (min < 1) {
            return;
        }
        Path path = this.j;
        float[] fArr = this.o;
        path.moveTo(fArr[0], fArr[1]);
        if (min > 1) {
            Path path2 = this.j;
            float[] fArr2 = this.o;
            path2.lineTo((fArr2[0] + fArr2[2]) / 2.0f, (fArr2[1] + fArr2[3]) / 2.0f);
        }
        int i3 = 1;
        while (true) {
            i = min - 1;
            if (i3 >= i) {
                break;
            }
            Path path3 = this.j;
            float[] fArr3 = this.o;
            int i4 = i3 * 2;
            int i5 = i4 + 1;
            i3++;
            int i6 = i3 * 2;
            path3.quadTo(fArr3[i4], fArr3[i5], (fArr3[i4] + fArr3[i6]) / 2.0f, (fArr3[i5] + fArr3[i6 + 1]) / 2.0f);
        }
        if (min > 1) {
            Path path4 = this.j;
            float[] fArr4 = this.o;
            int i7 = i * 2;
            path4.lineTo(fArr4[i7], fArr4[i7 + 1]);
        }
    }

    private void h() {
        int i = this.m;
        float[] fArr = new float[i * 2 * 2];
        float[] fArr2 = new float[i * 2];
        System.arraycopy(this.o, 0, fArr, 0, this.n * 2);
        System.arraycopy(this.p, 0, fArr2, 0, this.n);
        this.m *= 2;
        this.o = fArr;
        this.p = fArr2;
    }

    private static void i() {
        if (f20639e == null) {
            f20639e = Bitmap.createBitmap(40, 40, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(f20639e);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
            paint.setMaskFilter(new BlurMaskFilter(5.0f, BlurMaskFilter.Blur.NORMAL));
            canvas.drawCircle(20.0f, 20.0f, 15.0f, paint);
        }
    }

    private float j() {
        double d2 = 0.0d;
        for (int i = 1; i < this.n; i++) {
            float[] fArr = this.o;
            int i2 = (i - 1) * 2;
            float f2 = fArr[i2];
            float f3 = fArr[i2 + 1];
            int i3 = i * 2;
            d2 += Math.hypot(fArr[i3] - f2, fArr[i3 + 1] - f3);
        }
        return (float) d2;
    }

    public void a(float f2, float f3, Rect rect, float f4) {
        CapDecorationStyle capDecorationStyle;
        float f5;
        CapDecorationStyle capDecorationStyle2 = this.A;
        if ((capDecorationStyle2 == null || capDecorationStyle2 == CapDecorationStyle.None) && ((capDecorationStyle = this.B) == null || capDecorationStyle == CapDecorationStyle.None)) {
            f5 = this.z ? 2.0f : 1.0f;
        } else {
            f5 = 7.0f;
        }
        if (this.z && this.n > 1) {
            if (rect != null) {
                float f6 = this.w * f5;
                for (int i = 0; i < this.n; i++) {
                    float[] fArr = this.o;
                    int i2 = i * 2;
                    float f7 = fArr[i2];
                    float f8 = fArr[i2 + 1];
                    rect.union((int) ((f7 - f6) - 1.0f), (int) ((f8 - f6) - 1.0f), (int) (f7 + f6 + 1.0f), (int) (f8 + f6 + 1.0f));
                }
            }
            this.n = 1;
        }
        if (this.n >= this.m) {
            h();
        }
        if (rect != null) {
            float f9 = this.w * f5;
            rect.union((int) ((f2 - f9) - 1.0f), (int) ((f3 - f9) - 1.0f), (int) (f2 + f9 + 1.0f), (int) (f3 + f9 + 1.0f));
            int i3 = this.n;
            if (i3 > 0) {
                float[] fArr2 = this.o;
                float f10 = fArr2[(i3 - 1) * 2];
                float f11 = fArr2[((i3 - 1) * 2) + 1];
                rect.union((int) ((f10 - f9) - 1.0f), (int) ((f11 - f9) - 1.0f), (int) (f10 + f9 + 1.0f), (int) (f11 + f9 + 1.0f));
            }
            int i4 = this.n;
            if (i4 > 1) {
                float[] fArr3 = this.o;
                float f12 = fArr3[(i4 - 2) * 2];
                float f13 = fArr3[((i4 - 2) * 2) + 1];
                rect.union((int) ((f12 - f9) - 1.0f), (int) ((f13 - f9) - 1.0f), (int) (f12 + f9 + 1.0f), (int) (f13 + f9 + 1.0f));
            }
        }
        float[] fArr4 = this.o;
        int i5 = this.n;
        fArr4[i5 * 2] = f2;
        fArr4[(i5 * 2) + 1] = f3;
        this.p[i5] = f4;
        this.n = i5 + 1;
        this.f20640f = true;
    }

    public void b(boolean z) {
        this.z = z;
        this.f20640f = true;
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public boolean b() {
        return false;
    }

    public void c() {
        this.n = 0;
        this.f20640f = true;
    }

    public Path f() {
        d(1.0f);
        return this.j;
    }

    /* loaded from: classes.dex */
    public enum PathStyle {
        Smooth,
        Sharp,
        Interpolated,
        Rect,
        RoundRect,
        Ellipse,
        XShape,
        FillRect(true),
        FillRoundRect(true),
        FillEllipse(true);

        public final boolean filled;

        PathStyle() {
            this.filled = false;
        }

        public static PathStyle fromsProtoBuf(KMProto.KMProject.PathStyle pathStyle) {
            switch (d.f20645b[pathStyle.ordinal()]) {
                case 1:
                    return Smooth;
                case 2:
                    return Sharp;
                case 3:
                    return Rect;
                case 4:
                    return XShape;
                case 5:
                    return Ellipse;
                case 6:
                    return RoundRect;
                case 7:
                    return FillRect;
                case 8:
                    return FillEllipse;
                case 9:
                    return FillRoundRect;
                default:
                    return null;
            }
        }

        public KMProto.KMProject.PathStyle asProtoBuf() {
            switch (d.f20644a[ordinal()]) {
                case 1:
                    return KMProto.KMProject.PathStyle.SMOOTH;
                case 2:
                    return KMProto.KMProject.PathStyle.SHARP;
                case 3:
                    return KMProto.KMProject.PathStyle.SHARP;
                case 4:
                    return KMProto.KMProject.PathStyle.RECT;
                case 5:
                    return KMProto.KMProject.PathStyle.XSHAPE;
                case 6:
                    return KMProto.KMProject.PathStyle.ELLIPSE;
                case 7:
                    return KMProto.KMProject.PathStyle.ROUND_RECT;
                case 8:
                    return KMProto.KMProject.PathStyle.FILL_RECT;
                case 9:
                    return KMProto.KMProject.PathStyle.FILL_ELLIPSE;
                case 10:
                    return KMProto.KMProject.PathStyle.FILL_ROUND_RECT;
                default:
                    return null;
            }
        }

        PathStyle(boolean z) {
            this.filled = z;
        }
    }

    private void b(float f2, float f3) {
        if (this.k == null) {
            this.k = new Path();
        }
        f20635a.setPath(this.j, false);
        this.k.rewind();
        PathMeasure pathMeasure = f20635a;
        pathMeasure.getSegment(pathMeasure.getLength() * f2, f20635a.getLength() * f3, this.k, true);
        this.k.rLineTo(0.0f, 0.0f);
    }

    private void c(float f2) {
        this.C = ((int) Math.ceil(j() / this.D)) + 1 + this.n;
        float[] fArr = this.E;
        if (fArr == null || fArr.length < this.C * 3) {
            this.E = new float[Math.max(500, this.C * 3 * 2)];
        }
        int i = 0;
        float f3 = 0.0f;
        for (int i2 = 1; i2 < this.n; i2++) {
            float[] fArr2 = this.o;
            int i3 = i2 - 1;
            int i4 = i3 * 2;
            float f4 = fArr2[i4];
            float f5 = fArr2[i4 + 1];
            float[] fArr3 = this.p;
            float f6 = fArr3[i3];
            int i5 = i2 * 2;
            float f7 = fArr2[i5];
            float f8 = fArr2[i5 + 1];
            float f9 = fArr3[i2];
            float f10 = f7 - f4;
            float f11 = f8 - f5;
            float hypot = (float) Math.hypot(f10, f11);
            if (f3 > hypot) {
                f3 -= hypot;
            } else {
                float f12 = f3;
                while (f3 < hypot) {
                    float f13 = f3 / hypot;
                    float[] fArr4 = this.E;
                    int i6 = i * 3;
                    fArr4[i6] = (f10 * f13) + f4;
                    fArr4[i6 + 1] = f5 + (f11 * f13);
                    fArr4[i6 + 2] = ((f9 - f6) * f13) + f6;
                    i++;
                    f12 = hypot - f3;
                    f3 += this.D;
                }
                f3 = f12;
            }
        }
        this.C = i;
    }

    private void f(float f2) {
        this.j.rewind();
        int i = this.n;
        int min = Math.min(i, (int) (i * f2));
        if (min < 1) {
            return;
        }
        Path path = this.j;
        float[] fArr = this.o;
        path.moveTo(fArr[0], fArr[1]);
        for (int i2 = 1; i2 < min; i2++) {
            Path path2 = this.j;
            float[] fArr2 = this.o;
            int i3 = i2 * 2;
            path2.lineTo(fArr2[i3], fArr2[i3 + 1]);
        }
    }

    public float g() {
        return this.w;
    }

    public void b(CapDecorationStyle capDecorationStyle) {
        this.A = capDecorationStyle;
        this.f20640f = true;
    }

    private void b(Canvas canvas, float f2, float f3) {
        int i = this.C;
        int min = Math.min(i, (int) (i * f2)) + 1;
        int i2 = this.C;
        int min2 = Math.min(i2, (int) (i2 * f3));
        if (min2 < 1 || min >= min2) {
            return;
        }
        if (this.F == null) {
            this.F = new Paint();
            this.F.setAntiAlias(true);
            this.F.setStyle(Paint.Style.FILL);
            this.F.setStrokeCap(Paint.Cap.ROUND);
        }
        if (f20639e == null) {
            i();
        }
        this.F.setColor(this.v);
        for (int i3 = min + 1; i3 < min2; i3++) {
            float[] fArr = this.E;
            int i4 = (i3 - 1) * 3;
            float f4 = fArr[i4];
            float f5 = fArr[i4 + 1];
            float f6 = fArr[i4 + 2];
            int i5 = i3 * 3;
            float f7 = fArr[i5];
            float f8 = fArr[i5 + 1];
            float f9 = fArr[i5 + 2];
            float f10 = f7 - f4;
            float f11 = f8 - f5;
            float ceil = (float) (Math.ceil(Math.hypot(f10, f11)) / 2.0d);
            float f12 = 0.0f;
            if (ceil > 0.0f) {
                while (f12 < 1.0f) {
                    float f13 = (this.w * (((((f9 - f6) * f12) + f6) * 0.95f) + 0.05f)) / 2.0f;
                    float f14 = (f10 * f12) + f4;
                    float f15 = (f11 * f12) + f5;
                    this.G.set(f14 - f13, f15 - f13, f14 + f13, f15 + f13);
                    canvas.drawBitmap(f20639e, (Rect) null, this.G, this.F);
                    f12 += 1.0f / ceil;
                    f9 = f9;
                }
            }
        }
    }

    public Stroke(Stroke stroke) {
        CapDecorationStyle capDecorationStyle = CapDecorationStyle.None;
        this.A = capDecorationStyle;
        this.B = capDecorationStyle;
        this.C = 0;
        this.D = 20.0f;
        this.G = new RectF();
        this.n = stroke.n;
        int i = this.n;
        this.m = i;
        int i2 = this.m;
        this.o = new float[i2 * 2];
        this.p = new float[i2];
        this.u = stroke.u;
        this.v = stroke.v;
        this.w = stroke.w;
        this.x = stroke.x;
        this.y = stroke.y;
        this.z = stroke.z;
        this.A = stroke.A;
        this.B = stroke.B;
        System.arraycopy(stroke.o, 0, this.o, 0, i * 2);
        System.arraycopy(stroke.p, 0, this.p, 0, this.n);
    }

    public int d() {
        return this.v;
    }

    public Paint e() {
        if (this.l == null) {
            this.l = new Paint();
            this.l.setAntiAlias(true);
            this.l.setStyle(Paint.Style.STROKE);
            this.l.setStrokeJoin(Paint.Join.ROUND);
            this.l.setStrokeCap(Paint.Cap.ROUND);
            this.f20642h = true;
        }
        if (this.f20642h) {
            this.l.setColor(this.v);
            this.l.setStrokeWidth(this.w);
            if (this.x) {
                this.l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            } else {
                this.l.setXfermode(null);
            }
            float f2 = this.y;
            if (f2 < 1.0f) {
                this.l.setMaskFilter(new BlurMaskFilter((1.0f - f2) * this.w, BlurMaskFilter.Blur.NORMAL));
            } else {
                this.l.setMaskFilter(null);
            }
            if (this.u.filled) {
                this.l.setStyle(Paint.Style.FILL);
            } else {
                this.l.setStyle(Paint.Style.STROKE);
            }
            this.f20642h = false;
        }
        return this.l;
    }

    private Path a(float f2, float f3) {
        d(1.0f);
        if (f3 >= 1.0f) {
            return this.j;
        }
        b(f2, f3);
        return this.k;
    }

    public void b(KMProto.KMProject.DrawingAction drawingAction) {
        this.o = C1708l.a(drawingAction.points);
        this.v = drawingAction.color.intValue();
        this.w = drawingAction.stroke_width.floatValue();
        this.y = drawingAction.hardness.floatValue();
        this.x = drawingAction.is_eraser.booleanValue();
        this.z = drawingAction.straight_line.booleanValue();
        this.u = PathStyle.fromsProtoBuf(drawingAction.path_style);
        this.A = CapDecorationStyle.fromProtoBuf(drawingAction.start_cap);
        this.B = CapDecorationStyle.fromProtoBuf(drawingAction.end_cap);
        this.n = drawingAction.points.size() / 2;
        this.m = this.n;
        this.f20642h = true;
        this.f20640f = true;
        this.i = true;
    }

    public void a(PathStyle pathStyle) {
        PathStyle pathStyle2 = this.u;
        if (pathStyle2 != pathStyle) {
            if (pathStyle.filled != pathStyle2.filled) {
                this.f20642h = true;
            }
            this.u = pathStyle;
            this.f20640f = true;
        }
    }

    public void a(CapDecorationStyle capDecorationStyle) {
        this.B = capDecorationStyle;
        this.f20640f = true;
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public void a(Canvas canvas) {
        a(canvas, 1.0f);
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public void a(Canvas canvas, float f2) {
        a(canvas, 0.0f, f2);
    }

    public void a(Canvas canvas, float f2, float f3) {
        if (this.u == PathStyle.Interpolated) {
            d(1.0f);
            b(canvas, f2, f3);
            return;
        }
        canvas.drawPath(a(f2, f3), e());
        if (this.B == CapDecorationStyle.SolidArrow && f3 == 1.0f) {
            float f4 = this.w * 6.0f;
            float f5 = ((f4 * 3.0f) / 4.0f) / 2.0f;
            f20635a.setPath(f(), false);
            float length = f20635a.getLength();
            f20635a.getPosTan(length - f4, f20636b, null);
            float[] fArr = f20636b;
            float f6 = fArr[0];
            float f7 = fArr[1];
            f20635a.getPosTan(length, fArr, null);
            float[] fArr2 = f20636b;
            float f8 = fArr2[0];
            float f9 = fArr2[1];
            float f10 = f8 - f6;
            float f11 = f9 - f7;
            float sqrt = (float) Math.sqrt((f10 * f10) + (f11 * f11));
            if (sqrt == 0.0f) {
                sqrt = 1.0E-8f;
            }
            float f12 = f10 / sqrt;
            float f13 = f11 / sqrt;
            float f14 = this.w;
            float f15 = f12 * f14 * 2.0f;
            float f16 = f14 * f13 * 2.0f;
            float f17 = f12 * f5;
            float f18 = -(f5 * f13);
            f20637c.rewind();
            f20637c.moveTo(f6 + f18 + f15, f7 + f17 + f16);
            f20637c.lineTo(f8 + f15, f9 + f16);
            f20637c.lineTo((f6 - f18) + f15, (f7 - f17) + f16);
            f20637c.close();
            Paint.Style style = this.l.getStyle();
            this.l.setStyle(Paint.Style.FILL);
            canvas.drawPath(f20637c, this.l);
            this.l.setStyle(style);
        }
        if (this.A == CapDecorationStyle.SolidArrow) {
            float f19 = this.w * 6.0f;
            float f20 = ((3.0f * f19) / 4.0f) / 2.0f;
            f20635a.setPath(f(), false);
            f20635a.getLength();
            f20635a.getPosTan(0.0f, f20636b, null);
            float[] fArr3 = f20636b;
            float f21 = fArr3[0];
            float f22 = fArr3[1];
            f20635a.getPosTan(f19, fArr3, null);
            float[] fArr4 = f20636b;
            float f23 = fArr4[0];
            float f24 = fArr4[1];
            float f25 = f21 - f23;
            float f26 = f22 - f24;
            float sqrt2 = (float) Math.sqrt((f25 * f25) + (f26 * f26));
            if (sqrt2 == 0.0f) {
                sqrt2 = 1.0E-8f;
            }
            float f27 = f25 / sqrt2;
            float f28 = f26 / sqrt2;
            float f29 = this.w;
            float f30 = f27 * f29 * 2.0f;
            float f31 = f29 * f28 * 2.0f;
            float f32 = f27 * f20;
            float f33 = -(f28 * f20);
            f20637c.rewind();
            f20637c.moveTo(f23 + f33 + f30, f24 + f32 + f31);
            f20637c.lineTo(f21 + f30, f22 + f31);
            f20637c.lineTo((f23 - f33) + f30, (f24 - f32) + f31);
            f20637c.close();
            Paint.Style style2 = this.l.getStyle();
            this.l.setStyle(Paint.Style.FILL);
            canvas.drawPath(f20637c, this.l);
            this.l.setStyle(style2);
        }
    }

    public void b(float f2) {
        this.w = f2;
        this.f20642h = true;
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public void a(RectF rectF) {
        CapDecorationStyle capDecorationStyle;
        if (rectF == null) {
            return;
        }
        if (this.n == 0) {
            rectF.setEmpty();
            return;
        }
        float f2 = 1.0f;
        d(1.0f);
        if (this.i) {
            if (this.u == PathStyle.Interpolated) {
                rectF.setEmpty();
                for (int i = 0; i < this.C; i++) {
                    float[] fArr = this.E;
                    int i2 = i * 3;
                    float f3 = fArr[i2];
                    float f4 = fArr[i2 + 1];
                    float f5 = this.w;
                    rectF.union(f3 - f5, f4 - f5, f3 + f5, f4 + f5);
                }
                this.q = rectF.left;
                this.r = rectF.top;
                this.s = rectF.right;
                this.t = rectF.bottom;
                this.i = false;
                return;
            }
            CapDecorationStyle capDecorationStyle2 = this.A;
            if ((capDecorationStyle2 != null && capDecorationStyle2 != CapDecorationStyle.None) || ((capDecorationStyle = this.B) != null && capDecorationStyle != CapDecorationStyle.None)) {
                f2 = 7.0f;
            }
            f().computeBounds(rectF, true);
            float f6 = rectF.left;
            float f7 = this.w;
            rectF.left = f6 - (f7 * f2);
            rectF.right += f7 * f2;
            rectF.top -= f7 * f2;
            rectF.bottom += f7 * f2;
            this.q = rectF.left;
            this.r = rectF.top;
            this.s = rectF.right;
            this.t = rectF.bottom;
            this.i = false;
            return;
        }
        rectF.left = this.q;
        rectF.top = this.r;
        rectF.right = this.s;
        rectF.bottom = this.t;
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.b
    public KMProto.KMProject.DrawingAction a() {
        KMProto.KMProject.DrawingAction.Builder builder = new KMProto.KMProject.DrawingAction.Builder();
        builder.drawing_action_type = KMProto.KMProject.DrawingActionType.STROKE;
        builder.points = C1708l.a(this.o);
        builder.color = Integer.valueOf(this.v);
        builder.stroke_width = Float.valueOf(this.w);
        builder.hardness = Float.valueOf(this.y);
        builder.is_eraser = Boolean.valueOf(this.x);
        builder.straight_line = Boolean.valueOf(this.z);
        builder.path_style = this.u.asProtoBuf();
        builder.start_cap = this.A.asProtoBuf();
        builder.end_cap = this.B.asProtoBuf();
        return builder.build();
    }

    public void a(int i) {
        this.v = i;
        this.f20642h = true;
    }

    public void a(boolean z) {
        this.x = z;
        this.f20642h = true;
    }

    public void a(float f2) {
        this.y = f2;
        this.f20642h = true;
    }
}
