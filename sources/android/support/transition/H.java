package android.support.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: RectEvaluator.java */
/* loaded from: classes.dex */
class H implements TypeEvaluator<Rect> {

    /* renamed from: a */
    private Rect f531a;

    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public Rect evaluate(float f2, Rect rect, Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - r0) * f2));
        int i2 = rect.top + ((int) ((rect2.top - r1) * f2));
        int i3 = rect.right + ((int) ((rect2.right - r2) * f2));
        int i4 = rect.bottom + ((int) ((rect2.bottom - r6) * f2));
        Rect rect3 = this.f531a;
        if (rect3 == null) {
            return new Rect(i, i2, i3, i4);
        }
        rect3.set(i, i2, i3, i4);
        return this.f531a;
    }
}
