package com.nexstreaming.kinemaster.layer.handwriting;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.nexstreaming.app.general.util.h;
import com.nexstreaming.kinemaster.wire.KMProto;

/* loaded from: classes.dex */
public class Stroke extends a {
    private static PathMeasure w = new PathMeasure();
    private static float[] x = new float[2];
    private static Path y = new Path();
    private static RectF z = new RectF();

    /* renamed from: a, reason: collision with root package name */
    private transient boolean f3478a;
    private transient float b;
    private transient boolean c;
    private transient boolean d;
    private transient Path e;
    private transient Path f;
    private transient Paint g;
    private transient int h;
    private int i;
    private float[] j;
    private transient float k;
    private transient float l;
    private transient float m;
    private transient float n;
    private PathStyle o;
    private int p;
    private float q;
    private boolean r;
    private float s;
    private boolean t;
    private CapDecorationStyle u;
    private CapDecorationStyle v;

    /* loaded from: classes.dex */
    public enum PathStyle {
        Smooth,
        Sharp,
        Rect,
        RoundRect,
        Ellipse,
        XShape,
        FillRect(true),
        FillRoundRect(true),
        FillEllipse(true);

        public final boolean filled;

        public KMProto.KMProject.PathStyle asProtoBuf() {
            switch (this) {
                case Smooth:
                    return KMProto.KMProject.PathStyle.SMOOTH;
                case Sharp:
                    return KMProto.KMProject.PathStyle.SHARP;
                case Rect:
                    return KMProto.KMProject.PathStyle.RECT;
                case XShape:
                    return KMProto.KMProject.PathStyle.XSHAPE;
                case Ellipse:
                    return KMProto.KMProject.PathStyle.ELLIPSE;
                case RoundRect:
                    return KMProto.KMProject.PathStyle.ROUND_RECT;
                case FillRect:
                    return KMProto.KMProject.PathStyle.FILL_RECT;
                case FillEllipse:
                    return KMProto.KMProject.PathStyle.FILL_ELLIPSE;
                case FillRoundRect:
                    return KMProto.KMProject.PathStyle.FILL_ROUND_RECT;
                default:
                    return null;
            }
        }

        public static PathStyle fromsProtoBuf(KMProto.KMProject.PathStyle pathStyle) {
            switch (pathStyle) {
                case SMOOTH:
                    return Smooth;
                case SHARP:
                    return Sharp;
                case RECT:
                    return Rect;
                case XSHAPE:
                    return XShape;
                case ELLIPSE:
                    return Ellipse;
                case ROUND_RECT:
                    return RoundRect;
                case FILL_RECT:
                    return FillRect;
                case FILL_ELLIPSE:
                    return FillEllipse;
                case FILL_ROUND_RECT:
                    return FillRoundRect;
                default:
                    return null;
            }
        }

        PathStyle() {
            this.filled = false;
        }

        PathStyle(boolean z) {
            this.filled = z;
        }
    }

    /* loaded from: classes.dex */
    public enum CapDecorationStyle {
        None,
        Round,
        SolidArrow,
        HollowArrow;

        public KMProto.KMProject.CapDecorationStyle asProtoBuf() {
            switch (this) {
                case None:
                    return KMProto.KMProject.CapDecorationStyle.NONE;
                case Round:
                    return KMProto.KMProject.CapDecorationStyle.ROUND;
                case SolidArrow:
                    return KMProto.KMProject.CapDecorationStyle.SOLID_ARROW;
                case HollowArrow:
                    return KMProto.KMProject.CapDecorationStyle.HOLLOW_ARROW;
                default:
                    return null;
            }
        }

        public static CapDecorationStyle fromProtoBuf(KMProto.KMProject.CapDecorationStyle capDecorationStyle) {
            switch (capDecorationStyle) {
                case NONE:
                    return None;
                case ROUND:
                    return Round;
                case SOLID_ARROW:
                    return SolidArrow;
                case HOLLOW_ARROW:
                    return HollowArrow;
                default:
                    return null;
            }
        }
    }

    public Stroke() {
        this.u = CapDecorationStyle.None;
        this.v = CapDecorationStyle.None;
        this.i = 0;
        this.h = 500;
        this.o = PathStyle.Smooth;
        this.q = 1.0f;
        this.s = 1.0f;
        this.p = -16777216;
        this.r = false;
        this.j = new float[this.h * 2];
    }

