package h.a.a.a;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: CalligraphyTypefaceSpan.java */
/* loaded from: classes3.dex */
public class g extends MetricAffectingSpan {

    /* renamed from: a */
    private final Typeface f26807a;

    public g(Typeface typeface) {
        if (typeface != null) {
            this.f26807a = typeface;
            return;
        }
        throw new IllegalArgumentException("typeface is null");
    }

    private void a(Paint paint) {
        Typeface typeface = paint.getTypeface();
        int style = (typeface != null ? typeface.getStyle() : 0) & (this.f26807a.getStyle() ^ (-1));
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.f26807a);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
