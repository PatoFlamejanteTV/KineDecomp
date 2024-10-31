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
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class ColorWheelView extends View {

    /* renamed from: a, reason: collision with root package name */
    float[] f4470a;
    int[] b;
    final int[] c;
    final float[] d;
    private Rect e;
    private final int[] f;
    private final int[] g;
    private Path h;
    private int i;
    private Paint j;
    private SweepGradient k;
    private int l;
    private int m;
    private int n;
    private EmbossMaskFilter o;
    private boolean p;
    private float q;
    private float r;
    private float s;
    private a t;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    public void setOnColorWheelChangeListener(a aVar) {
        this.t = aVar;
    }

    public ColorWheelView(Context context) {
        super(context);
        this.e = new Rect();
        this.f = new int[0];
        this.g = new int[]{R.attr.state_pressed};
        this.h = null;
        this.j = new Paint();
        this.k = null;
        this.o = new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.0f, 8.0f, 1.25f);
        this.f4470a = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.b = new int[]{-16777216, -1, -65536, -16777216, -16777216, -16777216};
        this.c = new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281, -65536};
        this.d = new float[]{0.0f, 0.166666f, 0.333333f, 0.5f, 0.666666f, 0.833333f, 1.0f};
        a();
    }

    public ColorWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Rect();
        this.f = new int[0];
        this.g = new int[]{R.attr.state_pressed};
        this.h = null;
        this.j = new Paint();
        this.k = null;
        this.o = new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.0f, 8.0f, 1.25f);
        this.f4470a = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.b = new int[]{-16777216, -1, -65536, -16777216, -16777216, -16777216};
        this.c = new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281, -65536};
        this.d = new float[]{0.0f, 0.166666f, 0.333333f, 0.5f, 0.666666f, 0.833333f, 1.0f};
        a();
    }

    public ColorWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new Rect();
        this.f = new int[0];
        this.g = new int[]{R.attr.state_pressed};
        this.h = null;
        this.j = new Paint();
        this.k = null;
        this.o = new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.0f, 8.0f, 1.25f);
        this.f4470a = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.b = new int[]{-16777216, -1, -65536, -16777216, -16777216, -16777216};
        this.c = new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281, -65536};
        this.d = new float[]{0.0f, 0.166666f, 0.333333f, 0.5f, 0.666666f, 0.833333f, 1.0f};
        a();
    }

    private int a(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    private void a() {
        setLayerType(1, null);
        this.i = a(28);
        this.l = a(4);
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
        switch (View.MeasureSpec.getMode(i2)) {
            case NexEditorDeviceProfile.UNKNOWN /* -2147483648 */:
                setMeasuredDimension(Math.min(View.MeasureSpec.getSize(i), a2), Math.min(View.MeasureSpec.getSize(i2), a3));
                return;
            case 1073741824:
                setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
                return;
            default:
                setMeasuredDimension(a2, a3);
                return;
        }
    }

    private float a(MotionEvent motionEvent, float f, float f2) {
        int atan2 = (int) ((Math.atan2(motionEvent.getY() - f2, motionEvent.getX() - f) * 180.0d) / 3.141592653589793d);
        if (atan2 < 0) {
            atan2 += 360;
        }
        return atan2;
    }

    private void b() {
        if (this.t != null) {
            this.t.a(Color.HSVToColor(new float[]{this.q, this.r, this.s}));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setColor(int i) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        Color.colorToHSV(i, fArr);
        this.q = fArr[0];
        this.r = fArr[1];
        this.s = fArr[2];
        invalidate();
    }

    int getColor() {
        return Color.HSVToColor(new float[]{this.q, this.r, this.s});
    }

    private float a(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / ((f7 * f7) + (f8 * f8));
        float f10 = f9 >= 0.0f ? f9 : 0.0f;
        if (f10 > 1.0f) {
            return 1.0f;
        }
        return f10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int rgb;
        int width = getWidth();
        int height = getHeight();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = width / 2;
        int i2 = height / 2;
        float f = x - i;
        float f2 = y - i2;
        int min = ((Math.min(width, height) / 2) - this.i) - (this.l / 2);
        boolean z = Math.abs(f * f) + Math.abs(f2 * f2) > ((float) (min * min));
        float f3 = this.f4470a[0];
        float f4 = this.f4470a[1];
        float f5 = this.f4470a[2];
        float f6 = this.f4470a[3];
        float f7 = this.f4470a[4];
        float f8 = this.f4470a[5];
        float f9 = (((f6 - f8) * (x - f7)) + ((f7 - f5) * (y - f8))) / (((f6 - f8) * (f3 - f7)) + ((f7 - f5) * (f4 - f8)));
        float f10 = (((f8 - f4) * (x - f7)) + ((f3 - f7) * (y - f8))) / (((f6 - f8) * (f3 - f7)) + ((f7 - f5) * (f4 - f8)));
        float f11 = (1.0f - f10) - f9;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.p = z;
                break;
            case 1:
            default:
                return super.onTouchEvent(motionEvent);
            case 2:
                break;
        }
        if (this.p) {
            this.q = a(motionEvent, i, i2);
            b();
            invalidate();
        } else {
            float[] fArr = {this.q, 1.0f, 1.0f};
            int HSVToColor = Color.HSVToColor(fArr);
            if (f9 < 0.0f && f11 < 0.0f) {
                rgb = -1;
            } else if (f10 < 0.0f && f11 < 0.0f) {
                rgb = -16777216;
            } else if (f9 < 0.0f && f10 < 0.0f) {
                rgb = HSVToColor;
            } else if (f9 < 0.0f) {
                float a2 = a(x, y, f7, f8, f5, f6);
                rgb = Color.rgb((int) ((255.0f * a2) + ((1.0f - a2) * Color.red(HSVToColor))), (int) ((255.0f * a2) + ((1.0f - a2) * Color.green(HSVToColor))), (int) (((1.0f - a2) * Color.blue(HSVToColor)) + (255.0f * a2)));
            } else if (f11 < 0.0f) {
                float a3 = a(x, y, f3, f4, f5, f6);
                rgb = Color.rgb((int) (255.0f * a3), (int) (255.0f * a3), (int) (a3 * 255.0f));
            } else if (f10 < 0.0f) {
                float a4 = a(x, y, f3, f4, f7, f8);
                rgb = Color.rgb((int) (Color.red(HSVToColor) * a4), (int) (Color.green(HSVToColor) * a4), (int) (a4 * Color.blue(HSVToColor)));
            } else {
                rgb = Color.rgb((int) ((255.0f * f10) + (Color.red(HSVToColor) * f11)), (int) ((255.0f * f10) + (Color.green(HSVToColor) * f11)), (int) ((255.0f * f10) + (Color.blue(HSVToColor) * f11)));
            }
            Color.colorToHSV(rgb, fArr);
            this.r = fArr[1];
            this.s = fArr[2];
            b();
            invalidate();
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable background = getBackground();
        if (background != null) {
            this.e.set(0, 0, getWidth(), getHeight());
            background.setBounds(this.e);
            background.setState(isPressed() ? this.g : this.f);
            background.draw(canvas);
        }
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int min = Math.min(getWidth(), getHeight()) / 2;
        int i = min - this.i;
        int i2 = i - this.l;
        if (this.h == null) {
            this.h = new Path();
        }
        this.j.setDither(true);
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.FILL);
        this.h.rewind();
        this.h.addCircle(width, height, min, Path.Direction.CCW);
        this.h.addCircle(width, height, min - this.i, Path.Direction.CW);
        a(canvas, this.h);
        this.h.rewind();
        this.h.moveTo(width - (i * 0.8666f), height + (i * 0.4999f));
        this.h.lineTo(width, height - i);
        this.h.lineTo(width + (i * 0.8666f), (i * 0.4999f) + height);
        this.h.close();
        a(canvas, this.h);
        this.f4470a[0] = width - (i2 * 0.8666f);
        this.f4470a[1] = height + (i2 * 0.4999f);
        this.f4470a[2] = width;
        this.f4470a[3] = height - i2;
        this.f4470a[4] = width + (i2 * 0.8666f);
        this.f4470a[5] = height + (i2 * 0.4999f);
        this.b[2] = Color.HSVToColor(new float[]{this.q, 1.0f, 1.0f});
        canvas.drawVertices(Canvas.VertexMode.TRIANGLES, this.f4470a.length, this.f4470a, 0, null, 0, this.b, 0, null, 0, 0, this.j);
        this.h.rewind();
        this.h.moveTo(width - (i2 * 0.8666f), height + (i2 * 0.4999f));
        this.h.lineTo(width, height - i2);
        this.h.lineTo(width + (i2 * 0.8666f), height + (i2 * 0.4999f));
        this.h.close();
        this.j.setStyle(Paint.Style.STROKE);
        this.j.setColor(-15263977);
        this.j.setStrokeWidth(1.5f);
        canvas.drawPath(this.h, this.j);
        this.j.setStyle(Paint.Style.FILL);
        this.h.rewind();
        this.h.addCircle(width, height, min - this.l, Path.Direction.CCW);
        this.h.addCircle(width, height, (min - this.i) + this.l, Path.Direction.CW);
        if (this.k == null || this.m != width || this.n != height) {
            this.k = new SweepGradient(width, height, this.c, this.d);
            this.m = width;
            this.n = height;
        }
        this.j.setShader(this.k);
        canvas.drawPath(this.h, this.j);
        this.j.setShader(null);
        float cos = width + ((min - (this.i / 2)) * ((float) Math.cos((this.q * 3.141592653589793d) / 180.0d)));
        float sin = height + ((min - (this.i / 2)) * ((float) Math.sin((this.q * 3.141592653589793d) / 180.0d)));
        this.j.setStyle(Paint.Style.FILL);
        this.j.setColor(-1);
        canvas.drawCircle(cos, sin, this.i / 2, this.j);
        this.j.setColor(-6710887);
        canvas.drawCircle(cos, sin, (this.i / 2) - a(3), this.j);
        this.j.setColor(this.b[2]);
        canvas.drawCircle(cos, sin, (this.i / 2) - a(5), this.j);
        float f = this.f4470a[0];
        float f2 = this.f4470a[1];
        float f3 = this.f4470a[3];
        float f4 = this.f4470a[4];
        float f5 = this.s;
        float f6 = (1.0f - this.r) * f5;
        float f7 = f + ((f4 - f) * (f5 - (f6 / 2.0f)));
        float f8 = f2 - ((f2 - f3) * f6);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setColor(-1);
        canvas.drawCircle(f7, f8, this.i / 2, this.j);
        this.j.setColor(-6710887);
        canvas.drawCircle(f7, f8, (this.i / 2) - a(3), this.j);
        this.j.setColor(getColor());
        canvas.drawCircle(f7, f8, (this.i / 2) - a(5), this.j);
    }

    void a(Canvas canvas, Path path) {
        this.j.setColor(-16777216);
        canvas.drawPath(path, this.j);
    }
}
