package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ArrayValueMap {

    /* renamed from: a */
    private final Map<String, a> f14903a = ArrayMap.a();

    /* renamed from: b */
    private final Map<Field, a> f14904b = ArrayMap.a();

    /* renamed from: c */
    private final Object f14905c;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        final Class<?> f14906a;

        /* renamed from: b */
        final ArrayList<Object> f14907b = new ArrayList<>();

        a(Class<?> cls) {
            this.f14906a = cls;
        }

        Object a() {
            return Types.a((Collection<?>) this.f14907b, this.f14906a);
        }

        void a(Class<?> cls, Object obj) {
            Preconditions.a(cls == this.f14906a);
            this.f14907b.add(obj);
        }
    }

    public ArrayValueMap(Object obj) {
        this.f14905c = obj;
    }

    public void a() {
        for (Map.Entry<String, a> entry : this.f14903a.entrySet()) {
            ((Map) this.f14905c).put(entry.getKey(), entry.getValue().a());
        }
        for (Map.Entry<Field, a> entry2 : this.f14904b.entrySet()) {
            FieldInfo.a(entry2.getKey(), this.f14905c, entry2.getValue().a());
        }
    }

    public void a(Field field, Class<?> cls, Object obj) {
        a aVar = this.f14904b.get(field);
        if (aVar == null) {
            aVar = new a(cls);
            this.f14904b.put(field, aVar);
        }
        aVar.a(cls, obj);
    }
}
