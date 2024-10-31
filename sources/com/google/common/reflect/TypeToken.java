package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.Types;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes.dex */
public abstract class TypeToken<T> extends com.google.common.reflect.a<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private transient b f2936a;
    private final Type runtimeType;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeToken<?> typeToken) {
                return ((((TypeToken) typeToken).runtimeType instanceof TypeVariable) || (((TypeToken) typeToken).runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        }
    }

    protected TypeToken() {
        this.runtimeType = capture();
        Preconditions.b(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    protected TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = of((Class) cls).resolveType(capture).runtimeType;
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) Preconditions.a(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final Class<? super T> getRawType() {
        return (Class<? super T>) getRawType(this.runtimeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> a() {
        return (ImmutableSet<Class<? super T>>) getRawTypes(this.runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new b().a(ImmutableMap.of(typeParameter.f2935a, typeToken.runtimeType)).b(this.runtimeType));
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, Class<X> cls) {
        return where(typeParameter, of((Class) cls));
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.a(type);
        b bVar = this.f2936a;
        if (bVar == null) {
            bVar = b.a(this.runtimeType);
            this.f2936a = bVar;
        }
        return of(bVar.b(type));
    }

    private TypeToken<?> a(Type type) {
        TypeToken<?> resolveType = resolveType(type);
        resolveType.f2936a = this.f2936a;
        return resolveType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final TypeToken<? super T> getGenericSuperclass() {
        if (this.runtimeType instanceof TypeVariable) {
            return b(((TypeVariable) this.runtimeType).getBounds()[0]);
        }
        if (this.runtimeType instanceof WildcardType) {
            return b(((WildcardType) this.runtimeType).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) a(genericSuperclass);
    }

    @Nullable
    private TypeToken<? super T> b(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        if (this.runtimeType instanceof TypeVariable) {
            return a(((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return a(((WildcardType) this.runtimeType).getUpperBounds());
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : getRawType().getGenericInterfaces()) {
            builder.b((ImmutableList.Builder) a(type));
        }
        return builder.a();
    }

    private ImmutableList<TypeToken<? super T>> a(Type[] typeArr) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.getRawType().isInterface()) {
                builder.b((ImmutableList.Builder) of);
            }
        }
        return builder.a();
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        Preconditions.a(cls.isAssignableFrom(getRawType()), "%s is not a super class of %s", cls, this);
        if (this.runtimeType instanceof TypeVariable) {
            return a(cls, ((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return a(cls, ((WildcardType) this.runtimeType).getUpperBounds());
        }
        if (cls.isArray()) {
            return a((Class) cls);
        }
        return (TypeToken<? super T>) a(toGenericType(cls).runtimeType);
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        Preconditions.a(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        if (this.runtimeType instanceof WildcardType) {
            return b(cls, ((WildcardType) this.runtimeType).getLowerBounds());
        }
        Preconditions.a(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        if (isArray()) {
            return b(cls);
        }
        return (TypeToken<? extends T>) of(c(cls));
    }

    public final boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.runtimeType);
    }

    public final boolean isAssignableFrom(Type type) {
        return a((Type) Preconditions.a(type), this.runtimeType);
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    @Nullable
    public final TypeToken<?> getComponentType() {
        Type e = Types.e(this.runtimeType);
        if (e == null) {
            return null;
        }
        return of(e);
    }

    /* loaded from: classes2.dex */
    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private transient ImmutableSet<TypeToken<? super T>> f2939a;

        TypeSet() {
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f2939a;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> a2 = FluentIterable.a(a.f2940a.a((a<TypeToken<?>>) TypeToken.this)).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
                this.f2939a = a2;
                return a2;
            }
            return immutableSet;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) a.b.a(TypeToken.this.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class InterfaceSet extends TypeSet {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private final transient TypeToken<T>.TypeSet f2938a;
        private transient ImmutableSet<TypeToken<? super T>> b;

        InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.f2938a = typeSet;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.b;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> a2 = FluentIterable.a(this.f2938a).a(TypeFilter.INTERFACE_ONLY).a();
                this.b = a2;
                return a2;
            }
            return immutableSet;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.a(a.b.a(TypeToken.this.a())).a(new d(this)).a();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ClassSet extends TypeSet {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private transient ImmutableSet<TypeToken<? super T>> f2937a;

        private ClassSet() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f2937a;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> a2 = FluentIterable.a(a.f2940a.a().a((a<TypeToken<?>>) TypeToken.this)).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
                this.f2937a = a2;
                return a2;
            }
            return immutableSet;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) a.b.a().a(TypeToken.this.a()));
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public String toString() {
        return Types.d(this.runtimeType);
    }

    protected Object writeReplace() {
        return of(new b().b(this.runtimeType));
    }

    final TypeToken<T> rejectTypeVariables() {
        Preconditions.a(!Types.f(this.runtimeType), "%s contains a type variable and is not safe for the operation");
        return this;
    }

    private static boolean a(Type type, Type type2) {
        if (type2.equals(type)) {
            return true;
        }
        if (type2 instanceof WildcardType) {
            return a(type, (WildcardType) type2);
        }
        if (type instanceof TypeVariable) {
            return a(((TypeVariable) type).getBounds(), type2);
        }
        if (type instanceof WildcardType) {
            return a(((WildcardType) type).getUpperBounds(), type2);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type, type2);
        }
        if (type2 instanceof Class) {
            return a(type, (Class<?>) type2);
        }
        if (type2 instanceof ParameterizedType) {
            return a(type, (ParameterizedType) type2);
        }
        if (type2 instanceof GenericArrayType) {
            return a(type, (GenericArrayType) type2);
        }
        return false;
    }

    private static boolean a(Type[] typeArr, Type type) {
        for (Type type2 : typeArr) {
            if (a(type2, type)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Type type, Class<?> cls) {
        return cls.isAssignableFrom(getRawType(type));
    }

    private static boolean a(Type type, WildcardType wildcardType) {
        return a(type, a(wildcardType)) && b(type, wildcardType);
    }

    private static boolean b(Type type, WildcardType wildcardType) {
        Type b = b(wildcardType);
        if (b == null) {
            return true;
        }
        Type d = d(type);
        if (d == null) {
            return false;
        }
        return a(b, d);
    }

    private static boolean a(Type type, ParameterizedType parameterizedType) {
        Class<?> rawType = getRawType(parameterizedType);
        if (!rawType.isAssignableFrom(getRawType(type))) {
            return false;
        }
        TypeVariable<Class<?>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeToken<?> of = of(type);
        for (int i = 0; i < typeParameters.length; i++) {
            if (!b(((TypeToken) of.resolveType(typeParameters[i])).runtimeType, actualTypeArguments[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(Type type, GenericArrayType genericArrayType) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return a(cls.getComponentType(), genericArrayType.getGenericComponentType());
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return a(((GenericArrayType) type).getGenericComponentType(), genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private static boolean a(GenericArrayType genericArrayType, Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return a(genericArrayType.getGenericComponentType(), (Type) cls.getComponentType());
            }
            return cls == Object.class;
        }
        if (type instanceof GenericArrayType) {
            return a(genericArrayType.getGenericComponentType(), ((GenericArrayType) type).getGenericComponentType());
        }
        return false;
    }

    private static boolean b(Type type, Type type2) {
        if (type.equals(type2)) {
            return true;
        }
        if (type2 instanceof WildcardType) {
            return a(type, (WildcardType) type2);
        }
        return false;
    }

    private static Type c(Type type) {
        if (type instanceof WildcardType) {
            return a((WildcardType) type);
        }
        return type;
    }

    private static Type a(WildcardType wildcardType) {
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return c(upperBounds[0]);
        }
        if (upperBounds.length == 0) {
            return Object.class;
        }
        throw new AssertionError("There should be at most one upper bound for wildcard type: " + wildcardType);
    }

    @Nullable
    private static Type d(Type type) {
        if (type instanceof WildcardType) {
            return b((WildcardType) type);
        }
        return type;
    }

    @Nullable
    private static Type b(WildcardType wildcardType) {
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (lowerBounds.length == 1) {
            return d(lowerBounds[0]);
        }
        if (lowerBounds.length == 0) {
            return null;
        }
        throw new AssertionError("Wildcard should have at most one lower bound: " + wildcardType);
    }

    @VisibleForTesting
    static Class<?> getRawType(Type type) {
        return getRawTypes(type).iterator().next();
    }

    @VisibleForTesting
    static ImmutableSet<Class<?>> getRawTypes(Type type) {
        if (type instanceof Class) {
            return ImmutableSet.of((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return ImmutableSet.of((Class) ((ParameterizedType) type).getRawType());
        }
        if (type instanceof GenericArrayType) {
            return ImmutableSet.of(Types.a(getRawType(((GenericArrayType) type).getGenericComponentType())));
        }
        if (type instanceof TypeVariable) {
            return b(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return b(((WildcardType) type).getUpperBounds());
        }
        throw new AssertionError(type + " unsupported");
    }

    private static ImmutableSet<Class<?>> b(Type[] typeArr) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        for (Type type : typeArr) {
            builder.a((Iterable) getRawTypes(type));
        }
        return builder.a();
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.a(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        if (typeParameters.length > 0) {
            return (TypeToken<? extends T>) of(Types.a((Class<?>) cls, (Type[]) typeParameters));
        }
        return of((Class) cls);
    }

    private TypeToken<? super T> a(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of((Class) cls).isAssignableFrom(of)) {
                return (TypeToken<? super T>) of.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private TypeToken<? extends T> b(Class<?> cls, Type[] typeArr) {
        if (0 < typeArr.length) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> a(Class<? super T> cls) {
        return (TypeToken<? super T>) of(e(((TypeToken) Preconditions.a(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).runtimeType));
    }

    private TypeToken<? extends T> b(Class<?> cls) {
        return (TypeToken<? extends T>) of(e(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    private Type c(Class<?> cls) {
        if (!(this.runtimeType instanceof Class)) {
            TypeToken genericType = toGenericType(cls);
            return new b().a(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).b(genericType.runtimeType);
        }
        return cls;
    }

    private static Type e(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class a<K> {

        /* renamed from: a, reason: collision with root package name */
        static final a<TypeToken<?>> f2940a = new e();
        static final a<Class<?>> b = new f();

        abstract Class<?> b(K k);

        abstract Iterable<? extends K> c(K k);

        @Nullable
        abstract K d(K k);

        private a() {
        }

        final a<K> a() {
            return new g(this, this);
        }

        final ImmutableList<K> a(K k) {
            return a((Iterable) ImmutableList.of(k));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ImmutableList<K> a(Iterable<? extends K> iterable) {
            HashMap a2 = Maps.a();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                a((a<K>) it.next(), (Map<? super a<K>, Integer>) a2);
            }
            return a(a2, Ordering.natural().reverse());
        }

        private int a(K k, Map<? super K, Integer> map) {
            Integer num = map.get(this);
            if (num != null) {
                return num.intValue();
            }
            int i = b(k).isInterface() ? 1 : 0;
            Iterator<? extends K> it = c(k).iterator();
            while (it.hasNext()) {
                i = Math.max(i, a((a<K>) it.next(), (Map<? super a<K>, Integer>) map));
            }
            K d = d(k);
            if (d != null) {
                i = Math.max(i, a((a<K>) d, (Map<? super a<K>, Integer>) map));
            }
            map.put(k, Integer.valueOf(i + 1));
            return i + 1;
        }

        private static <K, V> ImmutableList<K> a(Map<K, V> map, Comparator<? super V> comparator) {
            return (ImmutableList<K>) new h(comparator, map).immutableSortedCopy(map.keySet());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.common.reflect.TypeToken$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0051a<K> extends a<K> {
            private final a<K> c;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0051a(a<K> aVar) {
                super();
                this.c = aVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.a
            public Class<?> b(K k) {
                return this.c.b(k);
            }

            @Override // com.google.common.reflect.TypeToken.a
            Iterable<? extends K> c(K k) {
                return this.c.c(k);
            }

            @Override // com.google.common.reflect.TypeToken.a
            K d(K k) {
                return this.c.d(k);
            }
        }
    }
}
