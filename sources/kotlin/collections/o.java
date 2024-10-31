package kotlin.collections;

import java.util.Collections;
import java.util.List;

/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes3.dex */
public class o extends n {
    public static <T extends Comparable<? super T>> void c(List<T> list) {
        kotlin.jvm.internal.h.b(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
