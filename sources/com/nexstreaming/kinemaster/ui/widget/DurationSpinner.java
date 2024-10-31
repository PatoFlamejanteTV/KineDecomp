package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.nexstreaming.app.general.util.O;
import com.nexstreaming.app.general.util.v;
import com.nexstreaming.app.kinemasterfree.R;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* loaded from: classes2.dex */
public class DurationSpinner extends View {
    v.c A;

    /* renamed from: a */
    private int f23742a;

    /* renamed from: b */
    com.nexstreaming.app.general.util.v f23743b;

    /* renamed from: c */
    private float f23744c;

    /* renamed from: d */
    private float f23745d;

    /* renamed from: e */
    private float f23746e;

    /* renamed from: f */
    private float f23747f;

    /* renamed from: g */
    private float f23748g;

    /* renamed from: h */
    private float f23749h;
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
    private DecimalFormat z;

    /* loaded from: classes2.dex */
    public interface a {
        void a(float f2);
    }

    public DurationSpinner(Context context) {
        super(context);
        this.f23744c = 0.0f;
        this.f23745d = 0.1f;
        this.f23746e = 15.0f;
        this.f23747f = 10.0f;
        this.f23748g = 0.0f;
        this.f23749h = 0.0f;
        this.i = new Paint();
        this.r = new Path();
        this.u = new Paint.FontMetrics();
        this.z = new DecimalFormat("#.#");
        this.A = new C2294b(this);
        a((AttributeSet) null);
    }

    public int getMaxScrollX() {
        return (int) Math.ceil(((this.f23747f - this.f23745d) / 0.1f) * this.j);
    }

    public int getMinScrollX() {
        return 0;
    }

    public float getMaxValue() {
        return this.f23746e;
    }

