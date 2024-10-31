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
import com.google.common.primitives.Primitives;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.Types;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
/* loaded from: classes2.dex */
public abstract class TypeToken<T> extends f<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private transient TypeResolver f16069a;
    private final Type runtimeType;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private transient ImmutableSet<TypeToken<? super T>> f16070b;

        private ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) b.f16077b.a().a(TypeToken.this.b()));
        }

        /* synthetic */ ClassSet(TypeToken typeToken, i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f16070b;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> a2 = FluentIterable.a(b.f16076a.a().a((b<TypeToken<?>>) TypeToken.this)).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
            this.f16070b = a2;
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

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
        };

        /* synthetic */ TypeFilter(i iVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Type[] f16074a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f16075b;

        a(Type[] typeArr, boolean z) {
            this.f16074a = typeArr;
            this.f16075b = z;
        }

        boolean a(Type type) {
            for (Type type2 : this.f16074a) {
                boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z = this.f16075b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.f16075b;
        }

        boolean b(Type type) {
            TypeToken<?> of = TypeToken.of(type);
            for (Type type2 : this.f16074a) {
                boolean isSubtypeOf = of.isSubtypeOf(type2);
                boolean z = this.f16075b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.f16075b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class b<K> {

        /* renamed from: a, reason: collision with root package name */
        static final b<TypeToken<?>> f16076a = new n();

        /* renamed from: b, reason: collision with root package name */
        static final b<Class<?>> f16077b = new o();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class a<K> extends b<K> {

            /* renamed from: c, reason: collision with root package name */
            private final b<K> f16078c;

            /* JADX INFO: Access modifiers changed from: package-private */
            public a(b<K> bVar) {
                super(null);
                this.f16078c = bVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.b
            public Class<?> c(K k) {
                return this.f16078c.c(k);
            }

            @Override // com.google.common.reflect.TypeToken.b
            K d(K k) {
                return this.f16078c.d(k);
            }
        }

        private b() {
        }

        final b<K> a() {
            return new p(this, this);
        }

        abstract Iterable<? extends K> b(K k);

        abstract Class<?> c(K k);

        @Nullable
        abstract K d(K k);

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(i iVar) {
            this();
        }

        final ImmutableList<K> a(K k) {
            return a((Iterable) ImmutableList.of(k));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ImmutableList<K> a(Iterable<? extends K> iterable) {
            HashMap c2 = Maps.c();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                a((b<K>) it.next(), (Map<? super b<K>, Integer>) c2);
            }
            return a(c2, Ordering.natural().reverse());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        private int a(K k, Map<? super K, Integer> map) {
            Integer num = map.get(k);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = c(k).isInterface();
            Iterator<? extends K> it = b(k).iterator();
            int i = isInterface;
            while (it.hasNext()) {
                i = Math.max(i, a((b<K>) it.next(), (Map<? super b<K>, Integer>) map));
            }
            K d2 = d(k);
            int i2 = i;
            if (d2 != null) {
                i2 = Math.max(i, a((b<K>) d2, (Map<? super b<K>, Integer>) map));
            }
            int i3 = i2 + 1;
            map.put(k, Integer.valueOf(i3));
            return i3;
        }

        private static <K, V> ImmutableList<K> a(Map<K, V> map, Comparator<? super V> comparator) {
            return (ImmutableList<K>) new q(comparator, map).immutableSortedCopy(map.keySet());
        }
    }

    /* synthetic */ TypeToken(Type type, i iVar) {
        this(type);
    }

    @Nullable
    private TypeToken<? super T> a(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Type[] access$000(TypeToken typeToken, Type[] typeArr) {
        typeToken.d(typeArr);
        return typeArr;
    }

    private ImmutableList<TypeToken<? super T>> b(Type[] typeArr) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.getRawType().isInterface()) {
                builder.a((ImmutableList.Builder) of);
            }
        }
        return builder.a();
    }

    private boolean c() {
        return Primitives.a().contains(this.runtimeType);
    }

    private Type[] d(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]).getType();
        }
        return typeArr;
    }

    private TypeToken<?> e(Type type) {
        TypeToken<?> resolveType = resolveType(type);
        resolveType.f16069a = this.f16069a;
        return resolveType;
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.b(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        if (typeParameters.length <= 0 && (type == null || type == cls.getEnclosingClass())) {
            return of((Class) cls);
        }
        return (TypeToken<? extends T>) of(Types.a(type, (Class<?>) cls, (Type[]) typeParameters));
    }

    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        Preconditions.a(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new j(this, constructor);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    @Nullable
    public final TypeToken<?> getComponentType() {
        Type a2 = Types.a(this.runtimeType);
        if (a2 == null) {
            return null;
        }
        return of(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return b(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return b(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.a((ImmutableList.Builder) e(type2));
        }
        return builder.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return a(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return a(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) e(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return b().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        Preconditions.a(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return a(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return a(cls);
        }
        Preconditions.a(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        return (TypeToken<? extends T>) of(c(cls));
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        Preconditions.a(d((Class<?>) cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return b(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return b(cls, ((WildcardType) type).getUpperBounds());
        }
        if (cls.isArray()) {
            return b((Class) cls);
        }
        return (TypeToken<? super T>) e(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final Invokable<T, Object> method(Method method) {
        Preconditions.a(d(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new i(this, method);
    }

    @CanIgnoreReturnValue
    final TypeToken<T> rejectTypeVariables() {
        new k(this).a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.a(type);
        TypeResolver typeResolver = this.f16069a;
        if (typeResolver == null) {
            typeResolver = TypeResolver.a(this.runtimeType);
            this.f16069a = typeResolver;
        }
        return of(typeResolver.b(type));
    }

    public String toString() {
        return Types.e(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return c() ? of(Primitives.a((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new TypeResolver().a(ImmutableMap.of(new TypeResolver.c(typeParameter.f16062a), typeToken.runtimeType)).b(this.runtimeType));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(Primitives.b((Class) this.runtimeType)) : this;
    }

    protected Object writeReplace() {
        return of(new TypeResolver().b(this.runtimeType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* renamed from: b, reason: collision with root package name */
        private final transient TypeToken<T>.TypeSet f16071b;

        /* renamed from: c, reason: collision with root package name */
        private transient ImmutableSet<TypeToken<? super T>> f16072c;

        InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.f16071b = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.a(b.f16077b.a(TypeToken.this.b())).a(new m(this)).a();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f16072c;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> a2 = FluentIterable.a(this.f16071b).a(TypeFilter.INTERFACE_ONLY).a();
            this.f16072c = a2;
            return a2;
        }
    }

    /* loaded from: classes2.dex */
    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private transient ImmutableSet<TypeToken<? super T>> f16073a;

        TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) b.f16077b.a(TypeToken.this.b()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.f16073a;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> a2 = FluentIterable.a(b.f16076a.a((b<TypeToken<?>>) TypeToken.this)).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
            this.f16073a = a2;
            return a2;
        }
    }

    protected TypeToken() {
        this.runtimeType = capture();
        Preconditions.b(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    private static a c(Type[] typeArr) {
        return new a(typeArr, false);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final boolean isSubtypeOf(Type type) {
        Preconditions.a(type);
        if (type instanceof WildcardType) {
            return a(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return a(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || a(((TypeVariable) this.runtimeType).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return of(type).b((GenericArrayType) this.runtimeType);
        }
        if (type instanceof Class) {
            return d((Class<?>) type);
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type);
        }
        return false;
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    private boolean a(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!d((Class<?>) rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < typeParameters.length; i++) {
            if (!resolveType(typeParameters[i]).b(actualTypeArguments[i])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || c(parameterizedType.getOwnerType());
    }

    private boolean c(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type a2 = it.next().a();
            if (a2 != null && of(a2).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean d(Class<?> cls) {
        Iterator it = b().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom((Class) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParameter, Class<X> cls) {
        return where(typeParameter, of((Class) cls));
    }

    protected TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = of((Class) cls).resolveType(capture).runtimeType;
        }
    }

    private static Type d(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    private Type c(Class<?> cls) {
        if ((this.runtimeType instanceof Class) && (cls.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return cls;
        }
        TypeToken genericType = toGenericType(cls);
        return new TypeResolver().a(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).b(genericType.runtimeType);
    }

    private boolean b(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return cls.isAssignableFrom(Object[].class);
            }
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        }
        return false;
    }

    private TypeToken(Type type) {
        Preconditions.a(type);
        this.runtimeType = type;
    }

    private boolean a(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private boolean b(Type type) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) type;
        return c(wildcardType.getUpperBounds()).b(this.runtimeType) && c(wildcardType.getLowerBounds()).a(this.runtimeType);
    }

    private static a a(Type[] typeArr) {
        return new a(typeArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> b() {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        new l(this, builder).a(this.runtimeType);
        return builder.a();
    }

    @Nullable
    private Type a() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    private TypeToken<? super T> b(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) of.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private TypeToken<? extends T> a(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> b(Class<? super T> cls) {
        f componentType = getComponentType();
        Preconditions.a(componentType, "%s isn't a super type of %s", cls, this);
        return (TypeToken<? super T>) of(d(((TypeToken) componentType).getSupertype(cls.getComponentType()).runtimeType));
    }

    private TypeToken<? extends T> a(Class<?> cls) {
        return (TypeToken<? extends T>) of(d(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }
}
