package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Scroller;

/* loaded from: classes2.dex */
public class AudioLevelMeter extends View {

    /* renamed from: a */
    private static final int[] f21752a = {Color.parseColor("#ff1200"), Color.parseColor("#ff8400"), Color.parseColor("#0afe00")};

    /* renamed from: b */
    private static final int[] f21753b;

    /* renamed from: c */
    private static final float[] f21754c;

    /* renamed from: d */
    private LinearGradient f21755d;

    /* renamed from: e */
    private LinearGradient f21756e;

    /* renamed from: f */
    private Paint f21757f;

    /* renamed from: g */
    private TextPaint f21758g;

    /* renamed from: h */
    private int f21759h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private String n;
    private int o;
    private float p;
    private int q;
    private Rect r;
    private a s;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a */
        final Scroller f21760a;

        /* renamed from: b */
        int f21761b;

        /* renamed from: c */
        boolean f21762c;

        /* renamed from: d */
        boolean f21763d;

        a(Context context, int i) {
            if (i != 0) {
                this.f21760a = new Scroller(context, AnimationUtils.loadInterpolator(context, i));
            } else {
                this.f21760a = new Scroller(context);
            }
        }

        void a(int i) {
            this.f21761b = 0;
            this.f21762c = false;
            this.f21763d = true;
            AudioLevelMeter.this.removeCallbacks(this);
            AudioLevelMeter.this.postDelayed(this, i);
        }

        void b() {
            AudioLevelMeter.this.removeCallbacks(this);
            this.f21760a.abortAnimation();
            this.f21762c = true;
        }

