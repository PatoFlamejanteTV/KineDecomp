package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Messenger;

/* renamed from: com.facebook.ads.redexgen.X.Ga, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0411Ga {
    public static byte[] A06;
    public Messenger A00;
    public boolean A01 = false;
    public final ServiceConnection A02 = new GZ(this);
    public final C0362Ec A03;
    public final String A04;
    public final String A05;

    static {
        A06();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A05(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0411Ga.A06
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
            r0 = r0 ^ 92
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0411Ga.A05(int, int, int):java.lang.String");
    }

    public static void A06() {
        A06 = new byte[]{117, 100, 119, 100, 104, 122, 119, 96, 116, 112, 96, 118, 113, 122, 108, 97, 34, 51, 32, 51, 63, 45, 51, 60, 45, 39, 39, 59, 54, 40, 42, 33, 42, 61, 38, 44, 6, 23, 4, 23, 27, 9, 6, 4, 25, 2, 25, 21, 25, 26, 9, 0, 19, 4, 5, 31, 25, 24, 113, 125, Byte.MAX_VALUE, 60, 116, 115, 113, 119, 112, 125, 125, 121, 60, 115, 103, 118, 123, 119, 124, 113, 119, 124, 119, 102, 101, 125, 96, 121, 60, 83, 103, 118, 123, 119, 124, 113, 119, 92, 119, 102, 101, 125, 96, 121, 65, 119, 96, 100, 123, 113, 119, 73, 69, 71, 4, 76, 75, 73, 79, 72, 69, 69, 65, 4, 65, 75, 94, 75, 68, 75};
    }

    public C0411Ga(C0362Ec c0362Ec, String str, String str2) {
        this.A03 = c0362Ec;
        this.A05 = str;
        this.A04 = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle A00() {
        Bundle bundle = new Bundle();
        bundle.putInt(A05(36, 22, 10), 1);
        bundle.putString(A05(16, 13, 46), this.A04);
        bundle.putString(A05(0, 16, 121), this.A05);
        return bundle;
    }

    public final void A08() {
        Intent intent = new Intent();
        intent.setClassName(A05(109, 19, 118), A05(58, 51, 78));
        try {
            if (!this.A03.bindService(intent, this.A02, 1)) {
                this.A03.unbindService(this.A02);
            }
        } catch (Exception e) {
            C0511Kb.A06(this.A03, A05(29, 7, 19), C0512Kc.A10, new C0514Ke(e));
        }
    }
}
