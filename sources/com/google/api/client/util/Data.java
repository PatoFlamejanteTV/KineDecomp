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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class Data {

    /* renamed from: a, reason: collision with root package name */
    public static final Boolean f14924a = new Boolean(true);

    /* renamed from: b, reason: collision with root package name */
    public static final String f14925b = new String();

    /* renamed from: c, reason: collision with root package name */
    public static final Character f14926c = new Character(0);

    /* renamed from: d, reason: collision with root package name */
    public static final Byte f14927d = new Byte((byte) 0);

    /* renamed from: e, reason: collision with root package name */
    public static final Short f14928e = new Short((short) 0);

    /* renamed from: f, reason: collision with root package name */
    public static final Integer f14929f = new Integer(0);

    /* renamed from: g, reason: collision with root package name */
    public static final Float f14930g = new Float(0.0f);

    /* renamed from: h, reason: collision with root package name */
    public static final Long f14931h = new Long(0);
    public static final Double i = new Double(0.0d);
    public static final BigInteger j = new BigInteger(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    public static final BigDecimal k = new BigDecimal(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    public static final DateTime l = new DateTime(0);
    private static final ConcurrentHashMap<Class<?>, Object> m = new ConcurrentHashMap<>();

    static {
        m.put(Boolean.class, f14924a);
        m.put(String.class, f14925b);
        m.put(Character.class, f14926c);
        m.put(Byte.class, f14927d);
        m.put(Short.class, f14928e);
        m.put(Integer.class, f14929f);
        m.put(Float.class, f14930g);
        m.put(Long.class, f14931h);
        m.put(Double.class, i);
        m.put(BigInteger.class, j);
        m.put(BigDecimal.class, k);
        m.put(DateTime.class, l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(T t) {
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
            if ("java.util.Arrays$ArrayList".equals(cls.getName())) {
                Object[] array = ((List) t).toArray();
                a(array, array);
                return (T) Arrays.asList(array);
            }
            t2 = (T) Types.a((Class) cls);
        }
        a(t, t2);
        return t2;
    }

    public static <T> T b(Class<?> cls) {
        Object obj = (T) m.get(cls);
        if (obj == null) {
            synchronized (m) {
                obj = m.get(cls);
                if (obj == null) {
                    int i2 = 0;
                    if (cls.isArray()) {
                        Class<?> cls2 = cls;
                        do {
                            cls2 = cls2.getComponentType();
                            i2++;
                        } while (cls2.isArray());
                        obj = (T) Array.newInstance(cls2, new int[i2]);
                    } else if (cls.isEnum()) {
                        FieldInfo b2 = ClassInfo.a(cls).b(null);
                        Preconditions.a(b2, "enum missing constant with @NullValue annotation: %s", cls);
                        obj = b2.a();
                    } else {
                        obj = Types.a((Class<Object>) cls);
                    }
                    m.put(cls, obj);
                }
            }
        }
        return (T) obj;
    }

    public static boolean c(Object obj) {
        return obj == null || a((Type) obj.getClass());
    }

    public static Map<String, Object> d(Object obj) {
        if (obj != null && !b(obj)) {
            if (obj instanceof Map) {
                return (Map) obj;
            }
            return new f(obj, false);
        }
        return Collections.emptyMap();
    }

    public static void a(Object obj, Object obj2) {
        ClassInfo a2;
        Class<?> cls = obj.getClass();
        int i2 = 0;
        Preconditions.a(cls == obj2.getClass());
        if (cls.isArray()) {
            Preconditions.a(Array.getLength(obj) == Array.getLength(obj2));
            Iterator it = Types.a(obj).iterator();
            while (it.hasNext()) {
                Array.set(obj2, i2, a(it.next()));
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
                collection2.add(a(it2.next()));
            }
            return;
        }
        boolean isAssignableFrom = GenericData.class.isAssignableFrom(cls);
        if (!isAssignableFrom && Map.class.isAssignableFrom(cls)) {
            if (ArrayMap.class.isAssignableFrom(cls)) {
                ArrayMap arrayMap = (ArrayMap) obj2;
                ArrayMap arrayMap2 = (ArrayMap) obj;
                int size = arrayMap2.size();
                while (i2 < size) {
                    arrayMap.a(i2, a(arrayMap2.c(i2)));
                    i2++;
                }
                return;
            }
            Map map = (Map) obj2;
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                map.put(entry.getKey(), a(entry.getValue()));
            }
            return;
        }
        if (isAssignableFrom) {
            a2 = ((GenericData) obj).classInfo;
        } else {
            a2 = ClassInfo.a(cls);
        }
        Iterator<String> it3 = a2.f14922f.iterator();
        while (it3.hasNext()) {
            FieldInfo b2 = a2.b(it3.next());
            if (!b2.f() && (!isAssignableFrom || !b2.g())) {
                Object a3 = b2.a(obj);
                if (a3 != null) {
                    b2.a(obj2, a(a3));
                }
            }
        }
    }

    public static boolean b(Object obj) {
        return obj != null && obj == m.get(obj.getClass());
    }

    public static Collection<Object> b(Type type) {
        if (type instanceof WildcardType) {
            type = Types.a((WildcardType) type);
        }
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || (type instanceof GenericArrayType) || (cls != null && (cls.isArray() || cls.isAssignableFrom(ArrayList.class)))) {
            return new ArrayList();
        }
        if (cls != null) {
            if (cls.isAssignableFrom(HashSet.class)) {
                return new HashSet();
            }
            if (cls.isAssignableFrom(TreeSet.class)) {
                return new TreeSet();
            }
            return (Collection) Types.a(cls);
        }
        throw new IllegalArgumentException("unable to create new instance of type: " + type);
    }

    public static boolean a(Type type) {
        if (type instanceof WildcardType) {
            type = Types.a((WildcardType) type);
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Class cls = (Class) type;
        return cls.isPrimitive() || cls == Character.class || cls == String.class || cls == Integer.class || cls == Long.class || cls == Short.class || cls == Byte.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == DateTime.class || cls == Boolean.class;
    }

    public static Object a(Type type, String str) {
        Class cls = type instanceof Class ? (Class) type : null;
        if (type == null || cls != null) {
            if (cls == Void.class) {
                return null;
            }
            if (str == null || cls == null || cls.isAssignableFrom(String.class)) {
                return str;
            }
            if (cls != Character.class && cls != Character.TYPE) {
                if (cls != Boolean.class && cls != Boolean.TYPE) {
                    if (cls != Byte.class && cls != Byte.TYPE) {
                        if (cls != Short.class && cls != Short.TYPE) {
                            if (cls != Integer.class && cls != Integer.TYPE) {
                                if (cls != Long.class && cls != Long.TYPE) {
                                    if (cls != Float.class && cls != Float.TYPE) {
                                        if (cls != Double.class && cls != Double.TYPE) {
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
                                                if (ClassInfo.a((Class<?>) cls).f14922f.contains(str)) {
                                                    return ClassInfo.a((Class<?>) cls).b(str).a();
                                                }
                                                throw new IllegalArgumentException(String.format("given enum name %s not part of enumeration", str));
                                            }
                                        } else {
                                            return Double.valueOf(str);
                                        }
                                    } else {
                                        return Float.valueOf(str);
                                    }
                                } else {
                                    return Long.valueOf(str);
                                }
                            } else {
                                return Integer.valueOf(str);
                            }
                        } else {
                            return Short.valueOf(str);
                        }
                    } else {
                        return Byte.valueOf(str);
                    }
                } else {
                    return Boolean.valueOf(str);
                }
            } else {
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw new IllegalArgumentException("expected type Character/char but got " + cls);
            }
        }
        throw new IllegalArgumentException("expected primitive class, but got: " + type);
    }

    public static Map<String, Object> a(Class<?> cls) {
        if (cls != null && !cls.isAssignableFrom(ArrayMap.class)) {
            if (cls.isAssignableFrom(TreeMap.class)) {
                return new TreeMap();
            }
            return (Map) Types.a((Class) cls);
        }
        return ArrayMap.a();
    }

    public static Type a(List<Type> list, Type type) {
        if (type instanceof WildcardType) {
            type = Types.a((WildcardType) type);
        }
        while (type instanceof TypeVariable) {
            Type a2 = Types.a(list, (TypeVariable<?>) type);
            if (a2 != null) {
                type = a2;
            }
            if (type instanceof TypeVariable) {
                type = ((TypeVariable) type).getBounds()[0];
            }
        }
        return type;
    }
}
