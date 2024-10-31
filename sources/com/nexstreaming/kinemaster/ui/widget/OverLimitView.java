package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes2.dex */
public class OverLimitView extends View {
    public OverLimitView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.nexstreaming.kinemaster.usage.analytics.b.a(OverLimitView.class.getName());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        getDrawingRect(rect);
        Drawable drawable = getResources().getDrawable(R.drawable.stripes_tile);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        for (int i = rect.top; i < rect.bottom + 1; i += intrinsicHeight) {
            int i2 = rect.left;
            while (i2 < rect.right + 1) {
                int i3 = i2 + intrinsicWidth;
                int i4 = i + intrinsicHeight;
                if (!canvas.quickReject(i2, i, i3, i4, Canvas.EdgeType.AA)) {
                    drawable.setBounds(i2, i, i3, i4);
                    drawable.setAlpha(100);
                    drawable.draw(canvas);
                }
                i2 = i3;
            }
        }
    }

    public OverLimitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OverLimitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public OverLimitView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
