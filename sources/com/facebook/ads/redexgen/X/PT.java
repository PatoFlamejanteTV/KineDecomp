package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;

/* loaded from: assets/audience_network.dex */
public final class PT {
    public static boolean A00;
    public static byte[] A01;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A02(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.PT.A01
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
            r0 = r0 ^ 84
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PT.A02(int, int, int):java.lang.String");
    }

    public static void A03() {
        A01 = new byte[]{89, 116, 110, 109, 113, 124, 100, 80, 120, 105, 111, 116, 126, 110, 61, 116, 110, 61, 115, 104, 113, 113, 51, 71, 112, 102, 122, 96, 103, 118, 112, 102, 53, 124, 102, 53, 123, 96, 121, 121, 59, 77, 79, 76, 116, 67, 78, 75, 70, 67, 86, 75, 77, 76, 2, 68, 67, 75, 78, 71, 70, 12};
    }

    static {
        A03();
        A00 = true;
    }

    @Nullable
    public static BitmapDrawable A00(C0362Ec c0362Ec, @Nullable String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] decode = Base64.decode(str, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (decodeByteArray != null && (!A00 || A05(c0362Ec, decodeByteArray))) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeByteArray);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                Resources resources = c0362Ec.getResources();
                if (resources != null) {
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics != null) {
                        bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                        return bitmapDrawable;
                    }
                    A04(c0362Ec, A02(0, 23, 73));
                    return bitmapDrawable;
                }
                A04(c0362Ec, A02(23, 18, 65));
                return bitmapDrawable;
            }
            return null;
        } catch (Throwable th) {
            C0511Kb.A06(c0362Ec, A02(41, 3, 116), C0512Kc.A1O, new C0514Ke(th));
            return null;
        }
    }

    @Nullable
    public static PU A01(C0362Ec c0362Ec, @Nullable String str) {
        BitmapDrawable A002;
        try {
            if (!TextUtils.isEmpty(str) && (A002 = A00(c0362Ec, str)) != null) {
                PU pu = new PU(c0362Ec);
                if (Build.VERSION.SDK_INT >= 16) {
                    pu.setBackground(A002);
                } else {
                    pu.setBackgroundDrawable(A002);
                }
                pu.setClickable(false);
                pu.setFocusable(false);
                return pu;
            }
            return null;
        } catch (Throwable th) {
            C0511Kb.A06(c0362Ec, A02(41, 3, 116), C0512Kc.A1O, new C0514Ke(th));
            return null;
        }
    }

    public static void A04(C0362Ec c0362Ec, String str) {
        C0511Kb.A06(c0362Ec, A02(41, 3, 116), C0512Kc.A1O, new C0514Ke(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x005d, code lost:            return r2;     */
    @android.support.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A05(com.facebook.ads.redexgen.X.C0362Ec r5, android.graphics.Bitmap r6) {
        /*
            r2 = 0
            r4 = 0
            r0 = 0
            r3 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L49;
                case 3: goto L42;
                case 4: goto L35;
                case 5: goto L1b;
                case 6: goto L9;
                case 7: goto L5d;
                case 8: goto L56;
                case 9: goto L45;
                case 10: goto L5a;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.Ec r5 = (com.facebook.ads.redexgen.X.C0362Ec) r5
            r2 = 44
            r1 = 18
            r0 = 118(0x76, float:1.65E-43)
            java.lang.String r0 = A02(r2, r1, r0)
            A04(r5, r0)
            r2 = 0
            r0 = 7
            goto L5
        L1b:
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            int r0 = r6.getPixel(r3, r4)
            int r0 = android.graphics.Color.alpha(r0)
            float r1 = (float) r0
            r0 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 / r0
            r0 = 1022739087(0x3cf5c28f, float:0.03)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L32
            r0 = 6
            goto L5
        L32:
            r0 = 8
            goto L5
        L35:
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            int r0 = r6.getHeight()
            if (r4 >= r0) goto L3f
            r0 = 5
            goto L5
        L3f:
            r0 = 9
            goto L5
        L42:
            r4 = 0
            r0 = 4
            goto L5
        L45:
            int r3 = r3 + 1
            r0 = 2
            goto L5
        L49:
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            int r0 = r6.getWidth()
            if (r3 >= r0) goto L53
            r0 = 3
            goto L5
        L53:
            r0 = 10
            goto L5
        L56:
            int r4 = r4 + 1
            r0 = 4
            goto L5
        L5a:
            r2 = 1
            r0 = 7
            goto L5
        L5d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.PT.A05(com.facebook.ads.redexgen.X.Ec, android.graphics.Bitmap):boolean");
    }
}
