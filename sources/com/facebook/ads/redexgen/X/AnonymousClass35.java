package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"HardcodedIPAddressUse"})
/* renamed from: com.facebook.ads.redexgen.X.35, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class AnonymousClass35 implements AnonymousClass34 {
    public static byte[] A0D;
    public static final Handler A0E;
    public static final C1K A0F = null;

    @SuppressLint({"StaticFieldLeak"})
    public static final IQ A0G = null;
    public static final String A0H;
    public View A00;

    @Nullable
    public C1F A01;
    public C1F A02;
    public long A03 = -1;
    public C0402Fq A04;
    public IH A05;
    public C1G A06;
    public final AnonymousClass31 A07;
    public final InterfaceC0422Gl A08;
    public final C1K A09;
    public final IQ A0A;
    public final C0362Ec A0B;
    public volatile boolean A0C;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass35.A0D
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
            int r0 = r0 + (-74)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass35.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A0D = new byte[]{1, 10, 18, 5, 14, 11, 10, 9, 1, 10, 16, -68, 5, 15, -68, 1, 9, 12, 16, 21, -22, 11, -68, 9, 11, 14, 1, -68, -3, 0, -68, -1, -3, 10, 0, 5, 0, -3, 16, 1, 15, -54, 20, 21, 22, 25, 30, 25, 36, 25, 31, 30, -34, -37, -18, -37, -39, -25, -23, -34, -33, -26, -39, -18, -13, -22, -33, -25, -22, -36, -33, -38, -17, -28, -24, -32, -38, -24, -18, -26, -39, -27, -23, -39, -25, -24, -56, -35, -31, -39, -29, 6, 3, 18, 22, 7, 20, -62, 11, 21, -62, 16, 23, 14, 14, -62, 17, 16, -62, 21, 22, 3, 20, 22, -29, 6, -67, -52, -59, -31, -44, -32, -28, -44, -30, -29, -50, -40, -45, 2, 19, 14, 41, 38, 37, 30, -41, 24, 27, 24, 39, 43, 28, 41, -41, 43, 48, 39, 28, -27, -45, -42, -110, -45, -34, -28, -41, -45, -42, -21, -110, -27, -26, -45, -28, -26, -41, -42, -64, -67, -48, -67, -35, -8, 0, 3, -4, -5, -73, 11, 6, -73, 0, 5, 0, 11, 0, -8, 3, 0, 17, -4, -73, -38, 6, 6, 2, 0, -4, -28, -8, 5, -8, -2, -4, 9, -59, -117, -82, -85, -70, -66, -81, -68, 106, -82, -71, -81, -67, 106, -72, -71, -66, 106, -81, -62, -77, -67, -66, -124, 106, 47, 43, 32, 34, 36, 44, 36, 45, 51, 8, 35};
    }

    public abstract void A0K();

    public abstract void A0L(C1F c1f, C0402Fq c0402Fq, C0400Fo c0400Fo, Map<String, Object> map);

    static {
        A03();
        KG.A02();
        A0H = AnonymousClass35.class.getSimpleName();
        A0E = new Handler(Looper.getMainLooper());
    }

    public AnonymousClass35(C0362Ec c0362Ec, AnonymousClass31 anonymousClass31) {
        this.A0B = c0362Ec;
        this.A07 = anonymousClass31;
        if (A0G != null) {
            this.A0A = A0G;
        } else {
            this.A0A = new IQ(this.A0B);
        }
        this.A0A.A0V(this);
        if (A0F != null) {
            this.A09 = A0F;
        } else {
            this.A09 = new C1K();
        }
        try {
            CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(this.A0B);
            }
        } catch (Exception e) {
            Log.w(A0H, A01(172, 35, 77), e);
        }
        DynamicLoaderFactory.makeLoader(this.A0B).getInitApi().onAdLoadInvoked(this.A0B);
        this.A08 = c0362Ec.A05();
        this.A0B.A08().A3r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01bb, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A02() {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass35.A02():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long A05() {
        /*
            r4 = this;
            r3 = r4
            r1 = 0
            com.facebook.ads.redexgen.X.Fq r0 = r3.A04
            if (r0 == 0) goto L1a
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1c;
                case 4: goto L16;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.35 r3 = (com.facebook.ads.redexgen.X.AnonymousClass35) r3
            com.facebook.ads.redexgen.X.Fq r0 = r3.A04
            long r1 = r0.A03()
            r0 = 3
            goto L8
        L16:
            r1 = -1
            r0 = 3
            goto L8
        L1a:
            r0 = 4
            goto L8
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass35.A05():long");
    }

    public final Handler A06() {
        return A0E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.C0403Fr A07() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Fq r0 = r2.A04
            if (r0 != 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.35 r2 = (com.facebook.ads.redexgen.X.AnonymousClass35) r2
            com.facebook.ads.redexgen.X.Fq r0 = r2.A04
            com.facebook.ads.redexgen.X.Fr r1 = r0.A05()
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            com.facebook.ads.redexgen.X.Fr r1 = (com.facebook.ads.redexgen.X.C0403Fr) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass35.A07():com.facebook.ads.redexgen.X.Fr");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:            return r1;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String A08() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.1F r0 = r2.A02
            if (r0 != 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.35 r2 = (com.facebook.ads.redexgen.X.AnonymousClass35) r2
            com.facebook.ads.redexgen.X.1F r0 = r2.A02
            java.lang.String r1 = r0.A4V()
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass35.A08():java.lang.String");
    }

    public final void A09() {
        this.A0B.A08().A2e(K4.A01(this.A03));
        if (this.A02 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(A01(67, 12, 49), K4.A04(this.A03));
        new C0432Gv(this.A02.A4V(), this.A08).A02(EnumC0431Gu.A07, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00df, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0A() {
        /*
            r6 = this;
            r3 = r6
            com.facebook.ads.redexgen.X.1F r0 = r3.A02
            if (r0 != 0) goto Ldc
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L82;
                case 3: goto Ldf;
                case 4: goto L78;
                case 5: goto L30;
                case 6: goto La;
                case 7: goto Lcb;
                case 8: goto L1d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.35 r3 = (com.facebook.ads.redexgen.X.AnonymousClass35) r3
            com.facebook.ads.redexgen.X.1F r0 = r3.A02
            java.lang.String r0 = r0.A4V()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1a
            r0 = 7
            goto L6
        L1a:
            r0 = 8
            goto L6
        L1d:
            com.facebook.ads.redexgen.X.35 r3 = (com.facebook.ads.redexgen.X.AnonymousClass35) r3
            com.facebook.ads.redexgen.X.Ec r0 = r3.A0B
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A3w()
            r0 = 1
            r3.A0C = r0
            r3.A0K()
            r0 = 3
            goto L6
        L30:
            com.facebook.ads.redexgen.X.35 r3 = (com.facebook.ads.redexgen.X.AnonymousClass35) r3
            r2 = 150(0x96, float:2.1E-43)
            r1 = 18
            r0 = 40
            java.lang.String r5 = A01(r2, r1, r0)
            com.facebook.ads.redexgen.X.Ec r4 = r3.A0B
            r2 = 116(0x74, float:1.63E-43)
            r1 = 3
            r0 = 18
            java.lang.String r2 = A01(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A0C
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r5)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r4, r2, r1, r0)
            com.facebook.ads.internal.protocol.AdErrorType r2 = com.facebook.ads.internal.protocol.AdErrorType.AD_ALREADY_STARTED
            com.facebook.ads.redexgen.X.Ec r0 = r3.A0B
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            int r0 = r2.getErrorCode()
            r1.A3s(r0, r5)
            com.facebook.ads.redexgen.X.1G r1 = r3.A06
            java.lang.String r0 = r2.getDefaultErrorMessage()
            com.facebook.ads.redexgen.X.Hr r0 = com.facebook.ads.redexgen.X.C0453Hr.A02(r2, r0)
            r1.A0G(r0)
            com.facebook.ads.redexgen.X.Ec r0 = r3.A0B
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A3u()
            r0 = 3
            goto L6
        L78:
            com.facebook.ads.redexgen.X.35 r3 = (com.facebook.ads.redexgen.X.AnonymousClass35) r3
            boolean r0 = r3.A0C
            if (r0 == 0) goto L80
            r0 = 5
            goto L6
        L80:
            r0 = 6
            goto L6
        L82:
            com.facebook.ads.redexgen.X.35 r3 = (com.facebook.ads.redexgen.X.AnonymousClass35) r3
            r2 = 90
            r1 = 26
            r0 = 88
            java.lang.String r5 = A01(r2, r1, r0)
            com.facebook.ads.redexgen.X.Ec r4 = r3.A0B
            r2 = 116(0x74, float:1.63E-43)
            r1 = 3
            r0 = 18
            java.lang.String r2 = A01(r2, r1, r0)
            int r1 = com.facebook.ads.redexgen.X.C0512Kc.A0F
            com.facebook.ads.redexgen.X.Ke r0 = new com.facebook.ads.redexgen.X.Ke
            r0.<init>(r5)
            com.facebook.ads.redexgen.X.C0511Kb.A06(r4, r2, r1, r0)
            com.facebook.ads.internal.protocol.AdErrorType r2 = com.facebook.ads.internal.protocol.AdErrorType.INTERNAL_ERROR
            com.facebook.ads.redexgen.X.Ec r0 = r3.A0B
            com.facebook.ads.redexgen.X.0c r1 = r0.A08()
            int r0 = r2.getErrorCode()
            r1.A3s(r0, r5)
            com.facebook.ads.redexgen.X.1G r1 = r3.A06
            java.lang.String r0 = r2.getDefaultErrorMessage()
            com.facebook.ads.redexgen.X.Hr r0 = com.facebook.ads.redexgen.X.C0453Hr.A02(r2, r0)
            r1.A0G(r0)
            com.facebook.ads.redexgen.X.Ec r0 = r3.A0B
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A3v()
            r0 = 3
            goto L6
        Lcb:
            com.facebook.ads.redexgen.X.35 r3 = (com.facebook.ads.redexgen.X.AnonymousClass35) r3
            com.facebook.ads.redexgen.X.Gl r1 = r3.A08
            com.facebook.ads.redexgen.X.1F r0 = r3.A02
            java.lang.String r0 = r0.A4V()
            r1.A5m(r0)
            r0 = 8
            goto L6
        Ldc:
            r0 = 4
            goto L6
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass35.A0A():void");
    }

    public final void A0B() {
        A0I(false);
    }

    public final synchronized void A0C() {
        A0E.post(new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.38
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
                    byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass38.A01
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
                    int r0 = r0 + (-82)
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass38.A01(int, int, int):java.lang.String");
            }

            public static void A04() {
                A01 = new byte[]{-73, -58, -65};
            }

            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            public final void A05() {
                try {
                    AnonymousClass35.this.A02();
                } catch (Exception e) {
                    C0511Kb.A06(AnonymousClass35.this.A0B, A01(0, 3, 4), C0512Kc.A0I, new C0514Ke(e));
                }
            }
        });
    }

    public final void A0D(C1F c1f) {
        if (c1f != null) {
            c1f.onDestroy();
        }
    }

    public final void A0E(C1G c1g) {
        this.A06 = c1g;
    }

    public void A0F(@Nullable String str) {
        this.A0B.A08().A3t(str != null);
        this.A03 = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT < 17) {
            A6Y(new C0453Hr(AdErrorType.API_NOT_SUPPORTED, A01(67, 0, 45)));
            return;
        }
        try {
            this.A05 = this.A07.A01(this.A0B, new I2(this.A0B, str, this.A07.A08, this.A07.A07));
            this.A0A.A0U(this.A05);
        } catch (C0454Hs e) {
            A6Y(C0453Hr.A03(e));
        }
    }

    public final void A0G(@Nullable String str) {
        A0F(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0H(java.util.Map<java.lang.String, java.lang.Object> r7) {
        /*
            r6 = this;
            r5 = r6
            r3 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Ec r0 = r5.A0B
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A3q()
            r2 = 168(0xa8, float:2.35E-43)
            r1 = 4
            r0 = 18
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.Object r4 = r7.get(r0)
            boolean r0 = r4 instanceof org.json.JSONObject
            if (r0 == 0) goto L51
            r0 = 2
        L1e:
            switch(r0) {
                case 2: goto L22;
                case 3: goto L3e;
                case 4: goto L53;
                default: goto L21;
            }
        L21:
            goto L1e
        L22:
            java.lang.Object r4 = (java.lang.Object) r4
            r3 = r4
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            r2 = 129(0x81, float:1.81E-43)
            r1 = 2
            r0 = 85
            java.lang.String r0 = A01(r2, r1, r0)
            java.lang.String r3 = r3.optString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L3c
            r0 = 3
            goto L1e
        L3c:
            r0 = 4
            goto L1e
        L3e:
            com.facebook.ads.redexgen.X.35 r5 = (com.facebook.ads.redexgen.X.AnonymousClass35) r5
            java.lang.String r3 = (java.lang.String) r3
            com.facebook.ads.redexgen.X.Gv r2 = new com.facebook.ads.redexgen.X.Gv
            com.facebook.ads.redexgen.X.Gl r0 = r5.A08
            r2.<init>(r3, r0)
            com.facebook.ads.redexgen.X.Gu r1 = com.facebook.ads.redexgen.X.EnumC0431Gu.A03
            r0 = 0
            r2.A02(r1, r0)
            r0 = 4
            goto L1e
        L51:
            r0 = 4
            goto L1e
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass35.A0H(java.util.Map):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0I(boolean r3) {
        /*
            r2 = this;
            r1 = r2
            if (r3 != 0) goto L2f
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L31;
                case 4: goto L12;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.35 r1 = (com.facebook.ads.redexgen.X.AnonymousClass35) r1
            boolean r0 = r1.A0C
            if (r0 != 0) goto L10
            r0 = 3
            goto L4
        L10:
            r0 = 4
            goto L4
        L12:
            com.facebook.ads.redexgen.X.35 r1 = (com.facebook.ads.redexgen.X.AnonymousClass35) r1
            com.facebook.ads.redexgen.X.Ec r0 = r1.A0B
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A3x()
            com.facebook.ads.redexgen.X.1F r0 = r1.A02
            r1.A0D(r0)
            com.facebook.ads.redexgen.X.IQ r0 = r1.A0A
            r0.A0T()
            r0 = 0
            r1.A00 = r0
            r0 = 0
            r1.A0C = r0
            r0 = 3
            goto L4
        L2f:
            r0 = 4
            goto L4
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass35.A0I(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0J() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Fq r0 = r2.A04
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
            com.facebook.ads.redexgen.X.35 r2 = (com.facebook.ads.redexgen.X.AnonymousClass35) r2
            com.facebook.ads.redexgen.X.Fq r0 = r2.A04
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass35.A0J():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass34
    public final synchronized void A6Y(final C0453Hr c0453Hr) {
        A06().post(new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.39
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            public final void A05() {
                AnonymousClass35.this.A0B.A08().A3s(c0453Hr.A04().getErrorCode(), c0453Hr.A05());
                AnonymousClass35.this.A06.A0G(c0453Hr);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass34
    public final synchronized void A7Y(final IU iu) {
        A06().post(new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.37
            public static byte[] A02;

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
                    byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass37.A02
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
                    r0 = r0 ^ 80
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.A01(int, int, int):java.lang.String");
            }

            public static void A04() {
                A02 = new byte[]{45, 42, 50, 37, 40, 45, 32, 100, 52, 40, 37, 39, 33, 41, 33, 42, 48, 100, 45, 42, 100, 54, 33, 55, 52, 43, 42, 55, 33};
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A05() {
                /*
                    r6 = this;
                    r5 = r6
                    r0 = 0
                    com.facebook.ads.redexgen.X.IU r0 = r2
                    com.facebook.ads.redexgen.X.Fq r4 = r0.A00()
                    if (r4 == 0) goto L59
                    r0 = 2
                Lb:
                    switch(r0) {
                        case 2: goto Lf;
                        case 3: goto L1b;
                        case 4: goto L5b;
                        case 5: goto L49;
                        default: goto Le;
                    }
                Le:
                    goto Lb
                Lf:
                    com.facebook.ads.redexgen.X.Fq r4 = (com.facebook.ads.redexgen.X.C0402Fq) r4
                    com.facebook.ads.redexgen.X.Fr r0 = r4.A05()
                    if (r0 != 0) goto L19
                    r0 = 3
                    goto Lb
                L19:
                    r0 = 5
                    goto Lb
                L1b:
                    com.facebook.ads.redexgen.X.37 r5 = (com.facebook.ads.redexgen.X.AnonymousClass37) r5
                    r2 = 0
                    r1 = 29
                    r0 = 20
                    java.lang.String r3 = A01(r2, r1, r0)
                    com.facebook.ads.redexgen.X.Hr r2 = new com.facebook.ads.redexgen.X.Hr
                    com.facebook.ads.internal.protocol.AdErrorType r0 = com.facebook.ads.internal.protocol.AdErrorType.NO_AD_PLACEMENT
                    r2.<init>(r0, r3)
                    com.facebook.ads.redexgen.X.35 r0 = com.facebook.ads.redexgen.X.AnonymousClass35.this
                    com.facebook.ads.redexgen.X.Ec r0 = r0.A0B
                    com.facebook.ads.redexgen.X.0c r1 = r0.A08()
                    com.facebook.ads.internal.protocol.AdErrorType r0 = r2.A04()
                    int r0 = r0.getErrorCode()
                    r1.A3s(r0, r3)
                    com.facebook.ads.redexgen.X.35 r0 = com.facebook.ads.redexgen.X.AnonymousClass35.this
                    com.facebook.ads.redexgen.X.1G r0 = r0.A06
                    r0.A0G(r2)
                    r0 = 4
                    goto Lb
                L49:
                    com.facebook.ads.redexgen.X.37 r5 = (com.facebook.ads.redexgen.X.AnonymousClass37) r5
                    com.facebook.ads.redexgen.X.Fq r4 = (com.facebook.ads.redexgen.X.C0402Fq) r4
                    com.facebook.ads.redexgen.X.35 r0 = com.facebook.ads.redexgen.X.AnonymousClass35.this
                    com.facebook.ads.redexgen.X.AnonymousClass35.A00(r0, r4)
                    com.facebook.ads.redexgen.X.35 r0 = com.facebook.ads.redexgen.X.AnonymousClass35.this
                    r0.A0C()
                    r0 = 4
                    goto Lb
                L59:
                    r0 = 3
                    goto Lb
                L5b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass37.A05():void");
            }
        });
    }
}
