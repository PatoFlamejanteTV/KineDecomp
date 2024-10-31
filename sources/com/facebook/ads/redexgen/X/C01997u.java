package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Paint;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.internal.api.AdChoicesViewApi;

/* renamed from: com.facebook.ads.redexgen.X.7u, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C01997u implements AdChoicesViewApi {
    public static byte[] A07;
    public TextView A00;
    public String A01;
    public boolean A02 = false;
    public final float A03 = KE.A01;
    public final AdChoicesView A04;
    public final NativeAdBase A05;
    public final C0362Ec A06;

    static {
        A07();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A04(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C01997u.A07
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
            int r0 = r0 + (-10)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01997u.A04(int, int, int):java.lang.String");
    }

    public static void A07() {
        A07 = new byte[]{-112, -77, -110, -73, -66, -72, -78, -76, -62};
    }

    public C01997u(AdChoicesView adChoicesView, Context context, NativeAdBase nativeAdBase) {
        this.A04 = adChoicesView;
        this.A06 = C8N.A02(context);
        this.A05 = nativeAdBase;
    }

    private ImageView A00(HY hy) {
        ImageView imageView = new ImageView(this.A04.getContext());
        this.A04.addView(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(hy.getWidth() * this.A03), Math.round(hy.getHeight() * this.A03));
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(Math.round(4.0f * this.A03), Math.round(this.A03 * 2.0f), Math.round(this.A03 * 2.0f), Math.round(this.A03 * 2.0f));
        imageView.setLayoutParams(layoutParams);
        HX.A0d(hy, imageView, this.A06);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        Paint p = new Paint();
        p.setTextSize(this.A00.getTextSize());
        int round = Math.round(p.measureText(this.A01) + (4.0f * this.A03));
        final int width = this.A04.getWidth();
        final int targetWidth = width - round;
        Animation animation = new Animation() { // from class: com.facebook.ads.redexgen.X.7s
            @Override // android.view.animation.Animation
            public final void applyTransformation(float f, Transformation transformation) {
                AdChoicesView adChoicesView;
                AdChoicesView adChoicesView2;
                TextView textView;
                TextView textView2;
                int i = (int) (width + ((targetWidth - width) * f));
                adChoicesView = C01997u.this.A04;
                adChoicesView.getLayoutParams().width = i;
                adChoicesView2 = C01997u.this.A04;
                adChoicesView2.requestLayout();
                textView = C01997u.this.A00;
                textView.getLayoutParams().width = i - targetWidth;
                textView2 = C01997u.this.A00;
                textView2.requestLayout();
            }

            @Override // android.view.animation.Animation
            public final boolean willChangeBounds() {
                return true;
            }
        };
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.facebook.ads.redexgen.X.7t
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation2) {
                C01997u.this.A02 = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation2) {
            }
        });
        animation.setDuration(300L);
        animation.setFillAfter(true);
        this.A04.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        Paint paint = new Paint();
        paint.setTextSize(this.A00.getTextSize());
        int round = Math.round(paint.measureText(this.A01) + (4.0f * this.A03));
        final int startWidth = this.A04.getWidth();
        final int textWidth = startWidth + round;
        this.A02 = true;
        Animation animation = new Animation() { // from class: com.facebook.ads.redexgen.X.7p
            @Override // android.view.animation.Animation
            public final void applyTransformation(float f, Transformation transformation) {
                AdChoicesView adChoicesView;
                AdChoicesView adChoicesView2;
                TextView textView;
                TextView textView2;
                int i = (int) (startWidth + ((textWidth - startWidth) * f));
                adChoicesView = C01997u.this.A04;
                adChoicesView.getLayoutParams().width = i;
                adChoicesView2 = C01997u.this.A04;
                adChoicesView2.requestLayout();
                textView = C01997u.this.A00;
                textView.getLayoutParams().width = i - startWidth;
                textView2 = C01997u.this.A00;
                textView2.requestLayout();
            }

            @Override // android.view.animation.Animation
            public final boolean willChangeBounds() {
                return true;
            }
        };
        animation.setAnimationListener(new AnimationAnimationListenerC01977r(this));
        animation.setDuration(300L);
        animation.setFillAfter(true);
        this.A04.startAnimation(animation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x014e, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void initialize(boolean r10, @android.support.annotation.Nullable com.facebook.ads.NativeAdLayout r11) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01997u.initialize(boolean, com.facebook.ads.NativeAdLayout):void");
    }
}
