package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Collections.kt */
/* loaded from: classes3.dex */
public class k extends j {
    public static <T> List<T> a() {
        return EmptyList.INSTANCE;
    }

    public static final <T> Collection<T> b(T[] tArr) {
        kotlin.jvm.internal.h.b(tArr, "$this$asCollection");
        return new b(tArr, false);
    }

    public static <T> ArrayList<T> a(T... tArr) {
        kotlin.jvm.internal.h.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new b(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> b(List<? extends T> list) {
        List<T> a2;
        List<T> a3;
        kotlin.jvm.internal.h.b(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            a2 = a();
            return a2;
        }
        if (size != 1) {
            return list;
        }
        a3 = j.a(list.get(0));
        return a3;
    }

    public static kotlin.c.d a(Collection<?> collection) {
        kotlin.jvm.internal.h.b(collection, "$this$indices");
        return new kotlin.c.d(0, collection.size() - 1);
    }

    public static <T> int a(List<? extends T> list) {
        kotlin.jvm.internal.h.b(list, "$this$lastIndex");
        return list.size() - 1;
    }
}
