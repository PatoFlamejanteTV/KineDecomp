package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import android.view.ViewOverlay;
import android.widget.RelativeLayout;
import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView;

/* renamed from: com.facebook.ads.redexgen.X.8W, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C8W extends C1G {
    public static byte[] A01;
    public final /* synthetic */ C8X A00;

    static {
        A01();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A00(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C8W.A01
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
            int r0 = r0 - r4
            int r0 = r0 + (-73)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8W.A00(int, int, int):java.lang.String");
    }

    public static void A01() {
        A01 = new byte[]{-32, -2, 11, 11, 12, 17, -67, 13, 15, 2, 16, 2, 11, 17, -67, 11, 18, 9, 9, -67, 19, 6, 2, 20};
    }

    public C8W(C8X c8x) {
        this.A00 = c8x;
    }

    private void A02(InstreamVideoAdView instreamVideoAdView) {
        C0362Ec c0362Ec;
        String str;
        c0362Ec = this.A00.A0C;
        str = this.A00.A08;
        PU A012 = PT.A01(c0362Ec, str);
        if (A012 != null) {
            instreamVideoAdView.addView(A012, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0B() {
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.8V
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InstreamVideoAdListener instreamVideoAdListener;
                InstreamVideoAdListener instreamVideoAdListener2;
                InstreamVideoAdView instreamVideoAdView;
                instreamVideoAdListener = C8W.this.A00.A02;
                if (instreamVideoAdListener == null) {
                    return;
                }
                instreamVideoAdListener2 = C8W.this.A00.A02;
                instreamVideoAdView = C8W.this.A00.A0B;
                instreamVideoAdListener2.onAdVideoComplete(instreamVideoAdView);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0C() {
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.8T
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InstreamVideoAdListener instreamVideoAdListener;
                InstreamVideoAdListener instreamVideoAdListener2;
                InstreamVideoAdView instreamVideoAdView;
                instreamVideoAdListener = C8W.this.A00.A02;
                if (instreamVideoAdListener == null) {
                    return;
                }
                instreamVideoAdListener2 = C8W.this.A00.A02;
                instreamVideoAdView = C8W.this.A00.A0B;
                instreamVideoAdListener2.onAdClicked(instreamVideoAdView);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0D() {
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.8U
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InstreamVideoAdListener instreamVideoAdListener;
                InstreamVideoAdListener instreamVideoAdListener2;
                InstreamVideoAdView instreamVideoAdView;
                instreamVideoAdListener = C8W.this.A00.A02;
                if (instreamVideoAdListener == null) {
                    return;
                }
                instreamVideoAdListener2 = C8W.this.A00.A02;
                instreamVideoAdView = C8W.this.A00.A0B;
                instreamVideoAdListener2.onLoggingImpression(instreamVideoAdView);
            }
        });
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0006. Please report as an issue. */
    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0E(View view) {
        NQ nq;
        C3B c3b;
        InstreamVideoAdView instreamVideoAdView;
        View view2;
        InstreamVideoAdView instreamVideoAdView2;
        View view3;
        InstreamVideoAdView instreamVideoAdView3;
        C0362Ec c0362Ec;
        View view4;
        NQ nq2;
        View view5;
        NQ nq3;
        String str;
        NQ nq4;
        C0362Ec c0362Ec2;
        C3B c3b2;
        C3B c3b3;
        final C8W c8w = this;
        char c = view == null ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    throw new IllegalStateException(A00(0, 24, 84));
                case 3:
                    c8w = c8w;
                    view = view;
                    c8w.A00.A01 = view;
                    instreamVideoAdView = c8w.A00.A0B;
                    instreamVideoAdView.removeAllViews();
                    view2 = c8w.A00.A01;
                    view2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    instreamVideoAdView2 = c8w.A00.A0B;
                    view3 = c8w.A00.A01;
                    instreamVideoAdView2.addView(view3);
                    instreamVideoAdView3 = c8w.A00.A0B;
                    c8w.A02(instreamVideoAdView3);
                    c = Build.VERSION.SDK_INT >= 18 ? (char) 4 : '\t';
                case 4:
                    c8w = c8w;
                    c0362Ec = c8w.A00.A0C;
                    c = C0413Gc.A0d(c0362Ec) ? (char) 5 : '\t';
                case 5:
                    c8w = c8w;
                    c8w.A00.A06 = new NQ();
                    nq3 = c8w.A00.A06;
                    str = c8w.A00.A0D;
                    nq3.A0C(str);
                    nq4 = c8w.A00.A06;
                    c0362Ec2 = c8w.A00.A0C;
                    nq4.A0B(c0362Ec2.getPackageName());
                    c3b2 = c8w.A00.A04;
                    c = c3b2 != null ? (char) 6 : '\b';
                case 6:
                    c8w = c8w;
                    c3b3 = c8w.A00.A04;
                    c = c3b3.A07() != null ? (char) 7 : '\b';
                case 7:
                    c8w = c8w;
                    nq = c8w.A00.A06;
                    c3b = c8w.A00.A04;
                    nq.A09(c3b.A07().A0C());
                    c = '\b';
                case '\b':
                    c8w = c8w;
                    view4 = c8w.A00.A01;
                    ViewOverlay overlay = view4.getOverlay();
                    nq2 = c8w.A00.A06;
                    overlay.add(nq2);
                    view5 = c8w.A00.A01;
                    view5.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.facebook.ads.redexgen.X.8S
                        /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:            return r5;     */
                        @Override // android.view.View.OnLongClickListener
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final boolean onLongClick(android.view.View r7) {
                            /*
                                r6 = this;
                                r3 = r6
                                r1 = 0
                                r0 = 0
                                r0 = 0
                                r5 = 1
                                r2 = 0
                                com.facebook.ads.redexgen.X.8W r0 = com.facebook.ads.redexgen.X.C8W.this
                                com.facebook.ads.redexgen.X.8X r0 = r0.A00
                                android.view.View r0 = com.facebook.ads.redexgen.X.C8X.A00(r0)
                                if (r0 == 0) goto L73
                                r0 = 2
                            L11:
                                switch(r0) {
                                    case 2: goto L5c;
                                    case 3: goto L58;
                                    case 4: goto L75;
                                    case 5: goto L18;
                                    case 6: goto L15;
                                    case 7: goto L6c;
                                    default: goto L14;
                                }
                            L14:
                                goto L11
                            L15:
                                r2 = r5
                                r0 = 7
                                goto L11
                            L18:
                                com.facebook.ads.redexgen.X.8S r3 = (com.facebook.ads.redexgen.X.C8S) r3
                                r2 = 0
                                com.facebook.ads.redexgen.X.8W r0 = com.facebook.ads.redexgen.X.C8W.this
                                com.facebook.ads.redexgen.X.8X r0 = r0.A00
                                com.facebook.ads.redexgen.X.NQ r4 = com.facebook.ads.redexgen.X.C8X.A07(r0)
                                com.facebook.ads.redexgen.X.8W r0 = com.facebook.ads.redexgen.X.C8W.this
                                com.facebook.ads.redexgen.X.8X r0 = r0.A00
                                android.view.View r0 = com.facebook.ads.redexgen.X.C8X.A00(r0)
                                int r1 = r0.getWidth()
                                com.facebook.ads.redexgen.X.8W r0 = com.facebook.ads.redexgen.X.C8W.this
                                com.facebook.ads.redexgen.X.8X r0 = r0.A00
                                android.view.View r0 = com.facebook.ads.redexgen.X.C8X.A00(r0)
                                int r0 = r0.getHeight()
                                r4.setBounds(r2, r2, r1, r0)
                                com.facebook.ads.redexgen.X.8W r0 = com.facebook.ads.redexgen.X.C8W.this
                                com.facebook.ads.redexgen.X.8X r0 = r0.A00
                                com.facebook.ads.redexgen.X.NQ r1 = com.facebook.ads.redexgen.X.C8X.A07(r0)
                                com.facebook.ads.redexgen.X.8W r0 = com.facebook.ads.redexgen.X.C8W.this
                                com.facebook.ads.redexgen.X.8X r0 = r0.A00
                                com.facebook.ads.redexgen.X.NQ r0 = com.facebook.ads.redexgen.X.C8X.A07(r0)
                                boolean r0 = r0.A0E()
                                if (r0 != 0) goto L56
                                r0 = 6
                                goto L11
                            L56:
                                r0 = 7
                                goto L11
                            L58:
                                r2 = 0
                                r5 = r2
                                r0 = 4
                                goto L11
                            L5c:
                                com.facebook.ads.redexgen.X.8S r3 = (com.facebook.ads.redexgen.X.C8S) r3
                                com.facebook.ads.redexgen.X.8W r0 = com.facebook.ads.redexgen.X.C8W.this
                                com.facebook.ads.redexgen.X.8X r0 = r0.A00
                                com.facebook.ads.redexgen.X.NQ r0 = com.facebook.ads.redexgen.X.C8X.A07(r0)
                                if (r0 != 0) goto L6a
                                r0 = 3
                                goto L11
                            L6a:
                                r0 = 5
                                goto L11
                            L6c:
                                com.facebook.ads.redexgen.X.NQ r1 = (com.facebook.ads.redexgen.X.NQ) r1
                                r1.A0D(r2)
                                r0 = 4
                                goto L11
                            L73:
                                r0 = 3
                                goto L11
                            L75:
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C8S.onLongClick(android.view.View):boolean");
                        }
                    });
                    c = '\t';
                case '\t':
                    return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0F(C1F c1f) {
        C3B c3b;
        c3b = this.A00.A04;
        if (c3b == null) {
            return;
        }
        this.A00.A09 = true;
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.8R
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InstreamVideoAdListener instreamVideoAdListener;
                InstreamVideoAdListener instreamVideoAdListener2;
                InstreamVideoAdView instreamVideoAdView;
                instreamVideoAdListener = C8W.this.A00.A02;
                if (instreamVideoAdListener == null) {
                    return;
                }
                instreamVideoAdListener2 = C8W.this.A00.A02;
                instreamVideoAdView = C8W.this.A00.A0B;
                instreamVideoAdListener2.onAdLoaded(instreamVideoAdView);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.X.C1G
    public final void A0G(final C0453Hr c0453Hr) {
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.8Q
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InstreamVideoAdListener instreamVideoAdListener;
                InstreamVideoAdListener instreamVideoAdListener2;
                InstreamVideoAdView instreamVideoAdView;
                instreamVideoAdListener = C8W.this.A00.A02;
                if (instreamVideoAdListener == null) {
                    return;
                }
                instreamVideoAdListener2 = C8W.this.A00.A02;
                instreamVideoAdView = C8W.this.A00.A0B;
                instreamVideoAdListener2.onError(instreamVideoAdView, C0453Hr.A00(c0453Hr));
            }
        });
    }
}