    public Stroke(Stroke stroke) {
        this.u = CapDecorationStyle.None;
        this.v = CapDecorationStyle.None;
        this.i = stroke.i;
        this.h = this.i;
        this.j = new float[this.h * 2];
        this.o = stroke.o;
        this.p = stroke.p;
        this.q = stroke.q;
        this.r = stroke.r;
        this.s = stroke.s;
        this.t = stroke.t;
        this.u = stroke.u;
        this.v = stroke.v;
        System.arraycopy(stroke.j, 0, this.j, 0, this.i * 2);
    }

    private void h() {
        float[] fArr = new float[this.h * 2 * 2];
        System.arraycopy(this.j, 0, fArr, 0, this.i * 2);
        this.h *= 2;
        this.j = fArr;
    }

    public void a(float f, float f2, Rect rect) {
        float f3;
        if ((this.u == null || this.u == CapDecorationStyle.None) && (this.v == null || this.v == CapDecorationStyle.None)) {
            f3 = this.t ? 2.0f : 1.0f;
        } else {
            f3 = 7.0f;
        }
        if (this.t && this.i > 1) {
            if (rect != null) {
                float f4 = this.q * f3;
                float f5 = this.j[(this.i - 2) * 2];
                float f6 = this.j[((this.i - 2) * 2) + 1];
                rect.union((int) ((f5 - f4) - 1.0f), (int) ((f6 - f4) - 1.0f), (int) (f5 + f4 + 1.0f), (int) (f4 + f6 + 1.0f));
            }
            this.i = 1;
        }
        if (this.i >= this.h) {
            h();
        }
        if (rect != null) {
            float f7 = f3 * this.q;
            rect.union((int) ((f - f7) - 1.0f), (int) ((f2 - f7) - 1.0f), (int) (f + f7 + 1.0f), (int) (f2 + f7 + 1.0f));
            if (this.i > 0) {
                float f8 = this.j[(this.i - 1) * 2];
                float f9 = this.j[((this.i - 1) * 2) + 1];
                rect.union((int) ((f8 - f7) - 1.0f), (int) ((f9 - f7) - 1.0f), (int) (f8 + f7 + 1.0f), (int) (f9 + f7 + 1.0f));
            }
            if (this.i > 1) {
                float f10 = this.j[(this.i - 2) * 2];
                float f11 = this.j[((this.i - 2) * 2) + 1];
                rect.union((int) ((f10 - f7) - 1.0f), (int) ((f11 - f7) - 1.0f), (int) (f10 + f7 + 1.0f), (int) (f7 + f11 + 1.0f));
            }
        }
        this.j[this.i * 2] = f;
        this.j[(this.i * 2) + 1] = f2;
        this.i++;
        this.f3478a = true;
    }

    public void c() {
        this.i = 0;
        this.f3478a = true;
    }

    public void a(boolean z2) {
        this.t = z2;
        this.f3478a = true;
    }

    public Path d() {
        e(1.0f);
        return this.e;
    }

    public Path a(float f) {
        e(1.0f);
        if (f >= 1.0f) {
            return this.e;
        }
        d(f);
        return this.f;
    }

    private void d(float f) {
        if (this.f == null) {
            this.f = new Path();
        }
        w.setPath(this.e, false);
        this.f.rewind();
        w.getSegment(0.0f, w.getLength() * f, this.f, true);
        this.f.rLineTo(0.0f, 0.0f);
    }

    private void e(float f) {
        if (this.e == null) {
            this.e = new Path();
            this.f3478a = true;
        }
        if (Math.abs(this.b - f) > 1.0E-4d) {
            this.f3478a = true;
        }
        if (this.f3478a) {
            this.b = f;
            this.e.rewind();
            switch (this.o) {
                case Smooth:
                    g(f);
                    break;
                case Sharp:
                    h(f);
                    break;
                case Rect:
                case XShape:
                case Ellipse:
                case RoundRect:
                case FillRect:
                case FillEllipse:
                case FillRoundRect:
                    f(f);
                    break;
            }
            this.d = true;
            this.f3478a = false;
        }
    }

    private void f(float f) {
        this.e.rewind();
        if (this.i >= 1) {
            float f2 = this.j[0];
            float f3 = this.j[1];
            float f4 = this.j[((this.i - 1) * 2) + 0];
            float f5 = this.j[((this.i - 1) * 2) + 1];
            RectF rectF = z;
            switch (this.o) {
                case Rect:
                case FillRect:
                    this.e.addRect(f2, f3, f4, f5, Path.Direction.CCW);
                    return;
                case XShape:
                    this.e.moveTo(f2, f3);
                    this.e.lineTo(f4, f5);
                    this.e.moveTo(f4, f3);
                    this.e.lineTo(f2, f5);
                    return;
                case Ellipse:
                case FillEllipse:
                    rectF.set(f2, f3, f4, f5);
                    this.e.addOval(rectF, Path.Direction.CCW);
                    return;
                case RoundRect:
                case FillRoundRect:
                    this.e.addRect(f2, f3, f4, f5, Path.Direction.CCW);
                    return;
                default:
                    return;
            }
        }
    }

