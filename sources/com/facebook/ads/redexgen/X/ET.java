package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: assets/audience_network.dex */
public class ET implements Callable<Boolean> {
    public static byte[] A02;
    public final ES A00;
    public final /* synthetic */ EV A01;

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
            byte[] r1 = com.facebook.ads.redexgen.X.ET.A02
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
            r0 = r0 ^ 23
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ET.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{16, 20, 24, 30, 28};
    }

    public ET(EV ev, ES es) {
        this.A01 = ev;
        this.A00 = es;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x013a, code lost:            return java.lang.Boolean.valueOf(r7);     */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean call() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ET.call():java.lang.Boolean");
    }

    private void A03(int i, int i2) {
        EW ew;
        C0361Eb c0361Eb;
        Map map;
        ew = this.A01.A03;
        c0361Eb = this.A01.A04;
        Bitmap bitmap = ew.A0D(c0361Eb, this.A00.A07, i, i2, this.A00.A01);
        if (bitmap == null) {
            return;
        }
        map = this.A01.A07;
        map.put(this.A00.A07, bitmap);
    }

    private void A04(String str, AnonymousClass08 anonymousClass08) {
        C0361Eb c0361Eb;
        AnonymousClass02 A022;
        Map map;
        c0361Eb = this.A01.A04;
        A022 = EV.A02(c0361Eb.A00());
        Bitmap A00 = A022.A8B(anonymousClass08, true).A00();
        if (A00 == null) {
            return;
        }
        map = this.A01.A07;
        map.put(str, A00);
    }
}
