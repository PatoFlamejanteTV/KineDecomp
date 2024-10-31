package com.google.api.client.util;

import com.google.api.client.util.f;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class GenericData extends AbstractMap<String, Object> implements Cloneable {
    final ClassInfo classInfo;
    Map<String, Object> unknownFields;

    /* loaded from: classes.dex */
    public enum Flags {
        IGNORE_CASE
    }

    public GenericData() {
        this(EnumSet.noneOf(Flags.class));
    }

    public GenericData(EnumSet<Flags> enumSet) {
        this.unknownFields = ArrayMap.a();
        this.classInfo = ClassInfo.a(getClass(), enumSet.contains(Flags.IGNORE_CASE));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        FieldInfo a2 = this.classInfo.a(str);
        if (a2 != null) {
            return a2.a(this);
        }
        if (this.classInfo.a()) {
            str = str.toLowerCase();
        }
        return this.unknownFields.get(str);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(String str, Object obj) {
        FieldInfo a2 = this.classInfo.a(str);
        if (a2 != null) {
            Object a3 = a2.a(this);
            a2.a(this, obj);
            return a3;
        }
        if (this.classInfo.a()) {
            str = str.toLowerCase();
        }
        return this.unknownFields.put(str, obj);
    }

    public GenericData set(String str, Object obj) {
        FieldInfo a2 = this.classInfo.a(str);
        if (a2 != null) {
            a2.a(this, obj);
        } else {
            if (this.classInfo.a()) {
                str = str.toLowerCase();
            }
            this.unknownFields.put(str, obj);
        }
        return this;
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
        if (this.classInfo.a(str) != null) {
            throw new UnsupportedOperationException();
        }
        if (this.classInfo.a()) {
            str = str.toLowerCase();
        }
        return this.unknownFields.remove(str);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return new b();
    }

    @Override // java.util.AbstractMap
    public GenericData clone() {
        try {
            GenericData genericData = (GenericData) super.clone();
            Data.a(this, genericData);
            genericData.unknownFields = (Map) Data.c(this.unknownFields);
            return genericData;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    public final Map<String, Object> getUnknownKeys() {
        return this.unknownFields;
    }

    public final void setUnknownKeys(Map<String, Object> map) {
        this.unknownFields = map;
    }

    public final ClassInfo getClassInfo() {
        return this.classInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b extends AbstractSet<Map.Entry<String, Object>> {
        private final f.c b;

        b() {
            this.b = new f(GenericData.this, GenericData.this.classInfo.a()).entrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<String, Object>> iterator() {
            return new a(this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return GenericData.this.unknownFields.size() + this.b.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            GenericData.this.unknownFields.clear();
            this.b.clear();
        }
    }

    /* loaded from: classes.dex */
    final class a implements Iterator<Map.Entry<String, Object>> {
        private boolean b;
        private final Iterator<Map.Entry<String, Object>> c;
        private final Iterator<Map.Entry<String, Object>> d;

        a(f.c cVar) {
            this.c = cVar.iterator();
            this.d = GenericData.this.unknownFields.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c.hasNext() || this.d.hasNext();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<String, Object> next() {
            if (!this.b) {
                if (this.c.hasNext()) {
                    return this.c.next();
                }
                this.b = true;
            }
            return this.d.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.b) {
                this.d.remove();
            }
            this.c.remove();
        }
    }
}
