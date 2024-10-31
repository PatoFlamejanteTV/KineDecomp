package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataMap.java */
/* loaded from: classes.dex */
public final class f extends AbstractMap<String, Object> {

    /* renamed from: a, reason: collision with root package name */
    final Object f2554a;
    final ClassInfo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Object obj, boolean z) {
        this.f2554a = obj;
        this.b = ClassInfo.a(obj.getClass(), z);
        Preconditions.a(!this.b.b());
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c entrySet() {
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        FieldInfo a2;
        if ((obj instanceof String) && (a2 = this.b.a((String) obj)) != null) {
            return a2.a(this.f2554a);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        FieldInfo a2 = this.b.a(str);
        String valueOf = String.valueOf(str);
        Preconditions.a(a2, valueOf.length() != 0 ? "no field of key ".concat(valueOf) : new String("no field of key "));
        Object a3 = a2.a(this.f2554a);
        a2.a(this.f2554a, Preconditions.a(obj));
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataMap.java */
    /* loaded from: classes.dex */
    public final class c extends AbstractSet<Map.Entry<String, Object>> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b iterator() {
            return new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i = 0;
            Iterator<String> it = f.this.b.f2531a.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    i = f.this.b.a(it.next()).a(f.this.f2554a) != null ? i2 + 1 : i2;
                } else {
                    return i2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterator<String> it = f.this.b.f2531a.iterator();
            while (it.hasNext()) {
                f.this.b.a(it.next()).a(f.this.f2554a, (Object) null);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            Iterator<String> it = f.this.b.f2531a.iterator();
            while (it.hasNext()) {
                if (f.this.b.a(it.next()).a(f.this.f2554a) != null) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataMap.java */
    /* loaded from: classes.dex */
    public final class b implements Iterator<Map.Entry<String, Object>> {
        private int b = -1;
        private FieldInfo c;
        private Object d;
        private boolean e;
        private boolean f;
        private FieldInfo g;

        b() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f) {
                this.f = true;
                this.d = null;
                while (this.d == null) {
                    int i = this.b + 1;
                    this.b = i;
                    if (i >= f.this.b.f2531a.size()) {
                        break;
                    }
                    this.c = f.this.b.a(f.this.b.f2531a.get(this.b));
                    this.d = this.c.a(f.this.f2554a);
                }
            }
            return this.d != null;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<String, Object> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.g = this.c;
            Object obj = this.d;
            this.f = false;
            this.e = false;
            this.c = null;
            this.d = null;
            return new a(this.g, obj);
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.b((this.g == null || this.e) ? false : true);
            this.e = true;
            this.g.a(f.this.f2554a, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DataMap.java */
    /* loaded from: classes.dex */
    public final class a implements Map.Entry<String, Object> {
        private Object b;
        private final FieldInfo c;

        a(FieldInfo fieldInfo, Object obj) {
            this.c = fieldInfo;
            this.b = Preconditions.a(obj);
        }

        @Override // java.util.Map.Entry
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getKey() {
            String b = this.c.b();
            if (f.this.b.a()) {
                return b.toLowerCase();
            }
            return b;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.b;
            this.b = Preconditions.a(obj);
            this.c.a(f.this.f2554a, obj);
            return obj2;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return getKey().equals(entry.getKey()) && getValue().equals(entry.getValue());
        }
    }
}