        boolean c() {
            return !(this.f21762c || this.f21760a.isFinished()) || this.f21763d;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f21763d) {
                this.f21763d = false;
                if (this.f21762c) {
                    return;
                }
                int abs = Math.abs(AudioLevelMeter.this.f21759h - AudioLevelMeter.this.i);
                this.f21760a.startScroll(0, 0, abs, 0, abs * 10);
                AudioLevelMeter.this.post(this);
                return;
            }
            if (!this.f21760a.computeScrollOffset() || this.f21762c) {
                return;
            }
            int currX = this.f21760a.getCurrX();
            int abs2 = Math.abs(currX - this.f21761b);
            if (AudioLevelMeter.this.f21759h > AudioLevelMeter.this.i) {
                AudioLevelMeter audioLevelMeter = AudioLevelMeter.this;
                audioLevelMeter.i = Math.min(audioLevelMeter.i + abs2, AudioLevelMeter.this.j);
            } else {
                AudioLevelMeter audioLevelMeter2 = AudioLevelMeter.this;
                audioLevelMeter2.i = Math.max(audioLevelMeter2.i - abs2, 0);
            }
            this.f21761b = currX;
            AudioLevelMeter.this.postInvalidate();
            AudioLevelMeter.this.post(this);
        }
    }

    static {
        int[] iArr = f21752a;
        int[] iArr2 = f21752a;
        int[] iArr3 = f21752a;
        f21753b = new int[]{Color.argb(128, (iArr[0] >> 16) & 255, (iArr[0] >> 8) & 255, iArr[0] & 255), Color.argb(128, (iArr2[1] >> 16) & 255, (iArr2[1] >> 8) & 255, iArr2[1] & 255), Color.argb(128, (iArr3[2] >> 16) & 255, (iArr3[2] >> 8) & 255, iArr3[2] & 255)};
        f21754c = new float[]{0.1f, 0.2f, 1.0f};
    }

    public AudioLevelMeter(Context context) {
        super(context);
        this.j = 100;
        this.k = 1000;
        this.l = 3;
        a(context, (AttributeSet) null);
    }

    public int getLevel() {
        return this.f21759h;
    }

    public int getMax() {
        return this.j;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(AudioLevelMeter.class.getName());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        int width = getWidth() - (getPaddingLeft() + getPaddingRight());
        int height = getHeight() - (getPaddingTop() + getPaddingBottom());
        if (width == 0 || height == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (!TextUtils.isEmpty(this.n)) {
            if (this.r == null) {
                this.r = new Rect();
            }
            TextPaint textPaint = this.f21758g;
            String str = this.n;
            textPaint.getTextBounds(str, 0, str.length(), this.r);
            int height2 = paddingTop + this.r.height();
            canvas.drawText(this.n, (width / 2) + paddingLeft, height2, this.f21758g);
            paddingTop = height2 + this.q;
            height -= paddingTop;
        }
        this.f21757f.setColor(ViewCompat.MEASURED_STATE_MASK);
        float f2 = paddingLeft;
        float f3 = paddingLeft + width;
        float f4 = paddingTop + height;
        canvas.drawRect(f2, paddingTop, f3, f4, this.f21757f);
        LinearGradient linearGradient = this.f21756e;
        if (linearGradient != null && (i2 = (int) (height * (1.0f - (this.i / this.j)))) < height) {
            this.f21757f.setShader(linearGradient);
            canvas.drawRect(f2, i2 + paddingTop, f3, f4, this.f21757f);
        }
        LinearGradient linearGradient2 = this.f21755d;
        if (linearGradient2 != null && (i = (int) (height * (1.0f - (this.f21759h / this.j)))) < height) {
            this.f21757f.setShader(linearGradient2);
            canvas.drawRect(f2, i + paddingTop, f3, f4, this.f21757f);
        }
        this.f21757f.setShader(null);
        this.f21757f.setColor(-1);
        int i3 = paddingTop + (height / 2);
        canvas.drawRect(f2, i3 - 1, f3, i3 + 1, this.f21757f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size > 0 && size2 > 0) {
            if ((this.l & 1) == 1) {
                this.f21755d = new LinearGradient(0.0f, 0.0f, size, size2, f21752a, f21754c, Shader.TileMode.CLAMP);
            }
            if ((this.l & 2) == 2) {
                this.f21756e = new LinearGradient(0.0f, 0.0f, size, size2, f21753b, f21754c, Shader.TileMode.CLAMP);
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setLevel(int i) {
        int min = Math.min(i, this.j);
        if (min == this.f21759h) {
            return;
        }
        this.f21759h = min;
        int i2 = this.f21759h;
        if (i2 > this.i) {
            this.i = i2;
            this.s.b();
            this.s.a(this.k);
        } else if (!this.s.c()) {
            this.s.a(this.k);
        }
        invalidate();
    }

    public void setMax(int i) {
        this.j = i;
        invalidate();
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.AudioLevelMeter);
        if (obtainStyledAttributes != null) {
            this.f21759h = obtainStyledAttributes.getInt(5, 0);
            this.j = obtainStyledAttributes.getInt(6, 100);
            this.k = obtainStyledAttributes.getInt(8, 1000);
            this.l = obtainStyledAttributes.getInt(7, 3);
            this.m = obtainStyledAttributes.getResourceId(0, 0);
            this.n = obtainStyledAttributes.getString(1);
            this.o = obtainStyledAttributes.getColor(2, -1);
            this.p = obtainStyledAttributes.getDimensionPixelSize(4, a(getResources(), 10.0f));
            this.q = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            obtainStyledAttributes.recycle();
        }
        this.f21757f = new Paint(1);
        this.f21758g = new TextPaint(1);
        this.f21758g.setTextAlign(Paint.Align.CENTER);
        this.f21758g.setColor(this.o);
        this.f21758g.setTextSize(this.p);
        this.s = new a(context, this.m);
    }

    public AudioLevelMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 100;
        this.k = 1000;
        this.l = 3;
        a(context, attributeSet);
    }

    public AudioLevelMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = 100;
        this.k = 1000;
        this.l = 3;
        a(context, attributeSet);
    }

    public void a() {
        this.s.b();
        this.f21759h = 0;
        this.i = 0;
        invalidate();
    }

    private static int a(Resources resources, float f2) {
        return (int) TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
    }
}
