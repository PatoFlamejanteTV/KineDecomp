package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.support.annotation.Nullable;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.93, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass93 implements NativeAdScrollViewApi {
    public static byte[] A07;
    public final int A00;

    @Nullable
    public final NativeAdScrollView.AdViewProvider A01;

    @Nullable
    public final NativeAdView.Type A02;
    public final NativeAdViewAttributes A03;
    public final NativeAdsManager A04;
    public final AnonymousClass92 A05;
    public final C0362Ec A06;

    static {
        A07();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A06(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass93.A07
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
            r0 = r0 ^ 13
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass93.A06(int, int, int):java.lang.String");
    }

    public static void A07() {
        A07 = new byte[]{96, 88, 94, 89, 13, 93, 95, 66, 91, 68, 73, 72, 13, 76, 13, 99, 76, 89, 68, 91, 72, 108, 73, 123, 68, 72, 90, 3, 121, 84, 93, 72, 1, 13, 108, 73, 123, 68, 72, 90, 125, 95, 66, 91, 68, 73, 72, 95, 13, 66, 95, 13, 76, 13, 67, 76, 89, 68, 91, 72, 108, 73, 123, 68, 72, 90, 101, 72, 68, 74, 69, 89, 105, 93, 58, 21, 0, 29, 2, 17, 53, 16, 7, 57, 21, 26, 21, 19, 17, 6, 84, 26, 27, 0, 84, 24, 27, 21, 16, 17, 16};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.facebook.ads.redexgen.X.92] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.facebook.ads.redexgen.X.91, com.facebook.ads.redexgen.X.4n] */
    public AnonymousClass93(NativeAdScrollView nativeAdScrollView, final Context context, NativeAdsManager nativeAdsManager, @Nullable NativeAdScrollView.AdViewProvider adViewProvider, int i, @Nullable NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i2) {
        if (!nativeAdsManager.isLoaded()) {
            throw new IllegalStateException(A06(74, 27, 121));
        }
        if (type == null && adViewProvider == null && i <= 0) {
            throw new IllegalArgumentException(A06(0, 74, 32));
        }
        this.A06 = C8N.A02(context);
        this.A04 = nativeAdsManager;
        this.A03 = nativeAdViewAttributes;
        this.A01 = adViewProvider;
        this.A02 = type;
        this.A00 = i2;
        ?? r3 = new AbstractC01204n() { // from class: com.facebook.ads.redexgen.X.91
            public List<NativeAd> A00 = new ArrayList();

            @Override // com.facebook.ads.redexgen.X.AbstractC01204n
            public final int A05() {
                return this.A00.size();
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC01204n
            public final int A06(Object obj) {
                int indexOf = this.A00.indexOf(obj);
                if (indexOf >= 0) {
                    return indexOf;
                }
                return -2;
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:            r1 = r1;        r6.addView(r1);     */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:            return r1;     */
            @Override // com.facebook.ads.redexgen.X.AbstractC01204n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object A08(android.view.ViewGroup r6, int r7) {
                /*
                    r5 = this;
                    r4 = r5
                    r1 = 0
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdScrollView$AdViewProvider r0 = com.facebook.ads.redexgen.X.AnonymousClass93.A01(r0)
                    if (r0 == 0) goto L71
                    r0 = 2
                Lb:
                    switch(r0) {
                        case 2: goto Lf;
                        case 3: goto L73;
                        case 4: goto L25;
                        case 5: goto L33;
                        case 6: goto L55;
                        default: goto Le;
                    }
                Le:
                    goto Lb
                Lf:
                    com.facebook.ads.redexgen.X.91 r4 = (com.facebook.ads.redexgen.X.AnonymousClass91) r4
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdScrollView$AdViewProvider r1 = com.facebook.ads.redexgen.X.AnonymousClass93.A01(r0)
                    java.util.List<com.facebook.ads.NativeAd> r0 = r4.A00
                    java.lang.Object r0 = r0.get(r7)
                    com.facebook.ads.NativeAd r0 = (com.facebook.ads.NativeAd) r0
                    android.view.View r1 = r1.createView(r0, r7)
                    r0 = 3
                    goto Lb
                L25:
                    com.facebook.ads.redexgen.X.91 r4 = (com.facebook.ads.redexgen.X.AnonymousClass91) r4
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdView$Type r0 = com.facebook.ads.redexgen.X.AnonymousClass93.A02(r0)
                    if (r0 == 0) goto L31
                    r0 = 5
                    goto Lb
                L31:
                    r0 = 6
                    goto Lb
                L33:
                    com.facebook.ads.redexgen.X.91 r4 = (com.facebook.ads.redexgen.X.AnonymousClass91) r4
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.redexgen.X.Ec r3 = com.facebook.ads.redexgen.X.AnonymousClass93.A05(r0)
                    java.util.List<com.facebook.ads.NativeAd> r0 = r4.A00
                    java.lang.Object r2 = r0.get(r7)
                    com.facebook.ads.NativeAd r2 = (com.facebook.ads.NativeAd) r2
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdView$Type r1 = com.facebook.ads.redexgen.X.AnonymousClass93.A02(r0)
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdViewAttributes r0 = com.facebook.ads.redexgen.X.AnonymousClass93.A03(r0)
                    android.view.View r1 = com.facebook.ads.NativeAdView.render(r3, r2, r1, r0)
                    r0 = 3
                    goto Lb
                L55:
                    com.facebook.ads.redexgen.X.91 r4 = (com.facebook.ads.redexgen.X.AnonymousClass91) r4
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.redexgen.X.Ec r2 = com.facebook.ads.redexgen.X.AnonymousClass93.A05(r0)
                    java.util.List<com.facebook.ads.NativeAd> r0 = r4.A00
                    java.lang.Object r1 = r0.get(r7)
                    com.facebook.ads.NativeAd r1 = (com.facebook.ads.NativeAd) r1
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdViewAttributes r0 = com.facebook.ads.redexgen.X.AnonymousClass93.A03(r0)
                    android.view.View r1 = com.facebook.ads.NativeAdView.render(r2, r1, r0)
                    r0 = 3
                    goto Lb
                L71:
                    r0 = 4
                    goto Lb
                L73:
                    android.view.ViewGroup r6 = (android.view.ViewGroup) r6
                    android.view.View r1 = (android.view.View) r1
                    r6.addView(r1)
                    java.lang.Object r1 = (java.lang.Object) r1
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass91.A08(android.view.ViewGroup, int):java.lang.Object");
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:            r5.removeView((android.view.View) r7);     */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.AbstractC01204n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A0B(android.view.ViewGroup r5, int r6, java.lang.Object r7) {
                /*
                    r4 = this;
                    r3 = r4
                    java.util.List<com.facebook.ads.NativeAd> r0 = r3.A00
                    int r0 = r0.size()
                    if (r6 >= r0) goto L45
                    r0 = 2
                La:
                    switch(r0) {
                        case 2: goto Le;
                        case 3: goto L1c;
                        case 4: goto L47;
                        case 5: goto L36;
                        default: goto Ld;
                    }
                Ld:
                    goto La
                Le:
                    com.facebook.ads.redexgen.X.91 r3 = (com.facebook.ads.redexgen.X.AnonymousClass91) r3
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdScrollView$AdViewProvider r0 = com.facebook.ads.redexgen.X.AnonymousClass93.A01(r0)
                    if (r0 == 0) goto L1a
                    r0 = 3
                    goto La
                L1a:
                    r0 = 5
                    goto La
                L1c:
                    com.facebook.ads.redexgen.X.91 r3 = (com.facebook.ads.redexgen.X.AnonymousClass91) r3
                    java.lang.Object r7 = (java.lang.Object) r7
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdScrollView$AdViewProvider r2 = com.facebook.ads.redexgen.X.AnonymousClass93.A01(r0)
                    java.util.List<com.facebook.ads.NativeAd> r0 = r3.A00
                    java.lang.Object r1 = r0.get(r6)
                    com.facebook.ads.NativeAd r1 = (com.facebook.ads.NativeAd) r1
                    r0 = r7
                    android.view.View r0 = (android.view.View) r0
                    r2.destroyView(r1, r0)
                    r0 = 4
                    goto La
                L36:
                    com.facebook.ads.redexgen.X.91 r3 = (com.facebook.ads.redexgen.X.AnonymousClass91) r3
                    java.util.List<com.facebook.ads.NativeAd> r0 = r3.A00
                    java.lang.Object r0 = r0.get(r6)
                    com.facebook.ads.NativeAd r0 = (com.facebook.ads.NativeAd) r0
                    r0.unregisterView()
                    r0 = 4
                    goto La
                L45:
                    r0 = 4
                    goto La
                L47:
                    android.view.ViewGroup r5 = (android.view.ViewGroup) r5
                    java.lang.Object r7 = (java.lang.Object) r7
                    android.view.View r7 = (android.view.View) r7
                    r5.removeView(r7)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass91.A0B(android.view.ViewGroup, int, java.lang.Object):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0010, code lost:            return r1;     */
            @Override // com.facebook.ads.redexgen.X.AbstractC01204n
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A0C(android.view.View r3, java.lang.Object r4) {
                /*
                    r2 = this;
                    r1 = 0
                    if (r3 != r4) goto Le
                    r0 = 2
                L4:
                    switch(r0) {
                        case 2: goto L8;
                        case 3: goto L10;
                        case 4: goto Lb;
                        default: goto L7;
                    }
                L7:
                    goto L4
                L8:
                    r1 = 1
                    r0 = 3
                    goto L4
                Lb:
                    r1 = 0
                    r0 = 3
                    goto L4
                Le:
                    r0 = 4
                    goto L4
                L10:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass91.A0C(android.view.View, java.lang.Object):boolean");
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:            r5.A09();     */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:            return;     */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A0D() {
                /*
                    r6 = this;
                    r5 = r6
                    r0 = 0
                    r0 = 0
                    java.util.List<com.facebook.ads.NativeAd> r0 = r5.A00
                    r0.clear()
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    int r1 = com.facebook.ads.redexgen.X.AnonymousClass93.A00(r0)
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdsManager r0 = com.facebook.ads.redexgen.X.AnonymousClass93.A04(r0)
                    int r0 = r0.getUniqueNativeAdCount()
                    int r4 = java.lang.Math.min(r1, r0)
                    r3 = 0
                    r0 = 2
                L1e:
                    switch(r0) {
                        case 2: goto L22;
                        case 3: goto L28;
                        case 4: goto L49;
                        default: goto L21;
                    }
                L21:
                    goto L1e
                L22:
                    if (r3 >= r4) goto L26
                    r0 = 3
                    goto L1e
                L26:
                    r0 = 4
                    goto L1e
                L28:
                    com.facebook.ads.redexgen.X.91 r5 = (com.facebook.ads.redexgen.X.AnonymousClass91) r5
                    com.facebook.ads.redexgen.X.93 r0 = com.facebook.ads.redexgen.X.AnonymousClass93.this
                    com.facebook.ads.NativeAdsManager r0 = com.facebook.ads.redexgen.X.AnonymousClass93.A04(r0)
                    com.facebook.ads.NativeAd r2 = r0.nextNativeAd()
                    com.facebook.ads.internal.api.NativeAdBaseApi r0 = r2.getInternalNativeAd()
                    com.facebook.ads.redexgen.X.HX r1 = com.facebook.ads.redexgen.X.HX.A0J(r0)
                    r0 = 1
                    r1.A1Q(r0)
                    java.util.List<com.facebook.ads.NativeAd> r0 = r5.A00
                    r0.add(r2)
                    int r3 = r3 + 1
                    r0 = 2
                    goto L1e
                L49:
                    com.facebook.ads.redexgen.X.91 r5 = (com.facebook.ads.redexgen.X.AnonymousClass91) r5
                    r5.A09()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass91.A0D():void");
            }
        };
        this.A05 = new C5T(context) { // from class: com.facebook.ads.redexgen.X.92
            public int A00 = 0;

            /* JADX INFO: Access modifiers changed from: private */
            public void A00(int i3) {
                this.A00 = i3;
            }

            public static /* synthetic */ void A01(AnonymousClass92 anonymousClass92, int i3) {
                anonymousClass92.A00(i3);
            }

            /* JADX WARN: Code restructure failed: missing block: B:29:0x0038, code lost:            r5 = r5;        super.onMeasure(r7, android.view.View.MeasureSpec.makeMeasureSpec(r3, 1073741824));     */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0043, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.C5T, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onMeasure(int r7, int r8) {
                /*
                    r6 = this;
                    r5 = r6
                    r1 = 0
                    r0 = 0
                    r0 = 0
                    r0 = 0
                    r4 = 0
                    int r3 = r5.A00
                    r2 = 0
                    r0 = 2
                La:
                    switch(r0) {
                        case 2: goto Le;
                        case 3: goto L1a;
                        case 4: goto L31;
                        case 5: goto L34;
                        case 6: goto L38;
                        default: goto Ld;
                    }
                Ld:
                    goto La
                Le:
                    com.facebook.ads.redexgen.X.92 r5 = (com.facebook.ads.redexgen.X.AnonymousClass92) r5
                    int r0 = r5.getChildCount()
                    if (r2 >= r0) goto L18
                    r0 = 3
                    goto La
                L18:
                    r0 = 6
                    goto La
                L1a:
                    com.facebook.ads.redexgen.X.92 r5 = (com.facebook.ads.redexgen.X.AnonymousClass92) r5
                    android.view.View r1 = r5.getChildAt(r2)
                    int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r4)
                    r1.measure(r7, r0)
                    int r1 = r1.getMeasuredHeight()
                    if (r1 <= r3) goto L2f
                    r0 = 4
                    goto La
                L2f:
                    r0 = 5
                    goto La
                L31:
                    r3 = r1
                    r0 = 5
                    goto La
                L34:
                    int r2 = r2 + 1
                    r0 = 2
                    goto La
                L38:
                    com.facebook.ads.redexgen.X.92 r5 = (com.facebook.ads.redexgen.X.AnonymousClass92) r5
                    r0 = 1073741824(0x40000000, float:2.0)
                    int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r0)
                    super.onMeasure(r7, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass92.onMeasure(int, int):void");
            }
        };
        if (this.A02 != null) {
            AnonymousClass92.A01(this.A05, (int) (KE.A01 * this.A02.getHeight()));
        } else if (i > 0) {
            AnonymousClass92.A01(this.A05, ((int) KE.A01) * i);
        }
        setAdapter(r3);
        setInset(20);
        r3.A0D();
        nativeAdScrollView.addView(this.A05);
    }

    public final void setInset(int insetDp) {
        if (insetDp > 0) {
            float f = KE.A01;
            int round = Math.round(insetDp * f);
            setPadding(round, 0, round, 0);
            setPageMargin(Math.round((insetDp / 2) * f));
            setClipToPadding(false);
        }
    }
}
