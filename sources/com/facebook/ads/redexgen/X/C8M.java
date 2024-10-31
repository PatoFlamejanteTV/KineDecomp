package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BidderTokenProviderApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* renamed from: com.facebook.ads.redexgen.X.8M, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8M implements BidderTokenProviderApi {
    public static byte[] A03;
    public C0365Ef A00;
    public String A01;

    @VisibleForTesting
    public final C0493Ji A02 = new C0493Ji(300000000000L, new AbstractRunnableC00351g() { // from class: com.facebook.ads.redexgen.X.8L
        @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
        public final void A05() {
            C8M.this.A02();
        }
    });

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C8M.A03
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
            int r0 = r0 + (-103)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8M.A01(int, int, int):java.lang.String");
    }

    public static void A03() {
        A03 = new byte[]{47, 38, 53, 56, 48, 51, 44, 64, 53, 58, 49, 38, -58, -72, -58, -58, -68, -62, -63, -46, -57, -68, -64, -72, -12, 1, -12, -1, 2, -6};
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.GL A00(com.facebook.ads.redexgen.X.C0365Ef r4) {
        /*
            r1 = 0
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A0c(r4)
            if (r0 == 0) goto L40
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L42;
                case 4: goto L3a;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r0 = 3
            java.lang.String[] r4 = new java.lang.String[r0]
            r3 = 0
            r2 = 24
            r1 = 6
            r0 = 76
            java.lang.String r0 = A01(r2, r1, r0)
            r4[r3] = r0
            r3 = 1
            r2 = 12
            r1 = 12
            r0 = 12
            java.lang.String r0 = A01(r2, r1, r0)
            r4[r3] = r0
            r3 = 2
            r2 = 0
            r1 = 12
            r0 = 122(0x7a, float:1.71E-43)
            java.lang.String r0 = A01(r2, r1, r0)
            r4[r3] = r0
            com.facebook.ads.redexgen.X.GL r1 = com.facebook.ads.redexgen.X.GO.A01(r4)
            r0 = 3
            goto L8
        L3a:
            com.facebook.ads.redexgen.X.GL r1 = com.facebook.ads.redexgen.X.GO.A00()
            r0 = 3
            goto L8
        L40:
            r0 = 4
            goto L8
        L42:
            com.facebook.ads.redexgen.X.GL r1 = (com.facebook.ads.redexgen.X.GL) r1
            com.facebook.ads.redexgen.X.GL r1 = (com.facebook.ads.redexgen.X.GL) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8M.A00(com.facebook.ads.redexgen.X.Ef):com.facebook.ads.redexgen.X.GL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        C0365Ef c0365Ef;
        synchronized (this) {
            c0365Ef = this.A00;
        }
        if (c0365Ef == null) {
            return;
        }
        String A4z = GQ.A00().A02(c0365Ef, true).A4z(A00(c0365Ef));
        synchronized (this) {
            this.A01 = A4z;
        }
    }

    public final synchronized String getBidderToken(Context context) {
        this.A00 = C8N.A07(context);
        DynamicLoaderFactory.makeLoader(this.A00).getInitApi().maybeAttachCrashListener(this.A00);
        if (this.A01 == null) {
            A02();
            this.A02.A04().A03();
        }
        this.A02.A05();
        return this.A01;
    }
}
