package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes.dex */
public class AutoResizeTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    private a f4371a;
    private boolean b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private boolean h;

    /* loaded from: classes.dex */
    public interface a {
        void a(TextView textView, float f, float f2);
    }

    public AutoResizeTextView(Context context) {
        this(context, null);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.d = 0.0f;
        this.e = 10.0f;
        this.f = 1.0f;
        this.g = 0.0f;
        this.h = true;
        this.c = getTextSize();
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.b = true;
        a();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3 || i2 != i4) {
            this.b = true;
        }
    }

    public void setOnResizeListener(a aVar) {
        this.f4371a = aVar;
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        this.c = getTextSize();
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.c = getTextSize();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.f = f2;
        this.g = f;
    }

    public void setMaxTextSize(float f) {
        this.d = f;
        requestLayout();
        invalidate();
    }

    public float getMaxTextSize() {
        return this.d;
    }

    public void setMinTextSize(float f) {
        this.e = f;
        requestLayout();
        invalidate();
    }

    public float getMinTextSize() {
        return this.e;
    }

    public void setAddEllipsis(boolean z) {
        this.h = z;
    }

    public boolean getAddEllipsis() {
        return this.h;
    }

    public void a() {
        if (this.c > 0.0f) {
            super.setTextSize(0, this.c);
            this.d = this.c;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.b) {
            a(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void a(int i, int i2) {
        CharSequence text = getText();
        if (text != null && text.length() != 0 && i2 > 0 && i > 0 && this.c != 0.0f) {
            if (getTransformationMethod() != null) {
                text = getTransformationMethod().getTransformation(text, this);
            }
            TextPaint paint = getPaint();
            float textSize = paint.getTextSize();
            float min = this.d > 0.0f ? Math.min(this.c, this.d) : this.c;
            float f = min;
            int a2 = a(text, paint, i, min);
            while (a2 > i2 && f > this.e) {
                float max = Math.max(f - 2.0f, this.e);
                a2 = a(text, paint, i, max);
                f = max;
            }
            if (this.h && f == this.e && a2 > i2) {
                StaticLayout staticLayout = new StaticLayout(text, new TextPaint(paint), i, Layout.Alignment.ALIGN_NORMAL, this.f, this.g, false);
                if (staticLayout.getLineCount() > 0) {
                    int lineForVertical = staticLayout.getLineForVertical(i2) - 1;
                    if (lineForVertical < 0) {
                        setText("");
                    } else {
                        int lineStart = staticLayout.getLineStart(lineForVertical);
                        int lineEnd = staticLayout.getLineEnd(lineForVertical);
                        float lineWidth = staticLayout.getLineWidth(lineForVertical);
                        float measureText = paint.measureText("...");
                        while (i < lineWidth + measureText) {
                            lineEnd--;
                            lineWidth = paint.measureText(text.subSequence(lineStart, lineEnd + 1).toString());
                        }
                        setText(((Object) text.subSequence(0, lineEnd)) + "...");
                    }
                }
            }
            setTextSize(0, f);
            setLineSpacing(this.g, this.f);
            if (this.f4371a != null) {
                this.f4371a.a(this, textSize, f);
            }
            this.b = false;
        }
    }

    private int a(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Layout.Alignment.ALIGN_NORMAL, this.f, this.g, true).getHeight();
    }
}
