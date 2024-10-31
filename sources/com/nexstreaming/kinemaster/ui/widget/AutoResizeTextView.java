package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes2.dex */
public class AutoResizeTextView extends TextView {

    /* renamed from: a */
    private a f23711a;

    /* renamed from: b */
    private boolean f23712b;

    /* renamed from: c */
    private float f23713c;

    /* renamed from: d */
    private float f23714d;

    /* renamed from: e */
    private float f23715e;

    /* renamed from: f */
    private float f23716f;

    /* renamed from: g */
    private float f23717g;

    /* renamed from: h */
    private boolean f23718h;

    /* loaded from: classes2.dex */
    public interface a {
        void a(TextView textView, float f2, float f3);
    }

    public AutoResizeTextView(Context context) {
        this(context, null);
    }

    public void a() {
        float f2 = this.f23713c;
        if (f2 > 0.0f) {
            super.setTextSize(0, f2);
            this.f23714d = this.f23713c;
        }
    }

    public boolean getAddEllipsis() {
        return this.f23718h;
    }

    public float getMaxTextSize() {
        return this.f23714d;
    }

    public float getMinTextSize() {
        return this.f23715e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.f23712b) {
            a(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i == i3 && i2 == i4) {
            return;
        }
        this.f23712b = true;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f23712b = true;
        a();
    }

    public void setAddEllipsis(boolean z) {
        this.f23718h = z;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f2, float f3) {
        super.setLineSpacing(f2, f3);
        this.f23716f = f3;
        this.f23717g = f2;
    }

    public void setMaxTextSize(float f2) {
        this.f23714d = f2;
        requestLayout();
        invalidate();
    }

    public void setMinTextSize(float f2) {
        this.f23715e = f2;
        requestLayout();
        invalidate();
    }

    public void setOnResizeListener(a aVar) {
        this.f23711a = aVar;
    }

    @Override // android.widget.TextView
    public void setTextSize(float f2) {
        super.setTextSize(f2);
        this.f23713c = getTextSize();
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23712b = false;
        this.f23714d = 0.0f;
        this.f23715e = 10.0f;
        this.f23716f = 1.0f;
        this.f23717g = 0.0f;
        this.f23718h = true;
        this.f23713c = getTextSize();
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f2) {
        super.setTextSize(i, f2);
        this.f23713c = getTextSize();
    }

    public void a(int i, int i2) {
        CharSequence text = getText();
        if (text == null || text.length() == 0 || i2 <= 0 || i <= 0 || this.f23713c == 0.0f) {
            return;
        }
        if (getTransformationMethod() != null) {
            text = getTransformationMethod().getTransformation(text, this);
        }
        CharSequence charSequence = text;
        TextPaint paint = getPaint();
        float textSize = paint.getTextSize();
        float f2 = this.f23714d;
        float min = f2 > 0.0f ? Math.min(this.f23713c, f2) : this.f23713c;
        int a2 = a(charSequence, paint, i, min);
        float f3 = min;
        while (a2 > i2) {
            float f4 = this.f23715e;
            if (f3 <= f4) {
                break;
            }
            f3 = Math.max(f3 - 2.0f, f4);
            a2 = a(charSequence, paint, i, f3);
        }
        if (this.f23718h && f3 == this.f23715e && a2 > i2) {
            StaticLayout staticLayout = new StaticLayout(charSequence, new TextPaint(paint), i, Layout.Alignment.ALIGN_NORMAL, this.f23716f, this.f23717g, false);
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
                        lineWidth = paint.measureText(charSequence.subSequence(lineStart, lineEnd + 1).toString());
                    }
                    setText(((Object) charSequence.subSequence(0, lineEnd)) + "...");
                }
            }
        }
        setTextSize(0, f3);
        setLineSpacing(this.f23717g, this.f23716f);
        a aVar = this.f23711a;
        if (aVar != null) {
            aVar.a(this, textSize, f3);
        }
        this.f23712b = false;
    }

    private int a(CharSequence charSequence, TextPaint textPaint, int i, float f2) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f2);
        return new StaticLayout(charSequence, textPaint2, i, Layout.Alignment.ALIGN_NORMAL, this.f23716f, this.f23717g, true).getHeight();
    }
}
