package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: DataMap.java */
/* loaded from: classes2.dex */
public final class f extends AbstractMap<String, Object> {

    /* renamed from: a */
    final Object f14994a;

    /* renamed from: b */
    final ClassInfo f14995b;

    /* compiled from: DataMap.java */
    /* loaded from: classes2.dex */
    public final class a implements Map.Entry<String, Object> {

        /* renamed from: a */
        private Object f14996a;

        /* renamed from: b */
        private final FieldInfo f14997b;

        a(FieldInfo fieldInfo, Object obj) {
            this.f14997b = fieldInfo;
            Preconditions.a(obj);
            this.f14996a = obj;
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

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f14996a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode() ^ getValue().hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f14996a;
            Preconditions.a(obj);
            this.f14996a = obj;
            this.f14997b.a(f.this.f14994a, obj);
            return obj2;
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            String d2 = this.f14997b.d();
            return f.this.f14995b.b() ? d2.toLowerCase(Locale.US) : d2;
        }
    }

    /* compiled from: DataMap.java */
    /* loaded from: classes2.dex */
    public final class b implements Iterator<Map.Entry<String, Object>> {

        /* renamed from: a */
        private int f14999a = -1;

        /* renamed from: b */
        private FieldInfo f15000b;

        /* renamed from: c */
        private Object f15001c;

        /* renamed from: d */
        private boolean f15002d;

        /* renamed from: e */
        private boolean f15003e;

        /* renamed from: f */
        private FieldInfo f15004f;

        b() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f15003e) {
                this.f15003e = true;
                this.f15001c = null;
                while (this.f15001c == null) {
                    int i = this.f14999a + 1;
                    this.f14999a = i;
                    if (i >= f.this.f14995b.f14922f.size()) {
                        break;
                    }
                    ClassInfo classInfo = f.this.f14995b;
                    this.f15000b = classInfo.b(classInfo.f14922f.get(this.f14999a));
                    this.f15001c = this.f15000b.a(f.this.f14994a);
                }
            }
            return this.f15001c != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.b((this.f15004f == null || this.f15002d) ? false : true);
            this.f15002d = true;
            this.f15004f.a(f.this.f14994a, (Object) null);
        }

        @Override // java.util.Iterator
        public Map.Entry<String, Object> next() {
            if (hasNext()) {
                this.f15004f = this.f15000b;
                Object obj = this.f15001c;
                this.f15003e = false;
                this.f15002d = false;
                this.f15000b = null;
                this.f15001c = null;
                return new a(this.f15004f, obj);
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: DataMap.java */
    /* loaded from: classes2.dex */
    public final class c extends AbstractSet<Map.Entry<String, Object>> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterator<String> it = f.this.f14995b.f14922f.iterator();
            while (it.hasNext()) {
                f.this.f14995b.b(it.next()).a(f.this.f14994a, (Object) null);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            Iterator<String> it = f.this.f14995b.f14922f.iterator();
            while (it.hasNext()) {
                if (f.this.f14995b.b(it.next()).a(f.this.f14994a) != null) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<String> it = f.this.f14995b.f14922f.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (f.this.f14995b.b(it.next()).a(f.this.f14994a) != null) {
                    i++;
                }
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public b iterator() {
            return new b();
        }
    }

    public f(Object obj, boolean z) {
        this.f14994a = obj;
        this.f14995b = ClassInfo.a(obj.getClass(), z);
        Preconditions.a(!this.f14995b.c());
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public Object put(String str, Object obj) {
        FieldInfo b2 = this.f14995b.b(str);
        Preconditions.a(b2, "no field of key " + str);
        Object a2 = b2.a(this.f14994a);
        Object obj2 = this.f14994a;
        Preconditions.a(obj);
        b2.a(obj2, obj);
        return a2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        FieldInfo b2;
        if ((obj instanceof String) && (b2 = this.f14995b.b((String) obj)) != null) {
            return b2.a(this.f14994a);
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public c entrySet() {
        return new c();
    }
}
