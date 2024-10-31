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
import android.widget.Button;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.b;

/* loaded from: classes.dex */
public class TransparentTextButton extends Button {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f4382a;
    private RectF b;
    private Paint c;

    public TransparentTextButton(Context context) {
        super(context);
        this.b = new RectF();
        a();
    }

    public TransparentTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new RectF();
        a();
        a(attributeSet);
    }

    public TransparentTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new RectF();
        a();
        a(attributeSet);
    }

    @TargetApi(21)
    public TransparentTextButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = new RectF();
        a();
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (getContext().getTheme().obtainStyledAttributes(attributeSet, b.a.TransparentTextButton, 0, 0).getInteger(0, 0) == 1) {
            this.f4382a = getResources().getDrawable(R.drawable.red_button_border);
        }
    }

    private void a() {
        this.f4382a = getResources().getDrawable(R.drawable.btn_v3_gen);
        setLayerType(1, null);
        this.c = new Paint();
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f4382a.setBounds(0, 0, getWidth(), getHeight());
        this.f4382a.setState(getDrawableState());
        this.f4382a.draw(canvas);
        if (!isEnabled()) {
            setAlpha(0.3f);
            this.f4382a.setAlpha(170);
        } else {
            setAlpha(1.0f);
            this.f4382a.setAlpha(255);
        }
        if (isPressed()) {
            int saveLayer = canvas.saveLayer(this.b, this.c, 31);
            super.onDraw(canvas);
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.onDraw(canvas);
    }
}
