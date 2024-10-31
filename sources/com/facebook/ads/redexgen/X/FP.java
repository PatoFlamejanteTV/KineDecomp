package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.VisibleForTesting;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

/* loaded from: assets/audience_network.dex */
public final class FP {
    public static byte[] A0G;
    public static final String A0H;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public AbstractRunnableC00351g A04;
    public FO A05;
    public Map<String, Integer> A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final Handler A0B;
    public final View A0C;
    public final C0362Ec A0D;
    public final WeakReference<AnonymousClass29> A0E;
    public final boolean A0F;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0H(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.FP.A0G
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
            r0 = r0 ^ 85
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A0H(int, int, int):java.lang.String");
    }

    public static void A0M() {
        A0G = new byte[]{118, 83, 23, 94, 68, 23, 88, 89, 23, 67, 88, 71, 23, 88, 81, 23, 67, 95, 82, 23, 123, 88, 84, 92, 68, 84, 69, 82, 82, 89, 25, 71, 107, 78, 124, 67, 79, 93, 10, 92, 67, 89, 67, 72, 70, 79, 10, 75, 88, 79, 75, 10, 67, 89, 10, 94, 69, 69, 10, 89, 71, 75, 70, 70, 10, 113, 15, 4, 24, 76, 15, 15, 10, 92, 67, 89, 67, 72, 70, 79, 6, 10, 73, 95, 88, 88, 79, 68, 94, 10, 94, 66, 88, 79, 89, 66, 69, 70, 78, 10, 15, 4, 24, 76, 15, 15, 119, 73, 86, 90, 72, 94, 93, 83, 90, 76, 112, 125, 56, 108, 113, 123, 115, 125, 106, 56, 123, 121, 118, 118, 119, 108, 56, 122, 125, 56, 118, 125, Byte.MAX_VALUE, 121, 108, 113, 110, 125, 125, 81, 116, 70, 121, 117, 103, 48, 103, 121, 126, 116, Byte.MAX_VALUE, 103, 48, 121, 99, 48, 126, Byte.MAX_VALUE, 100, 48, 99, 117, 100, 48, 100, Byte.MAX_VALUE, 48, 70, 89, 67, 89, 82, 92, 85, 62, 51, 45, 42, 32, 43, 51, 53, 124, 102, 53, 39, 5, 10, 10, 11, 16, 68, 3, 1, 16, 68, 8, 11, 7, 5, 16, 13, 11, 10, 68, 11, 10, 68, 23, 7, 22, 1, 1, 10, 74, 34, 9, 3, 21, 8, 65, 18, 70, 11, 7, 13, 3, 70, 21, 3, 8, 21, 3, 70, 18, 9, 70, 21, 3, 18, 70, 5, 14, 3, 5, 13, 70, 15, 8, 18, 3, 20, 16, 7, 10, 70, 0, 9, 20, 70, 8, 9, 8, 75, 20, 3, 22, 3, 7, 18, 70, 5, 14, 3, 5, 13, 3, 20, 72, 110, 57, 39, 58, 38, 110, 60, 43, 47, 61, 33, 32, 116, 110, 19, 63, 26, 40, 23, 27, 9, 94, 22, 31, 13, 94, 23, 16, 8, 23, 13, 23, 28, 18, 27, 94, 26, 23, 19, 27, 16, 13, 23, 17, 16, 13, 94, 86, 9, 67, 93, 95, 120, 72, 89, 78, 78, 69, 11, 66, 88, 11, 69, 68, 95, 11, 66, 69, 95, 78, 89, 74, 72, 95, 66, 93, 78, 5, 42, 43, 48, 100, 50, 45, 33, 51, 37, 38, 40, 33, 0, 44, 9, 59, 4, 8, 26, 77, 4, 30, 77, 3, 24, 1, 1, 67, 29, 21, 24, 19, 12, 91, 24, 24, 20, 112, 92, 121, 75, 116, 120, 106, 61, 116, 110, 61, 115, 114, 105, 61, 107, 116, 110, 116, Byte.MAX_VALUE, 113, 120, 61, 123, 111, 114, 112, 61, 105, 117, 120, 61, Byte.MAX_VALUE, 114, 105, 105, 114, 112, 51, 77, 83, 123, 68, 72, 90, 13, 76, 96, 69, 119, 72, 68, 86, 1, 72, 82, 1, 79, 78, 85, 1, 87, 72, 82, 72, 67, 77, 68, 1, 71, 83, 78, 76, 1, 85, 73, 68, 1, 85, 78, 81, 15, 20, 24, 26, 89, 17, 22, 20, 18, 21, 24, 24, 28, 89, 22, 19, 4, 89, 30, 25, 3, 18, 5, 25, 22, 27, 89, 1, 30, 18, 0, 89, 49, 2, 27, 27, 36, 20, 5, 18, 18, 25, 54, 19, 35, 24, 24, 27, 21, 22, 5, 55, 25, 5, 27, 9, 29, 14, 24, 92, 21, 15, 92, 19, 30, 15, 8, 14, 9, 31, 8, 21, 18, 27, 92, 10, 21, 25, 11, 82, 92, 88, 73, 56, 20, 49, 3, 60, 48, 34, 117, 60, 38, 117, 33, 58, 58, 117, 33, 39, 52, 59, 38, 37, 52, 39, 48, 59, 33, 123, 52, 24, 61, 15, 48, 60, 46, 121, 48, 42, 121, 55, 54, 45, 121, 63, 44, 53, 53, 32, 121, 54, 55, 121, 42, 58, 43, 60, 60, 55, 121, 49, 54, 43, 48, 35, 54, 55, 45, 56, 53, 53, 32, 119, 53, 51, 78, 98, 71, 117, 74, 70, 84, 3, 83, 66, 81, 70, 77, 87, 3, 74, 80, 3, 77, 76, 87, 3, 80, 70, 87, 3, 87, 76, 3, 117, 106, 112, 106, 97, 111, 102, 13, 60, 16, 53, 7, 56, 52, 38, 113, 57, 48, 34, 113, 63, 62, 113, 33, 48, 35, 52, 63, 37, Byte.MAX_VALUE, 23, 27, 83, 6, 109, 65, 100, 86, 105, 101, 119, 32, 105, 115, 32, 118, 105, 115, 105, 98, 108, 101, 46};
    }

