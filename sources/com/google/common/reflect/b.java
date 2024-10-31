package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* compiled from: TypeResolver.java */
/* loaded from: classes2.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableMap<TypeVariable<?>, Type> f2943a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(ImmutableMap immutableMap, c cVar) {
        this(immutableMap);
    }

    public b() {
        this.f2943a = ImmutableMap.of();
    }

    private b(ImmutableMap<TypeVariable<?>, Type> immutableMap) {
        this.f2943a = immutableMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(Type type) {
        return new b().a(a.a(type));
    }

    public final b a(Type type, Type type2) {
        HashMap a2 = Maps.a();
        a(a2, type, type2);
        return a(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b a(Map<? extends TypeVariable<?>, ? extends Type> map) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        builder.b(this.f2943a);
        for (Map.Entry<? extends TypeVariable<?>, ? extends Type> entry : map.entrySet()) {
            TypeVariable<?> key = entry.getKey();
            Type value = entry.getValue();
            Preconditions.a(!key.equals(value), "Type variable %s bound to itself", key);
            builder.b(key, value);
        }
        return new b(builder.b());
    }

    private static void a(Map<TypeVariable<?>, Type> map, Type type, Type type2) {
        int i = 0;
        if (!type.equals(type2)) {
            if (type instanceof TypeVariable) {
                map.put((TypeVariable) type, type2);
                return;
            }
            if (type instanceof GenericArrayType) {
                a(map, ((GenericArrayType) type).getGenericComponentType(), (Type) a(Types.e(type2), "%s is not an array type.", type2));
                return;
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) a(ParameterizedType.class, (Object) type2);
                Preconditions.a(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", type, type2);
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
                Preconditions.a(actualTypeArguments.length == actualTypeArguments2.length);
                while (i < actualTypeArguments.length) {
                    a(map, actualTypeArguments[i], actualTypeArguments2[i]);
                    i++;
                }
                return;
            }
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) a(WildcardType.class, (Object) type2);
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                Preconditions.a(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", type, type2);
                for (int i2 = 0; i2 < upperBounds.length; i2++) {
                    a(map, upperBounds[i2], upperBounds2[i2]);
                }
                while (i < lowerBounds.length) {
                    a(map, lowerBounds[i], lowerBounds2[i]);
                    i++;
                }
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + type);
        }
    }

    public final Type b(Type type) {
        if (type instanceof TypeVariable) {
            return a((TypeVariable<?>) type);
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type);
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            return new Types.WildcardTypeImpl(a(wildcardType.getLowerBounds()), a(wildcardType.getUpperBounds()));
        }
        return type;
    }

    private Type[] a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = b(typeArr[i]);
        }
        return typeArr2;
    }

    private Type a(GenericArrayType genericArrayType) {
        return Types.a(b(genericArrayType.getGenericComponentType()));
    }

    private Type a(TypeVariable<?> typeVariable) {
        return a(typeVariable, new c(this, this.f2943a, typeVariable, this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.reflect.GenericDeclaration] */
    public Type a(TypeVariable<?> typeVariable, b bVar) {
        Type type = this.f2943a.get(typeVariable);
        if (type == null) {
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 0) {
                return Types.a(typeVariable.getGenericDeclaration(), typeVariable.getName(), bVar.a(bounds));
            }
            return typeVariable;
        }
        return bVar.b(type);
    }

    private ParameterizedType a(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        Type b = ownerType == null ? null : b(ownerType);
        Type b2 = b(parameterizedType.getRawType());
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] typeArr = new Type[actualTypeArguments.length];
        for (int i = 0; i < actualTypeArguments.length; i++) {
            typeArr[i] = b(actualTypeArguments[i]);
        }
        return Types.a(b, (Class<?>) b2, typeArr);
    }

    private static <T> T a(T t, String str, Object... objArr) {
        Preconditions.a(t != null, str, objArr);
        return t;
    }

    private static <T> T a(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    /* compiled from: TypeResolver.java */
    /* loaded from: classes2.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final C0052b f2944a = new C0052b(null);
        private final Map<TypeVariable<?>, Type> b = Maps.a();
        private final Set<Type> c = Sets.a();

        private a() {
        }

        static ImmutableMap<TypeVariable<?>, Type> a(Type type) {
            a aVar = new a();
            aVar.b(f2944a.a(type));
            return ImmutableMap.copyOf((Map) aVar.b);
        }

        private void b(Type type) {
            int i = 0;
            if (this.c.add(type)) {
                if (type instanceof ParameterizedType) {
                    a((ParameterizedType) type);
                    return;
                }
                if (type instanceof Class) {
                    a((Class<?>) type);
                    return;
                }
                if (type instanceof TypeVariable) {
                    Type[] bounds = ((TypeVariable) type).getBounds();
                    int length = bounds.length;
                    while (i < length) {
                        b(bounds[i]);
                        i++;
                    }
                    return;
                }
                if (type instanceof WildcardType) {
                    Type[] upperBounds = ((WildcardType) type).getUpperBounds();
                    int length2 = upperBounds.length;
                    while (i < length2) {
                        b(upperBounds[i]);
                        i++;
                    }
                }
            }
        }

        private void a(Class<?> cls) {
            b(cls.getGenericSuperclass());
            for (Type type : cls.getGenericInterfaces()) {
                b(type);
            }
        }

        private void a(ParameterizedType parameterizedType) {
            Class<?> cls = (Class) parameterizedType.getRawType();
            TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.b(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                a(typeParameters[i], actualTypeArguments[i]);
            }
            a(cls);
            b(parameterizedType.getOwnerType());
        }

        private void a(TypeVariable<?> typeVariable, Type type) {
            if (!this.b.containsKey(typeVariable)) {
                Type type2 = type;
                while (type2 != null) {
                    if (!typeVariable.equals(type2)) {
                        type2 = this.b.get(type2);
                    } else {
                        while (type != null) {
                            type = this.b.remove(type);
                        }
                        return;
                    }
                }
                this.b.put(typeVariable, type);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeResolver.java */
    /* renamed from: com.google.common.reflect.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0052b {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f2945a;

        private C0052b() {
            this.f2945a = new AtomicInteger();
        }

        /* synthetic */ C0052b(c cVar) {
            this();
        }

        Type a(Type type) {
            Preconditions.a(type);
            if (!(type instanceof Class) && !(type instanceof TypeVariable)) {
                if (type instanceof GenericArrayType) {
                    return Types.a(a(((GenericArrayType) type).getGenericComponentType()));
                }
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    return Types.a(b(parameterizedType.getOwnerType()), (Class<?>) parameterizedType.getRawType(), a(parameterizedType.getActualTypeArguments()));
                }
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    if (wildcardType.getLowerBounds().length == 0) {
                        return Types.a(C0052b.class, "capture#" + this.f2945a.incrementAndGet() + "-of ? extends " + Joiner.a('&').a((Object[]) wildcardType.getUpperBounds()), wildcardType.getUpperBounds());
                    }
                    return type;
                }
                throw new AssertionError("must have been one of the known types");
            }
            return type;
        }

        private Type b(@Nullable Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private Type[] a(Type[] typeArr) {
            Type[] typeArr2 = new Type[typeArr.length];
            for (int i = 0; i < typeArr.length; i++) {
                typeArr2[i] = a(typeArr[i]);
            }
            return typeArr2;
        }
    }
}
