package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class LazyField extends LazyFieldLite {

    /* renamed from: f */
    private final MessageLite f18634f;

    /* loaded from: classes2.dex */
    public static class a<K> implements Map.Entry<K, Object> {

        /* renamed from: a */
        private Map.Entry<K, LazyField> f18635a;

        /* synthetic */ a(Map.Entry entry, F f2) {
            this(entry);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f18635a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField value = this.f18635a.getValue();
            if (value == null) {
                return null;
            }
            return value.c();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.f18635a.getValue().c((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private a(Map.Entry<K, LazyField> entry) {
            this.f18635a = entry;
        }
    }

    /* loaded from: classes2.dex */
    public static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a */
        private Iterator<Map.Entry<K, Object>> f18636a;

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.f18636a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18636a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f18636a.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f18636a.next();
            return next.getValue() instanceof LazyField ? new a(next) : next;
        }
    }

    public MessageLite c() {
        return b(this.f18634f);
    }

    @Override // com.google.protobuf.LazyFieldLite
    public boolean equals(Object obj) {
        return c().equals(obj);
    }

    @Override // com.google.protobuf.LazyFieldLite
    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString();
    }
}
