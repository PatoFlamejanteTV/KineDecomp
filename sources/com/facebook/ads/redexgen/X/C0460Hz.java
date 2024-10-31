package com.facebook.ads.redexgen.X;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Hz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0460Hz {
    public static final Map<EnumC0457Hw, EnumC0458Hx> A00 = new HashMap();

    static {
        A00.put(EnumC0457Hw.A08, EnumC0458Hx.A09);
        A00.put(EnumC0457Hw.A06, EnumC0458Hx.A0B);
        A00.put(EnumC0457Hw.A05, EnumC0458Hx.A0A);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.AdSize A00(com.facebook.ads.redexgen.X.EnumC0458Hx r4) {
        /*
            r3 = 0
            r2 = 0
            r0 = 0
            java.util.Map<com.facebook.ads.redexgen.X.Hw, com.facebook.ads.redexgen.X.Hx> r0 = com.facebook.ads.redexgen.X.C0460Hz.A00
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L1e;
                case 4: goto L32;
                case 5: goto L44;
                case 6: goto L40;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L1c
            r0 = 3
            goto Le
        L1c:
            r0 = 6
            goto Le
        L1e:
            com.facebook.ads.redexgen.X.Hx r4 = (com.facebook.ads.redexgen.X.EnumC0458Hx) r4
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r0 = r3.getValue()
            if (r0 != r4) goto L30
            r0 = 4
            goto Le
        L30:
            r0 = 2
            goto Le
        L32:
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r0 = r3.getKey()
            com.facebook.ads.redexgen.X.Hw r0 = (com.facebook.ads.redexgen.X.EnumC0457Hw) r0
            com.facebook.ads.AdSize r2 = r0.A05()
            r0 = 5
            goto Le
        L40:
            com.facebook.ads.AdSize r2 = com.facebook.ads.AdSize.BANNER_320_50
            r0 = 5
            goto Le
        L44:
            com.facebook.ads.AdSize r2 = (com.facebook.ads.AdSize) r2
            com.facebook.ads.AdSize r2 = (com.facebook.ads.AdSize) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0460Hz.A00(com.facebook.ads.redexgen.X.Hx):com.facebook.ads.AdSize");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0034, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.EnumC0458Hx A01(android.util.DisplayMetrics r4) {
        /*
            r0 = 0
            r3 = 0
            r0 = 0
            int r0 = r4.widthPixels
            float r1 = (float) r0
            float r0 = r4.density
            float r1 = r1 / r0
            int r2 = (int) r1
            int r0 = r4.heightPixels
            float r1 = (float) r0
            float r0 = r4.density
            float r1 = r1 / r0
            int r1 = (int) r1
            boolean r0 = com.facebook.ads.redexgen.X.C0487Jc.A04(r2, r1)
            if (r0 == 0) goto L2e
            r0 = 2
        L18:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L30;
                case 4: goto L20;
                case 5: goto L26;
                case 6: goto L2a;
                default: goto L1b;
            }
        L1b:
            goto L18
        L1c:
            com.facebook.ads.redexgen.X.Hx r3 = com.facebook.ads.redexgen.X.EnumC0458Hx.A0E
            r0 = 3
            goto L18
        L20:
            if (r1 <= r2) goto L24
            r0 = 5
            goto L18
        L24:
            r0 = 6
            goto L18
        L26:
            com.facebook.ads.redexgen.X.Hx r3 = com.facebook.ads.redexgen.X.EnumC0458Hx.A0G
            r0 = 3
            goto L18
        L2a:
            com.facebook.ads.redexgen.X.Hx r3 = com.facebook.ads.redexgen.X.EnumC0458Hx.A0D
            r0 = 3
            goto L18
        L2e:
            r0 = 4
            goto L18
        L30:
            com.facebook.ads.redexgen.X.Hx r3 = (com.facebook.ads.redexgen.X.EnumC0458Hx) r3
            com.facebook.ads.redexgen.X.Hx r3 = (com.facebook.ads.redexgen.X.EnumC0458Hx) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0460Hz.A01(android.util.DisplayMetrics):com.facebook.ads.redexgen.X.Hx");
    }

    public static EnumC0458Hx A02(EnumC0457Hw enumC0457Hw) {
        EnumC0458Hx enumC0458Hx = A00.get(enumC0457Hw);
        if (enumC0458Hx == null) {
            return EnumC0458Hx.A0C;
        }
        return enumC0458Hx;
    }

    public static void A03(DisplayMetrics displayMetrics, View view, EnumC0457Hw enumC0457Hw) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= enumC0457Hw.getWidth() ? displayMetrics.widthPixels : (int) Math.ceil(enumC0457Hw.getWidth() * displayMetrics.density), (int) Math.ceil(enumC0457Hw.getHeight() * displayMetrics.density));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }
}
