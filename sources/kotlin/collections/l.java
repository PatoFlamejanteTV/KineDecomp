package kotlin.collections;

import java.util.Collection;

/* compiled from: Iterables.kt */
/* loaded from: classes3.dex */
public class l extends k {
    public static <T> int a(Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.h.b(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
