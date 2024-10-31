package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.7E, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C7E {
    @Deprecated
    private final void A00(Rect rect, int i, C01807a c01807a) {
        rect.set(0, 0, 0, 0);
    }

    public final void A01(Rect rect, View view, C01807a c01807a, C7W c7w) {
        A00(rect, ((C01596e) view.getLayoutParams()).A00(), c01807a);
    }
}
