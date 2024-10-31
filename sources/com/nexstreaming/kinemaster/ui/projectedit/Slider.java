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
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.b;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Slider extends View {
    private int A;
    private int B;
    private int C;
    private boolean D;
    private float E;
    private ShowValueStyle F;
    private boolean G;
    private FrameLayout H;
    private TextView I;
    private WindowManager.LayoutParams J;
    private com.nextreaming.nexeditorui.ck K;
    private StartDirection L;
    private boolean M;
    private String N;
    private String O;
    private int P;
    private int Q;
    private int R;
    private boolean S;

    /* renamed from: a, reason: collision with root package name */
    private int f3744a;
    private DisplayMetrics b;
    private Paint c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float[] h;
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
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private a w;
    private WindowManager x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum ShowValueStyle {
        unsigned,
        signed,
        percent,
        rate,
        timemillis,
        none
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum StartDirection {
        left,
        right
    }

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(float f);

        void b();
    }

    public Slider(Context context) {
        super(context);
        this.f3744a = 1;
        this.c = new Paint();
        this.d = 0.0f;
        this.e = 100.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = new float[0];
        this.i = new float[0];
        this.j = new float[0];
        this.k = new float[0];
        this.m = new Rect();
        this.n = new RectF();
        this.r = -1.0f;
        this.u = false;
        this.v = -858993460;
        this.w = null;
        this.x = null;
        this.H = null;
        this.I = null;
        this.M = false;
        this.S = false;
        a();
    }

    public Slider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3744a = 1;
        this.c = new Paint();
        this.d = 0.0f;
        this.e = 100.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = new float[0];
        this.i = new float[0];
        this.j = new float[0];
        this.k = new float[0];
        this.m = new Rect();
        this.n = new RectF();
        this.r = -1.0f;
        this.u = false;
        this.v = -858993460;
        this.w = null;
        this.x = null;
        this.H = null;
        this.I = null;
        this.M = false;
        this.S = false;
        a();
        a(attributeSet);
    }

    public Slider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3744a = 1;
        this.c = new Paint();
        this.d = 0.0f;
        this.e = 100.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = new float[0];
        this.i = new float[0];
        this.j = new float[0];
        this.k = new float[0];
        this.m = new Rect();
        this.n = new RectF();
        this.r = -1.0f;
        this.u = false;
        this.v = -858993460;
        this.w = null;
        this.x = null;
        this.H = null;
        this.I = null;
        this.M = false;
        this.S = false;
        a();
        a(attributeSet);
    }

    @TargetApi(21)
    public Slider(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3744a = 1;
        this.c = new Paint();
        this.d = 0.0f;
        this.e = 100.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = new float[0];
        this.i = new float[0];
        this.j = new float[0];
        this.k = new float[0];
        this.m = new Rect();
        this.n = new RectF();
        this.r = -1.0f;
        this.u = false;
        this.v = -858993460;
        this.w = null;
        this.x = null;
        this.H = null;
        this.I = null;
        this.M = false;
        this.S = false;
        a();
        a(attributeSet);
    }

    private void a() {
        setLayerType(1, null);
        this.x = (WindowManager) getContext().getSystemService("window");
        this.b = getResources().getDisplayMetrics();
        this.K = new com.nextreaming.nexeditorui.ck(this.x.getDefaultDisplay());
        this.K.a(new kt(this));
    }

    private void a(AttributeSet attributeSet) {
        int i = 0;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, b.a.Slider, 0, 0);
        this.f3744a = obtainStyledAttributes.getInteger(0, 0);
        this.y = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.z = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.A = obtainStyledAttributes.getColor(3, -1);
        this.v = obtainStyledAttributes.getColor(4, -858993460);
        this.B = obtainStyledAttributes.getColor(5, -65536);
        this.C = obtainStyledAttributes.getColor(6, -16776961);
        this.D = obtainStyledAttributes.getBoolean(12, false);
        this.t = obtainStyledAttributes.getBoolean(13, false);
        this.E = obtainStyledAttributes.getFloat(7, 0.0f);
        this.g = obtainStyledAttributes.getFloat(11, 0.0f);
        this.d = obtainStyledAttributes.getFloat(9, 0.0f);
        this.e = obtainStyledAttributes.getFloat(10, 0.0f);
        this.f = obtainStyledAttributes.getFloat(8, 0.0f);
        this.l = obtainStyledAttributes.getDimensionPixelSize(17, 0);
        this.N = obtainStyledAttributes.getString(22);
        this.O = obtainStyledAttributes.getString(23);
        this.P = obtainStyledAttributes.getColor(24, this.v);
        this.Q = obtainStyledAttributes.getColor(25, this.v);
        this.R = obtainStyledAttributes.getColor(26, this.v);
        this.S = obtainStyledAttributes.getBoolean(27, false);
        int integer = obtainStyledAttributes.getInteger(14, 0);
        ShowValueStyle[] values = ShowValueStyle.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            ShowValueStyle showValueStyle = values[i2];
            if (integer != showValueStyle.ordinal()) {
                i2++;
            } else {
                this.F = showValueStyle;
                break;
            }
        }
        int integer2 = obtainStyledAttributes.getInteger(15, 0);
        StartDirection[] values2 = StartDirection.values();
        int length2 = values2.length;
        while (true) {
            if (i >= length2) {
                break;
            }
            StartDirection startDirection = values2[i];
            if (integer2 != startDirection.ordinal()) {
                i++;
            } else {
                this.L = startDirection;
                break;
            }
        }
        this.h = a(obtainStyledAttributes.getString(18));
        this.k = a(obtainStyledAttributes.getString(21));
        this.i = a(obtainStyledAttributes.getString(19));
        this.j = a(obtainStyledAttributes.getString(20));
    }

    private float[] a(String str) {
        int i = 0;
        if (str == null) {
            return new float[0];
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(" *[ ,;] *")) {
            try {
                arrayList.add(Float.valueOf(Float.parseFloat(str2)));
            } catch (NumberFormatException e) {
            }
        }
        float[] fArr = new float[arrayList.size()];
        while (true) {
            int i2 = i;
            if (i2 < fArr.length) {
                fArr[i2] = ((Float) arrayList.get(i2)).floatValue();
                i = i2 + 1;
            } else {
                Arrays.sort(fArr);
                return fArr;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
        c(canvas);
    }

    private void a(Canvas canvas) {
        this.c.reset();
        a(this.m);
        if (this.f3744a == 1) {
            this.m.left += (this.m.width() - this.z) / 2;
            this.m.right = this.m.left + this.z;
            this.m.top += this.y / 2;
            this.m.bottom -= this.y / 2;
            RectF rectF = new RectF(this.m);
            this.c.setColor(this.B);
            canvas.drawRoundRect(rectF, 7.0f, 7.0f, this.c);
            canvas.save();
            RectF rectF2 = new RectF(this.m);
            rectF2.top = c(this.f);
            if (isEnabled()) {
                this.c.setColor(this.C);
            } else {
                rectF2.top += this.y + b(1.0f);
                this.c.setColor(getResources().getColor(R.color.slider_disable));
            }
            Path path = new Path();
            path.addRoundRect(rectF2, 7.0f, 7.0f, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.drawRect(rectF2, this.c);
            canvas.restore();
            return;
        }
        if (this.f3744a == 0) {
            this.m.top += (this.m.height() - this.z) / 2;
            this.m.bottom = this.m.top + this.z;
            RectF rectF3 = new RectF(this.m);
            rectF3.left -= this.z / 2;
            rectF3.right += this.z / 2;
            if (this.L == StartDirection.left) {
                this.c.setColor(this.B);
            } else if (this.L == StartDirection.right) {
                this.c.setColor(isEnabled() ? this.C : this.B);
            }
            canvas.drawRoundRect(rectF3, this.z / 2.0f, this.z / 2.0f, this.c);
            if (isEnabled()) {
                if (this.L == StartDirection.left) {
                    this.c.setColor(this.C);
                } else if (this.L == StartDirection.right) {
                    this.c.setColor(this.B);
                }
                rectF3.right = c(this.f);
                canvas.drawRoundRect(rectF3, this.z / 2.0f, this.z / 2.0f, this.c);
            }
        }
    }

    private void b(Canvas canvas) {
        float b = b(1.0f);
        this.c.reset();
        this.c.setColor(this.v);
        this.c.setStyle(Paint.Style.FILL);
        a(this.m);
        int i = 0;
        int width = ((this.m.width() - this.z) / 2) + this.m.left;
        int width2 = ((this.m.width() + this.z) / 2) + this.m.left;
        int height = ((this.m.height() - this.z) / 2) + this.m.top;
        int height2 = ((this.m.height() + this.z) / 2) + this.m.top;
        if (this.f3744a == 1) {
            i = this.y * 2;
            this.m.left = (int) (width - b(9.0f));
            this.m.right = (int) (width - b(3.0f));
        } else if (this.f3744a == 0) {
            i = this.y * 2;
            this.m.top = (int) (height - b(6.0f));
            this.m.bottom = (int) (height - b(3.0f));
        }
        if (this.t) {
            for (float f : this.h) {
                int c = c(f);
                if (this.f3744a == 1) {
                    this.m.top = c + ((int) (this.y + b));
                    this.m.bottom = this.m.top + ((int) b);
                } else if (this.f3744a == 0) {
                    this.m.left = (c - ((int) (b / 2.0f))) + (i / 2);
                    this.m.right = this.m.left + ((int) b);
                }
                canvas.drawRect(this.m, this.c);
            }
        }
        for (float f2 : this.i) {
            int c2 = c(f2);
            if (this.f3744a == 1) {
                this.n.top = (c2 + (this.y / 2)) - (b / 2.0f);
                this.n.bottom = this.n.top + ((int) (b / 2.0f));
                this.n.left = width - b(5.0f);
                this.n.right = width - b(3.0f);
                canvas.drawRect(this.n, this.c);
                this.n.left = width2 + b(3.0f);
                this.n.right = width2 + b(5.0f);
                canvas.drawRect(this.n, this.c);
            } else if (this.f3744a == 0) {
                this.n.left = (c2 - ((int) (b / 2.0f))) + (this.z / 2);
                this.n.right = this.n.left + ((int) b);
                this.n.top = height - b(5.0f);
                this.n.bottom = height - b(3.0f);
                canvas.drawRect(this.n, this.c);
                this.n.top = height2 + b(3.0f);
                this.n.bottom = height2 + b(5.0f);
                canvas.drawRect(this.n, this.c);
            }
        }
        for (float f3 : this.j) {
            int c3 = c(f3);
            if (this.f3744a == 1) {
                this.n.top = (c3 + (this.y / 2)) - (b / 2.0f);
                this.n.bottom = this.n.top + ((int) (b / 2.0f));
                this.n.left = width - b(7.0f);
                this.n.right = width - b(3.0f);
                canvas.drawRect(this.n, this.c);
                this.n.left = width2 + b(3.0f);
                this.n.right = width2 + b(7.0f);
                canvas.drawRect(this.n, this.c);
            } else if (this.f3744a == 0) {
                this.n.left = (c3 - ((int) (b / 2.0f))) + (this.z / 2);
                this.n.right = this.n.left + ((int) b);
                this.n.top = height - b(7.0f);
                this.n.bottom = height - b(3.0f);
                canvas.drawRect(this.n, this.c);
                this.n.top = height2 + b(3.0f);
                this.n.bottom = height2 + b(7.0f);
                canvas.drawRect(this.n, this.c);
            }
        }
        float[] fArr = this.k;
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            float f4 = fArr[i2];
            int c4 = c(f4);
            if (this.f3744a == 1) {
                this.n.top = (c4 + (this.y / 2)) - (f4 <= this.E ? getPaddingBottom() : 0);
                this.n.bottom = this.n.top + ((int) b);
                this.n.left = width - b(9.0f);
                this.n.right = width - b(3.0f);
                canvas.drawRect(this.n, this.c);
                this.n.left = width2 + b(3.0f);
                this.n.right = width2 + b(9.0f);
                canvas.drawRect(this.n, this.c);
            } else if (this.f3744a == 0) {
                this.n.left = c4 - ((int) (b / 2.0f));
                this.n.right = this.n.left + ((int) b);
                this.n.top = height - b(9.0f);
                this.n.bottom = height - b(3.0f);
                canvas.drawRect(this.n, this.c);
                this.n.top = height2 + b(3.0f);
                this.n.bottom = height2 + b(9.0f);
                canvas.drawRect(this.n, this.c);
            }
        }
        if (this.O != null) {
            int c5 = c(this.e);
            if (this.f3744a != 1 && this.f3744a == 0) {
                this.c.setTextAlign(Paint.Align.CENTER);
                this.c.setTextSize(b(8.0f));
                this.c.setTypeface(Typeface.DEFAULT_BOLD);
                this.c.setColor(this.Q);
                canvas.drawText(this.O, c5, height - b(12.0f), this.c);
            }
        }
        if (this.N != null) {
            int c6 = c(this.d);
            if (this.f3744a != 1 && this.f3744a == 0) {
                this.c.setTextAlign(Paint.Align.CENTER);
                this.c.setTextSize(b(8.0f));
                this.c.setTypeface(Typeface.DEFAULT_BOLD);
                this.c.setColor(this.P);
                canvas.drawText(this.N, c6, height - b(12.0f), this.c);
            }
        }
        if (this.D) {
            int c7 = c(this.L == StartDirection.left ? this.E : this.e - this.E);
            if (this.R != this.v) {
                this.c.setColor(this.R);
            }
            if (this.f3744a == 1) {
                this.m.top = c7;
                this.m.bottom = this.m.top + ((int) b);
                canvas.drawRect(this.m, this.c);
                this.m.left = (int) (width2 + b(5.0f));
                this.m.right = (int) (width2 + b(11.0f));
                canvas.drawRect(this.m, this.c);
                return;
            }
            if (this.f3744a == 0) {
                this.n.left = c7 - ((int) (b / 2.0f));
                this.n.right = this.n.left + ((int) b);
                this.n.top = height - b(9.0f);
                this.n.bottom = height - b(3.0f);
                canvas.drawRect(this.n, this.c);
                this.n.top = height2 + b(3.0f);
                this.n.bottom = height2 + b(9.0f);
                canvas.drawRect(this.n, this.c);
            }
        }
    }

    private void c(Canvas canvas) {
        this.c.reset();
        int c = c(this.f);
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.slider_thumb_text_size);
        a(this.m);
        if (this.f3744a == 1) {
            int i = this.m.left + (this.y * 2);
            if (isEnabled()) {
                this.c.setColor(this.A);
            } else {
                this.c.setColor(getResources().getColor(R.color.slider_disable));
            }
            this.c.setFlags(1);
            canvas.drawCircle(i, c, this.y, this.c);
            if (!this.s) {
                String a2 = a(this.f);
                while (dimensionPixelSize > 5.0f) {
                    this.c.setTextSize(dimensionPixelSize);
                    if (this.c.measureText(a2) < (this.y * 2) - 10) {
                        break;
                    } else {
                        dimensionPixelSize = (float) (dimensionPixelSize - 0.5d);
                    }
                }
                this.c.getTextBounds(a2, 0, a2.length(), new Rect());
                if (isEnabled()) {
                    this.c.setColor(getResources().getColor(R.color.slider_thumb_text));
                } else {
                    this.c.setColor(getResources().getColor(R.color.slider_thumb_text_disable));
                }
                canvas.drawText(a2, (i - (r0.width() / 2)) - this.z, (r0.height() / 2) + c, this.c);
                return;
            }
            return;
        }
        if (this.f3744a == 0) {
            int centerY = this.m.centerY();
            if (isEnabled()) {
                this.c.setColor(this.A);
            } else {
                this.c.setColor(getResources().getColor(R.color.slider_disable));
            }
            this.c.setFlags(1);
            canvas.drawCircle(c, centerY, this.y, this.c);
            if (!this.s) {
                String a3 = a(this.f);
                while (dimensionPixelSize > 5.0f) {
                    this.c.setTextSize(dimensionPixelSize);
                    if (this.c.measureText(a3) < (this.y * 2) - 10) {
                        break;
                    } else {
                        dimensionPixelSize = (float) (dimensionPixelSize - 0.5d);
                    }
                }
                this.c.getTextBounds(a3, 0, a3.length(), new Rect());
                if (isEnabled()) {
                    this.c.setColor(getResources().getColor(R.color.slider_thumb_text));
                } else {
                    this.c.setColor(getResources().getColor(R.color.slider_thumb_text_disable));
                }
                canvas.drawText(a3, (c - (r0.width() / 2)) - this.z, (r0.height() / 2) + centerY, this.c);
            }
        }
    }

    private void b() {
        int i;
        int i2;
        int i3;
        int i4;
        int c = c(this.f);
        a(this.m);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (this.f3744a == 1) {
            int i7 = this.y * 2;
            i = c - (i7 / 2);
            i2 = (this.m.left + (this.m.width() / 2)) - ((i7 / 3) * 2);
        } else if (this.f3744a == 0) {
            int i8 = this.y * 2;
            i = ((this.m.top + ((this.m.height() - this.z) / 2)) - getResources().getDimensionPixelSize(R.dimen.slider_valuetab_horizontal_height)) - ((i8 / 5) * 3);
            i2 = c + ((i8 / 6) * 5);
        } else {
            i = 0;
            i2 = 0;
        }
        if (this.J == null) {
            this.J = new WindowManager.LayoutParams();
        }
        if (this.H == null) {
            this.H = new FrameLayout(getContext());
            this.I = new ku(this, getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 5;
            this.I.setLayerType(1, null);
            this.H.setLayerType(1, null);
            this.H.addView(this.I, layoutParams);
        } else {
            this.I.invalidate();
        }
        if (this.f3744a == 1) {
            i4 = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_vertical_height);
            i3 = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_vertical_width);
        } else if (this.f3744a == 0) {
            i4 = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_horizontal_height);
            i3 = getResources().getDimensionPixelSize(R.dimen.slider_valuetab_horizontal_width);
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.J.height = i4;
        this.J.width = i3;
        this.J.flags = 904;
        this.J.gravity = 51;
        this.J.x = (i2 - i3) + i5;
        this.J.y = i + i6;
        this.J.windowAnimations = 0;
        this.J.format = -3;
        if (this.G) {
            this.x.updateViewLayout(this.H, this.J);
        } else {
            this.x.addView(this.H, this.J);
            this.G = true;
        }
    }

    private void c() {
        boolean z = false;
        if (this.s) {
            z = true;
        }
        if (!this.M && z) {
            b();
        } else {
            d();
        }
    }

    private void d() {
        if (this.G) {
            this.x.removeView(this.H);
            this.G = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float b(float f) {
        return TypedValue.applyDimension(1, f, this.b);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            d();
            this.s = false;
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (a(motionEvent)) {
                    return true;
                }
                break;
            case 1:
            case 3:
            case 5:
                if (c(motionEvent)) {
                }
                return true;
            case 2:
                if (b(motionEvent)) {
                }
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.s) {
            return false;
        }
        this.K.a();
        if (!this.M) {
            b();
        }
        this.s = true;
        this.o = motionEvent.getX();
        this.p = motionEvent.getY();
        this.q = this.f;
        if (this.w != null) {
            this.w.a();
        }
        invalidate();
        return true;
    }

    private boolean b(MotionEvent motionEvent) {
        if (!this.s) {
            return false;
        }
        float x = motionEvent.getX() - this.o;
        float y = motionEvent.getY() - this.p;
        if (x > 6.0f) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        float f = this.f;
        if (this.f3744a == 1) {
            f = a((int) (c(this.q) + y));
        } else if (this.f3744a == 0) {
            f = a((int) (c(this.q) + x));
        }
        if (f < this.d) {
            f = this.d;
        }
        if (this.g > 0.0f) {
            f = (((int) (((f - this.d) + (this.g / 2.0f)) / this.g)) * this.g) + this.d;
        }
        if (f > this.e) {
            f = this.e;
        }
        if (this.r != -1.0f && this.L == StartDirection.right && f <= this.e - this.r) {
            f = this.e - this.r;
        } else if (this.r != -1.0f && this.L == StartDirection.left && f >= this.r) {
            f = this.r;
        }
        if (this.f != f) {
            this.f = f;
            if (this.w != null) {
                this.w.a(this.f);
            }
            invalidate();
        }
        c();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(MotionEvent motionEvent) {
        if (!this.s) {
            return false;
        }
        this.K.b();
        d();
        this.s = false;
        if (this.w != null) {
            this.w.b();
        }
        invalidate();
        return true;
    }

    private int c(float f) {
        if (this.f3744a == 1) {
            return getHeight() - (a(f, getHeight() - getVPadding()) + getPaddingBottom());
        }
        if (this.f3744a == 0) {
            return a(f, getWidth() - getHPadding()) + getPaddingLeft();
        }
        return 0;
    }

    private float a(int i) {
        if (this.f3744a == 1) {
            return a((getHeight() - i) - getPaddingBottom(), getHeight() - getVPadding());
        }
        if (this.f3744a == 0) {
            return a(i - getPaddingLeft(), getWidth() - getHPadding());
        }
        return 0.0f;
    }

    private int a(float f, int i) {
        float d;
        if (this.f3744a == 1) {
            d = d(f) * (i - (this.h.length * this.l));
        } else {
            d = d(f) * i;
        }
        return (int) d;
    }

    private float d(float f) {
        return (f - this.d) / (this.e - this.d);
    }

    private float a(int i, int i2) {
        float[] fArr = this.h;
        int length = fArr.length;
        float f = i / i2;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            float f2 = fArr[i3];
            if (d(f2) >= f || d(f2) + (this.l / i2) <= f) {
                if (d(f2) < f) {
                    f -= this.l / i2;
                }
                i3++;
            } else {
                f = d(f2);
                break;
            }
        }
        return (f * (this.e - this.d)) + this.d;
    }

    private int getVPadding() {
        return getPaddingTop() + getPaddingBottom();
    }

    private int getHPadding() {
        return getPaddingLeft() + getPaddingRight();
    }

    private void a(Rect rect) {
        rect.left = getPaddingLeft();
        rect.right = getWidth() - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = getHeight() - getPaddingBottom();
    }

    public void setListener(a aVar) {
        this.w = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(float f) {
        if (this.L == StartDirection.right) {
            f = this.e - f;
        }
        switch (this.F) {
            case none:
                return "";
            case percent:
                return " " + (this.S ? Math.abs((int) f) : (int) f) + "% ";
            case signed:
                int abs = this.S ? Math.abs((int) f) : (int) f;
                if (abs < 0) {
                    return " " + abs + " ";
                }
                if (abs > 0) {
                    return " +" + abs + " ";
                }
                return Math.max(Math.abs(this.e), Math.abs(this.d)) >= 10.0f ? " 00 " : " 0 ";
            case unsigned:
                return " " + ((int) f) + " ";
            case rate:
                return " " + (((int) f) / 100.0f) + "x";
            case timemillis:
                int i = (int) ((f * 100.0f) % 100.0f);
                StringBuilder append = new StringBuilder().append(" ");
                Resources resources = getResources();
                Object[] objArr = new Object[1];
                objArr[0] = ((int) f) + "." + i + (i < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "");
                return append.append(resources.getString(R.string.transition_time_n, objArr)).toString();
            default:
                return "";
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.K.b();
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        if (i == 0) {
            this.s = false;
            d();
            invalidate();
        }
        super.onScreenStateChanged(i);
    }

    public void setDefaultValue(float f) {
        this.E = f;
    }

    public void setSnapAt(String str) {
        int i = 0;
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : str.split(" *[ ,;] *")) {
                try {
                    arrayList.add(Float.valueOf(Float.parseFloat(str2)));
                } catch (NumberFormatException e) {
                }
            }
            this.h = new float[arrayList.size()];
            while (true) {
                int i2 = i;
                if (i2 < this.h.length) {
                    this.h[i2] = ((Float) arrayList.get(i2)).floatValue();
                    i = i2 + 1;
                } else {
                    Arrays.sort(this.h);
                    return;
                }
            }
        }
    }

    public void setSnapAt(float f) {
    }

    public void setMaxValue(float f) {
        this.e = f;
        invalidate();
    }

    public void setMinValue(float f) {
        this.d = f;
        invalidate();
    }

    public float getMaxValue() {
        return this.e;
    }

    public float getMinValue() {
        return this.d;
    }

    public void setValue(float f) {
        this.f = f;
        invalidate();
    }

    public void setDraggingLimitValue(float f) {
        this.r = f;
        invalidate();
    }

    public float getValue() {
        return this.L == StartDirection.left ? this.f : this.e - this.f;
    }

    public void setHideValueTab(boolean z) {
        this.M = z;
    }
}
