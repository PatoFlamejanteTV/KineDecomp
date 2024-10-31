package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.9p, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02459p {

    @Nullable
    public static InterfaceC02469q A00;
    public static boolean A01;
    public static byte[] A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C02459p.A02
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
            int r0 = r0 + (-75)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02459p.A00(int, int, int):java.lang.String");
    }

    public static void A02() {
        A02 = new byte[]{43, 46, 55, 44, 49, 54, 42, 59, 52};
    }

    static {
        A02();
        A01 = false;
        A00 = null;
    }

    public static void A01() {
        synchronized (C02459p.class) {
            if (A00 != null) {
                C0514Ke c0514Ke = new C0514Ke(A00.A89());
                c0514Ke.A03(1);
                C0365Ef A002 = C0363Ed.A00();
                if (A002 != null) {
                    A002.A06().A5W(A00(0, 9, 126), 3401, c0514Ke);
                }
                A00.reset();
            }
        }
    }

    public static void A03(final long j) {
        if (j > 0) {
            A00 = new InterfaceC02469q() { // from class: com.facebook.ads.redexgen.X.9r
                public final Map<String, C02449o> A00 = new HashMap();

                @Override // com.facebook.ads.redexgen.X.InterfaceC02469q
                public final synchronized String A89() {
                    StringBuilder sb;
                    sb = new StringBuilder();
                    Iterator<C02449o> it = this.A00.values().iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().toString());
                        sb.append('\n');
                    }
                    return sb.toString();
                }

                @Override // com.facebook.ads.redexgen.X.InterfaceC02469q
                public final synchronized void reset() {
                    this.A00.clear();
                }
            };
            new Thread(j) { // from class: com.facebook.ads.redexgen.X.9s
                public final long A00;

                {
                    this.A00 = j;
                    start();
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    if (C0466Ig.A02(this)) {
                        return;
                    }
                    while (true) {
                        try {
                            try {
                                Thread.sleep(this.A00);
                            } catch (InterruptedException unused) {
                            }
                            C02459p.A01();
                        } catch (Throwable th) {
                            C0466Ig.A00(th, this);
                            return;
                        }
                    }
                }
            };
        }
    }
}
