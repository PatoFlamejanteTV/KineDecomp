package com.facebook.ads.redexgen.X;

import android.R;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.support.annotation.Nullable;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: assets/audience_network.dex */
public final class KE {
    public static byte[] A00;
    public static final float A01;
    public static final DisplayMetrics A02;
    public static final int A03;
    public static final int A04;
    public static final ConcurrentHashMap<Integer, Integer> A05;
    public static final AtomicInteger A06;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0030, code lost:            return new java.lang.String(r2);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String A0E(int r2, int r3, int r4) {
        /*
            r0 = 0
            r0 = 0
            byte[] r1 = com.facebook.ads.redexgen.X.KE.A00
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
            int r0 = r0 + (-23)
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0E(int, int, int):java.lang.String");
    }

    public static void A0F() {
        A00 = new byte[]{-28, -46, -33, -28, -98, -28, -42, -29, -38, -41, -98, -34, -42, -43, -38, -26, -34};
    }

    static {
        A0F();
        A04 = C4G.A01(-1, 0);
        A03 = C4G.A01(-16777216, 115);
        A02 = Resources.getSystem().getDisplayMetrics();
        A01 = A02.density;
        A06 = new AtomicInteger(1);
        A05 = new ConcurrentHashMap<>();
    }

    public static int A00() {
        int result;
        int i;
        do {
            result = A06.get();
            i = result + 1;
            if (i > 16777215) {
                i = 1;
            }
        } while (!A06.compareAndSet(result, i));
        return result;
    }

    public static int A01(int i) {
        return (int) TypedValue.applyDimension(2, i, A02);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A02(int r2) {
        /*
            r1 = 0
            boolean r0 = A0b(r2)
            if (r0 == 0) goto L21
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L23;
                case 4: goto L16;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            r1 = -1
            r0 = 1053609165(0x3ecccccd, float:0.4)
            int r1 = com.facebook.ads.redexgen.X.C4G.A02(r2, r1, r0)
            r0 = 3
            goto L8
        L16:
            r1 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = 1045220557(0x3e4ccccd, float:0.2)
            int r1 = com.facebook.ads.redexgen.X.C4G.A02(r2, r1, r0)
            r0 = 3
            goto L8
        L21:
            r0 = 4
            goto L8
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A02(int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A03(@android.support.annotation.Nullable android.content.Context r2) {
        /*
            r1 = 0
            if (r2 != 0) goto L19
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L8;
                case 3: goto L1b;
                case 4: goto Lb;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            r1 = 0
            r0 = 3
            goto L4
        Lb:
            android.content.Context r2 = (android.content.Context) r2
            android.content.res.Resources r0 = r2.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r1 = r0.orientation
            r0 = 3
            goto L4
        L19:
            r0 = 4
            goto L4
        L1b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A03(android.content.Context):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0046, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A04(android.widget.TextView r6) {
        /*
            r5 = 0
            r4 = 0
            r0 = 0
            r2 = 0
            if (r6 == 0) goto L44
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L46;
                case 4: goto L17;
                case 5: goto L27;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            android.widget.TextView r6 = (android.widget.TextView) r6
            android.text.Layout r0 = r6.getLayout()
            if (r0 != 0) goto L15
            r0 = 3
            goto L7
        L15:
            r0 = 4
            goto L7
        L17:
            android.widget.TextView r6 = (android.widget.TextView) r6
            android.text.Layout r4 = r6.getLayout()
            int r5 = r4.getLineCount()
            if (r5 <= 0) goto L25
            r0 = 5
            goto L7
        L25:
            r0 = 3
            goto L7
        L27:
            android.widget.TextView r6 = (android.widget.TextView) r6
            android.text.Layout r4 = (android.text.Layout) r4
            int r0 = r5 + (-1)
            int r0 = r4.getEllipsisCount(r0)
            double r2 = (double) r0
            java.lang.CharSequence r0 = r6.getText()
            int r0 = r0.length()
            double r0 = (double) r0
            double r0 = r0 - r2
            double r2 = r2 / r0
            double r0 = java.lang.Math.ceil(r2)
            int r2 = (int) r0
            r0 = 3
            goto L7
        L44:
            r0 = 3
            goto L7
        L46:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A04(android.widget.TextView):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:            return r2;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A05(android.widget.TextView r4, int r5) {
        /*
            r0 = 0
            r0 = 0
            r0 = 0
            int r3 = A04(r4)
            r2 = 0
            int r1 = r4.getLineHeight()
            r0 = 2
        Ld:
            switch(r0) {
                case 2: goto L11;
                case 3: goto L17;
                case 4: goto L1d;
                case 5: goto L22;
                default: goto L10;
            }
        L10:
            goto Ld
        L11:
            if (r5 <= r1) goto L15
            r0 = 3
            goto Ld
        L15:
            r0 = 5
            goto Ld
        L17:
            if (r2 >= r3) goto L1b
            r0 = 4
            goto Ld
        L1b:
            r0 = 5
            goto Ld
        L1d:
            int r2 = r2 + 1
            int r5 = r5 - r1
            r0 = 2
            goto Ld
        L22:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A05(android.widget.TextView, int):int");
    }

    public static Drawable A06(int i, int i2) {
        return A09(i, A02(i), i2);
    }

    public static Drawable A07(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(i2);
        return gradientDrawable;
    }

    public static Drawable A08(int i, int i2) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, i2);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static Drawable A09(int i, int i2, int i3) {
        return A0A(i, i2, i, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:            return (android.graphics.drawable.Drawable) r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable A0A(int r4, int r5, int r6, int r7) {
        /*
            r3 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r1 < r0) goto L25
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L27;
                case 4: goto L1f;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            android.graphics.drawable.RippleDrawable r3 = new android.graphics.drawable.RippleDrawable
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r5)
            android.graphics.drawable.Drawable r1 = A07(r4, r7)
            android.graphics.drawable.Drawable r0 = A08(r6, r7)
            r3.<init>(r2, r1, r0)
            r0 = 3
            goto L8
        L1f:
            android.graphics.drawable.StateListDrawable r3 = A0B(r4, r5, r7)
            r0 = 3
            goto L8
        L25:
            r0 = 4
            goto L8
        L27:
            java.lang.Object r3 = (java.lang.Object) r3
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0A(int, int, int, int):android.graphics.drawable.Drawable");
    }

    public static StateListDrawable A0B(int i, int i2, int i3) {
        return A0C(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{i2, i}, i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:            return r3;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.StateListDrawable A0C(int[][] r4, int[] r5, int r6) {
        /*
            r0 = 0
            r0 = 0
            android.graphics.drawable.StateListDrawable r3 = new android.graphics.drawable.StateListDrawable
            r3.<init>()
            r2 = 0
            r0 = 2
        L9:
            switch(r0) {
                case 2: goto Ld;
                case 3: goto L16;
                case 4: goto L33;
                default: goto Lc;
            }
        Lc:
            goto L9
        Ld:
            int[][] r4 = (int[][]) r4
            int r0 = r4.length
            if (r2 >= r0) goto L14
            r0 = 3
            goto L9
        L14:
            r0 = 4
            goto L9
        L16:
            int[][] r4 = (int[][]) r4
            int[] r5 = (int[]) r5
            android.graphics.drawable.StateListDrawable r3 = (android.graphics.drawable.StateListDrawable) r3
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            r1.<init>()
            r0 = r5[r2]
            r1.setColor(r0)
            float r0 = (float) r6
            r1.setCornerRadius(r0)
            r0 = r4[r2]
            r3.addState(r0, r1)
            int r2 = r2 + 1
            r0 = 2
            goto L9
        L33:
            android.graphics.drawable.StateListDrawable r3 = (android.graphics.drawable.StateListDrawable) r3
            android.graphics.drawable.StateListDrawable r3 = (android.graphics.drawable.StateListDrawable) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0C(int[][], int[], int):android.graphics.drawable.StateListDrawable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x004a, code lost:            return r3;     */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.widget.TextView A0D(android.view.ViewGroup r4) {
        /*
            r3 = 0
            r2 = 0
            r0 = 0
            r1 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L1b;
                case 4: goto L14;
                case 5: goto L48;
                case 6: goto L9;
                case 7: goto L3a;
                case 8: goto L29;
                case 9: goto L45;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            android.view.View r2 = (android.view.View) r2
            boolean r0 = r2 instanceof android.view.ViewGroup
            if (r0 == 0) goto L11
            r0 = 7
            goto L5
        L11:
            r0 = 8
            goto L5
        L14:
            android.view.View r2 = (android.view.View) r2
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3
            r0 = 5
            goto L5
        L1b:
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            android.view.View r2 = r4.getChildAt(r1)
            boolean r0 = r2 instanceof android.widget.TextView
            if (r0 == 0) goto L27
            r0 = 4
            goto L5
        L27:
            r0 = 6
            goto L5
        L29:
            int r1 = r1 + 1
            r0 = 2
            goto L5
        L2d:
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            int r0 = r4.getChildCount()
            if (r1 >= r0) goto L37
            r0 = 3
            goto L5
        L37:
            r0 = 9
            goto L5
        L3a:
            android.view.View r2 = (android.view.View) r2
            r0 = r2
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            A0D(r0)
            r0 = 8
            goto L5
        L45:
            r3 = 0
            r0 = 5
            goto L5
        L48:
            android.widget.TextView r3 = (android.widget.TextView) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0D(android.view.ViewGroup):android.widget.TextView");
    }

    public static void A0G(int i, float f, View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(i / 2);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(2);
        view.startAnimation(scaleAnimation);
    }

    public static void A0H(int i, View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(i / 3);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration((i / 3) * 2);
        scaleAnimation2.setInterpolator(new BounceInterpolator());
        scaleAnimation.setAnimationListener(new KD(view, scaleAnimation2));
        view.startAnimation(scaleAnimation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0I(int r2, android.view.View r3) {
        /*
            r0 = 0
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> r1 = com.facebook.ads.redexgen.X.KE.A05
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.Object r1 = r1.get(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L28
            r0 = 2
        L10:
            switch(r0) {
                case 2: goto L14;
                case 3: goto L2a;
                case 4: goto L21;
                default: goto L13;
            }
        L13:
            goto L10
        L14:
            android.view.View r3 = (android.view.View) r3
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r0 = r1.intValue()
            r3.setId(r0)
            r0 = 3
            goto L10
        L21:
            android.view.View r3 = (android.view.View) r3
            A0N(r3)
            r0 = 3
            goto L10
        L28:
            r0 = 4
            goto L10
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0I(int, android.view.View):void");
    }

    public static void A0J(@Nullable View view) {
        A0Q(view, 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0K(android.view.View r1) {
        /*
            r0 = 0
            android.view.ViewParent r1 = r1.getParent()
            if (r1 == 0) goto L20
            r0 = 2
        L8:
            switch(r0) {
                case 2: goto Lc;
                case 3: goto L16;
                case 4: goto L22;
                default: goto Lb;
            }
        Lb:
            goto L8
        Lc:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            boolean r0 = r1 instanceof android.view.ViewGroup
            if (r0 == 0) goto L14
            r0 = 3
            goto L8
        L14:
            r0 = 4
            goto L8
        L16:
            android.view.ViewParent r1 = (android.view.ViewParent) r1
            r0 = r1
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            A0U(r0)
            r0 = 4
            goto L8
        L20:
            r0 = 4
            goto L8
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0K(android.view.View):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0021, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0L(@android.support.annotation.Nullable android.view.View r2) {
        /*
            r1 = 0
            if (r2 != 0) goto L1f
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L21;
                case 3: goto L8;
                case 4: goto L16;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            android.view.View r2 = (android.view.View) r2
            android.view.ViewParent r1 = r2.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            if (r1 == 0) goto L14
            r0 = 4
            goto L4
        L14:
            r0 = 2
            goto L4
        L16:
            android.view.View r2 = (android.view.View) r2
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r1.removeView(r2)
            r0 = 2
            goto L4
        L1f:
            r0 = 3
            goto L4
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0L(android.view.View):void");
    }

    public static void A0M(View view) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{A04, A03});
        gradientDrawable.setCornerRadius(0.0f);
        A0T(view, gradientDrawable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0N(android.view.View r2) {
        /*
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 17
            if (r1 < r0) goto L21
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L23;
                case 4: goto L16;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            android.view.View r2 = (android.view.View) r2
            int r0 = android.view.View.generateViewId()
            r2.setId(r0)
            r0 = 3
            goto L7
        L16:
            android.view.View r2 = (android.view.View) r2
            int r0 = A00()
            r2.setId(r0)
            r0 = 3
            goto L7
        L21:
            r0 = 4
            goto L7
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0N(android.view.View):void");
    }

    public static void A0O(@Nullable View view) {
        A0Q(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0P(android.view.View r2, int r3) {
        /*
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r1 < r0) goto L23
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L25;
                case 4: goto L17;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            android.view.View r2 = (android.view.View) r2
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            r0.<init>(r3)
            r2.setBackground(r0)
            r0 = 3
            goto L7
        L17:
            android.view.View r2 = (android.view.View) r2
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            r0.<init>(r3)
            r2.setBackgroundDrawable(r0)
            r0 = 3
            goto L7
        L23:
            r0 = 4
            goto L7
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0P(android.view.View, int):void");
    }

    public static void A0Q(@Nullable View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public static void A0R(View view, int i, int i2) {
        A0T(view, A09(i, A02(i), i2));
    }

    public static void A0S(View view, int i, int i2, int i3) {
        A0T(view, A0A(i, A02(i), i2, i3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001f, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0T(android.view.View r2, android.graphics.drawable.Drawable r3) {
        /*
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r1 < r0) goto L1d
            r0 = 2
        L7:
            switch(r0) {
                case 2: goto Lb;
                case 3: goto L1f;
                case 4: goto L14;
                default: goto La;
            }
        La:
            goto L7
        Lb:
            android.view.View r2 = (android.view.View) r2
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
            r2.setBackground(r3)
            r0 = 3
            goto L7
        L14:
            android.view.View r2 = (android.view.View) r2
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
            r2.setBackgroundDrawable(r3)
            r0 = 3
            goto L7
        L1d:
            r0 = 4
            goto L7
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0T(android.view.View, android.graphics.drawable.Drawable):void");
    }

    public static void A0U(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT > 19) {
            A0V(viewGroup, 200);
        }
    }

    public static void A0V(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT > 19) {
            A0X(viewGroup, new AutoTransition(), i);
        }
    }

    public static void A0W(ViewGroup viewGroup, Transition transition) {
        if (Build.VERSION.SDK_INT > 19) {
            A0X(viewGroup, transition, 200);
        }
    }

    @TargetApi(19)
    public static void A0X(ViewGroup viewGroup, Transition transition, int i) {
        transition.setDuration(i);
        transition.setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.beginDelayedTransition(viewGroup, transition);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:            r4 = r4;        r4.setTypeface(r2);        r4.setTextSize(2, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0Y(android.widget.TextView r4, boolean r5, int r6) {
        /*
            r2 = 0
            r0 = 0
            r0 = 0
            if (r5 == 0) goto L36
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L14;
                case 4: goto L38;
                case 5: goto L24;
                case 6: goto L2d;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            int r1 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r1 < r0) goto L12
            r0 = 3
            goto L6
        L12:
            r0 = 5
            goto L6
        L14:
            r3 = 0
            r2 = 0
            r1 = 17
            r0 = 90
            java.lang.String r0 = A0E(r2, r1, r0)
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r0, r3)
            r0 = 4
            goto L6
        L24:
            android.graphics.Typeface r1 = android.graphics.Typeface.SANS_SERIF
            r0 = 1
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r1, r0)
            r0 = 4
            goto L6
        L2d:
            r1 = 0
            android.graphics.Typeface r0 = android.graphics.Typeface.SANS_SERIF
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r0, r1)
            r0 = 4
            goto L6
        L36:
            r0 = 6
            goto L6
        L38:
            android.widget.TextView r4 = (android.widget.TextView) r4
            android.graphics.Typeface r2 = (android.graphics.Typeface) r2
            r4.setTypeface(r2)
            r1 = 2
            float r0 = (float) r6
            r4.setTextSize(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0Y(android.widget.TextView, boolean, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0Z(@android.support.annotation.Nullable android.widget.Toast r2, java.lang.String r3, int r4, int r5, int r6) {
        /*
            r1 = 0
            if (r2 != 0) goto L2b
            r0 = 2
        L4:
            switch(r0) {
                case 2: goto L2d;
                case 3: goto L8;
                case 4: goto L1d;
                default: goto L7;
            }
        L7:
            goto L4
        L8:
            android.widget.Toast r2 = (android.widget.Toast) r2
            r2.setGravity(r4, r5, r6)
            android.view.View r0 = r2.getView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.widget.TextView r1 = A0D(r0)
            if (r1 == 0) goto L1b
            r0 = 4
            goto L4
        L1b:
            r0 = 2
            goto L4
        L1d:
            java.lang.String r3 = (java.lang.String) r3
            android.widget.TextView r1 = (android.widget.TextView) r1
            r1.setText(r3)
            r0 = 17
            r1.setGravity(r0)
            r0 = 2
            goto L4
        L2b:
            r0 = 3
            goto L4
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0Z(android.widget.Toast, java.lang.String, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001a, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0a(android.view.View... r3) {
        /*
            r0 = 0
            r0 = 0
            int r2 = r3.length
            r1 = 0
            r0 = 2
        L5:
            switch(r0) {
                case 2: goto L9;
                case 3: goto Lf;
                case 4: goto L1a;
                default: goto L8;
            }
        L8:
            goto L5
        L9:
            if (r1 >= r2) goto Ld
            r0 = 3
            goto L5
        Ld:
            r0 = 4
            goto L5
        Lf:
            android.view.View[] r3 = (android.view.View[]) r3
            r0 = r3[r1]
            A0L(r0)
            int r1 = r1 + 1
            r0 = 2
            goto L5
        L1a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0a(android.view.View[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:            return r5;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0b(int r6) {
        /*
            r5 = 0
            double r3 = com.facebook.ads.redexgen.X.C4G.A00(r6)
            r1 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L16
            r0 = 2
        Lc:
            switch(r0) {
                case 2: goto L10;
                case 3: goto L18;
                case 4: goto L13;
                default: goto Lf;
            }
        Lf:
            goto Lc
        L10:
            r5 = 1
            r0 = 3
            goto Lc
        L13:
            r5 = 0
            r0 = 3
            goto Lc
        L16:
            r0 = 4
            goto Lc
        L18:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.KE.A0b(int):boolean");
    }
}
