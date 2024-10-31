package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes2.dex */
public class ChromaKeyGraphView extends View {

    /* renamed from: a */
    private float[] f23728a;

    /* renamed from: b */
    private float[] f23729b;

    /* renamed from: c */
    private Paint f23730c;

    /* renamed from: d */
    private int f23731d;

    /* renamed from: e */
    private float f23732e;

    /* renamed from: f */
    private float f23733f;

    /* renamed from: g */
    private float f23734g;

    /* renamed from: h */
    private float f23735h;
    private float i;
    private float j;
    private a k;
    private Context l;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, float f2, float f3);
    }

    public ChromaKeyGraphView(Context context) {
        super(context);
        this.f23728a = new float[]{0.25f, 0.75f};
        this.f23729b = new float[]{0.25f, 0.75f};
        this.f23730c = new Paint(1);
        this.f23731d = -1;
        this.l = context;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(ChromaKeyGraphView.class.getName());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        float f2 = paddingLeft;
        float f3 = paddingTop + height;
        float f4 = ((height / 2) + width) / 40.0f;
        super.onDraw(canvas);
        this.f23730c.setColor(-15132639);
        this.f23730c.setStyle(Paint.Style.FILL);
        int dimensionPixelOffset = this.l.getResources().getDimensionPixelOffset(R.dimen.chroma_key_detail_radius);
        int dimensionPixelOffset2 = this.l.getResources().getDimensionPixelOffset(R.dimen.chroma_key_detail_border);
        float f5 = dimensionPixelOffset;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), f5, f5, this.f23730c);
        this.f23730c.setColor(-9079686);
        this.f23730c.setStyle(Paint.Style.STROKE);
        float f6 = dimensionPixelOffset2;
        this.f23730c.setStrokeWidth(f6);
        float f7 = paddingTop;
        float f8 = paddingLeft + width;
        RectF rectF = new RectF(f2, f7, f8, f3);
        canvas.drawRoundRect(rectF, f5, f5, this.f23730c);
        int i = 1;
        while (i <= 3) {
            float f9 = i;
            float width2 = rectF.left + (((rectF.width() / 4.0f) * f9) - f6);
            canvas.drawLine(width2, rectF.top, width2 + f6, rectF.bottom, this.f23730c);
            float height2 = (((rectF.height() / 4.0f) * f9) - f6) + rectF.top;
            canvas.drawLine(rectF.left, height2, rectF.right, height2 + f6, this.f23730c);
            i++;
            f8 = f8;
        }
        float f10 = f8;
        this.f23730c.setColor(-1381654);
        int i2 = 0;
        float f11 = f2;
        float f12 = f3;
        int i3 = 0;
        while (true) {
            float[] fArr = this.f23728a;
            if (i3 >= fArr.length) {
                break;
            }
            float f13 = f2 + (fArr[i3] * width);
            float f14 = f3 - (this.f23729b[i3] * height);
            canvas.drawLine(f11, f12, f13, f14, this.f23730c);
            i3++;
            f11 = f13;
            f12 = f14;
        }
        canvas.drawLine(f11, f12, f10, f7, this.f23730c);
        this.f23730c.setStyle(Paint.Style.FILL);
        float f15 = f4 / 2.0f;
        canvas.drawCircle(f2, f3, f15, this.f23730c);
        canvas.drawCircle(f10, f7, f15, this.f23730c);
        Drawable drawable = this.l.getResources().getDrawable(R.drawable.vol_env_keyframe_icon);
        float intrinsicWidth = drawable.getIntrinsicWidth() / 2.0f;
        float intrinsicHeight = drawable.getIntrinsicHeight() / 2.0f;
        while (true) {
            float[] fArr2 = this.f23728a;
            if (i2 >= fArr2.length) {
                return;
            }
            float width3 = ((fArr2[i2] / 1.0f) * rectF.width()) + rectF.left;
            float f16 = this.f23728a[i2];
            float f17 = this.f23729b[i2];
            float height3 = (rectF.height() - ((this.f23729b[i2] / 1.0f) * rectF.height())) + rectF.top;
            drawable.setBounds((int) (width3 - intrinsicWidth), (int) (height3 - intrinsicHeight), (int) (width3 + intrinsicWidth), (int) (height3 + intrinsicHeight));
            drawable.draw(canvas);
            i2++;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float[] fArr;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        int actionMasked = motionEvent.getActionMasked();
        int i = -1;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f23731d >= 0) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        float f2 = (x - this.i) / width;
                        float f3 = (this.j - y) / height;
                        float[] fArr2 = this.f23728a;
                        int i2 = this.f23731d;
                        fArr2[i2] = Math.max(this.f23732e, Math.min(this.f23733f, fArr2[i2] + f2));
                        float[] fArr3 = this.f23729b;
                        int i3 = this.f23731d;
                        fArr3[i3] = Math.max(this.f23734g, Math.min(this.f23735h, fArr3[i3] + f3));
                        invalidate();
                        this.i = x;
                        this.j = y;
                        a aVar = this.k;
                        if (aVar != null) {
                            int i4 = this.f23731d;
                            aVar.a(i4, this.f23728a[i4], this.f23729b[i4]);
                        }
                    }
                    return true;
                }
                if (actionMasked != 3) {
                    return super.onTouchEvent(motionEvent);
                }
            }
            this.f23731d = -1;
            invalidate();
            return true;
        }
        float f4 = Float.MAX_VALUE;
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        int i5 = 0;
        while (true) {
            fArr = this.f23728a;
            if (i5 >= fArr.length) {
                break;
            }
            float abs = Math.abs((paddingLeft + (fArr[i5] * width)) - x2) * Math.abs(((paddingTop + height) - (this.f23729b[i5] * height)) - y2);
            if (abs < f4) {
                i = i5;
                f4 = abs;
            }
            i5++;
        }
        this.i = x2;
        this.j = y2;
        this.f23731d = i;
        this.f23732e = i < 1 ? 0.0f : fArr[i - 1];
        int i6 = i + 1;
        float[] fArr4 = this.f23728a;
        this.f23733f = i6 >= fArr4.length ? 1.0f : fArr4[i6];
        if (i <= 0) {
            this.f23734g = 0.0f;
            this.f23735h = this.f23729b[i6];
        } else {
            float[] fArr5 = this.f23729b;
            if (i >= fArr5.length - 1) {
                this.f23734g = fArr5[i - 1];
                this.f23735h = 1.0f;
            } else {
                this.f23734g = fArr5[i - 1];
                this.f23735h = fArr5[i6];
            }
        }
        this.f23734g += 1.0E-5f;
        this.f23735h -= 1.0E-5f;
        this.f23732e += 1.0E-5f;
        this.f23733f -= 1.0E-5f;
        invalidate();
        return true;
    }

    public void setChromaKeyDivisions(float[] fArr) {
        float[] fArr2 = this.f23728a;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        invalidate();
    }

    public void setChromaKeyStrengths(float[] fArr) {
        float[] fArr2 = this.f23729b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        invalidate();
    }

    public void setOnChromaKeyGraphValueChangeListener(a aVar) {
        this.k = aVar;
    }

    public ChromaKeyGraphView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23728a = new float[]{0.25f, 0.75f};
        this.f23729b = new float[]{0.25f, 0.75f};
        this.f23730c = new Paint(1);
        this.f23731d = -1;
        this.l = context;
    }

    public ChromaKeyGraphView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23728a = new float[]{0.25f, 0.75f};
        this.f23729b = new float[]{0.25f, 0.75f};
        this.f23730c = new Paint(1);
        this.f23731d = -1;
        this.l = context;
    }

    @TargetApi(21)
    public ChromaKeyGraphView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23728a = new float[]{0.25f, 0.75f};
        this.f23729b = new float[]{0.25f, 0.75f};
        this.f23730c = new Paint(1);
        this.f23731d = -1;
        this.l = context;
    }
}
