package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class TransparentImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f4381a;
    private RectF b;
    private Paint c;

    public TransparentImageView(Context context) {
        super(context);
        this.b = new RectF();
        a();
    }

    public TransparentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new RectF();
        a();
    }

    public TransparentImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new RectF();
        a();
    }

    @TargetApi(21)
    public TransparentImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = new RectF();
        a();
    }

    private void a() {
        this.f4381a = getResources().getDrawable(R.drawable.trans_tv_bg);
        setLayerType(1, null);
        this.c = new Paint();
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f4381a.setBounds(0, 0, getWidth(), getHeight());
        this.f4381a.setState(getDrawableState());
        this.f4381a.draw(canvas);
        if (isPressed()) {
            int saveLayer = canvas.saveLayer(this.b, this.c, 31);
            super.onDraw(canvas);
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.onDraw(canvas);
    }
}
