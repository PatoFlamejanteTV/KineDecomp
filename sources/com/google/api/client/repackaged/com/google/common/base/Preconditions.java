package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void a(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void a(boolean z, @Nullable String str, @Nullable Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(a(str, objArr));
        }
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void b(boolean z, @Nullable String str, @Nullable Object... objArr) {
        if (!z) {
            throw new IllegalStateException(a(str, objArr));
        }
    }

    public static <T> T a(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    public static <T> T a(T t, @Nullable Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    public static <T> T a(T t, @Nullable String str, @Nullable Object... objArr) {
        if (t == null) {
            throw new NullPointerException(a(str, objArr));
        }
        return t;
    }

    @VisibleForTesting
    static String a(String str, @Nullable Object... objArr) {
        int indexOf;
        int i = 0;
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i2)) != -1) {
            sb.append(valueOf.substring(i2, indexOf));
            sb.append(objArr[i]);
            i2 = indexOf + 2;
            i++;
        }
        sb.append(valueOf.substring(i2));
        if (i < objArr.length) {
            sb.append(" [");
            int i3 = i + 1;
            sb.append(objArr[i]);
            while (true) {
                int i4 = i3;
                if (i4 >= objArr.length) {
                    break;
                }
                sb.append(", ");
                i3 = i4 + 1;
                sb.append(objArr[i4]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
