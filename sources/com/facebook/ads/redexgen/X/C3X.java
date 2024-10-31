package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Locale;
import java.util.UUID;

/* renamed from: com.facebook.ads.redexgen.X.3X, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C3X implements C3W {
    public static byte[] A05;
    public final C3S A00;
    public final C0362Ec A01;
    public final String A02 = UUID.randomUUID().toString();
    public final Handler A03;
    public final InterfaceC00963p A04;

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C3X.A05
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
            r0 = r0 ^ 56
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3X.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A05 = new byte[]{0, 7, 29, 22, 12, 27, 27, 6, 27, 22, 10, 6, 13, 12, 22, 2, 12, 16, 48, 39, 60, 54, 62, 55, 45, 55, 42, 38, 32, 51, 33, 45, 57, 55, 43, 64, 71, 65, 76, 86, 65, 65, 92, 65, 76, 94, 86, 64, 64, 82, 84, 86, 76, 88, 86, 74, 92, 91, 93, 80, 78, 75, 80, 70, 75, 80, 68, 74, 86};
    }

    public abstract void A04();

    public C3X(final C0362Ec c0362Ec, InterfaceC00913k interfaceC00913k) {
        this.A01 = c0362Ec;
        DynamicLoaderFactory.makeLoader(this.A01).getInitApi().onAdLoadInvoked(this.A01);
        this.A00 = new C3S(c0362Ec, this) { // from class: com.facebook.ads.redexgen.X.3T
            public static byte[] A04;
            public C3Y A00 = C3Y.A02;
            public C3Y A01 = C3Y.A02;
            public final C3X A02;
            public final C0362Ec A03;

            static {
                A01();
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static java.lang.String A00(int r2, int r3, int r4) {
                /*
                    r0 = 0
                    r0 = 0
                    byte[] r1 = com.facebook.ads.redexgen.X.C3T.A04
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
                    int r0 = r0 + (-17)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3T.A00(int, int, int):java.lang.String");
            }

            public static void A01() {
                A04 = new byte[]{-18, -15, -29, -26, -86, -85, -99, -110, -103, -95, 82, 83, 107, -105, -108, -110, 69, -62, -66, -67, -15, -32, -27, -31, -22, -33, -31, -54, -31, -16, -13, -21, -18, -25, -65, -50, -57, -114, Byte.MIN_VALUE, -71, -49, -43, Byte.MIN_VALUE, -61, -63, -50, Byte.MIN_VALUE, -61, -56, -63, -50, -57, -59, Byte.MIN_VALUE, -87, -50, -44, -59, -57, -46, -63, -44, -55, -49, -50, Byte.MIN_VALUE, -91, -46, -46, -49, -46, Byte.MIN_VALUE, -51, -49, -60, -59, Byte.MIN_VALUE, -62, -39, Byte.MIN_VALUE, -45, -59, -44, -44, -55, -50, -57, Byte.MIN_VALUE, -95, -60, -77, -59, -44, -44, -55, -50, -57, -45, -114, -45, -59, -44, -87, -50, -44, -59, -57, -46, -63, -44, -55, -49, -50, -91, -46, -46, -49, -46, -83, -49, -60, -59, -120, -119, -16, -28, -35, -16, -100, -27, -17, -100, -22, -21, -16, -100, -56, -53, -67, -64, -63, -64, -38, -50, -57, -38, -122, -49, -39, -122, -57, -46, -40, -53, -57, -54, -33, -122, -71, -82, -75, -67, -81, -76, -83, 99, -73, -78, 99, -12, -24, -31, -12, -96, -23, -13, -96, -31, -20, -14, -27, -31, -28, -7, -96, -52, -49, -63, -60, -55, -50, -57, -84, -96, -52, -49, -63, -60, -59, -60, -96, -17, -14, -96, -45, -56, -49, -41, -55, -50, -57, -67, -40, -43, -44, -51, -122, -49, -44, -38, -53, -40, -44, -57, -46, -122, -38, -40, -57, -44, -39, -49, -38, -49, -43, -44, -108};
            }

            {
                this.A03 = c0362Ec;
                this.A02 = this;
            }

            private void A02(C3Y c3y, C3Y c3y2) {
                String A00 = A00(211, 26, 85);
                String str = A00(12, 5, 20) + c3y + A00(165, 4, 50) + c3y2;
                C0511Kb.A06(this.A03, A00(34, 3, 77), C0512Kc.A0S, new C0514Ke(A00, str));
                this.A03.A08().A8q(A00 + ' ' + str);
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0021. Please report as an issue. */
            private void A03(String str, String str2, boolean z) {
                C3T c3t = this;
                AdSettings.IntegrationErrorMode A00 = C3C.A00(c3t.A03);
                String format = String.format(Locale.US, AdErrorType.INCORRECT_API_CALL_ERROR.getDefaultErrorMessage(), str, str2);
                char c = !z ? (char) 2 : (char) 4;
                while (true) {
                    switch (c) {
                        case 2:
                            c3t = c3t;
                            format = format;
                            Log.e(A00(17, 17, 107), format);
                            C0511Kb.A06(c3t.A03, A00(34, 3, 77), C0512Kc.A0Q, new C0514Ke(format));
                            c3t.A03.A08().A8p(format);
                            c = 3;
                        case 3:
                            return;
                        case 4:
                            A00 = A00;
                            switch (C3R.A00[A00.ordinal()]) {
                                case 1:
                                    c = 7;
                                    break;
                                case 2:
                                    c = 6;
                                    break;
                                default:
                                    c = 5;
                                    break;
                            }
                        case 5:
                            format = format;
                            Log.e(A00(17, 17, 107), format);
                            c = 3;
                        case 6:
                            c3t = c3t;
                            format = format;
                            c3t.A02.A04();
                            c3t.A02.A05(10, AdErrorType.INCORRECT_STATE_ERROR, format);
                            c3t.A03.A08().A8p(format);
                            Log.e(A00(17, 17, 107), format);
                            C0511Kb.A06(c3t.A03, A00(34, 3, 77), C0512Kc.A0Q, new C0514Ke(format));
                            c = 5;
                        case 7:
                            throw new C3Z(format + A00(37, 87, 79));
                    }
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:57:0x0069, code lost:            return r6;     */
            @Override // com.facebook.ads.redexgen.X.C3S
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A45() {
                /*
                    r8 = this;
                    r5 = r8
                    r0 = 0
                    r7 = 0
                    r0 = 0
                    r6 = 1
                    r4 = 0
                    com.facebook.ads.redexgen.X.3Y r1 = r5.A00
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A02
                    if (r1 == r0) goto L67
                    r0 = 2
                Ld:
                    switch(r0) {
                        case 2: goto L52;
                        case 3: goto L45;
                        case 4: goto L42;
                        case 5: goto L21;
                        case 6: goto L11;
                        case 7: goto L19;
                        case 8: goto L69;
                        case 9: goto L63;
                        case 10: goto L28;
                        case 11: goto L5f;
                        default: goto L10;
                    }
                L10:
                    goto Ld
                L11:
                    com.facebook.ads.redexgen.X.3T r5 = (com.facebook.ads.redexgen.X.C3T) r5
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A06
                    r5.A00 = r0
                    r0 = 7
                    goto Ld
                L19:
                    if (r7 != 0) goto L1e
                    r0 = 8
                    goto Ld
                L1e:
                    r0 = 9
                    goto Ld
                L21:
                    if (r7 == 0) goto L25
                    r0 = 6
                    goto Ld
                L25:
                    r0 = 10
                    goto Ld
                L28:
                    com.facebook.ads.redexgen.X.3T r5 = (com.facebook.ads.redexgen.X.C3T) r5
                    r4 = 0
                    r2 = 0
                    r1 = 6
                    r0 = 113(0x71, float:1.58E-43)
                    java.lang.String r3 = A00(r2, r1, r0)
                    r2 = 169(0xa9, float:2.37E-43)
                    r1 = 42
                    r0 = 111(0x6f, float:1.56E-43)
                    java.lang.String r0 = A00(r2, r1, r0)
                    r5.A03(r3, r0, r4)
                    r0 = 7
                    goto Ld
                L42:
                    r7 = r6
                    r0 = 5
                    goto Ld
                L45:
                    com.facebook.ads.redexgen.X.3T r5 = (com.facebook.ads.redexgen.X.C3T) r5
                    com.facebook.ads.redexgen.X.3Y r1 = r5.A01
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A07
                    if (r1 == r0) goto L4f
                    r0 = 4
                    goto Ld
                L4f:
                    r0 = 11
                    goto Ld
                L52:
                    com.facebook.ads.redexgen.X.3T r5 = (com.facebook.ads.redexgen.X.C3T) r5
                    com.facebook.ads.redexgen.X.3Y r1 = r5.A00
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A04
                    if (r1 != r0) goto L5c
                    r0 = 3
                    goto Ld
                L5c:
                    r0 = 11
                    goto Ld
                L5f:
                    r4 = 0
                    r7 = r4
                    r0 = 5
                    goto Ld
                L63:
                    r6 = r4
                    r0 = 8
                    goto Ld
                L67:
                    r0 = 3
                    goto Ld
                L69:
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3T.A45():boolean");
            }

            /* JADX WARN: Code restructure failed: missing block: B:69:0x0098, code lost:            return r5;     */
            @Override // com.facebook.ads.redexgen.X.C3S
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A46() {
                /*
                    r8 = this;
                    r6 = r8
                    r0 = 0
                    r7 = 0
                    r0 = 0
                    r5 = 1
                    r4 = 0
                    com.facebook.ads.redexgen.X.3Y r1 = r6.A00
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A05
                    if (r1 != r0) goto L94
                    r0 = 2
                Ld:
                    switch(r0) {
                        case 2: goto L3d;
                        case 3: goto L11;
                        case 4: goto L20;
                        case 5: goto L49;
                        case 6: goto L31;
                        case 7: goto L50;
                        case 8: goto L98;
                        case 9: goto L5c;
                        case 10: goto L23;
                        case 11: goto L60;
                        case 12: goto L79;
                        case 13: goto L58;
                        default: goto L10;
                    }
                L10:
                    goto Ld
                L11:
                    com.facebook.ads.redexgen.X.3T r6 = (com.facebook.ads.redexgen.X.C3T) r6
                    com.facebook.ads.redexgen.X.Ec r0 = r6.A03
                    boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0U(r0)
                    if (r0 == 0) goto L1d
                    r0 = 4
                    goto Ld
                L1d:
                    r0 = 13
                    goto Ld
                L20:
                    r7 = r5
                    r0 = 5
                    goto Ld
                L23:
                    com.facebook.ads.redexgen.X.3T r6 = (com.facebook.ads.redexgen.X.C3T) r6
                    com.facebook.ads.redexgen.X.3Y r1 = r6.A00
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A05
                    if (r1 == r0) goto L2e
                    r0 = 11
                    goto Ld
                L2e:
                    r0 = 12
                    goto Ld
                L31:
                    com.facebook.ads.redexgen.X.3T r6 = (com.facebook.ads.redexgen.X.C3T) r6
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A02
                    r6.A00 = r0
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A07
                    r6.A01 = r0
                    r0 = 7
                    goto Ld
                L3d:
                    com.facebook.ads.redexgen.X.3T r6 = (com.facebook.ads.redexgen.X.C3T) r6
                    com.facebook.ads.redexgen.X.3Y r1 = r6.A01
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A07
                    if (r1 != r0) goto L47
                    r0 = 3
                    goto Ld
                L47:
                    r0 = 4
                    goto Ld
                L49:
                    if (r7 == 0) goto L4d
                    r0 = 6
                    goto Ld
                L4d:
                    r0 = 10
                    goto Ld
                L50:
                    if (r7 != 0) goto L55
                    r0 = 8
                    goto Ld
                L55:
                    r0 = 9
                    goto Ld
                L58:
                    r4 = 0
                    r7 = r4
                    r0 = 5
                    goto Ld
                L5c:
                    r5 = r4
                    r0 = 8
                    goto Ld
                L60:
                    com.facebook.ads.redexgen.X.3T r6 = (com.facebook.ads.redexgen.X.C3T) r6
                    r2 = 6
                    r1 = 6
                    r0 = 25
                    java.lang.String r3 = A00(r2, r1, r0)
                    r2 = 124(0x7c, float:1.74E-43)
                    r1 = 18
                    r0 = 107(0x6b, float:1.5E-43)
                    java.lang.String r0 = A00(r2, r1, r0)
                    r6.A03(r3, r0, r5)
                    r0 = 7
                    goto Ld
                L79:
                    com.facebook.ads.redexgen.X.3T r6 = (com.facebook.ads.redexgen.X.C3T) r6
                    r4 = 0
                    r2 = 6
                    r1 = 6
                    r0 = 25
                    java.lang.String r3 = A00(r2, r1, r0)
                    r2 = 142(0x8e, float:1.99E-43)
                    r1 = 23
                    r0 = 85
                    java.lang.String r0 = A00(r2, r1, r0)
                    r6.A03(r3, r0, r4)
                    r0 = 7
                    goto Ld
                L94:
                    r0 = 13
                    goto Ld
                L98:
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3T.A46():boolean");
            }

            @Override // com.facebook.ads.redexgen.X.C3S
            public final C3Y A4G() {
                return this.A00;
            }

            @Override // com.facebook.ads.redexgen.X.C3S
            public final void A8F(C3Y c3y) {
                this.A00 = c3y;
                this.A01 = c3y;
            }

            @Override // com.facebook.ads.redexgen.X.C3S
            public final void A8G(AdError adError) {
                this.A00 = C3Y.A04;
                this.A01 = C3Y.A04;
            }

            @Override // com.facebook.ads.redexgen.X.C3S
            public final void A8I() {
                if (this.A00 != C3Y.A06) {
                    A02(this.A00, C3Y.A05);
                }
                this.A00 = C3Y.A05;
            }

            @Override // com.facebook.ads.redexgen.X.C3S
            public final void A8L() {
                if (this.A01 != C3Y.A07) {
                    A02(this.A00, C3Y.A08);
                }
                this.A01 = C3Y.A08;
            }
        };
        this.A03 = new Handler(Looper.getMainLooper());
        this.A04 = interfaceC00913k.A3m(this.A00, this);
    }

    public final void A03() {
        if (!C0413Gc.A0Y(this.A01)) {
            return;
        }
        K7.A00(new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.3V
            public static byte[] A01;

            static {
                A04();
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public static java.lang.String A01(int r2, int r3, int r4) {
                /*
                    r0 = 0
                    r0 = 0
                    byte[] r1 = com.facebook.ads.redexgen.X.C3V.A01
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
                    int r0 = r0 + (-45)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3V.A01(int, int, int):java.lang.String");
            }

            public static void A04() {
                A01 = new byte[]{115, 111, 110, -94, -111, -106, -110, -101, -112, -110, 123, -110, -95, -92, -100, -97, -104, -57, -42, -49, -70, -48, -42, -127, -59, -54, -59, -49, -120, -43, -127, -60, -62, -51, -51, -127, -59, -58, -44, -43, -45, -48, -38, -119, -118, -127, -57, -48, -45, -127, -94, -59, -127, -80, -61, -53, -58, -60, -43, -113, -127, -75, -55, -54, -44, -127, -50, -62, -38, -127, -51, -58, -62, -59, -127, -43, -48, -127, -51, -58, -62, -52, -54, -49, -56, -127, -50, -58, -50, -48, -45, -38, -113, -127, -79, -51, -58, -62, -44, -58, -115, -127, -62, -51, -40, -62, -38, -44, -127, -60, -62, -51, -51, -127, -59, -58, -44, -43, -45, -48, -38, -119, -118, -127, -40, -55, -58, -49, -127, -38, -48, -42, -127, -59, -48, -49, -120, -43, -127, -49, -58, -58, -59, -127, -43, -55, -54, -44, -127, -94, -59, -127, -80, -61, -53, -58, -60, -43, -127, -62, -49, -38, -127, -50, -48, -45, -58, -113, -24, 9, 23, 24, 22, 19, 29, -60, 27, 5, 23, -60, 18, 19, 24, -60, 7, 5, 16, 16, 9, 8, -46};
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A05() {
                /*
                    r8 = this;
                    r4 = r8
                    com.facebook.ads.redexgen.X.3X r0 = com.facebook.ads.redexgen.X.C3X.this
                    com.facebook.ads.redexgen.X.Ec r0 = r0.A01
                    com.facebook.ads.redexgen.X.0c r0 = r0.A08()
                    r0.A2i()
                    com.facebook.ads.redexgen.X.3X r0 = com.facebook.ads.redexgen.X.C3X.this
                    com.facebook.ads.redexgen.X.3S r0 = r0.A00
                    com.facebook.ads.redexgen.X.3Y r1 = r0.A4G()
                    com.facebook.ads.redexgen.X.3Y r0 = com.facebook.ads.redexgen.X.C3Y.A03
                    if (r1 != r0) goto L6a
                    r0 = 2
                L19:
                    switch(r0) {
                        case 2: goto L6c;
                        case 3: goto L60;
                        case 4: goto L1d;
                        case 5: goto L42;
                        default: goto L1c;
                    }
                L1c:
                    goto L19
                L1d:
                    com.facebook.ads.redexgen.X.3V r4 = (com.facebook.ads.redexgen.X.C3V) r4
                    com.facebook.ads.redexgen.X.3X r0 = com.facebook.ads.redexgen.X.C3X.this
                    com.facebook.ads.redexgen.X.Ec r7 = r0.A01
                    r2 = 17
                    r1 = 3
                    r0 = 57
                    java.lang.String r6 = A01(r2, r1, r0)
                    int r5 = com.facebook.ads.redexgen.X.C0512Kc.A0N
                    com.facebook.ads.redexgen.X.Ke r3 = new com.facebook.ads.redexgen.X.Ke
                    r2 = 168(0xa8, float:2.35E-43)
                    r1 = 23
                    r0 = 119(0x77, float:1.67E-43)
                    java.lang.String r0 = A01(r2, r1, r0)
                    r3.<init>(r0)
                    com.facebook.ads.redexgen.X.C0511Kb.A07(r7, r6, r5, r3)
                    r0 = 5
                    goto L19
                L42:
                    com.facebook.ads.redexgen.X.3V r4 = (com.facebook.ads.redexgen.X.C3V) r4
                    r2 = 0
                    r1 = 17
                    r0 = 0
                    java.lang.String r3 = A01(r2, r1, r0)
                    r2 = 20
                    r1 = 148(0x94, float:2.07E-43)
                    r0 = 52
                    java.lang.String r0 = A01(r2, r1, r0)
                    android.util.Log.e(r3, r0)
                    com.facebook.ads.redexgen.X.3X r0 = com.facebook.ads.redexgen.X.C3X.this
                    r0.A04()
                    r0 = 2
                    goto L19
                L60:
                    boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
                    if (r0 != 0) goto L68
                    r0 = 4
                    goto L19
                L68:
                    r0 = 5
                    goto L19
                L6a:
                    r0 = 3
                    goto L19
                L6c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3V.A05():void");
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:            r3 = r5;        r4 = r4;        r4.putInt(A01(0, 18, 113), r7.getErrorCode());        r3.A75(r6, r3.A02, r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A05(int r6, com.facebook.ads.internal.protocol.AdErrorType r7, @android.support.annotation.Nullable java.lang.String r8) {
        /*
            r5 = this;
            r0 = 0
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r8 == 0) goto L37
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L39;
                case 4: goto L20;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            java.lang.String r8 = (java.lang.String) r8
            android.os.Bundle r4 = (android.os.Bundle) r4
            r2 = 35
            r1 = 21
            r0 = 43
            java.lang.String r0 = A01(r2, r1, r0)
            r4.putString(r0, r8)
            r0 = 3
            goto L9
        L20:
            com.facebook.ads.internal.protocol.AdErrorType r7 = (com.facebook.ads.internal.protocol.AdErrorType) r7
            android.os.Bundle r4 = (android.os.Bundle) r4
            r2 = 35
            r1 = 21
            r0 = 43
            java.lang.String r1 = A01(r2, r1, r0)
            java.lang.String r0 = r7.getDefaultErrorMessage()
            r4.putString(r1, r0)
            r0 = 3
            goto L9
        L37:
            r0 = 4
            goto L9
        L39:
            r3 = r5
            com.facebook.ads.redexgen.X.3X r3 = (com.facebook.ads.redexgen.X.C3X) r3
            com.facebook.ads.internal.protocol.AdErrorType r7 = (com.facebook.ads.internal.protocol.AdErrorType) r7
            android.os.Bundle r4 = (android.os.Bundle) r4
            r2 = 0
            r1 = 18
            r0 = 113(0x71, float:1.58E-43)
            java.lang.String r1 = A01(r2, r1, r0)
            int r0 = r7.getErrorCode()
            r4.putInt(r1, r0)
            java.lang.String r0 = r3.A02
            r3.A75(r6, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3X.A05(int, com.facebook.ads.internal.protocol.AdErrorType, java.lang.String):void");
    }

    @Override // com.facebook.ads.redexgen.X.C3W
    public final void A75(int i, String str, @Nullable Bundle bundle) {
        final Message obtain = Message.obtain((Handler) null, i);
        obtain.getData().putString(A01(56, 13, 55), str);
        if (bundle != null) {
            obtain.getData().putBundle(A01(18, 17, 74), bundle);
        }
        this.A03.post(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.3U
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InterfaceC00963p interfaceC00963p;
                interfaceC00963p = C3X.this.A04;
                interfaceC00963p.A54(obtain);
            }
        });
    }
}
