package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/* loaded from: assets/audience_network.dex */
public final class M9 extends ImageView implements QI {
    public static byte[] A05;
    public static final int A06;

    @Nullable
    public C0537Lb A00;
    public final Paint A01;
    public final C0362Ec A02;
    public final C0432Gv A03;
    public final AbstractC02258u A04;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A03(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.M9.A05
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
            r0 = r0 ^ 85
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M9.A03(int, int, int):java.lang.String");
    }

    public static void A06() {
        A05 = new byte[]{24, 32, 33, 48, 117, 20, 49};
    }

    static {
        A06();
        A06 = (int) (4.0f * KE.A01);
    }

    public M9(C0362Ec c0362Ec, C0432Gv c0432Gv) {
        super(c0362Ec);
        this.A04 = new MM(this);
        this.A03 = c0432Gv;
        this.A02 = c0362Ec;
        this.A01 = new Paint();
        this.A01.setColor(-1728053248);
        setColorFilter(-1);
        setPadding(A06, A06, A06, A06);
        setContentDescription(A03(0, 7, 0));
        A05();
        setOnClickListener(new MA(this));
    }

    private void A04() {
        setImageBitmap(KN.A00(KM.SOUND_OFF));
    }

    private void A05() {
        setImageBitmap(KN.A00(KM.SOUND_ON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0024, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A07() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            com.facebook.ads.redexgen.X.Lb r0 = r3.A00
            if (r0 == 0) goto L22
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1c;
                case 4: goto L24;
                case 5: goto L1f;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.M9 r3 = (com.facebook.ads.redexgen.X.M9) r3
            com.facebook.ads.redexgen.X.Lb r0 = r3.A00
            float r1 = r0.getVolume()
            r0 = 0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L1a
            r0 = 3
            goto L7
        L1a:
            r0 = 5
            goto L7
        L1c:
            r2 = 1
            r0 = 4
            goto L7
        L1f:
            r2 = 0
            r0 = 4
            goto L7
        L22:
            r0 = 5
            goto L7
        L24:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M9.A07():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0026, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A09() {
        /*
            r2 = this;
            r1 = r2
            com.facebook.ads.redexgen.X.Lb r0 = r1.A00
            if (r0 != 0) goto L24
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L26;
                case 3: goto La;
                case 4: goto L16;
                case 5: goto L1d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.M9 r1 = (com.facebook.ads.redexgen.X.M9) r1
            boolean r0 = r1.A07()
            if (r0 == 0) goto L14
            r0 = 4
            goto L6
        L14:
            r0 = 5
            goto L6
        L16:
            com.facebook.ads.redexgen.X.M9 r1 = (com.facebook.ads.redexgen.X.M9) r1
            r1.A04()
            r0 = 2
            goto L6
        L1d:
            com.facebook.ads.redexgen.X.M9 r1 = (com.facebook.ads.redexgen.X.M9) r1
            r1.A05()
            r0 = 2
            goto L6
        L24:
            r0 = 3
            goto L6
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.M9.A09():void");
    }

    @Override // com.facebook.ads.redexgen.X.QI
    public final void A5M(C0537Lb c0537Lb) {
        this.A00 = c0537Lb;
        if (this.A00 != null) {
            this.A00.getEventBus().A05(this.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QI
    public final void A8U(C0537Lb c0537Lb) {
        if (this.A00 != null) {
            this.A00.getEventBus().A06(this.A04);
        }
        this.A00 = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(r1, r0), this.A01);
        super.onDraw(canvas);
    }
}
