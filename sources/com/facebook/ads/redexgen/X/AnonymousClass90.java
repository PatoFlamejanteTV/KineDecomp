package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.VideoAutoplayBehavior;
import com.facebook.ads.internal.api.NativeAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.90, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass90 implements NativeAdApi {
    public final NativeAd A00;
    public final NativeAdBaseApi A01;

    public AnonymousClass90(NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        this.A00 = nativeAd;
        this.A01 = nativeAdBaseApi;
        HX.A0J(nativeAdBaseApi).A1O(EnumC0458Hx.A06);
    }

    public AnonymousClass90(NativeAdBase nativeAdBase, NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        this.A00 = nativeAd;
        this.A01 = nativeAdBaseApi;
    }

    private HX A00() {
        return HX.A0J(this.A01);
    }

    @Nullable
    public final String A01() {
        return A00().A17();
    }

    @Nullable
    public final String A02() {
        return A00().A18();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:            return r3;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.facebook.ads.NativeAd> A03() {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            com.facebook.ads.redexgen.X.HX r0 = r5.A00()
            java.util.List r0 = r0.A1A()
            if (r0 != 0) goto L4e
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L50;
                case 4: goto L15;
                case 5: goto L42;
                case 6: goto L2a;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            r3 = 0
            r0 = 3
            goto Le
        L15:
            com.facebook.ads.redexgen.X.90 r5 = (com.facebook.ads.redexgen.X.AnonymousClass90) r5
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.facebook.ads.redexgen.X.HX r0 = r5.A00()
            java.util.List r0 = r0.A1A()
            java.util.Iterator r4 = r0.iterator()
            r0 = 5
            goto Le
        L2a:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r2 = r4.next()
            com.facebook.ads.redexgen.X.HX r2 = (com.facebook.ads.redexgen.X.HX) r2
            com.facebook.ads.NativeAd r1 = new com.facebook.ads.NativeAd
            com.facebook.ads.redexgen.X.Ec r0 = r2.A0v()
            r1.<init>(r0, r2)
            r3.add(r1)
            r0 = 5
            goto Le
        L42:
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L4c
            r0 = 6
            goto Le
        L4c:
            r0 = 3
            goto Le
        L4e:
            r0 = 4
            goto Le
        L50:
            java.util.List r3 = (java.util.List) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass90.A03():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x007b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.NativeAd.AdCreativeType getAdCreativeType() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            com.facebook.ads.redexgen.X.HX r0 = r2.A00()
            java.lang.String r0 = r0.A18()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L75
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L3d;
                case 3: goto L77;
                case 4: goto L2d;
                case 5: goto L19;
                case 6: goto L15;
                case 7: goto L41;
                case 8: goto L53;
                case 9: goto L6d;
                case 10: goto L71;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.NativeAd$AdCreativeType r1 = com.facebook.ads.NativeAd.AdCreativeType.CAROUSEL
            r0 = 3
            goto L11
        L19:
            com.facebook.ads.redexgen.X.90 r2 = (com.facebook.ads.redexgen.X.AnonymousClass90) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A00()
            java.util.List r0 = r0.A1A()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L2b
            r0 = 6
            goto L11
        L2b:
            r0 = 7
            goto L11
        L2d:
            com.facebook.ads.redexgen.X.90 r2 = (com.facebook.ads.redexgen.X.AnonymousClass90) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A00()
            java.util.List r0 = r0.A1A()
            if (r0 == 0) goto L3b
            r0 = 5
            goto L11
        L3b:
            r0 = 7
            goto L11
        L3d:
            com.facebook.ads.NativeAd$AdCreativeType r1 = com.facebook.ads.NativeAd.AdCreativeType.VIDEO
            r0 = 3
            goto L11
        L41:
            com.facebook.ads.redexgen.X.90 r2 = (com.facebook.ads.redexgen.X.AnonymousClass90) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A00()
            com.facebook.ads.redexgen.X.HY r0 = r0.getAdCoverImage()
            if (r0 == 0) goto L50
            r0 = 8
            goto L11
        L50:
            r0 = 10
            goto L11
        L53:
            com.facebook.ads.redexgen.X.90 r2 = (com.facebook.ads.redexgen.X.AnonymousClass90) r2
            com.facebook.ads.redexgen.X.HX r0 = r2.A00()
            com.facebook.ads.redexgen.X.HY r0 = r0.getAdCoverImage()
            java.lang.String r0 = r0.getUrl()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L6a
            r0 = 9
            goto L11
        L6a:
            r0 = 10
            goto L11
        L6d:
            com.facebook.ads.NativeAd$AdCreativeType r1 = com.facebook.ads.NativeAd.AdCreativeType.IMAGE
            r0 = 3
            goto L11
        L71:
            com.facebook.ads.NativeAd$AdCreativeType r1 = com.facebook.ads.NativeAd.AdCreativeType.UNKNOWN
            r0 = 3
            goto L11
        L75:
            r0 = 4
            goto L11
        L77:
            com.facebook.ads.NativeAd$AdCreativeType r1 = (com.facebook.ads.NativeAd.AdCreativeType) r1
            com.facebook.ads.NativeAd$AdCreativeType r1 = (com.facebook.ads.NativeAd.AdCreativeType) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass90.getAdCreativeType():com.facebook.ads.NativeAd$AdCreativeType");
    }

    public final VideoAutoplayBehavior getVideoAutoplayBehavior() {
        return EnumC0447Hk.A00(A00().A12());
    }

    public final void registerViewForInteraction(View view, MediaView mediaView) {
        registerViewForInteraction(view, mediaView, (MediaView) null);
    }

    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable ImageView imageView) {
        registerViewForInteraction(view, mediaView, imageView, (List<View>) null);
    }

    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable ImageView imageView, @Nullable List<View> list) {
        if (imageView != null) {
            C0362Ec A0v = A00().A0v();
            C0362Ec A02 = C8N.A02(imageView.getContext());
            A02.A0C(A0v);
            HX.A0d(A00().getAdIcon(), imageView, A02);
        }
        registerViewForInteraction(view, mediaView, (MediaView) null, list);
    }

    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable MediaView mediaView2) {
        registerViewForInteraction(view, mediaView, mediaView2, (List<View>) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void registerViewForInteraction(android.view.View r5, com.facebook.ads.MediaView r6, @android.support.annotation.Nullable com.facebook.ads.MediaView r7, @android.support.annotation.Nullable java.util.List<android.view.View> r8) {
        /*
            r4 = this;
            r3 = r4
            if (r6 == 0) goto L5c
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L4b;
                case 3: goto L22;
                case 4: goto L39;
                case 5: goto L19;
                case 6: goto L8;
                case 7: goto L5e;
                case 8: goto L2a;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.90 r3 = (com.facebook.ads.redexgen.X.AnonymousClass90) r3
            android.view.View r5 = (android.view.View) r5
            com.facebook.ads.MediaView r6 = (com.facebook.ads.MediaView) r6
            java.util.List r8 = (java.util.List) r8
            com.facebook.ads.redexgen.X.HX r0 = r3.A00()
            r0.A1G(r5, r6, r8)
            r0 = 7
            goto L4
        L19:
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L1f
            r0 = 6
            goto L4
        L1f:
            r0 = 8
            goto L4
        L22:
            com.facebook.ads.MediaView r7 = (com.facebook.ads.MediaView) r7
            if (r7 == 0) goto L28
            r0 = 4
            goto L4
        L28:
            r0 = 5
            goto L4
        L2a:
            com.facebook.ads.redexgen.X.90 r3 = (com.facebook.ads.redexgen.X.AnonymousClass90) r3
            android.view.View r5 = (android.view.View) r5
            com.facebook.ads.MediaView r6 = (com.facebook.ads.MediaView) r6
            com.facebook.ads.redexgen.X.HX r0 = r3.A00()
            r0.A1F(r5, r6)
            r0 = 7
            goto L4
        L39:
            com.facebook.ads.redexgen.X.90 r3 = (com.facebook.ads.redexgen.X.AnonymousClass90) r3
            com.facebook.ads.MediaView r7 = (com.facebook.ads.MediaView) r7
            com.facebook.ads.internal.api.MediaViewApi r2 = r7.getMediaViewApi()
            com.facebook.ads.redexgen.X.8j r2 = (com.facebook.ads.redexgen.X.C02148j) r2
            com.facebook.ads.internal.api.NativeAdBaseApi r1 = r3.A01
            r0 = 0
            r2.A0I(r1, r0)
            r0 = 5
            goto L4
        L4b:
            com.facebook.ads.redexgen.X.90 r3 = (com.facebook.ads.redexgen.X.AnonymousClass90) r3
            com.facebook.ads.MediaView r6 = (com.facebook.ads.MediaView) r6
            com.facebook.ads.internal.api.MediaViewApi r1 = r6.getMediaViewApi()
            com.facebook.ads.redexgen.X.8j r1 = (com.facebook.ads.redexgen.X.C02148j) r1
            com.facebook.ads.NativeAd r0 = r3.A00
            r1.A0H(r0)
            r0 = 3
            goto L4
        L5c:
            r0 = 3
            goto L4
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass90.registerViewForInteraction(android.view.View, com.facebook.ads.MediaView, com.facebook.ads.MediaView, java.util.List):void");
    }

    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable List<View> list) {
        registerViewForInteraction(view, mediaView, (MediaView) null, list);
    }
}
