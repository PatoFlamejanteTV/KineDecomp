package com.facebook.ads.redexgen.X;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Gr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0428Gr implements InterfaceC0452Hp {
    public TransitionDrawable A00;
    public TransitionDrawable A01;
    public final int A03;
    public final Drawable A04;
    public final Drawable A05;
    public final View A07;
    public final Handler A06 = new Handler();
    public EnumC0459Hy A02 = EnumC0459Hy.A04;

    public C0428Gr(View view, int i, Drawable drawable, Drawable drawable2) {
        this.A03 = i;
        this.A07 = view;
        this.A05 = drawable;
        this.A04 = drawable2;
        this.A01 = new TransitionDrawable(new Drawable[]{drawable, drawable2});
        this.A01.setCrossFadeEnabled(true);
        this.A00 = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        this.A00.setCrossFadeEnabled(true);
        KE.A0T(this.A07, this.A01);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04(boolean r6) {
        /*
            r5 = this;
            r4 = r5
            android.os.Handler r1 = r4.A06
            r0 = 0
            r1.removeCallbacksAndMessages(r0)
            if (r6 == 0) goto L40
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L42;
                case 4: goto L31;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Gr r4 = (com.facebook.ads.redexgen.X.C0428Gr) r4
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A05
            r4.A02 = r0
            android.view.View r1 = r4.A07
            android.graphics.drawable.TransitionDrawable r0 = r4.A00
            com.facebook.ads.redexgen.X.KE.A0T(r1, r0)
            android.graphics.drawable.TransitionDrawable r1 = r4.A00
            int r0 = r4.A03
            r1.startTransition(r0)
            android.os.Handler r3 = r4.A06
            com.facebook.ads.redexgen.X.Gt r2 = new com.facebook.ads.redexgen.X.Gt
            r2.<init>(r4)
            int r0 = r4.A03
            long r0 = (long) r0
            r3.postDelayed(r2, r0)
            r0 = 3
            goto La
        L31:
            com.facebook.ads.redexgen.X.Gr r4 = (com.facebook.ads.redexgen.X.C0428Gr) r4
            android.view.View r1 = r4.A07
            android.graphics.drawable.Drawable r0 = r4.A05
            com.facebook.ads.redexgen.X.KE.A0T(r1, r0)
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A04
            r4.A02 = r0
            r0 = 3
            goto La
        L40:
            r0 = 4
            goto La
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0428Gr.A04(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A05(boolean r6) {
        /*
            r5 = this;
            r4 = r5
            android.os.Handler r1 = r4.A06
            r0 = 0
            r1.removeCallbacksAndMessages(r0)
            if (r6 == 0) goto L40
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L42;
                case 4: goto L31;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Gr r4 = (com.facebook.ads.redexgen.X.C0428Gr) r4
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A03
            r4.A02 = r0
            android.view.View r1 = r4.A07
            android.graphics.drawable.TransitionDrawable r0 = r4.A01
            com.facebook.ads.redexgen.X.KE.A0T(r1, r0)
            android.graphics.drawable.TransitionDrawable r1 = r4.A01
            int r0 = r4.A03
            r1.startTransition(r0)
            android.os.Handler r3 = r4.A06
            com.facebook.ads.redexgen.X.H2 r2 = new com.facebook.ads.redexgen.X.H2
            r2.<init>(r4)
            int r0 = r4.A03
            long r0 = (long) r0
            r3.postDelayed(r2, r0)
            r0 = 3
            goto La
        L31:
            com.facebook.ads.redexgen.X.Gr r4 = (com.facebook.ads.redexgen.X.C0428Gr) r4
            android.view.View r1 = r4.A07
            android.graphics.drawable.Drawable r0 = r4.A04
            com.facebook.ads.redexgen.X.KE.A0T(r1, r0)
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A02
            r4.A02 = r0
            r0 = 3
            goto La
        L40:
            r0 = 4
            goto La
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0428Gr.A05(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0452Hp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A3A(boolean r3, boolean r4) {
        /*
            r2 = this;
            r1 = r2
            if (r4 == 0) goto L16
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L18;
                case 4: goto Lf;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.Gr r1 = (com.facebook.ads.redexgen.X.C0428Gr) r1
            r1.A04(r3)
            r0 = 3
            goto L4
        Lf:
            com.facebook.ads.redexgen.X.Gr r1 = (com.facebook.ads.redexgen.X.C0428Gr) r1
            r1.A05(r3)
            r0 = 3
            goto L4
        L16:
            r0 = 4
            goto L4
        L18:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0428Gr.A3A(boolean, boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0452Hp
    public final EnumC0459Hy A4x() {
        return this.A02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:            r3.A02 = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0452Hp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void cancel() {
        /*
            r3 = this;
            r2 = 0
            android.os.Handler r1 = r3.A06
            r0 = 0
            r1.removeCallbacksAndMessages(r0)
            android.graphics.drawable.TransitionDrawable r0 = r3.A01
            r0.resetTransition()
            android.graphics.drawable.TransitionDrawable r0 = r3.A00
            r0.resetTransition()
            com.facebook.ads.redexgen.X.Hy r1 = r3.A02
            com.facebook.ads.redexgen.X.Hy r0 = com.facebook.ads.redexgen.X.EnumC0459Hy.A03
            if (r1 != r0) goto L24
            r0 = 2
        L18:
            switch(r0) {
                case 2: goto L1c;
                case 3: goto L26;
                case 4: goto L20;
                default: goto L1b;
            }
        L1b:
            goto L18
        L1c:
            com.facebook.ads.redexgen.X.Hy r2 = com.facebook.ads.redexgen.X.EnumC0459Hy.A04
            r0 = 3
            goto L18
        L20:
            com.facebook.ads.redexgen.X.Hy r2 = com.facebook.ads.redexgen.X.EnumC0459Hy.A02
            r0 = 3
            goto L18
        L24:
            r0 = 4
            goto L18
        L26:
            r0 = r3
            com.facebook.ads.redexgen.X.Gr r0 = (com.facebook.ads.redexgen.X.C0428Gr) r0
            com.facebook.ads.redexgen.X.Hy r2 = (com.facebook.ads.redexgen.X.EnumC0459Hy) r2
            r0.A02 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0428Gr.cancel():void");
    }
}
