package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
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

    public static void b(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
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

    public static int a(int i, int i2) {
        return a(i, i2, "index");
    }

    public static int a(int i, int i2, @Nullable String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(c(i, i2, str));
        }
        return i;
    }

    private static String c(int i, int i2, String str) {
        if (i < 0) {
            return a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        }
        return a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static int b(int i, int i2) {
        return b(i, i2, "index");
    }

    public static int b(int i, int i2, @Nullable String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(d(i, i2, str));
        }
        return i;
    }

    private static String d(int i, int i2, String str) {
        if (i < 0) {
            return a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        }
        return a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void a(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(b(i, i2, i3));
        }
    }

    private static String b(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return d(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return d(i2, i3, "end index");
        }
        return a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
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