    private void g(float f) {
        this.e.rewind();
        int min = Math.min(this.i, (int) (this.i * f));
        if (min >= 1) {
            this.e.moveTo(this.j[0], this.j[1]);
            if (min > 1) {
                this.e.lineTo((this.j[0] + this.j[2]) / 2.0f, (this.j[1] + this.j[3]) / 2.0f);
            }
            for (int i = 1; i < min - 1; i++) {
                this.e.quadTo(this.j[i * 2], this.j[(i * 2) + 1], (this.j[i * 2] + this.j[(i + 1) * 2]) / 2.0f, (this.j[(i * 2) + 1] + this.j[((i + 1) * 2) + 1]) / 2.0f);
            }
            if (min > 1) {
                this.e.lineTo(this.j[(min - 1) * 2], this.j[((min - 1) * 2) + 1]);
            }
        }
    }

    private void h(float f) {
        this.e.rewind();
        int min = Math.min(this.i, (int) (this.i * f));
        if (min >= 1) {
            this.e.moveTo(this.j[0], this.j[1]);
            for (int i = 1; i < min; i++) {
                this.e.lineTo(this.j[i * 2], this.j[(i * 2) + 1]);
            }
        }
    }

    public Paint e() {
        if (this.g == null) {
            this.g = new Paint();
            this.g.setAntiAlias(true);
            this.g.setStyle(Paint.Style.STROKE);
            this.g.setStrokeJoin(Paint.Join.ROUND);
            this.g.setStrokeCap(Paint.Cap.ROUND);
            this.c = true;
        }
        if (this.c) {
            this.g.setColor(this.p);
            this.g.setStrokeWidth(this.q);
            if (this.r) {
                this.g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            } else {
                this.g.setXfermode(null);
            }
            if (this.s < 1.0f) {
                this.g.setMaskFilter(new BlurMaskFilter((1.0f - this.s) * this.q, BlurMaskFilter.Blur.NORMAL));
            } else {
                this.g.setMaskFilter(null);
            }
            if (this.o.filled) {
                this.g.setStyle(Paint.Style.FILL);
            } else {
                this.g.setStyle(Paint.Style.STROKE);
            }
            this.c = false;
        }
        return this.g;
    }

    public void a(PathStyle pathStyle) {
        if (this.o != pathStyle) {
            if (pathStyle.filled != this.o.filled) {
                this.c = true;
            }
            this.o = pathStyle;
            this.f3478a = true;
        }
    }

    public void a(CapDecorationStyle capDecorationStyle) {
        this.u = capDecorationStyle;
        this.f3478a = true;
    }

