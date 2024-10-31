package c.f.a.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: DimensionCalculator.java */
/* loaded from: classes3.dex */
public class a {
    public Rect a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new Rect();
    }

    private Rect a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }
}
