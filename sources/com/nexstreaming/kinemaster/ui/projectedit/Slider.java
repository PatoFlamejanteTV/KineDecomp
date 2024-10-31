package com.nexstreaming.kinemaster.ui.projectedit;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class Slider extends View {
    private WindowManager A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private float H;
    private ShowValueStyle I;
    private boolean J;
    private FrameLayout K;
    private TextView L;
    private WindowManager.LayoutParams M;
    private com.nextreaming.nexeditorui.Aa N;
    private StartDirection O;
    private boolean P;
    private String Q;
    private String R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private long W;

    /* renamed from: a */
    private int f22086a;
    private int aa;

    /* renamed from: b */
    private DisplayMetrics f22087b;
    private float ba;

    /* renamed from: c */
    private Paint f22088c;

    /* renamed from: d */
    private float f22089d;

    /* renamed from: e */
    private float f22090e;

    /* renamed from: f */
    private float f22091f;

    /* renamed from: g */
    private float f22092g;

    /* renamed from: h */
    private float[] f22093h;
    private float[] i;
    private float[] j;
    private float[] k;
    private int l;
    private Rect m;
    private RectF n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private a z;

    /* loaded from: classes2.dex */
    public enum ShowValueStyle {
        unsigned,
        signed,
        percent,
        rate,
        timemillis,
        none
    }

    /* loaded from: classes2.dex */
    public enum StartDirection {
        left,
        right
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(float f2);

        void b();
    }

    public Slider(Context context) {
        super(context);
        this.f22086a = 1;
        this.f22088c = new Paint();
        this.f22089d = 0.0f;
        this.f22090e = 100.0f;
        this.f22091f = 0.0f;
        this.f22092g = 0.0f;
        this.f22093h = new float[0];
        this.i = new float[0];
        this.j = new float[0];
        this.k = new float[0];
        this.m = new Rect();
        this.n = new RectF();
        this.t = -1.0f;
        this.x = false;
        this.y = -858993460;
        this.z = null;
        this.A = null;
        this.K = null;
        this.L = null;
        this.P = false;
        this.V = false;
        a();
    }

    private void d() {
        boolean z = this.u || (this.v && System.nanoTime() > this.W);
        if (!this.P && z) {
            c();
        } else {
            b();
        }
    }

    private int getHPadding() {
        return getPaddingLeft() + getPaddingRight();
    }

    private int getVPadding() {
        return getPaddingTop() + getPaddingBottom();
    }

    public float getMaxValue() {
        return this.f22090e;
    }

    public float getMinValue() {
        return this.f22089d;
    }

    public float getStep() {
        return this.f22092g;
    }

    public float getValue() {
        return this.O == StartDirection.left ? this.f22091f : this.f22090e - this.f22091f;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(Slider.class.getName());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.N.b();
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        if (i == 0) {
            this.u = false;
            this.v = false;
            b();
            invalidate();
        }
        super.onScreenStateChanged(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            if (r0 != 5) goto L56;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r4.b()
            r4.u = r1
            r4.v = r1
            return r2
        L10:
            int r0 = r5.getActionMasked()
            if (r0 == 0) goto L35
            if (r0 == r2) goto L2e
            r3 = 2
            if (r0 == r3) goto L27
            r3 = 3
            if (r0 == r3) goto L22
            r3 = 5
            if (r0 == r3) goto L2e
            goto L3c
        L22:
            boolean r5 = r4.a(r5, r2)
            return r5
        L27:
            boolean r5 = r4.b(r5)
            if (r5 == 0) goto L2d
        L2d:
            return r2
        L2e:
            boolean r5 = r4.a(r5, r1)
            if (r5 == 0) goto L34
        L34:
            return r2
        L35:
            boolean r0 = r4.a(r5)
            if (r0 == 0) goto L3c
            return r2
        L3c:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.Slider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDefaultValue(float f2) {
        this.H = f2;
    }

    public void setDraggingLimitValue(float f2) {
        this.t = f2;
        invalidate();
    }

    public void setHideValueTab(boolean z) {
        this.P = z;
    }

    public void setListener(a aVar) {
        this.z = aVar;
    }

    public void setMaxValue(float f2) {
        this.f22090e = f2;
        invalidate();
    }

    public void setMinValue(float f2) {
        this.f22089d = f2;
        invalidate();
    }

    public void setSnapAt(float f2) {
    }

    public void setSnapAt(String str) {
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (String str2 : str.split(" *[ ,;] *")) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(str2)));
            } catch (NumberFormatException unused) {
            }
        }
        this.f22093h = new float[arrayList.size()];
        while (true) {
            float[] fArr = this.f22093h;
            if (i < fArr.length) {
                fArr[i] = ((Float) arrayList.get(i)).floatValue();
                i++;
            } else {
                Arrays.sort(fArr);
                return;
            }
        }
    }

    public void setStep(float f2) {
        this.f22092g = f2;
        invalidate();
    }

    public void setValue(float f2) {
        this.f22091f = f2;
        invalidate();
    }

    private void b(Canvas canvas) {
        int i;
        float b2 = b(1.0f);
        this.f22088c.reset();
        this.f22088c.setColor(this.y);
        this.f22088c.setStyle(Paint.Style.FILL);
        a(this.m);
        Rect rect = this.m;
        int width = rect.left + ((rect.width() - this.C) / 2);
        Rect rect2 = this.m;
        int width2 = rect2.left + ((rect2.width() + this.C) / 2);
        Rect rect3 = this.m;
        int height = rect3.top + ((rect3.height() - this.C) / 2);
        Rect rect4 = this.m;
        int height2 = rect4.top + ((rect4.height() + this.C) / 2);
        int i2 = this.f22086a;
        if (i2 == 1) {
            i = this.B * 2;
            float f2 = width;
            this.m.left = (int) (f2 - b(9.0f));
            this.m.right = (int) (f2 - b(3.0f));
        } else if (i2 == 0) {
            i = this.B * 2;
            float f3 = height;
            this.m.top = (int) (f3 - b(6.0f));
            this.m.bottom = (int) (f3 - b(3.0f));
        } else {
            i = 0;
        }
        if (this.w) {
            for (float f4 : this.f22093h) {
                int d2 = d(f4);
                int i3 = this.f22086a;
                if (i3 == 1) {
                    Rect rect5 = this.m;
                    rect5.top = d2 + ((int) (this.B + b2));
                    rect5.bottom = rect5.top + ((int) b2);
                } else if (i3 == 0) {
                    Rect rect6 = this.m;
                    rect6.left = (d2 - ((int) (b2 / 2.0f))) + (i / 2);
                    rect6.right = rect6.left + ((int) b2);
                }
                canvas.drawRect(this.m, this.f22088c);
            }
        }
        for (float f5 : this.i) {
            int d3 = d(f5);
            int i4 = this.f22086a;
            if (i4 == 1) {
                RectF rectF = this.n;
                rectF.top = (d3 + (this.B / 2)) - (b2 / 2.0f);
                rectF.bottom = rectF.top + ((int) r15);
                float f6 = width;
                rectF.left = f6 - b(5.0f);
                this.n.right = f6 - b(3.0f);
                canvas.drawRect(this.n, this.f22088c);
                float f7 = width2;
                this.n.left = f7 + b(3.0f);
                this.n.right = f7 + b(5.0f);
                canvas.drawRect(this.n, this.f22088c);
            } else if (i4 == 0) {
                RectF rectF2 = this.n;
                rectF2.left = (d3 - ((int) (b2 / 2.0f))) + (this.C / 2);
                rectF2.right = rectF2.left + ((int) b2);
                float f8 = height;
                rectF2.top = f8 - b(5.0f);
                this.n.bottom = f8 - b(3.0f);
                canvas.drawRect(this.n, this.f22088c);
                float f9 = height2;
                this.n.top = f9 + b(3.0f);
                this.n.bottom = f9 + b(5.0f);
                canvas.drawRect(this.n, this.f22088c);
            }
        }
        for (float f10 : this.j) {
            int d4 = d(f10);
            int i5 = this.f22086a;
            if (i5 == 1) {
                RectF rectF3 = this.n;
                rectF3.top = (d4 + (this.B / 2)) - (b2 / 2.0f);
                rectF3.bottom = rectF3.top + ((int) r12);
                float f11 = width;
                rectF3.left = f11 - b(7.0f);
                this.n.right = f11 - b(3.0f);
                canvas.drawRect(this.n, this.f22088c);
                float f12 = width2;
                this.n.left = f12 + b(3.0f);
                this.n.right = f12 + b(7.0f);
                canvas.drawRect(this.n, this.f22088c);
            } else if (i5 == 0) {
                RectF rectF4 = this.n;
                rectF4.left = (d4 - ((int) (b2 / 2.0f))) + (this.C / 2);
                rectF4.right = rectF4.left + ((int) b2);
                float f13 = height;
                rectF4.top = f13 - b(7.0f);
                this.n.bottom = f13 - b(3.0f);
                canvas.drawRect(this.n, this.f22088c);
                float f14 = height2;
                this.n.top = f14 + b(3.0f);
                this.n.bottom = f14 + b(7.0f);
                canvas.drawRect(this.n, this.f22088c);
            }
        }
        float[] fArr = this.k;
        int length = fArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            float f15 = fArr[i6];
            int d5 = d(f15);
            int i7 = this.f22086a;
            if (i7 == 1) {
                this.n.top = (d5 + (this.B / 2)) - (f15 <= this.H ? getPaddingBottom() : 0);
                RectF rectF5 = this.n;
                rectF5.bottom = rectF5.top + ((int) b2);
                float f16 = width;
                rectF5.left = f16 - b(9.0f);
                this.n.right = f16 - b(3.0f);
                canvas.drawRect(this.n, this.f22088c);
                float f17 = width2;
                this.n.left = b(3.0f) + f17;
                this.n.right = f17 + b(9.0f);
                canvas.drawRect(this.n, this.f22088c);
            } else if (i7 == 0) {
                RectF rectF6 = this.n;
                rectF6.left = d5 - ((int) (b2 / 2.0f));
                rectF6.right = rectF6.left + ((int) b2);
                float f18 = height;
                rectF6.top = f18 - b(9.0f);
                this.n.bottom = f18 - b(3.0f);
                canvas.drawRect(this.n, this.f22088c);
                float f19 = height2;
                this.n.top = b(3.0f) + f19;
                this.n.bottom = f19 + b(9.0f);
                canvas.drawRect(this.n, this.f22088c);
            }
        }
        if (this.R != null) {
            int d6 = d(this.f22090e) - getResources().getDimensionPixelOffset(R.dimen.slider_label_padding);
            int i8 = this.f22086a;
            if (i8 != 1 && i8 == 0) {
                this.f22088c.setTextAlign(Paint.Align.CENTER);
                this.f22088c.setTextSize(getResources().getDimension(R.dimen.slider_label_text_size));
                this.f22088c.setTypeface(Typeface.DEFAULT_BOLD);
                this.f22088c.setColor(this.T);
                canvas.drawText(this.R, d6, height - getResources().getDimensionPixelOffset(R.dimen.slider_label_top_position), this.f22088c);
            }
        }
        if (this.Q != null) {
            int d7 = d(this.f22089d) + getResources().getDimensionPixelOffset(R.dimen.slider_label_padding);
            int i9 = this.f22086a;
            if (i9 != 1 && i9 == 0) {
                this.f22088c.setTextAlign(Paint.Align.CENTER);
                this.f22088c.setTextSize(getResources().getDimension(R.dimen.slider_label_text_size));
                this.f22088c.setTypeface(Typeface.DEFAULT_BOLD);
                this.f22088c.setColor(this.S);
                canvas.drawText(this.Q, d7, height - getResources().getDimensionPixelOffset(R.dimen.slider_label_top_position), this.f22088c);
            }
        }
        if (this.G) {
            int d8 = d(this.O == StartDirection.left ? this.H : this.f22090e - this.H);
            int i10 = this.U;
            if (i10 != this.y) {
                this.f22088c.setColor(i10);
            }
            int i11 = this.f22086a;
            if (i11 == 1) {
                Rect rect7 = this.m;
                rect7.top = d8;
                rect7.bottom = rect7.top + ((int) b2);
                canvas.drawRect(rect7, this.f22088c);
                float f20 = width2;
                this.m.left = (int) (b(5.0f) + f20);
                this.m.right = (int) (f20 + b(11.0f));
                canvas.drawRect(this.m, this.f22088c);
                return;
            }
            if (i11 == 0) {
                RectF rectF7 = this.n;
                rectF7.left = d8 - ((int) (b2 / 2.0f));
                rectF7.right = rectF7.left + ((int) b2);
                float f21 = height;
                rectF7.top = f21 - b(9.0f);
                this.n.bottom = f21 - b(3.0f);
                canvas.drawRect(this.n, this.f22088c);
                float f22 = height2;
                this.n.top = b(3.0f) + f22;
                this.n.bottom = f22 + b(9.0f);
                canvas.drawRect(this.n, this.f22088c);
            }
        }
    }

    private void c(Canvas canvas) {
        this.f22088c.reset();
        a(this.m);
        int i = this.f22086a;
        if (i == 1) {
            Rect rect = this.m;
            int i2 = rect.left;
            int width = rect.width();
            int i3 = this.C;
            rect.left = i2 + ((width - i3) / 2);
            Rect rect2 = this.m;
            rect2.right = rect2.left + i3;
            int i4 = rect2.top;
            int i5 = this.B;
            rect2.top = i4 + (i5 / 2);
            rect2.bottom -= i5 / 2;
            RectF rectF = new RectF(rect2);
            this.f22088c.setColor(this.E);
            canvas.drawRoundRect(rectF, 7.0f, 7.0f, this.f22088c);
            canvas.save();
            RectF rectF2 = new RectF(this.m);
            rectF2.top = d(this.f22091f);
            if (isEnabled()) {
                this.f22088c.setColor(this.F);
            } else {
                rectF2.top += this.B + b(1.0f);
                this.f22088c.setColor(getResources().getColor(R.color.slider_disable));
            }
            Path path = new Path();
            path.addRoundRect(rectF2, 7.0f, 7.0f, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.drawRect(rectF2, this.f22088c);
            canvas.restore();
            return;
        }
        if (i == 0) {
            Rect rect3 = this.m;
            int i6 = rect3.top;
            int height = rect3.height();
            int i7 = this.C;
            rect3.top = i6 + ((height - i7) / 2);
            Rect rect4 = this.m;
            rect4.bottom = rect4.top + i7;
            RectF rectF3 = new RectF(rect4);
            float f2 = rectF3.left;
            int i8 = this.C;
            rectF3.left = f2 - (i8 / 2);
            rectF3.right += i8 / 2;
            StartDirection startDirection = this.O;
            if (startDirection == StartDirection.left) {
                this.f22088c.setColor(this.E);
            } else if (startDirection == StartDirection.right) {
                this.f22088c.setColor(isEnabled() ? this.F : this.E);
            }
            int i9 = this.C;
            canvas.drawRoundRect(rectF3, i9 / 2.0f, i9 / 2.0f, this.f22088c);
            if (isEnabled()) {
                StartDirection startDirection2 = this.O;
                if (startDirection2 == StartDirection.left) {
                    this.f22088c.setColor(this.F);
                } else if (startDirection2 == StartDirection.right) {
                    this.f22088c.setColor(this.E);
                }
                rectF3.right = d(this.f22091f);
                int i10 = this.C;
                canvas.drawRoundRect(rectF3, i10 / 2.0f, i10 / 2.0f, this.f22088c);
            }
        }
    }

    private void a() {
        this.aa = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setLayerType(1, null);
        this.A = (WindowManager) getContext().getSystemService("window");
        this.f22087b = getResources().getDisplayMetrics();
        this.N = new com.nextreaming.nexeditorui.Aa(this.A.getDefaultDisplay());
        this.N.a(new Jg(this));
    }

    private int d(float f2) {
        int i = this.f22086a;
        if (i == 1) {
            return getHeight() - (a(f2, getHeight() - getVPadding()) + getPaddingBottom());
        }
        if (i == 0) {
            return a(f2, getWidth() - getHPadding()) + getPaddingLeft();
        }
        return 0;
    }

    private void a(AttributeSet attributeSet) {
        int i = 0;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.Slider, 0, 0);
        this.f22086a = obtainStyledAttributes.getInteger(11, 0);
        this.B = obtainStyledAttributes.getDimensionPixelOffset(19, 0);
        this.C = obtainStyledAttributes.getDimensionPixelOffset(24, 0);
        this.D = obtainStyledAttributes.getColor(18, -1);
        this.y = obtainStyledAttributes.getColor(21, -858993460);
        this.E = obtainStyledAttributes.getColor(23, SupportMenu.CATEGORY_MASK);
        this.F = obtainStyledAttributes.getColor(22, -16776961);
        this.G = obtainStyledAttributes.getBoolean(0, false);
        this.w = obtainStyledAttributes.getBoolean(14, false);
        this.H = obtainStyledAttributes.getFloat(2, 0.0f);
        this.f22092g = obtainStyledAttributes.getFloat(17, 0.0f);
        this.f22089d = obtainStyledAttributes.getFloat(10, 0.0f);
        this.f22090e = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f22091f = obtainStyledAttributes.getFloat(26, 0.0f);
        this.l = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.Q = obtainStyledAttributes.getString(6);
        this.R = obtainStyledAttributes.getString(3);
        this.S = obtainStyledAttributes.getColor(7, this.y);
        this.T = obtainStyledAttributes.getColor(4, this.y);
        this.U = obtainStyledAttributes.getColor(1, this.y);
        this.V = obtainStyledAttributes.getBoolean(25, false);
        int integer = obtainStyledAttributes.getInteger(27, 0);
        ShowValueStyle[] values = ShowValueStyle.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            ShowValueStyle showValueStyle = values[i2];
            if (integer == showValueStyle.ordinal()) {
                this.I = showValueStyle;
                break;
            }
            i2++;
        }
        int integer2 = obtainStyledAttributes.getInteger(16, 0);
        StartDirection[] values2 = StartDirection.values();
        int length2 = values2.length;
        while (true) {
            if (i >= length2) {
                break;
            }
            StartDirection startDirection = values2[i];
            if (integer2 == startDirection.ordinal()) {
                this.O = startDirection;
                break;
            }
            i++;
        }
        this.f22093h = a(obtainStyledAttributes.getString(13));
        this.k = a(obtainStyledAttributes.getString(5));
        this.i = a(obtainStyledAttributes.getString(12));
        this.j = a(obtainStyledAttributes.getString(9));
    }

    public Slider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22086a = 1;
        this.f22088c = new Paint();
        this.f22089d = 0.0f;
        this.f22090e = 100.0f;
        this.f22091f = 0.0f;
        this.f22092g = 0.0f;
        this.f22093h = new float[0];
        this.i = new float[0];
        this.j = new float[0];
        this.k = new float[0];
        this.m = new Rect();
        this.n = new RectF();
        this.t = -1.0f;
        this.x = false;
        this.y = -858993460;
        this.z = null;
        this.A = null;
        this.K = null;
        this.L = null;
        this.P = false;
        this.V = false;
        a();
        a(attributeSet);
    }

    private void c() {
        int i;
        int i2;
        int i3;
        int i4;
        int d2 = d(this.f22091f);
        a(this.m);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int i5 = rect.left;
        int i6 = iArr[0] - 0;
        int i7 = iArr[1];
        int i8 = this.f22086a;
        if (i8 == 1) {
            int i9 = this.B * 2;
            Rect rect2 = this.m;
            i2 = d2 - (i9 / 2);
            i = (rect2.left + (rect2.width() / 2)) - ((i9 / 3) * 2);
        } else if (i8 == 0) {
            int i10 = this.B * 2;
            Rect rect3 = this.m;
            i2 = ((rect3.top + ((rect3.height() - this.C) / 2)) - getResources().getDimensionPixelSize(R.dimen.slider_valuetab_horizontal_height)) - ((i10 / 5) * 3);
            i = d2 + ((i10 / 6) * 5);
        } else {
            i = 0;
            i2 = 0;
        }
        if (this.M == null) {
            this.M = new WindowManager.LayoutParams();
        }
        if (this.K == null) {
            this.K = new FrameLayout(getContext());
            this.L = new Kg(this, getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 5;
            this.L.setLayerType(1, null);
            this.K.setLayerType(1, null);
            this.K.addView(this.L, layoutParams);
        } else {
            this.L.invalidate();
        }
        int i11 = this.f22086a;
        if (i11 == 1) {
            i3 = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_vertical_height);
            i4 = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_vertical_width);
        } else if (i11 == 0) {
            i3 = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_horizontal_height);
            i4 = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_horizontal_width);
        } else {
            i3 = 0;
            i4 = 0;
        }
        WindowManager.LayoutParams layoutParams2 = this.M;
        layoutParams2.height = i3;
        layoutParams2.width = i4;
        layoutParams2.flags = 904;
        layoutParams2.gravity = 51;
        layoutParams2.x = (i - i4) + i6;
        layoutParams2.y = i2 + i7;
        layoutParams2.windowAnimations = 0;
        layoutParams2.format = -3;
        if (this.J) {
            this.A.updateViewLayout(this.K, layoutParams2);
        } else {
            this.A.addView(this.K, layoutParams2);
            this.J = true;
        }
    }

    private float[] a(String str) {
        if (str == null) {
            return new float[0];
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(" *[ ,;] *")) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(str2)));
            } catch (NumberFormatException unused) {
            }
        }
        float[] fArr = new float[arrayList.size()];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = ((Float) arrayList.get(i)).floatValue();
        }
        Arrays.sort(fArr);
        return fArr;
    }

    public Slider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22086a = 1;
        this.f22088c = new Paint();
        this.f22089d = 0.0f;
        this.f22090e = 100.0f;
        this.f22091f = 0.0f;
        this.f22092g = 0.0f;
        this.f22093h = new float[0];
        this.i = new float[0];
        this.j = new float[0];
        this.k = new float[0];
        this.m = new Rect();
        this.n = new RectF();
        this.t = -1.0f;
        this.x = false;
        this.y = -858993460;
        this.z = null;
        this.A = null;
        this.K = null;
        this.L = null;
        this.P = false;
        this.V = false;
        a();
        a(attributeSet);
    }

    private void a(Canvas canvas) {
        this.f22088c.reset();
        int d2 = d(this.f22091f);
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.slider_thumb_text_size);
        a(this.m);
        int i = this.f22086a;
        if (i == 1) {
            int i2 = this.m.left + (this.B * 2);
            if (isEnabled()) {
                this.f22088c.setColor(this.D);
            } else {
                this.f22088c.setColor(getResources().getColor(R.color.slider_disable));
            }
            this.f22088c.setFlags(1);
            canvas.drawCircle(i2, d2, this.B, this.f22088c);
            if (this.u || this.v) {
                return;
            }
            String a2 = a(this.f22091f);
            while (dimensionPixelSize > 5.0f) {
                this.f22088c.setTextSize(dimensionPixelSize);
                if (this.f22088c.measureText(a2) < (this.B * 2) - 10) {
                    break;
                }
                double d3 = dimensionPixelSize;
                Double.isNaN(d3);
                dimensionPixelSize = (float) (d3 - 0.5d);
            }
            this.f22088c.getTextBounds(a2, 0, a2.length(), new Rect());
            if (isEnabled()) {
                this.f22088c.setColor(getResources().getColor(R.color.slider_thumb_text));
            } else {
                this.f22088c.setColor(getResources().getColor(R.color.slider_thumb_text_disable));
            }
            canvas.drawText(a2, (i2 - (r1.width() / 2)) - this.C, d2 + (r1.height() / 2), this.f22088c);
            return;
        }
        if (i == 0) {
            int centerY = this.m.centerY();
            if (isEnabled()) {
                this.f22088c.setColor(this.D);
            } else {
                this.f22088c.setColor(getResources().getColor(R.color.slider_disable));
            }
            this.f22088c.setFlags(1);
            canvas.drawCircle(d2, centerY, this.B, this.f22088c);
            if (this.u || this.v) {
                return;
            }
            String a3 = a(this.f22091f);
            while (dimensionPixelSize > 5.0f) {
                this.f22088c.setTextSize(dimensionPixelSize);
                if (this.f22088c.measureText(a3) < (this.B * 2) - 10) {
                    break;
                }
                double d4 = dimensionPixelSize;
                Double.isNaN(d4);
                dimensionPixelSize = (float) (d4 - 0.5d);
            }
            this.f22088c.getTextBounds(a3, 0, a3.length(), new Rect());
            if (isEnabled()) {
                this.f22088c.setColor(getResources().getColor(R.color.slider_thumb_text));
            } else {
                this.f22088c.setColor(getResources().getColor(R.color.slider_thumb_text_disable));
            }
            canvas.drawText(a3, (d2 - (r1.width() / 2)) - this.C, centerY + (r1.height() / 2), this.f22088c);
        }
    }

    @TargetApi(21)
    public Slider(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f22086a = 1;
        this.f22088c = new Paint();
        this.f22089d = 0.0f;
        this.f22090e = 100.0f;
        this.f22091f = 0.0f;
        this.f22092g = 0.0f;
        this.f22093h = new float[0];
        this.i = new float[0];
        this.j = new float[0];
        this.k = new float[0];
        this.m = new Rect();
        this.n = new RectF();
        this.t = -1.0f;
        this.x = false;
        this.y = -858993460;
        this.z = null;
        this.A = null;
        this.K = null;
        this.L = null;
        this.P = false;
        this.V = false;
        a();
        a(attributeSet);
    }

    private float c(float f2) {
        float f3 = this.f22089d;
        return (f2 - f3) / (this.f22090e - f3);
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.u || this.v) {
            return false;
        }
        this.W = System.nanoTime() - 1;
        if (com.nexstreaming.app.general.util.O.a(this)) {
            this.W += 350000000;
            this.ba = this.aa;
        } else {
            this.ba = this.aa / 3.0f;
        }
        this.N.a();
        if (!this.P && System.nanoTime() > this.W) {
            c();
        }
        this.u = false;
        this.v = true;
        float x = motionEvent.getX();
        this.q = x;
        this.o = x;
        float y = motionEvent.getY();
        this.r = y;
        this.p = y;
        this.s = this.f22091f;
        a aVar = this.z;
        if (aVar != null) {
            aVar.b();
        }
        invalidate();
        return true;
    }

    public boolean a(MotionEvent motionEvent, boolean z) {
        if (!this.u && !this.v) {
            return false;
        }
        if (z) {
            this.f22091f = this.s;
        }
        this.N.b();
        b();
        this.u = false;
        this.v = false;
        a aVar = this.z;
        if (aVar != null) {
            aVar.a();
        }
        invalidate();
        return true;
    }

    private void b() {
        if (this.J) {
            this.A.removeView(this.K);
            this.J = false;
        }
    }

    private float a(int i) {
        int i2 = this.f22086a;
        if (i2 == 1) {
            return a((getHeight() - i) - getPaddingBottom(), getHeight() - getVPadding());
        }
        if (i2 == 0) {
            return a(i - getPaddingLeft(), getWidth() - getHPadding());
        }
        return 0.0f;
    }

    public float b(float f2) {
        return TypedValue.applyDimension(1, f2, this.f22087b);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.Slider.b(android.view.MotionEvent):boolean");
    }

    private int a(float f2, int i) {
        float c2;
        int i2;
        if (this.f22086a == 1) {
            float c3 = c(f2);
            c2 = c3 * (i - (r1.length * this.l));
            for (float f3 : this.f22093h) {
                if (Math.abs(f3 - f2) < 1.0E-4f) {
                    i2 = this.l / 2;
                } else if (f3 < f2) {
                    i2 = this.l;
                }
                c2 += i2;
            }
        } else {
            c2 = c(f2) * i;
        }
        return (int) c2;
    }

    private float a(int i, int i2) {
        float f2;
        float f3;
        if (this.f22086a == 1) {
            f2 = i;
            f3 = i2 - (this.f22093h.length * this.l);
        } else {
            f2 = i;
            f3 = i2;
        }
        float f4 = f2 / f3;
        float[] fArr = this.f22093h;
        int length = fArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            float f5 = fArr[i3];
            if (c(f5) < f4 && c(f5) + (this.l / i2) > f4) {
                f4 = c(f5);
                break;
            }
            if (c(f5) < f4) {
                f4 -= this.l / i2;
            }
            i3++;
        }
        float f6 = this.f22089d;
        return f6 + (f4 * (this.f22090e - f6));
    }

    private void a(Rect rect) {
        rect.left = getPaddingLeft();
        rect.right = getWidth() - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = getHeight() - getPaddingBottom();
    }

    public String a(float f2) {
        if (this.O == StartDirection.right) {
            f2 = this.f22090e - f2;
        }
        switch (Lg.f21951a[this.I.ordinal()]) {
            case 1:
                return "";
            case 2:
                return " " + (this.V ? Math.abs((int) f2) : (int) f2) + "% ";
            case 3:
                int abs = this.V ? Math.abs((int) f2) : (int) f2;
                if (abs < 0) {
                    return " " + abs + " ";
                }
                if (abs <= 0) {
                    return Math.max(Math.abs(this.f22090e), Math.abs(this.f22089d)) >= 10.0f ? " 00 " : " 0 ";
                }
                return " +" + abs + " ";
            case 4:
                return " " + ((int) f2) + " ";
            case 5:
                return " " + (((int) f2) / 100.0f) + FragmentC2201x.f23219a;
            case 6:
                int i = (int) f2;
                int i2 = (int) ((f2 * 100.0f) % 100.0f);
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                Resources resources = getResources();
                Object[] objArr = new Object[1];
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append(".");
                sb2.append(i2);
                sb2.append(i2 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "");
                objArr[0] = sb2.toString();
                sb.append(resources.getString(R.string.transition_time_n, objArr));
                return sb.toString();
            default:
                return "";
        }
    }
}
