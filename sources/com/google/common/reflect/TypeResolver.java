package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes2.dex */
public final class TypeResolver {

    /* renamed from: a */
    private final b f16063a;

    /* synthetic */ TypeResolver(b bVar, g gVar) {
        this(bVar);
    }

    public static void b(Map<c, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new g(map, type2).a(type);
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a */
        private final ImmutableMap<c, Type> f16066a;

        public b() {
            this.f16066a = ImmutableMap.of();
        }

        final b a(Map<c, ? extends Type> map) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            builder.a(this.f16066a);
            for (Map.Entry<c, ? extends Type> entry : map.entrySet()) {
                c key = entry.getKey();
                Type value = entry.getValue();
                Preconditions.a(!key.a(value), "Type variable %s bound to itself", key);
                builder.a(key, value);
            }
            return new b(builder.a());
        }

        private b(ImmutableMap<c, Type> immutableMap) {
            this.f16066a = immutableMap;
        }

        final Type a(TypeVariable<?> typeVariable) {
            return a(typeVariable, new h(this, typeVariable, this));
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.GenericDeclaration] */
        public Type a(TypeVariable<?> typeVariable, b bVar) {
            Type type = this.f16066a.get(new c(typeVariable));
            if (type == null) {
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length == 0) {
                    return typeVariable;
                }
                Type[] a2 = new TypeResolver(bVar, null).a(bounds);
                return (Types.a.f16081a && Arrays.equals(bounds, a2)) ? typeVariable : Types.a(typeVariable.getGenericDeclaration(), typeVariable.getName(), a2);
            }
            return new TypeResolver(bVar, null).b(type);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a */
        private final TypeVariable<?> f16067a;

        public c(TypeVariable<?> typeVariable) {
            Preconditions.a(typeVariable);
            this.f16067a = typeVariable;
        }

        static c b(Type type) {
            if (type instanceof TypeVariable) {
                return new c((TypeVariable) type);
            }
            return null;
        }

        boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return a((TypeVariable<?>) type);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return a(((c) obj).f16067a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.a(this.f16067a.getGenericDeclaration(), this.f16067a.getName());
        }

        public String toString() {
            return this.f16067a.toString();
        }

        private boolean a(TypeVariable<?> typeVariable) {
            return this.f16067a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f16067a.getName().equals(typeVariable.getName());
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a */
        private final AtomicInteger f16068a;

        private d() {
            this.f16068a = new AtomicInteger();
        }

        private Type b(@Nullable Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        Type a(Type type) {
            Preconditions.a(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.b(a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return Types.a(b(parameterizedType.getOwnerType()), (Class<?>) parameterizedType.getRawType(), a(parameterizedType.getActualTypeArguments()));
            }
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                if (wildcardType.getLowerBounds().length != 0) {
                    return type;
                }
                return Types.a(d.class, "capture#" + this.f16068a.incrementAndGet() + "-of ? extends " + Joiner.a('&').a((Object[]) wildcardType.getUpperBounds()), wildcardType.getUpperBounds());
            }
            throw new AssertionError("must have been one of the known types");
        }

        /* synthetic */ d(g gVar) {
            this();
        }

        private Type[] a(Type[] typeArr) {
            Type[] typeArr2 = new Type[typeArr.length];
            for (int i = 0; i < typeArr.length; i++) {
                typeArr2[i] = a(typeArr[i]);
            }
            return typeArr2;
        }
    }

    public TypeResolver() {
        this.f16063a = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a extends r {

        /* renamed from: b */
        private static final d f16064b = new d(null);

        /* renamed from: c */
        private final Map<c, Type> f16065c = Maps.c();

        private a() {
        }

        static ImmutableMap<c, Type> a(Type type) {
            a aVar = new a();
            aVar.a(f16064b.a(type));
            return ImmutableMap.copyOf((Map) aVar.f16065c);
        }

        @Override // com.google.common.reflect.r
        void a(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.r
        void a(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.b(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                a(new c(typeParameters[i]), actualTypeArguments[i]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.r
        void a(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.r
        void a(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        private void a(c cVar, Type type) {
            if (this.f16065c.containsKey(cVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (cVar.a(type2)) {
                    while (type != null) {
                        type = this.f16065c.remove(c.b(type));
                    }
                    return;
                }
                type2 = this.f16065c.get(c.b(type2));
            }
            this.f16065c.put(cVar, type);
        }
    }

    public Type b(Type type) {
        Preconditions.a(type);
        if (type instanceof TypeVariable) {
            return this.f16063a.a((TypeVariable<?>) type);
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type);
        }
        return type instanceof WildcardType ? a((WildcardType) type) : type;
    }

    private TypeResolver(b bVar) {
        this.f16063a = bVar;
    }

    public static TypeResolver a(Type type) {
        return new TypeResolver().a(a.a(type));
    }

    public TypeResolver a(Type type, Type type2) {
        HashMap c2 = Maps.c();
        Preconditions.a(type);
        Preconditions.a(type2);
        b(c2, type, type2);
        return a(c2);
    }

    public TypeResolver a(Map<c, ? extends Type> map) {
        return new TypeResolver(this.f16063a.a(map));
    }

    public Type[] a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = b(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType a(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(a(wildcardType.getLowerBounds()), a(wildcardType.getUpperBounds()));
    }

    public static <T> T b(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    private Type a(GenericArrayType genericArrayType) {
        return Types.b(b(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType a(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.a(ownerType == null ? null : b(ownerType), (Class<?>) b(parameterizedType.getRawType()), a(parameterizedType.getActualTypeArguments()));
    }
}
