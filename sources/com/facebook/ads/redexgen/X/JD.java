package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public class JD implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C0468Ij A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.JD.A01
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
            r0 = r0 ^ 102(0x66, float:1.43E-43)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.JD.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{82, 116, 98, 117, 39, 100, 107, 110, 100, 108, 98, 99, 39, 116, 108, 110, 119, 39, 101, 98, 97, 104, 117, 98, 39, 115, 111, 98, 39, 102, 99, 116, 39, 110, 116, 39, 102, 107, 107, 104, 112, 98, 99, 39, 115, 104, 39, 116, 108, 110, 119, 41, 102, 94, 92, 69, 101, 89, 64, 82, 92, 91};
    }

    public JD(C0468Ij c0468Ij) {
        this.A00 = c0468Ij;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AtomicBoolean atomicBoolean;
        C0537Lb videoView;
        C0537Lb videoView2;
        if (!C0466Ig.A02(this)) {
            try {
                atomicBoolean = this.A00.A05;
                if (atomicBoolean.get()) {
                    videoView = this.A00.getVideoView();
                    if (videoView != null) {
                        videoView2 = this.A00.getVideoView();
                        videoView2.A0P(QE.A08);
                    }
                } else {
                    Log.i(A00(52, 10, 83), A00(0, 52, 97));
                }
            } catch (Throwable th) {
                C0466Ig.A00(th, this);
            }
        }
    }
}
