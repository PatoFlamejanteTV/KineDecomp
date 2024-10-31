package kotlin.collections;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.share.internal.ShareConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;

/* compiled from: Maps.kt */
/* loaded from: classes3.dex */
public class z extends y {
    public static final <K, V> Map<K, V> a() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (emptyMap != null) {
            return emptyMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static <K, V> Map<K, V> a(Pair<? extends K, ? extends V>... pairArr) {
        int a2;
        kotlin.jvm.internal.h.b(pairArr, "pairs");
        if (pairArr.length <= 0) {
            return a();
        }
        a2 = a(pairArr.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(a2);
        a(pairArr, linkedHashMap);
        return linkedHashMap;
    }

    public static int a(int i) {
        return i < 3 ? i + 1 : i < 1073741824 ? i + (i / 3) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public static final <K, V> void a(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        kotlin.jvm.internal.h.b(map, "$this$putAll");
        kotlin.jvm.internal.h.b(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M a(Pair<? extends K, ? extends V>[] pairArr, M m) {
        kotlin.jvm.internal.h.b(pairArr, "$this$toMap");
        kotlin.jvm.internal.h.b(m, ShareConstants.DESTINATION);
        a(m, pairArr);
        return m;
    }
}
