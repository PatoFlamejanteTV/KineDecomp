package com.nextreaming.nexeditorui;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ColorPickerView extends View {
    private static int l = 0;
    private float A;
    private float B;
    private float C;
    private SliderId D;
    private Rect E;
    private final int[] F;
    private final int[] G;
    private Handler H;
    private Paint I;
    private b[] J;

    /* renamed from: a, reason: collision with root package name */
    private WindowManager f4467a;
    private boolean b;
    private boolean c;
    private boolean d;
    private ColorPickerView e;
    private WindowManager.LayoutParams f;
    private b g;
    private c h;
    private a i;
    private long j;
    private long k;
    private boolean m;
    private boolean n;
    private float o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private final float w;
    private float x;
    private float y;
    private float z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum SliderId {
        Hue,
        Sat,
        Val
    }

    /* loaded from: classes.dex */
    private interface a {
        void a();
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(ColorPickerView colorPickerView);

        void a(ColorPickerView colorPickerView, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final float[] o = new float[3];

        /* renamed from: a, reason: collision with root package name */
        final int f4469a;
        final int b;
        final int c;
        final float d;
        final float e;
        final float f;
        final float g;
        final float h;
        final float i;
        final float j;
        int k;
        int l;
        int m;
        int n;

        b(float f, float f2, float f3) {
            o[0] = f;
            o[1] = f2;
            o[2] = f3;
            this.f4469a = Color.HSVToColor(o);
            this.e = Color.red(this.f4469a) / 255.0f;
            this.f = Color.green(this.f4469a) / 255.0f;
            this.g = Color.blue(this.f4469a) / 255.0f;
            this.d = (float) Math.sqrt((this.e * this.e * 0.241d) + (this.f * this.f * 0.691d) + (this.g * this.g * 0.068d));
            this.h = o[0];
            this.i = o[1];
            this.j = o[2];
            o[2] = (float) (r0[2] - 0.1d);
            if (o[2] < 0.0f) {
                o[2] = 0.0f;
            }
            this.b = Color.HSVToColor(o);
            o[2] = this.j + 0.1f;
            if (o[2] > 1.0d) {
                float[] fArr = o;
                fArr[1] = fArr[1] - (o[2] - 1.0f);
                o[2] = 1.0f;
                if (o[1] < 0.0f) {
                    o[1] = 0.0f;
                }
            }
            this.c = Color.HSVToColor(o);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i) {
            this.f4469a = i;
            this.e = Color.red(i) / 255.0f;
            this.f = Color.green(i) / 255.0f;
            this.g = Color.blue(i) / 255.0f;
            this.d = (float) Math.sqrt((this.e * this.e * 0.241d) + (this.f * this.f * 0.691d) + (this.g * this.g * 0.068d));
            Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), o);
            this.h = o[0];
            this.i = o[1];
            this.j = o[2];
            o[2] = (float) (r0[2] - 0.1d);
            if (o[2] < 0.0f) {
                o[2] = 0.0f;
            }
            this.b = Color.HSVToColor(o);
            o[2] = this.j + 0.1f;
            if (o[2] > 1.0d) {
                float[] fArr = o;
                fArr[1] = fArr[1] - (o[2] - 1.0f);
                o[2] = 1.0f;
                if (o[1] < 0.0f) {
                    o[1] = 0.0f;
                }
            }
            this.c = Color.HSVToColor(o);
        }

        static b[] a(int[] iArr) {
            b[] bVarArr = new b[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                bVarArr[i] = new b(iArr[i]);
            }
            return bVarArr;
        }
    }

    public ColorPickerView(Context context) {
        super(context);
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = null;
        this.f = null;
        this.g = new b(-8421505);
        this.h = null;
        this.i = null;
        this.j = 0L;
        this.k = 0L;
        this.m = false;
        this.n = false;
        this.t = 8;
        this.u = 85;
        this.v = false;
        this.w = 20.0f;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = 0.0f;
        this.B = 0.0f;
        this.C = 0.0f;
        this.D = null;
        this.E = new Rect();
        this.F = new int[0];
        this.G = new int[]{R.attr.state_pressed};
        this.H = new u(this);
        this.I = new Paint();
        this.J = b.a(new int[0]);
        a();
    }

    private void a() {
        this.f4467a = (WindowManager) getContext().getSystemService("window");
    }

    public void setAllowFineAdjustment(boolean z) {
        this.v = z;
        invalidate();
    }

    public void setExpandedMode(boolean z) {
        this.b = z;
        invalidate();
        requestLayout();
    }

    public boolean getExpandedMode() {
        return this.b;
    }

    public void setColorOptions(int[] iArr) {
        this.J = b.a(iArr);
        invalidate();
    }

    private void setColorOptions(b[] bVarArr) {
        this.J = bVarArr;
        if (this.e != null) {
            this.e.setColorOptions(bVarArr);
        }
        invalidate();
    }

    public void setSelectedColor(int i) {
        this.g = new b(i);
        invalidate();
    }

    public void setInnerRingSections(int i) {
        this.t = i;
        if (this.e != null) {
            this.e.setInnerRingSections(i);
        }
        invalidate();
    }

    public void setListener(c cVar) {
        this.h = cVar;
    }

    public void setPopupRingWidth(int i) {
        this.u = i;
        invalidate();
    }

    public int getSelectedColor() {
        return this.g.f4469a;
    }

    private int getNumLevels() {
        int i = this.v ? 2 : 0;
        if (this.J.length <= this.t) {
            return i + 1;
        }
        if (this.J.length > this.t && this.J.length <= this.t * 3) {
            return i + 2;
        }
        return i + 3;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (!this.d || keyCode != 4 || keyEvent.getAction() != 0 || keyEvent.getRepeatCount() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.h != null) {
            this.h.a(this);
        }
        return true;
    }

    public void a(boolean z) {
        if (!this.b && !this.c) {
            ColorPickerPopup colorPickerPopup = new ColorPickerPopup(getContext(), false);
            colorPickerPopup.a(new v(this));
            colorPickerPopup.a(new w(this));
            colorPickerPopup.b(this.g.f4469a);
        }
    }

    @Override // android.view.View
    @TargetApi(16)
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int i;
        int i2;
        float f8;
        float min = Math.min(((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2, ((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2);
        float paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2);
        float paddingTop = getPaddingTop() + (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int width = (getWidth() / 2) + iArr[0];
        int height = iArr[1] + (getHeight() / 2);
        this.I.setAntiAlias(true);
        if (!this.b) {
            this.I.setColor(this.g.f4469a);
            this.I.setStyle(Paint.Style.FILL);
            canvas.drawCircle(paddingLeft, paddingTop, min - 3.0f, this.I);
            this.I.setStyle(Paint.Style.STROKE);
            this.I.setColor(-1);
            if (isSelected()) {
                this.I.setStrokeWidth(6.0f);
                canvas.drawCircle(paddingLeft, paddingTop, min - 3.0f, this.I);
                this.I.setColor(0);
                canvas.drawCircle(paddingLeft, paddingTop, min - 1.0f, this.I);
            } else {
                this.I.setStrokeWidth(3.0f);
                canvas.drawCircle(paddingLeft, paddingTop, min - 5.0f, this.I);
                this.I.setColor(-16777216);
                canvas.drawCircle(paddingLeft, paddingTop, min - 4.0f, this.I);
            }
            Drawable background = getBackground();
            if (background != null) {
                this.E.set(0, 0, getWidth(), getHeight());
                background.setBounds(this.E);
                background.setState(isPressed() ? this.G : this.F);
                background.draw(canvas);
                return;
            }
            return;
        }
        int i3 = 0;
        int i4 = 0;
        if (this.d) {
            i4 = height - this.q;
            i3 = width - this.p;
        }
        this.r = (int) paddingLeft;
        this.s = (int) paddingTop;
        int numLevels = getNumLevels();
        Arrays.sort(this.J, new x(this));
        float f9 = min / (numLevels + 1);
        if (this.d) {
            f = this.o * 1.3f;
        } else {
            f = 0.95f * f9;
        }
        this.k = System.currentTimeMillis() - this.j;
        if (!this.n) {
            f2 = 1.0f;
            f3 = f;
            f4 = f9;
            f5 = paddingLeft;
            f6 = paddingTop;
        } else {
            if (this.m) {
                f8 = ((float) this.k) / l;
            } else {
                f8 = 1.0f - (((float) this.k) / l);
            }
            if (f8 > 1.0f) {
                f8 = 1.0f;
            } else if (f8 < 0.0f) {
                f8 = 0.0f;
            }
            f5 = paddingLeft - (i3 * (1.0f - f8));
            f2 = f8;
            f3 = f * f8;
            f4 = f9 * f8;
            f6 = paddingTop - (i4 * (1.0f - f8));
        }
        this.I.setStyle(Paint.Style.FILL);
        Path path = new Path();
        int[] iArr2 = new int[4];
        float[] fArr = new float[4];
        this.I.setColor(-16777216);
        canvas.drawCircle(f5, f6, f3, this.I);
        float[] fArr2 = {0.0f, 0.0f, 0.0f};
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= numLevels - (this.v ? 2 : 0)) {
                break;
            }
            float f10 = ((i6 * f4) - 1.0f) + f3;
            float f11 = 1.0f + f10 + f4;
            if (i6 == 0) {
                i = this.t;
                i2 = 0;
            } else if (i6 == 1) {
                int i7 = this.t;
                i = this.t * 2;
                i2 = i7;
            } else {
                int i8 = this.t * 3;
                i = this.t * 4;
                i2 = i8;
            }
            int min2 = Math.min(i, this.J.length - i2);
            float f12 = 360.0f / min2;
            Arrays.sort(this.J, i2, i2 + min2, new y(this));
            if (f11 > 0.0f) {
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < min2) {
                        float f13 = i10 * f12;
                        float f14 = 0.5f + f12 + f13;
                        path.rewind();
                        path.arcTo(new RectF(f5 - f10, f6 - f10, f5 + f10, f6 + f10), f13, 0.5f + f12);
                        path.arcTo(new RectF(f5 - f11, f6 - f11, f5 + f11, f6 + f11), f14, -(0.5f + f12));
                        path.close();
                        this.J[i2 + i10].k = (int) f13;
                        this.J[i2 + i10].l = (int) f14;
                        this.J[i2 + i10].m = ((int) f10) - 1;
                        this.J[i2 + i10].n = (int) f11;
                        this.I.setColor(this.J[i2 + i10].f4469a);
                        iArr2[0] = this.J[i2 + i10].b;
                        iArr2[1] = this.J[i2 + i10].f4469a;
                        iArr2[2] = this.J[i2 + i10].c;
                        iArr2[3] = this.J[i2 + i10].b;
                        fArr[0] = f10 / f11;
                        fArr[1] = (((f11 - f10) / 4.0f) + f10) / f11;
                        fArr[2] = ((((f11 - f10) * 3.0f) / 4.0f) + f10) / f11;
                        fArr[3] = 1.0f;
                        this.I.setDither(true);
                        this.I.setShader(new RadialGradient(f5, f6, f11, iArr2, fArr, Shader.TileMode.CLAMP));
                        canvas.drawPath(path, this.I);
                        this.I.setShader(null);
                        i9 = i10 + 1;
                    }
                }
            }
            i5 = i6 + 1;
        }
        if (this.v) {
            int[] iArr3 = {-65536, -256, -16711936, -16711681, -16776961, -65281, -65536};
            float[] fArr3 = new float[iArr3.length];
            for (int i11 = 0; i11 < fArr3.length; i11++) {
                fArr3[i11] = 0.027777778f + ((i11 / (fArr3.length - 1)) * 0.44444445f);
            }
            float f15 = (((numLevels - 2) * f4) - 1.0f) + f3;
            float f16 = 1.0f + f15 + f4;
            float f17 = (f16 + f4) - 2.0f;
            this.x = f15;
            this.y = (f4 / 3.0f) + f17;
            if (f15 > 0.0f && f16 > 0.0f) {
                iArr2[0] = 2130706432;
                iArr2[1] = 0;
                iArr2[2] = Integer.MAX_VALUE;
                iArr2[3] = 2130706432;
                fArr[0] = f15 / f16;
                fArr[1] = (((f16 - f15) / 4.0f) + f15) / f16;
                fArr[2] = ((((f16 - f15) * 3.0f) / 4.0f) + f15) / f16;
                fArr[3] = 1.0f;
                path.rewind();
                path.arcTo(new RectF(f5 - f15, f6 - f15, f5 + f15, f6 + f15), 10.0f, 160.0f);
                path.arcTo(new RectF(f5 - f16, f6 - f16, f5 + f16, f6 + f16), 10.0f + 160.0f, -160.0f);
                path.close();
                this.I.setDither(true);
                this.I.setShader(new SweepGradient(f5, f6, iArr3, fArr3));
                canvas.drawPath(path, this.I);
                this.I.setShader(new RadialGradient(f5, f6, f16, iArr2, fArr, Shader.TileMode.CLAMP));
                canvas.drawPath(path, this.I);
                this.I.setShader(null);
                path.rewind();
                path.arcTo(new RectF(f5 - f15, f6 - f15, f5 + f15, f6 + f15), 190.0f, 70.0f);
                path.arcTo(new RectF(f5 - f16, f6 - f16, f5 + f16, f6 + f16), 190.0f + 70.0f, -70.0f);
                path.close();
                fArr2[0] = this.g.h;
                fArr2[1] = 1.0f;
                fArr2[2] = 0.75f;
                int HSVToColor = Color.HSVToColor(fArr2);
                fArr2[0] = this.g.h;
                fArr2[1] = 0.0f;
                fArr2[2] = 0.75f;
                int[] iArr4 = {HSVToColor, Color.HSVToColor(fArr2)};
                this.I.setDither(true);
                this.I.setShader(new SweepGradient(f5, f6, iArr4, new float[]{0.5277778f, 0.7222222f}));
                canvas.drawPath(path, this.I);
                this.I.setShader(new RadialGradient(f5, f6, f16, iArr2, fArr, Shader.TileMode.CLAMP));
                canvas.drawPath(path, this.I);
                this.I.setShader(null);
                path.rewind();
                path.arcTo(new RectF(f5 - f15, f6 - f15, f5 + f15, f15 + f6), 280.0f, 70.0f);
                path.arcTo(new RectF(f5 - f16, f6 - f16, f5 + f16, f6 + f16), 280.0f + 70.0f, -70.0f);
                path.close();
                fArr2[0] = this.g.h;
                fArr2[1] = this.g.i;
                fArr2[2] = 0.0f;
                int HSVToColor2 = Color.HSVToColor(fArr2);
                fArr2[0] = this.g.h;
                fArr2[1] = this.g.i;
                fArr2[2] = 1.0f;
                int[] iArr5 = {HSVToColor2, Color.HSVToColor(fArr2)};
                this.I.setDither(true);
                this.I.setShader(new SweepGradient(f5, f6, iArr5, new float[]{0.7777778f, 0.9722222f}));
                canvas.drawPath(path, this.I);
                this.I.setShader(new RadialGradient(f5, f6, f16, iArr2, fArr, Shader.TileMode.CLAMP));
                canvas.drawPath(path, this.I);
                this.I.setShader(null);
                path.rewind();
                path.moveTo(f16, 0.0f);
                path.quadTo(f17 - 3.0f, a(30), f17 - 3.0f, 0.0f);
                path.quadTo(f17 - 3.0f, -a(30), f16, 0.0f);
                path.close();
                canvas.save();
                canvas.translate(f5, f6);
                this.z = 10.0f + ((this.g.h / 360.0f) * 160.0f);
                canvas.rotate(this.z);
                this.I.setStyle(Paint.Style.STROKE);
                this.I.setColor(2130706432);
                this.I.setStrokeWidth(6.0f);
                canvas.drawPath(path, this.I);
                this.I.setStrokeWidth(4.0f);
                canvas.drawPath(path, this.I);
                fArr2[0] = this.g.h;
                fArr2[1] = 1.0f;
                fArr2[2] = 1.0f;
                this.I.setStyle(Paint.Style.FILL);
                this.I.setColor(Color.HSVToColor(fArr2));
                canvas.drawPath(path, this.I);
                this.I.setStyle(Paint.Style.STROKE);
                this.I.setColor(-1);
                this.I.setStrokeWidth(2.0f);
                canvas.drawPath(path, this.I);
                canvas.restore();
                canvas.save();
                canvas.translate(f5, f6);
                this.A = 190.0f + ((1.0f - this.g.i) * 70.0f);
                canvas.rotate(this.A);
                this.I.setStyle(Paint.Style.STROKE);
                this.I.setColor(2130706432);
                this.I.setStrokeWidth(6.0f);
                canvas.drawPath(path, this.I);
                this.I.setStrokeWidth(4.0f);
                canvas.drawPath(path, this.I);
                fArr2[0] = this.g.h;
                fArr2[1] = this.g.i;
                fArr2[2] = 0.75f;
                this.I.setStyle(Paint.Style.FILL);
                this.I.setColor(Color.HSVToColor(fArr2));
                canvas.drawPath(path, this.I);
                this.I.setStyle(Paint.Style.STROKE);
                this.I.setColor(-1);
                this.I.setStrokeWidth(2.0f);
                canvas.drawPath(path, this.I);
                canvas.restore();
                canvas.save();
                canvas.translate(f5, f6);
                this.B = 280.0f + (this.g.j * 70.0f);
                canvas.rotate(this.B);
                this.I.setStyle(Paint.Style.STROKE);
                this.I.setColor(2130706432);
                this.I.setStrokeWidth(6.0f);
                canvas.drawPath(path, this.I);
                this.I.setStrokeWidth(4.0f);
                canvas.drawPath(path, this.I);
                fArr2[0] = this.g.h;
                fArr2[1] = this.g.i;
                fArr2[2] = this.g.j;
                this.I.setStyle(Paint.Style.FILL);
                this.I.setColor(Color.HSVToColor(fArr2));
                canvas.drawPath(path, this.I);
                this.I.setStyle(Paint.Style.STROKE);
                this.I.setColor(-1);
                this.I.setStrokeWidth(2.0f);
                canvas.drawPath(path, this.I);
                canvas.restore();
            }
        }
        if (this.d) {
            f7 = (int) ((((f4 / 2.0f) + f3) * f2) + (this.o * (1.0f - f2)));
        } else {
            f7 = 0.8f * f4;
        }
        this.I.setColor(this.g.f4469a);
        this.I.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f5, f6, f7 - 3.0f, this.I);
        this.I.setStyle(Paint.Style.STROKE);
        this.I.setStrokeWidth(3.0f);
        this.I.setColor(-1);
        canvas.drawCircle(f5, f6, f7 - 3.0f, this.I);
        this.I.setColor(-16777216);
        canvas.drawCircle(f5, f6, f7 - 1.0f, this.I);
        if (this.n) {
            if (this.k < l) {
                if (Build.VERSION.SDK_INT == 16) {
                    postInvalidateOnAnimation();
                    return;
                } else {
                    invalidate();
                    return;
                }
            }
            if (this.i != null) {
                this.i.a();
                this.i = null;
            }
            this.k = 0L;
            this.n = false;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int a2 = this.b ? a((this.u * getNumLevels()) + 55) : a(48);
        int a3 = this.b ? a((this.u * getNumLevels()) + 55) : a(48);
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

    private int a(MotionEvent motionEvent) {
        int atan2 = (int) ((Math.atan2(motionEvent.getY() - this.s, motionEvent.getX() - this.r) * 180.0d) / 3.141592653589793d);
        if (atan2 < 0) {
            return atan2 + 360;
        }
        return atan2;
    }

    private int b(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getY() - this.s);
        float abs2 = Math.abs(motionEvent.getX() - this.r);
        return (int) Math.sqrt((abs * abs) + (abs2 * abs2));
    }

    private boolean c(MotionEvent motionEvent) {
        int a2 = a(motionEvent);
        int b2 = b(motionEvent);
        if (this.v && b2 >= this.x && b2 <= this.y) {
            if (Math.abs(a2 - this.z) < 20.0f) {
                this.C = this.z - a2;
                this.D = SliderId.Hue;
                return true;
            }
            if (Math.abs(a2 - this.A) < 20.0f) {
                this.C = this.A - a2;
                this.D = SliderId.Sat;
                return true;
            }
            if (Math.abs(a2 - this.B) < 20.0f) {
                this.C = this.B - a2;
                this.D = SliderId.Val;
                return true;
            }
        }
        for (int i = 0; i < this.J.length; i++) {
            if (b2 >= this.J[i].m && b2 <= this.J[i].n && a2 >= this.J[i].k && a2 <= this.J[i].l) {
                if (this.J[i].f4469a != this.g.f4469a) {
                    this.g = this.J[i];
                    if (this.h != null) {
                        this.h.a(this, this.g.f4469a);
                    }
                    invalidate();
                }
                return true;
            }
        }
        return false;
    }

    private boolean d(MotionEvent motionEvent) {
        int a2 = a(motionEvent);
        int b2 = b(motionEvent);
        if (this.D == null) {
            for (int i = 0; i < this.J.length; i++) {
                if (b2 >= this.J[i].m && b2 <= this.J[i].n && a2 >= this.J[i].k && a2 <= this.J[i].l) {
                    if (this.J[i].f4469a != this.g.f4469a) {
                        this.g = this.J[i];
                        if (this.h != null) {
                            this.h.a(this, this.g.f4469a);
                        }
                        invalidate();
                    }
                    return true;
                }
            }
            return false;
        }
        float[] fArr = {this.g.h, this.g.i, this.g.j};
        switch (this.D) {
            case Hue:
                float f = (360.0f * ((a2 + this.C) - 10.0f)) / 160.0f;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                if (f > 360.0f) {
                    f = 360.0f;
                }
                if (f == fArr[0]) {
                    return true;
                }
                fArr[0] = f;
                if (fArr[1] < 0.01d) {
                    fArr[1] = 1.0f;
                }
                if (fArr[2] < 0.01d) {
                    fArr[2] = 1.0f;
                    break;
                }
                break;
            case Sat:
                float f2 = 1.0f - (((a2 + this.C) - 190.0f) / 70.0f);
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                if (f2 > 1.0f) {
                    f2 = 1.0f;
                }
                if (f2 == fArr[1]) {
                    return true;
                }
                fArr[1] = f2;
                break;
            case Val:
                float f3 = (((a2 < 180 ? a2 + 360 : a2) + this.C) - 280.0f) / 70.0f;
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
                float f4 = f3 <= 1.0f ? f3 : 1.0f;
                if (f4 == fArr[2]) {
                    return true;
                }
                fArr[2] = f4;
                break;
        }
        this.g = new b(fArr[0], fArr[1], fArr[2]);
        if (this.h != null) {
            this.h.a(this, this.g.f4469a);
        }
        invalidate();
        return true;
    }

    private boolean a(MotionEvent motionEvent, boolean z) {
        if (this.D == null && this.d && this.h != null) {
            this.h.a(this);
            return true;
        }
        this.D = null;
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.b) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                return c(motionEvent);
            case 1:
                return a(motionEvent, false);
            case 2:
                return d(motionEvent);
            case 3:
                return a(motionEvent, true);
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    private int a(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }
}
