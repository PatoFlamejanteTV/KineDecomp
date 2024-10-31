package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network.dex */
public final class LD extends LC {

    @Nullable
    public AnonymousClass89 A00;

    @Nullable
    public AbstractC0604Nr A01;
    public final AnonymousClass86 A02;
    public final K5 A03;
    public final AnonymousClass29 A04;
    public final FP A05;
    public final AtomicBoolean A06;
    public final AtomicBoolean A07;

    public LD(C0362Ec c0362Ec, C2W c2w, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81) {
        super(c0362Ec, interfaceC0422Gl, anonymousClass81, c2w);
        this.A02 = new L9(this);
        this.A03 = new K5();
        this.A06 = new AtomicBoolean(false);
        this.A07 = new AtomicBoolean(false);
        this.A04 = new LA(this);
        this.A05 = new FP(this, 100, this.A04, c0362Ec);
        this.A05.A0X(c2w.A0F());
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009c, code lost:            r2 = r2;        r2.A01 = com.facebook.ads.redexgen.X.C0607Nu.A01(r4, r13, true, r3);        r2.A08(r2.A01, r2.A01.A0b(), r12);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b3, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(int r12, android.os.Bundle r13) {
        /*
            r11 = this;
            r2 = r11
            r0 = 0
            r0 = 0
            r0 = 0
            r1 = 1
            com.facebook.ads.redexgen.X.2W r0 = r2.A09
            com.facebook.ads.redexgen.X.2L r5 = r0.A0L()
            android.widget.ImageView r8 = new android.widget.ImageView
            android.content.Context r0 = r2.getContext()
            r8.<init>(r0)
            android.widget.ImageView$ScaleType r0 = android.widget.ImageView.ScaleType.CENTER
            r8.setScaleType(r0)
            r8.setAdjustViewBounds(r1)
            com.facebook.ads.redexgen.X.NR r4 = new com.facebook.ads.redexgen.X.NR
            com.facebook.ads.redexgen.X.Ec r0 = r2.A0A
            r4.<init>(r8, r0)
            com.facebook.ads.redexgen.X.2O r0 = r5.A0D()
            int r3 = r0.A00()
            com.facebook.ads.redexgen.X.2O r0 = r5.A0D()
            int r0 = r0.A01()
            com.facebook.ads.redexgen.X.NR r3 = r4.A05(r3, r0)
            com.facebook.ads.redexgen.X.LB r0 = new com.facebook.ads.redexgen.X.LB
            r0.<init>(r2)
            r3.A06(r0)
            com.facebook.ads.redexgen.X.2O r0 = r5.A0D()
            java.lang.String r0 = r0.A06()
            r3.A07(r0)
            com.facebook.ads.redexgen.X.Nw r3 = new com.facebook.ads.redexgen.X.Nw
            com.facebook.ads.redexgen.X.Ec r4 = r2.A0A
            com.facebook.ads.redexgen.X.Gl r5 = r2.A0B
            com.facebook.ads.redexgen.X.81 r6 = r2.getAudienceNetworkListener()
            com.facebook.ads.redexgen.X.2W r7 = r2.A09
            com.facebook.ads.redexgen.X.FP r9 = r2.A05
            com.facebook.ads.redexgen.X.K5 r10 = r2.A03
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r2.A0D
            int r0 = r0.getToolbarHeight()
            com.facebook.ads.redexgen.X.Nw r0 = r3.A0D(r0)
            com.facebook.ads.redexgen.X.Nw r3 = r0.A0C(r12)
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r2.A0D
            com.facebook.ads.redexgen.X.Nw r0 = r3.A0F(r0)
            com.facebook.ads.redexgen.X.Nx r4 = r0.A0H()
            r3 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
            if (r0 == 0) goto L9a
            r0 = 2
        L7b:
            switch(r0) {
                case 2: goto L7f;
                case 3: goto L91;
                case 4: goto L9c;
                default: goto L7e;
            }
        L7e:
            goto L7b
        L7f:
            com.facebook.ads.redexgen.X.LD r2 = (com.facebook.ads.redexgen.X.LD) r2
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
            boolean r3 = r0.A0a()
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
            boolean r0 = r0 instanceof com.facebook.ads.redexgen.X.OD
            if (r0 != 0) goto L8f
            r0 = 3
            goto L7b
        L8f:
            r0 = 4
            goto L7b
        L91:
            com.facebook.ads.redexgen.X.LD r2 = (com.facebook.ads.redexgen.X.LD) r2
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
            r0.A0U()
            r0 = 4
            goto L7b
        L9a:
            r0 = 4
            goto L7b
        L9c:
            com.facebook.ads.redexgen.X.LD r2 = (com.facebook.ads.redexgen.X.LD) r2
            android.os.Bundle r13 = (android.os.Bundle) r13
            com.facebook.ads.redexgen.X.Nx r4 = (com.facebook.ads.redexgen.X.C0610Nx) r4
            com.facebook.ads.redexgen.X.Nr r0 = com.facebook.ads.redexgen.X.C0607Nu.A01(r4, r13, r1, r3)
            r2.A01 = r0
            com.facebook.ads.redexgen.X.Nr r1 = r2.A01
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
            boolean r0 = r0.A0b()
            r2.A08(r1, r0, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LD.A07(int, android.os.Bundle):void");
    }

    @Override // com.facebook.ads.redexgen.X.LC
    public final void A0S() {
        this.A06.set(true);
        if (this.A07.get()) {
            this.A05.A0V();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0020, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.LC
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0T() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
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
            com.facebook.ads.redexgen.X.LD r2 = (com.facebook.ads.redexgen.X.LD) r2
            r1 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LD.A0T():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A5L(Intent intent, Bundle bundle, AnonymousClass89 anonymousClass89) {
        super.A0A(anonymousClass89);
        this.A00 = anonymousClass89;
        this.A00.A0J(this.A02);
        A07(anonymousClass89.A0H().getResources().getConfiguration().orientation, bundle);
        int A03 = this.A09.A0L().A0D().A03();
        if (A03 > 0) {
            A07(A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A8E(Bundle bundle) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r1;     */
    @Override // com.facebook.ads.redexgen.X.LC
    @com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getCloseButtonStyle() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
            if (r0 != 0) goto L18
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1a;
                case 4: goto Le;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r1 = 0
            r0 = 3
            goto L7
        Le:
            com.facebook.ads.redexgen.X.LD r2 = (com.facebook.ads.redexgen.X.LD) r2
            com.facebook.ads.redexgen.X.Nr r0 = r2.A01
            int r1 = r0.getCloseButtonStyle()
            r0 = 3
            goto L7
        L18:
            r0 = 4
            goto L7
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LD.getCloseButtonStyle():int");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        removeAllViews();
        A07(configuration.orientation, bundle);
        super.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:            r4 = r4;        r4.A00 = null;        super.onDestroy();     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.LC, com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r5 = this;
            r4 = r5
            com.facebook.ads.redexgen.X.2W r0 = r4.A09
            if (r0 == 0) goto L58
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1c;
                case 4: goto L40;
                case 5: goto L4f;
                case 6: goto L5a;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.LD r4 = (com.facebook.ads.redexgen.X.LD) r4
            com.facebook.ads.redexgen.X.2W r0 = r4.A09
            java.lang.String r0 = r0.A0P()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1a
            r0 = 3
            goto L6
        L1a:
            r0 = 4
            goto L6
        L1c:
            com.facebook.ads.redexgen.X.LD r4 = (com.facebook.ads.redexgen.X.LD) r4
            com.facebook.ads.redexgen.X.Gl r3 = r4.A0B
            com.facebook.ads.redexgen.X.2W r0 = r4.A09
            java.lang.String r2 = r0.A0P()
            com.facebook.ads.redexgen.X.NS r1 = new com.facebook.ads.redexgen.X.NS
            r1.<init>()
            com.facebook.ads.redexgen.X.FP r0 = r4.A05
            com.facebook.ads.redexgen.X.NS r1 = r1.A03(r0)
            com.facebook.ads.redexgen.X.K5 r0 = r4.A03
            com.facebook.ads.redexgen.X.NS r0 = r1.A02(r0)
            java.util.Map r0 = r0.A05()
            r3.A5U(r2, r0)
            r0 = 4
            goto L6
        L40:
            com.facebook.ads.redexgen.X.LD r4 = (com.facebook.ads.redexgen.X.LD) r4
            com.facebook.ads.redexgen.X.FP r0 = r4.A05
            r0.A0W()
            com.facebook.ads.redexgen.X.Nr r0 = r4.A01
            if (r0 == 0) goto L4d
            r0 = 5
            goto L6
        L4d:
            r0 = 6
            goto L6
        L4f:
            com.facebook.ads.redexgen.X.LD r4 = (com.facebook.ads.redexgen.X.LD) r4
            com.facebook.ads.redexgen.X.Nr r0 = r4.A01
            r0.A0U()
            r0 = 6
            goto L6
        L58:
            r0 = 4
            goto L6
        L5a:
            com.facebook.ads.redexgen.X.LD r4 = (com.facebook.ads.redexgen.X.LD) r4
            r0 = 0
            r4.A00 = r0
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LD.onDestroy():void");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A03.A06(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
