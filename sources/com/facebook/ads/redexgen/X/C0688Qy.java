package com.facebook.ads.redexgen.X;

import android.media.AudioManager;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.Qy */
/* loaded from: assets/audience_network.dex */
public final class C0688Qy extends QJ {
    public static byte[] A04;
    public WeakReference<AudioManager.OnAudioFocusChangeListener> A00;
    public final AbstractC02238s A01;
    public final AbstractC02198o A02;
    public final AbstractC02178m A03;

    static {
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0688Qy.A04
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
            r0 = r0 ^ 53
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0688Qy.A02(int, int, int):java.lang.String");
    }

    public static void A05() {
        A04 = new byte[]{110, 122, 107, 102, 96};
    }

    public C0688Qy(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A00 = null;
        this.A01 = new C0683Qt(this);
        this.A02 = new C0684Qu(this);
        this.A03 = new C0687Qx(this);
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A09() {
        super.A09();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A03(this.A03, this.A01, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QJ
    public final void A0A() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A02, this.A01, this.A03);
        }
        super.A0A();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:            r1.abandonAudioFocus(r4);        super.onDetachedFromWindow();     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDetachedFromWindow() {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            android.content.Context r0 = r5.getContext()
            android.content.Context r3 = r0.getApplicationContext()
            r2 = 0
            r1 = 5
            r0 = 58
            java.lang.String r0 = A02(r2, r1, r0)
            java.lang.Object r1 = r3.getSystemService(r0)
            android.media.AudioManager r1 = (android.media.AudioManager) r1
            java.lang.ref.WeakReference<android.media.AudioManager$OnAudioFocusChangeListener> r0 = r5.A00
            if (r0 != 0) goto L31
            r0 = 2
        L1e:
            switch(r0) {
                case 2: goto L22;
                case 3: goto L33;
                case 4: goto L25;
                default: goto L21;
            }
        L21:
            goto L1e
        L22:
            r4 = 0
            r0 = 3
            goto L1e
        L25:
            com.facebook.ads.redexgen.X.Qy r5 = (com.facebook.ads.redexgen.X.C0688Qy) r5
            java.lang.ref.WeakReference<android.media.AudioManager$OnAudioFocusChangeListener> r0 = r5.A00
            java.lang.Object r4 = r0.get()
            android.media.AudioManager$OnAudioFocusChangeListener r4 = (android.media.AudioManager.OnAudioFocusChangeListener) r4
            r0 = 3
            goto L1e
        L31:
            r0 = 4
            goto L1e
        L33:
            com.facebook.ads.redexgen.X.Qy r5 = (com.facebook.ads.redexgen.X.C0688Qy) r5
            android.media.AudioManager r1 = (android.media.AudioManager) r1
            r1.abandonAudioFocus(r4)
            super.onDetachedFromWindow()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0688Qy.onDetachedFromWindow():void");
    }
}
