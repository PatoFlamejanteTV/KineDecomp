package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

/* loaded from: assets/audience_network.dex */
public class N2 implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ N3 A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.N2.A01
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
            int r0 = r0 + (-67)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N2.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-85, -72, -82, -68, -71, -77, -82, 120, -77, -72, -66, -81, -72, -66, 120, -85, -83, -66, -77, -71, -72, 120, -96, -109, -113, -95, -18, -17, -4, 2, 1, -57, -17, -7, -18, -5, -8};
    }

    public N2(N3 n3) {
        this.A00 = n3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        String str3;
        if (C0466Ig.A02(this)) {
            return;
        }
        try {
            str = this.A00.A04;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String A00 = A00(26, 11, 74);
            str2 = this.A00.A04;
            if (A00.equals(str2)) {
                return;
            }
            String A002 = A00(0, 26, 7);
            str3 = this.A00.A04;
            Intent intent = new Intent(A002, Uri.parse(str3));
            intent.addFlags(268435456);
            this.A00.getContext().startActivity(intent);
        } catch (Throwable th) {
            C0466Ig.A00(th, this);
        }
    }
}
