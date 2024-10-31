package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;

/* loaded from: assets/audience_network.dex */
public final class AY {
    public final Context A00;
    public final AS A01;
    public final EnumC0349Dp A02;

    public AY(Context context, AS as, EnumC0349Dp enumC0349Dp) {
        this.A01 = as;
        this.A00 = context;
        this.A02 = enumC0349Dp;
    }

    public final void A00(MotionEvent motionEvent) {
        int i;
        int i2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        E7 e7 = this.A02 == EnumC0349Dp.A0F ? null : new E7(this.A00 == null ? "" : this.A00.getPackageName());
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 1:
            case 3:
            case 5:
            case 6:
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 14) {
                    i = motionEvent.getToolType(actionIndex);
                } else {
                    i = -1;
                }
                this.A01.A02(new EA(elapsedRealtime, e7, new C0258Ac(motionEvent.getActionMasked(), pointerId, i, new float[]{motionEvent.getRawX(), motionEvent.getRawY()}, motionEvent.getSize(actionIndex), Math.min(motionEvent.getPressure(actionIndex), 1.0f), motionEvent.getOrientation(actionIndex))), AR.A0D);
                return;
            case 2:
            case 4:
                for (int i4 = 0; i4 < motionEvent.getPointerCount(); i4++) {
                    int pointerId2 = motionEvent.getPointerId(i4);
                    int i5 = Build.VERSION.SDK_INT;
                    if (i5 >= 14) {
                        i2 = motionEvent.getToolType(i4);
                    } else {
                        i2 = -1;
                    }
                    this.A01.A02(new EA(elapsedRealtime, e7, new C0258Ac(motionEvent.getActionMasked(), pointerId2, i2, new float[]{motionEvent.getRawX(), motionEvent.getRawY()}, motionEvent.getSize(i4), Math.min(motionEvent.getPressure(i4), 1.0f), motionEvent.getOrientation(i4))), AR.A0D);
                }
                return;
            default:
                return;
        }
    }
}
