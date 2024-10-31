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

/* loaded from: classes2.dex */
public class AngleMaskImageView extends ImageView {

    /* renamed from: a */
    private Path f21744a;

    /* renamed from: b */
    private float f21745b;

    /* renamed from: c */
    private float f21746c;

    /* renamed from: d */
    private boolean f21747d;

    /* renamed from: e */
    private float f21748e;

    /* renamed from: f */
    private Bitmap f21749f;

    /* renamed from: g */
    private Bitmap f21750g;

    /* renamed from: h */
    private Paint f21751h;

    public AngleMaskImageView(Context context) {
        super(context);
        this.f21744a = new Path();
        this.f21747d = true;
        this.f21748e = 1.5f;
        this.f21751h = new Paint();
        a();
    }

    private void a() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    public float getCenterDistance() {
        return this.f21746c;
    }

    public float getMaskAngle() {
        return this.f21745b;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float height = getHeight() / 2;
        canvas.save();
        this.f21744a.rewind();
        this.f21744a.moveTo(this.f21746c, height);
        Path path = this.f21744a;
        double d2 = this.f21746c;
        double tan = Math.tan(Math.toRadians(getMaskAngle()) / 2.0d);
        Double.isNaN(d2);
        path.lineTo(0.0f, (-((float) (d2 * tan))) + height);
        Path path2 = this.f21744a;
        double d3 = this.f21746c;
        double tan2 = Math.tan(Math.toRadians(getMaskAngle()) / 2.0d);
        Double.isNaN(d3);
        path2.lineTo(0.0f, ((float) (d3 * tan2)) + height);
        canvas.clipPath(this.f21744a);
        Bitmap bitmap = this.f21750g;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f21751h);
        }
        super.onDraw(canvas);
        canvas.restore();
    }

    public void setBitmapResource(int i) {
        this.f21749f = BitmapFactory.decodeResource(getResources(), i);
        Bitmap bitmap = this.f21749f;
        this.f21750g = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), this.f21749f.getHeight(), true);
        invalidate();
    }

    public void setCenterDistance(float f2) {
        this.f21746c = f2;
    }

    public void setMaskAngle(float f2) {
        this.f21745b = f2;
    }

    public AngleMaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21744a = new Path();
        this.f21747d = true;
        this.f21748e = 1.5f;
        this.f21751h = new Paint();
        a();
    }

    public AngleMaskImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21744a = new Path();
        this.f21747d = true;
        this.f21748e = 1.5f;
        this.f21751h = new Paint();
        a();
    }

    @TargetApi(21)
    public AngleMaskImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f21744a = new Path();
        this.f21747d = true;
        this.f21748e = 1.5f;
        this.f21751h = new Paint();
        a();
    }
}
