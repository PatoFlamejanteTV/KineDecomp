package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import com.facebook.ads.InstreamVideoAdListener;
import com.facebook.ads.InstreamVideoAdView;
import com.facebook.ads.internal.api.InstreamVideoAdViewApi;

/* renamed from: com.facebook.ads.redexgen.X.1z, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C00541z implements InterfaceC00481t {
    public static byte[] A06;

    @Nullable
    public View A00;

    @Nullable
    public InstreamVideoAdListener A01;

    @Nullable
    public String A02;
    public final InstreamVideoAdView A03;
    public final InstreamVideoAdViewApi A04;
    public final C0362Ec A05;

    static {
        A03();
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
            byte[] r1 = com.facebook.ads.redexgen.X.C00541z.A06
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
            r0 = r0 ^ 57
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00541z.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A06 = new byte[]{68, 102, 105, 105, 104, 115, 39, 119, 117, 98, 116, 98, 105, 115, 39, 105, 114, 107, 107, 39, 113, 110, 98, 112};
    }

    public C00541z(InstreamVideoAdViewApi instreamVideoAdViewApi, InstreamVideoAdListener instreamVideoAdListener, InstreamVideoAdView instreamVideoAdView, View view, C0362Ec c0362Ec, String str) {
        this.A04 = instreamVideoAdViewApi;
        this.A01 = instreamVideoAdListener;
        this.A03 = instreamVideoAdView;
        this.A00 = view;
        this.A05 = c0362Ec;
        this.A02 = str;
    }

    private void A04(InstreamVideoAdView instreamVideoAdView) {
        PU A01 = PT.A01(this.A05, this.A02);
        if (A01 != null) {
            instreamVideoAdView.addView(A01, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
    public final void A6k(AbstractC00311c abstractC00311c) {
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.1x
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InstreamVideoAdListener instreamVideoAdListener;
                InstreamVideoAdListener instreamVideoAdListener2;
                InstreamVideoAdView instreamVideoAdView;
                instreamVideoAdListener = C00541z.this.A01;
                if (instreamVideoAdListener == null) {
                    return;
                }
                instreamVideoAdListener2 = C00541z.this.A01;
                instreamVideoAdView = C00541z.this.A03;
                instreamVideoAdListener2.onAdClicked(instreamVideoAdView);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
    public final void A6l(AbstractC00311c abstractC00311c) {
        this.A04.setIsAdLoaded(true);
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.1v
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InstreamVideoAdListener instreamVideoAdListener;
                InstreamVideoAdListener instreamVideoAdListener2;
                InstreamVideoAdView instreamVideoAdView;
                instreamVideoAdListener = C00541z.this.A01;
                if (instreamVideoAdListener == null) {
                    return;
                }
                instreamVideoAdListener2 = C00541z.this.A01;
                instreamVideoAdView = C00541z.this.A03;
                instreamVideoAdListener2.onAdLoaded(instreamVideoAdView);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
    public final void A6m(AbstractC00311c abstractC00311c) {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
    public final void A6n(AbstractC00311c abstractC00311c) {
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.1y
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InstreamVideoAdListener instreamVideoAdListener;
                InstreamVideoAdListener instreamVideoAdListener2;
                InstreamVideoAdView instreamVideoAdView;
                instreamVideoAdListener = C00541z.this.A01;
                if (instreamVideoAdListener == null) {
                    return;
                }
                instreamVideoAdListener2 = C00541z.this.A01;
                instreamVideoAdView = C00541z.this.A03;
                instreamVideoAdListener2.onAdVideoComplete(instreamVideoAdView);
            }
        });
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
    public final void A6o(AbstractC00311c abstractC00311c, View view) {
        if (view == null) {
            throw new IllegalStateException(A02(0, 24, 62));
        }
        this.A00 = view;
        this.A03.removeAllViews();
        this.A00.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A03.addView(this.A00);
        A04(this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC00481t
    public final void A6p(AbstractC00311c abstractC00311c, final AdError adError) {
        C0465If.A00(new AbstractRunnableC00491u() { // from class: com.facebook.ads.redexgen.X.1w
            @Override // com.facebook.ads.redexgen.X.AbstractRunnableC00491u
            public final void A01() {
                InstreamVideoAdListener instreamVideoAdListener;
                InstreamVideoAdListener instreamVideoAdListener2;
                InstreamVideoAdView instreamVideoAdView;
                instreamVideoAdListener = C00541z.this.A01;
                if (instreamVideoAdListener == null) {
                    return;
                }
                instreamVideoAdListener2 = C00541z.this.A01;
                instreamVideoAdView = C00541z.this.A03;
                instreamVideoAdListener2.onError(instreamVideoAdView, adError);
            }
        });
    }
}
