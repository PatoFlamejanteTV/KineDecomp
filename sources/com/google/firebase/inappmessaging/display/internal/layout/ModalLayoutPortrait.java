package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure;
import com.google.firebase.inappmessaging.display.internal.layout.util.ViewMeasure;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class ModalLayoutPortrait extends BaseModalLayout {

    /* renamed from: e */
    private VerticalViewGroupMeasure f17690e;

    /* renamed from: f */
    private int f17691f;

    public ModalLayoutPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17690e = new VerticalViewGroupMeasure();
    }

    private boolean d(View view) {
        return view.getId() == R.id.body_scroll || view.getId() == R.id.image_view;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int size = getVisibleChildren().size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = getVisibleChildren().get(i7);
            FrameLayout.LayoutParams c2 = c(view);
            int measuredHeight = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i8 = measuredHeight + paddingTop;
            if ((c2.gravity & 1) == 1) {
                int i9 = (i3 - i) / 2;
                int i10 = measuredWidth / 2;
                i6 = i9 - i10;
                i5 = i9 + i10;
            } else {
                i5 = paddingLeft + measuredWidth;
                i6 = paddingLeft;
            }
            Logging.a("Layout child " + i7);
            Logging.a("\t(top, bottom)", (float) paddingTop, (float) i8);
            Logging.a("\t(left, right)", (float) i6, (float) i5);
            view.layout(i6, paddingTop, i5, i8);
            paddingTop += view.getMeasuredHeight();
            if (i7 < size - 1) {
                paddingTop += this.f17691f;
            }
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f17691f = c(24);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int b2 = b(i);
        int a2 = a(i2);
        int size = paddingBottom + ((getVisibleChildren().size() - 1) * this.f17691f);
        this.f17690e.a(b2, a2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            this.f17690e.a(childAt, d(childAt));
        }
        Logging.a("Screen dimens: " + getDisplayMetrics());
        Logging.a("Max pct", getMaxWidthPct(), getMaxHeightPct());
        float f2 = (float) b2;
        Logging.a("Base dimens", f2, (float) a2);
        for (ViewMeasure viewMeasure : this.f17690e.c()) {
            Logging.a("Pre-measure child");
            viewMeasure.a(b2, a2);
        }
        int b3 = this.f17690e.b() + size;
        Logging.a("Total reserved height", size);
        Logging.a("Total desired height", b3);
        boolean z = b3 > a2;
        Logging.a("Total height constrained: " + z);
        if (z) {
            this.f17690e.a((a2 - size) - this.f17690e.a());
        }
        int i4 = b2 - paddingRight;
        for (ViewMeasure viewMeasure2 : this.f17690e.c()) {
            Logging.a("Measuring child");
            MeasureUtils.a(viewMeasure2.c(), i4, viewMeasure2.b());
            size += a(viewMeasure2.c());
        }
        Logging.a("Measured dims", f2, size);
        setMeasuredDimension(b2, size);
    }
}
