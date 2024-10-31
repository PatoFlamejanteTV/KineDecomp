package com.facebook.ads.redexgen.X;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager;
import com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.5T, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C5T extends ViewGroup {
    public static byte[] A0u;
    public static final int[] A0v;
    public static final Interpolator A0w;
    public static final C5S A0x;
    public static final Comparator<C5I> A0y;
    public int A00;
    public AbstractC01204n A01;
    public float A02;
    public float A03;
    public float A04;
    public float A05;
    public float A06;
    public float A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public int A0E;
    public int A0F;
    public int A0G;
    public int A0H;
    public int A0I;
    public int A0J;
    public int A0K;
    public int A0L;
    public int A0M;
    public int A0N;
    public int A0O;
    public int A0P;
    public int A0Q;
    public int A0R;
    public Drawable A0S;
    public Parcelable A0T;
    public VelocityTracker A0U;
    public EdgeEffect A0V;
    public EdgeEffect A0W;
    public Scroller A0X;
    public C5M A0Y;
    public C5M A0Z;
    public C5N A0a;
    public C5O A0b;
    public ClassLoader A0c;
    public ArrayList<View> A0d;
    public List<ViewPager.OnAdapterChangeListener> A0e;
    public List<C5M> A0f;
    public boolean A0g;
    public boolean A0h;
    public boolean A0i;
    public boolean A0j;
    public boolean A0k;
    public boolean A0l;
    public boolean A0m;
    public boolean A0n;
    public boolean A0o;
    public boolean A0p;
    public final Rect A0q;
    public final C5I A0r;
    public final Runnable A0s;
    public final ArrayList<C5I> A0t;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A08(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.C5T.A0u
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
            int r0 = r0 + (-116)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A08(int, int, int):java.lang.String");
    }

    public static void A0C() {
        A0u = new byte[]{-33, 15, 49, 46, 33, 43, 36, 44, 32, 51, 40, 34, -33, 32, 35, 32, 47, 51, 36, 49, -7, -33, -72, -42, -29, -29, -28, -23, -107, -42, -39, -39, -107, -27, -42, -36, -38, -25, -107, -39, -38, -40, -28, -25, -107, -21, -34, -38, -20, -107, -39, -22, -25, -34, -29, -36, -107, -31, -42, -18, -28, -22, -23, -60, -72, -2, 7, 13, 6, -4, -46, -72, -9, 10, 22, 26, 10, 24, 25, 10, 9, -59, 20, 11, 11, 24, 8, 23, 10, 10, 19, -59, 21, 6, 12, 10, -59, 17, 14, 18, 14, 25, -59, -13, 71, 66, 66, -13, 70, 64, 52, 63, 63, 14, -13, 55, 56, 57, 52, 72, 63, 71, 60, 65, 58, -13, 71, 66, -13, -36, 12, 29, 35, 33, 46, -36, 31, 40, 29, 47, 47, -10, -36, 14, 34, 31, -38, 27, 42, 42, 38, 35, 29, 27, 46, 35, 41, 40, -31, 45, -38, 10, 27, 33, 31, 44, -5, 30, 27, 42, 46, 31, 44, -38, 29, 34, 27, 40, 33, 31, 30, -38, 46, 34, 31, -38, 27, 30, 27, 42, 46, 31, 44, -31, 45, -38, 29, 41, 40, 46, 31, 40, 46, 45, -38, 49, 35, 46, 34, 41, 47, 46, -38, 29, 27, 38, 38, 35, 40, 33, -38, 10, 27, 33, 31, 44, -5, 30, 27, 42, 46, 31, 44, -35, 40, 41, 46, 35, 32, 51, -2, 27, 46, 27, 13, 31, 46, -3, 34, 27, 40, 33, 31, 30, -37, -38, -1, 50, 42, 31, 29, 46, 31, 30, -38, 27, 30, 27, 42, 46, 31, 44, -38, 35, 46, 31, 39, -38, 29, 41, 47, 40, 46, -12, -38, -9, 8, 8, 5, 13, -23, -7, 8, 5, 2, 2, -74, 10, 8, -1, -5, -6, -74, 10, 5, -74, -4, -1, 4, -6, -74, -4, 5, -7, 11, 9, -74, -8, -9, 9, -5, -6, -74, 5, 4, -74, 4, 5, 4, -61, -7, -2, -1, 2, -6, -74, -7, 11, 8, 8, -5, 4, 10, -74, -4, 5, -7, 11, 9, -5, -6, -74, 12, -1, -5, 13, -74, -40, -21, -25, -7, -46, -29, -23, -25, -12, -9, -10, -40, -23, -17, -19, -37, -21, -6, -9, -12, -12, -19, -20, -88, -20, -15, -20, -88, -10, -9, -4, -88, -21, -23, -12, -12, -88, -5, -3, -8, -19, -6, -21, -12, -23, -5, -5, -88, -15, -11, -8, -12, -19, -11, -19, -10, -4, -23, -4, -15, -9, -10, -63, -34, -33, -63, -5, 43, 60, 66, 64, 77, -5, 68, 63, 21, -5};
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.facebook.ads.redexgen.X.5S] */
    static {
        A0C();
        A0v = new int[]{R.attr.layout_gravity};
        A0y = new Comparator<C5I>() { // from class: com.facebook.ads.redexgen.X.5D
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final int compare(C5I c5i, C5I c5i2) {
                return c5i.A02 - c5i2.A02;
            }
        };
        A0w = new Interpolator() { // from class: com.facebook.ads.redexgen.X.5E
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
        A0x = new Comparator<View>() { // from class: com.facebook.ads.redexgen.X.5S
            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:            return r1;     */
            @Override // java.util.Comparator
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final int compare(android.view.View r6, android.view.View r7) {
                /*
                    r5 = this;
                    r0 = 0
                    r0 = 0
                    r1 = 0
                    android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
                    com.facebook.ads.redexgen.X.5J r4 = (com.facebook.ads.redexgen.X.C5J) r4
                    android.view.ViewGroup$LayoutParams r3 = r7.getLayoutParams()
                    com.facebook.ads.redexgen.X.5J r3 = (com.facebook.ads.redexgen.X.C5J) r3
                    boolean r2 = r4.A05
                    boolean r0 = r3.A05
                    if (r2 == r0) goto L35
                    r0 = 2
                L16:
                    switch(r0) {
                        case 2: goto L1a;
                        case 3: goto L24;
                        case 4: goto L37;
                        case 5: goto L27;
                        case 6: goto L2a;
                        default: goto L19;
                    }
                L19:
                    goto L16
                L1a:
                    com.facebook.ads.redexgen.X.5J r4 = (com.facebook.ads.redexgen.X.C5J) r4
                    boolean r0 = r4.A05
                    if (r0 == 0) goto L22
                    r0 = 3
                    goto L16
                L22:
                    r0 = 5
                    goto L16
                L24:
                    r1 = 1
                    r0 = 4
                    goto L16
                L27:
                    r1 = -1
                    r0 = 4
                    goto L16
                L2a:
                    com.facebook.ads.redexgen.X.5J r4 = (com.facebook.ads.redexgen.X.C5J) r4
                    com.facebook.ads.redexgen.X.5J r3 = (com.facebook.ads.redexgen.X.C5J) r3
                    int r1 = r4.A02
                    int r0 = r3.A02
                    int r1 = r1 - r0
                    r0 = 4
                    goto L16
                L35:
                    r0 = 6
                    goto L16
                L37:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5S.compare(android.view.View, android.view.View):int");
            }
        };
    }

    public C5T(Context context) {
        super(context);
        this.A0t = new ArrayList<>();
        this.A0r = new C5I();
        this.A0q = new Rect();
        this.A0O = -1;
        this.A0T = null;
        this.A0c = null;
        this.A02 = -3.4028235E38f;
        this.A07 = Float.MAX_VALUE;
        this.A0L = 1;
        this.A08 = -1;
        this.A0i = true;
        this.A0n = false;
        this.A0s = new Runnable() { // from class: com.facebook.ads.redexgen.X.5F
            @Override // java.lang.Runnable
            public final void run() {
                C5T.this.setScrollState(0);
                C5T.this.A0f();
            }
        };
        this.A0P = 0;
        A0D();
    }

    private final float A00(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0086, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A01(int r7, float r8, int r9, int r10) {
        /*
            r6 = this;
            r2 = r6
            r5 = 0
            r3 = 0
            int r1 = java.lang.Math.abs(r10)
            int r0 = r2.A0H
            if (r1 <= r0) goto L83
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L51;
                case 3: goto L4a;
                case 4: goto L47;
                case 5: goto L39;
                case 6: goto L10;
                case 7: goto L86;
                case 8: goto L60;
                case 9: goto L64;
                case 10: goto L70;
                case 11: goto L76;
                case 12: goto L7d;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r1 = r2.A0t
            r0 = 0
            java.lang.Object r4 = r1.get(r0)
            com.facebook.ads.redexgen.X.5I r4 = (com.facebook.ads.redexgen.X.C5I) r4
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r1 = r2.A0t
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r2.A0t
            int r0 = r0.size()
            int r0 = r0 + (-1)
            java.lang.Object r0 = r1.get(r0)
            com.facebook.ads.redexgen.X.5I r0 = (com.facebook.ads.redexgen.X.C5I) r0
            int r1 = r4.A02
            int r0 = r0.A02
            int r0 = java.lang.Math.min(r3, r0)
            int r3 = java.lang.Math.max(r1, r0)
            r0 = 7
            goto Lc
        L39:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r2.A0t
            int r0 = r0.size()
            if (r0 <= 0) goto L45
            r0 = 6
            goto Lc
        L45:
            r0 = 7
            goto Lc
        L47:
            r3 = r7
            r0 = 5
            goto Lc
        L4a:
            if (r9 <= 0) goto L4e
            r0 = 4
            goto Lc
        L4e:
            r0 = 8
            goto Lc
        L51:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            int r1 = java.lang.Math.abs(r9)
            int r0 = r2.A0K
            if (r1 <= r0) goto L5d
            r0 = 3
            goto Lc
        L5d:
            r0 = 9
            goto Lc
        L60:
            int r3 = r7 + 1
            r0 = 5
            goto Lc
        L64:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            int r0 = r2.A00
            if (r7 < r0) goto L6d
            r0 = 10
            goto Lc
        L6d:
            r0 = 12
            goto Lc
        L70:
            r5 = 1053609165(0x3ecccccd, float:0.4)
            r0 = 11
            goto Lc
        L76:
            float r0 = r8 + r5
            int r0 = (int) r0
            int r3 = r7 + r0
            r0 = 5
            goto Lc
        L7d:
            r5 = 1058642330(0x3f19999a, float:0.6)
            r0 = 11
            goto Lc
        L83:
            r0 = 9
            goto Lc
        L86:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A01(int, float, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0092, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Rect A02(android.graphics.Rect r5, android.view.View r6) {
        /*
            r4 = this;
            r2 = r4
            r0 = 0
            r3 = 0
            r0 = 0
            if (r5 != 0) goto L8b
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L48;
                case 3: goto L2d;
                case 4: goto L35;
                case 5: goto L8e;
                case 6: goto Lb;
                case 7: goto L3d;
                case 8: goto L4f;
                case 9: goto L5a;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            android.view.View r6 = (android.view.View) r6
            int r0 = r6.getLeft()
            r5.left = r0
            int r0 = r6.getRight()
            r5.right = r0
            int r0 = r6.getTop()
            r5.top = r0
            int r0 = r6.getBottom()
            r5.bottom = r0
            android.view.ViewParent r3 = r6.getParent()
            r0 = 7
            goto L7
        L2d:
            android.view.View r6 = (android.view.View) r6
            if (r6 != 0) goto L33
            r0 = 4
            goto L7
        L33:
            r0 = 6
            goto L7
        L35:
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            r0 = 0
            r5.set(r0, r0, r0, r0)
            r0 = 5
            goto L7
        L3d:
            android.view.ViewParent r3 = (android.view.ViewParent) r3
            boolean r0 = r3 instanceof android.view.ViewGroup
            if (r0 == 0) goto L46
            r0 = 8
            goto L7
        L46:
            r0 = 5
            goto L7
        L48:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            r0 = 3
            goto L7
        L4f:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            android.view.ViewParent r3 = (android.view.ViewParent) r3
            if (r3 == r2) goto L58
            r0 = 9
            goto L7
        L58:
            r0 = 5
            goto L7
        L5a:
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            android.view.ViewParent r3 = (android.view.ViewParent) r3
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            int r1 = r5.left
            int r0 = r3.getLeft()
            int r1 = r1 + r0
            r5.left = r1
            int r1 = r5.right
            int r0 = r3.getRight()
            int r1 = r1 + r0
            r5.right = r1
            int r1 = r5.top
            int r0 = r3.getTop()
            int r1 = r1 + r0
            r5.top = r1
            int r1 = r5.bottom
            int r0 = r3.getBottom()
            int r1 = r1 + r0
            r5.bottom = r1
            android.view.ViewParent r3 = r3.getParent()
            r0 = 7
            goto L7
        L8b:
            r0 = 3
            goto L7
        L8e:
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A02(android.graphics.Rect, android.view.View):android.graphics.Rect");
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x00e6, code lost:            return r10;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.redexgen.X.C5I A03() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A03():com.facebook.ads.redexgen.X.5I");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0032, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C5I A04(int r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r0 = 0
            r1 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L17;
                case 4: goto L30;
                case 5: goto L29;
                case 6: goto L2d;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r3.A0t
            int r0 = r0.size()
            if (r1 >= r0) goto L15
            r0 = 3
            goto L5
        L15:
            r0 = 6
            goto L5
        L17:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r3.A0t
            java.lang.Object r2 = r0.get(r1)
            com.facebook.ads.redexgen.X.5I r2 = (com.facebook.ads.redexgen.X.C5I) r2
            int r0 = r2.A02
            if (r0 != r5) goto L27
            r0 = 4
            goto L5
        L27:
            r0 = 5
            goto L5
        L29:
            int r1 = r1 + 1
            r0 = 2
            goto L5
        L2d:
            r2 = 0
            r0 = 4
            goto L5
        L30:
            com.facebook.ads.redexgen.X.5I r2 = (com.facebook.ads.redexgen.X.C5I) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A04(int):com.facebook.ads.redexgen.X.5I");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C5I A05(int r4, int r5) {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            com.facebook.ads.redexgen.X.5I r1 = new com.facebook.ads.redexgen.X.5I
            r1.<init>()
            r1.A02 = r4
            com.facebook.ads.redexgen.X.4n r0 = r2.A01
            java.lang.Object r0 = r0.A08(r2, r4)
            r1.A03 = r0
            com.facebook.ads.redexgen.X.4n r0 = r2.A01
            float r0 = r0.A04(r4)
            r1.A01 = r0
            if (r5 < 0) goto L44
            r0 = 2
        L1c:
            switch(r0) {
                case 2: goto L20;
                case 3: goto L2e;
                case 4: goto L46;
                case 5: goto L39;
                default: goto L1f;
            }
        L1f:
            goto L1c
        L20:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r2.A0t
            int r0 = r0.size()
            if (r5 < r0) goto L2c
            r0 = 3
            goto L1c
        L2c:
            r0 = 5
            goto L1c
        L2e:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            com.facebook.ads.redexgen.X.5I r1 = (com.facebook.ads.redexgen.X.C5I) r1
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r2.A0t
            r0.add(r1)
            r0 = 4
            goto L1c
        L39:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            com.facebook.ads.redexgen.X.5I r1 = (com.facebook.ads.redexgen.X.C5I) r1
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r2.A0t
            r0.add(r5, r1)
            r0 = 4
            goto L1c
        L44:
            r0 = 3
            goto L1c
        L46:
            com.facebook.ads.redexgen.X.5I r1 = (com.facebook.ads.redexgen.X.C5I) r1
            com.facebook.ads.redexgen.X.5I r1 = (com.facebook.ads.redexgen.X.C5I) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A05(int, int):com.facebook.ads.redexgen.X.5I");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x003f, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C5I A06(android.view.View r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L1d;
                case 3: goto L15;
                case 4: goto L8;
                case 5: goto L12;
                case 6: goto L3d;
                case 7: goto L2c;
                case 8: goto L33;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            boolean r0 = r1 instanceof android.view.View
            if (r0 != 0) goto L10
            r0 = 5
            goto L4
        L10:
            r0 = 7
            goto L4
        L12:
            r2 = 0
            r0 = 6
            goto L4
        L15:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            if (r1 == 0) goto L1b
            r0 = 4
            goto L4
        L1b:
            r0 = 5
            goto L4
        L1d:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            android.view.View r5 = (android.view.View) r5
            android.view.ViewParent r1 = r5.getParent()
            if (r1 == r3) goto L29
            r0 = 3
            goto L4
        L29:
            r0 = 8
            goto L4
        L2c:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            r5 = r1
            android.view.View r5 = (android.view.View) r5
            r0 = 2
            goto L4
        L33:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            android.view.View r5 = (android.view.View) r5
            com.facebook.ads.redexgen.X.5I r2 = r3.A07(r5)
            r0 = 6
            goto L4
        L3d:
            com.facebook.ads.redexgen.X.5I r2 = (com.facebook.ads.redexgen.X.C5I) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A06(android.view.View):com.facebook.ads.redexgen.X.5I");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x003a, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.facebook.ads.redexgen.X.C5I A07(android.view.View r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r2 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto L17;
                case 4: goto L38;
                case 5: goto L31;
                case 6: goto L35;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r4.A0t
            int r0 = r0.size()
            if (r2 >= r0) goto L15
            r0 = 3
            goto L5
        L15:
            r0 = 6
            goto L5
        L17:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            android.view.View r6 = (android.view.View) r6
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r4.A0t
            java.lang.Object r3 = r0.get(r2)
            com.facebook.ads.redexgen.X.5I r3 = (com.facebook.ads.redexgen.X.C5I) r3
            com.facebook.ads.redexgen.X.4n r1 = r4.A01
            java.lang.Object r0 = r3.A03
            boolean r0 = r1.A0C(r6, r0)
            if (r0 == 0) goto L2f
            r0 = 4
            goto L5
        L2f:
            r0 = 5
            goto L5
        L31:
            int r2 = r2 + 1
            r0 = 2
            goto L5
        L35:
            r3 = 0
            r0 = 4
            goto L5
        L38:
            com.facebook.ads.redexgen.X.5I r3 = (com.facebook.ads.redexgen.X.C5I) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A07(android.view.View):com.facebook.ads.redexgen.X.5I");
    }

    private void A09() {
        this.A0k = false;
        this.A0m = false;
        if (this.A0U != null) {
            this.A0U.recycle();
            this.A0U = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0035, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0A() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 0
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L14;
                case 4: goto L28;
                case 5: goto L31;
                case 6: goto L35;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            int r0 = r2.getChildCount()
            if (r1 >= r0) goto L12
            r0 = 3
            goto L4
        L12:
            r0 = 6
            goto L4
        L14:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            android.view.View r0 = r2.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            com.facebook.ads.redexgen.X.5J r0 = (com.facebook.ads.redexgen.X.C5J) r0
            boolean r0 = r0.A05
            if (r0 != 0) goto L26
            r0 = 4
            goto L4
        L26:
            r0 = 5
            goto L4
        L28:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            r2.removeViewAt(r1)
            int r1 = r1 + (-1)
            r0 = 5
            goto L4
        L31:
            int r1 = r1 + 1
            r0 = 2
            goto L4
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0A():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0058, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0B() {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r2 = 0
            int r0 = r4.A0F
            if (r0 == 0) goto L55
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L36;
                case 3: goto L2b;
                case 4: goto Lc;
                case 5: goto L24;
                case 6: goto L15;
                case 7: goto L40;
                case 8: goto L49;
                case 9: goto L58;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            int r2 = r4.getChildCount()
            r3 = 0
            r0 = 5
            goto L8
        L15:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            android.view.View r1 = r4.getChildAt(r3)
            java.util.ArrayList<android.view.View> r0 = r4.A0d
            r0.add(r1)
            int r3 = r3 + 1
            r0 = 5
            goto L8
        L24:
            if (r3 >= r2) goto L28
            r0 = 6
            goto L8
        L28:
            r0 = 8
            goto L8
        L2b:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.A0d = r0
            r0 = 4
            goto L8
        L36:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            java.util.ArrayList<android.view.View> r0 = r4.A0d
            if (r0 != 0) goto L3e
            r0 = 3
            goto L8
        L3e:
            r0 = 7
            goto L8
        L40:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            java.util.ArrayList<android.view.View> r0 = r4.A0d
            r0.clear()
            r0 = 4
            goto L8
        L49:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            java.util.ArrayList<android.view.View> r1 = r4.A0d
            com.facebook.ads.redexgen.X.5S r0 = com.facebook.ads.redexgen.X.C5T.A0x
            java.util.Collections.sort(r1, r0)
            r0 = 9
            goto L8
        L55:
            r0 = 9
            goto L8
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0B():void");
    }

    private final void A0D() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.A0X = new Scroller(context, A0w);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.A0R = viewConfiguration.getScaledPagingTouchSlop();
        float density = 400.0f * f;
        this.A0K = (int) density;
        this.A0J = viewConfiguration.getScaledMaximumFlingVelocity();
        this.A0V = new EdgeEffect(context);
        this.A0W = new EdgeEffect(context);
        float density2 = 25.0f * f;
        this.A0H = (int) density2;
        float density3 = 2.0f * f;
        this.A0C = (int) density3;
        float density4 = 16.0f * f;
        this.A0E = (int) density4;
        C5B.A0A(this, new C01114e() { // from class: com.facebook.ads.redexgen.X.5K
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0023, code lost:            return r1;     */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private boolean A00() {
                /*
                    r3 = this;
                    r2 = r3
                    r0 = 0
                    r1 = 1
                    com.facebook.ads.redexgen.X.5T r0 = com.facebook.ads.redexgen.X.C5T.this
                    com.facebook.ads.redexgen.X.4n r0 = r0.A01
                    if (r0 == 0) goto L21
                    r0 = 2
                La:
                    switch(r0) {
                        case 2: goto Le;
                        case 3: goto L23;
                        case 4: goto L1e;
                        default: goto Ld;
                    }
                Ld:
                    goto La
                Le:
                    com.facebook.ads.redexgen.X.5K r2 = (com.facebook.ads.redexgen.X.C5K) r2
                    com.facebook.ads.redexgen.X.5T r0 = com.facebook.ads.redexgen.X.C5T.this
                    com.facebook.ads.redexgen.X.4n r0 = r0.A01
                    int r0 = r0.A05()
                    if (r0 <= r1) goto L1c
                    r0 = 3
                    goto La
                L1c:
                    r0 = 4
                    goto La
                L1e:
                    r1 = 0
                    r0 = 3
                    goto La
                L21:
                    r0 = 4
                    goto La
                L23:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5K.A00():boolean");
            }

            /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.C01114e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A07(android.view.View r4, android.view.accessibility.AccessibilityEvent r5) {
                /*
                    r3 = this;
                    r2 = r3
                    super.A07(r4, r5)
                    java.lang.Class<com.facebook.ads.redexgen.X.5T> r0 = com.facebook.ads.redexgen.X.C5T.class
                    java.lang.String r0 = r0.getName()
                    r5.setClassName(r0)
                    boolean r0 = r2.A00()
                    r5.setScrollable(r0)
                    int r1 = r5.getEventType()
                    r0 = 4096(0x1000, float:5.74E-42)
                    if (r1 != r0) goto L4c
                    r0 = 2
                L1d:
                    switch(r0) {
                        case 2: goto L21;
                        case 3: goto L2d;
                        case 4: goto L4e;
                        default: goto L20;
                    }
                L20:
                    goto L1d
                L21:
                    com.facebook.ads.redexgen.X.5K r2 = (com.facebook.ads.redexgen.X.C5K) r2
                    com.facebook.ads.redexgen.X.5T r0 = com.facebook.ads.redexgen.X.C5T.this
                    com.facebook.ads.redexgen.X.4n r0 = r0.A01
                    if (r0 == 0) goto L2b
                    r0 = 3
                    goto L1d
                L2b:
                    r0 = 4
                    goto L1d
                L2d:
                    com.facebook.ads.redexgen.X.5K r2 = (com.facebook.ads.redexgen.X.C5K) r2
                    android.view.accessibility.AccessibilityEvent r5 = (android.view.accessibility.AccessibilityEvent) r5
                    com.facebook.ads.redexgen.X.5T r0 = com.facebook.ads.redexgen.X.C5T.this
                    com.facebook.ads.redexgen.X.4n r0 = r0.A01
                    int r0 = r0.A05()
                    r5.setItemCount(r0)
                    com.facebook.ads.redexgen.X.5T r0 = com.facebook.ads.redexgen.X.C5T.this
                    int r0 = r0.A00
                    r5.setFromIndex(r0)
                    com.facebook.ads.redexgen.X.5T r0 = com.facebook.ads.redexgen.X.C5T.this
                    int r0 = r0.A00
                    r5.setToIndex(r0)
                    r0 = 4
                    goto L1d
                L4c:
                    r0 = 4
                    goto L1d
                L4e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5K.A07(android.view.View, android.view.accessibility.AccessibilityEvent):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:23:0x0045, code lost:            return;     */
            @Override // com.facebook.ads.redexgen.X.C01114e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void A08(android.view.View r4, com.facebook.ads.redexgen.X.C5q r5) {
                /*
                    r3 = this;
                    r2 = r3
                    super.A08(r4, r5)
                    java.lang.Class<com.facebook.ads.redexgen.X.5T> r0 = com.facebook.ads.redexgen.X.C5T.class
                    java.lang.String r0 = r0.getName()
                    r5.A0O(r0)
                    boolean r0 = r2.A00()
                    r5.A0R(r0)
                    com.facebook.ads.redexgen.X.5T r1 = com.facebook.ads.redexgen.X.C5T.this
                    r0 = 1
                    boolean r0 = r1.canScrollHorizontally(r0)
                    if (r0 == 0) goto L43
                    r0 = 2
                L1e:
                    switch(r0) {
                        case 2: goto L22;
                        case 3: goto L2b;
                        case 4: goto L3a;
                        case 5: goto L45;
                        default: goto L21;
                    }
                L21:
                    goto L1e
                L22:
                    com.facebook.ads.redexgen.X.5q r5 = (com.facebook.ads.redexgen.X.C5q) r5
                    r0 = 4096(0x1000, float:5.74E-42)
                    r5.A0N(r0)
                    r0 = 3
                    goto L1e
                L2b:
                    com.facebook.ads.redexgen.X.5K r2 = (com.facebook.ads.redexgen.X.C5K) r2
                    com.facebook.ads.redexgen.X.5T r1 = com.facebook.ads.redexgen.X.C5T.this
                    r0 = -1
                    boolean r0 = r1.canScrollHorizontally(r0)
                    if (r0 == 0) goto L38
                    r0 = 4
                    goto L1e
                L38:
                    r0 = 5
                    goto L1e
                L3a:
                    com.facebook.ads.redexgen.X.5q r5 = (com.facebook.ads.redexgen.X.C5q) r5
                    r0 = 8192(0x2000, float:1.148E-41)
                    r5.A0N(r0)
                    r0 = 5
                    goto L1e
                L43:
                    r0 = 3
                    goto L1e
                L45:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5K.A08(android.view.View, com.facebook.ads.redexgen.X.5q):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:52:0x0062, code lost:            return r0;     */
            @Override // com.facebook.ads.redexgen.X.C01114e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean A09(android.view.View r5, int r6, android.os.Bundle r7) {
                /*
                    r4 = this;
                    r3 = r4
                    r0 = 0
                    r0 = 0
                    r0 = 0
                    r0 = 1
                    boolean r1 = super.A09(r5, r6, r7)
                    if (r1 == 0) goto L60
                    r1 = 2
                Lc:
                    switch(r1) {
                        case 2: goto L62;
                        case 3: goto L30;
                        case 4: goto L2d;
                        case 5: goto L1f;
                        case 6: goto L10;
                        case 7: goto L3a;
                        case 8: goto L3d;
                        case 9: goto L4e;
                        case 10: goto L5d;
                        default: goto Lf;
                    }
                Lf:
                    goto Lc
                L10:
                    com.facebook.ads.redexgen.X.5K r3 = (com.facebook.ads.redexgen.X.C5K) r3
                    com.facebook.ads.redexgen.X.5T r2 = com.facebook.ads.redexgen.X.C5T.this
                    com.facebook.ads.redexgen.X.5T r1 = com.facebook.ads.redexgen.X.C5T.this
                    int r1 = r1.A00
                    int r1 = r1 + 1
                    r2.setCurrentItem(r1)
                    r1 = 2
                    goto Lc
                L1f:
                    com.facebook.ads.redexgen.X.5K r3 = (com.facebook.ads.redexgen.X.C5K) r3
                    com.facebook.ads.redexgen.X.5T r1 = com.facebook.ads.redexgen.X.C5T.this
                    boolean r1 = r1.canScrollHorizontally(r0)
                    if (r1 == 0) goto L2b
                    r1 = 6
                    goto Lc
                L2b:
                    r1 = 7
                    goto Lc
                L2d:
                    r0 = 0
                    r1 = 2
                    goto Lc
                L30:
                    switch(r6) {
                        case 4096: goto L38;
                        case 8192: goto L35;
                        default: goto L33;
                    }
                L33:
                    r1 = 4
                    goto Lc
                L35:
                    r1 = 8
                    goto Lc
                L38:
                    r1 = 5
                    goto Lc
                L3a:
                    r0 = 0
                    r1 = 2
                    goto Lc
                L3d:
                    com.facebook.ads.redexgen.X.5K r3 = (com.facebook.ads.redexgen.X.C5K) r3
                    com.facebook.ads.redexgen.X.5T r2 = com.facebook.ads.redexgen.X.C5T.this
                    r1 = -1
                    boolean r1 = r2.canScrollHorizontally(r1)
                    if (r1 == 0) goto L4b
                    r1 = 9
                    goto Lc
                L4b:
                    r1 = 10
                    goto Lc
                L4e:
                    com.facebook.ads.redexgen.X.5K r3 = (com.facebook.ads.redexgen.X.C5K) r3
                    com.facebook.ads.redexgen.X.5T r2 = com.facebook.ads.redexgen.X.C5T.this
                    com.facebook.ads.redexgen.X.5T r1 = com.facebook.ads.redexgen.X.C5T.this
                    int r1 = r1.A00
                    int r1 = r1 + (-1)
                    r2.setCurrentItem(r1)
                    r1 = 2
                    goto Lc
                L5d:
                    r0 = 0
                    r1 = 2
                    goto Lc
                L60:
                    r1 = 3
                    goto Lc
                L62:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5K.A09(android.view.View, int, android.os.Bundle):boolean");
            }
        });
        if (C5B.A00(this) == 0) {
            C5B.A09(this, 1);
        }
        C5B.A0B(this, new InterfaceC01194m() { // from class: com.facebook.ads.redexgen.X.5G
            public final Rect A00 = new Rect();

            /* JADX WARN: Code restructure failed: missing block: B:26:0x009f, code lost:            return r8;     */
            @Override // com.facebook.ads.redexgen.X.InterfaceC01194m
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.facebook.ads.redexgen.X.C5Y A6B(android.view.View r10, com.facebook.ads.redexgen.X.C5Y r11) {
                /*
                    r9 = this;
                    r7 = r9
                    r6 = 0
                    r5 = 0
                    r4 = 0
                    r0 = 0
                    com.facebook.ads.redexgen.X.5Y r8 = com.facebook.ads.redexgen.X.C5B.A06(r10, r11)
                    boolean r0 = r8.A07()
                    if (r0 == 0) goto L98
                    r0 = 2
                L10:
                    switch(r0) {
                        case 2: goto L9b;
                        case 3: goto L14;
                        case 4: goto L3b;
                        case 5: goto L41;
                        case 6: goto L85;
                        default: goto L13;
                    }
                L13:
                    goto L10
                L14:
                    com.facebook.ads.redexgen.X.5G r7 = (com.facebook.ads.redexgen.X.C5G) r7
                    com.facebook.ads.redexgen.X.5Y r8 = (com.facebook.ads.redexgen.X.C5Y) r8
                    android.graphics.Rect r6 = r7.A00
                    int r0 = r8.A03()
                    r6.left = r0
                    int r0 = r8.A05()
                    r6.top = r0
                    int r0 = r8.A04()
                    r6.right = r0
                    int r0 = r8.A02()
                    r6.bottom = r0
                    r4 = 0
                    com.facebook.ads.redexgen.X.5T r0 = com.facebook.ads.redexgen.X.C5T.this
                    int r5 = r0.getChildCount()
                    r0 = 4
                    goto L10
                L3b:
                    if (r4 >= r5) goto L3f
                    r0 = 5
                    goto L10
                L3f:
                    r0 = 6
                    goto L10
                L41:
                    com.facebook.ads.redexgen.X.5G r7 = (com.facebook.ads.redexgen.X.C5G) r7
                    com.facebook.ads.redexgen.X.5Y r8 = (com.facebook.ads.redexgen.X.C5Y) r8
                    android.graphics.Rect r6 = (android.graphics.Rect) r6
                    com.facebook.ads.redexgen.X.5T r0 = com.facebook.ads.redexgen.X.C5T.this
                    android.view.View r0 = r0.getChildAt(r4)
                    com.facebook.ads.redexgen.X.5Y r2 = com.facebook.ads.redexgen.X.C5B.A05(r0, r8)
                    int r1 = r2.A03()
                    int r0 = r6.left
                    int r0 = java.lang.Math.min(r1, r0)
                    r6.left = r0
                    int r1 = r2.A05()
                    int r0 = r6.top
                    int r0 = java.lang.Math.min(r1, r0)
                    r6.top = r0
                    int r1 = r2.A04()
                    int r0 = r6.right
                    int r0 = java.lang.Math.min(r1, r0)
                    r6.right = r0
                    int r1 = r2.A02()
                    int r0 = r6.bottom
                    int r0 = java.lang.Math.min(r1, r0)
                    r6.bottom = r0
                    int r4 = r4 + 1
                    r0 = 4
                    goto L10
                L85:
                    com.facebook.ads.redexgen.X.5Y r8 = (com.facebook.ads.redexgen.X.C5Y) r8
                    android.graphics.Rect r6 = (android.graphics.Rect) r6
                    int r3 = r6.left
                    int r2 = r6.top
                    int r1 = r6.right
                    int r0 = r6.bottom
                    com.facebook.ads.redexgen.X.5Y r8 = r8.A06(r3, r2, r1, r0)
                    r0 = 2
                    goto L10
                L98:
                    r0 = 3
                    goto L10
                L9b:
                    com.facebook.ads.redexgen.X.5Y r8 = (com.facebook.ads.redexgen.X.C5Y) r8
                    com.facebook.ads.redexgen.X.5Y r8 = (com.facebook.ads.redexgen.X.C5Y) r8
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5G.A6B(android.view.View, com.facebook.ads.redexgen.X.5Y):com.facebook.ads.redexgen.X.5Y");
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0049, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0E(int r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.5M r0 = r3.A0Z
            if (r0 == 0) goto L47
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L31;
                case 3: goto L26;
                case 4: goto L20;
                case 5: goto L10;
                case 6: goto Lc;
                case 7: goto L3b;
                case 8: goto L49;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            int r1 = r1 + 1
            r0 = 4
            goto L8
        L10:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            java.util.List<com.facebook.ads.redexgen.X.5M> r0 = r3.A0f
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.5M r0 = (com.facebook.ads.redexgen.X.C5M) r0
            if (r0 == 0) goto L1e
            r0 = 6
            goto L8
        L1e:
            r0 = 6
            goto L8
        L20:
            if (r1 >= r2) goto L24
            r0 = 5
            goto L8
        L24:
            r0 = 7
            goto L8
        L26:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            r1 = 0
            java.util.List<com.facebook.ads.redexgen.X.5M> r0 = r3.A0f
            int r2 = r0.size()
            r0 = 4
            goto L8
        L31:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            java.util.List<com.facebook.ads.redexgen.X.5M> r0 = r3.A0f
            if (r0 == 0) goto L39
            r0 = 3
            goto L8
        L39:
            r0 = 7
            goto L8
        L3b:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            com.facebook.ads.redexgen.X.5M r0 = r3.A0Y
            if (r0 == 0) goto L44
            r0 = 8
            goto L8
        L44:
            r0 = 8
            goto L8
        L47:
            r0 = 2
            goto L8
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0E(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0049, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F(int r5) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.5M r0 = r3.A0Z
            if (r0 == 0) goto L47
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L31;
                case 3: goto L26;
                case 4: goto L10;
                case 5: goto L16;
                case 6: goto Lc;
                case 7: goto L3b;
                case 8: goto L49;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            int r1 = r1 + 1
            r0 = 4
            goto L8
        L10:
            if (r1 >= r2) goto L14
            r0 = 5
            goto L8
        L14:
            r0 = 7
            goto L8
        L16:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            java.util.List<com.facebook.ads.redexgen.X.5M> r0 = r3.A0f
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.5M r0 = (com.facebook.ads.redexgen.X.C5M) r0
            if (r0 == 0) goto L24
            r0 = 6
            goto L8
        L24:
            r0 = 6
            goto L8
        L26:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            r1 = 0
            java.util.List<com.facebook.ads.redexgen.X.5M> r0 = r3.A0f
            int r2 = r0.size()
            r0 = 4
            goto L8
        L31:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            java.util.List<com.facebook.ads.redexgen.X.5M> r0 = r3.A0f
            if (r0 == 0) goto L39
            r0 = 3
            goto L8
        L39:
            r0 = 7
            goto L8
        L3b:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            com.facebook.ads.redexgen.X.5M r0 = r3.A0Y
            if (r0 == 0) goto L44
            r0 = 8
            goto L8
        L44:
            r0 = 8
            goto L8
        L47:
            r0 = 2
            goto L8
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0F(int):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 431
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void A0G(int r38) {
        /*
            Method dump skipped, instructions count: 1684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0G(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0049, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0H(int r5, float r6, int r7) {
        /*
            r4 = this;
            r3 = r4
            r2 = 0
            r1 = 0
            com.facebook.ads.redexgen.X.5M r0 = r3.A0Z
            if (r0 == 0) goto L47
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto L31;
                case 3: goto L26;
                case 4: goto L20;
                case 5: goto L10;
                case 6: goto Lc;
                case 7: goto L3b;
                case 8: goto L49;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            int r1 = r1 + 1
            r0 = 4
            goto L8
        L10:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            java.util.List<com.facebook.ads.redexgen.X.5M> r0 = r3.A0f
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.5M r0 = (com.facebook.ads.redexgen.X.C5M) r0
            if (r0 == 0) goto L1e
            r0 = 6
            goto L8
        L1e:
            r0 = 6
            goto L8
        L20:
            if (r1 >= r2) goto L24
            r0 = 5
            goto L8
        L24:
            r0 = 7
            goto L8
        L26:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            r1 = 0
            java.util.List<com.facebook.ads.redexgen.X.5M> r0 = r3.A0f
            int r2 = r0.size()
            r0 = 4
            goto L8
        L31:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            java.util.List<com.facebook.ads.redexgen.X.5M> r0 = r3.A0f
            if (r0 == 0) goto L39
            r0 = 3
            goto L8
        L39:
            r0 = 7
            goto L8
        L3b:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            com.facebook.ads.redexgen.X.5M r0 = r3.A0Y
            if (r0 == 0) goto L44
            r0 = 8
            goto L8
        L44:
            r0 = 8
            goto L8
        L47:
            r0 = 2
            goto L8
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0H(int, float, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0119, code lost:            r9.A0g = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x011e, code lost:            return;     */
    @android.support.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0I(int r18, float r19, int r20) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0I(int, float, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0131, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0J(int r15, int r16, int r17) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0J(int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ba, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0K(int r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            r2 = r8
            r1 = 0
            r7 = 0
            r3 = 0
            if (r10 <= 0) goto Lb7
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L6b;
                case 3: goto L5d;
                case 4: goto L3c;
                case 5: goto Lba;
                case 6: goto Lb;
                case 7: goto L79;
                case 8: goto L4e;
                case 9: goto L8a;
                case 10: goto La7;
                case 11: goto L38;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            int r0 = r2.getPaddingLeft()
            int r6 = r9 - r0
            int r0 = r2.getPaddingRight()
            int r6 = r6 - r0
            int r6 = r6 + r11
            int r0 = r2.getPaddingLeft()
            int r5 = r10 - r0
            int r0 = r2.getPaddingRight()
            int r5 = r5 - r0
            int r5 = r5 + r12
            int r0 = r2.getScrollX()
            float r4 = (float) r0
            float r0 = (float) r5
            float r4 = r4 / r0
            float r0 = (float) r6
            float r0 = r0 * r4
            int r4 = (int) r0
            int r0 = r2.getScrollY()
            r2.scrollTo(r4, r0)
            r0 = 5
            goto L7
        L38:
            r7 = 0
            r0 = 9
            goto L7
        L3c:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            android.widget.Scroller r5 = r2.A0X
            int r4 = r2.getCurrentItem()
            int r0 = r2.getClientWidth()
            int r4 = r4 * r0
            r5.setFinalX(r4)
            r0 = 5
            goto L7
        L4e:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            com.facebook.ads.redexgen.X.5I r3 = (com.facebook.ads.redexgen.X.C5I) r3
            float r4 = r3.A00
            float r0 = r2.A07
            float r7 = java.lang.Math.min(r4, r0)
            r0 = 9
            goto L7
        L5d:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            android.widget.Scroller r0 = r2.A0X
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L69
            r0 = 4
            goto L7
        L69:
            r0 = 6
            goto L7
        L6b:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            java.util.ArrayList<com.facebook.ads.redexgen.X.5I> r0 = r2.A0t
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L77
            r0 = 3
            goto L7
        L77:
            r0 = 7
            goto L7
        L79:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            int r0 = r2.A00
            com.facebook.ads.redexgen.X.5I r3 = r2.A04(r0)
            if (r3 == 0) goto L86
            r0 = 8
            goto L7
        L86:
            r0 = 11
            goto L7
        L8a:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            int r0 = r2.getPaddingLeft()
            int r1 = r9 - r0
            int r0 = r2.getPaddingRight()
            int r1 = r1 - r0
            float r0 = (float) r1
            float r0 = r0 * r7
            int r1 = (int) r0
            int r0 = r2.getScrollX()
            if (r1 == r0) goto La4
            r0 = 10
            goto L7
        La4:
            r0 = 5
            goto L7
        La7:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            r0 = 0
            r2.A0R(r0)
            int r0 = r2.getScrollY()
            r2.scrollTo(r1, r0)
            r0 = 5
            goto L7
        Lb7:
            r0 = 7
            goto L7
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0K(int, int, int, int):void");
    }

    private final void A0L(int i, boolean z) {
        this.A0o = false;
        A0N(i, z, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0065, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0M(int r7, boolean r8, int r9, boolean r10) {
        /*
            r6 = this;
            r5 = r6
            r0 = 0
            r0 = 0
            r0 = 0
            r0 = 0
            com.facebook.ads.redexgen.X.5I r4 = r5.A04(r7)
            r1 = 0
            if (r4 == 0) goto L63
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L38;
                case 3: goto L24;
                case 4: goto L18;
                case 5: goto L11;
                case 6: goto L65;
                case 7: goto L53;
                case 8: goto L5b;
                case 9: goto L2a;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            r5.A0E(r7)
            r0 = 6
            goto Ld
        L18:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            r0 = 0
            r5.A0J(r1, r0, r9)
            if (r10 == 0) goto L22
            r0 = 5
            goto Ld
        L22:
            r0 = 6
            goto Ld
        L24:
            if (r8 == 0) goto L28
            r0 = 4
            goto Ld
        L28:
            r0 = 7
            goto Ld
        L2a:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            r0 = 0
            r5.A0R(r0)
            r5.scrollTo(r1, r0)
            r5.A0Z(r1)
            r0 = 6
            goto Ld
        L38:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            com.facebook.ads.redexgen.X.5I r4 = (com.facebook.ads.redexgen.X.C5I) r4
            int r0 = r5.getClientWidth()
            float r3 = (float) r0
            float r2 = r5.A02
            float r1 = r4.A00
            float r0 = r5.A07
            float r0 = java.lang.Math.min(r1, r0)
            float r0 = java.lang.Math.max(r2, r0)
            float r3 = r3 * r0
            int r1 = (int) r3
            r0 = 3
            goto Ld
        L53:
            if (r10 == 0) goto L58
            r0 = 8
            goto Ld
        L58:
            r0 = 9
            goto Ld
        L5b:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            r5.A0E(r7)
            r0 = 9
            goto Ld
        L63:
            r0 = 3
            goto Ld
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0M(int, boolean, int, boolean):void");
    }

    private final void A0N(int i, boolean z, boolean z2) {
        A0O(i, z, z2, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0110, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A0O(int r6, boolean r7, boolean r8, int r9) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0O(int, boolean, boolean, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0043, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0P(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            int r2 = r6.getActionIndex()
            int r1 = r6.getPointerId(r2)
            int r0 = r4.A08
            if (r1 != r0) goto L41
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L38;
                case 3: goto L35;
                case 4: goto L1d;
                case 5: goto L14;
                case 6: goto L43;
                case 7: goto L3e;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            android.view.VelocityTracker r0 = r4.A0U
            r0.clear()
            r0 = 6
            goto L10
        L1d:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            android.view.MotionEvent r6 = (android.view.MotionEvent) r6
            float r0 = r6.getX(r3)
            r4.A05 = r0
            int r0 = r6.getPointerId(r3)
            r4.A08 = r0
            android.view.VelocityTracker r0 = r4.A0U
            if (r0 == 0) goto L33
            r0 = 5
            goto L10
        L33:
            r0 = 6
            goto L10
        L35:
            r3 = 1
            r0 = 4
            goto L10
        L38:
            if (r2 != 0) goto L3c
            r0 = 3
            goto L10
        L3c:
            r0 = 7
            goto L10
        L3e:
            r3 = 0
            r0 = 4
            goto L10
        L41:
            r0 = 6
            goto L10
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0P(android.view.MotionEvent):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:272:0x0355, code lost:            r14.A0n = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x035a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0Q(com.facebook.ads.redexgen.X.C5I r29, int r30, com.facebook.ads.redexgen.X.C5I r31) {
        /*
            Method dump skipped, instructions count: 960
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0Q(com.facebook.ads.redexgen.X.5I, int, com.facebook.ads.redexgen.X.5I):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x00eb, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0R(boolean r13) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0R(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0031, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0S(boolean r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r0 = 0
            r0 = 0
            int r3 = r5.getChildCount()
            r2 = 0
            r0 = 2
        La:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L25;
                case 4: goto L1f;
                case 5: goto L11;
                case 6: goto Le;
                case 7: goto L31;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r4 = 0
            r0 = 5
            goto La
        L11:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            android.view.View r1 = r5.getChildAt(r2)
            r0 = 0
            r1.setLayerType(r4, r0)
            int r2 = r2 + 1
            r0 = 2
            goto La
        L1f:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            int r4 = r5.A0N
            r0 = 5
            goto La
        L25:
            if (r7 == 0) goto L29
            r0 = 4
            goto La
        L29:
            r0 = 6
            goto La
        L2b:
            if (r2 >= r3) goto L2f
            r0 = 3
            goto La
        L2f:
            r0 = 7
            goto La
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0S(boolean):void");
    }

    private void A0T(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0U() {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            r0 = -1
            r2.A08 = r0
            r2.A09()
            android.widget.EdgeEffect r0 = r2.A0V
            r0.onRelease()
            android.widget.EdgeEffect r0 = r2.A0W
            r0.onRelease()
            android.widget.EdgeEffect r0 = r2.A0V
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L33
            r0 = 2
        L1b:
            switch(r0) {
                case 2: goto L1f;
                case 3: goto L2d;
                case 4: goto L35;
                case 5: goto L30;
                default: goto L1e;
            }
        L1e:
            goto L1b
        L1f:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            android.widget.EdgeEffect r0 = r2.A0W
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L2b
            r0 = 3
            goto L1b
        L2b:
            r0 = 5
            goto L1b
        L2d:
            r1 = 1
            r0 = 4
            goto L1b
        L30:
            r1 = 0
            r0 = 4
            goto L1b
        L33:
            r0 = 3
            goto L1b
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0U():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0V() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            r1 = 1
            int r0 = r2.A00
            if (r0 <= 0) goto L1a
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1c;
                case 4: goto L17;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            int r0 = r2.A00
            int r0 = r0 + (-1)
            r2.A0L(r0, r1)
            r0 = 3
            goto L8
        L17:
            r1 = 0
            r0 = 3
            goto L8
        L1a:
            r0 = 4
            goto L8
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0V():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0W() {
        /*
            r4 = this;
            r3 = r4
            r0 = 0
            r2 = 1
            com.facebook.ads.redexgen.X.4n r0 = r3.A01
            if (r0 == 0) goto L2c
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L1e;
                case 4: goto L2e;
                case 5: goto L29;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            int r1 = r3.A00
            com.facebook.ads.redexgen.X.4n r0 = r3.A01
            int r0 = r0.A05()
            int r0 = r0 + (-1)
            if (r1 >= r0) goto L1c
            r0 = 3
            goto L8
        L1c:
            r0 = 5
            goto L8
        L1e:
            com.facebook.ads.redexgen.X.5T r3 = (com.facebook.ads.redexgen.X.C5T) r3
            int r0 = r3.A00
            int r0 = r0 + 1
            r3.A0L(r0, r2)
            r0 = 4
            goto L8
        L29:
            r2 = 0
            r0 = 4
            goto L8
        L2c:
            r0 = 5
            goto L8
        L2e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0W():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:            r3 = r3;        r3.A05 += r4 - ((int) r4);        r3.scrollTo((int) r4, r3.getScrollY());        r3.A0Z((int) r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d5, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0X(float r13) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0X(float):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x003b, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0Y(float r6, float r7) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            r0 = 0
            r2 = 0
            int r0 = r4.A0I
            float r0 = (float) r0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 >= 0) goto L39
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L1b;
                case 4: goto L13;
                case 5: goto L10;
                case 6: goto L3b;
                case 7: goto L36;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r3 = 1
            r0 = 6
            goto Lc
        L13:
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 >= 0) goto L19
            r0 = 5
            goto Lc
        L19:
            r0 = 7
            goto Lc
        L1b:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            int r1 = r4.getWidth()
            int r0 = r4.A0I
            int r1 = r1 - r0
            float r0 = (float) r1
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L2b
            r0 = 4
            goto Lc
        L2b:
            r0 = 7
            goto Lc
        L2d:
            r2 = 0
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 > 0) goto L34
            r0 = 3
            goto Lc
        L34:
            r0 = 5
            goto Lc
        L36:
            r3 = 0
            r0 = 6
            goto Lc
        L39:
            r0 = 3
            goto Lc
        L3b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0Y(float, float):boolean");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000c. Please report as an issue. */
    private boolean A0Z(int i) {
        C5T c5t = this;
        boolean z = false;
        float pageOffset = c5t.A0t.size() == 0 ? 2.8E-45f : 8.4E-45f;
        while (true) {
            switch (pageOffset) {
                case 2.8E-45f:
                    c5t = c5t;
                    pageOffset = c5t.A0i ? 4.2E-45f : 5.6E-45f;
                case 4.2E-45f:
                    return z;
                case 5.6E-45f:
                    c5t = c5t;
                    z = false;
                    c5t.A0g = false;
                    c5t.A0I(0, 0.0f, 0);
                    pageOffset = !c5t.A0g ? 7.0E-45f : 4.2E-45f;
                case 7.0E-45f:
                    throw new IllegalStateException(A08(366, 53, 20));
                case 8.4E-45f:
                    c5t = c5t;
                    z = false;
                    C5I A03 = c5t.A03();
                    int clientWidth = c5t.getClientWidth();
                    int width = c5t.A0M;
                    int i2 = clientWidth + width;
                    int widthWithMargin = c5t.A0M;
                    float f = widthWithMargin / clientWidth;
                    int i3 = A03.A02;
                    float marginOffset = clientWidth;
                    float f2 = i / marginOffset;
                    float marginOffset2 = A03.A00;
                    float f3 = f2 - marginOffset2;
                    float marginOffset3 = A03.A01;
                    float f4 = f3 / (marginOffset3 + f);
                    float pageOffset2 = i2;
                    c5t.A0g = false;
                    c5t.A0I(i3, f4, (int) (pageOffset2 * f4));
                    pageOffset = !c5t.A0g ? 9.8E-45f : 1.1E-44f;
                case 9.8E-45f:
                    throw new IllegalStateException(A08(366, 53, 20));
                case 1.1E-44f:
                    z = true;
                    pageOffset = 4.2E-45f;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:205:0x01e4, code lost:            return r16;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0a(int r19) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0a(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x008f, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0b(android.view.KeyEvent r6) {
        /*
            r5 = this;
            r4 = r5
            r0 = 0
            r0 = 0
            r0 = 0
            r3 = 1
            r2 = 2
            r1 = 0
            int r0 = r6.getAction()
            if (r0 != 0) goto L8d
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L48;
                case 3: goto L8f;
                case 4: goto L26;
                case 5: goto L1e;
                case 6: goto L12;
                case 7: goto L5b;
                case 8: goto L63;
                case 9: goto L32;
                case 10: goto L71;
                case 11: goto L3a;
                case 12: goto L7b;
                case 13: goto L83;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            android.view.KeyEvent r6 = (android.view.KeyEvent) r6
            boolean r0 = r6.hasModifiers(r3)
            if (r0 == 0) goto L1c
            r0 = 7
            goto Le
        L1c:
            r0 = 3
            goto Le
        L1e:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            boolean r1 = r4.A0a(r2)
            r0 = 3
            goto Le
        L26:
            android.view.KeyEvent r6 = (android.view.KeyEvent) r6
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L30
            r0 = 5
            goto Le
        L30:
            r0 = 6
            goto Le
        L32:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            boolean r1 = r4.A0W()
            r0 = 3
            goto Le
        L3a:
            android.view.KeyEvent r6 = (android.view.KeyEvent) r6
            boolean r0 = r6.hasModifiers(r2)
            if (r0 == 0) goto L45
            r0 = 12
            goto Le
        L45:
            r0 = 13
            goto Le
        L48:
            android.view.KeyEvent r6 = (android.view.KeyEvent) r6
            int r0 = r6.getKeyCode()
            switch(r0) {
                case 21: goto L53;
                case 22: goto L56;
                case 61: goto L59;
                default: goto L51;
            }
        L51:
            r0 = 3
            goto Le
        L53:
            r0 = 11
            goto Le
        L56:
            r0 = 8
            goto Le
        L59:
            r0 = 4
            goto Le
        L5b:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            boolean r1 = r4.A0a(r3)
            r0 = 3
            goto Le
        L63:
            android.view.KeyEvent r6 = (android.view.KeyEvent) r6
            boolean r0 = r6.hasModifiers(r2)
            if (r0 == 0) goto L6e
            r0 = 9
            goto Le
        L6e:
            r0 = 10
            goto Le
        L71:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            r0 = 66
            boolean r1 = r4.A0a(r0)
            r0 = 3
            goto Le
        L7b:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            boolean r1 = r4.A0V()
            r0 = 3
            goto Le
        L83:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            r0 = 17
            boolean r1 = r4.A0a(r0)
            r0 = 3
            goto Le
        L8d:
            r0 = 3
            goto Le
        L8f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0b(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0c(@android.support.annotation.NonNull android.view.View r3) {
        /*
            r2 = 0
            java.lang.Class r1 = r3.getClass()
            java.lang.Class<com.facebook.ads.internal.androidx.support.v4.view.ViewPager$DecorView> r0 = com.facebook.ads.internal.androidx.support.v4.view.ViewPager$DecorView.class
            java.lang.annotation.Annotation r0 = r1.getAnnotation(r0)
            if (r0 == 0) goto L18
            r0 = 2
        Le:
            switch(r0) {
                case 2: goto L12;
                case 3: goto L1a;
                case 4: goto L15;
                default: goto L11;
            }
        L11:
            goto Le
        L12:
            r2 = 1
            r0 = 3
            goto Le
        L15:
            r2 = 0
            r0 = 3
            goto Le
        L18:
            r0 = 4
            goto Le
        L1a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0c(android.view.View):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x00c1, code lost:            return r6;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean A0d(android.view.View r14, boolean r15, int r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0d(android.view.View, boolean, int, int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x0153, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0e() {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.A0e():void");
    }

    public final void A0f() {
        A0G(this.A00);
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x00d1, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void addFocusables(java.util.ArrayList<android.view.View> r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.addFocusables(java.util.ArrayList, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0050, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void addTouchables(java.util.ArrayList<android.view.View> r7) {
        /*
            r6 = this;
            r5 = r6
            r4 = 0
            r3 = 0
            r0 = 0
            r2 = 0
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto L43;
                case 3: goto L2f;
                case 4: goto L21;
                case 5: goto L13;
                case 6: goto La;
                case 7: goto L3f;
                case 8: goto L50;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            android.view.View r3 = (android.view.View) r3
            r3.addTouchables(r7)
            r0 = 7
            goto L6
        L13:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            com.facebook.ads.redexgen.X.5I r4 = (com.facebook.ads.redexgen.X.C5I) r4
            int r1 = r4.A02
            int r0 = r5.A00
            if (r1 != r0) goto L1f
            r0 = 6
            goto L6
        L1f:
            r0 = 7
            goto L6
        L21:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.5I r4 = r5.A07(r3)
            if (r4 == 0) goto L2d
            r0 = 5
            goto L6
        L2d:
            r0 = 7
            goto L6
        L2f:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            android.view.View r3 = r5.getChildAt(r2)
            int r0 = r3.getVisibility()
            if (r0 != 0) goto L3d
            r0 = 4
            goto L6
        L3d:
            r0 = 7
            goto L6
        L3f:
            int r2 = r2 + 1
            r0 = 2
            goto L6
        L43:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            int r0 = r5.getChildCount()
            if (r2 >= r0) goto L4d
            r0 = 3
            goto L6
        L4d:
            r0 = 8
            goto L6
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.addTouchables(java.util.ArrayList):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        C5T c5t = this;
        C5J c5j = null;
        char c = !c5t.checkLayoutParams(layoutParams) ? (char) 2 : (char) 3;
        while (true) {
            switch (c) {
                case 2:
                    c5t = c5t;
                    layoutParams = c5t.generateLayoutParams(layoutParams);
                    c = 3;
                case 3:
                    c5t = c5t;
                    view = view;
                    layoutParams = layoutParams;
                    c5j = (C5J) layoutParams;
                    c5j.A05 |= A0c(view);
                    c = c5t.A0j ? (char) 4 : (char) 7;
                case 4:
                    c5j = c5j;
                    c = c5j != null ? (char) 5 : '\b';
                case 5:
                    c5j = c5j;
                    c = c5j.A05 ? (char) 6 : '\b';
                case 6:
                    throw new IllegalStateException(A08(22, 41, 1));
                case 7:
                    c5t = c5t;
                    view = view;
                    layoutParams = layoutParams;
                    super.addView(view, i, layoutParams);
                    c = '\t';
                case '\b':
                    c5t = c5t;
                    view = view;
                    layoutParams = layoutParams;
                    c5j = c5j;
                    c5j.A03 = true;
                    c5t.addViewInLayout(view, i, layoutParams);
                    c = '\t';
                case '\t':
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0054, code lost:            return r2;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean canScrollHorizontally(int r8) {
        /*
            r7 = this;
            r6 = r7
            r0 = 0
            r5 = 0
            r4 = 0
            r0 = 0
            r3 = 1
            r2 = 0
            com.facebook.ads.redexgen.X.4n r0 = r6.A01
            if (r0 != 0) goto L52
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L54;
                case 3: goto L29;
                case 4: goto L1c;
                case 5: goto L19;
                case 6: goto L10;
                case 7: goto L39;
                case 8: goto L40;
                case 9: goto L4f;
                case 10: goto L14;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r2 = 0
            r3 = r2
            r0 = 5
            goto Lc
        L14:
            r2 = 0
            r3 = r2
            r0 = 9
            goto Lc
        L19:
            r2 = r3
            r0 = 2
            goto Lc
        L1c:
            com.facebook.ads.redexgen.X.5T r6 = (com.facebook.ads.redexgen.X.C5T) r6
            float r1 = (float) r4
            float r0 = r6.A02
            float r1 = r1 * r0
            int r0 = (int) r1
            if (r5 <= r0) goto L27
            r0 = 5
            goto Lc
        L27:
            r0 = 6
            goto Lc
        L29:
            com.facebook.ads.redexgen.X.5T r6 = (com.facebook.ads.redexgen.X.C5T) r6
            int r4 = r6.getClientWidth()
            int r5 = r6.getScrollX()
            if (r8 >= 0) goto L37
            r0 = 4
            goto Lc
        L37:
            r0 = 7
            goto Lc
        L39:
            if (r8 <= 0) goto L3e
            r0 = 8
            goto Lc
        L3e:
            r0 = 2
            goto Lc
        L40:
            com.facebook.ads.redexgen.X.5T r6 = (com.facebook.ads.redexgen.X.C5T) r6
            float r1 = (float) r4
            float r0 = r6.A07
            float r1 = r1 * r0
            int r0 = (int) r1
            if (r5 >= r0) goto L4c
            r0 = 9
            goto Lc
        L4c:
            r0 = 10
            goto Lc
        L4f:
            r2 = r3
            r0 = 2
            goto Lc
        L52:
            r0 = 3
            goto Lc
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.canScrollHorizontally(int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean checkLayoutParams(android.view.ViewGroup.LayoutParams r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = r4 instanceof com.facebook.ads.redexgen.X.C5J
            if (r0 == 0) goto L1f
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            boolean r0 = super.checkLayoutParams(r4)
            if (r0 == 0) goto L17
            r0 = 3
            goto L7
        L17:
            r0 = 5
            goto L7
        L19:
            r1 = 1
            r0 = 4
            goto L7
        L1c:
            r1 = 0
            r0 = 4
            goto L7
        L1f:
            r0 = 5
            goto L7
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.checkLayoutParams(android.view.ViewGroup$LayoutParams):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0075, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void computeScroll() {
        /*
            r7 = this;
            r6 = r7
            r0 = 0
            r5 = 0
            r4 = 0
            r3 = 0
            r2 = 1
            r6.A0l = r2
            android.widget.Scroller r0 = r6.A0X
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L72
            r0 = 2
        L11:
            switch(r0) {
                case 2: goto L5b;
                case 3: goto L3f;
                case 4: goto L31;
                case 5: goto L22;
                case 6: goto L15;
                case 7: goto L37;
                case 8: goto L75;
                case 9: goto L6a;
                default: goto L14;
            }
        L14:
            goto L11
        L15:
            com.facebook.ads.redexgen.X.5T r6 = (com.facebook.ads.redexgen.X.C5T) r6
            android.widget.Scroller r0 = r6.A0X
            r0.abortAnimation()
            r0 = 0
            r6.scrollTo(r0, r4)
            r0 = 7
            goto L11
        L22:
            com.facebook.ads.redexgen.X.5T r6 = (com.facebook.ads.redexgen.X.C5T) r6
            r6.scrollTo(r5, r4)
            boolean r0 = r6.A0Z(r5)
            if (r0 != 0) goto L2f
            r0 = 6
            goto L11
        L2f:
            r0 = 7
            goto L11
        L31:
            if (r3 == r4) goto L35
            r0 = 5
            goto L11
        L35:
            r0 = 7
            goto L11
        L37:
            com.facebook.ads.redexgen.X.5T r6 = (com.facebook.ads.redexgen.X.C5T) r6
            com.facebook.ads.redexgen.X.C5B.A07(r6)
            r0 = 8
            goto L11
        L3f:
            com.facebook.ads.redexgen.X.5T r6 = (com.facebook.ads.redexgen.X.C5T) r6
            int r1 = r6.getScrollX()
            int r3 = r6.getScrollY()
            android.widget.Scroller r0 = r6.A0X
            int r5 = r0.getCurrX()
            android.widget.Scroller r0 = r6.A0X
            int r4 = r0.getCurrY()
            if (r1 != r5) goto L59
            r0 = 4
            goto L11
        L59:
            r0 = 5
            goto L11
        L5b:
            com.facebook.ads.redexgen.X.5T r6 = (com.facebook.ads.redexgen.X.C5T) r6
            android.widget.Scroller r0 = r6.A0X
            boolean r0 = r0.computeScrollOffset()
            if (r0 == 0) goto L67
            r0 = 3
            goto L11
        L67:
            r0 = 9
            goto L11
        L6a:
            com.facebook.ads.redexgen.X.5T r6 = (com.facebook.ads.redexgen.X.C5T) r6
            r6.A0R(r2)
            r0 = 8
            goto L11
        L72:
            r0 = 9
            goto L11
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.computeScroll():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0023, code lost:            return r1;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = super.dispatchKeyEvent(r4)
            if (r0 != 0) goto L21
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L1b;
                case 4: goto L23;
                case 5: goto L1e;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            android.view.KeyEvent r4 = (android.view.KeyEvent) r4
            boolean r0 = r2.A0b(r4)
            if (r0 == 0) goto L19
            r0 = 3
            goto L9
        L19:
            r0 = 5
            goto L9
        L1b:
            r1 = 1
            r0 = 4
            goto L9
        L1e:
            r1 = 0
            r0 = 4
            goto L9
        L21:
            r0 = 3
            goto L9
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x007a, code lost:            return r4;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent r9) {
        /*
            r8 = this;
            r7 = r8
            r6 = 0
            r5 = 0
            r4 = 0
            r3 = 0
            r2 = 0
            int r1 = r9.getEventType()
            r0 = 4096(0x1000, float:5.74E-42)
            if (r1 != r0) goto L78
            r0 = 2
        Lf:
            switch(r0) {
                case 2: goto L2b;
                case 3: goto L7a;
                case 4: goto L35;
                case 5: goto L24;
                case 6: goto L13;
                case 7: goto L5e;
                case 8: goto L4e;
                case 9: goto L3e;
                case 10: goto L6e;
                case 11: goto L71;
                case 12: goto L75;
                default: goto L12;
            }
        L12:
            goto Lf
        L13:
            com.facebook.ads.redexgen.X.5T r7 = (com.facebook.ads.redexgen.X.C5T) r7
            android.view.View r5 = r7.getChildAt(r2)
            int r0 = r5.getVisibility()
            if (r0 != 0) goto L21
            r0 = 7
            goto Lf
        L21:
            r0 = 11
            goto Lf
        L24:
            if (r2 >= r3) goto L28
            r0 = 6
            goto Lf
        L28:
            r0 = 12
            goto Lf
        L2b:
            com.facebook.ads.redexgen.X.5T r7 = (com.facebook.ads.redexgen.X.C5T) r7
            android.view.accessibility.AccessibilityEvent r9 = (android.view.accessibility.AccessibilityEvent) r9
            boolean r4 = super.dispatchPopulateAccessibilityEvent(r9)
            r0 = 3
            goto Lf
        L35:
            com.facebook.ads.redexgen.X.5T r7 = (com.facebook.ads.redexgen.X.C5T) r7
            int r3 = r7.getChildCount()
            r2 = 0
            r0 = 5
            goto Lf
        L3e:
            android.view.accessibility.AccessibilityEvent r9 = (android.view.accessibility.AccessibilityEvent) r9
            android.view.View r5 = (android.view.View) r5
            boolean r0 = r5.dispatchPopulateAccessibilityEvent(r9)
            if (r0 == 0) goto L4b
            r0 = 10
            goto Lf
        L4b:
            r0 = 11
            goto Lf
        L4e:
            com.facebook.ads.redexgen.X.5T r7 = (com.facebook.ads.redexgen.X.C5T) r7
            com.facebook.ads.redexgen.X.5I r6 = (com.facebook.ads.redexgen.X.C5I) r6
            int r1 = r6.A02
            int r0 = r7.A00
            if (r1 != r0) goto L5b
            r0 = 9
            goto Lf
        L5b:
            r0 = 11
            goto Lf
        L5e:
            com.facebook.ads.redexgen.X.5T r7 = (com.facebook.ads.redexgen.X.C5T) r7
            android.view.View r5 = (android.view.View) r5
            com.facebook.ads.redexgen.X.5I r6 = r7.A07(r5)
            if (r6 == 0) goto L6b
            r0 = 8
            goto Lf
        L6b:
            r0 = 11
            goto Lf
        L6e:
            r4 = 1
            r0 = 3
            goto Lf
        L71:
            int r2 = r2 + 1
            r0 = 5
            goto Lf
        L75:
            r4 = 0
            r0 = 3
            goto Lf
        L78:
            r0 = 4
            goto Lf
        L7a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00fb, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.draw(android.graphics.Canvas):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void drawableStateChanged() {
        /*
            r3 = this;
            r2 = r3
            r0 = 0
            super.drawableStateChanged()
            android.graphics.drawable.Drawable r1 = r2.A0S
            if (r1 == 0) goto L27
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L1a;
                case 4: goto L29;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            boolean r0 = r1.isStateful()
            if (r0 == 0) goto L18
            r0 = 3
            goto La
        L18:
            r0 = 4
            goto La
        L1a:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            int[] r0 = r2.getDrawableState()
            r1.setState(r0)
            r0 = 4
            goto La
        L27:
            r0 = 4
            goto La
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.drawableStateChanged():void");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C5J();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C5J(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public AbstractC01204n getAdapter() {
        return this.A01;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:            return ((com.facebook.ads.redexgen.X.C5J) r3.A0d.get(r1).getLayoutParams()).A01;     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getChildDrawingOrder(int r4, int r5) {
        /*
            r3 = this;
            r1 = 0
            int r2 = r3.A0F
            r0 = 2
            if (r2 != r0) goto L13
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L15;
                case 4: goto L10;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            int r1 = r4 + (-1)
            int r1 = r1 - r5
            r0 = 3
            goto L7
        L10:
            r1 = r5
            r0 = 3
            goto L7
        L13:
            r0 = 4
            goto L7
        L15:
            r0 = r3
            com.facebook.ads.redexgen.X.5T r0 = (com.facebook.ads.redexgen.X.C5T) r0
            java.util.ArrayList<android.view.View> r0 = r0.A0d
            java.lang.Object r0 = r0.get(r1)
            android.view.View r0 = (android.view.View) r0
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            com.facebook.ads.redexgen.X.5J r0 = (com.facebook.ads.redexgen.X.C5J) r0
            int r0 = r0.A01
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.getChildDrawingOrder(int, int):int");
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public int getCurrentItem() {
        return this.A00;
    }

    public int getOffscreenPageLimit() {
        return this.A0L;
    }

    public int getPageMargin() {
        return this.A0M;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A0i = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:            super.onDetachedFromWindow();     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDetachedFromWindow() {
        /*
            r2 = this;
            r1 = r2
            java.lang.Runnable r0 = r1.A0s
            r1.removeCallbacks(r0)
            android.widget.Scroller r0 = r1.A0X
            if (r0 == 0) goto L26
            r0 = 2
        Lb:
            switch(r0) {
                case 2: goto Lf;
                case 3: goto L1d;
                case 4: goto L28;
                default: goto Le;
            }
        Le:
            goto Lb
        Lf:
            com.facebook.ads.redexgen.X.5T r1 = (com.facebook.ads.redexgen.X.C5T) r1
            android.widget.Scroller r0 = r1.A0X
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L1b
            r0 = 3
            goto Lb
        L1b:
            r0 = 4
            goto Lb
        L1d:
            com.facebook.ads.redexgen.X.5T r1 = (com.facebook.ads.redexgen.X.C5T) r1
            android.widget.Scroller r0 = r1.A0X
            r0.abortAnimation()
            r0 = 4
            goto Lb
        L26:
            r0 = 4
            goto Lb
        L28:
            com.facebook.ads.redexgen.X.5T r1 = (com.facebook.ads.redexgen.X.C5T) r1
            super.onDetachedFromWindow()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.onDetachedFromWindow():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0124, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r22) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:216:0x021f, code lost:            return r4;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v11, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v12, types: [android.view.View, com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v13, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v14, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v15, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v16, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v17, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v18, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v19, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v2, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v20, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v21, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v22, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v23, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v24, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v25, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v26, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v5, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v6, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v7, types: [android.view.View, com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v8, types: [com.facebook.ads.redexgen.X.5T] */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.facebook.ads.redexgen.X.5T] */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x0264, code lost:            r7.A0i = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0269, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onLayout(boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 704
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:222:0x0272, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r25, int r26) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.onMeasure(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0079, code lost:            return r9;     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onRequestFocusInDescendants(int r12, android.graphics.Rect r13) {
        /*
            r11 = this;
            r8 = r11
            r10 = 0
            r9 = 0
            r7 = 0
            r6 = 0
            r0 = 0
            r5 = 0
            r4 = 0
            r3 = 0
            int r2 = r8.getChildCount()
            r0 = r12 & 2
            if (r0 == 0) goto L76
            r0 = 2
        L12:
            switch(r0) {
                case 2: goto L54;
                case 3: goto L3d;
                case 4: goto L36;
                case 5: goto L25;
                case 6: goto L16;
                case 7: goto L40;
                case 8: goto L59;
                case 9: goto L6f;
                case 10: goto L79;
                case 11: goto L73;
                case 12: goto L50;
                case 13: goto L69;
                default: goto L15;
            }
        L15:
            goto L12
        L16:
            com.facebook.ads.redexgen.X.5T r8 = (com.facebook.ads.redexgen.X.C5T) r8
            android.view.View r3 = (android.view.View) r3
            com.facebook.ads.redexgen.X.5I r7 = r8.A07(r3)
            if (r7 == 0) goto L22
            r0 = 7
            goto L12
        L22:
            r0 = 11
            goto L12
        L25:
            com.facebook.ads.redexgen.X.5T r8 = (com.facebook.ads.redexgen.X.C5T) r8
            android.view.View r3 = r8.getChildAt(r4)
            int r0 = r3.getVisibility()
            if (r0 != 0) goto L33
            r0 = 6
            goto L12
        L33:
            r0 = 11
            goto L12
        L36:
            if (r4 == r5) goto L3a
            r0 = 5
            goto L12
        L3a:
            r0 = 12
            goto L12
        L3d:
            r4 = r6
            r0 = 4
            goto L12
        L40:
            com.facebook.ads.redexgen.X.5T r8 = (com.facebook.ads.redexgen.X.C5T) r8
            com.facebook.ads.redexgen.X.5I r7 = (com.facebook.ads.redexgen.X.C5I) r7
            int r1 = r7.A02
            int r0 = r8.A00
            if (r1 != r0) goto L4d
            r0 = 8
            goto L12
        L4d:
            r0 = 11
            goto L12
        L50:
            r9 = 0
            r0 = 10
            goto L12
        L54:
            r6 = 0
            r10 = 1
            r5 = r2
            r0 = 3
            goto L12
        L59:
            android.graphics.Rect r13 = (android.graphics.Rect) r13
            android.view.View r3 = (android.view.View) r3
            boolean r0 = r3.requestFocus(r12, r13)
            if (r0 == 0) goto L66
            r0 = 9
            goto L12
        L66:
            r0 = 11
            goto L12
        L69:
            int r6 = r2 + (-1)
            r10 = -1
            r5 = -1
            r0 = 3
            goto L12
        L6f:
            r9 = 1
            r0 = 10
            goto L12
        L73:
            int r4 = r4 + r10
            r0 = 4
            goto L12
        L76:
            r0 = 13
            goto L12
        L79:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.onRequestFocusInDescendants(int, android.graphics.Rect):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:            return;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onRestoreInstanceState(android.os.Parcelable r6) {
        /*
            r5 = this;
            r4 = r5
            r3 = 0
            boolean r0 = r6 instanceof com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState
            if (r0 != 0) goto L49
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L4b;
                case 4: goto L14;
                case 5: goto L2a;
                case 6: goto L37;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            android.os.Parcelable r6 = (android.os.Parcelable) r6
            super.onRestoreInstanceState(r6)
            r0 = 3
            goto L7
        L14:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            android.os.Parcelable r6 = (android.os.Parcelable) r6
            r3 = r6
            com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState r3 = (com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState) r3
            android.os.Parcelable r0 = r3.A02()
            super.onRestoreInstanceState(r0)
            com.facebook.ads.redexgen.X.4n r0 = r4.A01
            if (r0 == 0) goto L28
            r0 = 5
            goto L7
        L28:
            r0 = 6
            goto L7
        L2a:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState r3 = (com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState) r3
            int r2 = r3.A00
            r1 = 0
            r0 = 1
            r4.A0N(r2, r1, r0)
            r0 = 3
            goto L7
        L37:
            com.facebook.ads.redexgen.X.5T r4 = (com.facebook.ads.redexgen.X.C5T) r4
            com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState r3 = (com.facebook.ads.internal.androidx.support.v4.view.ViewPager$SavedState) r3
            int r0 = r3.A00
            r4.A0O = r0
            android.os.Parcelable r0 = r3.A01
            r4.A0T = r0
            java.lang.ClassLoader r0 = r3.A02
            r4.A0c = r0
            r0 = 3
            goto L7
        L49:
            r0 = 4
            goto L7
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.onRestoreInstanceState(android.os.Parcelable):void");
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState(superState);
        viewPager$SavedState.A00 = this.A00;
        if (this.A01 != null) {
            Parcelable superState2 = this.A01.A07();
            viewPager$SavedState.A01 = superState2;
        }
        return viewPager$SavedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            A0K(i, i3, this.A0M, this.A0M);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:217:0x0275, code lost:            return r13;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:            return;     */
    @Override // android.view.ViewGroup, android.view.ViewManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void removeView(android.view.View r3) {
        /*
            r2 = this;
            r1 = r2
            boolean r0 = r1.A0j
            if (r0 == 0) goto L1c
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1e;
                case 4: goto L13;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            com.facebook.ads.redexgen.X.5T r1 = (com.facebook.ads.redexgen.X.C5T) r1
            android.view.View r3 = (android.view.View) r3
            r1.removeViewInLayout(r3)
            r0 = 3
            goto L6
        L13:
            com.facebook.ads.redexgen.X.5T r1 = (com.facebook.ads.redexgen.X.C5T) r1
            android.view.View r3 = (android.view.View) r3
            super.removeView(r3)
            r0 = 3
            goto L6
        L1c:
            r0 = 4
            goto L6
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.removeView(android.view.View):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0114, code lost:            return;     */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.facebook.ads.redexgen.X.5O] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.os.Parcelable, java.lang.ClassLoader] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setAdapter(com.facebook.ads.redexgen.X.AbstractC01204n r12) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.setAdapter(com.facebook.ads.redexgen.X.4n):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0016, code lost:            A0N(r4, r2, false);     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCurrentItem(int r4) {
        /*
            r3 = this;
            r2 = 0
            r0 = 0
            r1 = 0
            r3.A0o = r1
            boolean r0 = r3.A0i
            if (r0 != 0) goto L14
            r0 = 2
        La:
            switch(r0) {
                case 2: goto Le;
                case 3: goto L16;
                case 4: goto L11;
                default: goto Ld;
            }
        Ld:
            goto La
        Le:
            r2 = 1
            r0 = 3
            goto La
        L11:
            r2 = r1
            r0 = 3
            goto La
        L14:
            r0 = 4
            goto La
        L16:
            r0 = r3
            com.facebook.ads.redexgen.X.5T r0 = (com.facebook.ads.redexgen.X.C5T) r0
            r0.A0N(r4, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.setCurrentItem(int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setOffscreenPageLimit(int r8) {
        /*
            r7 = this;
            r5 = r7
            r0 = 0
            r4 = 1
            if (r8 >= r4) goto L5a
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L47;
                case 4: goto L51;
                case 5: goto L5c;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r2 = 357(0x165, float:5.0E-43)
            r1 = 9
            r0 = 14
            java.lang.String r6 = A08(r2, r1, r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 72
            r1 = 31
            r0 = 49
            java.lang.String r0 = A08(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r3 = r0.append(r8)
            r2 = 103(0x67, float:1.44E-43)
            r1 = 26
            r0 = 95
            java.lang.String r0 = A08(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r6, r0)
            r8 = 1
            r0 = 3
            goto L6
        L47:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            int r0 = r5.A0L
            if (r8 == r0) goto L4f
            r0 = 4
            goto L6
        L4f:
            r0 = 5
            goto L6
        L51:
            com.facebook.ads.redexgen.X.5T r5 = (com.facebook.ads.redexgen.X.C5T) r5
            r5.A0L = r8
            r5.A0f()
            r0 = 5
            goto L6
        L5a:
            r0 = 3
            goto L6
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.setOffscreenPageLimit(int):void");
    }

    @Deprecated
    public void setOnPageChangeListener(C5M c5m) {
        this.A0Z = c5m;
    }

    public void setPageMargin(int width) {
        int i = this.A0M;
        this.A0M = width;
        int width2 = getWidth();
        A0K(width2, width2, width, i);
        requestLayout();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(C4B.A00(getContext(), i));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0022, code lost:            r2 = r2;        r2.setWillNotDraw(r1);        r2.invalidate();     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x002a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setPageMarginDrawable(android.graphics.drawable.Drawable r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            r2.A0S = r4
            if (r4 == 0) goto L20
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L12;
                case 4: goto L1a;
                case 5: goto L22;
                case 6: goto L1d;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            r2.refreshDrawableState()
            r0 = 3
            goto L7
        L12:
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            if (r4 != 0) goto L18
            r0 = 4
            goto L7
        L18:
            r0 = 6
            goto L7
        L1a:
            r1 = 1
            r0 = 5
            goto L7
        L1d:
            r1 = 0
            r0 = 5
            goto L7
        L20:
            r0 = 3
            goto L7
        L22:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            r2.setWillNotDraw(r1)
            r2.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.setPageMarginDrawable(android.graphics.drawable.Drawable):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0034, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setScrollState(int r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            int r0 = r2.A0P
            if (r0 != r4) goto L32
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto L34;
                case 3: goto L1c;
                case 4: goto L15;
                case 5: goto L12;
                case 6: goto Lb;
                case 7: goto L28;
                case 8: goto L2f;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            r2.A0S(r1)
            r0 = 7
            goto L7
        L12:
            r1 = 1
            r0 = 6
            goto L7
        L15:
            if (r4 == 0) goto L19
            r0 = 5
            goto L7
        L19:
            r0 = 8
            goto L7
        L1c:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            r2.A0P = r4
            com.facebook.ads.redexgen.X.5N r0 = r2.A0a
            if (r0 == 0) goto L26
            r0 = 4
            goto L7
        L26:
            r0 = 7
            goto L7
        L28:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            r2.A0F(r4)
            r0 = 2
            goto L7
        L2f:
            r1 = 0
            r0 = 6
            goto L7
        L32:
            r0 = 3
            goto L7
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.setScrollState(int):void");
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.A0p != z) {
            this.A0p = z;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0021, code lost:            return r1;     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean verifyDrawable(android.graphics.drawable.Drawable r4) {
        /*
            r3 = this;
            r2 = r3
            r1 = 0
            boolean r0 = super.verifyDrawable(r4)
            if (r0 != 0) goto L1f
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L19;
                case 4: goto L21;
                case 5: goto L1c;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            com.facebook.ads.redexgen.X.5T r2 = (com.facebook.ads.redexgen.X.C5T) r2
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            android.graphics.drawable.Drawable r0 = r2.A0S
            if (r4 != r0) goto L17
            r0 = 3
            goto L9
        L17:
            r0 = 5
            goto L9
        L19:
            r1 = 1
            r0 = 4
            goto L9
        L1c:
            r1 = 0
            r0 = 4
            goto L9
        L1f:
            r0 = 3
            goto L9
        L21:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C5T.verifyDrawable(android.graphics.drawable.Drawable):boolean");
    }
}
