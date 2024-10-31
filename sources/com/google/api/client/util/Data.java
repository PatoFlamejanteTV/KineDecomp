package com.google.api.client.util;

import com.facebook.appevents.AppEventsConstants;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class Data {

    /* renamed from: a, reason: collision with root package name */
    public static final Boolean f2533a = new Boolean(true);
    public static final String b = new String();
    public static final Character c = new Character(0);
    public static final Byte d = new Byte((byte) 0);
    public static final Short e = new Short((short) 0);
    public static final Integer f = new Integer(0);
    public static final Float g = new Float(0.0f);
    public static final Long h = new Long(0);
    public static final Double i = new Double(0.0d);
    public static final BigInteger j = new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    public static final BigDecimal k = new BigDecimal(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    public static final DateTime l = new DateTime(0);
    private static final ConcurrentHashMap<Class<?>, Object> m = new ConcurrentHashMap<>();

    static {
        m.put(Boolean.class, f2533a);
        m.put(String.class, b);
        m.put(Character.class, c);
        m.put(Byte.class, d);
        m.put(Short.class, e);
        m.put(Integer.class, f);
        m.put(Float.class, g);
        m.put(Long.class, h);
        m.put(Double.class, i);
        m.put(BigInteger.class, j);
        m.put(BigDecimal.class, k);
        m.put(DateTime.class, l);
    }

    public static <T> T a(Class<?> cls) {
        int i2 = 0;
        Object obj = (T) m.get(cls);
        if (obj == null) {
            synchronized (m) {
                obj = m.get(cls);
                if (obj == null) {
                    if (cls.isArray()) {
                        Class<?> cls2 = cls;
                        do {
                            cls2 = cls2.getComponentType();
                            i2++;
                        } while (cls2.isArray());
                        obj = (T) Array.newInstance(cls2, new int[i2]);
                    } else if (cls.isEnum()) {
                        FieldInfo a2 = ClassInfo.a(cls).a((String) null);
                        Preconditions.a(a2, "enum missing constant with @NullValue annotation: %s", cls);
                        obj = a2.g();
                    } else {
                        obj = Types.a((Class<Object>) cls);
                    }
                    m.put(cls, obj);
                }
            }
        }
        return (T) obj;
    }

    public static boolean a(Object obj) {
        return obj != null && obj == m.get(obj.getClass());
    }

    public static Map<String, Object> b(Object obj) {
        if (obj == null || a(obj)) {
            return Collections.emptyMap();
        }
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return new f(obj, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T c(T t) {
        T t2;
        if (t == 0 || a((Type) t.getClass())) {
            return t;
        }
        if (t instanceof GenericData) {
            return (T) ((GenericData) t).clone();
        }
        Class<?> cls = t.getClass();
        if (cls.isArray()) {
            t2 = (T) Array.newInstance(cls.getComponentType(), Array.getLength(t));
        } else if (t instanceof ArrayMap) {
            t2 = (T) ((ArrayMap) t).clone();
        } else {
            t2 = (T) Types.a((Class) cls);
        }
        a(t, t2);
        return t2;
    }

    public static void a(Object obj, Object obj2) {
        int i2 = 0;
        Class<?> cls = obj.getClass();
        Preconditions.a(cls == obj2.getClass());
        if (cls.isArray()) {
            Preconditions.a(Array.getLength(obj) == Array.getLength(obj2));
            Iterator it = Types.a(obj).iterator();
            while (it.hasNext()) {
                Array.set(obj2, i2, c(it.next()));
                i2++;
            }
            return;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            Collection collection = (Collection) obj;
            if (ArrayList.class.isAssignableFrom(cls)) {
                ((ArrayList) obj2).ensureCapacity(collection.size());
            }
            Collection collection2 = (Collection) obj2;
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                collection2.add(c(it2.next()));
            }
            return;
        }
        boolean isAssignableFrom = GenericData.class.isAssignableFrom(cls);
        if (isAssignableFrom || !Map.class.isAssignableFrom(cls)) {
            ClassInfo a2 = isAssignableFrom ? ((GenericData) obj).classInfo : ClassInfo.a(cls);
            Iterator<String> it3 = a2.f2531a.iterator();
            while (it3.hasNext()) {
                FieldInfo a3 = a2.a(it3.next());
                if (!a3.e() && (!isAssignableFrom || !a3.f())) {
                    Object a4 = a3.a(obj);
                    if (a4 != null) {
                        a3.a(obj2, c(a4));
                    }
                }
            }
            return;
        }
        if (ArrayMap.class.isAssignableFrom(cls)) {
            ArrayMap arrayMap = (ArrayMap) obj2;
            ArrayMap arrayMap2 = (ArrayMap) obj;
            int size = arrayMap2.size();
            while (i2 < size) {
                arrayMap.a(i2, c(arrayMap2.b(i2)));
                i2++;
            }
            return;
        }
        Map map = (Map) obj2;
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            map.put(entry.getKey(), c(entry.getValue()));
        }
    }

    public static boolean a(Type type) {
        Type a2 = type instanceof WildcardType ? Types.a((WildcardType) type) : type;
        if (!(a2 instanceof Class)) {
            return false;
        }
        Class cls = (Class) a2;
        return cls.isPrimitive() || cls == Character.class || cls == String.class || cls == Integer.class || cls == Long.class || cls == Short.class || cls == Byte.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == DateTime.class || cls == Boolean.class;
    }

    public static boolean d(Object obj) {
        return obj == null || a((Type) obj.getClass());
    }

    public static Object a(Type type, String str) {
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || cls != null) {
            if (cls == Void.class) {
                return null;
            }
            if (str != null && cls != null && !cls.isAssignableFrom(String.class)) {
                if (cls == Character.class || cls == Character.TYPE) {
                    if (str.length() != 1) {
                        String valueOf = String.valueOf(String.valueOf(cls));
                        throw new IllegalArgumentException(new StringBuilder(valueOf.length() + 37).append("expected type Character/char but got ").append(valueOf).toString());
                    }
                    return Character.valueOf(str.charAt(0));
                }
                if (cls == Boolean.class || cls == Boolean.TYPE) {
                    return Boolean.valueOf(str);
                }
                if (cls == Byte.class || cls == Byte.TYPE) {
                    return Byte.valueOf(str);
                }
                if (cls == Short.class || cls == Short.TYPE) {
                    return Short.valueOf(str);
                }
                if (cls == Integer.class || cls == Integer.TYPE) {
                    return Integer.valueOf(str);
                }
                if (cls == Long.class || cls == Long.TYPE) {
                    return Long.valueOf(str);
                }
                if (cls == Float.class || cls == Float.TYPE) {
                    return Float.valueOf(str);
                }
                if (cls == Double.class || cls == Double.TYPE) {
                    return Double.valueOf(str);
                }
                if (cls == DateTime.class) {
                    return DateTime.parseRfc3339(str);
                }
                if (cls == BigInteger.class) {
                    return new BigInteger(str);
                }
                if (cls == BigDecimal.class) {
                    return new BigDecimal(str);
                }
                if (cls.isEnum()) {
                    return ClassInfo.a((Class<?>) cls).a(str).g();
                }
            } else {
                return str;
            }
        }
        String valueOf2 = String.valueOf(String.valueOf(type));
        throw new IllegalArgumentException(new StringBuilder(valueOf2.length() + 35).append("expected primitive class, but got: ").append(valueOf2).toString());
    }

    public static Collection<Object> b(Type type) {
        Type a2 = type instanceof WildcardType ? Types.a((WildcardType) type) : type;
        Type rawType = a2 instanceof ParameterizedType ? ((ParameterizedType) a2).getRawType() : a2;
        Class cls = rawType instanceof Class ? (Class) rawType : null;
        if (rawType == null || (rawType instanceof GenericArrayType) || (cls != null && (cls.isArray() || cls.isAssignableFrom(ArrayList.class)))) {
            return new ArrayList();
        }
        if (cls == null) {
            String valueOf = String.valueOf(String.valueOf(rawType));
            throw new IllegalArgumentException(new StringBuilder(valueOf.length() + 39).append("unable to create new instance of type: ").append(valueOf).toString());
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        return (Collection) Types.a(cls);
    }

    public static Map<String, Object> b(Class<?> cls) {
        if (cls == null || cls.isAssignableFrom(ArrayMap.class)) {
            return ArrayMap.a();
        }
        if (cls.isAssignableFrom(TreeMap.class)) {
            return new TreeMap();
        }
        return (Map) Types.a((Class) cls);
    }

    public static Type a(List<Type> list, Type type) {
        Type a2 = type instanceof WildcardType ? Types.a((WildcardType) type) : type;
        while (a2 instanceof TypeVariable) {
            Type a3 = Types.a(list, (TypeVariable<?>) a2);
            if (a3 == null) {
                a3 = a2;
            }
            a2 = a3 instanceof TypeVariable ? ((TypeVariable) a3).getBounds()[0] : a3;
        }
        return a2;
    }
}
