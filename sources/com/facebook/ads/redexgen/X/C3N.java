package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.3N, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3N implements AnonymousClass34 {
    public static byte[] A0E;
    public C3K A00;
    public C0402Fq A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final Handler A05;

    @Nullable
    public final AdSize A06;
    public final C1K A07;
    public final C0362Ec A08;
    public final InterfaceC0422Gl A09;
    public final EnumC0458Hx A0A;
    public final IQ A0B;
    public final Runnable A0C;
    public final String A0D;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C3N.A0E
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
            r0 = r0 ^ 43
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3N.A03(int, int, int):java.lang.String");
    }

    public static void A05() {
        A0E = new byte[]{92, 93, 18, 66, 94, 83, 81, 87, 95, 87, 92, 70, 18, 91, 92, 18, 64, 87, 65, 66, 93, 92, 65, 87, 26, 27, 24, 23, 16, 23, 10, 23, 17, 16, 13, 8, 29, 8};
    }

    static {
        A05();
        KG.A02();
    }

    public C3N(C0362Ec c0362Ec, String str, EnumC0458Hx enumC0458Hx, @Nullable AdSize adSize, int i) {
        this.A08 = c0362Ec;
        this.A0D = str;
        this.A0A = enumC0458Hx;
        this.A06 = adSize;
        this.A04 = i;
        this.A0B = new IQ(this.A08);
        this.A0B.A0V(this);
        this.A07 = new C1K();
        this.A03 = true;
        this.A05 = new Handler();
        this.A0C = new C3L<C3N>(this) { // from class: com.facebook.ads.redexgen.X.3M
            {
                super(this);
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A05() {
                /*
                    r5 = this;
                    r0 = 0
                    java.lang.Object r4 = r5.A06()
                    com.facebook.ads.redexgen.X.3N r4 = (com.facebook.ads.redexgen.X.C3N) r4
                    if (r4 != 0) goto L36
                    r0 = 2
                La:
                    switch(r0) {
                        case 2: goto L38;
                        case 3: goto L26;
                        case 4: goto Le;
                        case 5: goto L15;
                        default: goto Ld;
                    }
                Ld:
                    goto La
                Le:
                    com.facebook.ads.redexgen.X.3N r4 = (com.facebook.ads.redexgen.X.C3N) r4
                    r4.A07()
                    r0 = 2
                    goto La
                L15:
                    com.facebook.ads.redexgen.X.3N r4 = (com.facebook.ads.redexgen.X.C3N) r4
                    android.os.Handler r3 = com.facebook.ads.redexgen.X.C3N.A00(r4)
                    java.lang.Runnable r2 = com.facebook.ads.redexgen.X.C3N.A02(r4)
                    r0 = 5000(0x1388, double:2.4703E-320)
                    r3.postDelayed(r2, r0)
                    r0 = 2
                    goto La
                L26:
                    com.facebook.ads.redexgen.X.3N r4 = (com.facebook.ads.redexgen.X.C3N) r4
                    com.facebook.ads.redexgen.X.Ec r0 = com.facebook.ads.redexgen.X.C3N.A01(r4)
                    boolean r0 = com.facebook.ads.redexgen.X.C0519Kj.A02(r0)
                    if (r0 == 0) goto L34
                    r0 = 4
                    goto La
                L34:
                    r0 = 5
                    goto La
                L36:
                    r0 = 3
                    goto La
                L38:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3M.A05():void");
            }
        };
        this.A09 = c0362Ec.A05();
        DynamicLoaderFactory.makeLoader(this.A08).getInitApi().onAdLoadInvoked(this.A08);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0090, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.facebook.ads.redexgen.X.C00371i> A04() {
        /*
            r13 = this;
            r5 = r13
            r0 = 0
            r0 = 0
            r0 = 0
            r6 = 0
            com.facebook.ads.redexgen.X.Fq r4 = r5.A01
            com.facebook.ads.redexgen.X.Fo r3 = r4.A04()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r0 = r4.A02()
            r2.<init>(r0)
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto L74;
                case 3: goto L7c;
                case 4: goto L66;
                case 5: goto L21;
                case 6: goto L19;
                case 7: goto L8c;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            com.facebook.ads.redexgen.X.Fq r4 = (com.facebook.ads.redexgen.X.C0402Fq) r4
            com.facebook.ads.redexgen.X.Fo r3 = r4.A04()
            r0 = 2
            goto L15
        L21:
            com.facebook.ads.redexgen.X.3N r5 = (com.facebook.ads.redexgen.X.C3N) r5
            com.facebook.ads.redexgen.X.Fq r4 = (com.facebook.ads.redexgen.X.C0402Fq) r4
            com.facebook.ads.redexgen.X.Fo r3 = (com.facebook.ads.redexgen.X.C0400Fo) r3
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            com.facebook.ads.redexgen.X.1F r6 = (com.facebook.ads.redexgen.X.C1F) r6
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r7 = 34
            r1 = 4
            r0 = 66
            java.lang.String r1 = A03(r7, r1, r0)
            org.json.JSONObject r0 = r3.A05()
            r11.put(r1, r0)
            r7 = 24
            r1 = 10
            r0 = 85
            java.lang.String r1 = A03(r7, r1, r0)
            com.facebook.ads.redexgen.X.Fr r0 = r4.A05()
            r11.put(r1, r0)
            r7 = r6
            com.facebook.ads.redexgen.X.1i r7 = (com.facebook.ads.redexgen.X.C00371i) r7
            com.facebook.ads.redexgen.X.Ec r8 = r5.A08
            com.facebook.ads.redexgen.X.3J r9 = new com.facebook.ads.redexgen.X.3J
            r9.<init>()
            com.facebook.ads.redexgen.X.Gl r10 = r5.A09
            com.facebook.ads.redexgen.X.HQ r12 = com.facebook.ads.redexgen.X.HX.A0I()
            r7.A0W(r8, r9, r10, r11, r12)
            r0 = 6
            goto L15
        L66:
            com.facebook.ads.redexgen.X.1F r6 = (com.facebook.ads.redexgen.X.C1F) r6
            com.facebook.ads.internal.protocol.AdPlacementType r1 = r6.A4p()
            com.facebook.ads.internal.protocol.AdPlacementType r0 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE
            if (r1 != r0) goto L72
            r0 = 5
            goto L15
        L72:
            r0 = 6
            goto L15
        L74:
            com.facebook.ads.redexgen.X.Fo r3 = (com.facebook.ads.redexgen.X.C0400Fo) r3
            if (r3 == 0) goto L7a
            r0 = 3
            goto L15
        L7a:
            r0 = 7
            goto L15
        L7c:
            com.facebook.ads.redexgen.X.3N r5 = (com.facebook.ads.redexgen.X.C3N) r5
            com.facebook.ads.redexgen.X.1K r1 = r5.A07
            com.facebook.ads.internal.protocol.AdPlacementType r0 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE
            com.facebook.ads.redexgen.X.1F r6 = r1.A00(r0)
            if (r6 == 0) goto L8a
            r0 = 4
            goto L15
        L8a:
            r0 = 6
            goto L15
        L8c:
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.util.List r2 = (java.util.List) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3N.A04():java.util.List");
    }

    public final void A06() {
        this.A03 = false;
        this.A05.removeCallbacks(this.A0C);
    }

    public final void A07() {
        C0494Jj c0494Jj;
        try {
            I2 i2 = new I2(this.A08, null, null, null);
            C0362Ec c0362Ec = this.A08;
            String str = this.A0D;
            if (this.A06 != null) {
                c0494Jj = new C0494Jj(this.A06.getHeight(), this.A06.getWidth());
            } else {
                c0494Jj = null;
            }
            this.A0B.A0U(new IH(c0362Ec, str, c0494Jj, this.A0A, null, this.A04, AdSettings.isTestMode(this.A08), AdSettings.isChildDirected() || AdSettings.isMixedAudience(), i2, C0504Ju.A01(C0413Gc.A0E(this.A08)), this.A02));
        } catch (C0454Hs e) {
            A6Y(C0453Hr.A03(e));
        }
    }

    public final void A08(C3K c3k) {
        this.A00 = c3k;
    }

    public final void A09(String str) {
        this.A02 = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0A() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Fq r0 = r2.A01
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
            com.facebook.ads.redexgen.X.3N r2 = (com.facebook.ads.redexgen.X.C3N) r2
            com.facebook.ads.redexgen.X.Fq r0 = r2.A01
            boolean r0 = r0.A0A()
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3N.A0A():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass34
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A6Y(com.facebook.ads.redexgen.X.C0453Hr r6) {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = r4.A03
            if (r0 == 0) goto L2d
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L18;
                case 4: goto L22;
                case 5: goto L2f;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.3N r4 = (com.facebook.ads.redexgen.X.C3N) r4
            android.os.Handler r3 = r4.A05
            java.lang.Runnable r2 = r4.A0C
            r0 = 1800000(0x1b7740, double:8.89318E-318)
            r3.postDelayed(r2, r0)
            r0 = 3
            goto L6
        L18:
            com.facebook.ads.redexgen.X.3N r4 = (com.facebook.ads.redexgen.X.C3N) r4
            com.facebook.ads.redexgen.X.3K r0 = r4.A00
            if (r0 == 0) goto L20
            r0 = 4
            goto L6
        L20:
            r0 = 5
            goto L6
        L22:
            com.facebook.ads.redexgen.X.3N r4 = (com.facebook.ads.redexgen.X.C3N) r4
            com.facebook.ads.redexgen.X.Hr r6 = (com.facebook.ads.redexgen.X.C0453Hr) r6
            com.facebook.ads.redexgen.X.3K r0 = r4.A00
            r0.A6Y(r6)
            r0 = 5
            goto L6
        L2d:
            r0 = 3
            goto L6
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3N.A6Y(com.facebook.ads.redexgen.X.Hr):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000c. Please report as an issue. */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass34
    public final void A7Y(IU iu) {
        C3N c3n = this;
        List<C00371i> list = null;
        long j = 0;
        C0402Fq A00 = iu.A00();
        char c = A00 == null ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A03(0, 24, 25));
                case 3:
                    c3n = c3n;
                    c = c3n.A03 ? (char) 4 : (char) 7;
                case 4:
                    A00 = A00;
                    j = A00.A05().A0A();
                    c = j == 0 ? (char) 5 : (char) 6;
                case 5:
                    j = 1800000;
                    c = 6;
                case 6:
                    c3n = c3n;
                    c3n.A05.postDelayed(c3n.A0C, j);
                    c = 7;
                case 7:
                    c3n = c3n;
                    A00 = A00;
                    c3n.A01 = A00;
                    list = c3n.A04();
                    c = c3n.A00 != null ? '\b' : '\n';
                case '\b':
                    list = list;
                    c = list.isEmpty() ? '\t' : (char) 11;
                case '\t':
                    c3n = c3n;
                    c3n.A00.A6Y(C0453Hr.A02(AdErrorType.NO_FILL, A03(34, 0, 86)));
                    c = '\n';
                case '\n':
                    return;
                case 11:
                    c3n = c3n;
                    list = list;
                    c3n.A00.A79(list);
                    c = '\n';
            }
        }
    }
}
