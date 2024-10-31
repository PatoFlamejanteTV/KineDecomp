package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

/* renamed from: com.facebook.ads.redexgen.X.On, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0625On extends FrameLayout implements InterfaceC0524Ko {
    public static final RelativeLayout.LayoutParams A0D = new RelativeLayout.LayoutParams(-1, -1);
    public boolean A00;
    public final C2I A01;
    public final EV A02;
    public final C0362Ec A03;
    public final InterfaceC0422Gl A04;
    public final C0432Gv A05;
    public final K5 A06;
    public final AnonymousClass81 A07;
    public final FullScreenAdToolbar A08;
    public final MQ A09;
    public final FP A0A;
    public final ViewOnSystemUiVisibilityChangeListenerC0509Jz A0B;
    public final AnonymousClass29 A0C;

    public abstract void A0N();

    public abstract void A0O(AnonymousClass89 anonymousClass89);

    public abstract boolean A0P();

    public AbstractC0625On(C0362Ec c0362Ec, MQ mq, InterfaceC0422Gl interfaceC0422Gl, C2I c2i, EV ev, AnonymousClass81 anonymousClass81) {
        super(c0362Ec);
        this.A0C = new C0621Oj(this);
        this.A06 = new K5();
        this.A00 = false;
        this.A03 = c0362Ec;
        this.A09 = mq;
        this.A04 = interfaceC0422Gl;
        this.A01 = c2i;
        this.A02 = ev;
        this.A07 = anonymousClass81;
        this.A05 = new C0432Gv(this.A01.A0P(), this.A04);
        this.A0A = new FP(this, 1, this.A0C, this.A03);
        this.A0A.A0X(this.A01.A0F());
        this.A0A.A0Y(this.A01.A0G());
        this.A08 = A00();
        this.A0B = new ViewOnSystemUiVisibilityChangeListenerC0509Jz(this);
        this.A0B.A05(EnumC0508Jy.A02);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0067, code lost:            r5 = r5;        r5.setToolbarListener(new com.facebook.ads.redexgen.X.C0624Om(r1));     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.internal.view.FullScreenAdToolbar A00() {
        /*
            r11 = this;
            r1 = r11
            r0 = 0
            r9 = 1
            com.facebook.ads.internal.view.FullScreenAdToolbar r5 = new com.facebook.ads.internal.view.FullScreenAdToolbar
            com.facebook.ads.redexgen.X.Ec r6 = r1.A03
            com.facebook.ads.redexgen.X.81 r7 = r1.A07
            com.facebook.ads.redexgen.X.Gv r8 = r1.A05
            com.facebook.ads.redexgen.X.2I r0 = r1.A01
            int r10 = r0.A0D()
            r5.<init>(r6, r7, r8, r9, r10)
            com.facebook.ads.redexgen.X.2I r0 = r1.A01
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            int r4 = r0.A03()
            com.facebook.ads.redexgen.X.2I r0 = r1.A01
            com.facebook.ads.redexgen.X.2c r3 = r0.A0N()
            com.facebook.ads.redexgen.X.2I r0 = r1.A01
            java.lang.String r2 = r0.A0P()
            com.facebook.ads.redexgen.X.2I r0 = r1.A01
            com.facebook.ads.redexgen.X.2k r0 = r0.A0O()
            r5.setPageDetails(r3, r2, r4, r0)
            com.facebook.ads.redexgen.X.2I r0 = r1.A01
            com.facebook.ads.redexgen.X.2J r0 = r0.A0K()
            com.facebook.ads.redexgen.X.2T r0 = r0.A01()
            r5.A04(r0, r9)
            if (r4 >= 0) goto L65
            r0 = 2
        L47:
            switch(r0) {
                case 2: goto L4b;
                case 3: goto L5d;
                case 4: goto L67;
                default: goto L4a;
            }
        L4a:
            goto L47
        L4b:
            com.facebook.ads.redexgen.X.On r1 = (com.facebook.ads.redexgen.X.AbstractC0625On) r1
            com.facebook.ads.redexgen.X.2I r0 = r1.A01
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            boolean r0 = r0.A0K()
            if (r0 == 0) goto L5b
            r0 = 3
            goto L47
        L5b:
            r0 = 4
            goto L47
        L5d:
            com.facebook.ads.internal.view.FullScreenAdToolbar r5 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r5
            r0 = 4
            r5.setToolbarActionMode(r0)
            r0 = 4
            goto L47
        L65:
            r0 = 4
            goto L47
        L67:
            com.facebook.ads.redexgen.X.On r1 = (com.facebook.ads.redexgen.X.AbstractC0625On) r1
            com.facebook.ads.internal.view.FullScreenAdToolbar r5 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r5
            com.facebook.ads.redexgen.X.Om r0 = new com.facebook.ads.redexgen.X.Om
            r0.<init>(r1)
            r5.setToolbarListener(r0)
            com.facebook.ads.internal.view.FullScreenAdToolbar r5 = (com.facebook.ads.internal.view.FullScreenAdToolbar) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0625On.A00():com.facebook.ads.internal.view.FullScreenAdToolbar");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            r5 = this;
            r3 = r5
            com.facebook.ads.redexgen.X.2I r0 = r3.A01
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            boolean r0 = r0.A0O()
            if (r0 == 0) goto L5a
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L5c;
                case 4: goto L53;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            com.facebook.ads.redexgen.X.On r3 = (com.facebook.ads.redexgen.X.AbstractC0625On) r3
            com.facebook.ads.redexgen.X.Ou r4 = new com.facebook.ads.redexgen.X.Ou
            com.facebook.ads.redexgen.X.Ec r2 = r3.A03
            com.facebook.ads.redexgen.X.2I r0 = r3.A01
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2S r1 = r0.A0E()
            com.facebook.ads.redexgen.X.2I r0 = r3.A01
            com.facebook.ads.redexgen.X.2c r0 = r0.A0N()
            r4.<init>(r2, r1, r0)
            com.facebook.ads.redexgen.X.2I r0 = r3.A01
            com.facebook.ads.redexgen.X.2J r0 = r0.A0K()
            com.facebook.ads.redexgen.X.2T r0 = r0.A01()
            com.facebook.ads.redexgen.X.Ou r0 = r4.A08(r0)
            com.facebook.ads.redexgen.X.Ov r2 = r0.A0B()
            com.facebook.ads.redexgen.X.Gv r1 = r3.A05
            com.facebook.ads.redexgen.X.Gu r0 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0T
            com.facebook.ads.redexgen.X.C0434Gx.A04(r2, r1, r0)
            android.widget.RelativeLayout$LayoutParams r0 = com.facebook.ads.redexgen.X.AbstractC0625On.A0D
            r3.addView(r2, r0)
            com.facebook.ads.redexgen.X.Ol r0 = new com.facebook.ads.redexgen.X.Ol
            r0.<init>(r3)
            r2.A04(r0)
            r0 = 3
            goto Le
        L53:
            com.facebook.ads.redexgen.X.On r3 = (com.facebook.ads.redexgen.X.AbstractC0625On) r3
            r3.A0N()
            r0 = 3
            goto Le
        L5a:
            r0 = 4
            goto Le
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC0625On.A01():void");
    }

    public final void A02() {
        if (!this.A00) {
            this.A0A.A0V();
            this.A00 = true;
        }
    }

    public final void A03(int i, AbstractRunnableC00351g abstractRunnableC00351g) {
        new JW(i, new C0622Ok(this, i, abstractRunnableC00351g)).A07();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A5L(Intent intent, @Nullable Bundle bundle, AnonymousClass89 anonymousClass89) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.A0B.A05(EnumC0508Jy.A03);
        }
        this.A07.A39(this, A0D);
        A0O(anonymousClass89);
        A01();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A8E(Bundle bundle) {
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public void onDestroy() {
        this.A0B.A03();
        if (!TextUtils.isEmpty(this.A01.A0P())) {
            this.A04.A5U(this.A01.A0P(), new NS().A03(this.A0A).A02(this.A06).A05());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A06.A06(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(AnonymousClass81 anonymousClass81) {
    }
}
