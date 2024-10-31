package com.facebook.ads.redexgen.X;

import android.R;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

@TargetApi(19)
/* renamed from: com.facebook.ads.redexgen.X.Ku, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0530Ku implements InterfaceC0524Ko {
    public static byte[] A0C;
    public static final String A0D;
    public long A00;
    public String A02;
    public String A03;
    public final AnonymousClass89 A07;
    public final InterfaceC0422Gl A08;
    public final N3 A09;
    public final N4 A0A;
    public final NE A0B;
    public final AnonymousClass86 A06 = new C0525Kp(this);
    public boolean A05 = true;
    public long A01 = -1;
    public boolean A04 = true;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0530Ku.A0C
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
            r0 = r0 ^ 47
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0530Ku.A03(int, int, int):java.lang.String");
    }

    public static void A04() {
        A0C = new byte[]{27, 49, 49, 60, 49, 67, 116, 98, 97, 126, Byte.MAX_VALUE, 98, 116, 49, 84, Byte.MAX_VALUE, 117, 49, 69, 120, 124, 116, 43, 49, 40, 33, 46, 36, 44, 37, 50, 20, 41, 45, 37, 58, 16, 16, 29, 16, 99, 83, 66, 95, 92, 92, 16, 98, 85, 81, 84, 73, 16, 100, 89, 93, 85, 10, 16, 87, 125, 125, 112, 125, 17, 50, 60, 57, 125, 27, 52, 51, 52, 46, 53, 125, 9, 52, 48, 56, 103, 125, 105, 67, 67, 78, 67, 39, 12, 14, 67, 32, 12, 13, 23, 6, 13, 23, 67, 47, 12, 2, 7, 6, 7, 67, 55, 10, 14, 6, 89, 67, 2, 18, 15, 23, 19, 5, 18, 53, 50, 44, 62, 79, Byte.MAX_VALUE, 98, 122, 126, 104, Byte.MAX_VALUE, 45, 126, 104, 126, 126, 100, 98, 99, 45, 105, 108, 121, 108, 45, 97, 98, 106, 106, 104, 105, 45, 77, 45, 109, 98, 103, 107, 96, 122, 90, 97, 101, 107, 96, 94, 116, 116, 121, 116, 24, 59, 53, 48, 116, 7, 32, 53, 38, 32, 116, 0, 61, 57, 49, 110, 116, 14, 13, 0, 26, 27, 85, 13, 3, 14, 1, 4, 114, 88, 88, 85, 88, 43, 29, 11, 11, 17, 23, 22, 88, 62, 17, 22, 17, 11, 16, 88, 44, 17, 21, 29, 66, 88, 16, 58, 58, 55, 58, 82, 123, 116, 126, 118, Byte.MAX_VALUE, 104, 58, 78, 115, 119, Byte.MAX_VALUE, 32, 58};
    }

    static {
        A04();
        A0D = C0530Ku.class.getSimpleName();
    }

    public C0530Ku(AnonymousClass89 anonymousClass89, C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81) {
        this.A07 = anonymousClass89;
        this.A08 = interfaceC0422Gl;
        int i = (int) (2.0f * KE.A01);
        this.A09 = new N3(c0362Ec);
        this.A09.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.A09.setListener(new C0527Kr(this, anonymousClass89));
        anonymousClass81.A39(this.A09, layoutParams);
        this.A0B = new NE(c0362Ec, new C0529Kt(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, this.A09.getId());
        layoutParams2.addRule(12);
        anonymousClass81.A39(this.A0B, layoutParams2);
        this.A0A = new N4(c0362Ec, null, R.attr.progressBarStyleHorizontal);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i);
        layoutParams3.addRule(3, this.A09.getId());
        this.A0A.setProgress(0);
        anonymousClass81.A39(this.A0A, layoutParams3);
        anonymousClass89.A0J(this.A06);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:            r5 = r5;        r6 = r6;        r5.A09.setUrl(r6);        r5.A0B.loadUrl(r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c3, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5L(android.content.Intent r10, android.os.Bundle r11, com.facebook.ads.redexgen.X.AnonymousClass89 r12) {
        /*
            r9 = this;
            r5 = r9
            r0 = 0
            r6 = 0
            r2 = -1
            long r0 = r5.A01
            r7 = 0
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto Lb2
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L9a;
                case 3: goto L24;
                case 4: goto L2d;
                case 5: goto L19;
                case 6: goto L13;
                case 7: goto Lb5;
                case 8: goto La5;
                case 9: goto L63;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.Ku r5 = (com.facebook.ads.redexgen.X.C0530Ku) r5
            java.lang.String r6 = r5.A02
            r0 = 7
            goto Lf
        L19:
            com.facebook.ads.redexgen.X.Ku r5 = (com.facebook.ads.redexgen.X.C0530Ku) r5
            java.lang.String r0 = r5.A02
            if (r0 == 0) goto L21
            r0 = 6
            goto Lf
        L21:
            r0 = 8
            goto Lf
        L24:
            android.os.Bundle r11 = (android.os.Bundle) r11
            if (r11 != 0) goto L2a
            r0 = 4
            goto Lf
        L2a:
            r0 = 9
            goto Lf
        L2d:
            com.facebook.ads.redexgen.X.Ku r5 = (com.facebook.ads.redexgen.X.C0530Ku) r5
            android.content.Intent r10 = (android.content.Intent) r10
            r4 = 112(0x70, float:1.57E-43)
            r1 = 10
            r0 = 79
            java.lang.String r0 = A03(r4, r1, r0)
            java.lang.String r0 = r10.getStringExtra(r0)
            r5.A02 = r0
            r4 = 153(0x99, float:2.14E-43)
            r1 = 11
            r0 = 33
            java.lang.String r0 = A03(r4, r1, r0)
            java.lang.String r0 = r10.getStringExtra(r0)
            r5.A03 = r0
            r4 = 24
            r1 = 11
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r0 = A03(r4, r1, r0)
            long r0 = r10.getLongExtra(r0, r2)
            r5.A00 = r0
            r0 = 5
            goto Lf
        L63:
            com.facebook.ads.redexgen.X.Ku r5 = (com.facebook.ads.redexgen.X.C0530Ku) r5
            android.os.Bundle r11 = (android.os.Bundle) r11
            r4 = 112(0x70, float:1.57E-43)
            r1 = 10
            r0 = 79
            java.lang.String r0 = A03(r4, r1, r0)
            java.lang.String r0 = r11.getString(r0)
            r5.A02 = r0
            r4 = 153(0x99, float:2.14E-43)
            r1 = 11
            r0 = 33
            java.lang.String r0 = A03(r4, r1, r0)
            java.lang.String r0 = r11.getString(r0)
            r5.A03 = r0
            r4 = 24
            r1 = 11
            r0 = 111(0x6f, float:1.56E-43)
            java.lang.String r0 = A03(r4, r1, r0)
            long r0 = r11.getLong(r0, r2)
            r5.A00 = r0
            r0 = 5
            goto Lf
        L9a:
            com.facebook.ads.redexgen.X.Ku r5 = (com.facebook.ads.redexgen.X.C0530Ku) r5
            long r0 = java.lang.System.currentTimeMillis()
            r5.A01 = r0
            r0 = 3
            goto Lf
        La5:
            r4 = 186(0xba, float:2.6E-43)
            r1 = 11
            r0 = 64
            java.lang.String r6 = A03(r4, r1, r0)
            r0 = 7
            goto Lf
        Lb2:
            r0 = 3
            goto Lf
        Lb5:
            com.facebook.ads.redexgen.X.Ku r5 = (com.facebook.ads.redexgen.X.C0530Ku) r5
            java.lang.String r6 = (java.lang.String) r6
            com.facebook.ads.redexgen.X.N3 r0 = r5.A09
            r0.setUrl(r6)
            com.facebook.ads.redexgen.X.NE r0 = r5.A0B
            r0.loadUrl(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0530Ku.A5L(android.content.Intent, android.os.Bundle, com.facebook.ads.redexgen.X.89):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0133, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7F(boolean r7) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0530Ku.A7F(boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A7O(boolean z) {
        this.A0B.onResume();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A8E(Bundle bundle) {
        bundle.putString(A03(112, 10, 79), this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void onDestroy() {
        this.A07.A0K(this.A06);
        NN.A03(this.A0B);
        this.A0B.destroy();
    }
}
