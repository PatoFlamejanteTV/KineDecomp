package io.grpc;

/* compiled from: PersistentHashArrayMappedTrie.java */
/* loaded from: classes3.dex */
final class X<K, V> {

    /* renamed from: a */
    private final a<K, V> f27142a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PersistentHashArrayMappedTrie.java */
    /* loaded from: classes3.dex */
    public interface a<K, V> {
        V a(K k, int i, int i2);
    }

    public X() {
        this(null);
    }

    public V a(K k) {
        a<K, V> aVar = this.f27142a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(k, k.hashCode(), 0);
    }

    private X(a<K, V> aVar) {
        this.f27142a = aVar;
    }
}
