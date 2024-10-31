package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Na, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0587Na {
    public static byte[] A09;

    @Nullable
    public NZ A00;
    public boolean A01 = true;
    public boolean A02;
    public final C0362Ec A03;
    public final InterfaceC0422Gl A04;
    public final K5 A05;
    public final AnonymousClass81 A06;
    public final FP A07;
    public final String A08;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0587Na.A09
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
            int r0 = r0 + (-111)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0587Na.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A09 = new byte[]{-33, -16, -35, -34, 17, 16, 16, 11, 10, -33, 8, 5, -1, 7, -24, 5, 15, 16, 1, 10, 1, 14, -23, 22, 22, 19, 22, -60, 9, 28, 9, 7, 25, 24, 13, 18, 11, -60, 5, 7, 24, 13, 19, 18, -51, -6, -6, -9, -6, -88, -1, -16, -15, -12, -19, -88, -9, -8, -19, -10, -15, -10, -17, -88};
    }

    public C0587Na(C0362Ec c0362Ec, String str, FP fp, K5 k5, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81) {
        this.A03 = c0362Ec;
        this.A08 = str;
        this.A07 = fp;
        this.A05 = k5;
        this.A04 = interfaceC0422Gl;
        this.A06 = anonymousClass81;
    }

    public static void A03(C0362Ec c0362Ec, @Nullable FP fp, K5 k5, InterfaceC0422Gl interfaceC0422Gl, C2U c2u, String str) {
        AnonymousClass11 adAction = AnonymousClass12.A01(c0362Ec, interfaceC0422Gl, str, Uri.parse(c2u.A04()), new NS().A03(fp).A02(k5).A05(), false, false);
        if (adAction != null) {
            adAction.A0A();
        }
    }

    private void A05(String str, String str2, Map<String, String> map) {
        this.A04.A5r(str, map);
        C0486Jb.A00(new NX(this, map, str, str2), new NY(this, str, map), JJ.A00());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(String str, String str2, Map<String, String> map) {
        try {
            AnonymousClass11 A01 = AnonymousClass12.A01(this.A03, this.A04, str, Uri.parse(str2), new NS(map).A03(this.A07).A02(this.A05).A05(), this.A01, this.A02);
            if (A01 != null) {
                A01.A03();
            }
            if (this.A00 != null) {
                this.A00.A6R();
            }
            this.A06.A3b(this.A08);
        } catch (ActivityNotFoundException e) {
            Log.e(A01(0, 22, 45), A01(44, 20, 25) + str2, e);
        } catch (Exception e2) {
            Log.e(A01(0, 22, 45), A01(22, 22, 53), e2);
        }
    }

    public final void A07(NZ nz) {
        this.A00 = nz;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A08(java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            r4 = this;
            r3 = r4
            com.facebook.ads.redexgen.X.Gv r2 = new com.facebook.ads.redexgen.X.Gv
            com.facebook.ads.redexgen.X.Gl r0 = r3.A04
            r2.<init>(r5, r0)
            com.facebook.ads.redexgen.X.Gu r1 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0I
            r0 = 0
            r2.A02(r1, r0)
            com.facebook.ads.redexgen.X.K5 r1 = r3.A05
            com.facebook.ads.redexgen.X.Ec r0 = r3.A03
            boolean r0 = r1.A09(r0)
            if (r0 == 0) goto L52
            r0 = 2
        L19:
            switch(r0) {
                case 2: goto L1d;
                case 3: goto L54;
                case 4: goto L2a;
                case 5: goto L38;
                case 6: goto L45;
                default: goto L1c;
            }
        L1c:
            goto L19
        L1d:
            com.facebook.ads.redexgen.X.Na r3 = (com.facebook.ads.redexgen.X.C0587Na) r3
            java.lang.String r5 = (java.lang.String) r5
            java.util.Map r7 = (java.util.Map) r7
            com.facebook.ads.redexgen.X.Gl r0 = r3.A04
            r0.A5T(r5, r7)
            r0 = 3
            goto L19
        L2a:
            com.facebook.ads.redexgen.X.Na r3 = (com.facebook.ads.redexgen.X.C0587Na) r3
            com.facebook.ads.redexgen.X.Ec r0 = r3.A03
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0n(r0)
            if (r0 == 0) goto L36
            r0 = 5
            goto L19
        L36:
            r0 = 6
            goto L19
        L38:
            com.facebook.ads.redexgen.X.Na r3 = (com.facebook.ads.redexgen.X.C0587Na) r3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = (java.lang.String) r6
            java.util.Map r7 = (java.util.Map) r7
            r3.A05(r5, r6, r7)
            r0 = 3
            goto L19
        L45:
            com.facebook.ads.redexgen.X.Na r3 = (com.facebook.ads.redexgen.X.C0587Na) r3
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = (java.lang.String) r6
            java.util.Map r7 = (java.util.Map) r7
            r3.A06(r5, r6, r7)
            r0 = 3
            goto L19
        L52:
            r0 = 4
            goto L19
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0587Na.A08(java.lang.String, java.lang.String, java.util.Map):void");
    }

    public final void A09(boolean z) {
        this.A02 = z;
    }

    public final void A0A(boolean z) {
        this.A01 = z;
    }
}
