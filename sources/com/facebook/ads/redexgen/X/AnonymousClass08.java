package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.08, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass08 {
    public static byte[] A0B;
    public int A00;
    public int A01;

    @Nullable
    public Integer A02;
    public String A03;
    public String A04;
    public boolean A05;
    public final String A06;
    public final String A07;
    public final String A08;
    public final String A09;
    public final boolean A0A;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass08.A0B
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
            int r0 = r0 + (-9)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass08.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A0B = new byte[]{-119, -126, Byte.MAX_VALUE, -126, -125, -117, -126};
    }

    public AnonymousClass08(AnonymousClass08 anonymousClass08) {
        this.A04 = A00(7, 0, 121);
        this.A01 = -1;
        this.A00 = -1;
        this.A09 = anonymousClass08.A09;
        this.A08 = anonymousClass08.A08;
        this.A06 = anonymousClass08.A06;
        this.A07 = anonymousClass08.A07;
        this.A02 = anonymousClass08.A02;
        this.A03 = anonymousClass08.A03;
        this.A0A = anonymousClass08.A0A;
    }

    public AnonymousClass08(String str) {
        this.A04 = A00(7, 0, 121);
        this.A01 = -1;
        this.A00 = -1;
        this.A09 = str;
        this.A08 = A00(0, 7, 11);
        this.A06 = A00(0, 7, 11);
        this.A07 = A00(0, 7, 11);
        this.A02 = null;
        this.A03 = A00(0, 7, 11);
        this.A0A = false;
    }

    public AnonymousClass08(String str, String str2, String str3, String str4, String str5, boolean z) {
        this.A04 = A00(7, 0, 121);
        this.A01 = -1;
        this.A00 = -1;
        this.A09 = str;
        this.A08 = str2;
        this.A06 = str3;
        this.A07 = str4;
        this.A02 = null;
        this.A03 = str5;
        this.A0A = z;
    }
}
