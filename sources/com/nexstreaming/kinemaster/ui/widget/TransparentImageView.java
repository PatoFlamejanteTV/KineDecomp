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

/* loaded from: classes2.dex */
public class TransparentImageView extends ImageView {

    /* renamed from: a */
    private Drawable f23828a;

    /* renamed from: b */
    private RectF f23829b;

    /* renamed from: c */
    private Paint f23830c;

    public TransparentImageView(Context context) {
        super(context);
        this.f23829b = new RectF();
        a();
    }

    private void a() {
        this.f23828a = getResources().getDrawable(R.drawable.trans_tv_bg);
        setLayerType(1, null);
        this.f23830c = new Paint();
        this.f23830c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f23829b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f23828a.setBounds(0, 0, getWidth(), getHeight());
        this.f23828a.setState(getDrawableState());
        this.f23828a.draw(canvas);
        if (isPressed()) {
            int saveLayer = canvas.saveLayer(this.f23829b, this.f23830c, 31);
            super.onDraw(canvas);
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.onDraw(canvas);
    }

    public TransparentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23829b = new RectF();
        a();
    }

    public TransparentImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23829b = new RectF();
        a();
    }

    @TargetApi(21)
    public TransparentImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23829b = new RectF();
        a();
    }
}
