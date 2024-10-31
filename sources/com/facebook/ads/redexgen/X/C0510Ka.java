package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Ka, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0510Ka extends AbstractRunnableC00351g {
    public static byte[] A05;
    public final /* synthetic */ int A00;
    public final /* synthetic */ C0361Eb A01;
    public final /* synthetic */ G7 A02;
    public final /* synthetic */ C0514Ke A03;
    public final /* synthetic */ String A04;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0510Ka.A05
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
            r0 = r0 ^ 114(0x72, float:1.6E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0510Ka.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A05 = new byte[]{48, 17, 22, 1, 19, 84, 23, 6, 21, 7, 28, 84, 22, 17, 23, 21, 1, 7, 17, 84, 7, 49, 26, 2, 29, 6, 27, 26, 25, 17, 26, 0, 48, 21, 0, 21, 36, 6, 27, 2, 29, 16, 17, 6, 84, 26, 27, 0, 84, 29, 26, 30, 17, 23, 0, 17, 16, 58, 56, 58, 49, 60, 20, 17, 17, 28, 1, 28, 26, 27, 20, 25, 42, 28, 27, 19, 26, 79, 117, 114, 119, 60, 117, 111, 60, 114, 105, 112, 112, 61, 8, 14, 25, 15, 2, 11, 30, 82, 69, 82, 90, 95, 82, 81, 95, 86, 108, 87, 90, 64, 88, 108, 64, 67, 82, 80, 86, 121, Byte.MAX_VALUE, 104, 126, 115, 122, 111, 85, 105, 101, 110, 111, 23};
    }

    public C0510Ka(C0361Eb c0361Eb, String str, int i, C0514Ke c0514Ke, G7 g7) {
        this.A01 = c0361Eb;
        this.A04 = str;
        this.A00 = i;
        this.A03 = c0514Ke;
        this.A02 = g7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        String str;
        Map<String, String> A01;
        AtomicReference atomicReference;
        String stackTrace;
        try {
            if (!C0511Kb.A0J(this.A01, this.A04, this.A00, this.A03)) {
                H1.A06(this.A01, EnumC0427Gq.A09.toString() + A01(129, 1, 95) + this.A04);
                Throwable cause = this.A03.getCause();
                if (cause != null) {
                    str = C0504Ju.A03(this.A01, cause);
                } else if (C0414Gd.A0Q(this.A01)) {
                    str = C0504Ju.A03(this.A01, this.A03);
                } else {
                    str = A01(62, 0, 88) + this.A03.getMessage();
                }
                if (C0414Gd.A0S(this.A01)) {
                    A01 = GK.A01(this.A01);
                } else if (this.A02 != null) {
                    A01 = this.A02.A4d();
                } else if (!C0511Kb.A02) {
                    A01 = GK.A01(this.A01);
                } else {
                    C0511Kb.A0G(new RuntimeException(A01(0, 57, 6), this.A03));
                    A01 = new HashMap<>();
                }
                A01.put(A01(90, 7, 9), this.A04);
                A01.put(A01(117, 12, 120), String.valueOf(this.A00));
                JSONObject A02 = this.A03.A02();
                if (A02 != null) {
                    A01.put(A01(62, 15, 7), A02.toString());
                }
                if (A01(57, 5, 43).equals(this.A04) && (stackTrace = C0398Fm.A00()) != null) {
                    String lastDiskSpace = A01(97, 20, 65);
                    A01.put(lastDiskSpace, stackTrace);
                }
                atomicReference = C0511Kb.A09;
                G9 debugEventSink = (G9) atomicReference.get();
                if (debugEventSink != null) {
                    debugEventSink.A8m(str, A01, this.A01);
                } else {
                    Throwable deLogExceptionCause = new RuntimeException(A01(77, 13, 110));
                    C0511Kb.A0G(deLogExceptionCause);
                }
            }
        } catch (Throwable th) {
            C0511Kb.A0G(th);
        }
    }
}
