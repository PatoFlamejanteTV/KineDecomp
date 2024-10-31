package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class ArrayValueMap {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f2525a = ArrayMap.a();
    private final Map<Field, a> b = ArrayMap.a();
    private final Object c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Class<?> f2526a;
        final ArrayList<Object> b = new ArrayList<>();

        a(Class<?> cls) {
            this.f2526a = cls;
        }

        Object a() {
            return Types.a((Collection<?>) this.b, this.f2526a);
        }

        void a(Class<?> cls, Object obj) {
            Preconditions.a(cls == this.f2526a);
            this.b.add(obj);
        }
    }

    public ArrayValueMap(Object obj) {
        this.c = obj;
    }

    public void a() {
        for (Map.Entry<String, a> entry : this.f2525a.entrySet()) {
            ((Map) this.c).put(entry.getKey(), entry.getValue().a());
        }
        for (Map.Entry<Field, a> entry2 : this.b.entrySet()) {
            FieldInfo.a(entry2.getKey(), this.c, entry2.getValue().a());
        }
    }

    public void a(Field field, Class<?> cls, Object obj) {
        a aVar = this.b.get(field);
        if (aVar == null) {
            aVar = new a(cls);
            this.b.put(field, aVar);
        }
        aVar.a(cls, obj);
    }
}
