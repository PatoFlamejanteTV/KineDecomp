package com.facebook.ads.redexgen.X;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Ms, reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0579Ms extends LinearLayout {
    public static final int A03 = (int) (40.0f * KE.A01);
    public static final int A04 = (int) (20.0f * KE.A01);
    public static final int A05 = (int) (10.0f * KE.A01);
    public final AnonymousClass46 A00;
    public final C0362Ec A01;
    public final MX A02;

    public C0579Ms(C0362Ec c0362Ec, AnonymousClass46 anonymousClass46, MX mx, KM km) {
        this(c0362Ec, anonymousClass46, mx, null, km);
    }

    public C0579Ms(C0362Ec c0362Ec, AnonymousClass46 anonymousClass46, MX mx, @Nullable String str, KM km) {
        super(c0362Ec);
        this.A01 = c0362Ec;
        this.A00 = anonymousClass46;
        this.A02 = mx;
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            View A02 = A02(str);
            A02.setPadding(0, 0, 0, 0);
            View view = new View(getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            KE.A0P(view, -10459280);
            addView(A02, layoutParams);
            addView(view);
        }
        if (!TextUtils.isEmpty(this.A00.A03())) {
            View A01 = A01(km, this.A00.A03());
            A01.setPadding(0, A05, 0, A05);
            addView(A01, layoutParams);
        }
        View A00 = A00();
        A00.setPadding(0, A05, 0, 0);
        addView(A00, layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View A00() {
        /*
            r7 = this;
            r6 = r7
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.Mz r5 = new com.facebook.ads.redexgen.X.Mz
            com.facebook.ads.redexgen.X.Ec r0 = r6.A01
            r5.<init>(r0)
            com.facebook.ads.redexgen.X.46 r0 = r6.A00
            java.util.List r0 = r0.A05()
            java.util.Iterator r4 = r0.iterator()
            r0 = 2
        L15:
            switch(r0) {
                case 2: goto L19;
                case 3: goto L25;
                case 4: goto L4d;
                default: goto L18;
            }
        L18:
            goto L15
        L19:
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L23
            r0 = 3
            goto L15
        L23:
            r0 = 4
            goto L15
        L25:
            com.facebook.ads.redexgen.X.Ms r6 = (com.facebook.ads.redexgen.X.C0579Ms) r6
            com.facebook.ads.redexgen.X.Mz r5 = (com.facebook.ads.redexgen.X.C0586Mz) r5
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r3 = r4.next()
            com.facebook.ads.redexgen.X.46 r3 = (com.facebook.ads.redexgen.X.AnonymousClass46) r3
            com.facebook.ads.redexgen.X.Mc r2 = new com.facebook.ads.redexgen.X.Mc
            com.facebook.ads.redexgen.X.Ec r0 = r6.A01
            r2.<init>(r0)
            java.lang.String r1 = r3.A04()
            r0 = 0
            r2.setData(r1, r0)
            com.facebook.ads.redexgen.X.Mr r0 = new com.facebook.ads.redexgen.X.Mr
            r0.<init>(r6, r2, r3)
            r2.setOnClickListener(r0)
            r5.addView(r2)
            r0 = 2
            goto L15
        L4d:
            com.facebook.ads.redexgen.X.Mz r5 = (com.facebook.ads.redexgen.X.C0586Mz) r5
            android.view.View r5 = (android.view.View) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0579Ms.A00():android.view.View");
    }

    private View A01(KM km, String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A04, A04);
        layoutParams.gravity = 16;
        imageView.setImageBitmap(KN.A00(km));
        TextView textView = new TextView(getContext());
        KE.A0Y(textView, true, 14);
        textView.setTextColor(-10459280);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        textView.setText(str);
        textView.setPadding(A05, 0, 0, 0);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private View A02(String str) {
        ImageView imageView = new ImageView(getContext());
        imageView.setColorFilter(-10459280);
        imageView.setImageBitmap(KN.A00(KM.BACK_ARROW));
        imageView.setPadding(0, A05, A05 * 2, A05);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A03, A03);
        imageView.setOnClickListener(new ViewOnClickListenerC0577Mq(this));
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setText(str);
        KE.A0Y(textView, true, 16);
        textView.setTextColor(-14934495);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, A03, 0);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }
}
