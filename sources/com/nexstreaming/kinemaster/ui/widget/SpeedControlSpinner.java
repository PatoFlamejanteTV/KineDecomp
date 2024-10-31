package com.nexstreaming.kinemaster.ui.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

/* loaded from: classes2.dex */
public class SpeedControlSpinner extends View implements GestureDetector.OnGestureListener {

    /* renamed from: a */
    private int f23810a;

    /* renamed from: b */
    private float f23811b;

    /* renamed from: c */
    private float f23812c;

    /* renamed from: d */
    private float f23813d;

    /* renamed from: e */
    private float f23814e;

    /* renamed from: f */
    private float f23815f;

    /* renamed from: g */
    private float f23816g;

    /* renamed from: h */
    private float f23817h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private Paint n;
    private Path o;
    private Paint.FontMetrics p;
    private Scroller q;
    private GestureDetector r;
    private a s;
    private boolean t;
    private Handler u;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(float f2);

        void b();
    }

    public SpeedControlSpinner(Context context) {
        this(context, null);
    }

    private void b() {
        float f2 = ((this.l * 10.0f) - 3.0f) / 10.0f;
        if (this.m != f2) {
            this.m = f2;
            if (this.s != null) {
                if (f2 < 0.25d) {
                    f2 = 0.25f;
                }
                this.s.a(f2);
            }
        }
    }

    private int getMaxScrollX() {
        float f2 = this.f23812c;
        return (int) Math.ceil((3.0f * f2) + (((this.f23811b - 0.5f) / 0.1f) * f2));
    }

    private int getMinScrollX() {
        return 0;
    }

    public /* synthetic */ void a() {
        this.s.a();
    }

    public float getValue() {
        return this.l;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(SpeedControlSpinner.class.getName());
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
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
            this.k = Math.max(getMinScrollX(), Math.min(getMaxScrollX(), this.q.getCurrX()));
        }
        float f2 = this.k;
        float f3 = this.f23812c;
        float f4 = 0.1f;
        this.l = (((int) ((f2 + (f3 / 2.0f)) / f3)) * 0.1f) + 0.5f;
        float f5 = ((this.l - 0.5f) / 0.1f) * f3;
        if (this.q.isFinished() && !this.t && Math.abs(f5 - this.k) > 0.5d) {
            Scroller scroller = this.q;
            float f6 = this.k;
            scroller.startScroll((int) f6, 0, (int) (f5 - f6), 0, 0);
            postInvalidate();
        }
        canvas.save();
        canvas.translate((getWidth() / 2) - ((int) this.k), 0.0f);
        this.n.setAntiAlias(true);
        this.n.setColor(this.f23810a);
        this.n.setStyle(Paint.Style.FILL);
        this.n.setAlpha(51);
        this.n.setTextAlign(Paint.Align.CENTER);
        this.n.setTextSize(this.f23815f);
        this.n.setTypeface(Typeface.DEFAULT_BOLD);
        this.n.getFontMetrics(this.p);
        float f7 = this.f23813d;
        float height = getHeight() - this.f23814e;
        float height2 = (getHeight() / 2) - ((this.p.ascent * 0.8f) / 2.0f);
        int i = 0;
        while (i <= 2) {
            float f8 = ((i / 10.0f) / 0.1f) * this.f23812c;
            canvas.drawCircle(f8, f7, i == 0 ? this.f23817h : this.f23816g, this.n);
            canvas.drawCircle(f8, height, i == 0 ? this.f23817h : this.f23816g, this.n);
            if (i == 0) {
                this.n.setTextSize(this.f23815f);
                this.n.setAlpha(255 - Math.min((int) ((Math.abs(f8 - this.k) / (getWidth() / 2)) * 200.0f), 200));
                canvas.drawText(String.valueOf(0.25d) + FragmentC2201x.f23219a, f8 - this.f23812c, height2, this.n);
                this.n.setAlpha(51);
            }
            i++;
        }
        float f9 = this.f23812c * 3.0f;
        int i2 = 0;
        while (true) {
            float f10 = i2;
            float f11 = 5.0f + f10;
            if (f11 <= this.f23811b * 10.0f) {
                boolean z = i2 % 5 == 0;
                float f12 = (((f10 / 10.0f) / f4) * this.f23812c) + f9;
                canvas.drawCircle(f12, f7, z ? this.f23817h : this.f23816g, this.n);
                canvas.drawCircle(f12, height, z ? this.f23817h : this.f23816g, this.n);
                float f13 = f11 / 10.0f;
                if (z) {
                    this.n.setTextSize(this.f23815f);
                    this.n.setAlpha(255 - Math.min((int) ((Math.abs(f12 - this.k) / (getWidth() / 2)) * 200.0f), 200));
                    int i3 = (int) f13;
                    if (f13 % i3 == 0.0f) {
                        canvas.drawText(String.valueOf(i3) + FragmentC2201x.f23219a, f12, height2, this.n);
                    } else {
                        canvas.drawText(String.valueOf(f13) + FragmentC2201x.f23219a, f12, height2, this.n);
                    }
                    this.n.setAlpha(51);
                }
                i2++;
                f4 = 0.1f;
            } else {
                canvas.restore();
                this.n.setAlpha(255);
                this.o.rewind();
                this.o.moveTo(getWidth() / 2, this.i + (this.j / 2.0f));
                this.o.lineTo((getWidth() / 2) - (this.j / 2.0f), this.i);
                this.o.lineTo((getWidth() / 2) + (this.j / 2.0f), this.i);
                this.o.close();
                canvas.drawPath(this.o, this.n);
                this.o.rewind();
                this.o.moveTo(getWidth() / 2, getHeight() - (this.i + (this.j / 2.0f)));
                this.o.lineTo((getWidth() / 2) - (this.j / 2.0f), getHeight() - this.i);
                this.o.lineTo((getWidth() / 2) + (this.j / 2.0f), getHeight() - this.i);
                this.o.close();
                canvas.drawPath(this.o, this.n);
                b();
                return;
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.t = false;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.t = true;
        this.k = Math.max(getMinScrollX(), Math.min(getMaxScrollX(), this.k + f2));
        postInvalidate();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.r.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.q.forceFinished(true);
            a aVar = this.s;
            if (aVar != null) {
                aVar.b();
            }
        } else if (actionMasked == 1) {
            if (this.t) {
                this.t = false;
                postInvalidateOnAnimation();
            }
            if (this.s != null) {
                if (this.u == null) {
                    this.u = new Handler();
                }
                this.u.postDelayed(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.widget.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpeedControlSpinner.this.a();
                    }
                }, 100L);
            }
        }
        return true;
    }

    public void setListener(a aVar) {
        this.s = aVar;
    }

    public void setMaxSpeed(float f2) {
        this.f23811b = f2;
        postInvalidate();
    }

    public void setSpeed(float f2) {
        if (f2 == 0.25d) {
            f2 = 0.2f;
        }
        float f3 = ((f2 * 10.0f) + 3.0f) / 10.0f;
        this.l = f3;
        this.m = f3;
        this.l = f3;
        float f4 = ((f3 - 0.5f) / 0.1f) * this.f23812c;
        this.k = f4;
        Scroller scroller = this.q;
        float f5 = this.k;
        scroller.startScroll((int) f5, 0, (int) (f4 - f5), 0, 100);
        postInvalidate();
    }

    public SpeedControlSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23811b = 16.0f;
        this.n = new Paint();
        this.o = new Path();
        this.p = new Paint.FontMetrics();
        if (attributeSet != null) {
            this.f23810a = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.SpeedControlSpinner, 0, 0).getColor(0, ContextCompat.getColor(context, R.color.white));
        } else {
            this.f23810a = ContextCompat.getColor(context, R.color.white);
        }
        this.f23812c = getContext().getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.speed_control_spinner_markspacing);
        this.f23813d = getContext().getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.speed_control_spinner_topspace);
        this.f23814e = getContext().getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.speed_control_spinner_bottomspace);
        this.f23816g = getContext().getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.speed_control_spinner_smalldot_radius);
        this.f23817h = getContext().getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.speed_control_spinner_bigdot_radius);
        this.i = getContext().getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.speed_control_spinner_speed_display_arrow_inset);
        this.j = getContext().getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.speed_control_spinner_speed_display_arrow_width);
        this.f23815f = getContext().getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.speed_control_spinner_text_size);
        this.r = new GestureDetector(getContext(), this);
        this.q = new Scroller(getContext());
    }
}
