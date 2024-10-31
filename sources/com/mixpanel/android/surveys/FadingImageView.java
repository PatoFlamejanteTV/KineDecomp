package com.mixpanel.android.surveys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.mixpanel.android.a;

/* loaded from: classes.dex */
public class FadingImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Matrix f3058a;
    private Paint b;
    private Shader c;
    private Paint d;
    private Shader e;
    private int f;
    private int g;

    public FadingImageView(Context context) {
        super(context);
        a();
    }

    public FadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f = getHeight();
        this.g = getWidth();
        int size = View.MeasureSpec.getSize(i2);
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (getResources().getConfiguration().orientation == 1) {
            View findViewById = getRootView().findViewById(a.c.com_mixpanel_android_notification_bottom_wrapper);
            int i3 = 0;
            if (findViewById != null && findViewById.getHeight() != 0) {
                i3 = findViewById.getHeight();
            }
            this.f3058a.setScale(1.0f, ((viewGroup.getPaddingBottom() + size) - i3) + TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics()));
        } else {
            this.f3058a.setScale(1.0f, size);
        }
        this.c.setLocalMatrix(this.f3058a);
        this.e.setLocalMatrix(this.f3058a);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect clipBounds = canvas.getClipBounds();
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, clipBounds.width(), clipBounds.height(), null, 31);
        super.draw(canvas);
        if (getResources().getConfiguration().orientation == 1) {
            canvas.drawRect(0.0f, 0.0f, this.g, this.f, this.b);
        }
        canvas.restoreToCount(saveLayer);
    }

    private void a() {
        this.f3058a = new Matrix();
        this.b = new Paint();
        this.c = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{-16777216, -16777216, -452984832, 0}, new float[]{0.0f, 0.7f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
        this.b.setShader(this.c);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.d = new Paint();
        this.e = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{0, 0, -16777216, -16777216}, new float[]{0.0f, 0.85f, 0.98f, 1.0f}, Shader.TileMode.CLAMP);
        this.d.setShader(this.e);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
}
