package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

/* compiled from: MathPreconditions.java */
@CanIgnoreReturnValue
@GwtCompatible
/* loaded from: classes2.dex */
final class e {
    public static int a(@Nullable String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    public static void b(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new ArithmeticException("overflow");
        }
    }
}
