package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
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

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    private static String c(int i, int i2, String str) {
        if (i < 0) {
            return a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    private static String d(int i, int i2, String str) {
        if (i < 0) {
            return a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    public static void a(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void b(boolean z, @Nullable Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void a(boolean z, @Nullable String str, @Nullable Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(a(str, objArr));
        }
    }

    public static void b(boolean z, @Nullable String str, @Nullable Object... objArr) {
        if (!z) {
            throw new IllegalStateException(a(str, objArr));
        }
    }

    public static void a(boolean z, @Nullable String str, char c2) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Character.valueOf(c2)));
        }
    }

    public static void b(boolean z, @Nullable String str, int i) {
        if (!z) {
            throw new IllegalStateException(a(str, Integer.valueOf(i)));
        }
    }

    public static void a(boolean z, @Nullable String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Integer.valueOf(i)));
        }
    }

    public static void b(boolean z, @Nullable String str, long j) {
        if (!z) {
            throw new IllegalStateException(a(str, Long.valueOf(j)));
        }
    }

    public static void a(boolean z, @Nullable String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Long.valueOf(j)));
        }
    }

    public static void b(boolean z, @Nullable String str, @Nullable Object obj) {
        if (!z) {
            throw new IllegalStateException(a(str, obj));
        }
    }

    public static void a(boolean z, @Nullable String str, @Nullable Object obj) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj));
        }
    }

    @CanIgnoreReturnValue
    public static int b(int i, int i2) {
        b(i, i2, "index");
        return i;
    }

    public static void a(boolean z, @Nullable String str, char c2, @Nullable Object obj) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Character.valueOf(c2), obj));
        }
    }

    @CanIgnoreReturnValue
    public static int b(int i, int i2, @Nullable String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(d(i, i2, str));
        }
        return i;
    }

    public static void a(boolean z, @Nullable String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    private static String b(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return d(i, i3, "start index");
        }
        return (i2 < 0 || i2 > i3) ? d(i2, i3, "end index") : a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static void a(boolean z, @Nullable String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void a(boolean z, @Nullable String str, long j, @Nullable Object obj) {
        if (!z) {
            throw new IllegalArgumentException(a(str, Long.valueOf(j), obj));
        }
    }

    public static void a(boolean z, @Nullable String str, @Nullable Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj, Integer.valueOf(i)));
        }
    }

    public static void a(boolean z, @Nullable String str, @Nullable Object obj, @Nullable Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(a(str, obj, obj2));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    @CanIgnoreReturnValue
    public static <T> T a(T t, @Nullable Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static <T> T a(T t, @Nullable String str, @Nullable Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, objArr));
    }

    @CanIgnoreReturnValue
    public static <T> T a(T t, @Nullable String str, @Nullable Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, obj));
    }

    @CanIgnoreReturnValue
    public static <T> T a(T t, @Nullable String str, @Nullable Object obj, @Nullable Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(a(str, obj, obj2));
    }

    @CanIgnoreReturnValue
    public static int a(int i, int i2) {
        a(i, i2, "index");
        return i;
    }

    @CanIgnoreReturnValue
    public static int a(int i, int i2, @Nullable String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(c(i, i2, str));
        }
        return i;
    }

    public static void a(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(b(i, i2, i3));
        }
    }

    public static String a(String str, @Nullable Object... objArr) {
        int indexOf;
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i = 0;
        int i2 = 0;
        while (i < objArr.length && (indexOf = valueOf.indexOf("%s", i2)) != -1) {
            sb.append((CharSequence) valueOf, i2, indexOf);
            sb.append(objArr[i]);
            i2 = indexOf + 2;
            i++;
        }
        sb.append((CharSequence) valueOf, i2, valueOf.length());
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i3 = i + 1; i3 < objArr.length; i3++) {
                sb.append(", ");
                sb.append(objArr[i3]);
            }
            sb.append(']');
        }
        return sb.toString();
    }
}