    public void b(CapDecorationStyle capDecorationStyle) {
        this.v = capDecorationStyle;
        this.f3478a = true;
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public boolean a() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public void a(Canvas canvas) {
        a(canvas, 1.0f);
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public void a(Canvas canvas, float f) {
        canvas.drawPath(a(f), e());
        if (this.v == CapDecorationStyle.SolidArrow && f == 1.0f) {
            float f2 = this.q * 6.0f;
            float f3 = ((3.0f * f2) / 4.0f) / 2.0f;
            w.setPath(d(), false);
            float length = w.getLength();
            w.getPosTan(length - f2, x, null);
            float f4 = x[0];
            float f5 = x[1];
            w.getPosTan(length, x, null);
            float f6 = x[0];
            float f7 = x[1];
            float f8 = f6 - f4;
            float f9 = f7 - f5;
            float sqrt = (float) Math.sqrt((f8 * f8) + (f9 * f9));
            if (sqrt == 0.0f) {
                sqrt = 1.0E-8f;
            }
            float f10 = f8 / sqrt;
            float f11 = f9 / sqrt;
            float f12 = this.q * f10 * 2.0f;
            float f13 = this.q * f11 * 2.0f;
            float f14 = f10 * f3;
            float f15 = -(f11 * f3);
            y.rewind();
            y.moveTo(f4 + f15 + f12, f5 + f14 + f13);
            y.lineTo(f6 + f12, f7 + f13);
            y.lineTo((f4 - f15) + f12, (f5 - f14) + f13);
            y.close();
            Paint.Style style = this.g.getStyle();
            this.g.setStyle(Paint.Style.FILL);
            canvas.drawPath(y, this.g);
            this.g.setStyle(style);
        }
        if (this.u == CapDecorationStyle.SolidArrow) {
            float f16 = this.q * 6.0f;
            float f17 = ((3.0f * f16) / 4.0f) / 2.0f;
            w.setPath(d(), false);
            w.getLength();
            w.getPosTan(0.0f, x, null);
            float f18 = x[0];
            float f19 = x[1];
            w.getPosTan(f16, x, null);
            float f20 = x[0];
            float f21 = x[1];
            float f22 = f18 - f20;
            float f23 = f19 - f21;
            float sqrt2 = (float) Math.sqrt((f22 * f22) + (f23 * f23));
            if (sqrt2 == 0.0f) {
                sqrt2 = 1.0E-8f;
            }
            float f24 = f22 / sqrt2;
            float f25 = f23 / sqrt2;
            float f26 = this.q * f24 * 2.0f;
            float f27 = this.q * f25 * 2.0f;
            float f28 = f24 * f17;
            float f29 = -(f25 * f17);
            y.rewind();
            y.moveTo(f20 + f29 + f26, f21 + f28 + f27);
            y.lineTo(f18 + f26, f19 + f27);
            y.lineTo((f20 - f29) + f26, (f21 - f28) + f27);
            y.close();
            Paint.Style style2 = this.g.getStyle();
            this.g.setStyle(Paint.Style.FILL);
            canvas.drawPath(y, this.g);
            this.g.setStyle(style2);
        }
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public void a(RectF rectF) {
        float f = 1.0f;
        if (rectF != null) {
            if (this.i == 0) {
                rectF.setEmpty();
                return;
            }
            e(1.0f);
            if (this.d) {
                if ((this.u != null && this.u != CapDecorationStyle.None) || (this.v != null && this.v != CapDecorationStyle.None)) {
                    f = 7.0f;
                }
                d().computeBounds(rectF, true);
                rectF.left -= this.q * f;
                rectF.right += this.q * f;
                rectF.top -= this.q * f;
                rectF.bottom = (f * this.q) + rectF.bottom;
                this.k = rectF.left;
                this.l = rectF.top;
                this.m = rectF.right;
                this.n = rectF.bottom;
                this.d = false;
                return;
            }
            rectF.left = this.k;
            rectF.top = this.l;
            rectF.right = this.m;
            rectF.bottom = this.n;
        }
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public KMProto.KMProject.DrawingAction b() {
        KMProto.KMProject.DrawingAction.Builder builder = new KMProto.KMProject.DrawingAction.Builder();
        builder.drawing_action_type = KMProto.KMProject.DrawingActionType.STROKE;
        builder.points = h.a(this.j);
        builder.color = Integer.valueOf(this.p);
        builder.stroke_width = Float.valueOf(this.q);
        builder.hardness = Float.valueOf(this.s);
        builder.is_eraser = Boolean.valueOf(this.r);
        builder.straight_line = Boolean.valueOf(this.t);
        builder.path_style = this.o.asProtoBuf();
        builder.start_cap = this.u.asProtoBuf();
        builder.end_cap = this.v.asProtoBuf();
        return builder.build();
    }

    @Override // com.nexstreaming.kinemaster.layer.handwriting.a
    public void a(KMProto.KMProject.DrawingAction drawingAction) {
        this.j = h.a(drawingAction.points);
        this.p = drawingAction.color.intValue();
        this.q = drawingAction.stroke_width.floatValue();
        this.s = drawingAction.hardness.floatValue();
        this.r = drawingAction.is_eraser.booleanValue();
        this.t = drawingAction.straight_line.booleanValue();
        this.o = PathStyle.fromsProtoBuf(drawingAction.path_style);
        this.u = CapDecorationStyle.fromProtoBuf(drawingAction.start_cap);
        this.v = CapDecorationStyle.fromProtoBuf(drawingAction.end_cap);
        this.i = drawingAction.points.size() / 2;
        this.h = this.i;
        this.c = true;
        this.f3478a = true;
        this.d = true;
    }

    public float f() {
        return this.q;
    }

    public void b(float f) {
        this.q = f;
        this.c = true;
    }

    public int g() {
        return this.p;
    }

    public void a(int i) {
        this.p = i;
        this.c = true;
    }

    public void b(boolean z2) {
        this.r = z2;
        this.c = true;
    }

    public void c(float f) {
        this.s = f;
        this.c = true;
    }
}
