package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Lb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0537Lb extends RelativeLayout implements LY, LZ, InterfaceC0536La {
    public int A00;
    public C0432Gv A01;
    public QF A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final Handler A07;
    public final Handler A08;
    public final View.OnTouchListener A09;
    public final C0362Ec A0A;
    public final GY<C1S, GX> A0B;
    public final List<QI> A0C;
    public final FT A0D;
    public static final QS A0G = new QS();
    public static final QN A0E = new QN();
    public static final QV A0H = new QV();
    public static final QW A0I = new QW();
    public static final QR A0F = new QR();
    public static final QZ A0J = new QZ();
    public static final C0665Qb A0L = new C0665Qb();
    public static final C0664Qa A0K = new C0664Qa();

    public C0537Lb(C0362Ec c0362Ec) {
        super(c0362Ec);
        this.A0C = new ArrayList();
        this.A07 = new Handler();
        this.A08 = new Handler();
        this.A0B = new GY<>();
        this.A05 = false;
        this.A06 = true;
        this.A00 = 200;
        this.A09 = new ViewOnTouchListenerC0658Pu(this);
        this.A0A = c0362Ec;
        this.A0D = new FS(c0362Ec);
        A09();
    }

    public C0537Lb(C0362Ec c0362Ec, AttributeSet attributeSet) {
        super(c0362Ec, attributeSet);
        this.A0C = new ArrayList();
        this.A07 = new Handler();
        this.A08 = new Handler();
        this.A0B = new GY<>();
        this.A05 = false;
        this.A06 = true;
        this.A00 = 200;
        this.A09 = new ViewOnTouchListenerC0658Pu(this);
        this.A0A = c0362Ec;
        this.A0D = new FS(c0362Ec, attributeSet);
        A09();
    }

    public C0537Lb(C0362Ec c0362Ec, AttributeSet attributeSet, int i) {
        super(c0362Ec, attributeSet, i);
        this.A0C = new ArrayList();
        this.A07 = new Handler();
        this.A08 = new Handler();
        this.A0B = new GY<>();
        this.A05 = false;
        this.A06 = true;
        this.A00 = 200;
        this.A09 = new ViewOnTouchListenerC0658Pu(this);
        this.A0A = c0362Ec;
        this.A0D = new FS(c0362Ec, attributeSet, i);
        A09();
    }

    private void A09() {
        this.A0D.setRequestedVolume(1.0f);
        this.A0D.setVideoStateChangeListener(this);
        this.A02 = new QF(this.A0A, this.A0D);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
        setOnTouchListener(this.A09);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        this.A07.postDelayed(new C0655Pr(this), this.A00);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0B() {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            java.util.List<com.facebook.ads.redexgen.X.QI> r0 = r3.A0C
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1a;
                case 4: goto L2a;
                case 5: goto L36;
                case 6: goto L3f;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L18
            r0 = 3
            goto La
        L18:
            r0 = 6
            goto La
        L1a:
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r1.next()
            com.facebook.ads.redexgen.X.QI r2 = (com.facebook.ads.redexgen.X.QI) r2
            boolean r0 = r2 instanceof com.facebook.ads.redexgen.X.QJ
            if (r0 == 0) goto L28
            r0 = 4
            goto La
        L28:
            r0 = 5
            goto La
        L2a:
            com.facebook.ads.redexgen.X.Lb r3 = (com.facebook.ads.redexgen.X.C0537Lb) r3
            com.facebook.ads.redexgen.X.QI r2 = (com.facebook.ads.redexgen.X.QI) r2
            r0 = r2
            com.facebook.ads.redexgen.X.QJ r0 = (com.facebook.ads.redexgen.X.QJ) r0
            r3.A0G(r0)
            r0 = 5
            goto La
        L36:
            com.facebook.ads.redexgen.X.Lb r3 = (com.facebook.ads.redexgen.X.C0537Lb) r3
            com.facebook.ads.redexgen.X.QI r2 = (com.facebook.ads.redexgen.X.QI) r2
            r2.A5M(r3)
            r0 = 2
            goto La
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0B():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(EnumC0431Gu enumC0431Gu) {
        if (this.A01 == null) {
            return;
        }
        this.A01.A02(enumC0431Gu, null);
    }

    private void A0F(QI qi) {
        if (qi instanceof QJ) {
            A0H((QJ) qi);
        }
        qi.A8U(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0G(com.facebook.ads.redexgen.X.QJ r3) {
        /*
            r2 = this;
            r1 = r2
            android.view.ViewParent r0 = r3.getParent()
            if (r0 != 0) goto L2a
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L16;
                case 4: goto L2c;
                case 5: goto L21;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.QJ r3 = (com.facebook.ads.redexgen.X.QJ) r3
            boolean r0 = r3 instanceof com.facebook.ads.redexgen.X.M6
            if (r0 == 0) goto L14
            r0 = 3
            goto L8
        L14:
            r0 = 5
            goto L8
        L16:
            com.facebook.ads.redexgen.X.Lb r1 = (com.facebook.ads.redexgen.X.C0537Lb) r1
            com.facebook.ads.redexgen.X.QJ r3 = (com.facebook.ads.redexgen.X.QJ) r3
            com.facebook.ads.redexgen.X.QF r0 = r1.A02
            r0.A00(r3)
            r0 = 4
            goto L8
        L21:
            com.facebook.ads.redexgen.X.Lb r1 = (com.facebook.ads.redexgen.X.C0537Lb) r1
            com.facebook.ads.redexgen.X.QJ r3 = (com.facebook.ads.redexgen.X.QJ) r3
            r1.addView(r3)
            r0 = 4
            goto L8
        L2a:
            r0 = 4
            goto L8
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0G(com.facebook.ads.redexgen.X.QJ):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0H(com.facebook.ads.redexgen.X.QJ r3) {
        /*
            r2 = this;
            r1 = r2
            boolean r0 = r3 instanceof com.facebook.ads.redexgen.X.M6
            if (r0 == 0) goto L1c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1e;
                case 4: goto L15;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.Lb r1 = (com.facebook.ads.redexgen.X.C0537Lb) r1
            com.facebook.ads.redexgen.X.QJ r3 = (com.facebook.ads.redexgen.X.QJ) r3
            com.facebook.ads.redexgen.X.QF r0 = r1.A02
            r0.A01(r3)
            r0 = 3
            goto L6
        L15:
            com.facebook.ads.redexgen.X.QJ r3 = (com.facebook.ads.redexgen.X.QJ) r3
            com.facebook.ads.redexgen.X.KE.A0L(r3)
            r0 = 3
            goto L6
        L1c:
            r0 = 4
            goto L6
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0H(com.facebook.ads.redexgen.X.QJ):void");
    }

    public final void A0K() {
        this.A0D.setVideoStateChangeListener(null);
        this.A0D.destroy();
    }

    public final void A0L() {
        if (A0Y()) {
            return;
        }
        this.A0D.A53();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:            r2.A0C.clear();     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0M() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            java.util.List<com.facebook.ads.redexgen.X.QI> r0 = r2.A0C
            java.util.Iterator r1 = r0.iterator()
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L19;
                case 4: goto L28;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            java.util.Iterator r1 = (java.util.Iterator) r1
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L17
            r0 = 3
            goto L9
        L17:
            r0 = 4
            goto L9
        L19:
            com.facebook.ads.redexgen.X.Lb r2 = (com.facebook.ads.redexgen.X.C0537Lb) r2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r0 = r1.next()
            com.facebook.ads.redexgen.X.QI r0 = (com.facebook.ads.redexgen.X.QI) r0
            r2.A0F(r0)
            r0 = 2
            goto L9
        L28:
            com.facebook.ads.redexgen.X.Lb r2 = (com.facebook.ads.redexgen.X.C0537Lb) r2
            java.util.List<com.facebook.ads.redexgen.X.QI> r0 = r2.A0C
            r0.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0M():void");
    }

    public final void A0N() {
        this.A0D.stop();
    }

    public final void A0O(int i) {
        this.A07.removeCallbacksAndMessages(null);
        this.A0D.seekTo(i);
    }

    public final void A0P(QE qe) {
        this.A08.post(new C0660Pw(this));
        this.A0D.A8P(qe.A02());
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0023, code lost:            r2.A0D.A8Q(r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Q(com.facebook.ads.redexgen.X.QH r4) {
        /*
            r3 = this;
            r2 = r3
            boolean r0 = r2.A03
            if (r0 == 0) goto L21
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1a;
                case 4: goto L23;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.Lb r2 = (com.facebook.ads.redexgen.X.C0537Lb) r2
            com.facebook.ads.redexgen.X.FT r0 = r2.A0D
            com.facebook.ads.redexgen.X.FR r1 = r0.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A06
            if (r1 != r0) goto L18
            r0 = 3
            goto L6
        L18:
            r0 = 4
            goto L6
        L1a:
            com.facebook.ads.redexgen.X.Lb r2 = (com.facebook.ads.redexgen.X.C0537Lb) r2
            r0 = 0
            r2.A03 = r0
            r0 = 4
            goto L6
        L21:
            r0 = 4
            goto L6
        L23:
            com.facebook.ads.redexgen.X.Lb r2 = (com.facebook.ads.redexgen.X.C0537Lb) r2
            com.facebook.ads.redexgen.X.QH r4 = (com.facebook.ads.redexgen.X.QH) r4
            com.facebook.ads.redexgen.X.FT r0 = r2.A0D
            r0.A8Q(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0Q(com.facebook.ads.redexgen.X.QH):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0R(com.facebook.ads.redexgen.X.QH r4) {
        /*
            r3 = this;
            r2 = r3
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 18
            if (r1 < r0) goto L2b
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L2d;
                case 4: goto L22;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Lb r2 = (com.facebook.ads.redexgen.X.C0537Lb) r2
            com.facebook.ads.redexgen.X.QH r4 = (com.facebook.ads.redexgen.X.QH) r4
            android.view.View r0 = r2.getView()
            android.view.ViewTreeObserver r1 = r0.getViewTreeObserver()
            com.facebook.ads.redexgen.X.Pv r0 = new com.facebook.ads.redexgen.X.Pv
            r0.<init>(r2, r4)
            r1.addOnWindowFocusChangeListener(r0)
            r0 = 3
            goto L8
        L22:
            com.facebook.ads.redexgen.X.Lb r2 = (com.facebook.ads.redexgen.X.C0537Lb) r2
            com.facebook.ads.redexgen.X.QH r4 = (com.facebook.ads.redexgen.X.QH) r4
            r2.A0Q(r4)
            r0 = 3
            goto L8
        L2b:
            r0 = 4
            goto L8
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0R(com.facebook.ads.redexgen.X.QH):void");
    }

    public final void A0S(QI qi) {
        this.A0C.add(qi);
    }

    public final void A0T(QI qi) {
        this.A0C.remove(qi);
        A0F(qi);
    }

    public final void A0U(boolean z) {
        if (A0Y()) {
            return;
        }
        this.A0D.pause(z);
        this.A05 = z;
    }

    public final void A0V(boolean z, boolean z2) {
        this.A06 = z2;
        A0U(z);
    }

    public final boolean A0W() {
        return this.A0D.A55();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0017, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0X() {
        /*
            r3 = this;
            r2 = 0
            float r1 = r3.getVolume()
            r0 = 0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L15
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L17;
                case 4: goto L12;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            r2 = 1
            r0 = 3
            goto Lb
        L12:
            r2 = 0
            r0 = 3
            goto Lb
        L15:
            r0 = 4
            goto Lb
        L17:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0X():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0Y() {
        /*
            r3 = this;
            r2 = 0
            com.facebook.ads.redexgen.X.FR r1 = r3.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A05
            if (r1 != r0) goto L14
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L16;
                case 4: goto L11;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r2 = 1
            r0 = 3
            goto La
        L11:
            r2 = 0
            r0 = 3
            goto La
        L14:
            r0 = 4
            goto La
        L16:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0Y():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x001f, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0Z() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r2.A0Y()
            if (r0 == 0) goto L1d
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L17;
                case 4: goto L1f;
                case 5: goto L1a;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Lb r2 = (com.facebook.ads.redexgen.X.C0537Lb) r2
            boolean r0 = r2.A05
            if (r0 == 0) goto L15
            r0 = 3
            goto L9
        L15:
            r0 = 5
            goto L9
        L17:
            r1 = 1
            r0 = 4
            goto L9
        L1a:
            r1 = 0
            r0 = 4
            goto L9
        L1d:
            r0 = 5
            goto L9
        L1f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0Z():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0a() {
        /*
            r3 = this;
            r2 = 0
            com.facebook.ads.redexgen.X.FR r1 = r3.getState()
            com.facebook.ads.redexgen.X.FR r0 = com.facebook.ads.redexgen.X.FR.A0A
            if (r1 != r0) goto L14
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L16;
                case 4: goto L11;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r2 = 1
            r0 = 3
            goto La
        L11:
            r2 = 0
            r0 = 3
            goto La
        L14:
            r0 = 4
            goto La
        L16:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.A0a():boolean");
    }

    public final boolean A0b() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.LZ
    public final boolean A5C() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.LZ
    public final boolean A5D() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.LY
    public final void A7W(int i, int i2) {
        this.A08.post(new C0657Pt(this, i, i2));
        A0A();
    }

    @Override // com.facebook.ads.redexgen.X.LY
    public final void A7d(FR fr) {
        int currentPositionInMillis = getCurrentPositionInMillis();
        this.A08.post(new C0656Ps(this, fr, getDuration(), currentPositionInMillis));
    }

    @Override // com.facebook.ads.redexgen.X.LZ
    public int getCurrentPositionInMillis() {
        return this.A0D.getCurrentPosition();
    }

    public int getDuration() {
        return this.A0D.getDuration();
    }

    @NonNull
    public GY<C1S, GX> getEventBus() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.X.LZ
    public long getInitialBufferTime() {
        return this.A0D.getInitialBufferTime();
    }

    public FR getState() {
        return this.A0D.getState();
    }

    public Handler getStateHandler() {
        return this.A08;
    }

    public TextureView getTextureView() {
        return (TextureView) this.A0D;
    }

    public int getVideoHeight() {
        return this.A0D.getVideoHeight();
    }

    public int getVideoProgressReportIntervalMs() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.LZ
    public QH getVideoStartReason() {
        return this.A0D.getStartReason();
    }

    public View getVideoView() {
        return this.A02;
    }

    public int getVideoWidth() {
        return this.A0D.getVideoWidth();
    }

    @Override // com.facebook.ads.redexgen.X.LZ
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.LZ
    public float getVolume() {
        return this.A0D.getVolume();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.A0B.A02(A0K);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.A0B.A02(A0L);
        super.onDetachedFromWindow();
    }

    public void setControlsAnchorView(View view) {
        if (this.A0D != null) {
            this.A0D.setControlsAnchorView(view);
        }
    }

    public void setFunnelLoggingHandler(C0432Gv c0432Gv) {
        this.A01 = c0432Gv;
    }

    public void setIsFullScreen(boolean z) {
        this.A04 = z;
        this.A0D.setFullScreen(z);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(@Nullable String str) {
    }

    public void setVideoProgressReportIntervalMs(int i) {
        this.A00 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            r1.A03 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setVideoURI(@android.support.annotation.Nullable android.net.Uri r3) {
        /*
            r2 = this;
            r1 = r2
            if (r3 != 0) goto L1d
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L1f;
                case 4: goto Lf;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.Lb r1 = (com.facebook.ads.redexgen.X.C0537Lb) r1
            r1.A0M()
            r0 = 3
            goto L4
        Lf:
            com.facebook.ads.redexgen.X.Lb r1 = (com.facebook.ads.redexgen.X.C0537Lb) r1
            android.net.Uri r3 = (android.net.Uri) r3
            r1.A0B()
            com.facebook.ads.redexgen.X.FT r0 = r1.A0D
            r0.setup(r3)
            r0 = 3
            goto L4
        L1d:
            r0 = 4
            goto L4
        L1f:
            com.facebook.ads.redexgen.X.Lb r1 = (com.facebook.ads.redexgen.X.C0537Lb) r1
            r0 = 0
            r1.A03 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.setVideoURI(android.net.Uri):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:            setVideoURI(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setVideoURI(@android.support.annotation.Nullable java.lang.String r3) {
        /*
            r2 = this;
            r1 = 0
            if (r3 == 0) goto L13
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L15;
                case 4: goto L10;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri r1 = android.net.Uri.parse(r3)
            r0 = 3
            goto L4
        L10:
            r1 = 0
            r0 = 3
            goto L4
        L13:
            r0 = 4
            goto L4
        L15:
            r0 = r2
            com.facebook.ads.redexgen.X.Lb r0 = (com.facebook.ads.redexgen.X.C0537Lb) r0
            r0.setVideoURI(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.setVideoURI(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:            r1 = r1;        r1.A0D.setRequestedVolume(r3);        r1.getEventBus().A02(com.facebook.ads.redexgen.X.C0537Lb.A0J);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setVolume(float r3) {
        /*
            r2 = this;
            r1 = r2
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 != 0) goto L30
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L32;
                case 4: goto L1e;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.Lb r1 = (com.facebook.ads.redexgen.X.C0537Lb) r1
            com.facebook.ads.redexgen.X.Gu r0 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0a
            r1.A0C(r0)
            com.facebook.ads.redexgen.X.Ec r0 = r1.A0A
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2x()
            r0 = 3
            goto L8
        L1e:
            com.facebook.ads.redexgen.X.Lb r1 = (com.facebook.ads.redexgen.X.C0537Lb) r1
            com.facebook.ads.redexgen.X.Gu r0 = com.facebook.ads.redexgen.X.EnumC0431Gu.A0Z
            r1.A0C(r0)
            com.facebook.ads.redexgen.X.Ec r0 = r1.A0A
            com.facebook.ads.redexgen.X.0c r0 = r0.A08()
            r0.A2w()
            r0 = 3
            goto L8
        L30:
            r0 = 4
            goto L8
        L32:
            com.facebook.ads.redexgen.X.Lb r1 = (com.facebook.ads.redexgen.X.C0537Lb) r1
            com.facebook.ads.redexgen.X.FT r0 = r1.A0D
            r0.setRequestedVolume(r3)
            com.facebook.ads.redexgen.X.GY r1 = r1.getEventBus()
            com.facebook.ads.redexgen.X.QZ r0 = com.facebook.ads.redexgen.X.C0537Lb.A0J
            r1.A02(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0537Lb.setVolume(float):void");
    }
}
