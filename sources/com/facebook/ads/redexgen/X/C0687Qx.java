package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Qx, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0687Qx extends AbstractC02178m {
    public static byte[] A01;
    public final /* synthetic */ C0688Qy A00;

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
            byte[] r1 = com.facebook.ads.redexgen.X.C0687Qx.A01
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0687Qx.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-29, -9, -26, -21, -15};
    }

    public C0687Qx(C0688Qy c0688Qy) {
        this.A00 = c0688Qy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:            r4 = r4;        ((android.media.AudioManager) r4.A00.getContext().getApplicationContext().getSystemService(A00(0, 5, 63))).requestAudioFocus((android.media.AudioManager.OnAudioFocusChangeListener) com.facebook.ads.redexgen.X.C0688Qy.A03(r4.A00).get(), 3, 1);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1S
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03(com.facebook.ads.redexgen.X.QR r6) {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.Qy r0 = r4.A00
            java.lang.ref.WeakReference r0 = com.facebook.ads.redexgen.X.C0688Qy.A03(r0)
            if (r0 == 0) goto L33
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L20;
                case 4: goto L35;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Qx r4 = (com.facebook.ads.redexgen.X.C0687Qx) r4
            com.facebook.ads.redexgen.X.Qy r0 = r4.A00
            java.lang.ref.WeakReference r0 = com.facebook.ads.redexgen.X.C0688Qy.A03(r0)
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L1e
            r0 = 3
            goto La
        L1e:
            r0 = 4
            goto La
        L20:
            com.facebook.ads.redexgen.X.Qx r4 = (com.facebook.ads.redexgen.X.C0687Qx) r4
            com.facebook.ads.redexgen.X.Qy r2 = r4.A00
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            com.facebook.ads.redexgen.X.Qw r0 = new com.facebook.ads.redexgen.X.Qw
            r0.<init>(r4)
            r1.<init>(r0)
            com.facebook.ads.redexgen.X.C0688Qy.A04(r2, r1)
            r0 = 4
            goto La
        L33:
            r0 = 3
            goto La
        L35:
            com.facebook.ads.redexgen.X.Qx r4 = (com.facebook.ads.redexgen.X.C0687Qx) r4
            com.facebook.ads.redexgen.X.Qy r0 = r4.A00
            android.content.Context r0 = r0.getContext()
            android.content.Context r3 = r0.getApplicationContext()
            r2 = 0
            r1 = 5
            r0 = 63
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r3 = r3.getSystemService(r0)
            android.media.AudioManager r3 = (android.media.AudioManager) r3
            com.facebook.ads.redexgen.X.Qy r0 = r4.A00
            java.lang.ref.WeakReference r0 = com.facebook.ads.redexgen.X.C0688Qy.A03(r0)
            java.lang.Object r2 = r0.get()
            android.media.AudioManager$OnAudioFocusChangeListener r2 = (android.media.AudioManager.OnAudioFocusChangeListener) r2
            r1 = 3
            r0 = 1
            r3.requestAudioFocus(r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0687Qx.A03(com.facebook.ads.redexgen.X.QR):void");
    }
}
