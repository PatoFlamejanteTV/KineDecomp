package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: assets/audience_network.dex */
public final class CN extends C0279Ax {
    public ContentResolver A00;
    public DisplayMetrics A01;

    public CN(Context context, AA aa) {
        super(context, aa);
        this.A01 = context.getResources().getDisplayMetrics();
        this.A00 = context.getContentResolver();
    }

    public final InterfaceC0267Al A0G() {
        return new CM(this);
    }

    public final InterfaceC0267Al A0H() {
        return new CJ(this);
    }

    public final InterfaceC0267Al A0I() {
        return new CK(this);
    }

    public final InterfaceC0267Al A0J() {
        return new CI(this);
    }

    public final InterfaceC0267Al A0K() {
        return new CL(this);
    }
}
