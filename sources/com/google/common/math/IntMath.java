package com.google.common.math;

import com.facebook.internal.NativeProtocol;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.math.RoundingMode;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class IntMath {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    static final byte[] f2919a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    @VisibleForTesting
    static final int[] b = {1, 10, 100, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, 10000, NexVideoClipItem.ABSTRACT_DIMENSION, 1000000, 10000000, 100000000, 1000000000};

    @VisibleForTesting
    static final int[] c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    static final int[] d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    @VisibleForTesting
    static int[] e = {Integer.MAX_VALUE, Integer.MAX_VALUE, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2920a = new int[RoundingMode.values().length];

        static {
            try {
                f2920a[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2920a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2920a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2920a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2920a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2920a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2920a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2920a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0060, code lost:            if ((((r2 & 1) != 0) & (r9 == java.math.RoundingMode.HALF_EVEN)) != false) goto L36;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0026. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(int r7, int r8, java.math.RoundingMode r9) {
        /*
            r0 = 1
            r1 = 0
            com.google.common.base.Preconditions.a(r9)
            if (r8 != 0) goto Lf
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "/ by zero"
            r0.<init>(r1)
            throw r0
        Lf:
            int r2 = r7 / r8
            int r3 = r8 * r2
            int r3 = r7 - r3
            if (r3 != 0) goto L18
        L17:
            return r2
        L18:
            r4 = r7 ^ r8
            int r4 = r4 >> 31
            r5 = r4 | 1
            int[] r4 = com.google.common.math.IntMath.AnonymousClass1.f2920a
            int r6 = r9.ordinal()
            r4 = r4[r6]
            switch(r4) {
                case 1: goto L2f;
                case 2: goto L34;
                case 3: goto L41;
                case 4: goto L35;
                case 5: goto L3d;
                case 6: goto L45;
                case 7: goto L45;
                case 8: goto L45;
                default: goto L29;
            }
        L29:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L2f:
            if (r3 != 0) goto L3b
        L31:
            com.google.common.math.a.a(r0)
        L34:
            r0 = r1
        L35:
            if (r0 == 0) goto L6d
            int r0 = r2 + r5
        L39:
            r2 = r0
            goto L17
        L3b:
            r0 = r1
            goto L31
        L3d:
            if (r5 > 0) goto L35
            r0 = r1
            goto L35
        L41:
            if (r5 < 0) goto L35
            r0 = r1
            goto L35
        L45:
            int r3 = java.lang.Math.abs(r3)
            int r4 = java.lang.Math.abs(r8)
            int r4 = r4 - r3
            int r3 = r3 - r4
            if (r3 != 0) goto L69
            java.math.RoundingMode r3 = java.math.RoundingMode.HALF_UP
            if (r9 == r3) goto L62
            java.math.RoundingMode r3 = java.math.RoundingMode.HALF_EVEN
            if (r9 != r3) goto L65
            r4 = r0
        L5a:
            r3 = r2 & 1
            if (r3 == 0) goto L67
            r3 = r0
        L5f:
            r3 = r3 & r4
            if (r3 == 0) goto L63
        L62:
            r1 = r0
        L63:
            r0 = r1
            goto L35
        L65:
            r4 = r1
            goto L5a
        L67:
            r3 = r1
            goto L5f
        L69:
            if (r3 > 0) goto L35
            r0 = r1
            goto L35
        L6d:
            r0 = r2
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.a(int, int, java.math.RoundingMode):int");
    }

    public static int a(int i, int i2) {
        long j = i2 + i;
        a.b(j == ((long) ((int) j)));
        return (int) j;
    }

    public static int b(int i, int i2) {
        long j = i2 * i;
        a.b(j == ((long) ((int) j)));
        return (int) j;
    }

    private IntMath() {
    }
}
