package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: assets/audience_network.dex */
public final class P8 {
    public final int[] A00(View view, int i, int i2) {
        C01596e c01596e = (C01596e) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, view.getPaddingLeft() + view.getPaddingRight(), c01596e.width), ViewGroup.getChildMeasureSpec(i2, view.getPaddingTop() + view.getPaddingBottom(), c01596e.height));
        return new int[]{view.getMeasuredWidth() + c01596e.leftMargin + c01596e.rightMargin, view.getMeasuredHeight() + c01596e.bottomMargin + c01596e.topMargin};
    }
}
