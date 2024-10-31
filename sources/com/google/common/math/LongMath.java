package com.google.common.math;

import android.support.v7.widget.ActivityChooserView;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.umeng.commonsdk.proguard.ap;

/* loaded from: classes2.dex */
public final class LongMath {

    /* renamed from: a */
    @VisibleForTesting
    static final byte[] f15993a = {19, 18, 18, 18, 18, 17, 17, 17, ap.n, ap.n, ap.n, ap.m, ap.m, ap.m, ap.m, ap.l, ap.l, ap.l, ap.k, ap.k, ap.k, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* renamed from: b */
    @VisibleForTesting
    @GwtIncompatible
    static final long[] f15994b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* renamed from: c */
    @VisibleForTesting
    @GwtIncompatible
    static final long[] f15995c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* renamed from: d */
    static final long[] f15996d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* renamed from: e */
    static final int[] f15997e = {ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* renamed from: f */
    @VisibleForTesting
    static final int[] f15998f = {ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* renamed from: g */
    private static final long[][] f15999g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    private LongMath() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:            if (r2 > 0) goto L78;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:            if (r9 > 0) goto L78;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:            if (r9 < 0) goto L78;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long a(long r8, long r10, java.math.RoundingMode r12) {
        /*
            com.google.common.base.Preconditions.a(r12)
            long r0 = r8 / r10
            long r2 = r10 * r0
            long r2 = r8 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            return r0
        L10:
            long r8 = r8 ^ r10
            r6 = 63
            long r8 = r8 >> r6
            int r9 = (int) r8
            r8 = 1
            r9 = r9 | r8
            int[] r6 = com.google.common.math.d.f16010a
            int r7 = r12.ordinal()
            r6 = r6[r7]
            r7 = 0
            switch(r6) {
                case 1: goto L5c;
                case 2: goto L65;
                case 3: goto L59;
                case 4: goto L66;
                case 5: goto L56;
                case 6: goto L29;
                case 7: goto L29;
                case 8: goto L29;
                default: goto L23;
            }
        L23:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L29:
            long r2 = java.lang.Math.abs(r2)
            long r10 = java.lang.Math.abs(r10)
            long r10 = r10 - r2
            long r2 = r2 - r10
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L51
            java.math.RoundingMode r10 = java.math.RoundingMode.HALF_UP
            if (r12 != r10) goto L3d
            r10 = 1
            goto L3e
        L3d:
            r10 = 0
        L3e:
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r11) goto L44
            r11 = 1
            goto L45
        L44:
            r11 = 0
        L45:
            r2 = 1
            long r2 = r2 & r0
            int r12 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r12 == 0) goto L4d
            goto L4e
        L4d:
            r8 = 0
        L4e:
            r8 = r8 & r11
            r8 = r8 | r10
            goto L66
        L51:
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 <= 0) goto L65
            goto L66
        L56:
            if (r9 <= 0) goto L65
            goto L66
        L59:
            if (r9 >= 0) goto L65
            goto L66
        L5c:
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 != 0) goto L61
            goto L62
        L61:
            r8 = 0
        L62:
            com.google.common.math.e.b(r8)
        L65:
            r8 = 0
        L66:
            if (r8 == 0) goto L6a
            long r8 = (long) r9
            long r0 = r0 + r8
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.a(long, long, java.math.RoundingMode):long");
    }

    @GwtIncompatible
    public static long a(long j, long j2) {
        long j3 = j + j2;
        e.a(((j2 ^ j) < 0) | ((j ^ j3) >= 0));
        return j3;
    }
}
