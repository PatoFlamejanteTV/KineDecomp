package com.google.android.gms.common.internal;

/* loaded from: classes.dex */
public final class zzb {
    public static void a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
