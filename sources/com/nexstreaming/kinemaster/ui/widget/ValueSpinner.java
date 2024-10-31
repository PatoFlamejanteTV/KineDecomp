package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.app.general.util.O;
import com.nexstreaming.app.general.util.v;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ValueSpinner extends View {
    private Bitmap A;
    private Bitmap B;
    private Bitmap C;
    private float D;
    private Rect E;
    private int F;
    private LinearGradient G;
    private LinearGradient H;
    private int I;
    private float J;
    private float K;
    private boolean L;
    private boolean M;
    v.c N;

    /* renamed from: a */
    private int f23837a;

    /* renamed from: b */
    com.nexstreaming.app.general.util.v f23838b;

    /* renamed from: c */
    private float f23839c;

    /* renamed from: d */
    private float f23840d;

    /* renamed from: e */
    private float f23841e;

    /* renamed from: f */
    private float f23842f;

    /* renamed from: g */
    private float f23843g;

    /* renamed from: h */
    private float f23844h;
    private Paint i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private Scroller q;
    private Path r;
    private float s;
    private boolean t;
    private Paint.FontMetrics u;
    private a v;
    private int w;
    private float x;
    private float y;
    private String z;

    /* loaded from: classes2.dex */
    public interface a {
        void a(float f2, float f3, boolean z);
    }

    public ValueSpinner(Context context) {
        super(context);
        this.f23839c = 0.0f;
        this.f23840d = 0.125f;
        this.f23841e = 0.125f;
        this.f23842f = 10.0f;
        this.f23843g = 10.0f;
        this.f23844h = 0.0f;
        this.i = new Paint();
        this.r = new Path();
        this.u = new Paint.FontMetrics();
        this.D = 0.5f;
        this.E = new Rect();
        this.G = null;
        this.H = null;
        this.I = 0;
        this.M = true;
        this.N = new v(this);
        a((AttributeSet) null);
    }

    public int getMaxScrollX() {
        return (int) Math.ceil(((this.f23843g - this.f23841e) / this.f23840d) * this.j);
    }

    public int getMinScrollX() {
        return 0;
    }

    public float getValue() {
        return this.f23844h;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(ValueSpinner.class.getName());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable background = getBackground();
        if (background != null) {
            background.setBounds(0, 0, getWidth(), getHeight());
            background.draw(canvas);
        }
        if (this.q.computeScrollOffset()) {
            postInvalidateOnAnimation();
            this.f23839c = Math.max(getMinScrollX(), Math.min(getMaxScrollX(), this.q.getCurrX()));
        }
        float f2 = this.f23841e;
        float f3 = this.f23839c;
        float f4 = this.j;
        this.f23844h = f2 + (((int) ((f3 + (f4 / 2.0f)) / f4)) * this.f23840d);
        a();
        float f5 = ((this.f23844h - this.f23841e) / this.f23840d) * this.j;
        if (this.q.isFinished() && !this.t && Math.abs(f5 - this.f23839c) > 0.5d) {
            Scroller scroller = this.q;
            float f6 = this.f23839c;
            scroller.startScroll((int) f6, 0, (int) (f5 - f6), 0, 100);
            postInvalidateOnAnimation();
        }
        canvas.save();
        canvas.translate((getWidth() / 2) - ((int) this.f23839c), 0.0f);
        if (this.A != null) {
            this.E.set(0, 0, getMaxScrollX() - getMinScrollX(), getHeight());
            this.i.setFilterBitmap(true);
            canvas.drawBitmap(this.A, (Rect) null, this.E, this.i);
        }
        this.i.setAntiAlias(true);
        this.i.setColor(this.f23837a);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setAlpha(51);
        this.i.setTextAlign(Paint.Align.CENTER);
        this.i.setTextSize(this.s);
        this.i.setTypeface(Typeface.DEFAULT_BOLD);
        this.i.getFontMetrics(this.u);
        float f7 = this.k;
        float height = getHeight() - this.n;
        float height2 = (getHeight() / 2) - ((this.u.ascent * 0.8f) / 2.0f);
        float f8 = this.f23841e;
        while (true) {
            double d2 = f8;
            double d3 = this.f23842f;
            Double.isNaN(d3);
            if (d2 > d3 + 1.0E-5d) {
                break;
            }
            boolean z = ((double) (Math.abs(f8) % this.D)) < 1.0E-6d;
            float f9 = ((f8 - this.f23841e) / this.f23840d) * this.j;
            canvas.drawCircle(f9, f7, z ? this.m : this.l, this.i);
            canvas.drawCircle(f9, height, z ? this.m : this.l, this.i);
            this.i.setAlpha(51);
            f8 += this.f23840d;
        }
        canvas.restore();
        this.i.setAlpha(255);
        this.r.rewind();
        this.r.moveTo(getWidth() / 2, this.o + (this.p / 2.0f));
        this.r.lineTo((getWidth() / 2) - (this.p / 2.0f), this.o);
        this.r.lineTo((getWidth() / 2) + (this.p / 2.0f), this.o);
        this.r.close();
        canvas.drawPath(this.r, this.i);
        this.r.rewind();
        this.r.moveTo(getWidth() / 2, getHeight() - (this.o + (this.p / 2.0f)));
        this.r.lineTo((getWidth() / 2) - (this.p / 2.0f), getHeight() - this.o);
        this.r.lineTo((getWidth() / 2) + (this.p / 2.0f), getHeight() - this.o);
        this.r.close();
        canvas.drawPath(this.r, this.i);
        if (this.F != 0) {
            if (this.I != getWidth() || this.G == null || this.H == null) {
                this.G = new LinearGradient(0.0f, 0.0f, getWidth() / 2, 0.0f, this.F, 0, Shader.TileMode.CLAMP);
                this.H = new LinearGradient(getWidth() / 2, 0.0f, getWidth(), 0.0f, 0, this.F, Shader.TileMode.CLAMP);
                this.I = getWidth();
            }
            this.i.setShader(this.G);
            canvas.drawRect(0.0f, 0.0f, getWidth() / 2, getHeight(), this.i);
            this.i.setShader(this.H);
            canvas.drawRect(getWidth() / 2, 0.0f, getWidth(), getHeight(), this.i);
            this.i.setShader(null);
        }
        Bitmap bitmap = this.B;
        if (bitmap != null) {
            this.E.set(0, 0, (bitmap.getWidth() * getHeight()) / this.B.getHeight(), getHeight());
            this.i.setFilterBitmap(true);
            canvas.drawBitmap(this.B, (Rect) null, this.E, this.i);
        }
        if (this.C != null) {
            this.E.set(getWidth() - ((this.C.getWidth() * getHeight()) / this.C.getHeight()), 0, getWidth(), getHeight());
            this.i.setFilterBitmap(true);
            canvas.drawBitmap(this.C, (Rect) null, this.E, this.i);
        }
        this.i.setTextSize(this.s);
        this.i.setAlpha(255);
        String str = this.z;
        if (str != null) {
            canvas.drawText(J.a(Locale.ENGLISH, str, this.f23844h), getWidth() / 2, height2, this.i);
            return;
        }
        canvas.drawText(((int) this.f23844h) + "." + (((int) (this.f23844h * 10.0f)) % 10), getWidth() / 2, height2, this.i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.q.forceFinished(true);
            this.y = motionEvent.getX();
            if (O.a(this)) {
                this.x = this.w;
            } else {
                this.x = this.w / 3.0f;
            }
        } else if (actionMasked == 2) {
            if (Math.abs(motionEvent.getX() - this.y) < this.x) {
                return true;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        this.f23838b.a(motionEvent);
        if (motionEvent.getActionMasked() == 1 && this.t) {
            this.t = false;
            postInvalidateOnAnimation();
        }
        return true;
    }

    public void setFormat(String str) {
        this.z = str;
    }

    public void setLargeStepSize(float f2) {
        this.D = f2;
    }

    public void setMaxValue(float f2) {
        this.f23842f = f2;
        this.f23843g = f2;
    }

    public void setMinValue(float f2) {
        this.f23841e = f2;
    }

    public void setOnValueChangeListener(a aVar) {
        this.M = true;
        this.v = aVar;
    }

    public void setShadeColor(int i) {
        this.F = i;
    }

    public void setStepSize(float f2) {
        this.f23840d = f2;
    }

    public void setTextColor(int i) {
        this.f23837a = i;
    }

    public void setTextColorResource(int i) {
        this.f23837a = getResources().getColor(i);
    }

    public void setTrackBackground(Bitmap bitmap) {
        this.A = bitmap;
    }

    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.B = bitmap;
        this.C = bitmap2;
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.ValueSpinner, 0, 0);
        this.w = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f23837a = obtainStyledAttributes.getColor(1, -1);
        this.F = obtainStyledAttributes.getColor(0, 0);
        this.f23838b = new com.nexstreaming.app.general.util.v(getContext(), this.N);
        this.f23838b.a(2);
        this.j = getContext().getResources().getDimension(R.dimen.duration_spinner_markspacing);
        this.k = getContext().getResources().getDimension(R.dimen.duration_spinner_topspace);
        this.n = getContext().getResources().getDimension(R.dimen.duration_spinner_bottomspace);
        this.l = getContext().getResources().getDimension(R.dimen.duration_spinner_smalldot);
        this.m = getContext().getResources().getDimension(R.dimen.duration_spinner_bigdot);
        this.o = getContext().getResources().getDimension(R.dimen.duration_spinner_curpos_inset);
        this.p = getContext().getResources().getDimension(R.dimen.duration_spinner_curpos_width);
        this.s = getContext().getResources().getDimension(R.dimen.duration_spinner_text_size);
        this.q = new Scroller(getContext());
    }

    public ValueSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23839c = 0.0f;
        this.f23840d = 0.125f;
        this.f23841e = 0.125f;
        this.f23842f = 10.0f;
        this.f23843g = 10.0f;
        this.f23844h = 0.0f;
        this.i = new Paint();
        this.r = new Path();
        this.u = new Paint.FontMetrics();
        this.D = 0.5f;
        this.E = new Rect();
        this.G = null;
        this.H = null;
        this.I = 0;
        this.M = true;
        this.N = new v(this);
        a(attributeSet);
    }

    public void a(float f2, boolean z) {
        float f3 = this.f23842f;
        if (f3 < f2) {
            f2 = f3;
        }
        this.f23844h = f2;
        this.M = true;
        if (z) {
            float f4 = ((f2 - this.f23841e) / this.f23840d) * this.j;
            Scroller scroller = this.q;
            float f5 = this.f23839c;
            scroller.startScroll((int) f5, 0, (int) (f4 - f5), 0, 100);
            postInvalidateOnAnimation();
            return;
        }
        this.f23844h = f2;
        this.f23839c = ((f2 - this.f23841e) / this.f23840d) * this.j;
        invalidate();
    }

    private void a() {
        float f2 = this.f23844h;
        if (!this.t && !this.q.isFinished()) {
            float f3 = this.f23841e;
            float finalX = this.q.getFinalX();
            float f4 = this.j;
            f2 = f3 + (((int) ((finalX + (f4 / 2.0f)) / f4)) * this.f23840d);
        }
        a(this.f23844h, f2, !this.t && this.q.isFinished());
    }

    private void a(float f2, float f3, boolean z) {
        if (this.v != null && !this.M && (Math.abs(this.J - f2) > 1.0E-8d || Math.abs(this.K - f3) > 1.0E-8d || this.L != z)) {
            this.v.a(f2, f3, z);
        }
        this.M = false;
        this.L = z;
        this.J = f2;
        this.K = f3;
    }

    public ValueSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23839c = 0.0f;
        this.f23840d = 0.125f;
        this.f23841e = 0.125f;
        this.f23842f = 10.0f;
        this.f23843g = 10.0f;
        this.f23844h = 0.0f;
        this.i = new Paint();
        this.r = new Path();
        this.u = new Paint.FontMetrics();
        this.D = 0.5f;
        this.E = new Rect();
        this.G = null;
        this.H = null;
        this.I = 0;
        this.M = true;
        this.N = new v(this);
        a(attributeSet);
    }

    @TargetApi(21)
    public ValueSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23839c = 0.0f;
        this.f23840d = 0.125f;
        this.f23841e = 0.125f;
        this.f23842f = 10.0f;
        this.f23843g = 10.0f;
        this.f23844h = 0.0f;
        this.i = new Paint();
        this.r = new Path();
        this.u = new Paint.FontMetrics();
        this.D = 0.5f;
        this.E = new Rect();
        this.G = null;
        this.H = null;
        this.I = 0;
        this.M = true;
        this.N = new v(this);
        a(attributeSet);
    }
}
