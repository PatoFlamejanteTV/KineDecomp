package com.facebook.ads.redexgen.X;

import android.widget.Button;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.Nb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0588Nb extends Button {
    public static final int A0A = (int) (16.0f * KE.A01);
    public static final int A0B = (int) (4.0f * KE.A01);
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final float A04;
    public final int A05;
    public final C2T A06;
    public final Runnable A07;
    public final Runnable A08;
    public final Runnable A09;

    public C0588Nb(C0362Ec c0362Ec, C2T c2t) {
        super(c0362Ec);
        this.A01 = 0;
        this.A00 = 0;
        this.A02 = true;
        this.A03 = false;
        this.A07 = new C0591Ne(this);
        this.A09 = new C0592Nf(this);
        this.A08 = new C0593Ng(this);
        this.A06 = c2t;
        this.A05 = C0413Gc.A03(c0362Ec);
        this.A04 = C0413Gc.A00(c0362Ec);
        KE.A0Y(this, false, 16);
        setGravity(17);
        A04();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0039, code lost:            r4 = r4;        com.facebook.ads.redexgen.X.KE.A0R(r4, r2, r3);        r4.setTextColor(r4.A01);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            com.facebook.ads.redexgen.X.2T r0 = r4.A06
            if (r0 == 0) goto L37
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L24;
                case 4: goto L30;
                case 5: goto L39;
                case 6: goto L34;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Nb r4 = (com.facebook.ads.redexgen.X.C0588Nb) r4
            com.facebook.ads.redexgen.X.2T r1 = r4.A06
            boolean r0 = r4.A03
            int r0 = r1.A08(r0)
            r4.A00 = r0
            com.facebook.ads.redexgen.X.2T r1 = r4.A06
            boolean r0 = r4.A03
            int r0 = r1.A09(r0)
            r4.A01 = r0
            r0 = 3
            goto L8
        L24:
            com.facebook.ads.redexgen.X.Nb r4 = (com.facebook.ads.redexgen.X.C0588Nb) r4
            int r2 = r4.A00
            boolean r0 = r4.A02
            if (r0 == 0) goto L2e
            r0 = 4
            goto L8
        L2e:
            r0 = 6
            goto L8
        L30:
            int r3 = com.facebook.ads.redexgen.X.C0588Nb.A0B
            r0 = 5
            goto L8
        L34:
            r3 = 0
            r0 = 5
            goto L8
        L37:
            r0 = 3
            goto L8
        L39:
            com.facebook.ads.redexgen.X.Nb r4 = (com.facebook.ads.redexgen.X.C0588Nb) r4
            com.facebook.ads.redexgen.X.KE.A0R(r4, r2, r3)
            int r0 = r4.A01
            r4.setTextColor(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0588Nb.A04():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x003e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A05() {
        /*
            r4 = this;
            r3 = r4
            int r0 = r3.A05
            if (r0 >= 0) goto L3c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L3e;
                case 3: goto La;
                case 4: goto L1a;
                case 5: goto L24;
                case 6: goto L30;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.Nb r3 = (com.facebook.ads.redexgen.X.C0588Nb) r3
            android.content.Context r0 = r3.getContext()
            boolean r0 = com.facebook.ads.redexgen.X.C0413Gc.A19(r0)
            if (r0 == 0) goto L18
            r0 = 4
            goto L6
        L18:
            r0 = 6
            goto L6
        L1a:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r1 < r0) goto L22
            r0 = 5
            goto L6
        L22:
            r0 = 2
            goto L6
        L24:
            com.facebook.ads.redexgen.X.Nb r3 = (com.facebook.ads.redexgen.X.C0588Nb) r3
            java.lang.Runnable r2 = r3.A07
            int r0 = r3.A05
            long r0 = (long) r0
            r3.postDelayed(r2, r0)
            r0 = 2
            goto L6
        L30:
            com.facebook.ads.redexgen.X.Nb r3 = (com.facebook.ads.redexgen.X.C0588Nb) r3
            java.lang.Runnable r2 = r3.A08
            int r0 = r3.A05
            long r0 = (long) r0
            r3.postDelayed(r2, r0)
            r0 = 2
            goto L6
        L3c:
            r0 = 3
            goto L6
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0588Nb.A05():void");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        A05();
    }

    public void setRoundedCornersEnabled(boolean z) {
        this.A02 = z;
        A04();
    }

    public void setText(String str) {
        super.setText((CharSequence) str.toUpperCase(Locale.US));
    }

    public void setViewShowsOverMedia(boolean z) {
        this.A03 = z;
        A04();
    }
}
