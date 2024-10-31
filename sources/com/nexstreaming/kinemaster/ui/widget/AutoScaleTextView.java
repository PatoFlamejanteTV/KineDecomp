package com.nexstreaming.kinemaster.ui.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class AutoScaleTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private float f4372a;
    private float b;

    public AutoScaleTextView(Context context) {
        super(context);
        this.f4372a = 0.0f;
        this.b = 0.0f;
    }

    public AutoScaleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4372a = 0.0f;
        this.b = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.layout_width, R.attr.layout_height});
        try {
            this.f4372a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
            this.f4372a = context.getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.product_view_price_text_width);
        }
        try {
            this.b = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        } catch (UnsupportedOperationException e2) {
            e2.printStackTrace();
            this.b = context.getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.product_view_price_text_height);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        float f = this.b;
        Paint paint = new Paint();
        paint.setTextSize(f);
        Rect rect = new Rect();
        paint.getTextBounds(String.valueOf(charSequence), 0, charSequence.length(), rect);
        int width = rect.width();
        int height = rect.height() - ((int) (getResources().getDisplayMetrics().density * 4.0f));
        while (true) {
            if (width <= this.f4372a && height <= this.b) {
                break;
            }
            f -= getContext().getResources().getDisplayMetrics().density;
            if (f <= 0.0f) {
                rect.width();
                height = rect.height();
                break;
            } else {
                paint.setTextSize(f);
                paint.getTextBounds(String.valueOf(charSequence), 0, charSequence.length(), rect);
                width = rect.width();
                height = rect.height();
            }
        }
        setTextSize(0, height);
    }
}
