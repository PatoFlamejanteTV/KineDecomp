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

/* loaded from: classes.dex */
public class ChromaKeyGraphView extends View {

    /* renamed from: a, reason: collision with root package name */
    private float[] f4373a;
    private float[] b;
    private Paint c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private a k;
    private Context l;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, float f, float f2);
    }

    public ChromaKeyGraphView(Context context) {
        super(context);
        this.f4373a = new float[]{0.25f, 0.75f};
        this.b = new float[]{0.25f, 0.75f};
        this.c = new Paint(1);
        this.d = -1;
        this.l = context;
    }

    public ChromaKeyGraphView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4373a = new float[]{0.25f, 0.75f};
        this.b = new float[]{0.25f, 0.75f};
        this.c = new Paint(1);
        this.d = -1;
        this.l = context;
    }

    public ChromaKeyGraphView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4373a = new float[]{0.25f, 0.75f};
        this.b = new float[]{0.25f, 0.75f};
        this.c = new Paint(1);
        this.d = -1;
        this.l = context;
    }

    @TargetApi(21)
    public ChromaKeyGraphView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4373a = new float[]{0.25f, 0.75f};
        this.b = new float[]{0.25f, 0.75f};
        this.c = new Paint(1);
        this.d = -1;
        this.l = context;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        switch (motionEvent.getActionMasked()) {
            case 0:
                float f = Float.MAX_VALUE;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int i = -1;
                for (int i2 = 0; i2 < this.f4373a.length; i2++) {
                    float abs = Math.abs((paddingLeft + (this.f4373a[i2] * width)) - x) * Math.abs(((paddingTop + height) - (this.b[i2] * height)) - y);
                    if (abs < f) {
                        i = i2;
                        f = abs;
                    }
                }
                this.i = x;
                this.j = y;
                this.d = i;
                this.e = i < 1 ? 0.0f : this.f4373a[i - 1];
                this.f = i + 1 >= this.f4373a.length ? 1.0f : this.f4373a[i + 1];
                if (i <= 0) {
                    this.g = 0.0f;
                    this.h = this.b[i + 1];
                } else if (i >= this.b.length - 1) {
                    this.g = this.b[i - 1];
                    this.h = 1.0f;
                } else {
                    this.g = this.b[i - 1];
                    this.h = this.b[i + 1];
                }
                this.g += 1.0E-5f;
                this.h -= 1.0E-5f;
                this.e += 1.0E-5f;
                this.f -= 1.0E-5f;
                invalidate();
                return true;
            case 1:
            case 3:
                this.d = -1;
                invalidate();
                return true;
            case 2:
                if (this.d >= 0) {
                    float x2 = motionEvent.getX();
                    float y2 = motionEvent.getY();
                    float f2 = (x2 - this.i) / width;
                    float f3 = (this.j - y2) / height;
                    this.f4373a[this.d] = Math.max(this.e, Math.min(this.f, f2 + this.f4373a[this.d]));
                    this.b[this.d] = Math.max(this.g, Math.min(this.h, f3 + this.b[this.d]));
                    invalidate();
                    this.i = x2;
                    this.j = y2;
                    if (this.k != null) {
                        this.k.a(this.d, this.f4373a[this.d], this.b[this.d]);
                    }
                }
                return true;
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        float f = paddingLeft;
        float f2 = paddingTop + height;
        float f3 = ((height / 2) + width) / 40.0f;
        super.onDraw(canvas);
        this.c.setColor(-15132639);
        this.c.setStyle(Paint.Style.FILL);
        int dimensionPixelOffset = this.l.getResources().getDimensionPixelOffset(R.dimen.chroma_key_detail_radius);
        int dimensionPixelOffset2 = this.l.getResources().getDimensionPixelOffset(R.dimen.chroma_key_detail_border);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), dimensionPixelOffset, dimensionPixelOffset, this.c);
        this.c.setColor(-9079686);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(dimensionPixelOffset2);
        RectF rectF = new RectF(paddingLeft, paddingTop, paddingLeft + width, paddingTop + height);
        canvas.drawRoundRect(rectF, dimensionPixelOffset, dimensionPixelOffset, this.c);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 > 3) {
                break;
            }
            float width2 = rectF.left + (((rectF.width() / 4.0f) * i2) - dimensionPixelOffset2);
            canvas.drawLine(width2, rectF.top, width2 + dimensionPixelOffset2, rectF.bottom, this.c);
            float height2 = (((rectF.height() / 4.0f) * i2) - dimensionPixelOffset2) + rectF.top;
            canvas.drawLine(rectF.left, height2, rectF.right, height2 + dimensionPixelOffset2, this.c);
            i = i2 + 1;
        }
        this.c.setColor(-1381654);
        float f4 = f2;
        float f5 = f;
        int i3 = 0;
        while (i3 < this.f4373a.length) {
            float f6 = (this.f4373a[i3] * width) + paddingLeft;
            float f7 = (paddingTop + height) - (this.b[i3] * height);
            canvas.drawLine(f5, f4, f6, f7, this.c);
            i3++;
            f4 = f7;
            f5 = f6;
        }
        canvas.drawLine(f5, f4, width + paddingLeft, paddingTop, this.c);
        this.c.setStyle(Paint.Style.FILL);
        canvas.drawCircle(paddingLeft, paddingTop + height, f3 / 2.0f, this.c);
        canvas.drawCircle(paddingLeft + width, paddingTop, f3 / 2.0f, this.c);
        Drawable drawable = this.l.getResources().getDrawable(R.drawable.vol_env_keyframe_icon);
        float intrinsicWidth = drawable.getIntrinsicWidth() / 2.0f;
        float intrinsicHeight = drawable.getIntrinsicHeight() / 2.0f;
        for (int i4 = 0; i4 < this.f4373a.length; i4++) {
            float width3 = ((this.f4373a[i4] / 1.0f) * rectF.width()) + rectF.left;
            float f8 = width + (this.f4373a[i4] * width);
            float f9 = (height + height) - (this.b[i4] * height);
            float height3 = (rectF.height() - ((this.b[i4] / 1.0f) * rectF.height())) + rectF.top;
            drawable.setBounds((int) (width3 - intrinsicWidth), (int) (height3 - intrinsicHeight), (int) (width3 + intrinsicWidth), (int) (height3 + intrinsicHeight));
            drawable.draw(canvas);
        }
    }

    public void setChromaKeyDivisions(float[] fArr) {
        System.arraycopy(fArr, 0, this.f4373a, 0, this.f4373a.length);
        invalidate();
    }

    public void setChromaKeyStrengths(float[] fArr) {
        System.arraycopy(fArr, 0, this.b, 0, this.b.length);
        invalidate();
    }

    public void setOnChromaKeyGraphValueChangeListener(a aVar) {
        this.k = aVar;
    }
}
