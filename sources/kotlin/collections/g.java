package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
public class g extends f {
    public static final <T> boolean a(T[] tArr, T t) {
        int b2;
        kotlin.jvm.internal.h.b(tArr, "$this$contains");
        b2 = b(tArr, t);
        return b2 >= 0;
    }

    public static <T> int b(T[] tArr, T t) {
        kotlin.jvm.internal.h.b(tArr, "$this$indexOf");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (kotlin.jvm.internal.h.a(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static <T> List<T> c(T[] tArr, Comparator<? super T> comparator) {
        List<T> a2;
        kotlin.jvm.internal.h.b(tArr, "$this$sortedWith");
        kotlin.jvm.internal.h.b(comparator, "comparator");
        a2 = f.a(b((Object[]) tArr, (Comparator) comparator));
        return a2;
    }

    public static char a(char[] cArr) {
        kotlin.jvm.internal.h.b(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> List<T> c(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "$this$toMutableList");
        return new ArrayList(k.b(tArr));
    }

    public static <T> T b(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] b(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.h.b(tArr, "$this$sortedArrayWith");
        kotlin.jvm.internal.h.b(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.h.a((Object) tArr2, "java.util.Arrays.copyOf(this, size)");
        f.a(tArr2, comparator);
        return tArr2;
    }
}
