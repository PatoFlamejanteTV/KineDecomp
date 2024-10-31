package d.a;

import java.util.Collections;
import java.util.Map;

/* compiled from: MapBuilder.java */
/* loaded from: classes3.dex */
public final class e<K, V> {

    /* renamed from: a */
    private final Map<K, V> f26667a;

    private e(int i) {
        this.f26667a = a.a(i);
    }

    public static <K, V> e<K, V> a(int i) {
        return new e<>(i);
    }

    public e<K, V> a(K k, V v) {
        this.f26667a.put(k, v);
        return this;
    }

    public Map<K, V> a() {
        if (this.f26667a.size() != 0) {
            return Collections.unmodifiableMap(this.f26667a);
        }
        return Collections.emptyMap();
    }
}
