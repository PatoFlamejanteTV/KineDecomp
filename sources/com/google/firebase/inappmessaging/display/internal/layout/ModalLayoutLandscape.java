package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class ModalLayoutLandscape extends BaseModalLayout {

    /* renamed from: e */
    private View f17686e;

    /* renamed from: f */
    private View f17687f;

    /* renamed from: g */
    private View f17688g;

    /* renamed from: h */
    private View f17689h;
    private int i;
    private int j;
    private int k;
    private int l;

    public ModalLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        super.onLayout(z, i, i2, i3, i4);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i7 = this.k;
        int i8 = this.l;
        if (i7 < i8) {
            i6 = (i8 - i7) / 2;
            i5 = 0;
        } else {
            i5 = (i7 - i8) / 2;
            i6 = 0;
        }
        Logging.a("Layout image");
        int i9 = paddingTop + i6;
        int b2 = b(this.f17686e) + paddingLeft;
        a(this.f17686e, paddingLeft, i9, b2, i9 + a(this.f17686e));
        int i10 = b2 + this.i;
        Logging.a("Layout getTitle");
        int i11 = paddingTop + i5;
        int a2 = a(this.f17687f) + i11;
        a(this.f17687f, i10, i11, measuredWidth, a2);
        Logging.a("Layout getBody");
        int i12 = a2 + (this.f17687f.getVisibility() == 8 ? 0 : this.j);
        int a3 = a(this.f17688g) + i12;
        a(this.f17688g, i10, i12, measuredWidth, a3);
        Logging.a("Layout button");
        a(this.f17689h, i10, a3 + (this.f17688g.getVisibility() != 8 ? this.j : 0));
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f17686e = d(R.id.image_view);
        this.f17687f = d(R.id.message_title);
        this.f17688g = d(R.id.body_scroll);
        this.f17689h = d(R.id.button);
        int i3 = 0;
        this.i = this.f17686e.getVisibility() == 8 ? 0 : c(24);
        this.j = c(24);
        List asList = Arrays.asList(this.f17687f, this.f17688g, this.f17689h);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int b2 = b(i);
        int a2 = a(i2) - paddingBottom;
        int i4 = b2 - paddingLeft;
        Logging.a("Measuring image");
        MeasureUtils.a(this.f17686e, (int) (i4 * 0.4f), a2);
        int b3 = b(this.f17686e);
        int i5 = i4 - (this.i + b3);
        float f2 = b3;
        Logging.a("Max col widths (l, r)", f2, i5);
        Iterator it = asList.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() != 8) {
                i6++;
            }
        }
        int max = Math.max(0, (i6 - 1) * this.j);
        int i7 = a2 - max;
        Logging.a("Measuring getTitle");
        MeasureUtils.a(this.f17687f, i5, i7);
        Logging.a("Measuring button");
        MeasureUtils.a(this.f17689h, i5, i7);
        Logging.a("Measuring scroll view");
        MeasureUtils.a(this.f17688g, i5, (i7 - a(this.f17687f)) - a(this.f17689h));
        this.k = a(this.f17686e);
        this.l = max;
        Iterator it2 = asList.iterator();
        while (it2.hasNext()) {
            this.l += a((View) it2.next());
        }
        int max2 = Math.max(this.k + paddingBottom, this.l + paddingBottom);
        Iterator it3 = asList.iterator();
        while (it3.hasNext()) {
            i3 = Math.max(b((View) it3.next()), i3);
        }
        Logging.a("Measured columns (l, r)", f2, i3);
        int i8 = b3 + i3 + this.i + paddingLeft;
        Logging.a("Measured dims", i8, max2);
        setMeasuredDimension(i8, max2);
    }
}
