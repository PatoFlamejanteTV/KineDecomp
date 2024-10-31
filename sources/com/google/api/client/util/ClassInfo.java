package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class ClassInfo {
    private static final Map<Class<?>, ClassInfo> b = new WeakHashMap();
    private static final Map<Class<?>, ClassInfo> c = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    final List<String> f2531a;
    private final Class<?> d;
    private final boolean e;
    private final IdentityHashMap<String, FieldInfo> f = new IdentityHashMap<>();

    public static ClassInfo a(Class<?> cls) {
        return a(cls, false);
    }

    public static ClassInfo a(Class<?> cls, boolean z) {
        ClassInfo classInfo;
        if (cls == null) {
            return null;
        }
        Map<Class<?>, ClassInfo> map = z ? c : b;
        synchronized (map) {
            classInfo = map.get(cls);
            if (classInfo == null) {
                classInfo = new ClassInfo(cls, z);
                map.put(cls, classInfo);
            }
        }
        return classInfo;
    }

    public final boolean a() {
        return this.e;
    }

    public FieldInfo a(String str) {
        if (str != null) {
            if (this.e) {
                str = str.toLowerCase();
            }
            str = str.intern();
        }
        return this.f.get(str);
    }

    public Field b(String str) {
        FieldInfo a2 = a(str);
        if (a2 == null) {
            return null;
        }
        return a2.a();
    }

    public boolean b() {
        return this.d.isEnum();
    }

    private ClassInfo(Class<?> cls, boolean z) {
        this.d = cls;
        this.e = z;
        boolean z2 = (z && cls.isEnum()) ? false : true;
        String valueOf = String.valueOf(String.valueOf(cls));
        Preconditions.a(z2, new StringBuilder(valueOf.length() + 31).append("cannot ignore case on an enum: ").append(valueOf).toString());
        TreeSet treeSet = new TreeSet(new d(this));
        for (Field field : cls.getDeclaredFields()) {
            FieldInfo a2 = FieldInfo.a(field);
            if (a2 != null) {
                String b2 = a2.b();
                String intern = z ? b2.toLowerCase().intern() : b2;
                FieldInfo fieldInfo = this.f.get(intern);
                boolean z3 = fieldInfo == null;
                Object[] objArr = new Object[4];
                objArr[0] = z ? "case-insensitive " : "";
                objArr[1] = intern;
                objArr[2] = field;
                objArr[3] = fieldInfo == null ? null : fieldInfo.a();
                Preconditions.a(z3, "two fields have the same %sname <%s>: %s and %s", objArr);
                this.f.put(intern, a2);
                treeSet.add(intern);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            ClassInfo a3 = a(superclass, z);
            treeSet.addAll(a3.f2531a);
            for (Map.Entry<String, FieldInfo> entry : a3.f.entrySet()) {
                String key = entry.getKey();
                if (!this.f.containsKey(key)) {
                    this.f.put(key, entry.getValue());
                }
            }
        }
        this.f2531a = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
    }

    public Collection<FieldInfo> c() {
        return Collections.unmodifiableCollection(this.f.values());
    }
}
