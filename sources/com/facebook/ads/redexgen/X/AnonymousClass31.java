package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.AdSettings;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;

/* renamed from: com.facebook.ads.redexgen.X.31, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass31 {
    public int A00;

    @Nullable
    public RewardData A01;

    @Nullable
    public HI A02;

    @Nullable
    public String A03;

    @Nullable
    public String A04;
    public boolean A05;
    public final EnumC0457Hw A06;
    public final EnumC0458Hx A07;
    public final String A08;

    @Nullable
    public final EnumSet<CacheFlag> A09;
    public final int A0A;
    public final AdPlacementType A0B;

    public AnonymousClass31(String str, EnumC0458Hx enumC0458Hx, AdPlacementType adPlacementType, EnumC0457Hw enumC0457Hw, int i) {
        this(str, enumC0458Hx, adPlacementType, enumC0457Hw, i, EnumSet.of(CacheFlag.NONE));
    }

    public AnonymousClass31(String str, EnumC0458Hx enumC0458Hx, AdPlacementType adPlacementType, EnumC0457Hw enumC0457Hw, int i, @Nullable EnumSet<CacheFlag> enumSet) {
        this.A08 = str;
        this.A0B = adPlacementType;
        this.A06 = enumC0457Hw;
        this.A0A = i;
        this.A09 = enumSet;
        this.A07 = enumC0458Hx;
        this.A00 = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x003a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.internal.protocol.AdPlacementType A00() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.internal.protocol.AdPlacementType r0 = r3.A0B
            if (r0 == 0) goto L34
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L18;
                case 3: goto L36;
                case 4: goto L22;
                case 5: goto L1e;
                case 6: goto Lb;
                case 7: goto L2c;
                case 8: goto L30;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.31 r3 = (com.facebook.ads.redexgen.X.AnonymousClass31) r3
            com.facebook.ads.redexgen.X.Hw r1 = r3.A06
            com.facebook.ads.redexgen.X.Hw r0 = com.facebook.ads.redexgen.X.EnumC0457Hw.A07
            if (r1 != r0) goto L15
            r0 = 7
            goto L7
        L15:
            r0 = 8
            goto L7
        L18:
            com.facebook.ads.redexgen.X.31 r3 = (com.facebook.ads.redexgen.X.AnonymousClass31) r3
            com.facebook.ads.internal.protocol.AdPlacementType r2 = r3.A0B
            r0 = 3
            goto L7
        L1e:
            com.facebook.ads.internal.protocol.AdPlacementType r2 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE
            r0 = 3
            goto L7
        L22:
            com.facebook.ads.redexgen.X.31 r3 = (com.facebook.ads.redexgen.X.AnonymousClass31) r3
            com.facebook.ads.redexgen.X.Hw r0 = r3.A06
            if (r0 != 0) goto L2a
            r0 = 5
            goto L7
        L2a:
            r0 = 6
            goto L7
        L2c:
            com.facebook.ads.internal.protocol.AdPlacementType r2 = com.facebook.ads.internal.protocol.AdPlacementType.INTERSTITIAL
            r0 = 3
            goto L7
        L30:
            com.facebook.ads.internal.protocol.AdPlacementType r2 = com.facebook.ads.internal.protocol.AdPlacementType.BANNER
            r0 = 3
            goto L7
        L34:
            r0 = 4
            goto L7
        L36:
            com.facebook.ads.internal.protocol.AdPlacementType r2 = (com.facebook.ads.internal.protocol.AdPlacementType) r2
            com.facebook.ads.internal.protocol.AdPlacementType r2 = (com.facebook.ads.internal.protocol.AdPlacementType) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass31.A00():com.facebook.ads.internal.protocol.AdPlacementType");
    }

    public final IH A01(C0362Ec c0362Ec, I2 i2) {
        C0494Jj c0494Jj;
        String str = this.A08;
        if (this.A06 != null) {
            c0494Jj = new C0494Jj(this.A06.getHeight(), this.A06.getWidth());
        } else {
            c0494Jj = null;
        }
        return new IH(c0362Ec, str, c0494Jj, this.A07, AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT ? AdSettings.getTestAdType().getAdTypeString() : null, this.A0A, AdSettings.isTestMode(c0362Ec), AdSettings.isChildDirected() || AdSettings.isMixedAudience(), i2, C0504Ju.A01(C0413Gc.A0E(c0362Ec)), this.A03);
    }

    public final void A02(int i) {
        this.A00 = i;
    }

    public final void A03(@Nullable RewardData rewardData) {
        this.A01 = rewardData;
    }

    public final void A04(@Nullable HI hi) {
        this.A02 = hi;
    }

    public final void A05(@Nullable String str) {
        this.A03 = str;
    }

    public final void A06(@Nullable String str) {
        this.A04 = str;
    }

    public final void A07(boolean z) {
        this.A05 = z;
    }
}
