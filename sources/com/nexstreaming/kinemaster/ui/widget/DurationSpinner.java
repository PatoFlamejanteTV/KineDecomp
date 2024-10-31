package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import com.nexstreaming.app.general.util.n;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.b;

/* loaded from: classes.dex */
public class DurationSpinner extends View {

    /* renamed from: a, reason: collision with root package name */
    com.nexstreaming.app.general.util.n f4374a;
    n.c b;
    private int c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private Paint j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private Scroller r;
    private Path s;
    private float t;
    private boolean u;
    private Paint.FontMetrics v;
    private a w;

    /* loaded from: classes.dex */
    public interface a {
        void a(float f);
    }

    public DurationSpinner(Context context) {
        super(context);
        this.d = 0.0f;
        this.e = 0.125f;
        this.f = 10.0f;
        this.g = 10.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = new Paint();
        this.s = new Path();
        this.v = new Paint.FontMetrics();
        this.b = new com.nexstreaming.kinemaster.ui.widget.a(this);
        a((AttributeSet) null);
    }

    public DurationSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0f;
        this.e = 0.125f;
        this.f = 10.0f;
        this.g = 10.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = new Paint();
        this.s = new Path();
        this.v = new Paint.FontMetrics();
        this.b = new com.nexstreaming.kinemaster.ui.widget.a(this);
        a(attributeSet);
    }

    public DurationSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0.0f;
        this.e = 0.125f;
        this.f = 10.0f;
        this.g = 10.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = new Paint();
        this.s = new Path();
        this.v = new Paint.FontMetrics();
        this.b = new com.nexstreaming.kinemaster.ui.widget.a(this);
        a(attributeSet);
    }

    @TargetApi(21)
    public DurationSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = 0.0f;
        this.e = 0.125f;
        this.f = 10.0f;
        this.g = 10.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = new Paint();
        this.s = new Path();
        this.v = new Paint.FontMetrics();
        this.b = new com.nexstreaming.kinemaster.ui.widget.a(this);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.c = getContext().getTheme().obtainStyledAttributes(attributeSet, b.a.DurationSpinner, 0, 0).getColor(0, -1);
            this.f4374a = new com.nexstreaming.app.general.util.n(getContext(), this.b);
            this.f4374a.a(2);
            this.k = getContext().getResources().getDimension(R.dimen.duration_spinner_markspacing);
            this.l = getContext().getResources().getDimension(R.dimen.duration_spinner_topspace);
            this.o = getContext().getResources().getDimension(R.dimen.duration_spinner_bottomspace);
            this.m = getContext().getResources().getDimension(R.dimen.duration_spinner_smalldot);
            this.n = getContext().getResources().getDimension(R.dimen.duration_spinner_bigdot);
            this.p = getContext().getResources().getDimension(R.dimen.duration_spinner_curpos_inset);
            this.q = getContext().getResources().getDimension(R.dimen.duration_spinner_curpos_width);
            this.t = getContext().getResources().getDimension(R.dimen.duration_spinner_text_size);
            this.r = new Scroller(getContext());
        }
    }

    public void setOnValueChangeListener(a aVar) {
        this.w = aVar;
    }

    public void setTextColor(int i) {
        this.c = i;
    }

    public void setTextColorResource(int i) {
        this.c = getResources().getColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMinScrollX() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMaxScrollX() {
        return (int) Math.ceil(((this.g - this.e) / 0.125f) * this.k);
    }

    public void a(float f, boolean z) {
        float f2 = this.f < f ? this.f : f;
        this.h = f2;
        this.i = f;
        if (z) {
            this.r.startScroll((int) this.d, 0, (int) ((((f2 - this.e) / 0.125f) * this.k) - this.d), 0, 100);
            postInvalidateOnAnimation();
        } else {
            this.h = f2;
            this.d = ((f2 - this.e) / 0.125f) * this.k;
            invalidate();
        }
    }

    public float getValue() {
        return this.h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable background = getBackground();
        if (background != null) {
            background.setBounds(0, 0, getWidth(), getHeight());
            background.draw(canvas);
        }
        if (this.r.computeScrollOffset()) {
            postInvalidateOnAnimation();
            this.d = Math.max(getMinScrollX(), Math.min(getMaxScrollX(), this.r.getCurrX()));
        }
        this.h = this.e + (((int) ((this.d + (this.k / 2.0f)) / this.k)) * 0.125f);
        a();
        float f = ((this.h - this.e) / 0.125f) * this.k;
        if (this.r.isFinished() && !this.u && Math.abs(f - this.d) > 0.5d) {
            this.r.startScroll((int) this.d, 0, (int) (f - this.d), 0, 100);
            postInvalidateOnAnimation();
        }
        canvas.save();
        canvas.translate((getWidth() / 2) - ((int) this.d), 0.0f);
        this.j.setAntiAlias(true);
        this.j.setColor(this.c);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setAlpha(51);
        this.j.setTextAlign(Paint.Align.CENTER);
        this.j.setTextSize(this.t);
        this.j.setTypeface(Typeface.DEFAULT_BOLD);
        this.j.getFontMetrics(this.v);
        float f2 = this.l;
        float height = getHeight() - this.o;
        float height2 = (getHeight() / 2) - ((this.v.ascent * 0.8f) / 2.0f);
        for (float f3 = this.e; f3 <= this.f + 1.0E-5d; f3 += 0.125f) {
            boolean z = ((double) (f3 % 0.5f)) < 1.0E-5d;
            float f4 = this.k * ((f3 - this.e) / 0.125f);
            canvas.drawCircle(f4, f2, z ? this.n : this.m, this.j);
            canvas.drawCircle(f4, height, z ? this.n : this.m, this.j);
            if (z) {
                this.j.setTextSize(this.t);
                this.j.setAlpha(255 - Math.min((int) ((Math.abs(f4 - this.d) / (getWidth() / 2)) * 200.0f), 200));
                canvas.drawText(((int) f3) + "." + (((int) (10.0f * f3)) % 10), f4, height2, this.j);
                this.j.setAlpha(51);
            }
        }
        canvas.restore();
        this.j.setAlpha(255);
        this.s.rewind();
        this.s.moveTo(getWidth() / 2, this.p + (this.q / 2.0f));
        this.s.lineTo((getWidth() / 2) - (this.q / 2.0f), this.p);
        this.s.lineTo((getWidth() / 2) + (this.q / 2.0f), this.p);
        this.s.close();
        canvas.drawPath(this.s, this.j);
        this.s.rewind();
        this.s.moveTo(getWidth() / 2, getHeight() - (this.p + (this.q / 2.0f)));
        this.s.lineTo((getWidth() / 2) - (this.q / 2.0f), getHeight() - this.p);
        this.s.lineTo((getWidth() / 2) + (this.q / 2.0f), getHeight() - this.p);
        this.s.close();
        canvas.drawPath(this.s, this.j);
    }

    private void a() {
        if (!this.u) {
            float f = this.h;
            if (!this.r.isFinished()) {
                f = this.e + (((int) ((this.r.getFinalX() + (this.k / 2.0f)) / this.k)) * 0.125f);
            }
            if (Math.abs(f - this.i) > 1.0E-4d) {
                this.i = f;
                if (this.w != null) {
                    this.w.a(f);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.r.forceFinished(true);
                break;
        }
        this.f4374a.a(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 1:
                if (this.u) {
                    this.u = false;
                    postInvalidateOnAnimation();
                }
            default:
                return true;
        }
    }

    public void setMaxValue(float f) {
        this.f = f;
    }

    public void setScrollMaxValue(float f) {
        this.g = f;
    }
}
