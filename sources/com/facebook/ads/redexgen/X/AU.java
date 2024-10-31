package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.SystemClock;
import android.view.OrientationEventListener;
import javax.annotation.Nullable;

/* loaded from: assets/audience_network.dex */
public final class AU {

    @Nullable
    public static OrientationEventListener A02;
    public final AS A00;
    public final EnumC0349Dp A01;

    public AU(AS as, EnumC0349Dp enumC0349Dp) {
        this.A00 = as;
        this.A01 = enumC0349Dp;
    }

    public final synchronized void A01() {
        if (A02 != null) {
            A02.disable();
            A02 = null;
        }
    }

    public final synchronized void A02(Context context) {
        if (A02 == null) {
            A02 = new AT(this, context, 3, SystemClock.elapsedRealtime(), this.A01 == EnumC0349Dp.A0F ? null : new E7(context == null ? "" : context.getPackageName()));
            A02.enable();
        }
    }
}
