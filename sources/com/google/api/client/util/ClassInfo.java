package com.google.api.client.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class ClassInfo {

    /* renamed from: a */
    private static final Map<Class<?>, ClassInfo> f14917a = new WeakHashMap();

    /* renamed from: b */
    private static final Map<Class<?>, ClassInfo> f14918b = new WeakHashMap();

    /* renamed from: c */
    private final Class<?> f14919c;

    /* renamed from: d */
    private final boolean f14920d;

    /* renamed from: e */
    private final IdentityHashMap<String, FieldInfo> f14921e = new IdentityHashMap<>();

    /* renamed from: f */
    final List<String> f14922f;

    private ClassInfo(Class<?> cls, boolean z) {
        this.f14919c = cls;
        this.f14920d = z;
        Preconditions.a((z && cls.isEnum()) ? false : true, "cannot ignore case on an enum: " + cls);
        TreeSet treeSet = new TreeSet(new d(this));
        for (Field field : cls.getDeclaredFields()) {
            FieldInfo a2 = FieldInfo.a(field);
            if (a2 != null) {
                String d2 = a2.d();
                d2 = z ? d2.toLowerCase(Locale.US).intern() : d2;
                FieldInfo fieldInfo = this.f14921e.get(d2);
                boolean z2 = fieldInfo == null;
                Object[] objArr = new Object[4];
                objArr[0] = z ? "case-insensitive " : "";
                objArr[1] = d2;
                objArr[2] = field;
                objArr[3] = fieldInfo == null ? null : fieldInfo.b();
                Preconditions.a(z2, "two fields have the same %sname <%s>: %s and %s", objArr);
                this.f14921e.put(d2, a2);
                treeSet.add(d2);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            ClassInfo a3 = a(superclass, z);
            treeSet.addAll(a3.f14922f);
            for (Map.Entry<String, FieldInfo> entry : a3.f14921e.entrySet()) {
                String key = entry.getKey();
                if (!this.f14921e.containsKey(key)) {
                    this.f14921e.put(key, entry.getValue());
                }
            }
        }
        this.f14922f = treeSet.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(treeSet));
    }

    public static ClassInfo a(Class<?> cls) {
        return a(cls, false);
    }

    public final boolean b() {
        return this.f14920d;
    }

    public boolean c() {
        return this.f14919c.isEnum();
    }

    public static ClassInfo a(Class<?> cls, boolean z) {
        ClassInfo classInfo;
        if (cls == null) {
            return null;
        }
        Map<Class<?>, ClassInfo> map = z ? f14918b : f14917a;
        synchronized (map) {
            classInfo = map.get(cls);
            if (classInfo == null) {
                classInfo = new ClassInfo(cls, z);
                map.put(cls, classInfo);
            }
        }
        return classInfo;
    }

    public FieldInfo b(String str) {
        if (str != null) {
            if (this.f14920d) {
                str = str.toLowerCase(Locale.US);
            }
            str = str.intern();
        }
        return this.f14921e.get(str);
    }

    public Field a(String str) {
        FieldInfo b2 = b(str);
        if (b2 == null) {
            return null;
        }
        return b2.b();
    }

    public Collection<FieldInfo> a() {
        return Collections.unmodifiableCollection(this.f14921e.values());
    }
}
