package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.4r, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C01244r extends C5R implements InterfaceC01254s {
    public static byte[] A01;
    public boolean A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C01244r.A01
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
            r0 = r0 ^ 22
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01244r.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{75, 124, 103, 109, 101, 108, 41, 103, 102, 125, 41, 123, 108, 104, 109, 112};
    }

    public final synchronized void A06() {
        this.A00 = true;
    }

    public final synchronized boolean A07(AtomicReference<JSONObject> atomicReference, AtomicReference<JSONObject> atomicReference2) {
        boolean z = false;
        synchronized (this) {
            if (!A5G()) {
                throw new IllegalStateException(A00(0, 16, 31));
            }
            if (!this.A00) {
                atomicReference2.set(A4g());
            } else {
                atomicReference.set(A4X());
                atomicReference2.set(A4g());
                this.A00 = false;
                z = true;
            }
        }
        return z;
    }
}