    public float getValue() {
        return this.f23748g;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(DurationSpinner.class.getName());
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
            this.f23744c = Math.max(getMinScrollX(), Math.min(getMaxScrollX(), this.q.getCurrX()));
        }
        float f2 = this.f23745d;
        float f3 = this.f23744c;
        float f4 = this.j;
        this.f23748g = f2 + (((int) ((f3 + (f4 / 2.0f)) / f4)) * 0.1f);
        a();
        float f5 = ((this.f23748g - this.f23745d) / 0.1f) * this.j;
        double d2 = 0.5d;
        if (this.q.isFinished() && !this.t && Math.abs(f5 - this.f23744c) > 0.5d) {
            Scroller scroller = this.q;
            float f6 = this.f23744c;
            scroller.startScroll((int) f6, 0, (int) (f5 - f6), 0, 100);
            postInvalidateOnAnimation();
        }
        canvas.save();
        canvas.translate((getWidth() / 2.0f) - ((int) this.f23744c), 0.0f);
        this.i.setAntiAlias(true);
        this.i.setColor(this.f23742a);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setAlpha(51);
        this.i.setTextAlign(Paint.Align.CENTER);
        this.i.setTextSize(this.s);
        this.i.setTypeface(Typeface.DEFAULT_BOLD);
        this.i.getFontMetrics(this.u);
        float f7 = this.k;
        float height = getHeight() - this.n;
        float height2 = (getHeight() / 2.0f) - ((this.u.ascent * 0.8f) / 2.0f);
        double d3 = this.f23745d;
        while (d3 <= this.f23746e) {
            boolean z = (Math.floor(d3 * 10.0d) / 10.0d) % d2 == 0.0d;
            double d4 = this.f23745d;
            Double.isNaN(d4);
            float f8 = (((float) (d3 - d4)) / 0.1f) * this.j;
            canvas.drawCircle(f8, f7, z ? this.m : this.l, this.i);
            canvas.drawCircle(f8, height, z ? this.m : this.l, this.i);
            if (z) {
                this.i.setTextSize(this.s);
                this.i.setAlpha(255 - Math.min((int) ((Math.abs(f8 - this.f23744c) / (getWidth() / 2)) * 200.0f), 200));
                canvas.drawText(this.z.format(d3), f8, height2, this.i);
                this.i.setAlpha(51);
            }
            d3 += 0.10000000149011612d;
            d2 = 0.5d;
        }
        canvas.restore();
        this.i.setAlpha(255);
        this.r.rewind();
        this.r.moveTo(getWidth() / 2.0f, this.o + (this.p / 2.0f));
        this.r.lineTo((getWidth() / 2.0f) - (this.p / 2.0f), this.o);
        this.r.lineTo((getWidth() / 2.0f) + (this.p / 2.0f), this.o);
        this.r.close();
        canvas.drawPath(this.r, this.i);
        this.r.rewind();
        this.r.moveTo(getWidth() / 2.0f, getHeight() - (this.o + (this.p / 2.0f)));
        this.r.lineTo((getWidth() / 2.0f) - (this.p / 2.0f), getHeight() - this.o);
        this.r.lineTo((getWidth() / 2.0f) + (this.p / 2.0f), getHeight() - this.o);
        this.r.close();
        canvas.drawPath(this.r, this.i);
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
        this.f23743b.a(motionEvent);
        if (motionEvent.getActionMasked() == 1 && this.t) {
            this.t = false;
            postInvalidateOnAnimation();
        }
        return true;
    }

    public void setMaxValue(float f2) {
        this.f23746e = f2;
    }

    public void setMinValue(float f2) {
        this.f23745d = f2;
    }

    public void setOnValueChangeListener(a aVar) {
        this.v = aVar;
    }

    public void setScrollMaxValue(float f2) {
        this.f23747f = f2;
    }

    public void setTextColor(int i) {
        this.f23742a = i;
    }

    public void setTextColorResource(int i) {
        this.f23742a = getResources().getColor(i);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        this.z.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.DurationSpinner, 0, 0);
        this.w = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f23742a = obtainStyledAttributes.getColor(0, -1);
        this.f23743b = new com.nexstreaming.app.general.util.v(getContext(), this.A);
        this.f23743b.a(2);
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

    public DurationSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23744c = 0.0f;
        this.f23745d = 0.1f;
        this.f23746e = 15.0f;
        this.f23747f = 10.0f;
        this.f23748g = 0.0f;
        this.f23749h = 0.0f;
        this.i = new Paint();
        this.r = new Path();
        this.u = new Paint.FontMetrics();
        this.z = new DecimalFormat("#.#");
        this.A = new C2294b(this);
        a(attributeSet);
    }

    public void a(float f2, boolean z) {
        float f3 = this.f23746e;
        if (f3 >= f2) {
            f3 = f2;
        }
        this.f23748g = f3;
        this.f23749h = f2;
        if (z) {
            float f4 = ((f3 - this.f23745d) / 0.1f) * this.j;
            Scroller scroller = this.q;
            float f5 = this.f23744c;
            scroller.startScroll((int) f5, 0, (int) (f4 - f5), 0, 100);
            postInvalidateOnAnimation();
            return;
        }
        this.f23748g = f3;
        this.f23744c = ((f3 - this.f23745d) / 0.1f) * this.j;
        invalidate();
    }

    public DurationSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23744c = 0.0f;
        this.f23745d = 0.1f;
        this.f23746e = 15.0f;
        this.f23747f = 10.0f;
        this.f23748g = 0.0f;
        this.f23749h = 0.0f;
        this.i = new Paint();
        this.r = new Path();
        this.u = new Paint.FontMetrics();
        this.z = new DecimalFormat("#.#");
        this.A = new C2294b(this);
        a(attributeSet);
    }

    private void a() {
        if (this.t) {
            return;
        }
        float f2 = this.f23748g;
        if (!this.q.isFinished()) {
            float f3 = this.f23745d;
            float finalX = this.q.getFinalX();
            float f4 = this.j;
            f2 = f3 + (((int) ((finalX + (f4 / 2.0f)) / f4)) * 0.1f);
        }
        if (Math.abs(f2 - this.f23749h) > 1.0E-4d) {
            this.f23749h = f2;
            a aVar = this.v;
            if (aVar != null) {
                aVar.a(f2);
            }
        }
    }

    @TargetApi(21)
    public DurationSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23744c = 0.0f;
        this.f23745d = 0.1f;
        this.f23746e = 15.0f;
        this.f23747f = 10.0f;
        this.f23748g = 0.0f;
        this.f23749h = 0.0f;
        this.i = new Paint();
        this.r = new Path();
        this.u = new Paint.FontMetrics();
        this.z = new DecimalFormat("#.#");
        this.A = new C2294b(this);
        a(attributeSet);
    }
}
