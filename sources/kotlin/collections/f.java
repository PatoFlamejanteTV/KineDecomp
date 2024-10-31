package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: _ArraysJvm.kt */
/* loaded from: classes3.dex */
public class f extends e {
    public static <T> List<T> a(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "$this$asList");
        List<T> a2 = h.a(tArr);
        kotlin.jvm.internal.h.a((Object) a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }

    public static final <T> void a(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.h.b(tArr, "$this$sortWith");
        kotlin.jvm.internal.h.b(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
