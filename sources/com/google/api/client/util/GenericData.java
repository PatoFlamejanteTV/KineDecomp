package com.google.api.client.util;

import com.google.api.client.util.f;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class GenericData extends AbstractMap<String, Object> implements Cloneable {
    final ClassInfo classInfo;
    Map<String, Object> unknownFields;

    /* loaded from: classes2.dex */
    public enum Flags {
        IGNORE_CASE
    }

    /* loaded from: classes2.dex */
    final class a implements Iterator<Map.Entry<String, Object>> {

        /* renamed from: a */
        private boolean f14952a;

        /* renamed from: b */
        private final Iterator<Map.Entry<String, Object>> f14953b;

        /* renamed from: c */
        private final Iterator<Map.Entry<String, Object>> f14954c;

        a(f.c cVar) {
            this.f14953b = cVar.iterator();
            this.f14954c = GenericData.this.unknownFields.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14953b.hasNext() || this.f14954c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f14952a) {
                this.f14954c.remove();
            }
            this.f14953b.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<String, Object> next() {
            if (!this.f14952a) {
                if (this.f14953b.hasNext()) {
                    return this.f14953b.next();
                }
                this.f14952a = true;
            }
            return this.f14954c.next();
        }
    }

    /* loaded from: classes2.dex */
    public final class b extends AbstractSet<Map.Entry<String, Object>> {

        /* renamed from: a */
        private final f.c f14956a;

        b() {
            this.f14956a = new f(GenericData.this, GenericData.this.classInfo.b()).entrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            GenericData.this.unknownFields.clear();
            this.f14956a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<String, Object>> iterator() {
            return new a(this.f14956a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return GenericData.this.unknownFields.size() + this.f14956a.size();
        }
    }

    public GenericData() {
        this(EnumSet.noneOf(Flags.class));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return new b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        FieldInfo b2 = this.classInfo.b(str);
        if (b2 != null) {
            return b2.a(this);
        }
        if (this.classInfo.b()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.unknownFields.get(str);
    }

    public final ClassInfo getClassInfo() {
        return this.classInfo;
    }

    public final Map<String, Object> getUnknownKeys() {
        return this.unknownFields;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends String, ?> map) {
        for (Map.Entry<? extends String, ?> entry : map.entrySet()) {
            set(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (this.classInfo.b(str) == null) {
            if (this.classInfo.b()) {
                str = str.toLowerCase(Locale.US);
            }
            return this.unknownFields.remove(str);
        }
        throw new UnsupportedOperationException();
    }

    public GenericData set(String str, Object obj) {
        FieldInfo b2 = this.classInfo.b(str);
        if (b2 != null) {
            b2.a(this, obj);
        } else {
            if (this.classInfo.b()) {
                str = str.toLowerCase(Locale.US);
            }
            this.unknownFields.put(str, obj);
        }
        return this;
    }

    public final void setUnknownKeys(Map<String, Object> map) {
        this.unknownFields = map;
    }

    public GenericData(EnumSet<Flags> enumSet) {
        this.unknownFields = ArrayMap.a();
        this.classInfo = ClassInfo.a(getClass(), enumSet.contains(Flags.IGNORE_CASE));
    }

    @Override // java.util.AbstractMap
    public GenericData clone() {
        try {
            GenericData genericData = (GenericData) super.clone();
            Data.a(this, genericData);
            genericData.unknownFields = (Map) Data.a(this.unknownFields);
            return genericData;
        } catch (CloneNotSupportedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(String str, Object obj) {
        FieldInfo b2 = this.classInfo.b(str);
        if (b2 != null) {
            Object a2 = b2.a(this);
            b2.a(this, obj);
            return a2;
        }
        if (this.classInfo.b()) {
            str = str.toLowerCase(Locale.US);
        }
        return this.unknownFields.put(str, obj);
    }
}
