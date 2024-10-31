package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: assets/audience_network.dex */
public final class IQ {
    public static byte[] A09;
    public static final KH A0A;
    public static final Executor A0B;
    public IH A01;
    public AnonymousClass34 A02;
    public C0483Iy A03;

    @Nullable
    public String A04;
    public Map<String, String> A05;
    public final C0362Ec A06;
    public long A00 = -1;
    public final IR A07 = IR.A00();
    public final String A08 = IW.A00();

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0A(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.IQ.A09
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
            int r0 = r0 - r4
            int r0 = r0 + (-87)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IQ.A0A(int, int, int):java.lang.String");
    }

    public static void A0G() {
        A09 = new byte[]{-7, -6, -47, -12, -9, -9, -45, -6, -6, -10, -65, -32, -111, -73, -38, -35, -35, -111, -42, -29, -29, -32, -29, -111, -44, -32, -43, -42, -111, -52, -106, -28, -50, -111, -106, -28, -89, -44, -87, -39, -44, -39, -86, -41, -46, -4, -87, -37, -41, -61, -87, -49, -40, -43, -47, -38, -32, -21, -34, -47, -35, -31, -47, -33, -32, -21, -43, -48, 20, 21, -26, 12, 15, 18, 18, -26, 56, 43, 41, 43, 47, 60, 43, 42, -18, 15, -64, 14, 5, 20, 23, 15, 18, 11, -64, 3, 15, 14, 14, 5, 3, 20, 9, 15, 14, 40, 31, 46, 49, 41, 44, 37, -34, -17, -19, -23, -21, 16, 14, 23, 14, 27, 18, 12};
    }

    static {
        A0G();
        A0A = new KH();
        A0B = Executors.newCachedThreadPool(A0A);
    }

