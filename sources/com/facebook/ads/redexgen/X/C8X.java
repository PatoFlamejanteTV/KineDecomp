package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ads.AdSize;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView;
import com.facebook.ads.internal.api.InstreamVideoAdViewApi;
import com.facebook.ads.internal.protocol.AdPlacementType;

/* renamed from: com.facebook.ads.redexgen.X.8X, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8X implements InstreamVideoAdViewApi {
    public static byte[] A0E;

    @Nullable
    public Bundle A00;

    @Nullable
    public View A01;

    @Nullable
    public InstreamVideoAdListener A02;

    @Nullable
    public C00321d A03;

    @Nullable
    public C3B A04;
    public C8W A05;

    @Nullable
    public NQ A06;

    @Nullable
    public String A07;

    @Nullable
    public String A08;
    public boolean A09;
    public final AdSize A0A;
    public final InstreamVideoAdView A0B;
    public final C0362Ec A0C;
    public final String A0D;

    static {
        A0D();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A09(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C8X.A0E
            int r0 = r2 + r3
            byte[] r2 = java.util.Arrays.copyOfRange(r1, r2, r0)
            r1 = 0
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L19;
                case 4: goto L27;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            if (r1 >= r0) goto L17
            r0 = 3
            goto Lc
        L17:
            r0 = 4
            goto Lc
        L19:
            byte[] r2 = (byte[]) r2
            r0 = r2[r1]
            r0 = r0 ^ r4
            r0 = r0 ^ 125(0x7d, float:1.75E-43)
            byte r0 = (byte) r0
            r2[r1] = r0
            int r1 = r1 + 1
            r0 = 2
            goto Lc
        L27:
            byte[] r2 = (byte[]) r2
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8X.A09(int, int, int):java.lang.String");
    }

    public static void A0D() {
        A0E = new byte[]{105, 117, 120, 122, 124, 116, 124, 119, 109, 80, 93, 121, 124, 75, 113, 98, 125, Byte.MAX_VALUE, 122, Byte.MAX_VALUE, 110, 106, 123, 108};
    }

    public C8X(InstreamVideoAdView instreamVideoAdView, Context context, Bundle bundle) {
        this(instreamVideoAdView, context, bundle.getString(A09(0, 11, 100)), (AdSize) bundle.get(A09(11, 6, 101)));
        this.A00 = bundle;
    }

    public C8X(InstreamVideoAdView instreamVideoAdView, Context context, String str, AdSize adSize) {
        this.A09 = false;
        this.A0B = instreamVideoAdView;
        this.A0C = C8N.A02(context);
        this.A0D = str;
        this.A0A = adSize;
        this.A05 = new C8W(this);
        this.A04 = A04();
    }

    private C3B A04() {
        AnonymousClass31 anonymousClass31 = new AnonymousClass31(this.A0D, EnumC0458Hx.A03, AdPlacementType.INSTREAM, EnumC0457Hw.A02(this.A0A), 1);
        anonymousClass31.A05(this.A07);
        anonymousClass31.A06(this.A08);
        this.A04 = new C3B(this.A0C, anonymousClass31);
        this.A04.A0E(this.A05);
        return this.A04;
    }

    private void A0C() {
        if (this.A04 != null) {
            this.A04.A0I(true);
            this.A04 = null;
            this.A04 = A04();
            this.A03 = null;
            this.A09 = false;
            this.A0B.removeAllViews();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0E(@android.support.annotation.Nullable java.lang.String r19) {
        /*
            r18 = this;
            r1 = r19
            r6 = r18
            com.facebook.ads.redexgen.X.3B r0 = r6.A04
            if (r0 != 0) goto L63
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto L65;
                case 3: goto Ld;
                case 4: goto L17;
                case 5: goto L58;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.8X r6 = (com.facebook.ads.redexgen.X.C8X) r6
            android.os.Bundle r0 = r6.A00
            if (r0 == 0) goto L15
            r0 = 4
            goto L9
        L15:
            r0 = 5
            goto L9
        L17:
            com.facebook.ads.redexgen.X.8X r6 = (com.facebook.ads.redexgen.X.C8X) r6
            com.facebook.ads.redexgen.X.1K r2 = new com.facebook.ads.redexgen.X.1K
            r2.<init>()
            com.facebook.ads.internal.protocol.AdPlacementType r0 = com.facebook.ads.internal.protocol.AdPlacementType.INSTREAM
            com.facebook.ads.redexgen.X.1F r12 = r2.A00(r0)
            com.facebook.ads.redexgen.X.1d r12 = (com.facebook.ads.redexgen.X.C00321d) r12
            r6.A03 = r12
            com.facebook.ads.redexgen.X.Ec r13 = r6.A0C
            com.facebook.ads.redexgen.X.1z r5 = new com.facebook.ads.redexgen.X.1z
            com.facebook.ads.InstreamVideoAdListener r7 = r6.A02
            com.facebook.ads.InstreamVideoAdView r8 = r6.A0B
            android.view.View r9 = r6.A01
            com.facebook.ads.redexgen.X.Ec r10 = r6.A0C
            java.lang.String r11 = r6.A08
            r5.<init>(r6, r7, r8, r9, r10, r11)
            com.facebook.ads.redexgen.X.3B r0 = r6.A04
            com.facebook.ads.redexgen.X.Gl r15 = r0.A08
            android.os.Bundle r4 = r6.A00
            r3 = 17
            r2 = 7
            r0 = 99
            java.lang.String r0 = A09(r3, r2, r0)
            android.os.Bundle r16 = r4.getBundle(r0)
            com.facebook.ads.CacheFlag r0 = com.facebook.ads.CacheFlag.NONE
            java.util.EnumSet r17 = java.util.EnumSet.of(r0)
            r14 = r5
            r12.A0F(r13, r14, r15, r16, r17)
            r0 = 2
            goto L9
        L58:
            com.facebook.ads.redexgen.X.8X r6 = (com.facebook.ads.redexgen.X.C8X) r6
            java.lang.String r1 = (java.lang.String) r1
            com.facebook.ads.redexgen.X.3B r0 = r6.A04
            r0.A0G(r1)
            r0 = 2
            goto L9
        L63:
            r0 = 3
            goto L9
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8X.A0E(java.lang.String):void");
    }

    public final InstreamVideoAdView.InstreamVideoLoadConfigBuilder buildLoadAdConfig() {
        return new H4(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0042, code lost:            r2.A0C();     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0047, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void destroy() {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.NQ r0 = r2.A06
            if (r0 == 0) goto L40
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L14;
                case 4: goto L22;
                case 5: goto L31;
                case 6: goto L42;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 18
            if (r1 < r0) goto L12
            r0 = 3
            goto L6
        L12:
            r0 = 6
            goto L6
        L14:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            com.facebook.ads.redexgen.X.Ec r0 = r2.A0C
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0d(r0)
            if (r0 == 0) goto L20
            r0 = 4
            goto L6
        L20:
            r0 = 6
            goto L6
        L22:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            com.facebook.ads.redexgen.X.NQ r0 = r2.A06
            r0.A07()
            android.view.View r0 = r2.A01
            if (r0 == 0) goto L2f
            r0 = 5
            goto L6
        L2f:
            r0 = 6
            goto L6
        L31:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            android.view.View r0 = r2.A01
            android.view.ViewOverlay r1 = r0.getOverlay()
            com.facebook.ads.redexgen.X.NQ r0 = r2.A06
            r1.remove(r0)
            r0 = 6
            goto L6
        L40:
            r0 = 6
            goto L6
        L42:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            r2.A0C()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8X.destroy():void");
    }

    public final String getPlacementId() {
        return this.A0D;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0074, code lost:            return r4;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle getSaveInstanceState() {
        /*
            r7 = this;
            r6 = r7
            r5 = 0
            r0 = 0
            r1 = 0
            r4 = 0
            com.facebook.ads.redexgen.X.3B r1 = r6.A04
            if (r1 != 0) goto L70
            r1 = 2
        La:
            switch(r1) {
                case 2: goto L72;
                case 3: goto L22;
                case 4: goto L2d;
                case 5: goto L1a;
                case 6: goto Le;
                case 7: goto L33;
                case 8: goto L66;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.1c r0 = (com.facebook.ads.redexgen.X.AbstractC00311c) r0
            android.os.Bundle r5 = r0.getSaveInstanceState()
            if (r5 == 0) goto L18
            r1 = 7
            goto La
        L18:
            r1 = 2
            goto La
        L1a:
            com.facebook.ads.redexgen.X.1c r0 = (com.facebook.ads.redexgen.X.AbstractC00311c) r0
            if (r0 == 0) goto L20
            r1 = 6
            goto La
        L20:
            r1 = 2
            goto La
        L22:
            com.facebook.ads.redexgen.X.8X r6 = (com.facebook.ads.redexgen.X.C8X) r6
            com.facebook.ads.redexgen.X.1d r1 = r6.A03
            if (r1 == 0) goto L2a
            r1 = 4
            goto La
        L2a:
            r1 = 8
            goto La
        L2d:
            com.facebook.ads.redexgen.X.8X r6 = (com.facebook.ads.redexgen.X.C8X) r6
            com.facebook.ads.redexgen.X.1d r0 = r6.A03
            r1 = 5
            goto La
        L33:
            com.facebook.ads.redexgen.X.8X r6 = (com.facebook.ads.redexgen.X.C8X) r6
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r3 = 17
            r2 = 7
            r1 = 99
            java.lang.String r1 = A09(r3, r2, r1)
            r4.putBundle(r1, r5)
            r3 = 0
            r2 = 11
            r1 = 100
            java.lang.String r2 = A09(r3, r2, r1)
            java.lang.String r1 = r6.A0D
            r4.putString(r2, r1)
            r3 = 11
            r2 = 6
            r1 = 101(0x65, float:1.42E-43)
            java.lang.String r2 = A09(r3, r2, r1)
            com.facebook.ads.AdSize r1 = r6.A0A
            r4.putSerializable(r2, r1)
            r1 = 2
            goto La
        L66:
            com.facebook.ads.redexgen.X.8X r6 = (com.facebook.ads.redexgen.X.C8X) r6
            com.facebook.ads.redexgen.X.3B r0 = r6.A04
            com.facebook.ads.redexgen.X.1F r0 = r0.A02
            com.facebook.ads.redexgen.X.1c r0 = (com.facebook.ads.redexgen.X.AbstractC00311c) r0
            r1 = 5
            goto La
        L70:
            r1 = 3
            goto La
        L72:
            android.os.Bundle r4 = (android.os.Bundle) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8X.getSaveInstanceState():android.os.Bundle");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isAdInvalidated() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.3B r0 = r2.A04
            if (r0 == 0) goto L1f
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            com.facebook.ads.redexgen.X.3B r0 = r2.A04
            boolean r0 = r0.A0J()
            if (r0 == 0) goto L17
            r0 = 3
            goto L7
        L17:
            r0 = 5
            goto L7
        L19:
            r1 = 1
            r0 = 4
            goto L7
        L1c:
            r1 = 0
            r0 = 4
            goto L7
        L1f:
            r0 = 3
            goto L7
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8X.isAdInvalidated():boolean");
    }

    public final boolean isAdLoaded() {
        return this.A09;
    }

    public final void loadAd() {
        A0E(null);
    }

    public final void loadAd(InstreamVideoAdView.InstreamVideoLoadAdConfig instreamVideoLoadAdConfig) {
        A0E(((H4) instreamVideoLoadAdConfig).A00());
    }

    @Deprecated
    public final void loadAdFromBid(String str) {
        A0E(str);
    }

    public final void setAdListener(@Nullable InstreamVideoAdListener instreamVideoAdListener) {
        this.A02 = instreamVideoAdListener;
    }

    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A07 = extraHints.getHints();
        this.A08 = extraHints.getMediationData();
    }

    public final void setIsAdLoaded(boolean z) {
        this.A09 = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0055, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean show() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            boolean r0 = r2.A09
            if (r0 == 0) goto L53
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L17;
                case 4: goto L21;
                case 5: goto L55;
                case 6: goto Lc;
                case 7: goto L37;
                case 8: goto L4b;
                case 9: goto L41;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            com.facebook.ads.redexgen.X.1d r0 = r2.A03
            if (r0 == 0) goto L14
            r0 = 7
            goto L8
        L14:
            r0 = 9
            goto L8
        L17:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            com.facebook.ads.redexgen.X.1d r0 = r2.A03
            if (r0 != 0) goto L1f
            r0 = 4
            goto L8
        L1f:
            r0 = 6
            goto L8
        L21:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            com.facebook.ads.redexgen.X.8P r0 = new com.facebook.ads.redexgen.X.8P
            r0.<init>()
            com.facebook.ads.redexgen.X.C0465If.A00(r0)
            r0 = 5
            goto L8
        L2d:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            com.facebook.ads.redexgen.X.3B r0 = r2.A04
            if (r0 != 0) goto L35
            r0 = 3
            goto L8
        L35:
            r0 = 6
            goto L8
        L37:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            com.facebook.ads.redexgen.X.1d r0 = r2.A03
            r0.A0E()
            r0 = 8
            goto L8
        L41:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            com.facebook.ads.redexgen.X.3B r0 = r2.A04
            r0.A0A()
            r0 = 8
            goto L8
        L4b:
            com.facebook.ads.redexgen.X.8X r2 = (com.facebook.ads.redexgen.X.C8X) r2
            r0 = 0
            r2.A09 = r0
            r1 = 1
            r0 = 5
            goto L8
        L53:
            r0 = 4
            goto L8
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8X.show():boolean");
    }
}
