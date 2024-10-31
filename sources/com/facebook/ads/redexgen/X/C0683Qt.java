package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Qt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0683Qt extends AbstractC02238s {
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
            byte[] r1 = com.facebook.ads.redexgen.X.C0683Qt.A01
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
            r0 = r0 ^ 90
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0683Qt.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{15, 27, 10, 7, 1};
    }

    public C0683Qt(C0688Qy c0688Qy) {
        this.A00 = c0688Qy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:            r1.abandonAudioFocus(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1S
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A03(com.facebook.ads.redexgen.X.QM r7) {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r4 = 0
            com.facebook.ads.redexgen.X.Qy r0 = r5.A00
            android.content.Context r0 = r0.getContext()
            android.content.Context r3 = r0.getApplicationContext()
            r2 = 0
            r1 = 5
            r0 = 52
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.Object r1 = r3.getSystemService(r0)
            android.media.AudioManager r1 = (android.media.AudioManager) r1
            com.facebook.ads.redexgen.X.Qy r0 = r5.A00
            java.lang.ref.WeakReference r0 = com.facebook.ads.redexgen.X.C0688Qy.A03(r0)
            if (r0 != 0) goto L3b
            r0 = 2
        L24:
            switch(r0) {
                case 2: goto L28;
                case 3: goto L3d;
                case 4: goto L2b;
                default: goto L27;
            }
        L27:
            goto L24
        L28:
            r4 = 0
            r0 = 3
            goto L24
        L2b:
            com.facebook.ads.redexgen.X.Qt r5 = (com.facebook.ads.redexgen.X.C0683Qt) r5
            com.facebook.ads.redexgen.X.Qy r0 = r5.A00
            java.lang.ref.WeakReference r0 = com.facebook.ads.redexgen.X.C0688Qy.A03(r0)
            java.lang.Object r4 = r0.get()
            android.media.AudioManager$OnAudioFocusChangeListener r4 = (android.media.AudioManager.OnAudioFocusChangeListener) r4
            r0 = 3
            goto L24
        L3b:
            r0 = 4
            goto L24
        L3d:
            android.media.AudioManager r1 = (android.media.AudioManager) r1
            r1.abandonAudioFocus(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0683Qt.A03(com.facebook.ads.redexgen.X.QM):void");
    }
}
