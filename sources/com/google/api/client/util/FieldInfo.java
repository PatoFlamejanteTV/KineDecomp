package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class FieldInfo {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Field, FieldInfo> f2536a = new WeakHashMap();
    private final boolean b;
    private final Field c;
    private final String d;

    public static FieldInfo a(Enum<?> r5) {
        try {
            FieldInfo a2 = a(r5.getClass().getField(r5.name()));
            Preconditions.a(a2 != null, "enum constant missing @Value or @NullValue annotation: %s", r5);
            return a2;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[Catch: all -> 0x004b, TryCatch #0 {, blocks: (B:8:0x0007, B:11:0x0017, B:14:0x0023, B:16:0x002d, B:17:0x0031, B:19:0x0039, B:20:0x003e, B:21:0x0049, B:24:0x004e, B:27:0x005a, B:29:0x005c, B:31:0x0066, B:33:0x0068), top: B:7:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.api.client.util.FieldInfo a(java.lang.reflect.Field r5) {
        /*
            r1 = 0
            if (r5 != 0) goto L4
        L3:
            return r1
        L4:
            java.util.Map<java.lang.reflect.Field, com.google.api.client.util.FieldInfo> r2 = com.google.api.client.util.FieldInfo.f2536a
            monitor-enter(r2)
            java.util.Map<java.lang.reflect.Field, com.google.api.client.util.FieldInfo> r0 = com.google.api.client.util.FieldInfo.f2536a     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Throwable -> L4b
            com.google.api.client.util.FieldInfo r0 = (com.google.api.client.util.FieldInfo) r0     // Catch: java.lang.Throwable -> L4b
            boolean r3 = r5.isEnumConstant()     // Catch: java.lang.Throwable -> L4b
            if (r0 != 0) goto L73
            if (r3 != 0) goto L21
            int r4 = r5.getModifiers()     // Catch: java.lang.Throwable -> L4b
            boolean r4 = java.lang.reflect.Modifier.isStatic(r4)     // Catch: java.lang.Throwable -> L4b
            if (r4 != 0) goto L73
        L21:
            if (r3 == 0) goto L5c
            java.lang.Class<com.google.api.client.util.Value> r0 = com.google.api.client.util.Value.class
            java.lang.annotation.Annotation r0 = r5.getAnnotation(r0)     // Catch: java.lang.Throwable -> L4b
            com.google.api.client.util.Value r0 = (com.google.api.client.util.Value) r0     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L4e
            java.lang.String r0 = r0.a()     // Catch: java.lang.Throwable -> L4b
        L31:
            java.lang.String r1 = "##default"
            boolean r1 = r1.equals(r0)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L71
            java.lang.String r0 = r5.getName()     // Catch: java.lang.Throwable -> L4b
            r1 = r0
        L3e:
            com.google.api.client.util.FieldInfo r0 = new com.google.api.client.util.FieldInfo     // Catch: java.lang.Throwable -> L4b
            r0.<init>(r5, r1)     // Catch: java.lang.Throwable -> L4b
            java.util.Map<java.lang.reflect.Field, com.google.api.client.util.FieldInfo> r1 = com.google.api.client.util.FieldInfo.f2536a     // Catch: java.lang.Throwable -> L4b
            r1.put(r5, r0)     // Catch: java.lang.Throwable -> L4b
            r1 = r0
        L49:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4b
            goto L3
        L4b:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4b
            throw r0
        L4e:
            java.lang.Class<com.google.api.client.util.NullValue> r0 = com.google.api.client.util.NullValue.class
            java.lang.annotation.Annotation r0 = r5.getAnnotation(r0)     // Catch: java.lang.Throwable -> L4b
            com.google.api.client.util.NullValue r0 = (com.google.api.client.util.NullValue) r0     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L5a
            r0 = r1
            goto L31
        L5a:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4b
            goto L3
        L5c:
            java.lang.Class<com.google.api.client.util.Key> r0 = com.google.api.client.util.Key.class
            java.lang.annotation.Annotation r0 = r5.getAnnotation(r0)     // Catch: java.lang.Throwable -> L4b
            com.google.api.client.util.Key r0 = (com.google.api.client.util.Key) r0     // Catch: java.lang.Throwable -> L4b
            if (r0 != 0) goto L68
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4b
            goto L3
        L68:
            java.lang.String r0 = r0.a()     // Catch: java.lang.Throwable -> L4b
            r1 = 1
            r5.setAccessible(r1)     // Catch: java.lang.Throwable -> L4b
            goto L31
        L71:
            r1 = r0
            goto L3e
        L73:
            r1 = r0
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.util.FieldInfo.a(java.lang.reflect.Field):com.google.api.client.util.FieldInfo");
    }

    FieldInfo(Field field, String str) {
        this.c = field;
        this.d = str == null ? null : str.intern();
        this.b = Data.a((Type) c());
    }

    public Field a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public Class<?> c() {
        return this.c.getType();
    }

    public Type d() {
        return this.c.getGenericType();
    }

    public boolean e() {
        return Modifier.isFinal(this.c.getModifiers());
    }

    public boolean f() {
        return this.b;
    }

    public Object a(Object obj) {
        return a(this.c, obj);
    }

    public void a(Object obj, Object obj2) {
        a(this.c, obj, obj2);
    }

    public <T extends Enum<T>> T g() {
        return (T) Enum.valueOf(this.c.getDeclaringClass(), this.c.getName());
    }

    public static Object a(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
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
            String valueOf = String.valueOf(String.valueOf(a2));
            String valueOf2 = String.valueOf(String.valueOf(obj2));
            String valueOf3 = String.valueOf(String.valueOf(field.getName()));
            String valueOf4 = String.valueOf(String.valueOf(obj.getClass().getName()));
            throw new IllegalArgumentException(new StringBuilder(valueOf.length() + 48 + valueOf2.length() + valueOf3.length() + valueOf4.length()).append("expected final value <").append(valueOf).append("> but was <").append(valueOf2).append("> on ").append(valueOf3).append(" field in ").append(valueOf4).toString());
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (SecurityException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
