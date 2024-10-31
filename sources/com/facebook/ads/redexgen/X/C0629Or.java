package com.facebook.ads.redexgen.X;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Or, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0629Or extends AbstractC0625On {

    @Nullable
    public AbstractC0604Nr A00;
    public final AnonymousClass86 A01;
    public final AtomicBoolean A02;
    public final AtomicBoolean A03;
    public final AtomicBoolean A04;

    public C0629Or(C0362Ec c0362Ec, MQ mq, InterfaceC0422Gl interfaceC0422Gl, C2I c2i, EV ev, AnonymousClass81 anonymousClass81) {
        super(c0362Ec, mq, interfaceC0422Gl, c2i, ev, anonymousClass81);
        this.A01 = new C0626Oo(this);
        this.A03 = new AtomicBoolean(false);
        this.A02 = new AtomicBoolean(false);
        this.A04 = new AtomicBoolean(false);
    }

    private AbstractC0604Nr A01(int i) {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setAdjustViewBounds(true);
        new NR(imageView, super.A03).A05(super.A01.A0L().A0D().A00(), super.A01.A0L().A0D().A01()).A06(new C0628Oq(this)).A07(super.A01.A0L().A0D().A06());
        return C0607Nu.A00(new C0609Nw(super.A03, super.A04, this.A07, super.A01, imageView, this.A0A, this.A06).A0D(this.A08.getToolbarHeight()).A0F(this.A08).A0C(i).A0H(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A05() {
        /*
            r2 = this;
            r1 = r2
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.A03
            boolean r0 = r0.get()
            if (r0 == 0) goto L23
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1c;
                case 4: goto L25;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Or r1 = (com.facebook.ads.redexgen.X.C0629Or) r1
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.A02
            boolean r0 = r0.get()
            if (r0 == 0) goto L1a
            r0 = 3
            goto La
        L1a:
            r0 = 4
            goto La
        L1c:
            com.facebook.ads.redexgen.X.Or r1 = (com.facebook.ads.redexgen.X.C0629Or) r1
            r1.A02()
            r0 = 4
            goto La
        L23:
            r0 = 4
            goto La
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0629Or.A05():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x005e, code lost:            r3 = r3;        r4 = r4;        com.facebook.ads.redexgen.X.KE.A0P(r3, r4.A07(r1));        r3.A08.A04(r4, r3.A00.A0b());        r3.addView(r3.A00, 0, com.facebook.ads.redexgen.X.AbstractC0625On.A0D);     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(int r6) {
        /*
            r5 = this;
            r3 = r5
            r4 = 0
            r0 = 0
            r0 = 0
            r1 = 1
            r0 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r3.A00
            com.facebook.ads.redexgen.X.KE.A0L(r0)
            com.facebook.ads.redexgen.X.Nr r0 = r3.A01(r6)
            r3.A00 = r0
            if (r6 != r1) goto L5b
            r0 = 2
        L14:
            switch(r0) {
                case 2: goto L24;
                case 3: goto L40;
                case 4: goto L32;
                case 5: goto L18;
                case 6: goto L5e;
                case 7: goto L4a;
                case 8: goto L4d;
                default: goto L17;
            }
        L17:
            goto L14
        L18:
            com.facebook.ads.redexgen.X.Or r3 = (com.facebook.ads.redexgen.X.C0629Or) r3
            com.facebook.ads.redexgen.X.Nr r0 = r3.A00
            boolean r0 = r0 instanceof com.facebook.ads.redexgen.X.AbstractC0605Ns
            if (r0 == 0) goto L22
            r0 = 6
            goto L14
        L22:
            r0 = 7
            goto L14
        L24:
            com.facebook.ads.redexgen.X.Or r3 = (com.facebook.ads.redexgen.X.C0629Or) r3
            com.facebook.ads.redexgen.X.2I r0 = r3.A01
            com.facebook.ads.redexgen.X.2J r0 = r0.A0K()
            com.facebook.ads.redexgen.X.2T r4 = r0.A01()
            r0 = 3
            goto L14
        L32:
            com.facebook.ads.redexgen.X.Or r3 = (com.facebook.ads.redexgen.X.C0629Or) r3
            com.facebook.ads.redexgen.X.Nr r0 = r3.A00
            boolean r0 = r0.A0b()
            if (r0 != 0) goto L3e
            r0 = 5
            goto L14
        L3e:
            r0 = 6
            goto L14
        L40:
            com.facebook.ads.redexgen.X.Or r3 = (com.facebook.ads.redexgen.X.C0629Or) r3
            com.facebook.ads.redexgen.X.Nr r0 = r3.A00
            if (r0 == 0) goto L48
            r0 = 4
            goto L14
        L48:
            r0 = 7
            goto L14
        L4a:
            r1 = 0
            r0 = 6
            goto L14
        L4d:
            com.facebook.ads.redexgen.X.Or r3 = (com.facebook.ads.redexgen.X.C0629Or) r3
            com.facebook.ads.redexgen.X.2I r0 = r3.A01
            com.facebook.ads.redexgen.X.2J r0 = r0.A0K()
            com.facebook.ads.redexgen.X.2T r4 = r0.A00()
            r0 = 3
            goto L14
        L5b:
            r0 = 8
            goto L14
        L5e:
            com.facebook.ads.redexgen.X.Or r3 = (com.facebook.ads.redexgen.X.C0629Or) r3
            com.facebook.ads.redexgen.X.2T r4 = (com.facebook.ads.redexgen.X.C2T) r4
            r2 = 0
            int r0 = r4.A07(r1)
            com.facebook.ads.redexgen.X.KE.A0P(r3, r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = r3.A08
            com.facebook.ads.redexgen.X.Nr r0 = r3.A00
            boolean r0 = r0.A0b()
            r1.A04(r4, r0)
            com.facebook.ads.redexgen.X.Nr r1 = r3.A00
            android.widget.RelativeLayout$LayoutParams r0 = com.facebook.ads.redexgen.X.AbstractC0625On.A0D
            r3.addView(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0629Or.A06(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0625On
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0N() {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r3 = 1
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            com.facebook.ads.redexgen.X.KE.A0O(r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r4.A08
            com.facebook.ads.redexgen.X.KE.A0O(r0)
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.A02
            r0.set(r3)
            r4.A05()
            com.facebook.ads.redexgen.X.2I r0 = r4.A01
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            int r2 = r0.A03()
            if (r2 <= 0) goto L5c
            r0 = 2
        L27:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L35;
                case 4: goto L3e;
                case 5: goto L5e;
                case 6: goto L4a;
                default: goto L2a;
            }
        L2a:
            goto L27
        L2b:
            com.facebook.ads.redexgen.X.Or r4 = (com.facebook.ads.redexgen.X.C0629Or) r4
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            if (r0 == 0) goto L33
            r0 = 3
            goto L27
        L33:
            r0 = 4
            goto L27
        L35:
            com.facebook.ads.redexgen.X.Or r4 = (com.facebook.ads.redexgen.X.C0629Or) r4
            com.facebook.ads.redexgen.X.Nr r0 = r4.A00
            r0.A0Y()
            r0 = 4
            goto L27
        L3e:
            com.facebook.ads.redexgen.X.Or r4 = (com.facebook.ads.redexgen.X.C0629Or) r4
            com.facebook.ads.redexgen.X.Op r0 = new com.facebook.ads.redexgen.X.Op
            r0.<init>(r4)
            r4.A03(r2, r0)
            r0 = 5
            goto L27
        L4a:
            com.facebook.ads.redexgen.X.Or r4 = (com.facebook.ads.redexgen.X.C0629Or) r4
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.A04
            r0.set(r3)
            com.facebook.ads.internal.view.FullScreenAdToolbar r1 = r4.A08
            int r0 = r4.getCloseButtonStyle()
            r1.setToolbarActionMode(r0)
            r0 = 5
            goto L27
        L5c:
            r0 = 6
            goto L27
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0629Or.A0N():void");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0625On
    public final void A0O(AnonymousClass89 anonymousClass89) {
        anonymousClass89.A0J(this.A01);
        A06(anonymousClass89.A0H().getResources().getConfiguration().orientation);
        addView(this.A08, new FrameLayout.LayoutParams(-1, this.A08.getToolbarHeight()));
        KE.A0J(this.A00);
        KE.A0J(this.A08);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0020, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0625On
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0P() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r2.A00
            if (r0 == 0) goto L1e
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1b;
                case 4: goto L20;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Or r2 = (com.facebook.ads.redexgen.X.C0629Or) r2
            r1 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r2.A00
            boolean r0 = r0.A0c(r1)
            if (r0 == 0) goto L19
            r0 = 3
            goto L8
        L19:
            r0 = 4
            goto L8
        L1b:
            r1 = 1
            r0 = 4
            goto L8
        L1e:
            r0 = 4
            goto L8
        L20:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0629Or.A0P():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A7F(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A7O(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getCloseButtonStyle() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r2.A00
            if (r0 == 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto L15;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.Or r2 = (com.facebook.ads.redexgen.X.C0629Or) r2
            com.facebook.ads.redexgen.X.Nr r0 = r2.A00
            int r1 = r0.getCloseButtonStyle()
            r0 = 3
            goto L7
        L15:
            r1 = 0
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0629Or.getCloseButtonStyle():int");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0625On, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A06(configuration.orientation);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0625On, com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void onDestroy() {
        if (this.A00 != null) {
            this.A00.A0U();
        }
        super.onDestroy();
    }
}
