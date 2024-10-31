package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.View;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.facebook.ads.redexgen.X.24, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass24 extends C1H {
    public static byte[] A0E;
    public View A00;

    @Nullable
    public View A01;
    public AnonymousClass22 A02;
    public AnonymousClass23 A03;
    public EnumC0445Hi A04;

    @Nullable
    public String A05;
    public List<View> A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C00371i A0D;

    static {
        A05();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A01(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.AnonymousClass24.A0E
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass24.A01(int, int, int):java.lang.String");
    }

    public static void A05() {
        A0E = new byte[]{59, 52, 56, 61, 33, 37, 41, 47, 45, Byte.MAX_VALUE, 112, 124, 102, 126, 118, 119, 122, 114, 101, 122, 118, 100, 57, 54, 37, 54, 37, 73, 82, 87, 82, 83, 75, 82, Byte.MAX_VALUE, 120, 103, 100, 103, 124, 107, 122, 82, 77, 65, 83, 67, 86, 75, 81, 84, 32, 61, 50, 35, 32, 59, 60, 39, 42, 48, 35, 60, 53, 47, 50, 22, 27, 18, 7, 20, 27, 22, 4, 4, 49, 44, 32, 38, 53, 11, 60, 61, 58, 32, 39, 69, 70, 93, 36, 51, 50, 50, 41, 40, 57, 47, 58, 62, 85, 68, 89, 85, 97, 88, 68, 69, 11, 78, 83, 72, 78, 91, 95, 66, 68, 69, 70, 74, 95, 65, 94, 63, 61, 42, 44, 46, 44, 39, 42, 16, 34, 42, 43, 38, 46, 39, 56, 52, 38, 77, 94, 12, 19, 82, 26, 22, 65, 12, 19, 82, 75, 52, 49, 43, 44, 89, 68, 95, 81, 95, 88, 52, 55, 117, 106, 43, 99, 111, 54, 117, 106, 43, 50, 63, 50, 3, 5, 30, 104, 103, 98, 104, 96, 106, 105, 103, 110};
    }

    public AnonymousClass24(C0362Ec c0362Ec, C1I c1i, FP fp, C00371i c00371i) {
        super(c0362Ec, c1i, fp);
        this.A02 = AnonymousClass22.A03;
        this.A03 = null;
        this.A0D = c00371i;
    }

    private String A02(View view) {
        try {
            return A04(view).toString();
        } catch (JSONException unused) {
            return A01(103, 14, 62);
        }
    }

    private String A03(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return A01(42, 0, 13);
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            Canvas canvas = new Canvas(createBitmap);
            view.draw(canvas);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, this.A0D.A0D(), byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception unused) {
            return A01(42, 0, 13);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x01b4, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject A04(android.view.View r15) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass24.A04(android.view.View):org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:185:0x024b, code lost:            return;     */
    @Override // com.facebook.ads.redexgen.X.C1H
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A06(java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass24.A06(java.util.Map):void");
    }

    public final void A07(@Nullable View view) {
        this.A01 = view;
    }

    public final void A08(View view) {
        this.A00 = view;
    }

    public final void A09(AnonymousClass22 anonymousClass22) {
        this.A02 = anonymousClass22;
    }

    public final void A0A(AnonymousClass23 anonymousClass23) {
        this.A03 = anonymousClass23;
    }

    public final void A0B(EnumC0445Hi enumC0445Hi) {
        this.A04 = enumC0445Hi;
    }

    public final void A0C(@Nullable String str) {
        this.A05 = str;
    }

    public final void A0D(List<View> clickableViews) {
        this.A06 = clickableViews;
    }

    public final void A0E(boolean z) {
        this.A07 = z;
    }

    public final void A0F(boolean z) {
        this.A08 = z;
    }

    public final void A0G(boolean z) {
        this.A09 = z;
    }

    public final void A0H(boolean z) {
        this.A0A = z;
    }

    public final void A0I(boolean z) {
        this.A0B = z;
    }

    public final void A0J(boolean z) {
        this.A0C = z;
    }
}
