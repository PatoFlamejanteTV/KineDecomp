package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public final class G2 {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static final AtomicBoolean A03;
    public static final AtomicBoolean A04;
    public static final AtomicBoolean A05;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.G2.A02
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
            int r0 = r0 + (-7)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G2.A02(int, int, int):java.lang.String");
    }

    public static void A04() {
        A02 = new byte[]{-55, -59, -60, -8, -25, -20, -24, -15, -26, -24, -47, -24, -9, -6, -14, -11, -18, -116, -122, -115, -122, -118, -120, -70, -56, -41, -48, 122, Byte.MAX_VALUE, 122, -123, 122, 114, 125, 122, -117, 118, -60, -38, -32, -117, -49, -38, -39, -110, -33, -117, -50, -52, -41, -41, -117, -84, -32, -49, -44, -48, -39, -50, -48, -71, -48, -33, -30, -38, -35, -42, -84, -49, -34, -103, -44, -39, -44, -33, -44, -52, -41, -44, -27, -48, -109, -108, -103, -117, -66, -38, -40, -48, -117, -47, -32, -39, -50, -33, -44, -38, -39, -52, -41, -44, -33, -28, -117, -40, -52, -28, -117, -39, -38, -33, -117, -30, -38, -35, -42, -117, -37, -35, -38, -37, -48, -35, -41, -28, -103, -127, -122, -127, -116, -127, 121, -124, -127, -110, 125, 64, 65, 56, -122, -121, -116, 56, 123, 121, -124, -124, 125, 124, 70, 119, 117, 126, 117, -126, 121, 115, -123, 118, 125, 82, -101, -96, -101, -90, -101, -109, -98, -101, -84, -109, -90, -101, -95, -96, 82, -91, -90, -109, -92, -90, -105, -106, -80, -63, -56, 125, -44, -66, -48, 125, -66, -55, -49, -62, -66, -63, -42, 125, -58, -53, -58, -47, -58, -66, -55, -58, -41, -62, -63, 126, 125, -80, -56, -58, -51, -51, -58, -53, -60, -117};
    }

    static {
        A04();
        A05 = new AtomicBoolean();
        A03 = new AtomicBoolean();
        A04 = new AtomicBoolean();
    }

    public static InterfaceC0408Fx A00() {
        return new C0409Fy();
    }

    public static InterfaceC0410Fz A01(C0365Ef c0365Ef) {
        return new G0(c0365Ef);
    }

    public static void A05(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        K7.A01.execute(new C0407Fw(initListener, initResult));
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A07(C0365Ef c0365Ef) {
        if (C0414Gd.A0O(c0365Ef) && !A04.getAndSet(true)) {
            try {
                F4 reportHandler = new F4(Thread.getDefaultUncaughtExceptionHandler(), c0365Ef, new G6());
                Thread.setDefaultUncaughtExceptionHandler(reportHandler);
            } catch (Exception e) {
                C0511Kb.A06(c0365Ef, A02(150, 7, 9), C0512Kc.A19, new C0514Ke(e));
            }
        }
    }

    public static void A08(C0365Ef c0365Ef) {
        A0G(c0365Ef, null, null, 3);
    }

    public static void A09(C0365Ef c0365Ef) {
        A0G(c0365Ef, null, null, 3);
    }

    public static void A0A(C0365Ef c0365Ef) {
        if (C0413Gc.A10(c0365Ef)) {
            A0F(c0365Ef, 0);
            A0C(c0365Ef);
        }
    }

    public static void A0B(C0365Ef c0365Ef) {
        if (C0413Gc.A11(c0365Ef)) {
            A0H(c0365Ef, null, null, 3);
        }
    }

    public static void A0C(C0365Ef c0365Ef) {
        KJ.A05.execute(new C0406Fv(c0365Ef));
    }

    public static void A0D(C0365Ef c0365Ef) {
        C0511Kb.A0C(c0365Ef, new G8(c0365Ef), new GA(), BuildConfigApi.isDebug());
        C0425Go.A01(c0365Ef);
        A0.A04(c0365Ef, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0F(com.facebook.ads.redexgen.X.C0365Ef r6, int r7) {
        /*
            com.facebook.ads.redexgen.X.C0363Ed.A01(r6)
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.ads.redexgen.X.G2.A03
            r0 = 1
            boolean r0 = r1.getAndSet(r0)
            if (r0 == 0) goto La0
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto La3;
                case 3: goto L50;
                case 4: goto L46;
                case 5: goto L41;
                case 6: goto L11;
                case 7: goto L67;
                case 8: goto L5a;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.Ef r6 = (com.facebook.ads.redexgen.X.C0365Ef) r6
            A07(r6)
            boolean r3 = com.facebook.ads.redexgen.X.C0413Gc.A0W(r6)
            boolean r2 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            com.facebook.ads.redexgen.X.Fx r1 = A00()
            com.facebook.ads.redexgen.X.Fz r0 = A01(r6)
            com.facebook.ads.redexgen.X.C0475Iq.A00(r3, r2, r1, r0)
            int r0 = com.facebook.ads.redexgen.X.C0413Gc.A02(r6)
            long r0 = (long) r0
            com.facebook.ads.redexgen.X.C02459p.A03(r0)
            com.facebook.ads.redexgen.X.G5 r0 = new com.facebook.ads.redexgen.X.G5
            r0.<init>(r6)
            com.facebook.ads.redexgen.X.C7A.A0E(r0)
            r0 = 3
            if (r7 != r0) goto L3e
            r0 = 7
            goto Ld
        L3e:
            r0 = 8
            goto Ld
        L41:
            com.facebook.ads.redexgen.X.I5.A02()
            r0 = 6
            goto Ld
        L46:
            boolean r0 = com.facebook.ads.internal.settings.AdInternalSettings.isDebuggerOn()
            if (r0 == 0) goto L4e
            r0 = 5
            goto Ld
        L4e:
            r0 = 6
            goto Ld
        L50:
            boolean r0 = com.facebook.ads.internal.settings.AdInternalSettings.isDebugBuild()
            if (r0 != 0) goto L58
            r0 = 4
            goto Ld
        L58:
            r0 = 5
            goto Ld
        L5a:
            com.facebook.ads.redexgen.X.Ef r6 = (com.facebook.ads.redexgen.X.C0365Ef) r6
            com.facebook.ads.redexgen.X.JJ.A03(r6)
            com.facebook.ads.redexgen.X.KJ.A05(r6)
            com.facebook.ads.redexgen.X.H1.A03(r6)
            r0 = 2
            goto Ld
        L67:
            com.facebook.ads.redexgen.X.Ef r6 = (com.facebook.ads.redexgen.X.C0365Ef) r6
            r2 = 0
            r1 = 17
            r0 = 124(0x7c, float:1.74E-43)
            java.lang.String r3 = A02(r2, r1, r0)
            r2 = 37
            r1 = 89
            r0 = 100
            java.lang.String r0 = A02(r2, r1, r0)
            android.util.Log.e(r3, r0)
            r2 = 24
            r1 = 3
            r0 = 96
            java.lang.String r5 = A02(r2, r1, r0)
            int r4 = com.facebook.ads.redexgen.X.C0512Kc.A0G
            com.facebook.ads.redexgen.X.Ke r3 = new com.facebook.ads.redexgen.X.Ke
            r2 = 126(0x7e, float:1.77E-43)
            r1 = 24
            r0 = 17
            java.lang.String r0 = A02(r2, r1, r0)
            r3.<init>(r0)
            com.facebook.ads.redexgen.X.C0511Kb.A07(r6, r5, r4, r3)
            r0 = 8
            goto Ld
        La0:
            r0 = 3
            goto Ld
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.G2.A0F(com.facebook.ads.redexgen.X.Ef, int):void");
    }

    public static void A0G(C0365Ef c0365Ef, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i) {
        I5.A05(A02(27, 10, 10), A02(157, 26, 43), A02(17, 7, 77));
        C7A.A0A();
        A0H(c0365Ef, multithreadedBundleWrapper, initListener, i);
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A0H(C0365Ef c0365Ef, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i) {
        C0363Ed.A01(c0365Ef);
        boolean z = false;
        synchronized (G2.class) {
            if (!A00) {
                if (i != 1 && i != 2) {
                    if (i == 3 && !A01) {
                        A01 = true;
                        z = true;
                    }
                }
                A00 = true;
                z = true;
            }
        }
        if (z) {
            A0F(c0365Ef, i);
            KJ.A07.execute(new C0405Fu(c0365Ef, multithreadedBundleWrapper, initListener));
        } else {
            if (i != 1) {
                return;
            }
            String A022 = A02(183, 38, 86);
            if (initListener != null) {
                A05(initListener, new G1(true, A022));
            } else {
                Log.w(A02(0, 17, 124), A022);
            }
        }
    }

    public static synchronized boolean A0I() {
        boolean z;
        synchronized (G2.class) {
            z = A00;
        }
        return z;
    }
}
