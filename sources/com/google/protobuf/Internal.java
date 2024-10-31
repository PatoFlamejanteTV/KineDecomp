package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes2.dex */
public final class Internal {

    /* renamed from: a */
    static final Charset f18617a = Charset.forName("UTF-8");

    /* renamed from: b */
    static final Charset f18618b = Charset.forName("ISO-8859-1");

    /* renamed from: c */
    public static final byte[] f18619c = new byte[0];

    /* renamed from: d */
    public static final ByteBuffer f18620d = ByteBuffer.wrap(f18619c);

    /* renamed from: e */
    public static final CodedInputStream f18621e = CodedInputStream.a(f18619c);

    /* loaded from: classes2.dex */
    public interface BooleanList extends ProtobufList<Boolean> {
    }

    /* loaded from: classes2.dex */
    public interface DoubleList extends ProtobufList<Double> {
        void a(double d2);

        double getDouble(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.IntList
        /* renamed from: h */
        ProtobufList<Double> h2(int i);
    }

    /* loaded from: classes2.dex */
    public interface EnumLite {
        int getNumber();
    }

    /* loaded from: classes2.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T a(int i);
    }

    /* loaded from: classes2.dex */
    public interface FloatList extends ProtobufList<Float> {
    }

    /* loaded from: classes2.dex */
    public interface IntList extends ProtobufList<Integer> {
        int getInt(int i);

        @Override // 
        /* renamed from: h */
        ProtobufList<Integer> h2(int i);

        void i(int i);
    }

    /* loaded from: classes2.dex */
    public static class ListAdapter<F, T> extends AbstractList<T> {

        /* renamed from: a */
        private final List<F> f18622a;

        /* renamed from: b */
        private final Converter<F, T> f18623b;

        /* loaded from: classes2.dex */
        public interface Converter<F, T> {
            T a(F f2);
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return (T) this.f18623b.a(this.f18622a.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f18622a.size();
        }
    }

    /* loaded from: classes2.dex */
    public interface LongList extends ProtobufList<Long> {
        void g(long j);

        long getLong(int i);

        @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.IntList
        /* renamed from: h */
        ProtobufList<Long> h2(int i);
    }

    /* loaded from: classes2.dex */
    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {

        /* renamed from: a */
        private final Map<K, RealValue> f18624a;

        /* renamed from: b */
        private final Converter<RealValue, V> f18625b;

        /* loaded from: classes2.dex */
        public interface Converter<A, B> {
            B a(A a2);

            A b(B b2);
        }

        /* loaded from: classes2.dex */
        public class a implements Map.Entry<K, V> {

            /* renamed from: a */
            private final Map.Entry<K, RealValue> f18626a;

            public a(Map.Entry<K, RealValue> entry) {
                this.f18626a = entry;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.f18626a.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return (V) MapAdapter.this.f18625b.a(this.f18626a.getValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Map.Entry
            public V setValue(V v) {
                Object value = this.f18626a.setValue(MapAdapter.this.f18625b.b(v));
                if (value == null) {
                    return null;
                }
                return (V) MapAdapter.this.f18625b.a(value);
            }
        }

        /* loaded from: classes2.dex */
        private class b implements Iterator<Map.Entry<K, V>> {

            /* renamed from: a */
            private final Iterator<Map.Entry<K, RealValue>> f18628a;

            public b(Iterator<Map.Entry<K, RealValue>> it) {
                this.f18628a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f18628a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f18628a.remove();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return new a(this.f18628a.next());
            }
        }

        /* loaded from: classes2.dex */
        private class c extends AbstractSet<Map.Entry<K, V>> {

            /* renamed from: a */
            private final Set<Map.Entry<K, RealValue>> f18630a;

            public c(Set<Map.Entry<K, RealValue>> set) {
                this.f18630a = set;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new b(this.f18630a.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f18630a.size();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new c(this.f18624a.entrySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            RealValue realvalue = this.f18624a.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.f18625b.a(realvalue);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Object put = this.f18624a.put(k, this.f18625b.b(v));
            if (put == null) {
                return null;
            }
            return (V) this.f18625b.a(put);
        }
    }

    /* loaded from: classes2.dex */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        void L();

        boolean M();

        /* renamed from: h */
        ProtobufList<E> h2(int i);
    }

    private Internal() {
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static boolean b(byte[] bArr) {
        return Utf8.a(bArr);
    }

    public static String c(byte[] bArr) {
        return new String(bArr, f18617a);
    }

    static int a(byte[] bArr, int i, int i2) {
        int a2 = a(i2, bArr, i, i2);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }

    public static int a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }
}