    public IQ(C0362Ec c0362Ec) {
        this.A06 = c0362Ec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IL A06(long j) {
        return new IM(this, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterfaceC0436Gz A08(long j) {
        return new IK(this, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F() {
        /*
            r6 = this;
            r5 = r6
            com.facebook.ads.redexgen.X.Ec r0 = r5.A06
            if (r0 == 0) goto L3e
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L40;
                case 4: goto L18;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.IQ r5 = (com.facebook.ads.redexgen.X.IQ) r5
            com.facebook.ads.redexgen.X.Ec r0 = r5.A06
            boolean r0 = com.facebook.ads.redexgen.X.C7A.A0G(r0)
            if (r0 != 0) goto L16
            r0 = 3
            goto L6
        L16:
            r0 = 4
            goto L6
        L18:
            com.facebook.ads.redexgen.X.IQ r5 = (com.facebook.ads.redexgen.X.IQ) r5
            com.facebook.ads.redexgen.X.Ke r4 = new com.facebook.ads.redexgen.X.Ke
            r2 = 112(0x70, float:1.57E-43)
            r1 = 5
            r0 = 70
            java.lang.String r0 = A0A(r2, r1, r0)
            r4.<init>(r0)
            r0 = 1
            r4.A03(r0)
            com.facebook.ads.redexgen.X.Ec r3 = r5.A06
            r2 = 105(0x69, float:1.47E-43)
            r1 = 7
            r0 = 99
            java.lang.String r1 = A0A(r2, r1, r0)
            int r0 = com.facebook.ads.redexgen.X.C0512Kc.A1Q
            com.facebook.ads.redexgen.X.C0511Kb.A06(r3, r1, r0, r4)
            r0 = 3
            goto L6
        L3e:
            r0 = 3
            goto L6
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IQ.A0F():void");
    }

    private void A0H(int i, String str) {
        I5.A05(A0A(0, 10, 52), A0A(68, 16, 111), A0A(36, 8, 28));
        I5.A04(A0A(0, 10, 52), String.format(Locale.US, A0A(10, 26, 26), Integer.valueOf(i), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I(C0453Hr c0453Hr) {
        if (this.A02 != null) {
            this.A02.A6Y(c0453Hr);
        }
        A0T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0J(C0453Hr c0453Hr) {
        K7.A00(new IO(this, c0453Hr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0P(IU iu) {
        if (this.A02 != null) {
            this.A02.A7Y(iu);
        }
        A0T();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0Q(com.facebook.ads.redexgen.X.IU r3) {
        /*
            r2 = this;
            r1 = 0
            com.facebook.ads.redexgen.X.IN r0 = new com.facebook.ads.redexgen.X.IN
            r0.<init>(r2, r3)
            com.facebook.ads.redexgen.X.K7.A00(r0)
            com.facebook.ads.redexgen.X.Ec r0 = r2.A06
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A14(r0)
            if (r0 == 0) goto L2b
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L16;
                case 3: goto L24;
                case 4: goto L2d;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.GI r0 = com.facebook.ads.redexgen.X.GI.A01()
            com.facebook.ads.redexgen.X.4q r1 = r0.A08()
            if (r1 == 0) goto L22
            r0 = 3
            goto L12
        L22:
            r0 = 4
            goto L12
        L24:
            com.facebook.ads.redexgen.X.4q r1 = (com.facebook.ads.redexgen.X.InterfaceC01234q) r1
            r1.A4A()
            r0 = 4
            goto L12
        L2b:
            r0 = 4
            goto L12
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IQ.A0Q(com.facebook.ads.redexgen.X.IU):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0R(String str, long j) {
        String str2;
        try {
            IT A06 = this.A07.A06(this.A06, str, j, this.A04);
            C0402Fq A00 = A06.A00();
            A0.A05(this.A06.A00(), str);
            if (A00 != null) {
                C0413Gc.A0I(this.A06).A1P(A00.A08());
                DynamicLoaderFactory.makeLoader(this.A06).getInitApi().maybeAttachCrashListener(this.A06);
                AnonymousClass43.A0O(this.A06.A00(), A00.A06());
                IG.A05(A00.A05().A0B(), this.A01);
                KW.A01(this.A06, A0B, A00);
                C0514Ke c0514Ke = new C0514Ke(A0A(44, 7, 50) + C0487Jc.A02());
                c0514Ke.A04(1);
                c0514Ke.A07(false);
                C0511Kb.A08(this.A06, A0A(117, 7, 82), C0512Kc.A18, c0514Ke);
            }
            switch (A06.A01()) {
                case A02:
                    IU iu = (IU) A06;
                    if (A00 != null) {
                        if (A00.A05().A0E()) {
                            IG.A07(str, this.A01);
                        }
                        if (this.A05 != null) {
                            str2 = this.A05.get(A0A(51, 17, 53));
                        } else {
                            str2 = null;
                        }
                        String clientChallenge = A06.A02();
                        if (!TextUtils.isEmpty(clientChallenge) && !TextUtils.isEmpty(str2)) {
                            C0362Ec c0362Ec = this.A06;
                            String clientChallenge2 = A06.A02();
                            new C0411Ga(c0362Ec, str2, clientChallenge2).A08();
                        }
                    }
                    this.A06.A08().A2k(K4.A01(this.A00));
                    A0Q(iu);
                    return;
                case A03:
                    IV iv = (IV) A06;
                    String A04 = iv.A04();
                    AdErrorType adErrorTypeFromCode = AdErrorType.adErrorTypeFromCode(iv.A03(), AdErrorType.ERROR_MESSAGE);
                    A0H(iv.A03(), A04);
                    if (A04 == null) {
                        A04 = str;
                    }
                    this.A06.A08().A2j(K4.A01(this.A00), adErrorTypeFromCode.getErrorCode(), A04, adErrorTypeFromCode.isPublicError());
                    A0J(C0453Hr.A02(adErrorTypeFromCode, A04));
                    return;
                default:
                    AdErrorType adErrorType = AdErrorType.UNKNOWN_RESPONSE;
                    this.A06.A08().A2j(K4.A01(this.A00), adErrorType.getErrorCode(), str, adErrorType.isPublicError());
                    A0J(C0453Hr.A02(adErrorType, str));
                    return;
            }
        } catch (Exception e) {
            String message = e.getMessage();
            AdErrorType adErrorType2 = AdErrorType.PARSER_FAILURE;
            this.A06.A08().A2j(K4.A01(this.A00), adErrorType2.getErrorCode(), message, adErrorType2.isPublicError());
            A0J(C0453Hr.A02(adErrorType2, message));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0S(String str, long j) {
        A0B.execute(new IJ(this, str, j));
    }

    public final void A0T() {
        if (this.A03 != null) {
            this.A03.A0N(1);
            this.A03.A0O(1);
            this.A03 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0U(com.facebook.ads.redexgen.X.IH r13) {
        /*
            r12 = this;
            r2 = r12
            r1 = 0
            r2.A0T()
            long r3 = java.lang.System.currentTimeMillis()
            r2.A00 = r3
            com.facebook.ads.redexgen.X.Ec r0 = r2.A06
            com.facebook.ads.redexgen.X.K0 r3 = com.facebook.ads.redexgen.X.K1.A00(r0)
            com.facebook.ads.redexgen.X.K0 r0 = com.facebook.ads.redexgen.X.K0.A07
            if (r3 != r0) goto Lb3
            r0 = 2
        L16:
            switch(r0) {
                case 2: goto L57;
                case 3: goto Lb6;
                case 4: goto L31;
                case 5: goto L25;
                case 6: goto L1a;
                case 7: goto L89;
                case 8: goto L47;
                default: goto L19;
            }
        L19:
            goto L16
        L1a:
            com.facebook.ads.redexgen.X.IQ r2 = (com.facebook.ads.redexgen.X.IQ) r2
            java.lang.String r1 = (java.lang.String) r1
            r3 = 0
            r2.A0S(r1, r3)
            r0 = 3
            goto L16
        L25:
            com.facebook.ads.redexgen.X.IH r13 = (com.facebook.ads.redexgen.X.IH) r13
            java.lang.String r1 = com.facebook.ads.redexgen.X.IG.A02(r13)
            if (r1 == 0) goto L2f
            r0 = 6
            goto L16
        L2f:
            r0 = 7
            goto L16
        L31:
            com.facebook.ads.redexgen.X.IQ r2 = (com.facebook.ads.redexgen.X.IQ) r2
            com.facebook.ads.redexgen.X.IH r13 = (com.facebook.ads.redexgen.X.IH) r13
            r2.A01 = r13
            com.facebook.ads.redexgen.X.Ec r0 = r2.A06
            com.facebook.ads.redexgen.X.C0398Fm.A0B(r0)
            boolean r0 = com.facebook.ads.redexgen.X.IG.A08(r13)
            if (r0 == 0) goto L44
            r0 = 5
            goto L16
        L44:
            r0 = 8
            goto L16
        L47:
            com.facebook.ads.redexgen.X.IQ r2 = (com.facebook.ads.redexgen.X.IQ) r2
            com.facebook.ads.redexgen.X.IH r13 = (com.facebook.ads.redexgen.X.IH) r13
            java.util.concurrent.Executor r3 = com.facebook.ads.redexgen.X.IQ.A0B
            com.facebook.ads.redexgen.X.II r0 = new com.facebook.ads.redexgen.X.II
            r0.<init>(r2, r13)
            r3.execute(r0)
            r0 = 3
            goto L16
        L57:
            com.facebook.ads.redexgen.X.IQ r2 = (com.facebook.ads.redexgen.X.IQ) r2
            r2.A0F()
            com.facebook.ads.internal.protocol.AdErrorType r5 = com.facebook.ads.internal.protocol.AdErrorType.NETWORK_ERROR
            r4 = 84
            r3 = 21
            r0 = 73
            java.lang.String r10 = A0A(r4, r3, r0)
            com.facebook.ads.redexgen.X.Ec r0 = r2.A06
            com.facebook.ads.redexgen.X.0c r6 = r0.A08()
            long r3 = r2.A00
            long r7 = com.facebook.ads.redexgen.X.K4.A01(r3)
            int r9 = r5.getErrorCode()
            boolean r11 = r5.isPublicError()
            r6.A2j(r7, r9, r10, r11)
            com.facebook.ads.redexgen.X.Hr r0 = new com.facebook.ads.redexgen.X.Hr
            r0.<init>(r5, r10)
            r2.A0J(r0)
            r0 = 3
            goto L16
        L89:
            com.facebook.ads.redexgen.X.IQ r2 = (com.facebook.ads.redexgen.X.IQ) r2
            com.facebook.ads.internal.protocol.AdErrorType r5 = com.facebook.ads.internal.protocol.AdErrorType.LOAD_TOO_FREQUENTLY
            com.facebook.ads.redexgen.X.Ec r0 = r2.A06
            com.facebook.ads.redexgen.X.0c r6 = r0.A08()
            long r3 = r2.A00
            long r7 = com.facebook.ads.redexgen.X.K4.A01(r3)
            int r9 = r5.getErrorCode()
            java.lang.String r10 = r5.getDefaultErrorMessage()
            boolean r11 = r5.isPublicError()
            r6.A2j(r7, r9, r10, r11)
            r0 = 0
            com.facebook.ads.redexgen.X.Hr r0 = com.facebook.ads.redexgen.X.C0453Hr.A02(r5, r0)
            r2.A0J(r0)
            r0 = 3
            goto L16
        Lb3:
            r0 = 4
            goto L16
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IQ.A0U(com.facebook.ads.redexgen.X.IH):void");
    }

    public final void A0V(AnonymousClass34 anonymousClass34) {
        this.A02 = anonymousClass34;
    }
}
