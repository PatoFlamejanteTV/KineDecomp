package com.google.common.math;

import android.support.v7.widget.ActivityChooserView;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.primitives.Ints;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.math.RoundingMode;

/* loaded from: classes2.dex */
public final class IntMath {

    /* renamed from: a */
    @VisibleForTesting
    static final byte[] f15980a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* renamed from: b */
    @VisibleForTesting
    static final int[] f15981b = {1, 10, 100, 1000, io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT, NexVideoClipItem.ABSTRACT_DIMENSION, 1000000, 10000000, 100000000, 1000000000};

    /* renamed from: c */
    @VisibleForTesting
    static final int[] f15982c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};

    /* renamed from: d */
    private static final int[] f15983d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* renamed from: e */
    @VisibleForTesting
    static int[] f15984e = {ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    private IntMath() {
    }

    public static int a(int i, RoundingMode roundingMode) {
        e.a(FragmentC2201x.f23219a, i);
        switch (b.f16009a[roundingMode.ordinal()]) {
            case 1:
                e.b(a(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + c((-1257966797) >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static boolean a(int i) {
        return (i > 0) & ((i & (i + (-1))) == 0);
    }

    public static int b(int i, int i2) {
        long j = i * i2;
        int i3 = (int) j;
        e.a(j == ((long) i3));
        return i3;
    }

    @VisibleForTesting
    static int c(int i, int i2) {
        return (((i - i2) ^ (-1)) ^ (-1)) >>> 31;
    }

    @Beta
    public static int d(int i, int i2) {
        return Ints.b(i + i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:            if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:            if (r1 > 0) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:            if (r5 > 0) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:            if (r5 < 0) goto L80;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x001c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(int r5, int r6, java.math.RoundingMode r7) {
        /*
            com.google.common.base.Preconditions.a(r7)
            if (r6 == 0) goto L5c
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto Le
            return r0
        Le:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.common.math.b.f16009a
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L50;
                case 2: goto L57;
                case 3: goto L4d;
                case 4: goto L58;
                case 5: goto L4a;
                case 6: goto L25;
                case 7: goto L25;
                case 8: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L25:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L47
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L58
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L3b
            r6 = 1
            goto L3c
        L3b:
            r6 = 0
        L3c:
            r7 = r0 & 1
            if (r7 == 0) goto L42
            r7 = 1
            goto L43
        L42:
            r7 = 0
        L43:
            r6 = r6 & r7
            if (r6 == 0) goto L57
            goto L58
        L47:
            if (r1 <= 0) goto L57
            goto L58
        L4a:
            if (r5 <= 0) goto L57
            goto L58
        L4d:
            if (r5 >= 0) goto L57
            goto L58
        L50:
            if (r1 != 0) goto L53
            goto L54
        L53:
            r2 = 0
        L54:
            com.google.common.math.e.b(r2)
        L57:
            r2 = 0
        L58:
            if (r2 == 0) goto L5b
            int r0 = r0 + r5
        L5b:
            return r0
        L5c:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.a(int, int, java.math.RoundingMode):int");
    }

    public static int a(int i, int i2) {
        long j = i + i2;
        int i3 = (int) j;
        e.a(j == ((long) i3));
        return i3;
    }
}
