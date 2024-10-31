package com.nexstreaming.kinemaster.ui.projectedit;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class AngleMaskImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Path f3731a;
    private float b;
    private float c;
    private boolean d;
    private float e;
    private Bitmap f;
    private Paint g;

    public AngleMaskImageView(Context context) {
        super(context);
        this.f3731a = new Path();
        this.d = true;
        this.e = 1.5f;
        this.g = new Paint();
        a();
    }

    public AngleMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3731a = new Path();
        this.d = true;
        this.e = 1.5f;
        this.g = new Paint();
        a();
    }

    public AngleMaskImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3731a = new Path();
        this.d = true;
        this.e = 1.5f;
        this.g = new Paint();
        a();
    }

    @TargetApi(21)
    public AngleMaskImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3731a = new Path();
        this.d = true;
        this.e = 1.5f;
        this.g = new Paint();
        a();
    }

    private void a() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float height = getHeight() / 2;
        canvas.save();
        this.f3731a.rewind();
        this.f3731a.moveTo(this.c, height);
        this.f3731a.lineTo(0.0f, (-((float) (this.c * Math.tan(Math.toRadians(getMaskAngle()) / 2.0d)))) + height);
        this.f3731a.lineTo(0.0f, height + ((float) (this.c * Math.tan(Math.toRadians(getMaskAngle()) / 2.0d))));
        canvas.clipPath(this.f3731a);
        if (this.f != null) {
            canvas.drawBitmap(Bitmap.createScaledBitmap(this.f, this.f.getWidth(), this.f.getHeight(), true), 0.0f, 0.0f, this.g);
        }
        super.onDraw(canvas);
        canvas.restore();
    }

    public void setCenterDistance(float f) {
        this.c = f;
    }

    public float getCenterDistance() {
        return this.c;
    }

    public void setMaskAngle(float f) {
        this.b = f;
    }

    public float getMaskAngle() {
        return this.b;
    }

    public void setBitmapResource(int i) {
        this.f = BitmapFactory.decodeResource(getResources(), i);
        invalidate();
    }
}
