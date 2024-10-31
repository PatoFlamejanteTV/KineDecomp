package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import android.util.SparseIntArray;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.Kb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0511Kb {

    @VisibleForTesting
    public static SparseIntArray A00;

    @VisibleForTesting
    public static Executor A01;
    public static boolean A02;
    public static boolean A03;
    public static byte[] A04;
    public static final List<Integer> A05;
    public static final List<C0513Kd> A06;
    public static final AtomicBoolean A07;
    public static final AtomicInteger A08;
    public static final AtomicReference<G9> A09;
    public static final AtomicReference<G7> A0A;
    public static final AtomicReference<Boolean> A0B;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0511Kb.A04
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
            int r0 = r0 + (-29)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0511Kb.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A04 = new byte[]{-72, -74, -72, -67, -70, -111, -78, -81, -62, -76, 109, -80, -65, -82, -64, -75, 109, -81, -78, -80, -82, -62, -64, -78, 109, -68, -77, 109, -78, -61, -78, -69, -63, 109, -60, -74, -63, -75, 109, -64, -62, -81, -63, -58, -67, -78, 109, -118, 109, -108, -112, -113, -61, -78, -73, -77, -68, -79, -77, -100, -77, -62, -59, -67, -64, -71, -119, -89, -76, 109, -70, 102, -78, -75, -83, 102, -118, -85, -88, -69, -83, 102, -117, -68, -85, -76, -70, 116, 102, -119, -75, -76, -70, -85, -66, -70, 102, -81, -71, 102, -76, -69, -78, -78, 116, 75, 63, -110, -108, -127, -109, -104, -113, -124, 98, -114, -125, -124, 63, 92, 63, -104, -103, -109, -96, -93, -101, -101, -99, -94, -101, -113, -62, -83, -81, -81, -82, -81, -82, 106, -77, -72, 119, -73, -81, -73, -71, -68, -61, 106, -74, -71, -79, 106, -74, -77, -73, -77, -66, 107, 106, -106, -85, -67, -66, 106, -81, -64, -81, -72, -66, -124, 106, -113, -98, -105, -105, -114, -107, -112, -61, -82, -80, -69, -65, -76, -70, -71, 107, -113, -80, -83, -64, -78, 107, -112, -63, -80, -71, -65, 107, -62, -76, -65, -77, 107, -66, -64, -83, -65, -60, -69, -80, 107, -120, 107, -126, -99, -99, 78, -101, -113, -100, -89, 78, -109, -92, -109, -100, -94, -95, 78, -99, -108, 78, -95, -93, -112, -94, -89, -98, -109, 78, -111, -99, -110, -109, 104, 78, -85, -48, -56, -47, -126, -90, -57, -60, -41, -55, -126, -89, -40, -57, -48, -42, -126, -39, -53, -42, -54, -126, -43, -41, -60, -42, -37, -46, -57, -126, -97, -126, -58, -70, 7, -1, 13, 13, -5, 1, -1, -70, -41, -70, -34, -43, -28, -25, -33, -30, -37, -46, -43, 8, -13, -11, 0, 4, -7, -1, -2, -80, -12, 5, 2, -7, -2, -9, -80, -4, -1, -9, -9, -7, -2, -9, -80, -12, -11, -14, 5, -9, -80, -11, 6, -11, -2, 4, -66, -76, -32, -26, -33, -27, -42, -29, -85, -111, -36, -34, -39, -34, -37, -18, -37, -39, -26, -23, -31, -31, -29, -24, -31, 117, -88, -109, -107, -96, -92, -103, -97, -98, 80, -93, -104, -97, -91, -100, -108, 80, -98, -97, -92, 80, -104, -111, -96, -96, -107, -98, 80, -104, -107, -94, -107, 94, -36, -23, -18, -39, -34, -33, -18, -33, -35, -18, -29, -23, -24, -39, -15, -23, -39, -19, -29, -31, -24, -37, -26, -39, -34, -37, -18, -37, -39, -26, -23, -31, -31, -29, -24, -31, 97, 85, -106, -103, -103, -98, -87, -98, -92, -93, -106, -95, 126, -93, -101, -92, 85, 114, 85};
    }

    static {
        A04();
        A00 = new SparseIntArray();
        A03 = false;
        A0A = new AtomicReference<>();
        A09 = new AtomicReference<>();
        A01 = Executors.newSingleThreadExecutor();
        A05 = Arrays.asList(10, 50, 100, 1000);
        A06 = Collections.synchronizedList(new ArrayList());
        A08 = new AtomicInteger();
        A07 = new AtomicBoolean();
        A0B = new AtomicReference<>();
        A02 = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0088, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(java.lang.String r4, int r5, com.facebook.ads.redexgen.X.C0361Eb r6) {
        /*
            r0 = 0
            r3 = 200(0xc8, float:2.8E-43)
            r2 = 293(0x125, float:4.1E-43)
            r1 = 7
            r0 = 83
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L86
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L5b;
                case 3: goto L88;
                case 4: goto L47;
                case 5: goto L32;
                case 6: goto L17;
                case 7: goto L2e;
                case 8: goto L63;
                case 9: goto L7b;
                case 10: goto L83;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            java.lang.String r4 = (java.lang.String) r4
            r2 = 395(0x18b, float:5.54E-43)
            r1 = 36
            r0 = 93
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L2b
            r0 = 7
            goto L13
        L2b:
            r0 = 8
            goto L13
        L2e:
            r3 = 50
            r0 = 3
            goto L13
        L32:
            java.lang.String r4 = (java.lang.String) r4
            r2 = 173(0xad, float:2.42E-43)
            r1 = 6
            r0 = 12
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L45
            r0 = 6
            goto L13
        L45:
            r0 = 3
            goto L13
        L47:
            java.lang.String r4 = (java.lang.String) r4
            r2 = 0
            r1 = 5
            r0 = 56
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L59
            r0 = 5
            goto L13
        L59:
            r0 = 3
            goto L13
        L5b:
            int r0 = com.facebook.ads.redexgen.X.C0512Kc.A1R
            if (r0 != r5) goto L61
            r0 = 3
            goto L13
        L61:
            r0 = 4
            goto L13
        L63:
            java.lang.String r4 = (java.lang.String) r4
            r2 = 347(0x15b, float:4.86E-43)
            r1 = 15
            r0 = 93
            java.lang.String r0 = A01(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L78
            r0 = 9
            goto L13
        L78:
            r0 = 10
            goto L13
        L7b:
            com.facebook.ads.redexgen.X.Eb r6 = (com.facebook.ads.redexgen.X.C0361Eb) r6
            int r3 = com.facebook.ads.redexgen.X.C0414Gd.A05(r6)
            r0 = 3
            goto L13
        L83:
            r3 = -1
            r0 = 3
            goto L13
        L86:
            r0 = 4
            goto L13
        L88:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0511Kb.A00(java.lang.String, int, com.facebook.ads.redexgen.X.Eb):int");
    }

    public static void A05(C0361Eb c0361Eb, int i, int i2) {
        A06(c0361Eb, A01(121, 10, 23), C0512Kc.A1j, new C0514Ke(A01(216, 33, 17) + i, A01(338, 9, 84) + i2));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0007. Please report as an issue. */
    public static void A06(@Nullable C0361Eb c0361Eb, String str, int i, C0514Ke c0514Ke) {
        String str2 = str;
        C0361Eb c0361Eb2 = c0361Eb;
        C0514Ke c0514Ke2 = c0514Ke;
        char c = c0361Eb2 == null ? (char) 2 : (char) 4;
        while (true) {
            switch (c) {
                case 2:
                    A0G(new RuntimeException(A01(66, 39, 41)));
                    return;
                case 4:
                    c0361Eb2 = c0361Eb2;
                    C0363Ed.A01(c0361Eb2.A00());
                    c = A02 ? (char) 5 : (char) 7;
                case 5:
                    c0514Ke2 = c0514Ke2;
                    c = c0514Ke2.A00() == 0 ? (char) 6 : (char) 7;
                case 6:
                    str2 = str2;
                    c0514Ke2 = c0514Ke2;
                    A0D(new RuntimeException(A01(5, 44, 48) + str2 + A01(105, 16, 2) + i, c0514Ke2));
                    c = 7;
                case 7:
                    try {
                        if (A0I(c0361Eb2, str2, i, Math.random(), c0514Ke2)) {
                            A09(c0361Eb2, str2, i, c0514Ke2);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        A0G(th);
                        return;
                    }
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0003. Please report as an issue. */
    @SuppressLint({"CatchGeneralException"})
    public static void A07(C0361Eb c0361Eb, String str, int i, C0514Ke c0514Ke) {
        C0514Ke c0514Ke2;
        char c = 2;
        while (true) {
            switch (c) {
                case 2:
                    try {
                        c0514Ke = c0514Ke;
                        c0514Ke.A03(2);
                        c0514Ke.A07(false);
                        c0514Ke.A04(1);
                        c = C0414Gd.A0P(c0361Eb) ? (char) 7 : '\t';
                    } catch (Throwable th) {
                        A0G(th);
                        return;
                    }
                case 7:
                    c0514Ke2 = c0514Ke;
                    c0514Ke2.A06(true);
                    break;
                case '\t':
                    c0514Ke2 = c0514Ke;
                    c0514Ke2.A06(false);
                    break;
            }
        }
        A06(c0361Eb, str, i, c0514Ke2);
    }

    public static void A08(C0361Eb c0361Eb, String str, int i, C0514Ke c0514Ke) {
        try {
            c0514Ke.A03(2);
            c0514Ke.A06(false);
            A06(c0361Eb, str, i, c0514Ke);
        } catch (Throwable th) {
            A0G(th);
        }
    }

    public static void A09(C0361Eb c0361Eb, String str, int i, C0514Ke c0514Ke) {
        synchronized (C0511Kb.class) {
            if (!A03) {
                int A012 = C0414Gd.A01(c0361Eb);
                if (A08.getAndIncrement() < A012 - 1) {
                    A06.add(new C0513Kd(str, i, c0514Ke));
                } else if (A08.get() == A012) {
                    A06.add(new C0513Kd(A01(121, 10, 23), C0512Kc.A1g, new C0514Ke(A01(131, 42, 45) + str + A01(300, 1, 123) + i)));
                }
            } else {
                A0A(c0361Eb, str, i, c0514Ke, true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0129, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0A(com.facebook.ads.redexgen.X.C0361Eb r10, java.lang.String r11, int r12, com.facebook.ads.redexgen.X.C0514Ke r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0511Kb.A0A(com.facebook.ads.redexgen.X.Eb, java.lang.String, int, com.facebook.ads.redexgen.X.Ke, boolean):void");
    }

    public static void A0C(C0365Ef c0365Ef, G7 g7, G9 g9, boolean z) {
        A09.set(g9);
        A0A.set(g7);
        A07.set(z);
        synchronized (C0511Kb.class) {
            if (!A03) {
                A03 = true;
                A01.execute(new KY(c0365Ef));
            }
        }
    }

    public static void A0D(RuntimeException runtimeException) {
        if (A02) {
            new Handler(Looper.getMainLooper()).post(new KZ(runtimeException));
        }
    }

    public static void A0E(String str, int i, C0514Ke c0514Ke) {
        C0365Ef A002 = C0363Ed.A00();
        if (A002 != null) {
            A06(A002, str, i, c0514Ke);
        }
    }

    public static void A0F(Throwable th) {
        if (A02) {
            A0D(new RuntimeException(A01(362, 33, 19), th));
        }
    }

    public static void A0G(Throwable th) {
        Log.e(A01(49, 17, 49), A01(301, 37, 115), th);
        if (A02) {
            A0D(new RuntimeException(th));
        }
    }

    @VisibleForTesting
    @SuppressLint({"CatchGeneralException"})
    public static boolean A0I(C0361Eb c0361Eb, String str, int i, double d, C0514Ke c0514Ke) {
        double d2;
        int cacheEventsSampling;
        try {
            int A042 = C0414Gd.A04(c0361Eb);
            if (A042 < 1) {
                return false;
            }
            HashMap<String, Integer> A0L = C0414Gd.A0L(c0361Eb);
            Set<String> keySet = A0L.keySet();
            String eventKey = str + A01(300, 1, 123) + i;
            boolean contains = keySet.contains(eventKey);
            if (contains) {
                Integer tempSampling = A0L.get(eventKey);
                int sampling = tempSampling != null ? tempSampling.intValue() : -1;
                if (sampling == 0) {
                    return false;
                }
                if (sampling > 0) {
                    return d <= 1.0d / ((double) sampling);
                }
                if (C0414Gd.A03(c0361Eb) < 1) {
                    return false;
                }
                d2 = (A042 * r1) / 10000.0d;
            } else if (!c0514Ke.A08()) {
                d2 = 0.0d;
            } else {
                d2 = A042 / 100.0d;
            }
            double funnelEventLogProbability = c0361Eb.A04().A00();
            if (A01(0, 5, 56).equals(str)) {
                if (BuildConfigApi.isDebug()) {
                    return true;
                }
                int cacheEventsSampling2 = C0414Gd.A06(c0361Eb);
                if (cacheEventsSampling2 == 0) {
                    return false;
                }
                if (cacheEventsSampling2 > 0) {
                    double d3 = 1.0d / cacheEventsSampling2;
                    return contains ? funnelEventLogProbability <= d3 * d2 : funnelEventLogProbability <= d3;
                }
            }
            if (A01(293, 7, 83).equals(str) && C0512Kc.A1R == i) {
                if (!A07.get()) {
                    cacheEventsSampling = C0414Gd.A0D(c0361Eb);
                } else {
                    cacheEventsSampling = 1;
                }
                if (cacheEventsSampling == 0) {
                    return false;
                }
                if (cacheEventsSampling > 0) {
                    double networkEventLogProbability = 1.0d / cacheEventsSampling;
                    return contains ? funnelEventLogProbability <= networkEventLogProbability * d2 : funnelEventLogProbability <= networkEventLogProbability;
                }
            }
            if (A01(173, 6, 12).equals(str)) {
                Boolean bool = A0B.get();
                if (bool != null) {
                    return bool.booleanValue();
                }
                int funnelEventsSampling = C0414Gd.A0A(c0361Eb);
                if (funnelEventsSampling == 0) {
                    A0B.set(false);
                    return false;
                }
                if (funnelEventsSampling > 0) {
                    double d4 = 1.0d / funnelEventsSampling;
                    return contains ? funnelEventLogProbability <= d4 * d2 : funnelEventLogProbability <= d4;
                }
            }
            return d >= 1.0d - d2;
        } catch (Throwable t) {
            A0G(t);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0087, code lost:            return r5;     */
    @android.support.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0J(com.facebook.ads.redexgen.X.C0361Eb r6, java.lang.String r7, int r8, com.facebook.ads.redexgen.X.C0514Ke r9) {
        /*
            r3 = 0
            r4 = 0
            r0 = 0
            r2 = 0
            r5 = 1
            boolean r0 = com.facebook.ads.redexgen.X.C0414Gd.A0O(r6)
            if (r0 != 0) goto L85
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L87;
                case 3: goto L30;
                case 4: goto L28;
                case 5: goto L21;
                case 6: goto L10;
                case 7: goto L53;
                case 8: goto L61;
                case 9: goto L4a;
                case 10: goto L69;
                case 11: goto L78;
                case 12: goto L7b;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            java.util.List<java.lang.Integer> r1 = com.facebook.ads.redexgen.X.C0511Kb.A05
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L1e
            r0 = 7
            goto Lc
        L1e:
            r0 = 9
            goto Lc
        L21:
            if (r4 < r2) goto L25
            r0 = 6
            goto Lc
        L25:
            r0 = 12
            goto Lc
        L28:
            com.facebook.ads.redexgen.X.Ke r9 = (com.facebook.ads.redexgen.X.C0514Ke) r9
            int r2 = r9.A01()
            r0 = 5
            goto Lc
        L30:
            com.facebook.ads.redexgen.X.Eb r6 = (com.facebook.ads.redexgen.X.C0361Eb) r6
            com.facebook.ads.redexgen.X.Ke r9 = (com.facebook.ads.redexgen.X.C0514Ke) r9
            android.util.SparseIntArray r0 = com.facebook.ads.redexgen.X.C0511Kb.A00
            int r4 = r0.get(r8)
            int r2 = com.facebook.ads.redexgen.X.C0414Gd.A00(r6)
            int r1 = r9.A01()
            r0 = -1
            if (r1 == r0) goto L47
            r0 = 4
            goto Lc
        L47:
            r0 = 10
            goto Lc
        L4a:
            android.util.SparseIntArray r1 = com.facebook.ads.redexgen.X.C0511Kb.A00
            int r0 = r4 + 1
            r1.put(r8, r0)
            r0 = 2
            goto Lc
        L53:
            com.facebook.ads.redexgen.X.Ke r9 = (com.facebook.ads.redexgen.X.C0514Ke) r9
            boolean r0 = r9.A09()
            if (r0 != 0) goto L5e
            r0 = 8
            goto Lc
        L5e:
            r0 = 9
            goto Lc
        L61:
            com.facebook.ads.redexgen.X.Eb r6 = (com.facebook.ads.redexgen.X.C0361Eb) r6
            A05(r6, r8, r4)
            r0 = 9
            goto Lc
        L69:
            com.facebook.ads.redexgen.X.Eb r6 = (com.facebook.ads.redexgen.X.C0361Eb) r6
            java.lang.String r7 = (java.lang.String) r7
            int r3 = A00(r7, r8, r6)
            if (r2 >= r3) goto L76
            r0 = 11
            goto Lc
        L76:
            r0 = 5
            goto Lc
        L78:
            r2 = r3
            r0 = 5
            goto Lc
        L7b:
            android.util.SparseIntArray r1 = com.facebook.ads.redexgen.X.C0511Kb.A00
            int r0 = r4 + 1
            r1.put(r8, r0)
            r5 = 0
            r0 = 2
            goto Lc
        L85:
            r0 = 3
            goto Lc
        L87:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0511Kb.A0J(com.facebook.ads.redexgen.X.Eb, java.lang.String, int, com.facebook.ads.redexgen.X.Ke):boolean");
    }
}
