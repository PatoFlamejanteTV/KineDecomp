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
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes2.dex */
public class TransparentTextView extends TextView {

    /* renamed from: a */
    private Drawable f23834a;

    /* renamed from: b */
    private RectF f23835b;

    /* renamed from: c */
    private Paint f23836c;

    public TransparentTextView(Context context) {
        super(context);
        this.f23835b = new RectF();
        a();
    }

    private void a() {
        this.f23834a = getResources().getDrawable(R.drawable.trans_tv_bg);
        setLayerType(1, null);
        this.f23836c = new Paint();
        this.f23836c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f23835b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f23834a.setBounds(0, 0, getWidth(), getHeight());
        this.f23834a.setState(getDrawableState());
        this.f23834a.draw(canvas);
        if (isPressed()) {
            int saveLayer = canvas.saveLayer(this.f23835b, this.f23836c, 31);
            super.onDraw(canvas);
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.onDraw(canvas);
    }

    public TransparentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23835b = new RectF();
        a();
    }

    public TransparentTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23835b = new RectF();
        a();
    }

    @TargetApi(21)
    public TransparentTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23835b = new RectF();
        a();
    }
}
