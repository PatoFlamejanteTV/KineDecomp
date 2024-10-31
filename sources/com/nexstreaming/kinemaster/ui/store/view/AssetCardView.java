package com.nexstreaming.kinemaster.ui.store.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes2.dex */
public class AssetCardView extends CardView {
    private Paint j;
    private boolean k;
    private Drawable l;

    public AssetCardView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.j.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.j.setColorFilter(new ColorMatrixColorFilter(new float[]{0.7f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.7f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.7f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.AssetCardView);
            this.l = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.k) {
            Drawable drawable = this.l;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.l.getIntrinsicWidth());
            this.l.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            setLayerType(2, this.j);
        } else if (action == 1 || action == 3 || action == 4) {
            setLayerType(2, null);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setNewAsset(boolean z) {
        this.k = z;
        invalidate();
    }

    public AssetCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public AssetCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
