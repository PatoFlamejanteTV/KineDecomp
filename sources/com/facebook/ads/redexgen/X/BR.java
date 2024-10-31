package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;

/* loaded from: assets/audience_network.dex */
public final class BR extends C0279Ax {
    public static byte[] A01;
    public final AudioManager A00;

    static {
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.BR.A01
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
            r0 = r0 ^ 30
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.BR.A04(int, int, int):java.lang.String");
    }

    public static void A05() {
        A01 = new byte[]{57, 45, 60, 49, 55};
    }

    public BR(Context context, AA aa) {
        super(context, aa);
        this.A00 = (AudioManager) context.getSystemService(A04(0, 5, 70));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC0351Dr A03(HashMap<Integer, BQ> hashMap) {
        return new E2(SystemClock.elapsedRealtime(), A02(), hashMap, E8.A06);
    }

    public final InterfaceC0267Al A0G() {
        return new BO(this);
    }

    public final InterfaceC0267Al A0H() {
        return new BL(this);
    }

    public final InterfaceC0267Al A0I() {
        return new BM(this);
    }

    public final InterfaceC0267Al A0J() {
        return new BN(this);
    }

    public final InterfaceC0267Al A0K(List<C0345Dl> list) {
        return new BP(this, list);
    }
}
