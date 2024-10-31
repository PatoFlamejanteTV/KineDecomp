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

/* loaded from: classes2.dex */
public class TransparentTextButton extends Button {

    /* renamed from: a */
    private Drawable f23831a;

    /* renamed from: b */
    private RectF f23832b;

    /* renamed from: c */
    private Paint f23833c;

    public TransparentTextButton(Context context) {
        super(context);
        this.f23832b = new RectF();
        a();
    }

    private void a(AttributeSet attributeSet) {
        int integer = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.TransparentTextButton, 0, 0).getInteger(0, 0);
        if (integer == 1) {
            this.f23831a = getResources().getDrawable(R.drawable.red_button_border);
        } else if (integer == 2) {
            this.f23831a = getResources().getDrawable(R.drawable.dark_gray_button_border);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f23832b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f23831a.setBounds(0, 0, getWidth(), getHeight());
        this.f23831a.setState(getDrawableState());
        this.f23831a.draw(canvas);
        if (!isEnabled()) {
            setAlpha(0.3f);
            this.f23831a.setAlpha(170);
        } else {
            setAlpha(1.0f);
            this.f23831a.setAlpha(255);
        }
        if (isPressed()) {
            int saveLayer = canvas.saveLayer(this.f23832b, this.f23833c, 31);
            super.onDraw(canvas);
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.onDraw(canvas);
    }

    public TransparentTextButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23832b = new RectF();
        a();
        a(attributeSet);
    }

    private void a() {
        this.f23831a = getResources().getDrawable(R.drawable.btn_v3_gen);
        setLayerType(1, null);
        this.f23833c = new Paint();
        this.f23833c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public TransparentTextButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23832b = new RectF();
        a();
        a(attributeSet);
    }

    @TargetApi(21)
    public TransparentTextButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23832b = new RectF();
        a();
        a(attributeSet);
    }
}
