package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* loaded from: classes2.dex */
public class StateRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private Paint f22094a;

    public StateRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setLayerType(2, null);
            return;
        }
        if (this.f22094a == null) {
            ColorMatrix colorMatrix = new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f});
            this.f22094a = new Paint();
            this.f22094a.setAntiAlias(true);
            this.f22094a.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        }
        setLayerType(2, this.f22094a);
    }

    public StateRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StateRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
