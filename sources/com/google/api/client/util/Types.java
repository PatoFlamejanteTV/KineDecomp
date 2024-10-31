package com.google.api.client.util;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class Types {
    public static ParameterizedType a(Type type, Class<?> cls) {
        Class<?> cls2;
        if ((type instanceof Class) || (type instanceof ParameterizedType)) {
            Type type2 = type;
            while (type2 != null && type2 != Object.class) {
                if (type2 instanceof Class) {
                    cls2 = (Class) type2;
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    Class<?> a2 = a(parameterizedType);
                    if (a2 != cls) {
                        if (cls.isInterface()) {
                            for (Type type3 : a2.getGenericInterfaces()) {
                                if (cls.isAssignableFrom(type3 instanceof Class ? (Class) type3 : a((ParameterizedType) type3))) {
                                    type2 = type3;
                                    break;
                                }
                            }
                        }
                        cls2 = a2;
                    } else {
                        return parameterizedType;
                    }
                }
                type2 = cls2.getGenericSuperclass();
            }
        }
        return null;
    }

    public static boolean a(Class<?> cls, Class<?> cls2) {
        return cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls);
    }

    public static <T> T a(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            throw a((Exception) e, (Class<?>) cls);
        } catch (InstantiationException e2) {
            throw a((Exception) e2, (Class<?>) cls);
        }
    }

    private static IllegalArgumentException a(Exception exc, Class<?> cls) {
        StringBuilder append = new StringBuilder("unable to create new instance of class ").append(cls.getName());
        ArrayList arrayList = new ArrayList();
        if (cls.isArray()) {
            arrayList.add("because it is an array");
        } else if (cls.isPrimitive()) {
            arrayList.add("because it is primitive");
        } else if (cls == Void.class) {
            arrayList.add("because it is void");
        } else {
            if (Modifier.isInterface(cls.getModifiers())) {
                arrayList.add("because it is an interface");
            } else if (Modifier.isAbstract(cls.getModifiers())) {
                arrayList.add("because it is abstract");
            }
            if (cls.getEnclosingClass() != null && !Modifier.isStatic(cls.getModifiers())) {
                arrayList.add("because it is not static");
            }
            if (!Modifier.isPublic(cls.getModifiers())) {
                arrayList.add("possibly because it is not public");
            } else {
                try {
                    cls.getConstructor(new Class[0]);
                } catch (NoSuchMethodException e) {
                    arrayList.add("because it has no accessible default constructor");
                }
            }
        }
        Iterator it = arrayList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z) {
                append.append(" and");
            } else {
                z = true;
            }
            append.append(" ").append(str);
        }
        return new IllegalArgumentException(append.toString(), exc);
    }

    public static boolean a(Type type) {
        return (type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray());
    }

    public static Type b(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Class<?> a(ParameterizedType parameterizedType) {
        return (Class) parameterizedType.getRawType();
    }

    public static Type a(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        return lowerBounds.length != 0 ? lowerBounds[0] : wildcardType.getUpperBounds()[0];
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.GenericDeclaration] */
    public static Type a(List<Type> list, TypeVariable<?> typeVariable) {
        Type a2;
        ?? genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            Class cls = (Class) genericDeclaration;
            int size = list.size();
            ParameterizedType parameterizedType = null;
            while (parameterizedType == null) {
                size--;
                if (size < 0) {
                    break;
                }
                parameterizedType = a(list.get(size), (Class<?>) cls);
            }
            if (parameterizedType != null) {
                TypeVariable<?>[] typeParameters = genericDeclaration.getTypeParameters();
                int i = 0;
                while (i < typeParameters.length && !typeParameters[i].equals(typeVariable)) {
                    i++;
                }
                Type type = parameterizedType.getActualTypeArguments()[i];
                return (!(type instanceof TypeVariable) || (a2 = a(list, (TypeVariable<?>) type)) == null) ? type : a2;
            }
        }
        return null;
    }

    public static Class<?> a(List<Type> list, Type type) {
        Type a2 = type instanceof TypeVariable ? a(list, (TypeVariable<?>) type) : type;
        if (a2 instanceof GenericArrayType) {
            return Array.newInstance(a(list, b(a2)), 0).getClass();
        }
        if (a2 instanceof Class) {
            return (Class) a2;
        }
        if (a2 instanceof ParameterizedType) {
            return a((ParameterizedType) a2);
        }
        Preconditions.a(a2 == null, "wildcard type is not supported: %s", a2);
        return Object.class;
    }

    public static Type c(Type type) {
        return a(type, Iterable.class, 0);
    }

    public static Type d(Type type) {
        return a(type, Map.class, 1);
    }

    private static Type a(Type type, Class<?> cls, int i) {
        Type a2;
        ParameterizedType a3 = a(type, cls);
        if (a3 == null) {
            return null;
        }
        Type type2 = a3.getActualTypeArguments()[i];
        return (!(type2 instanceof TypeVariable) || (a2 = a((List<Type>) Arrays.asList(type), (TypeVariable<?>) type2)) == null) ? type2 : a2;
    }

    public static <T> Iterable<T> a(Object obj) {
        if (obj instanceof Iterable) {
            return (Iterable) obj;
        }
        Class<?> cls = obj.getClass();
        Preconditions.a(cls.isArray(), "not an array or Iterable: %s", cls);
        if (!cls.getComponentType().isPrimitive()) {
            return Arrays.asList((Object[]) obj);
        }
        return new j(obj);
    }

    public static Object a(Collection<?> collection, Class<?> cls) {
        if (!cls.isPrimitive()) {
            return collection.toArray((Object[]) Array.newInstance(cls, collection.size()));
        }
        Object newInstance = Array.newInstance(cls, collection.size());
        int i = 0;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            Array.set(newInstance, i, it.next());
            i++;
        }
        return newInstance;
    }

    private Types() {
    }
}
