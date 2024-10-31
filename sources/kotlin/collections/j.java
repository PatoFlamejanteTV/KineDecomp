package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: CollectionsJVM.kt */
/* loaded from: classes3.dex */
public class j {
    public static <T> List<T> a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.h.a((Object) singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final <T> Object[] a(T[] tArr, boolean z) {
        kotlin.jvm.internal.h.b(tArr, "$this$copyToArrayOfAny");
        if (z && kotlin.jvm.internal.h.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.h.a((Object) copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }
}
