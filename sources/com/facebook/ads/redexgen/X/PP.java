package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import java.util.List;

/* loaded from: assets/audience_network.dex */
public final class PP extends LC {
    public static byte[] A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public static final int A0I;
    public int A00;
    public int A01;

    @Nullable
    public LinearLayout A02;
    public EV A03;

    @Nullable
    public C0532Kw A04;

    @Nullable
    public C0595Ni A05;
    public PG A06;
    public AnonymousClass29 A07;
    public FP A08;
    public String A09;
    public List<PH> A0A;
    public final C0362Ec A0B;
    public final K5 A0C;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0A(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.PP.A0D
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
            r0 = r0 ^ 21
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PP.A0A(int, int, int):java.lang.String");
    }

    public static void A0C() {
        A0D = new byte[]{101, 96, 91, 96, 101, 112, 101, 91, 102, 113, 106, 96, 104, 97};
    }

    static {
        A0C();
        A0E = (int) (48.0f * KE.A01);
        A0F = (int) (KE.A01 * 8.0f);
        A0G = (int) (KE.A01 * 8.0f);
        A0I = (int) (56.0f * KE.A01);
        A0H = (int) (12.0f * KE.A01);
    }

    public PP(C0362Ec c0362Ec, InterfaceC0422Gl interfaceC0422Gl, EV ev, AnonymousClass81 anonymousClass81, C2W c2w) {
        super(c0362Ec, interfaceC0422Gl, anonymousClass81, c2w);
        this.A0C = new K5();
        this.A03 = ev;
        this.A0B = c0362Ec;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0044, code lost:            return;     */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.ads.redexgen.X.Ni, com.facebook.ads.redexgen.X.Kw] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0D() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            android.widget.LinearLayout r0 = r2.A02
            if (r0 == 0) goto L42
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L36;
                case 3: goto L2c;
                case 4: goto L21;
                case 5: goto L17;
                case 6: goto Lc;
                case 7: goto L44;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.PP r2 = (com.facebook.ads.redexgen.X.PP) r2
            com.facebook.ads.redexgen.X.Ni r0 = r2.A05
            r0.removeAllViews()
            r2.A05 = r1
            r0 = 7
            goto L8
        L17:
            com.facebook.ads.redexgen.X.PP r2 = (com.facebook.ads.redexgen.X.PP) r2
            com.facebook.ads.redexgen.X.Ni r0 = r2.A05
            if (r0 == 0) goto L1f
            r0 = 6
            goto L8
        L1f:
            r0 = 7
            goto L8
        L21:
            com.facebook.ads.redexgen.X.PP r2 = (com.facebook.ads.redexgen.X.PP) r2
            com.facebook.ads.redexgen.X.Kw r0 = r2.A04
            r0.removeAllViews()
            r2.A04 = r1
            r0 = 5
            goto L8
        L2c:
            com.facebook.ads.redexgen.X.PP r2 = (com.facebook.ads.redexgen.X.PP) r2
            com.facebook.ads.redexgen.X.Kw r0 = r2.A04
            if (r0 == 0) goto L34
            r0 = 4
            goto L8
        L34:
            r0 = 5
            goto L8
        L36:
            com.facebook.ads.redexgen.X.PP r2 = (com.facebook.ads.redexgen.X.PP) r2
            r1 = 0
            android.widget.LinearLayout r0 = r2.A02
            r0.removeAllViews()
            r2.A02 = r1
            r0 = 3
            goto L8
        L42:
            r0 = 3
            goto L8
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PP.A0D():void");
    }

    private final void A0E(int i, @Nullable Bundle bundle) {
        int width;
        int i2;
        int i3;
        C2T A00;
        this.A02 = new LinearLayout(getContext());
        if (i == 1) {
            this.A02.setGravity(17);
        } else {
            this.A02.setGravity(48);
        }
        this.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A02.setOrientation(1);
        int i4 = KE.A02.widthPixels;
        int width2 = KE.A02.heightPixels;
        if (i == 1) {
            int height = A0F;
            width = Math.min(i4 - (height * 4), width2 / 2);
            i2 = (i4 - width) / 8;
            i3 = i2 * 4;
        } else {
            int childSpacing = A0I;
            int extraSpacing = A0E;
            int childSpacing2 = childSpacing + extraSpacing;
            int extraSpacing2 = A0F;
            width = width2 - (childSpacing2 + (extraSpacing2 * 4));
            i2 = A0F;
            i3 = i2 * 2;
        }
        this.A07 = new PM(this);
        this.A08 = new FP(this, 1, this.A07, this.A0B);
        FP fp = this.A08;
        int extraSpacing3 = this.A00;
        fp.A0X(extraSpacing3);
        FP fp2 = this.A08;
        int extraSpacing4 = this.A01;
        fp2.A0Y(extraSpacing4);
        this.A04 = new C0532Kw(this.A0B);
        this.A04.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.A06 = new PG(this.A04, i, this.A0A, this.A08, bundle);
        C0532Kw c0532Kw = this.A04;
        C0362Ec c0362Ec = this.A0B;
        List<PH> list = this.A0A;
        InterfaceC0422Gl interfaceC0422Gl = super.A0B;
        EV ev = this.A03;
        FP fp3 = this.A08;
        K5 k5 = this.A0C;
        AnonymousClass81 audienceNetworkListener = getAudienceNetworkListener();
        if (i == 1) {
            A00 = super.A06.A01();
        } else {
            A00 = super.A06.A00();
        }
        c0532Kw.setAdapter(new PJ(c0362Ec, list, interfaceC0422Gl, ev, fp3, k5, audienceNetworkListener, A00, this.A09, width, i2, i3, i, this.A06));
        if (i == 1) {
            A0G(this.A06);
        }
        this.A02.addView(this.A04);
        if (this.A05 != null) {
            this.A02.addView(this.A05);
        }
        A09(this.A02, false, i, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F(com.facebook.ads.redexgen.X.C2W r8) {
        /*
            r7 = this;
            r6 = r7
            r0 = 0
            r0 = 0
            java.lang.String r0 = r8.A0P()
            r6.A09 = r0
            int r0 = r8.A0F()
            r6.A00 = r0
            int r0 = r8.A0G()
            r6.A01 = r0
            java.util.List r5 = r8.A0V()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r0 = r5.size()
            r1.<init>(r0)
            r6.A0A = r1
            r4 = 0
            r0 = 2
        L26:
            switch(r0) {
                case 2: goto L2a;
                case 3: goto L36;
                case 4: goto L52;
                default: goto L29;
            }
        L29:
            goto L26
        L2a:
            java.util.List r5 = (java.util.List) r5
            int r0 = r5.size()
            if (r4 >= r0) goto L34
            r0 = 3
            goto L26
        L34:
            r0 = 4
            goto L26
        L36:
            com.facebook.ads.redexgen.X.PP r6 = (com.facebook.ads.redexgen.X.PP) r6
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r3 = r5.get(r4)
            com.facebook.ads.redexgen.X.2L r3 = (com.facebook.ads.redexgen.X.C2L) r3
            java.util.List<com.facebook.ads.redexgen.X.PH> r2 = r6.A0A
            com.facebook.ads.redexgen.X.PH r1 = new com.facebook.ads.redexgen.X.PH
            int r0 = r5.size()
            r1.<init>(r4, r0, r3)
            r2.add(r1)
            int r4 = r4 + 1
            r0 = 2
            goto L26
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PP.A0F(com.facebook.ads.redexgen.X.2W):void");
    }

    private void A0G(PG pg) {
        new C01786y().A0B(this.A04);
        pg.A0c(new PN(this));
        this.A05 = new C0595Ni(this.A0B, super.A06.A01(), this.A0A.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, A0G);
        layoutParams.setMargins(0, A0H, 0, 0);
        this.A05.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.LC
    public final void A0S() {
    }

    @Override // com.facebook.ads.redexgen.X.LC
    public final boolean A0T() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A5L(Intent intent, Bundle bundle, AnonymousClass89 anonymousClass89) {
        C2W c2w = (C2W) intent.getSerializableExtra(A0A(0, 14, 17));
        super.A0A(anonymousClass89);
        A0F(c2w);
        A0E(anonymousClass89.A0H().getResources().getConfiguration().orientation, bundle);
        anonymousClass89.A0J(new PO(this, anonymousClass89));
        int A03 = super.A09.A0L().A0D().A03();
        if (A03 > 0) {
            A07(A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.LC, com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A7F(boolean z) {
        super.A7F(z);
        if (this.A06 != null) {
            this.A06.A0Z();
        }
    }

    @Override // com.facebook.ads.redexgen.X.LC, com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A7O(boolean z) {
        super.A7O(z);
        this.A06.A0a();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void A8E(Bundle bundle) {
        if (this.A06 != null) {
            this.A06.A0b(bundle);
        }
    }

    @Override // com.facebook.ads.redexgen.X.LC
    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        return 0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        A8E(bundle);
        A0D();
        A0E(configuration.orientation, bundle);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.facebook.ads.redexgen.X.LC, com.facebook.ads.redexgen.X.InterfaceC0524Ko
    public final void onDestroy() {
        super.onDestroy();
        if (!TextUtils.isEmpty(this.A09)) {
            super.A0B.A5U(this.A09, new NS().A03(this.A08).A02(this.A0C).A05());
        }
        A0D();
        this.A08.A0W();
        this.A08 = null;
        this.A07 = null;
        this.A0A = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0C.A06(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
