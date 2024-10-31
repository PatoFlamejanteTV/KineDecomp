package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: MutableCollections.kt */
/* loaded from: classes3.dex */
public class p extends o {
    public static <T> boolean a(Collection<? super T> collection, T[] tArr) {
        List a2;
        kotlin.jvm.internal.h.b(collection, "$this$addAll");
        kotlin.jvm.internal.h.b(tArr, MessengerShareContentUtility.ELEMENTS);
        a2 = f.a(tArr);
        return collection.addAll(a2);
    }

    public static <T> boolean a(Iterable<? extends T> iterable, kotlin.jvm.a.b<? super T, Boolean> bVar) {
        kotlin.jvm.internal.h.b(iterable, "$this$retainAll");
        kotlin.jvm.internal.h.b(bVar, "predicate");
        return a(iterable, bVar, false);
    }

    private static final <T> boolean a(Iterable<? extends T> iterable, kotlin.jvm.a.b<? super T, Boolean> bVar, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (bVar.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }
}
