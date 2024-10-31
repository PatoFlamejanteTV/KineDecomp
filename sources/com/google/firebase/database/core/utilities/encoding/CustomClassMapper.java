package com.google.firebase.database.core.utilities.encoding;

import android.util.Log;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;
import com.google.firebase.database.ThrowOnExtraProperties;
import com.google.firebase.database.core.utilities.Utilities;
import com.umeng.commonsdk.proguard.e;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class CustomClassMapper {

    /* renamed from: a */
    private static final ConcurrentMap<Class<?>, a<?>> f17081a = new ConcurrentHashMap();

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class a<T> {

        /* renamed from: a */
        private final Class<T> f17082a;

        /* renamed from: b */
        private final Constructor<T> f17083b;

        /* renamed from: c */
        private final boolean f17084c;

        /* renamed from: d */
        private final boolean f17085d;

        /* renamed from: e */
        private final Map<String, String> f17086e = new HashMap();

        /* renamed from: g */
        private final Map<String, Method> f17088g = new HashMap();

        /* renamed from: f */
        private final Map<String, Method> f17087f = new HashMap();

        /* renamed from: h */
        private final Map<String, Field> f17089h = new HashMap();

        public a(Class<T> cls) {
            Constructor<T> constructor;
            this.f17082a = cls;
            this.f17084c = cls.isAnnotationPresent(ThrowOnExtraProperties.class);
            this.f17085d = !cls.isAnnotationPresent(IgnoreExtraProperties.class);
            try {
                constructor = cls.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                constructor = null;
            }
            this.f17083b = constructor;
            for (Method method : cls.getMethods()) {
                if (b(method)) {
                    String a2 = a(method);
                    a(a2);
                    method.setAccessible(true);
                    if (!this.f17087f.containsKey(a2)) {
                        this.f17087f.put(a2, method);
                    } else {
                        throw new DatabaseException("Found conflicting getters for name: " + method.getName());
                    }
                }
            }
            for (Field field : cls.getFields()) {
                if (b(field)) {
                    a(a(field));
                }
            }
            Class<T> cls2 = cls;
            do {
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (c(method2)) {
                        String a3 = a(method2);
                        String str = this.f17086e.get(a3.toLowerCase());
                        if (str == null) {
                            continue;
                        } else if (str.equals(a3)) {
                            Method method3 = this.f17088g.get(a3);
                            if (method3 == null) {
                                method2.setAccessible(true);
                                this.f17088g.put(a3, method2);
                            } else if (!a(method2, method3)) {
                                throw new DatabaseException("Found a conflicting setters with name: " + method2.getName() + " (conflicts with " + method3.getName() + " defined on " + method3.getDeclaringClass().getName() + ")");
                            }
                        } else {
                            throw new DatabaseException("Found setter with invalid case-sensitive name: " + method2.getName());
                        }
                    }
                }
                for (Field field2 : cls2.getDeclaredFields()) {
                    String a4 = a(field2);
                    if (this.f17086e.containsKey(a4.toLowerCase()) && !this.f17089h.containsKey(a4)) {
                        field2.setAccessible(true);
                        this.f17089h.put(a4, field2);
                    }
                }
                cls2 = cls2.getSuperclass();
                if (cls2 == null) {
                    break;
                }
            } while (!cls2.equals(Object.class));
            if (this.f17086e.isEmpty()) {
                throw new DatabaseException("No properties to serialize found on class " + cls.getName());
            }
        }

        private static boolean b(Method method) {
            return ((!method.getName().startsWith("get") && !method.getName().startsWith(e.ac)) || method.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.isAnnotationPresent(Exclude.class)) ? false : true;
        }

        private static boolean c(Method method) {
            return method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(Exclude.class);
        }

        private void a(String str) {
            String put = this.f17086e.put(str.toLowerCase(), str);
            if (put == null || str.equals(put)) {
                return;
            }
            throw new DatabaseException("Found two getters or fields with conflicting case sensitivity for property: " + str.toLowerCase());
        }

        public T a(Map<String, Object> map) {
            return a(map, Collections.emptyMap());
        }

        public T a(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2) {
            Constructor<T> constructor = this.f17083b;
            if (constructor != null) {
                try {
                    T newInstance = constructor.newInstance(new Object[0]);
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        if (this.f17088g.containsKey(key)) {
                            Method method = this.f17088g.get(key);
                            Type[] genericParameterTypes = method.getGenericParameterTypes();
                            if (genericParameterTypes.length == 1) {
                                try {
                                    method.invoke(newInstance, CustomClassMapper.b(entry.getValue(), a(genericParameterTypes[0], map2)));
                                } catch (IllegalAccessException e2) {
                                    throw new RuntimeException(e2);
                                } catch (InvocationTargetException e3) {
                                    throw new RuntimeException(e3);
                                }
                            } else {
                                throw new IllegalStateException("Setter does not have exactly one parameter");
                            }
                        } else if (this.f17089h.containsKey(key)) {
                            Field field = this.f17089h.get(key);
                            try {
                                field.set(newInstance, CustomClassMapper.b(entry.getValue(), a(field.getGenericType(), map2)));
                            } catch (IllegalAccessException e4) {
                                throw new RuntimeException(e4);
                            }
                        } else {
                            String str = "No setter/field for " + key + " found on class " + this.f17082a.getName();
                            if (this.f17086e.containsKey(key.toLowerCase())) {
                                str = str + " (fields/setters are case sensitive!)";
                            }
                            if (!this.f17084c) {
                                if (this.f17085d) {
                                    Log.w("ClassMapper", str);
                                }
                            } else {
                                throw new DatabaseException(str);
                            }
                        }
                    }
                    return newInstance;
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(e5);
                } catch (InstantiationException e6) {
                    throw new RuntimeException(e6);
                } catch (InvocationTargetException e7) {
                    throw new RuntimeException(e7);
                }
            }
            throw new DatabaseException("Class " + this.f17082a.getName() + " does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped.");
        }

        private static boolean b(Field field) {
            return (field.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(field.getModifiers()) || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || field.isAnnotationPresent(Exclude.class)) ? false : true;
        }

        private static String b(String str) {
            String str2 = null;
            for (String str3 : new String[]{"get", "set", e.ac}) {
                if (str.startsWith(str3)) {
                    str2 = str3;
                }
            }
            if (str2 != null) {
                char[] charArray = str.substring(str2.length()).toCharArray();
                for (int i = 0; i < charArray.length && Character.isUpperCase(charArray[i]); i++) {
                    charArray[i] = Character.toLowerCase(charArray[i]);
                }
                return new String(charArray);
            }
            throw new IllegalArgumentException("Unknown Bean prefix for method: " + str);
        }

        private Type a(Type type, Map<TypeVariable<Class<T>>, Type> map) {
            if (!(type instanceof TypeVariable)) {
                return type;
            }
            Type type2 = map.get(type);
            if (type2 != null) {
                return type2;
            }
            throw new IllegalStateException("Could not resolve type " + type);
        }

        public Map<String, Object> a(T t) {
            Object obj;
            if (this.f17082a.isAssignableFrom(t.getClass())) {
                HashMap hashMap = new HashMap();
                for (String str : this.f17086e.values()) {
                    if (this.f17087f.containsKey(str)) {
                        try {
                            obj = this.f17087f.get(str).invoke(t, new Object[0]);
                        } catch (IllegalAccessException e2) {
                            throw new RuntimeException(e2);
                        } catch (InvocationTargetException e3) {
                            throw new RuntimeException(e3);
                        }
                    } else {
                        Field field = this.f17089h.get(str);
                        if (field != null) {
                            try {
                                obj = field.get(t);
                            } catch (IllegalAccessException e4) {
                                throw new RuntimeException(e4);
                            }
                        } else {
                            throw new IllegalStateException("Bean property without field or getter:" + str);
                        }
                    }
                    hashMap.put(str, CustomClassMapper.h(obj));
                }
                return hashMap;
            }
            throw new IllegalArgumentException("Can't serialize object of class " + t.getClass() + " with BeanMapper for class " + this.f17082a);
        }

        private static boolean a(Method method, Method method2) {
            Utilities.a(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            Utilities.a(method.getReturnType().equals(Void.TYPE), "Expected void return type");
            Utilities.a(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?>[] parameterTypes2 = method2.getParameterTypes();
            Utilities.a(parameterTypes.length == 1, "Expected exactly one parameter");
            Utilities.a(parameterTypes2.length == 1, "Expected exactly one parameter");
            return method.getName().equals(method2.getName()) && parameterTypes[0].equals(parameterTypes2[0]);
        }

        private static String a(Field field) {
            String a2 = a((AccessibleObject) field);
            return a2 != null ? a2 : field.getName();
        }

        private static String a(Method method) {
            String a2 = a((AccessibleObject) method);
            return a2 != null ? a2 : b(method.getName());
        }

        private static String a(AccessibleObject accessibleObject) {
            if (accessibleObject.isAnnotationPresent(PropertyName.class)) {
                return ((PropertyName) accessibleObject.getAnnotation(PropertyName.class)).value();
            }
            return null;
        }
    }

    public static <T> T b(Object obj, Type type) {
        if (obj == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return (T) a(obj, (ParameterizedType) type);
        }
        if (type instanceof Class) {
            return (T) c(obj, (Class) type);
        }
        if (!(type instanceof WildcardType)) {
            if (type instanceof GenericArrayType) {
                throw new DatabaseException("Generic Arrays are not supported, please use Lists instead");
            }
            throw new IllegalStateException("Unknown type encountered: " + type);
        }
        throw new DatabaseException("Generic wildcard types are not supported");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T c(Object obj, Class<T> cls) {
        if (obj == 0) {
            return null;
        }
        if (!cls.isPrimitive() && !Number.class.isAssignableFrom(cls) && !Boolean.class.isAssignableFrom(cls) && !Character.class.isAssignableFrom(cls)) {
            if (String.class.isAssignableFrom(cls)) {
                return (T) f(obj);
            }
            if (!cls.isArray()) {
                if (cls.getTypeParameters().length <= 0) {
                    if (cls.equals(Object.class)) {
                        return obj;
                    }
                    if (cls.isEnum()) {
                        return (T) d(obj, cls);
                    }
                    return (T) b(obj, (Class) cls);
                }
                throw new DatabaseException("Class " + cls.getName() + " has generic type parameters, please use GenericTypeIndicator instead");
            }
            throw new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
        }
        return (T) e(obj, cls);
    }

    private static <T> T d(Object obj, Class<T> cls) {
        if (obj instanceof String) {
            String str = (String) obj;
            try {
                return (T) Enum.valueOf(cls, str);
            } catch (IllegalArgumentException unused) {
                throw new DatabaseException("Could not find enum value of " + cls.getName() + " for value \"" + str + "\"");
            }
        }
        throw new DatabaseException("Expected a String while deserializing to enum " + cls + " but got a " + obj.getClass());
    }

    private static <T> T e(Object obj, Class<T> cls) {
        if (!Integer.class.isAssignableFrom(cls) && !Integer.TYPE.isAssignableFrom(cls)) {
            if (!Boolean.class.isAssignableFrom(cls) && !Boolean.TYPE.isAssignableFrom(cls)) {
                if (!Double.class.isAssignableFrom(cls) && !Double.TYPE.isAssignableFrom(cls)) {
                    if (!Long.class.isAssignableFrom(cls) && !Long.TYPE.isAssignableFrom(cls)) {
                        if (!Float.class.isAssignableFrom(cls) && !Float.TYPE.isAssignableFrom(cls)) {
                            if (!Short.class.isAssignableFrom(cls) && !Short.TYPE.isAssignableFrom(cls)) {
                                if (!Byte.class.isAssignableFrom(cls) && !Byte.TYPE.isAssignableFrom(cls)) {
                                    if (!Character.class.isAssignableFrom(cls) && !Character.TYPE.isAssignableFrom(cls)) {
                                        throw new IllegalArgumentException("Unknown primitive type: " + cls);
                                    }
                                    throw new DatabaseException("Deserializing to char is not supported");
                                }
                                throw new DatabaseException("Deserializing to bytes is not supported");
                            }
                            throw new DatabaseException("Deserializing to shorts is not supported");
                        }
                        return (T) Float.valueOf(c(obj).floatValue());
                    }
                    return (T) e(obj);
                }
                return (T) c(obj);
            }
            return (T) b(obj);
        }
        return (T) d(obj);
    }

    private static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new DatabaseException("Failed to convert value of type " + obj.getClass().getName() + " to String");
    }

    private static Map<String, Object> g(Object obj) {
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new DatabaseException("Expected a Map while deserializing, but got a " + obj.getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Object h(T t) {
        if (t == 0) {
            return null;
        }
        if (t instanceof Number) {
            if (!(t instanceof Float) && !(t instanceof Double)) {
                if (!(t instanceof Short)) {
                    if (t instanceof Byte) {
                        throw new DatabaseException("Bytes are not supported, please use int or long");
                    }
                    return t;
                }
                throw new DatabaseException("Shorts are not supported, please use int or long");
            }
            Number number = (Number) t;
            double doubleValue = number.doubleValue();
            if (doubleValue <= 9.223372036854776E18d && doubleValue >= -9.223372036854776E18d && Math.floor(doubleValue) == doubleValue) {
                return Long.valueOf(number.longValue());
            }
            return Double.valueOf(doubleValue);
        }
        if ((t instanceof String) || (t instanceof Boolean)) {
            return t;
        }
        if (!(t instanceof Character)) {
            if (t instanceof Map) {
                HashMap hashMap = new HashMap();
                for (Map.Entry entry : ((Map) t).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        hashMap.put((String) key, h(entry.getValue()));
                    } else {
                        throw new DatabaseException("Maps with non-string keys are not supported");
                    }
                }
                return hashMap;
            }
            if (t instanceof Collection) {
                if (t instanceof List) {
                    List list = (List) t;
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(h(it.next()));
                    }
                    return arrayList;
                }
                throw new DatabaseException("Serializing Collections is not supported, please use Lists instead");
            }
            if (!t.getClass().isArray()) {
                if (t instanceof Enum) {
                    return ((Enum) t).name();
                }
                return a((Class) t.getClass()).a((a) t);
            }
            throw new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
        }
        throw new DatabaseException("Characters are not supported, please use Strings");
    }

    public static Map<String, Object> a(Map<String, Object> map) {
        Object h2 = h(map);
        Utilities.a(h2 instanceof Map);
        return (Map) h2;
    }

    public static <T> T a(Object obj, Class<T> cls) {
        return (T) c(obj, cls);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.List, T, java.util.ArrayList] */
    private static <T> T a(Object obj, ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(cls)) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                ?? r0 = (T) new ArrayList(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    r0.add(b(it.next(), type));
                }
                return r0;
            }
            throw new DatabaseException("Expected a List while deserializing, but got a " + obj.getClass());
        }
        if (Map.class.isAssignableFrom(cls)) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (type2.equals(String.class)) {
                Map<String, Object> g2 = g(obj);
                ?? r02 = (T) new HashMap();
                for (Map.Entry<String, Object> entry : g2.entrySet()) {
                    r02.put(entry.getKey(), b(entry.getValue(), type3));
                }
                return r02;
            }
            throw new DatabaseException("Only Maps with string keys are supported, but found Map with key type " + type2);
        }
        if (!Collection.class.isAssignableFrom(cls)) {
            Map<String, Object> g3 = g(obj);
            a a2 = a(cls);
            HashMap hashMap = new HashMap();
            TypeVariable<Class<T>>[] typeParameters = a2.f17082a.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length == typeParameters.length) {
                for (int i = 0; i < typeParameters.length; i++) {
                    hashMap.put(typeParameters[i], actualTypeArguments[i]);
                }
                return (T) a2.a(g3, hashMap);
            }
            throw new IllegalStateException("Mismatched lengths for type variables and actual types");
        }
        throw new DatabaseException("Collections are not supported, please use Lists instead");
    }

    private static Integer d(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (!(obj instanceof Long) && !(obj instanceof Double)) {
            throw new DatabaseException("Failed to convert a value of type " + obj.getClass().getName() + " to int");
        }
        Number number = (Number) obj;
        double doubleValue = number.doubleValue();
        if (doubleValue >= -2.147483648E9d && doubleValue <= 2.147483647E9d) {
            return Integer.valueOf(number.intValue());
        }
        throw new DatabaseException("Numeric value out of 32-bit integer range: " + doubleValue + ". Did you mean to use a long or double instead of an int?");
    }

    private static Boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new DatabaseException("Failed to convert value of type " + obj.getClass().getName() + " to boolean");
    }

    private static <T> T b(Object obj, Class<T> cls) {
        a a2 = a((Class) cls);
        if (obj instanceof Map) {
            return (T) a2.a(g(obj));
        }
        throw new DatabaseException("Can't convert object of type " + obj.getClass().getName() + " to type " + cls.getName());
    }

    private static Double c(Object obj) {
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (obj instanceof Long) {
            Long l = (Long) obj;
            Double valueOf = Double.valueOf(l.doubleValue());
            if (valueOf.longValue() == l.longValue()) {
                return valueOf;
            }
            throw new DatabaseException("Loss of precision while converting number to double: " + obj + ". Did you mean to use a 64-bit long instead?");
        }
        if (obj instanceof Double) {
            return (Double) obj;
        }
        throw new DatabaseException("Failed to convert a value of type " + obj.getClass().getName() + " to double");
    }

    private static Long e(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Double) {
            Double d2 = (Double) obj;
            if (d2.doubleValue() >= -9.223372036854776E18d && d2.doubleValue() <= 9.223372036854776E18d) {
                return Long.valueOf(d2.longValue());
            }
            throw new DatabaseException("Numeric value out of 64-bit long range: " + d2 + ". Did you mean to use a double instead of a long?");
        }
        throw new DatabaseException("Failed to convert a value of type " + obj.getClass().getName() + " to long");
    }

    private static <T> a<T> a(Class<T> cls) {
        a<T> aVar = (a) f17081a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        a<T> aVar2 = new a<>(cls);
        f17081a.put(cls, aVar2);
        return aVar2;
    }
}
