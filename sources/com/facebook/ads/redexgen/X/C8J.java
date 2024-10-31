package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;

/* renamed from: com.facebook.ads.redexgen.X.8J, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C8J extends C02017w implements NativeAdLayoutApi {

    @Nullable
    public View A02;
    public NativeAdLayout A03;

    @Nullable
    public PU A04;
    public int A01 = 0;
    public int A00 = 0;

    public final void A02() {
        KE.A0U(this.A03);
        this.A03.removeView(this.A02);
        this.A02 = null;
    }

    public final void A03(MZ mz) {
        this.A02 = mz;
        mz.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        KE.A0U(this.A03);
        this.A03.addView(this.A02);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A04(@android.support.annotation.Nullable java.lang.String r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r3 = -1
            com.facebook.ads.redexgen.X.PU r0 = r4.A04
            if (r0 == 0) goto L4a
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L17;
                case 4: goto L33;
                case 5: goto L4c;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.8J r4 = (com.facebook.ads.redexgen.X.C8J) r4
            com.facebook.ads.NativeAdLayout r1 = r4.A03
            com.facebook.ads.redexgen.X.PU r0 = r4.A04
            r1.removeView(r0)
            r0 = 3
            goto L8
        L17:
            com.facebook.ads.redexgen.X.8J r4 = (com.facebook.ads.redexgen.X.C8J) r4
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.NativeAdLayout r0 = r4.A03
            android.content.Context r0 = r0.getContext()
            com.facebook.ads.redexgen.X.Ec r0 = com.facebook.ads.redexgen.X.C8N.A02(r0)
            com.facebook.ads.redexgen.X.PU r0 = com.facebook.ads.redexgen.X.PT.A01(r0, r6)
            r4.A04 = r0
            com.facebook.ads.redexgen.X.PU r0 = r4.A04
            if (r0 == 0) goto L31
            r0 = 4
            goto L8
        L31:
            r0 = 5
            goto L8
        L33:
            com.facebook.ads.redexgen.X.8J r4 = (com.facebook.ads.redexgen.X.C8J) r4
            com.facebook.ads.NativeAdLayout r2 = r4.A03
            com.facebook.ads.redexgen.X.PU r1 = r4.A04
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r0.<init>(r3, r3)
            r2.addView(r1, r0)
            com.facebook.ads.NativeAdLayout r1 = r4.A03
            com.facebook.ads.redexgen.X.PU r0 = r4.A04
            r1.bringChildToFront(r0)
            r0 = 5
            goto L8
        L4a:
            r0 = 3
            goto L8
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8J.A04(java.lang.String):void");
    }

    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    public final void initialize(NativeAdLayout nativeAdLayout) {
        this.A03 = nativeAdLayout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C02017w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            r2 = r3
            super.onMeasure(r4, r5)
            int r0 = r2.A00
            if (r0 <= 0) goto L4b
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1d;
                case 4: goto L4d;
                case 5: goto L2c;
                case 6: goto L3c;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.8J r2 = (com.facebook.ads.redexgen.X.C8J) r2
            com.facebook.ads.NativeAdLayout r0 = r2.A03
            int r1 = r0.getMeasuredWidth()
            int r0 = r2.A00
            if (r1 <= r0) goto L1b
            r0 = 3
            goto L9
        L1b:
            r0 = 5
            goto L9
        L1d:
            com.facebook.ads.redexgen.X.8J r2 = (com.facebook.ads.redexgen.X.C8J) r2
            int r1 = r2.A00
            com.facebook.ads.NativeAdLayout r0 = r2.A03
            int r0 = r0.getMeasuredHeight()
            r2.setMeasuredDimension(r1, r0)
            r0 = 4
            goto L9
        L2c:
            com.facebook.ads.redexgen.X.8J r2 = (com.facebook.ads.redexgen.X.C8J) r2
            com.facebook.ads.NativeAdLayout r0 = r2.A03
            int r1 = r0.getMeasuredWidth()
            int r0 = r2.A01
            if (r1 >= r0) goto L3a
            r0 = 6
            goto L9
        L3a:
            r0 = 4
            goto L9
        L3c:
            com.facebook.ads.redexgen.X.8J r2 = (com.facebook.ads.redexgen.X.C8J) r2
            int r1 = r2.A01
            com.facebook.ads.NativeAdLayout r0 = r2.A03
            int r0 = r0.getMeasuredHeight()
            r2.setMeasuredDimension(r1, r0)
            r0 = 4
            goto L9
        L4b:
            r0 = 5
            goto L9
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8J.onMeasure(int, int):void");
    }

    public final void setMaxWidth(int i) {
        this.A00 = i;
    }

    public final void setMinWidth(int i) {
        this.A01 = i;
    }
}