    static {
        A0M();
        A0H = FP.class.getSimpleName();
    }

    public FP(View view, int i, int i2, boolean z, AnonymousClass29 anonymousClass29, C0362Ec c0362Ec) {
        this.A0B = new Handler();
        this.A01 = 0;
        this.A02 = 1000;
        this.A08 = true;
        this.A05 = new FO(EnumC00040b.A0K);
        this.A06 = new HashMap();
        this.A03 = 0L;
        this.A00 = 0;
        this.A07 = true;
        this.A0D = c0362Ec;
        this.A0C = view;
        if (this.A0C.getId() == -1) {
            KE.A0N(this.A0C);
        }
        this.A0A = i;
        this.A0E = new WeakReference<>(anonymousClass29);
        this.A0F = z;
        if (i2 < 0) {
            if (BuildConfigApi.isDebug()) {
                Log.w(A0H, A0H(115, 29, 77));
            }
            i2 = 0;
        }
        this.A09 = i2;
    }

    public FP(View view, int i, AnonymousClass29 anonymousClass29, C0362Ec c0362Ec) {
        this(view, i, 0, false, anonymousClass29, c0362Ec);
    }

    public FP(View view, int i, boolean z, AnonymousClass29 anonymousClass29, C0362Ec c0362Ec) {
        this(view, i, 0, z, anonymousClass29, c0362Ec);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0044, code lost:            return r1;     */
    @android.support.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static float A00(android.view.View r3) {
        /*
            r0 = 0
            r0 = 0
            r2 = 0
            float r1 = r3.getAlpha()
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L2c;
                case 4: goto L29;
                case 5: goto L1f;
                case 6: goto Lc;
                case 7: goto L41;
                case 8: goto L44;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r2 = 1065353216(0x3f800000, float:1.0)
            r0 = 7
            goto L8
        L10:
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            boolean r0 = r0 instanceof android.view.ViewGroup
            if (r0 == 0) goto L1c
            r0 = 3
            goto L8
        L1c:
            r0 = 8
            goto L8
        L1f:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L27
            r0 = 6
            goto L8
        L27:
            r0 = 7
            goto L8
        L29:
            r2 = 0
            r0 = 5
            goto L8
        L2c:
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r3 = r3.getParent()
            android.view.View r3 = (android.view.View) r3
            float r2 = r3.getAlpha()
            r0 = 0
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L3f
            r0 = 4
            goto L8
        L3f:
            r0 = 5
            goto L8
        L41:
            float r1 = r1 * r2
            r0 = 2
            goto L8
        L44:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A00(android.view.View):float");
    }

    @VisibleForTesting
    public static int A01(int i, View view) {
        return (int) Math.max(i, Math.ceil(view.getWidth() * view.getHeight() > 0 ? 100.0f / r1 : 100.0f));
    }

    public static /* synthetic */ int A05(FP fp) {
        int i = fp.A00;
        fp.A00 = i + 1;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x012b, code lost:            return r21;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A08(java.util.Vector<android.graphics.Rect> r21) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A08(java.util.Vector):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0035, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A09(int[] r4, int r5) {
        /*
            r3 = 0
            r0 = 0
            r0 = 0
            r2 = 0
            int r1 = r4.length
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L27;
                case 3: goto L17;
                case 4: goto L35;
                case 5: goto La;
                case 6: goto L14;
                case 7: goto L2e;
                case 8: goto L32;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            int[] r4 = (int[]) r4
            r0 = r4[r3]
            if (r0 <= r5) goto L12
            r0 = 6
            goto L6
        L12:
            r0 = 7
            goto L6
        L14:
            r1 = r3
            r0 = 2
            goto L6
        L17:
            int[] r4 = (int[]) r4
            int r0 = r1 - r2
            int r0 = r0 / 2
            int r3 = r2 + r0
            r0 = r4[r3]
            if (r0 != r5) goto L25
            r0 = 4
            goto L6
        L25:
            r0 = 5
            goto L6
        L27:
            if (r2 >= r1) goto L2b
            r0 = 3
            goto L6
        L2b:
            r0 = 8
            goto L6
        L2e:
            int r2 = r3 + 1
            r0 = 2
            goto L6
        L32:
            r3 = -1
            r0 = 4
            goto L6
        L35:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A09(int[], int):int");
    }

    public static FO A0E(View view, int i, C0362Ec c0362Ec) {
        DisplayMetrics displayMetrics;
        if (view == null) {
            A0N(null, false, A0H(375, 16, 56));
            return new FO(EnumC00040b.A07);
        }
        if (view.getParent() == null) {
            A0N(view, false, A0H(674, 22, 4));
            return new FO(EnumC00040b.A0G);
        }
        if (!view.isShown()) {
            A0N(view, false, A0H(637, 37, 118));
            return new FO(EnumC00040b.A0G);
        }
        if (view.getWindowVisibility() != 0) {
            A0N(view, false, A0H(144, 37, 69));
            return new FO(EnumC00040b.A0H);
        }
        if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            A0N(view, false, A0H(299, 36, 43) + view.getMeasuredWidth() + A0H(696, 4, 110) + view.getMeasuredHeight());
            return new FO(EnumC00040b.A0F);
        }
        if (A00(view) < 0.9f) {
            A0N(view, false, A0H(564, 27, 0));
            return new FO(EnumC00040b.A0A);
        }
        int areaSize = view.getWidth();
        int height = view.getHeight();
        int[] iArr = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                return new FO(EnumC00040b.A06);
            }
            if (Build.VERSION.SDK_INT >= 17) {
                Display display = ((WindowManager) c0362Ec.getSystemService(A0H(181, 6, 17))).getDefaultDisplay();
                displayMetrics = new DisplayMetrics();
                display.getRealMetrics(displayMetrics);
            } else {
                displayMetrics = c0362Ec.getResources().getDisplayMetrics();
            }
            Vector<Rect> rectVector = A0K(view);
            int A08 = A08(rectVector);
            rectVector.add(rect);
            float A082 = ((A08(rectVector) - A08) * 1.0f) / (view.getMeasuredHeight() * view.getMeasuredWidth());
            boolean A16 = C0413Gc.A16(c0362Ec);
            int A01 = A01(i, view);
            float f = A01 / 100.0f;
            if (A16) {
                if (A082 < f) {
                    A0N(view, false, String.format(Locale.US, A0H(31, 76, 127), Float.valueOf(A082), Float.valueOf(f)));
                    return new FO(EnumC00040b.A03, A082);
                }
            } else {
                if (iArr[0] < 0 || displayMetrics.widthPixels - iArr[0] < areaSize) {
                    A0N(view, false, A0H(591, 44, 12));
                    return new FO(EnumC00040b.A0C, A082);
                }
                int i2 = (int) ((height * (100.0d - A01)) / 100.0d);
                if (rect.top - iArr[1] > i2) {
                    A0N(view, false, A0H(446, 36, 116));
                    return new FO(EnumC00040b.A0D, A082);
                }
                int bottomDistance = (iArr[1] + height) - rect.bottom;
                if (bottomDistance > i2) {
                    A0N(view, false, A0H(400, 39, 72));
                    return new FO(EnumC00040b.A0B, A082);
                }
            }
            if (!C0519Kj.A03(c0362Ec)) {
                A0N(view, false, A0H(337, 26, 126));
                return new FO(EnumC00040b.A0J, A082);
            }
            Map<String, String> A012 = C0520Kk.A01(c0362Ec);
            if (KF.A04(A012)) {
                A0N(view, false, A0H(532, 29, 41));
                return new FO(EnumC00040b.A09, A082);
            }
            if (C0413Gc.A0s(c0362Ec) && KF.A03(A012)) {
                A0N(view, false, A0H(0, 31, 98));
                return new FO(EnumC00040b.A04, A082, A012);
            }
            A0N(view, true, A0H(700, 19, 85));
            return new FO(EnumC00040b.A0I, A082, A012);
        } catch (NullPointerException unused) {
            A0N(view, false, A0H(191, 30, 49));
            return new FO(EnumC00040b.A0F);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0065, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Vector<android.graphics.Rect> A0K(android.view.View r5) {
        /*
            r4 = 0
            r3 = 0
            r0 = 0
            r2 = 0
            java.util.Vector r1 = new java.util.Vector
            r1.<init>()
            android.view.ViewParent r0 = r5.getParent()
            boolean r0 = r0 instanceof android.view.ViewGroup
            if (r0 != 0) goto L5f
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L61;
                case 3: goto L3e;
                case 4: goto L31;
                case 5: goto L23;
                case 6: goto L16;
                case 7: goto L4e;
                case 8: goto L52;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            java.util.Vector r1 = (java.util.Vector) r1
            android.view.View r4 = (android.view.View) r4
            java.util.Vector r0 = A0L(r4)
            r1.addAll(r0)
            r0 = 7
            goto L12
        L23:
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            android.view.View r4 = r3.getChildAt(r2)
            boolean r0 = r4 instanceof com.facebook.ads.redexgen.X.PU
            if (r0 != 0) goto L2f
            r0 = 6
            goto L12
        L2f:
            r0 = 7
            goto L12
        L31:
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            int r0 = r3.getChildCount()
            if (r2 >= r0) goto L3b
            r0 = 5
            goto L12
        L3b:
            r0 = 8
            goto L12
        L3e:
            android.view.View r5 = (android.view.View) r5
            android.view.ViewParent r3 = r5.getParent()
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            int r0 = r3.indexOfChild(r5)
            int r2 = r0 + 1
            r0 = 4
            goto L12
        L4e:
            int r2 = r2 + 1
            r0 = 4
            goto L12
        L52:
            java.util.Vector r1 = (java.util.Vector) r1
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            java.util.Vector r0 = A0K(r3)
            r1.addAll(r0)
            r0 = 2
            goto L12
        L5f:
            r0 = 3
            goto L12
        L61:
            java.util.Vector r1 = (java.util.Vector) r1
            java.util.Vector r1 = (java.util.Vector) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A0K(android.view.View):java.util.Vector");
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x00e7, code lost:            return r4;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Vector<android.graphics.Rect> A0L(android.view.View r9) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A0L(android.view.View):java.util.Vector");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0N(android.view.View r6, boolean r7, java.lang.String r8) {
        /*
            r5 = 0
            r4 = 0
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L71
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L38;
                case 4: goto L44;
                case 5: goto L73;
                case 6: goto L65;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            android.view.View r6 = (android.view.View) r6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 441(0x1b9, float:6.18E-43)
            r1 = 5
            r0 = 120(0x78, float:1.68E-43)
            java.lang.String r0 = A0H(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r3 = r0.append(r6)
            r2 = 187(0xbb, float:2.62E-43)
            r1 = 4
            r0 = 64
            java.lang.String r0 = A0H(r2, r1, r0)
            java.lang.StringBuilder r4 = r3.append(r0)
            if (r7 == 0) goto L36
            r0 = 3
            goto L9
        L36:
            r0 = 6
            goto L9
        L38:
            r2 = 107(0x6b, float:1.5E-43)
            r1 = 8
            r0 = 106(0x6a, float:1.49E-43)
            java.lang.String r5 = A0H(r2, r1, r0)
            r0 = 4
            goto L9
        L44:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            java.lang.String r5 = (java.lang.String) r5
            java.lang.StringBuilder r3 = r4.append(r5)
            r2 = 285(0x11d, float:4.0E-43)
            r1 = 14
            r0 = 27
            java.lang.String r0 = A0H(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r8)
            r0.toString()
            r0 = 5
            goto L9
        L65:
            r2 = 363(0x16b, float:5.09E-43)
            r1 = 12
            r0 = 17
            java.lang.String r5 = A0H(r2, r1, r0)
            r0 = 4
            goto L9
        L71:
            r0 = 5
            goto L9
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A0N(android.view.View, boolean, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x002e, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0O(android.view.View r3) {
        /*
            r2 = 0
            android.graphics.drawable.Drawable r0 = r3.getBackground()
            if (r0 == 0) goto L2c
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L16;
                case 4: goto L29;
                case 5: goto L2e;
                case 6: goto L26;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 19
            if (r1 < r0) goto L14
            r0 = 3
            goto L8
        L14:
            r0 = 6
            goto L8
        L16:
            android.view.View r3 = (android.view.View) r3
            android.graphics.drawable.Drawable r0 = r3.getBackground()
            int r0 = r0.getAlpha()
            if (r0 > 0) goto L24
            r0 = 4
            goto L8
        L24:
            r0 = 6
            goto L8
        L26:
            r2 = 0
            r0 = 5
            goto L8
        L29:
            r2 = 1
            r0 = 5
            goto L8
        L2c:
            r0 = 4
            goto L8
        L2e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A0O(android.view.View):boolean");
    }

    public final synchronized String A0S() {
        return EnumC00040b.values()[this.A05.A01()].toString() + String.format(Locale.US, A0H(391, 9, 104), Float.valueOf(this.A05.A00() * 100.0f));
    }

    public final synchronized Map<String, String> A0T() {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.put(A0H(561, 3, 127), String.valueOf(this.A05.A01()));
        hashMap.put(A0H(635, 2, 22), String.valueOf(this.A05.A00()));
        hashMap.put(A0H(439, 2, 110), new JSONObject(this.A06).toString());
        hashMap.put(A0H(335, 2, 126), K4.A05(this.A03));
        hashMap.putAll(this.A05.A03());
        return hashMap;
    }

    public final synchronized void A0U() {
        this.A05 = new FO(EnumC00040b.A0K);
    }

    public final synchronized void A0V() {
        if (this.A04 != null) {
            A0W();
        }
        if (this.A07) {
            this.A0D.A08().A2z();
        }
        this.A04 = new FQ(this, this.A0D);
        this.A0B.postDelayed(this.A04, this.A01);
        this.A08 = false;
        this.A00 = 0;
        this.A05 = new FO(EnumC00040b.A0K);
        this.A06 = new HashMap();
    }

    public final synchronized void A0W() {
        if (this.A07) {
            this.A0D.A08().A30();
        }
        this.A0B.removeCallbacks(this.A04);
        this.A04 = null;
        this.A08 = true;
        this.A00 = 0;
    }

    public final void A0X(int i) {
        this.A01 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:            r4.A02 = r6;     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0Y(int r6) {
        /*
            r5 = this;
            r4 = r5
            boolean r0 = com.facebook.ads.internal.api.BuildConfigApi.isDebug()
            if (r0 == 0) goto L27
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L16;
                case 4: goto L29;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.FP r4 = (com.facebook.ads.redexgen.X.FP) r4
            boolean r0 = r4.A0F
            if (r0 != 0) goto L14
            r0 = 3
            goto L8
        L14:
            r0 = 4
            goto L8
        L16:
            java.lang.String r3 = com.facebook.ads.redexgen.X.FP.A0H
            r2 = 221(0xdd, float:3.1E-43)
            r1 = 64
            r0 = 51
            java.lang.String r0 = A0H(r2, r1, r0)
            android.util.Log.w(r3, r0)
            r0 = 4
            goto L8
        L27:
            r0 = 4
            goto L8
        L29:
            com.facebook.ads.redexgen.X.FP r4 = (com.facebook.ads.redexgen.X.FP) r4
            r4.A02 = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.FP.A0Y(int):void");
    }

    public final void A0Z(boolean z) {
        this.A07 = z;
    }

    public final synchronized boolean A0a() {
        return this.A08;
    }
}
