package com.google.common.math;

import com.google.common.annotations.GwtCompatible;

/* compiled from: MathPreconditions.java */
@GwtCompatible
/* loaded from: classes2.dex */
final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z) {
        if (!z) {
            throw new ArithmeticException("overflow");
        }
    }
}
