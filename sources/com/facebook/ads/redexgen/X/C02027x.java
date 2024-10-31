package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdOptionsViewApi;

/* renamed from: com.facebook.ads.redexgen.X.7x, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C02027x extends C02017w implements AdOptionsViewApi {
    public static byte[] A03;
    public static final int A04;
    public static final int A05;
    public final ImageView A00;
    public final ImageView A01;
    public final AdOptionsView A02;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C02027x.A03
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
            int r0 = r0 + (-37)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02027x.A01(int, int, int):java.lang.String");
    }

    public static void A02() {
        A03 = new byte[]{-125, -106, -95, -96, -93, -91, 81, 114, -107};
    }

    static {
        A02();
        A04 = (int) (KE.A01 * 23.0f);
        A05 = (int) (KE.A01 * 4.0f);
    }

    public C02027x(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i, AdOptionsView adOptionsView) {
        this.A02 = adOptionsView;
        LinearLayout linearLayout = new LinearLayout(context);
        this.A02.addView(linearLayout);
        linearLayout.setOrientation(orientation == AdOptionsView.Orientation.HORIZONTAL ? 0 : 1);
        this.A01 = A00(KM.DEFAULT_INFO_ICON);
        this.A00 = A00(KM.AD_CHOICES_ICON);
        this.A00.setContentDescription(A01(0, 9, 12));
        linearLayout.addView(this.A01);
        linearLayout.addView(this.A00);
        setIconSizeDp(i);
        setIconColor(-10459280);
        final HX A0J = HX.A0J(nativeAdBase.getInternalNativeAd());
        A0J.A1J(nativeAdLayout);
        A0J.A1K(this);
        C00371i A0t = A0J.A0t();
        if (A0t != null && A0t.A0e() && !A0t.A0c()) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.7v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (C0466Ig.A02(this)) {
                        return;
                    }
                    try {
                        A0J.A1B();
                    } catch (Throwable th) {
                        C0466Ig.A00(th, this);
                    }
                }
            });
            EnumC0489Je.A04(this.A02, EnumC0489Je.A0B);
        }
    }

    public C02027x(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        this(context, nativeAdBase, nativeAdLayout, AdOptionsView.Orientation.HORIZONTAL, 23, adOptionsView);
    }

    private ImageView A00(KM km) {
        ImageView imageView = new ImageView(this.A02.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(A05, A05, A05, A05);
        imageView.setImageBitmap(KN.A00(km));
        return imageView;
    }

    public final void A03(KM km) {
        this.A01.setImageBitmap(KN.A00(km));
    }

    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    public final void setIconColor(int i) {
        this.A01.setColorFilter(i);
        this.A00.setColorFilter(i);
    }

    public final void setIconSizeDp(int i) {
        int max = Math.max(A04, (int) (KE.A01 * i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(max, max);
        this.A01.setLayoutParams(layoutParams);
        this.A00.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.C02017w
    public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = -2;
        super.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            com.facebook.ads.redexgen.X.KE.A0Q(r1, r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0019, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setSingleIcon(boolean r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            android.widget.ImageView r1 = r3.A01
            if (r4 == 0) goto L12
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L14;
                case 4: goto Lf;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            r2 = 8
            r0 = 3
            goto L7
        Lf:
            r2 = 0
            r0 = 3
            goto L7
        L12:
            r0 = 4
            goto L7
        L14:
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            com.facebook.ads.redexgen.X.KE.A0Q(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02027x.setSingleIcon(boolean):void");
    }
}
