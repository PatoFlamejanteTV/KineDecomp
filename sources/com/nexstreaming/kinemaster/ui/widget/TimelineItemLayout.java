package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes2.dex */
public class TimelineItemLayout extends RelativeLayout {

    /* renamed from: a */
    private Paint f23818a;

    /* renamed from: b */
    private boolean f23819b;

    public TimelineItemLayout(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f23819b) {
            return;
        }
        if (this.f23818a == null) {
            this.f23818a = new Paint();
            this.f23818a.setColor(-1728053248);
        }
        canvas.drawPaint(this.f23818a);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.f23819b = z;
        invalidate();
    }

    public TimelineItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    public TimelineItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
    }
}
