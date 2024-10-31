package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.7C, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C7C {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    private final C7C A00(C7Z c7z, int i) {
        View view = c7z.A0H;
        this.A01 = view.getLeft();
        this.A03 = view.getTop();
        this.A02 = view.getRight();
        this.A00 = view.getBottom();
        return this;
    }

    public final C7C A01(C7Z c7z) {
        return A00(c7z, 0);
    }
}
