package io.reactivex.internal.util;

/* compiled from: Pow2.java */
/* loaded from: classes3.dex */
public final class f {
    public static int a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
