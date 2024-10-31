package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
@TargetApi(16)
/* renamed from: com.facebook.ads.redexgen.X.Ln, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0549Ln extends RelativeLayout implements InterfaceC0524Ko {
    public static byte[] A0J;
    public static final int A0K;
    public static final int A0L;
    public static final int A0M;
    public static final int A0N;
    public static final RelativeLayout.LayoutParams A0O;
    public static final /* synthetic */ boolean A0P;
    public Toast A00;

    @Nullable
    public AnonymousClass89 A01;
    public C0588Nb A02;
    public PX A03;
    public boolean A04;
    public boolean A05;
    public final C2I A06;
    public final C00592e A07;
    public final AnonymousClass86 A08;
    public final C0362Ec A09;
    public final InterfaceC0422Gl A0A;
    public final C0432Gv A0B;
    public final JW A0C;
    public final ViewOnSystemUiVisibilityChangeListenerC0509Jz A0D;
    public final AnonymousClass81 A0E;
    public final MQ A0F;
    public final C0647Pj A0G;
    public final AtomicBoolean A0H;

    @VisibleForTesting
    public final FullScreenAdToolbar A0I;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0C(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C0549Ln.A0J
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
            r0 = r0 ^ 17
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0549Ln.A0C(int, int, int):java.lang.String");
    }

    public static void A0J() {
        A0J = new byte[]{123, 83, 69, 67, 83, 125, 108, 99, 102, 108, 100, 80, 96, 125, 102, 104, 102, 97, 7, 8, 29, 0, 31, 12, 54, 10, 5, 0, 10, 2, 1, 19, 20, 0, 31, 19, 1, 41, 21, 26, 31, 21, 29, 46, 50, 63, 61, 59, 51, 59, 48, 42};
    }

    static {
        A0J();
        A0P = !C0549Ln.class.desiredAssertionStatus();
        A0M = (int) (64.0f * KE.A01);
        A0L = (int) (16.0f * KE.A01);
        A0N = (int) (12.0f * KE.A01);
        A0K = (int) (10.0f * KE.A01);
        A0O = new RelativeLayout.LayoutParams(-1, -1);
    }

    public C0549Ln(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, AnonymousClass81 anonymousClass81, C2I c2i, @Nullable String str, MQ mq) {
        super(c0362Ec);
        this.A08 = new C0541Lf(this);
        this.A0H = new AtomicBoolean(false);
        this.A09 = c0362Ec;
        this.A0E = anonymousClass81;
        this.A0A = interfaceC0422Gl;
        this.A06 = c2i;
        this.A07 = c2i.A0L().A0D().A05();
        this.A0B = new C0432Gv(this.A06.A0P(), this.A0A);
        this.A0F = mq;
        this.A0G = new C0647Pj(c0362Ec, this.A0F, str, this.A0E);
        if (!A0P && this.A07 == null) {
            throw new AssertionError();
        }
        this.A0H.set(this.A07.A0H() ? false : true);
        this.A0C = new JW(this.A07.A07(), new C0546Lk(this, null));
        this.A0I = A06();
        KE.A0P(this, -14473425);
        this.A0D = new ViewOnSystemUiVisibilityChangeListenerC0509Jz(this);
        this.A0D.A05(EnumC0508Jy.A02);
    }

    private FullScreenAdToolbar A06() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A09, this.A0E, this.A0B, 0, this.A06.A0D());
        fullScreenAdToolbar.A04(this.A06.A0K().A01(), true);
        fullScreenAdToolbar.setPageDetailsVisible(false);
        fullScreenAdToolbar.setPageDetails(this.A06.A0N(), this.A06.A0P(), this.A07.A07(), this.A06.A0O());
        fullScreenAdToolbar.setToolbarListener(new C0543Lh(this));
        return fullScreenAdToolbar;
    }

    private C0588Nb A08() {
        C0588Nb c0588Nb = new C0588Nb(this.A09, this.A06.A0K().A01());
        c0588Nb.setText(this.A06.A0L().A0F().A03());
        c0588Nb.setTextSize(14.0f);
        c0588Nb.setIncludeFontPadding(false);
        c0588Nb.setPadding(A0K, A0K, A0K, A0K);
        KE.A0Q(c0588Nb, 8);
        c0588Nb.setOnClickListener(new ViewOnClickListenerC0544Li(this));
        return c0588Nb;
    }

    private C0601No A0A() {
        C0601No c0601No = new C0601No(this.A09, this.A06.A0K().A01(), true, 16, 14, 0);
        c0601No.A00(this.A06.A0L().A0E().A06(), this.A06.A0L().A0E().A05(), null, false, true);
        TextView descriptionTextView = c0601No.getDescriptionTextView();
        descriptionTextView.setAlpha(0.8f);
        descriptionTextView.setMaxLines(1);
        descriptionTextView.setEllipsize(TextUtils.TruncateAt.END);
        TextView titleTextView = c0601No.getTitleTextView();
        titleTextView.setMaxLines(1);
        titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        return c0601No;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0033, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0E() {
        /*
            r3 = this;
            r2 = r3
            com.facebook.ads.redexgen.X.2e r0 = r2.A07
            boolean r0 = r0.A0H()
            if (r0 == 0) goto L31
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L15;
                case 4: goto L1f;
                case 5: goto L33;
                case 6: goto L2a;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            r2.A0G()
            r0 = 3
            goto La
        L15:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 19
            if (r1 < r0) goto L1d
            r0 = 4
            goto La
        L1d:
            r0 = 5
            goto La
        L1f:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            com.facebook.ads.redexgen.X.Jz r1 = r2.A0D
            com.facebook.ads.redexgen.X.Jy r0 = com.facebook.ads.redexgen.X.EnumC0508Jy.A03
            r1.A05(r0)
            r0 = 5
            goto La
        L2a:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            r2.A0H()
            r0 = 3
            goto La
        L31:
            r0 = 6
            goto La
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0549Ln.A0E():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0F() {
        /*
            r9 = this;
            r2 = r9
            r0 = 0
            r0 = 0
            r0 = 1
            r2.A05 = r0
            com.facebook.ads.redexgen.X.2I r0 = r2.A06
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            boolean r0 = r0.A0K()
            if (r0 == 0) goto L5e
            r0 = 2
        L13:
            switch(r0) {
                case 2: goto L17;
                case 3: goto L37;
                case 4: goto L60;
                default: goto L16;
            }
        L16:
            goto L13
        L17:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            r4 = 0
            com.facebook.ads.redexgen.X.Pj r0 = r2.A0G
            r0.A05()
            com.facebook.ads.redexgen.X.81 r3 = r2.A0E
            com.facebook.ads.redexgen.X.MQ r0 = r2.A0F
            java.lang.String r1 = r0.A4D()
            com.facebook.ads.redexgen.X.QM r0 = new com.facebook.ads.redexgen.X.QM
            r0.<init>(r4, r4)
            r3.A3c(r1, r0)
            boolean r0 = r2.A04
            if (r0 == 0) goto L35
            r0 = 3
            goto L13
        L35:
            r0 = 4
            goto L13
        L37:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            com.facebook.ads.redexgen.X.Ec r3 = r2.A09
            com.facebook.ads.redexgen.X.PX r0 = r2.A03
            com.facebook.ads.redexgen.X.FP r4 = r0.getViewabilityChecker()
            com.facebook.ads.redexgen.X.PX r0 = r2.A03
            com.facebook.ads.redexgen.X.K5 r5 = r0.getTouchDataRecorder()
            com.facebook.ads.redexgen.X.Gl r6 = r2.A0A
            com.facebook.ads.redexgen.X.2I r0 = r2.A06
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2U r7 = r0.A0F()
            com.facebook.ads.redexgen.X.2I r0 = r2.A06
            java.lang.String r8 = r0.A0P()
            com.facebook.ads.redexgen.X.C0587Na.A03(r3, r4, r5, r6, r7, r8)
            r0 = 4
            goto L13
        L5e:
            r0 = 4
            goto L13
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0549Ln.A0F():void");
    }

    private void A0G() {
        C0633Ov A0B = new C0632Ou(this.A09, this.A06.A0L().A0E(), this.A06.A0N()).A08(this.A06.A0K().A01()).A0A(this.A07.A0F()).A09(this.A07.A0D()).A07(2000).A0B();
        C0434Gx.A04(A0B, this.A0B, EnumC0431Gu.A0T);
        addView(A0B, A0O);
        A0B.A04(new C0542Lg(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H() {
        KE.A0U(this);
        this.A03.A09();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        KE.A0N(relativeLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(A0L, A0N, A0L, A0N);
        layoutParams.addRule(12);
        this.A02 = A08();
        KE.A0N(this.A02);
        C0601No A0A = A0A();
        KE.A0N(A0A);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(0, this.A02.getId());
        layoutParams2.setMargins(0, 0, A0L, 0);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(6, A0A.getId());
        layoutParams3.addRule(8, A0A.getId());
        relativeLayout.addView(A0A, layoutParams2);
        relativeLayout.addView(this.A02, layoutParams3);
        KE.A0N(this.A0I);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(10);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.setMargins(A0L, 0, A0L, 0);
        layoutParams5.addRule(3, this.A0I.getId());
        layoutParams5.addRule(2, relativeLayout.getId());
        addView(this.A0I, layoutParams4);
        addView(this.A03, layoutParams5);
        addView(relativeLayout, layoutParams);
        this.A0C.A07();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0I() {
        /*
            r4 = this;
            r3 = r4
            android.widget.Toast r0 = r3.A00
            if (r0 == 0) goto L40
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L42;
                case 4: goto L1c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.Ln r3 = (com.facebook.ads.redexgen.X.C0549Ln) r3
            android.widget.Toast r0 = r3.A00
            android.view.View r0 = r0.getView()
            int r0 = r0.getWindowVisibility()
            if (r0 != 0) goto L1a
            r0 = 3
            goto L6
        L1a:
            r0 = 4
            goto L6
        L1c:
            com.facebook.ads.redexgen.X.Ln r3 = (com.facebook.ads.redexgen.X.C0549Ln) r3
            android.content.Context r2 = r3.getContext()
            com.facebook.ads.redexgen.X.2e r0 = r3.A07
            java.lang.String r1 = r0.A0C()
            r0 = 1
            android.widget.Toast r0 = android.widget.Toast.makeText(r2, r1, r0)
            r3.A00 = r0
            com.facebook.ads.redexgen.X.JW r0 = r3.A0C
            float r0 = r0.A03()
            int r0 = (int) r0
            r3.A0K(r0)
            android.widget.Toast r0 = r3.A00
            r0.show()
            r0 = 3
            goto L6
        L40:
            r0 = 4
            goto L6
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0549Ln.A0I():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0K(int i) {
        KE.A0Z(this.A00, this.A07.A0C().replace(A0C(0, 6, 49), String.valueOf(i)), 49, 0, A0M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c4, code lost:            r7.A04 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c8, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0Q(boolean r17) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0549Ln.A0Q(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x007f, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A5L(android.content.Intent r12, android.os.Bundle r13, com.facebook.ads.redexgen.X.AnonymousClass89 r14) {
        /*
            r11 = this;
            r3 = r11
            r0 = 0
            r0 = 0
            r0 = 0
            r2 = -1
            r3.A01 = r14
            com.facebook.ads.redexgen.X.89 r1 = r3.A01
            com.facebook.ads.redexgen.X.86 r0 = r3.A08
            r1.A0J(r0)
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            r4 = 43
            r1 = 9
            r0 = 79
            java.lang.String r1 = A0C(r4, r1, r0)
            com.facebook.ads.redexgen.X.MQ r0 = r3.A0F
            java.lang.String r0 = r0.A4q()
            r10.put(r1, r0)
            com.facebook.ads.redexgen.X.2I r0 = r3.A06
            com.facebook.ads.redexgen.X.2L r0 = r0.A0L()
            com.facebook.ads.redexgen.X.2O r0 = r0.A0D()
            com.facebook.ads.redexgen.X.2e r7 = r0.A05()
            if (r7 != 0) goto L7d
            r0 = 2
        L37:
            switch(r0) {
                case 2: goto L3b;
                case 3: goto L7f;
                case 4: goto L55;
                default: goto L3a;
            }
        L3a:
            goto L37
        L3b:
            com.facebook.ads.redexgen.X.Ln r3 = (com.facebook.ads.redexgen.X.C0549Ln) r3
            com.facebook.ads.redexgen.X.81 r1 = r3.A0E
            com.facebook.ads.redexgen.X.MQ r0 = r3.A0F
            java.lang.String r0 = r0.A4e()
            r1.A3b(r0)
            com.facebook.ads.redexgen.X.81 r1 = r3.A0E
            com.facebook.ads.redexgen.X.MQ r0 = r3.A0F
            java.lang.String r0 = r0.A4a()
            r1.A3b(r0)
            r0 = 3
            goto L37
        L55:
            com.facebook.ads.redexgen.X.Ln r3 = (com.facebook.ads.redexgen.X.C0549Ln) r3
            java.util.HashMap r10 = (java.util.HashMap) r10
            com.facebook.ads.redexgen.X.2e r7 = (com.facebook.ads.redexgen.X.C00592e) r7
            com.facebook.ads.redexgen.X.PX r4 = new com.facebook.ads.redexgen.X.PX
            com.facebook.ads.redexgen.X.Ec r5 = r3.A09
            com.facebook.ads.redexgen.X.2I r6 = r3.A06
            com.facebook.ads.redexgen.X.Gl r8 = r3.A0A
            com.facebook.ads.redexgen.X.Lm r9 = new com.facebook.ads.redexgen.X.Lm
            r0 = 0
            r9.<init>(r3, r0)
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r3.A03 = r4
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r2, r2)
            com.facebook.ads.redexgen.X.81 r0 = r3.A0E
            r0.A39(r3, r1)
            r3.A0E()
            r0 = 3
            goto L37
        L7d:
            r0 = 4
            goto L37
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0549Ln.A5L(android.content.Intent, android.os.Bundle, com.facebook.ads.redexgen.X.89):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A7F(boolean z) {
        this.A0C.A06();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0027, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A7O(boolean r3) {
        /*
            r2 = this;
            r1 = r2
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.A0H
            boolean r0 = r0.get()
            if (r0 == 0) goto L25
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1c;
                case 4: goto L27;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            com.facebook.ads.redexgen.X.Ln r1 = (com.facebook.ads.redexgen.X.C0549Ln) r1
            com.facebook.ads.redexgen.X.JW r0 = r1.A0C
            boolean r0 = r0.A05()
            if (r0 != 0) goto L1a
            r0 = 3
            goto La
        L1a:
            r0 = 4
            goto La
        L1c:
            com.facebook.ads.redexgen.X.Ln r1 = (com.facebook.ads.redexgen.X.C0549Ln) r1
            com.facebook.ads.redexgen.X.JW r0 = r1.A0C
            r0.A07()
            r0 = 4
            goto La
        L25:
            r0 = 4
            goto La
        L27:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0549Ln.A7O(boolean):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A8E(Bundle bundle) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:            r2 = r2;        r2.A0C.A06();        r2.A0I.setToolbarListener(null);        r2.A00 = null;        r2.A01 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroy() {
        /*
            r5 = this;
            r2 = r5
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Jz r0 = r2.A0D
            r0.A03()
            com.facebook.ads.redexgen.X.89 r0 = r2.A01
            if (r0 == 0) goto L6d
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L62;
                case 3: goto L58;
                case 4: goto L46;
                case 5: goto L1a;
                case 6: goto L11;
                case 7: goto L6f;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            com.facebook.ads.redexgen.X.PX r0 = r2.A03
            r0.A0A()
            r0 = 7
            goto Ld
        L1a:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            com.facebook.ads.redexgen.X.Gl r4 = r2.A0A
            com.facebook.ads.redexgen.X.2I r0 = r2.A06
            java.lang.String r3 = r0.A0P()
            com.facebook.ads.redexgen.X.NS r1 = new com.facebook.ads.redexgen.X.NS
            r1.<init>()
            com.facebook.ads.redexgen.X.PX r0 = r2.A03
            com.facebook.ads.redexgen.X.FP r0 = r0.getViewabilityChecker()
            com.facebook.ads.redexgen.X.NS r1 = r1.A03(r0)
            com.facebook.ads.redexgen.X.PX r0 = r2.A03
            com.facebook.ads.redexgen.X.K5 r0 = r0.getTouchDataRecorder()
            com.facebook.ads.redexgen.X.NS r0 = r1.A02(r0)
            java.util.Map r0 = r0.A05()
            r4.A5U(r3, r0)
            r0 = 6
            goto Ld
        L46:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            com.facebook.ads.redexgen.X.2I r0 = r2.A06
            java.lang.String r0 = r0.A0P()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L56
            r0 = 5
            goto Ld
        L56:
            r0 = 6
            goto Ld
        L58:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            com.facebook.ads.redexgen.X.PX r0 = r2.A03
            if (r0 == 0) goto L60
            r0 = 4
            goto Ld
        L60:
            r0 = 7
            goto Ld
        L62:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            com.facebook.ads.redexgen.X.89 r1 = r2.A01
            com.facebook.ads.redexgen.X.86 r0 = r2.A08
            r1.A0K(r0)
            r0 = 3
            goto Ld
        L6d:
            r0 = 3
            goto Ld
        L6f:
            com.facebook.ads.redexgen.X.Ln r2 = (com.facebook.ads.redexgen.X.C0549Ln) r2
            r1 = 0
            com.facebook.ads.redexgen.X.JW r0 = r2.A0C
            r0.A06()
            com.facebook.ads.internal.view.FullScreenAdToolbar r0 = r2.A0I
            r0.setToolbarListener(r1)
            r2.A00 = r1
            r2.A01 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0549Ln.onDestroy():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onWindowFocusChanged(boolean r3) {
        /*
            r2 = this;
            r1 = r2
            r0 = 0
            r0 = 0
            super.onWindowFocusChanged(r3)
            if (r3 == 0) goto L1d
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1f;
                case 4: goto L15;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.Ln r1 = (com.facebook.ads.redexgen.X.C0549Ln) r1
            r0 = 0
            r1.A7O(r0)
            r0 = 3
            goto L9
        L15:
            com.facebook.ads.redexgen.X.Ln r1 = (com.facebook.ads.redexgen.X.C0549Ln) r1
            r0 = 0
            r1.A7F(r0)
            r0 = 3
            goto L9
        L1d:
            r0 = 4
            goto L9
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0549Ln.onWindowFocusChanged(boolean):void");
    }

    public void setListener(AnonymousClass81 anonymousClass81) {
    }
}
