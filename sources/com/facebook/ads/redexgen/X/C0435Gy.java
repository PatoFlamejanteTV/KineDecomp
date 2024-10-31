package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Map;
import org.json.JSONException;

/* renamed from: com.facebook.ads.redexgen.X.Gy, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0435Gy extends AbstractRunnableC00351g {
    public static byte[] A01;
    public final /* synthetic */ C0361Eb A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0435Gy.A01
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
            r0 = r0 ^ 54
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0435Gy.A01(int, int, int):java.lang.String");
    }

    public static void A04() {
        A01 = new byte[]{102, 110, 106, 120, 126, 121, 110, 111, 84, 120, 110, 120, 120, 98, 100, 101, 84, 98, 111, 23, 27, 25, 90, 18, 21, 23, 17, 22, 27, 27, 31, 90, 21, 16, 7, 90, 56, 59, 55, 53, 56, 43, 55, 59, 33, 58, 32, 49, 38, 39, 28, 31, 19, 17, 28, 47, 19, 31, 5, 30, 4, 21, 2, 3};
    }

    public C0435Gy(C0361Eb c0361Eb) {
        this.A00 = c0361Eb;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00351g
    public final void A05() {
        SharedPreferences sp = null;
        try {
            sp = this.A00.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(19, 31, 66), this.A00), 0);
            Map<String, ?> all = sp.getAll();
            if (all.size() > 1) {
                H1.A04(this.A00, C7A.A04(this.A00), all);
                sp.edit().clear().apply();
            }
            sp.edit().putString(A01(0, 19, 61), this.A00.A04().A02()).apply();
        } catch (JSONException e) {
            this.A00.A06().A5W(A01(50, 14, 70), 3502, new C0514Ke(e));
            sp.edit().clear().apply();
        }
    }
}
