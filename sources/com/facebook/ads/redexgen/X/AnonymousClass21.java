package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* renamed from: com.facebook.ads.redexgen.X.21, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass21 extends BroadcastReceiver {
    public static byte[] A04;
    public C00341f A00;
    public AnonymousClass20 A01;
    public C0362Ec A02;
    public String A03;

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
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass21.A04
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
            r0 = r0 ^ 72
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass21.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A04 = new byte[]{41, 37, 39, 100, 44, 43, 41, 47, 40, 37, 37, 33, 100, 43, 46, 57, 100, 35, 36, 62, 47, 56, 57, 62, 35, 62, 35, 43, 38, 100, 56, 47, 61, 43, 56, 46, 21, 57, 47, 56, 60, 47, 56, 21, 44, 43, 35, 38, 63, 56, 47, 112, 94, 82, 80, 19, 91, 92, 94, 88, 95, 82, 82, 86, 19, 92, 89, 78, 19, 84, 83, 73, 88, 79, 78, 73, 84, 73, 84, 92, 81, 19, 92, 94, 73, 84, 75, 84, 73, 68, 98, 89, 88, 78, 73, 79, 82, 68, 88, 89, 51, 63, 61, 126, 54, 49, 51, 53, 50, 63, 63, 59, 126, 49, 52, 35, 126, 57, 62, 36, 53, 34, 35, 36, 57, 36, 57, 49, 60, 126, 34, 53, 39, 49, 34, 52, 106, 80, 92, 94, 29, 85, 82, 80, 86, 81, 92, 92, 88, 29, 82, 87, 64, 29, 90, 93, 71, 86, 65, 64, 71, 90, 71, 90, 82, 95, 29, 82, 80, 71, 90, 69, 90, 71, 74, 108, 87, 86, 64, 71, 65, 92, 74, 86, 87, 9, 105, 101, 103, 36, 108, 107, 105, 111, 104, 101, 101, 97, 36, 107, 110, 121, 36, 99, 100, 126, 111, 120, 121, 126, 99, 126, 99, 107, 102, 36, 99, 103, 122, 120, 111, 121, 121, 99, 101, 100, 36, 102, 101, 109, 109, 111, 110, 8, 4, 6, 69, 13, 10, 8, 14, 9, 4, 4, 0, 69, 10, 15, 24, 69, 2, 5, 31, 14, 25, 24, 31, 2, 31, 2, 10, 7, 69, 15, 2, 24, 27, 7, 10, 18, 14, 15, 119, 123, 121, 58, 114, 117, 119, 113, 118, 123, 123, Byte.MAX_VALUE, 58, 117, 112, 103, 58, 125, 122, 96, 113, 102, 103, 96, 125, 96, 125, 117, 120, 58, 102, 113, 99, 117, 102, 112, 75, 103, 113, 102, 98, 113, 102, 75, 103, 97, 119, 119, 113, 103, 103, 46, 96, 108, 110, 45, 101, 98, 96, 102, 97, 108, 108, 104, 45, 98, 103, 112, 45, 106, 109, 119, 102, 113, 112, 119, 106, 119, 106, 98, 111, 45, 101, 106, 109, 106, 112, 107, 92, 98, 96, 119, 106, 117, 106, 119, 122, 57, 64, 76, 78, 13, 69, 66, 64, 70, 65, 76, 76, 72, 13, 66, 71, 80, 13, 74, 77, 87, 70, 81, 80, 87, 74, 87, 74, 66, 79, 13, 70, 81, 81, 76, 81, 65, 77, 79, 12, 68, 67, 65, 71, 64, 77, 77, 73, 12, 67, 70, 81, 12, 75, 76, 86, 71, 80, 81, 86, 75, 86, 75, 67, 78, 12, 80, 71, 85, 67, 80, 70, 125, 81, 71, 80, 84, 71, 80, 125, 68, 67, 75, 78, 87, 80, 71, Byte.MAX_VALUE, 115, 113, 50, 122, 125, Byte.MAX_VALUE, 121, 126, 115, 115, 119, 50, 125, 120, 111, 50, 117, 114, 104, 121, 110, 111, 104, 117, 104, 117, 125, 112, 50, Byte.MAX_VALUE, 112, 117, Byte.MAX_VALUE, 119, 121, 120, 38, 118, 122, 120, 59, 115, 116, 118, 112, 119, 122, 122, 126, 59, 116, 113, 102, 59, 124, 123, 97, 112, 103, 102, 97, 124, 97, 124, 116, 121, 59, 113, 124, 102, 101, 121, 116, 108, 112, 113, 47, 121, 117, 119, 52, 124, 123, 121, Byte.MAX_VALUE, 120, 117, 117, 113, 52, 123, 126, 105, 52, 115, 116, 110, Byte.MAX_VALUE, 104, 105, 110, 115, 110, 115, 123, 118, 52, 104, Byte.MAX_VALUE, 109, 123, 104, 126, 94, 111, 99, 97, 34, 106, 109, 111, 105, 110, 99, 99, 103, 34, 109, 104, Byte.MAX_VALUE, 34, 101, 98, 120, 105, 126, Byte.MAX_VALUE, 120, 101, 120, 101, 109, 96, 34, 101, 97, 124, 126, 105, Byte.MAX_VALUE, Byte.MAX_VALUE, 101, 99, 98, 34, 96, 99, 107, 107, 105, 104, 54, 126, 114, 112, 51, 123, 124, 126, 120, Byte.MAX_VALUE, 114, 114, 118, 51, 124, 121, 110, 51, 116, 115, 105, 120, 111, 110, 105, 116, 105, 116, 124, 113, 51, 111, 120, 106, 124, 111, 121, 66, 110, 120, 111, 107, 120, 111, 66, 110, 104, 126, 126, 120, 110, 110, 2, 14, 12, 79, 7, 0, 2, 4, 3, 14, 14, 10, 79, 0, 5, 18, 79, 8, 15, 21, 4, 19, 18, 21, 8, 21, 8, 0, 13, 79, 5, 8, 18, 12, 8, 18, 18, 4, 5, 68, 72, 74, 9, 65, 70, 68, 66, 69, 72, 72, 76, 9, 70, 67, 84, 9, 78, 73, 83, 66, 85, 84, 83, 78, 83, 78, 70, 75, 9, 66, 85, 85, 72, 85, 29, 19, 31, 29, 94, 22, 17, 19, 21, 18, 31, 31, 27, 94, 17, 20, 3, 94, 25, 30, 4, 21, 2, 3, 4, 25, 4, 25, 17, 28, 94, 20, 25, 3, 29, 25, 3, 3, 21, 20, 74, 94, 82, 80, 19, 91, 92, 94, 88, 95, 82, 82, 86, 19, 92, 89, 78, 19, 84, 83, 73, 88, 79, 78, 73, 84, 73, 84, 92, 81, 19, 94, 81, 84, 94, 86, 88, 89};
    }

    public AnonymousClass21(C0362Ec c0362Ec, String str, C00341f c00341f, AnonymousClass20 anonymousClass20) {
        this.A02 = c0362Ec;
        this.A03 = str;
        this.A01 = anonymousClass20;
        this.A00 = c00341f;
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(571, 48, 68) + this.A03);
        intentFilter.addAction(A00(494, 40, 93) + this.A03);
        intentFilter.addAction(A00(745, 40, 56) + this.A03);
        intentFilter.addAction(A00(456, 38, 84) + this.A03);
        intentFilter.addAction(A00(709, 36, 111) + this.A03);
        intentFilter.addAction(A00(137, 49, 123) + this.A03);
        intentFilter.addAction(A00(100, 37, 24) + this.A03);
        intentFilter.addAction(A00(272, 52, 92) + this.A03);
        intentFilter.addAction(A00(0, 52, 2) + this.A03);
        intentFilter.addAction(A00(324, 46, 75) + this.A03);
        C4F.A00(this.A02).A06(this, intentFilter);
    }

    public final void A03() {
        try {
            C4F.A00(this.A02).A05(this);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0170, code lost:            return;     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r7, android.content.Intent r8) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass21.onReceive(android.content.Context, android.content.Intent):void");
    }
}
