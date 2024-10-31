package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import com.facebook.ads.AdSettings;

/* loaded from: assets/audience_network.dex */
public final class GI implements InterfaceC0367Eh {
    public static GI A04;
    public static byte[] A05;
    public InterfaceC00110i A00;
    public InterfaceC0366Eg A01;
    public GJ A02;

    @Nullable
    public InterfaceC01234q A03;

    static {
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.GI.A05
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
            r0 = r0 ^ 51
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GI.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A05 = new byte[]{122, 39, 124, 122, 44, 39, 125, 116, 66, 84, 84, 78, 72, 73, 7, 67, 70, 83, 70, 7, 78, 73, 78, 83, 78, 70, 75, 78, 93, 66, 67, 125, 106, Byte.MAX_VALUE, 96, 125, 123, 92, 106, 124, 124, 102, 96, 97, 75, 110, 123, 110, 70, 97, 102, 123, 102, 110, 99, 102, 117, 106, 107};
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0027, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C9U A00(com.facebook.ads.redexgen.X.C0365Ef r2, @android.support.annotation.Nullable com.facebook.ads.redexgen.X.InterfaceC01234q r3) {
        /*
            r1 = 0
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0q(r2)
            if (r0 == 0) goto L23
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L14;
                case 4: goto L25;
                case 5: goto L17;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.4q r3 = (com.facebook.ads.redexgen.X.InterfaceC01234q) r3
            if (r3 != 0) goto L12
            r0 = 3
            goto L8
        L12:
            r0 = 5
            goto L8
        L14:
            r1 = 0
            r0 = 4
            goto L8
        L17:
            com.facebook.ads.redexgen.X.4q r3 = (com.facebook.ads.redexgen.X.InterfaceC01234q) r3
            com.facebook.ads.redexgen.X.9V r0 = com.facebook.ads.redexgen.X.C9V.A00()
            com.facebook.ads.redexgen.X.9U r1 = r0.A01(r3)
            r0 = 4
            goto L8
        L23:
            r0 = 3
            goto L8
        L25:
            com.facebook.ads.redexgen.X.9U r1 = (com.facebook.ads.redexgen.X.C9U) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GI.A00(com.facebook.ads.redexgen.X.Ef, com.facebook.ads.redexgen.X.4q):com.facebook.ads.redexgen.X.9U");
    }

    public static synchronized GI A01() {
        GI gi;
        synchronized (GI.class) {
            if (A04 == null) {
                A04 = new GI();
            }
            gi = A04;
        }
        return gi;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.FM A02(com.facebook.ads.redexgen.X.C0365Ef r2) {
        /*
            r1 = 0
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0o(r2)
            if (r0 != 0) goto L17
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L19;
                case 4: goto Lf;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = 0
            r0 = 3
            goto L8
        Lf:
            com.facebook.ads.redexgen.X.Ef r2 = (com.facebook.ads.redexgen.X.C0365Ef) r2
            com.facebook.ads.redexgen.X.FM r1 = com.facebook.ads.redexgen.X.C7A.A05(r2)
            r0 = 3
            goto L8
        L17:
            r0 = 4
            goto L8
        L19:
            com.facebook.ads.redexgen.X.FM r1 = (com.facebook.ads.redexgen.X.FM) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GI.A02(com.facebook.ads.redexgen.X.Ef):com.facebook.ads.redexgen.X.FM");
    }

    @Nullable
    public static InterfaceC01234q A03(C0365Ef c0365Ef, @Nullable FM fm) {
        if (!C0413Gc.A1C(c0365Ef) || fm == null) {
            return null;
        }
        return AbstractC01224p.A00().A01(fm, IW.A04(c0365Ef), new GH(new IH(c0365Ef, A04(7, 0, 87), null, EnumC0458Hx.A08, AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT ? AdSettings.getTestAdType().getAdTypeString() : null, 0, AdSettings.isTestMode(c0365Ef), AdSettings.isMixedAudience(), new I2(), C0504Ju.A01(C0413Gc.A0E(c0365Ef)), null), c0365Ef), C01264t.A00().A00());
    }

    public static void A06() {
        I5.A05(A04(31, 28, 60), A04(7, 24, 20), A04(0, 7, 44));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A07(com.facebook.ads.redexgen.X.C0365Ef r1, @android.support.annotation.Nullable com.facebook.ads.redexgen.X.C9U r2) {
        /*
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0q(r1)
            if (r0 == 0) goto L20
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L22;
                case 4: goto L13;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.9U r2 = (com.facebook.ads.redexgen.X.C9U) r2
            if (r2 != 0) goto L11
            r0 = 3
            goto L7
        L11:
            r0 = 4
            goto L7
        L13:
            com.facebook.ads.redexgen.X.Ef r1 = (com.facebook.ads.redexgen.X.C0365Ef) r1
            com.facebook.ads.redexgen.X.9U r2 = (com.facebook.ads.redexgen.X.C9U) r2
            com.facebook.ads.redexgen.X.9N r0 = com.facebook.ads.redexgen.X.C9N.A00()
            r0.A01(r2, r1)
            r0 = 3
            goto L7
        L20:
            r0 = 3
            goto L7
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GI.A07(com.facebook.ads.redexgen.X.Ef, com.facebook.ads.redexgen.X.9U):void");
    }

    @Nullable
    public final synchronized InterfaceC01234q A08() {
        return this.A03;
    }

    public final synchronized void A09(C0365Ef c0365Ef) {
        if (this.A03 == null) {
            this.A03 = A03(c0365Ef, A02(c0365Ef));
            A07(c0365Ef, A00(c0365Ef, this.A03));
            if (this.A03 != null) {
                this.A03.A4A();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0367Eh
    public final InterfaceC0422Gl A4F(C0365Ef c0365Ef) {
        return C0425Go.A01(c0365Ef);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0367Eh
    public final synchronized InterfaceC0366Eg A4N(C0361Eb c0361Eb) {
        if (this.A01 == null) {
            this.A01 = new GE(this);
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0367Eh
    public final synchronized InterfaceC0515Kf A4Y(C0361Eb c0361Eb) {
        return new C0516Kg(c0361Eb);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0367Eh
    public final synchronized InterfaceC0368Ei A4b(C0361Eb c0361Eb) {
        return new GC(this, c0361Eb);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0367Eh
    @Nullable
    public final synchronized InterfaceC00110i A4h(C0361Eb c0361Eb) {
        InterfaceC00110i interfaceC00110i;
        if (C0413Gc.A0a(c0361Eb)) {
            if (this.A00 == null) {
                this.A00 = AbstractC00120j.A00().A01(new GF(this, c0361Eb));
            }
            interfaceC00110i = this.A00;
        } else {
            interfaceC00110i = null;
        }
        return interfaceC00110i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0367Eh
    public final synchronized InterfaceC0369Ej A4s(C0361Eb c0361Eb) {
        return new GD(this, c0361Eb);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0367Eh
    public final synchronized GJ A4v() {
        if (this.A02 == null) {
            this.A02 = new GJ();
            A06();
        }
        return this.A02;
    }
}
