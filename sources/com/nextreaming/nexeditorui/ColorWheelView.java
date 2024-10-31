package com.nextreaming.nexeditorui;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class ColorWheelView extends View {

    /* renamed from: a */
    private Rect f24001a;

    /* renamed from: b */
    private final int[] f24002b;

    /* renamed from: c */
    private final int[] f24003c;

    /* renamed from: d */
    private Path f24004d;

    /* renamed from: e */
    private int f24005e;

    /* renamed from: f */
    private Paint f24006f;

    /* renamed from: g */
    private SweepGradient f24007g;

    /* renamed from: h */
    private int f24008h;
    private int i;
    private int j;
    private EmbossMaskFilter k;
    float[] l;
    int[] m;
    private boolean n;
    private float o;
    private float p;
    private float q;
    private a r;
    final int[] s;
    final float[] t;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    public ColorWheelView(Context context) {
        super(context);
        this.f24001a = new Rect();
        this.f24002b = new int[0];
        this.f24003c = new int[]{R.attr.state_pressed};
        this.f24004d = null;
        this.f24006f = new Paint();
        this.f24007g = null;
        this.k = new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.0f, 8.0f, 1.25f);
        this.l = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.m = new int[]{ViewCompat.MEASURED_STATE_MASK, -1, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK};
        this.s = new int[]{SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -16711936, -16711681, -16776961, -65281, SupportMenu.CATEGORY_MASK};
        this.t = new float[]{0.0f, 0.166666f, 0.333333f, 0.5f, 0.666666f, 0.833333f, 1.0f};
        a(context);
    }

    private float a(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f6 - f4;
        float f9 = f7 - f5;
        float f10 = (((f2 - f4) * f8) + ((f3 - f5) * f9)) / ((f8 * f8) + (f9 * f9));
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > 1.0f) {
            return 1.0f;
        }
        return f10;
    }

    private int a(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    int getColor() {
        return Color.HSVToColor(new float[]{this.o, this.p, this.q});
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(ColorWheelView.class.getName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x01b0, code lost:            if (r36.j != r4) goto L45;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r37) {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.ColorWheelView.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int a2 = a(200);
        int a3 = a(200);
        Drawable background = getBackground();
        if (background != null) {
            if (background.getIntrinsicWidth() != -1) {
                a2 = background.getIntrinsicWidth();
            }
            if (background.getIntrinsicHeight() != -1) {
                a3 = background.getIntrinsicHeight();
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(View.MeasureSpec.getSize(i), a2), Math.min(View.MeasureSpec.getSize(i2), a3));
        } else if (mode != 1073741824) {
            setMeasuredDimension(a2, a3);
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int width = getWidth();
        int height = getHeight();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f2 = width / 2;
        float f3 = x - f2;
        float f4 = height / 2;
        float f5 = y - f4;
        int min = ((Math.min(width, height) / 2) - this.f24005e) - (this.f24008h / 2);
        boolean z = Math.abs(f3 * f3) + Math.abs(f5 * f5) > ((float) (min * min));
        float[] fArr = this.l;
        float f6 = fArr[0];
        float f7 = fArr[1];
        float f8 = fArr[2];
        float f9 = fArr[3];
        float f10 = fArr[4];
        float f11 = fArr[5];
        float f12 = f9 - f11;
        float f13 = x - f10;
        float f14 = f10 - f8;
        float f15 = y - f11;
        float f16 = (f12 * f13) + (f14 * f15);
        float f17 = f6 - f10;
        float f18 = (f12 * f17) + (f14 * (f7 - f11));
        float f19 = f16 / f18;
        float f20 = (((f11 - f7) * f13) + (f17 * f15)) / f18;
        float f21 = (1.0f - f20) - f19;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.n = z;
        } else if (actionMasked != 2) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.n) {
            this.o = a(motionEvent, f2, f4);
            a();
            invalidate();
            return true;
        }
        float[] fArr2 = {this.o, 1.0f, 1.0f};
        int HSVToColor = Color.HSVToColor(fArr2);
        if (f19 < 0.0f && f21 < 0.0f) {
            HSVToColor = -1;
        } else if (f20 < 0.0f && f21 < 0.0f) {
            HSVToColor = ViewCompat.MEASURED_STATE_MASK;
        } else if (f19 >= 0.0f || f20 >= 0.0f) {
            if (f19 < 0.0f) {
                float a2 = a(x, y, f10, f11, f8, f9);
                float f22 = 255.0f * a2;
                float f23 = 1.0f - a2;
                HSVToColor = Color.rgb((int) (f22 + (Color.red(HSVToColor) * f23)), (int) (f22 + (Color.green(HSVToColor) * f23)), (int) (f22 + (f23 * Color.blue(HSVToColor))));
            } else if (f21 < 0.0f) {
                int a3 = (int) (a(x, y, f6, f7, f8, f9) * 255.0f);
                HSVToColor = Color.rgb(a3, a3, a3);
            } else if (f20 < 0.0f) {
                float a4 = a(x, y, f6, f7, f10, f11);
                HSVToColor = Color.rgb((int) (Color.red(HSVToColor) * a4), (int) (Color.green(HSVToColor) * a4), (int) (a4 * Color.blue(HSVToColor)));
            } else {
                float f24 = f20 * 255.0f;
                HSVToColor = Color.rgb((int) (f24 + (Color.red(HSVToColor) * f21)), (int) (f24 + (Color.green(HSVToColor) * f21)), (int) (f24 + (f21 * Color.blue(HSVToColor))));
            }
        }
        Color.colorToHSV(HSVToColor, fArr2);
        this.p = fArr2[1];
        this.q = fArr2[2];
        a();
        invalidate();
        return true;
    }

    public void setColor(int i) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        Color.colorToHSV(i, fArr);
        this.o = fArr[0];
        this.p = fArr[1];
        this.q = fArr[2];
        invalidate();
    }

    public void setOnColorWheelChangeListener(a aVar) {
        this.r = aVar;
    }

    private void a(Context context) {
        setLayerType(1, null);
        this.f24005e = context.getResources().getDimensionPixelSize(com.nexstreaming.app.kinemasterfree.R.dimen.color_wheel_thickness);
        this.f24008h = context.getResources().getDimensionPixelSize(com.nexstreaming.app.kinemasterfree.R.dimen.color_wheel_border_size);
    }

    private float a(MotionEvent motionEvent, float f2, float f3) {
        int atan2 = (int) ((Math.atan2(motionEvent.getY() - f3, motionEvent.getX() - f2) * 180.0d) / 3.141592653589793d);
        if (atan2 < 0) {
            atan2 += 360;
        }
        return atan2;
    }

    private void a() {
        a aVar = this.r;
        if (aVar != null) {
            aVar.a(Color.HSVToColor(new float[]{this.o, this.p, this.q}));
        }
    }

    void a(Canvas canvas, Path path) {
        this.f24006f.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawPath(path, this.f24006f);
    }

    public ColorWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24001a = new Rect();
        this.f24002b = new int[0];
        this.f24003c = new int[]{R.attr.state_pressed};
        this.f24004d = null;
        this.f24006f = new Paint();
        this.f24007g = null;
        this.k = new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.0f, 8.0f, 1.25f);
        this.l = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.m = new int[]{ViewCompat.MEASURED_STATE_MASK, -1, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK};
        this.s = new int[]{SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -16711936, -16711681, -16776961, -65281, SupportMenu.CATEGORY_MASK};
        this.t = new float[]{0.0f, 0.166666f, 0.333333f, 0.5f, 0.666666f, 0.833333f, 1.0f};
        a(context);
    }

    public ColorWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24001a = new Rect();
        this.f24002b = new int[0];
        this.f24003c = new int[]{R.attr.state_pressed};
        this.f24004d = null;
        this.f24006f = new Paint();
        this.f24007g = null;
        this.k = new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.0f, 8.0f, 1.25f);
        this.l = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.m = new int[]{ViewCompat.MEASURED_STATE_MASK, -1, SupportMenu.CATEGORY_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK};
        this.s = new int[]{SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -16711936, -16711681, -16776961, -65281, SupportMenu.CATEGORY_MASK};
        this.t = new float[]{0.0f, 0.166666f, 0.333333f, 0.5f, 0.666666f, 0.833333f, 1.0f};
        a(context);
    }
}
