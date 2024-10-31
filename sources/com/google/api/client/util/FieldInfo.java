package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class FieldInfo {

    /* renamed from: a */
    private static final Map<Field, FieldInfo> f14948a = new WeakHashMap();

    /* renamed from: b */
    private final boolean f14949b;

    /* renamed from: c */
    private final Field f14950c;

    /* renamed from: d */
    private final String f14951d;

    FieldInfo(Field field, String str) {
        this.f14950c = field;
        this.f14951d = str == null ? null : str.intern();
        this.f14949b = Data.a((Type) e());
    }

    public static FieldInfo a(Enum<?> r5) {
        try {
            FieldInfo a2 = a(r5.getClass().getField(r5.name()));
            Preconditions.a(a2 != null, "enum constant missing @Value or @NullValue annotation: %s", r5);
            return a2;
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Field b() {
        return this.f14950c;
    }

    public Type c() {
        return this.f14950c.getGenericType();
    }

    public String d() {
        return this.f14951d;
    }

    public Class<?> e() {
        return this.f14950c.getType();
    }

    public boolean f() {
        return Modifier.isFinal(this.f14950c.getModifiers());
    }

    public boolean g() {
        return this.f14949b;
    }

    public static FieldInfo a(Field field) {
        String str = null;
        if (field == null) {
            return null;
        }
        synchronized (f14948a) {
            FieldInfo fieldInfo = f14948a.get(field);
            boolean isEnumConstant = field.isEnumConstant();
            if (fieldInfo == null && (isEnumConstant || !Modifier.isStatic(field.getModifiers()))) {
                if (isEnumConstant) {
                    Value value = (Value) field.getAnnotation(Value.class);
                    if (value != null) {
                        str = value.value();
                    } else if (((NullValue) field.getAnnotation(NullValue.class)) == null) {
                        return null;
                    }
                } else {
                    Key key = (Key) field.getAnnotation(Key.class);
                    if (key == null) {
                        return null;
                    }
                    str = key.value();
                    field.setAccessible(true);
                }
                if ("##default".equals(str)) {
                    str = field.getName();
                }
                fieldInfo = new FieldInfo(field, str);
                f14948a.put(field, fieldInfo);
            }
            return fieldInfo;
        }
    }

    public Object a(Object obj) {
        return a(this.f14950c, obj);
    }

    public void a(Object obj, Object obj2) {
        a(this.f14950c, obj, obj2);
    }

    public <T extends Enum<T>> T a() {
        return (T) Enum.valueOf(this.f14950c.getDeclaringClass(), this.f14950c.getName());
    }

    public static Object a(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        if (Modifier.isFinal(field.getModifiers())) {
            Object a2 = a(field, obj);
            if (obj2 == null) {
                if (a2 == null) {
                    return;
                }
            } else if (obj2.equals(a2)) {
                return;
            }
            throw new IllegalArgumentException("expected final value <" + a2 + "> but was <" + obj2 + "> on " + field.getName() + " field in " + obj.getClass().getName());
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(e2);
        } catch (SecurityException e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
